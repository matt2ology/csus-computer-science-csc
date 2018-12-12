#include "stats.h"
#define ADDR(var) &var
/********************************************************************
 *                        FUNCTION PROTOCALL 
 ********************************************************************/
/*
 * jumper_t jump_list[NCOMPETITORS] for in & out
 * stats_t *jump_stats for output 
 */
void get_stats(jumper_t jump_list[NCOMPETITORS], stats_t *jump_stats);

/********************************************************************
 *                       FUNCTION DEFINITION 
 ********************************************************************/
/* 
 * Will figure the best jump for each jumper, compute the all-over 
 * average of all the best jumps, find the winning jump, and each
 * jumper’s deviation from the winning jump
 */
void get_stats(jumper_t jump_list[NCOMPETITORS], stats_t *jump_stats)
{
    // Zero out the average_of_best.(HINT: use the -> notation)
    jump_stats->average_of_best = 0;
    // Zero out the winning_jump
    jump_stats->winning_jump = 0;
    // loop from r = zero to r < NCOMPETITORS, increment by one
    for (int r = 0; r < NCOMPETITORS; r++)
    {
        // Set the jumper's best_jump to the jumper's first jump
        jump_list[r].best_jump = jump_list[r].attempts[0];
        // Loop from c = one to c < N_TRIES increment by one
        for (int c = 0; c < N_ATTEMPTS; c++)
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
        // Loop from c = zero to c < N_TRIES increment by one
        for (size_t i = 0; i < count; i++)
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
        for (int r = 0; r < NCOMPETITORS; r++)
        {
            /*Figure the jumper's deviation from the winning_jump
        (deviation is all-over winning_jump minus each jumper's best jump)*/
            jump_list[r].deviation = jump_stats->winning_jump - jump_list[r].best_jump;

        } /* End of the second loop using “r” */
        return;
    }
