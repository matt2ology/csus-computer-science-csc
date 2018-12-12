#include <stdio.h>
#include <stdlib.h>

int main (void)
{
    double r1, r2, r3, r_combo;
    FILE * input_file;		// Declare a pointer variable
    FILE * output_file;		// for each file.    
	input_file = fopen ("resist.dat", "r");	
    if(input_file == NULL)
    {
         printf("Error on opening the input file \n");       
         exit (EXIT_FAILURE);   // ( ) required since exit is a function
    } 

	output_file = fopen ("resist.txt", "w");
    if(output_file == NULL)
    {
         printf("Error on opening the output file \n");
         exit (EXIT_FAILURE);  
    }
	
    /* Now that the files are open, we can use them */
     fprintf(output_file, "\nRuthann Biel.  Resistance Program.  \n\n");
    
     while ((fscanf(input_file, "%lf%lf%lf", &r1, &r2, &r3)) == 3)
     {
         r_combo = 1.0 / (1.0/r1 + 1.0/r2 + 1.0/r3);
         fprintf(output_file, "Three resistors are:  %f  %f  %f \n", r1, r2, r3);
         fprintf(output_file, "Combined Parallel Resistance:  %f  \n\n",
                  r_combo);
     }    
     fclose(input_file);
     fclose(output_file);

     return EXIT_SUCCESS;
 }
/*----------------------------------------*/
