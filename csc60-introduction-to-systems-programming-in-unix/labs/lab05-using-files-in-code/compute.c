#include "lab5.h"
#include <math.h>
void compute(double radius, double *area, double *cir)
{
    *area = calcArea(radius);
    *cir  = calcCircumference(radius);
}
double calcArea(double radius)
{
    return(M_PI*(pow(radius,2.0)));
}
double calcCircumference(double radius)
{
    return(2.0*M_PI*radius);
}
