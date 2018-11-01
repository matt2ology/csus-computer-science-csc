/*  execvp.c
    Program to execute a command using an argument from argv */
#include <stdio.h>
int main (int argc, char *argv[])
{
    if (argc != 2) {  
       printf("Usage: input a command name with no option i.e. ls \n");
       return 0; 
    }
    printf("About to run: %s \n", argv[1]);
    char *cmd[] = {argv[1], 0 }; /* make sure place a 0 at the end of 
				    array of pointer cmd */
    execvp(cmd[0], cmd);
    return 0;
}
