/* Authors: Matthew Mendoza, Tanner Fleming
 *
 * This is lab10.c the csc60mshell
 * This program serves as a skeleton for doing labs 9, 10, 11.
 * Student is required to use this program to build a mini shell
 * using the specification as documented in direction.
 * Date: Fall 2018
 */

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <sys/stat.h>
#include <unistd.h>
#include <fcntl.h>
#include <errno.h>

#define MAXLINE 80 //80 col rule!
#define MAXARGS 20
#define MAX_PATH_LENGTH 50
#define TRUE 1

/* function prototypes */
int parseline(char *cmdline, char **argv);

//The two function prototypes below will be needed in lab10.
//Leave them here to be used later.
void process_input(int argc, char **argv);
void handle_redir(int count, char *argv[]);

/* ----------------------------------------------------------------- */
/*                  The main program starts here                     */
/* ----------------------------------------------------------------- */
int main(void)
{
    char cmdline[MAXLINE];
    char *argv[MAXARGS];
    int argc;
    int status;
    pid_t pid;

    /* Loop forever to wait and process commands */
    while (TRUE)
    {
        /* Print your shell name: csc60mshell (m for mini shell) */
        printf("csc60mshell: ");

        /* Read the command line */
        fgets(cmdline, MAXLINE, stdin);

        /* Call parseline to build argc/argv */
        argc = parseline(cmdline, argv);

        for (int c = 0; c < argc; c++)
        {
            printf("Argv %i = %s \n", c, argv[c]);
        }

        /* If user hits enter key without a command, continue to loop */
        /* again at the beginning */
        /*  
        Hint: if argc is zero, no command declared
        Hint: look up for the keyword "continue" in C */
        if (argc == 0)
        {
            continue;
        }
        /* Handle build-in command: exit, pwd, or cd  */
        else if (strncmp(argv[0], "exit", 30) == 0) // Handles exit Command
        {
            exit(EXIT_SUCCESS);
        }
        else if (strncmp(argv[0], "pwd", 30) == 0) // Handles pwd Command
        {
            char cwd[MAX_PATH_LENGTH];
            getcwd(cwd, MAX_PATH_LENGTH);
            printf("%s\n", cwd);
            continue;
        }
        else if (strncmp(argv[0], "cd", 30) == 0) // Handles cd Command
        {
            char *dir;
            /* Set destination to home directory if no argument provided after cd */
            if (argc == 1)
            {
                dir = getenv("HOME");
            }
            else // Enter folder
            {
                dir = argv[1];
            }
            if (chdir(dir) < 0) // Check for error cd argument command
            {
                perror("Error changing directory");
            }
            continue;
        }
        /* Else, fork off a process */
        else
        {
            pid = fork();
            switch (pid)
            {
            case -1:
                perror("Shell Program fork error");
                exit(EXIT_FAILURE);
            case 0:
                /* I am child process. I will execute the command, */
                /* and call: execvp */
                process_input(argc, argv);
                break;
            default:
                /* I am parent process */
                if (wait(&status) == -1)
                    perror("Parent Process error");
                else
                    printf("Child returned status: %d\n", status);
                break;
            } /* end of the switch */
        }     /* end of the if-else-if */
    }         /* end of the while */
} /* end of main */

/* ----------------------------------------------------------------- */
/*                  parseline                                        */
/* ----------------------------------------------------------------- */
/* parse input line into argc/argv format */

int parseline(char *cmdline, char **argv)
{
    int count = 0;
    char *separator = " \n\t"; /* Includes space, Enter, Tab */

    /* strtok searches for the characters listed in separator */
    argv[count] = strtok(cmdline, separator);

    while ((argv[count] != NULL) && (count + 1 < MAXARGS))
        argv[++count] = strtok((char *)0, separator);

    return count; //This becomes "argc" back in main.
}
/* ----------------------------------------------------------------- */
/*                  process_input                                    */
/* ----------------------------------------------------------------- */
void process_input(int argc, char **argv)
{
    /* Step 1: Call handle_redir to deal with operators:            */
    /* < , or  >, or both                                           */
    handle_redir(argc, argv);
    /* Step 2: perform system call execvp to execute command        */
    /* Hint: Please be sure to review execvp.c sample program       */
    if (execvp(argv[0], argv) == -1)
    {
        perror("Shell Program fork error");
        exit(EXIT_FAILURE);
    }
}
/* ----------------------------------------------------------------- */
/*                  handle_redir                                     */
/* ----------------------------------------------------------------- */
void handle_redir(int count, char *argv[])
{
    /* Declare and set redirect index(s)*/
    int out_redir = 0;
    int in_redir = 0;
    /* Loop to parse the string to find redirect characters */
    for (int c = 0; c < count; c++)
    {
        // If a redirect out character is detected
        if (strcmp(argv[c], ">") == 0)
        {
            // Error handle multiple redirect characters.
            if (out_redir != 0)
            {
                perror("Cannot output more than one file.\n");
                _exit(EXIT_FAILURE);
            }
            // Error handle empty command
            else if (c == 0)
            {
                perror("No command entered. \n");
                _exit(EXIT_FAILURE);
            }
            // Set the out_redir index to counter.
            out_redir = c;
        }
        // If a redirect in character is detected
        else if (strcmp(argv[c], "<") == 0)
        {
            // Error handle multiple redirect characters
            if (in_redir != 0)
            {
                perror("Cannot input more than one file.\n");
                _exit(EXIT_FAILURE);
            }
            // Error handle empty command
            else if (c == 0)
            {
                perror("No command entered.\n");
                _exit(EXIT_FAILURE);
            }
            // Set the in_redir index to the counter
            in_redir = c;
        }
        // If a redirect out is taking place
        if (out_redir != 0)
        {
            /*
                System call to open the input file
                Flags:  write, create, truncate
                Bits:   user-read; user-write
            */
            int fileDescriptor = open(argv[out_redir + 1],
                                      O_RDWR | O_CREAT | O_TRUNC, S_IRUSR | S_IWUSR);
            // Error handle system call to open redirect out
            if (fileDescriptor < 0)
            {
                perror("Error on open for output.\n");
                _exit(EXIT_FAILURE);
            }
            /*
                Call dup2 to switch standard-out 
                to the value of the file descriptor.
            */
            dup2(fileDescriptor, 1);
            // Close output file with error handling
            if (close(fileDescriptor) == -1)
            {
                perror("Error on close output file.\n");
                _exit(EXIT_FAILURE);
            }
            // Set argument
            argv[out_redir] = NULL;
        }
        // If a redirect in is taking place
        if (in_redir != 0)
        {
            // Error handle for empty input file.
            if (argv[in_redir + 1] == NULL)
            {
                perror("Error, no such file exists.\n");
                _exit(EXIT_FAILURE);
            }
            int fileDescriptor = open(argv[in_redir + 1], O_RDWR);
            // Error handle system call to open input file
            if (fileDescriptor < 0)
            {
                perror("Error on open for read.\n");
                _exit(EXIT_FAILURE);
            }
            // Call dup2 to switch standard-in to the value of the file descriptor.
            dup2(fileDescriptor, 0);
            // Close input file with error handling
            if (close(fileDescriptor) == -1)
            {
                perror("Error on close for read.\n");
                exit(EXIT_FAILURE);
            }
            // Place null value in argument index for system call.
            argv[in_redir] = NULL;
        }
    }
}

/* ----------------------------------------------------------------- */
