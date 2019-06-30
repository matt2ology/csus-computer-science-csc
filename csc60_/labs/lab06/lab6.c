/*------------------------------------*/
/*  Test program for lab6 worksheet  */
/*  Written by R. Biel for CSC60      */

#include <stdio.h>
#include <stdlib.h>
int partial_sum (int x[], int npts);  /* function prototype */

int main(void)
{
   int x[] = {5, 6, 4, -8, 3, 7};
   int *ptr_x = &x[0];
   int a[] = {-6, 3, 4, 1, 8, 20, 16, 7};
   int *ptr_a = &a[2];
   printf("\n\n");
   printf("int x[] = {5, 6, 4, -8, 3, 7};\n");
   printf("int *ptr_x = &x[0];\n");
   printf("int a[] = {-6, 3, 4, 1, 8, 20, 16, 7};\n");
   printf("int *ptr_a = &a[2];\n\n");
   printf("partial_sum(x[],npts)\n");
   printf("\tint k,sum = 0;");
   printf("\tfor(k = 0; k < npts; k++)\n");
   printf("\t\tsum += x[k];\n");

   printf("\n");
   printf("  #1.  %3i *ptr_x\n", *ptr_x);
   printf("  #2.  %3i *ptr_x + 3\n", *ptr_x + 3);
   printf("  #3.  %3i *ptr_x+3\n", *(ptr_x+3));
   printf("  #4.  %3i *ptr_x + *(ptr_x + 5)\n", *ptr_x + *(ptr_x + 5));
   printf("  #5.  %3i *(ptr_x + 2) - 1)\n\n", *(ptr_x + 2) - 1);
   printf("  #6.  %3i x[3] - *ptr_x\n", x[3] - *ptr_x);
   printf("  #7.  %3i *ptr_x + x[5] + *(ptr_x + 1) + x[2\n",\
                      *ptr_x + x[5] + *(ptr_x + 1) + x[2]);
   printf("  #8.  %3i *x\n", *x);
   printf("  #9.  %3i *x + *ptr_x\n", *x + *ptr_x);
   printf(" #10.  %3i x[2] - *ptr_x + 3\n\n", x[2] - *ptr_x + 3);

   printf(" #11.  %3i partial_sum(ptr_a, 2)\n", partial_sum(ptr_a, 2));
   printf(" #12.  %3i partial_sum(ptr_a + 1, 3)\n", partial_sum(ptr_a + 1, 3));
   printf(" #13.  %3i partial_sum(a, 8)\n", partial_sum(a, 8));
   printf(" #14.  %3i partial_sum(a, 4)\n", partial_sum(a, 4));
   printf(" #15.  %3i partial_sum(ptr_a, a[1])\n", partial_sum(ptr_a, a[1]));
   printf(" #16.  %3i partial_sum(&a[a], 2)\n\n", partial_sum(&a[3], 2));

   return EXIT_SUCCESS;
}
/*----------------------------------------------------------*/
int partial_sum (int x[], int npts)
{
   int k, sum = 0;
   /*  Compute partial sum.  */
   for (k = 0; k < npts; k++)
   {    
       sum += x[k];
   }
   return sum;
}
/*----------------------------------------------------------*/
