/******************************************************************************
Programmer: Matthew D. Mendoza
Section 03
Lab #3 
-------------------------------------------------------------------------------
This program is to demonstrate student's ability to write several printf
statements to achieve the results desired by the professor.
There is no room for creativity in this assignment; for, reasons explained
in class.
******************************************************************************/
#include <stdlib.h> //Standard library
#include <stdio.h> 
/* The #include directive tells the compiler where to find information about
certain item that are used in your program. In this case stdio.h is the
standard C library */

int main(void)
{
	int age = 25;//No creativity comes from the forced use of this variable
	double average = 246.7531986;

	printf("\nMatthew Mendoza. Lab3.\n\n");
	printf("The dog ran quickly.\n\n");
	printf("Joe is %d years old.\n\n",age);
	printf("\"So many books, so little time.\"\n- Frank Zappa\n\n");
	printf("The average = %.1f\n\n",average);
	printf("The average = %.3f\n\n",average);
	printf("The average = %.2e\n\n",average);

	return EXIT_SUCCESS;
}
