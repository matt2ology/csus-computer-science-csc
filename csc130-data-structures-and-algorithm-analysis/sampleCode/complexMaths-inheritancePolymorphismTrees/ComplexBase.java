
public abstract class ComplexBase{
	/****************************************
	*imaginaryUnit "i" is square root of -1.*
	****************************************/
	public static final double imaginaryUnit = Math.sqrt(-1);
	/**************************************************************************
	 * Four private double data members:                                      *
	 * 	- real1, imaginary1, real2 and imaginary2.							  *
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*
	 *The real stores the real part of a complex number and the imaginary	  *
	 *	stores the imaginary part of a complex number.				  		  *
	 *************************************************************************/
	private double real1, imaginary1, real2, imaginary2;
	/**************************************************************************
	 *The first ComplexBase function                                          *
	 *	a. Does not take any data (or call no argument constructor)			  *
	 *	b. It initializes 0s to the private data members.                     *
	 *************************************************************************/
	public ComplexBase(){
		real1 = 0;
		imaginary1 = 0;
		real2 = 0;
		imaginary2 = 0;
	}//End of ComplexBase()
	/**************************************************************************
	 *The second ComplexBase function                                         *
	 *	a. Takes four double numbers. (or call four-argument constructor)     *
	 *	b. It assigns the four numbers to the private data members.			  *
	 *************************************************************************/
	public ComplexBase(double r1, double i1, double r2, double i2){
		real1 = r1;
		imaginary1 = i1;
		real2 = r2;
		imaginary2 = i2;
	}//End of ComplexBase(double q, double w, double e, double r)
	/**************************************************************************
	 *The getFirstReal function                                               *
	 *	a. Returns one double number but does not take any data.              *
	 *	b. It returns the real1.                                              *
	 *************************************************************************/
	public double getFirstReal(){
		return real1;
	}//End of getFirstReal()
	/**************************************************************************
	 *The getFirstImaginary function                                          *
	 *	a. Returns one double number but does not take any data.              *
	 *	b. It returns the imaginary1.                                         *
	 *************************************************************************/
	public double getFirstImaginary(){
		return imaginary1;		
	}//End of getFirstImaginary()
	/**************************************************************************
	 *The getSecondReal function                                              *
	 *	a. Returns one double number but does not take any data.              *
	 *	b. It returns the real2.                                              *
	 *************************************************************************/
	public double getSecondReal(){
		return real2;	
	}//End of getSecondReal()
	/**************************************************************************
	 *The getSecondImaginary function                                         *
	 *	a. Returns one double number but does not take any data.              *
	 *	b. It returns the imaginary2.                                         *
	 *************************************************************************/
	public double getSecondImaginary(){
		return imaginary2;		
	}//End of getSecondImaginary()
	//public abstract double evaluate();
}//End of public class ComplexBase