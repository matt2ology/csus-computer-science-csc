/*****************************************************************************\
| Author: Matthew Mendoma 													  |
| CISP 401 - Fall 2017 - ONLINE												  |
| Assignment A2: yearlySalaryCalculator           							  |
| Last Edit Date: 09/02/2017 												  |
|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
|   This program takes an Employee’s monthly salary and projects their yearly |
| salary; then, give each Employee a 10% raise and display each Employee’s    |
| yearly salary again.														  |
| 																			  |
|   If the monthly salary is not positive, display the inputed salary and set |
| the salary to a $1,000 value. 											  |
| 																			  |
| // Employee.java                                                            |
\*****************************************************************************/
package yearlySalaryCalculator;

public class Employee{
		private String fstName = "";//Instance variable of String type set to first name.
		private String lstName = "";//Instance variable of String type set to last name.
		private double mthSalary = 0.0;//Instance variable of type double set to mthSalary.
		private double yearlySalary = 0.0;//Instance variable of type double set to yearlySalary.
		private double raise = 0.0;//Instance variable of type double set to raise.
		private double stimulusPackage = 0.0;//Instance variable of type double set to stimulusPackage.
		
		//Employee class constructor
		public Employee(String f, String l, double m) {
			setEmployeeData(f, l, m);
	    }

	    //Method to set the firstName in the object.
	    public void setFirstName(String f) {
	        fstName = f;//Store the firstName from what is placed into the argument.
	    }

	    //Method to set the lastName in object.
	    public void setLastName(String l) {
	        lstName = l;//Store the lastName from what is placed into the argument.
		}
		
		public void setyearlySalary(double m) {
			/*********************************************************************\
	        | If mthSalary is less than 0, then set mthSalary to 1000 value;      |
	        | otherwise, use the value placed in the argument.                    |
	        \*********************************************************************/
			//Store the mthSalary from what is placed into the argument.
			mthSalary = m;
	        stimulusPackage = ((m < 0) ? 1000.00 : m);
			yearlySalary = (stimulusPackage*12.00);
		}

		//Method to set the employee's data in the object.
		public void setEmployeeData(String x, String l, double m){
			setFirstName(x);//Calls setFirstName function and passes argument x into it.
			setLastName(l);//Calls setLastName function and passes argument l into it.
			setyearlySalary(m);//Calls setMonthlySalary function and passes argument m into it.
			setRaise(m);//Calls setMonthlySalary function and passes argument m into it.
		}

		public void setRaise(double r){
			double temp;
			temp = ((r < 0) ? 1000.00 : r);
			raise = (getyearlySalary())+(getyearlySalary() * 0.10);
		}

	    //Method to retrieve the firstName from the object.
	    public String getFirstName() {
	        return fstName;//Return value of firstName to caller.
		}
		
	    //Method to retrieve the lastName from the object.
	    public String getLastName() {
	        return lstName;//Return value of lastName to caller.
		}

	    //Method to retrieve the mthSalary from the object.
	    public double getMonthlySalary() {
	        return mthSalary;//Return value of mthSalary to caller.
		}
		
	    public double getyearlySalary() {
	        return yearlySalary;//Return value of lastName to caller.
		}

		public double getRaise() {
			return raise;
		}

	    public void displayWarning() {
	        /*****************************************************************\
	        | If mthSalary is less than 0, warning will be displayed to user. |
	        \*****************************************************************/
			if(getMonthlySalary() < 0){
				System.out.format("***The inputed salary: $%.2f for %s %s is less than 0. %n" +
					"Salary set to $1000.00.***%n%n", getMonthlySalary(), getFirstName(), getLastName());
			}
		}

		public void display() {
			System.out.format("%s %s: Yearly Salary: $%.2f%n",
								getFirstName(), getLastName(), getyearlySalary());
		}

		public void displayRaise(){
			System.out.format("%s %s: Yearly Salary: $%.2f %n", getFirstName(), getLastName(), getRaise());
		}

	}//End class Employee
	