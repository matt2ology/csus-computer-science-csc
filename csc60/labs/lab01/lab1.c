/******************************************************************************
Programmer: Matthew D. Mendoza
Section 03
Lab #1
-------------------------------------------------------------------------------
Brief description of program here, including the new ideas
that are in this code

Throughout the code provide comments to why
the codes are there for all inputs, outputs, and operations.
******************************************************************************/
#include <stdlib.h> //Standard library
#include <stdio.h>
/* The #include directive tells the compiler where to find information about
certain item that are used in your program. In this case stdio.h is the 
standard C library */

int main(void)
{
    printf("\n\nLab1\n\n");
    printf("Hello, world!\n");
    printf("Hi, I'm Matt\n\n");
      
    printf("\"Many people have said that the worst feature of C is that\n");
    printf("switches don't break automatically before each case lable.\n");
    printf("This code forms some sort of argument in that debate, but I'm\n");
    printf("not sure whether it's for or against.\"\n");
    printf("\t\t\t\t\t- Tom Duff.\n\n");
	
    printf("\"You cannot teach beginners top-down programming,\n");
    printf("because they don't know which end is up.\"\n");
    printf("\t\t\t\t\t- C A R Hoare.\n\n");

    printf("\"A common fallacy is to assume authors of in comprehensible\n");
    printf("code will somehow be able to express themselves lucidly and \n");
    printf("clearly in comments.\"\n");
    printf("\t\t\t\t\t- Kevlin Henney.\n\n");

    // On some Unix/Linux systems fflush() does not work as in windows
    // substitute the following: 
    //while(getchar() != '\n'); // Pause the screen display

    return EXIT_SUCCESS; // Terminates the program
}
