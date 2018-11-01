/**************************************************************************
Programmer: Matthew D. Mendoza
Section 03
Lab #4
---------------------------------------------------------------------------
This program computes the perimeter and the area of a polygon taking
inputs from an input file and displays the results via an output file.
**************************************************************************/
#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#define FILENAME    "./lab4.dat"
//#define FILENAME  "./lab4sample.dat" //For testing
#define HEADERLINE0 "\nMatthew Mendoza. Lab4.\n\n"
#define HEADERLINE1 "            Number      Perimeter      Area Of  \n"
#define HEADERLINE2 " Radius    Of Sides    Of Polygon      Polygon  \n"
#define HEADERLINE3 "--------   --------   ------------   -----------\n"
#define REPORTLINE  "%7.2f%4s%7.2f%6s%9.4f%5s%9.4f\n"
double calculatePerimeter(double radius, double nSides);
double calculateArea(double radius, double nSides);
int main(void)
{
    FILE *input_file;
    FILE *output_file;
    double perimeter = 0.0, area = 0.0, radius = 0.0, nSides = 0.0,
           halfOfnSides = 0.0, radiusSqrd = 0.0, radian = 0.0;

    input_file = fopen(FILENAME,"r");
    if(input_file == NULL)
    {
        printf("ERROR ON OPENING INPUTFILE\n");
        exit (EXIT_FAILURE);
    }
	
    output_file = fopen("./lab4.txt", "w");
    if(output_file == NULL)
    {
        printf("ERROR ON OPENING output_file\n");	
        exit (EXIT_FAILURE);
    }
    /* Now that the files are open, we can use them */
    fprintf(output_file,HEADERLINE0);
    fprintf(output_file,HEADERLINE1);
    fprintf(output_file,HEADERLINE2);
    fprintf(output_file,HEADERLINE3);

    while((fscanf(input_file, "%lf%lf", &radius, &nSides)) == 2)
    {
        perimeter = calculatePerimeter(radius,nSides);
        area = calculateArea(radius,nSides);
        fprintf(output_file,REPORTLINE,radius,"",nSides,"",perimeter,"",area);
    }
    fclose(input_file);
    fclose(output_file);   
    return EXIT_SUCCESS;
}
double calculatePerimeter(double radius, double nSides)
{    
    return ((2.0*nSides*radius)*(sin(M_PI/nSides)));   
}
double calculateArea(double radius, double nSides)
{
    double halfOfnSides = 0.0, radiusSqrd = 0.0, radian = 0.0;
    halfOfnSides = 0.5*nSides;
    radiusSqrd = pow(radius,2.0);
    radian = (2.0*M_PI)/nSides;
    return ((halfOfnSides*radiusSqrd)*(sin(radian)));
}
