/*  Matthew Mendoza                         */
/*  Lab 7 - Olympic long jump program      */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define NCOMPETITORS 4
#define N_ATTEMPTS 6

//#define OUT_FILENAME "lab7sample.out"
#define OUT_FILENAME "lab7.out"

//#define IN_FILENAME "lab7sample.dat"
#define IN_FILENAME "lab7.dat"

/* Put your two structs here */
typedef struct stats_t
{
    double average_of_best, winning_jump;
} stats_t;
typedef char STR16[16 + 1];
typedef struct jumper_t
{
    STR16 userName;
    //A double array of tires that is N_ATTEMPTS in lenth
    double attempts[N_ATTEMPTS];
    double best_jump, deviation;
} jumper_t;



/* FUNCTION PROTOTYPES */
/* get_data is a function to get and read data */
void get_data(char *filename,                    /* input  */
              jumper_t jump_list[NCOMPETITORS]); /* output */

/* open_out_file is a function to open the output file */
FILE *open_out_file(void);

/* get_stats is a function to do figure the best jump for each     
jumper, compute the all-over average of the best jumps, and find 
the longest jump  on the track and each jumper's deviation 
from that winning long jump                                     */
void get_stats(jumper_t jump_list[NCOMPETITORS], /* in & out */
               stats_t *jump_stats);             /* output   */

/*  print_all is a function to print things out.
    all of its arguments are input  */
void print_all(FILE *out_file,
               jumper_t jump_list[NCOMPETITORS],
               stats_t *jump_stats);

/*-----------------------------------------------------------*/
int main(void)
{
    jumper_t jump_list[NCOMPETITORS];
    stats_t jump_stats = {0.0, 0.0};

    FILE *out_file; /* file pointer for the output file  */

    out_file = open_out_file();

    get_data(IN_FILENAME, jump_list);

    get_stats(jump_list, &jump_stats);

    print_all(out_file, jump_list, &jump_stats);

    return EXIT_SUCCESS;
}
/*----------------------------------------------------------*/
/* This function will open the output file and return the   */
/* file pointer name to the main program.                   */

FILE *open_out_file(void)
{
    FILE *outfile;

    outfile = fopen(OUT_FILENAME, "w");
    if (outfile == NULL)
    {
        printf("Error on fopen of %s \n", OUT_FILENAME);
        exit(EXIT_FAILURE);
    }
    fprintf(outfile, "\nMatthew Mendoza, Lab 7 output. \n");

    return outfile;
}

/*-----------------------------------------------------------*/
/* This function will open and read data into an array.      */
/* It will return the value of the real length of the array. */

void get_data(char *filename,                   /* input  */
              jumper_t jump_list[NCOMPETITORS]) /* output */
{
    int n, c;
    FILE *in_file;

    /* Open the data file and read in the array */
    in_file = fopen(filename, "r");
    if (in_file == NULL)
    {
        printf("Error on fopen of %s \n", filename);
        exit(EXIT_FAILURE);
    }

    /* Read the competitor's names first. */

    for (n = 0; n < NCOMPETITORS; n++) /* "n" for names of jumpers */
    {
        /* "fgets" gets a string including the new line attached */
        fgets(jump_list[n].userName, 15, in_file);

        /* strings require that the last character is NULL */
        jump_list[n].userName[15] = 0;

        /* This code removes the attached new line 
         It will find the new line embedded in the name which it 
	   then sets to NULL.  */

        char *new_line_position = strchr(jump_list[n].userName, '\n');
        if (new_line_position != NULL)
            *new_line_position = 0;
    }

    /* Read the sets of tries/ */
    for (c = 0; c < N_ATTEMPTS; c++)
        for (n = 0; n < NCOMPETITORS; n++)
            fscanf(in_file, "%lf", &jump_list[n].attempts[c]);

    fclose(in_file);
    return;
}

/*----------------------------------------------------------------*/
/* get_stats is a function to do figure the best jump for each     */
/* jumper, compute the all-over average of the best jumps, and     */
/* find the longest jump  on the track and each jumper's deviation */
/* from the winning jump                                           */

void get_stats(jumper_t jump_list[NCOMPETITORS], /* in & out */
               stats_t *jump_stats)              /* output   */
{
    int c, r, i;
    // Zero out the average_of_best.(HINT: use the -> notation)
    jump_stats->average_of_best = 0;
    // Zero out the winning_jump
    jump_stats->winning_jump = 0;
    // loop from r = zero to r < NCOMPETITORS, increment by one
    for (r = 0; r < NCOMPETITORS; r++)
    {
        // Set the jumper's best_jump to the jumper's first jump
        jump_list[r].best_jump = jump_list[r].attempts[0];
        // Loop from c = one to c < N_ATTEMPTS increment by one
        for (c = 0; c < N_ATTEMPTS; c++)
        {
            // If the next jump TRY > the contents of the best jump column
            if (jump_list[r].best_jump < jump_list[r].attempts[c])
            {
                //Set the best column to this better jump try
                jump_list[r].best_jump = jump_list[r].attempts[c];
            }
        } /* end of the loop using “c” */
        // Add the jumper's best jump into the running total average_of_best
        jump_stats->average_of_best += jump_list[r].best_jump;
        // Loop from c = zero to c < N_ATTEMPTS increment by one
        for (i = 0; i < N_ATTEMPTS; i++)
        {
            // Figure the winning - best jump of all the jumps(use an IF)
            if (jump_list[r].best_jump > jump_stats->winning_jump)
            {
                jump_stats->winning_jump = jump_list[r].best_jump;
            } /* End of the second loop using “c” */
        }     /* End of the loop using “r” */
        // Compute the average of the best jumps
        jump_stats->average_of_best = jump_stats->average_of_best / NCOMPETITORS;
        // Loop from r = zero to < NCOMPETITORS increment by one
        for (r = 0; r < NCOMPETITORS; r++)
        {
            /*Figure the jumper's deviation from the winning_jump
        (deviation is all-over winning_jump minus each jumper's best jump)*/
            jump_list[r].deviation = jump_stats->winning_jump - jump_list[r].best_jump;

        } /* End of the second loop using “r” */
    }
    return;
}

    /*--------------------------------------------------------*/
    /*  print_all is a function to print things out.
	all of its arguments are input  */

void print_all(FILE *out_file,
                   jumper_t jump_list[NCOMPETITORS],
                   stats_t *jump_stats)
{
    int r, c;

    fprintf(out_file, "\nTrack Results");

    fprintf(out_file, "\n\nName               Try 1   Try 2   Try 3   Try 4   Try 5   "
                      "Try 6   Best Jump   Deviation");
    fprintf(out_file, "\n----------------   -----   -----   -----   -----   -----   "
                      "-----   ---------   ---------\n");

    for (r = 0; r < NCOMPETITORS; r++)
    {
        fprintf(out_file, "%-16s  ", jump_list[r].userName);
        for (c = 0; c < N_ATTEMPTS; c++)
        {
            fprintf(out_file, "%6.2f  ", jump_list[r].attempts[c]);
        }

        fprintf(out_file, "  %6.2f   ", jump_list[r].best_jump);
        fprintf(out_file, "  %6.2f   \n", jump_list[r].deviation);
    }

    fprintf(out_file, "\n\nBest Jump Average  = %6.2f meters ", jump_stats->average_of_best);
    fprintf(out_file, "\n\nWinning Jump       = %6.2f meters\n\n", jump_stats->winning_jump);
    return;
}