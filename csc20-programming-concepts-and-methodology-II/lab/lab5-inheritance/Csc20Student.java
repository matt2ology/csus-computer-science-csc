/*=============================================================================
AUTHOR: Matthew Mendoza
CSc 020: Programming Concepts and Methodology II - Spring 2018
LAB ASSIGNMENT 5: Class Inheritance
LAST EDIT DATE: 02/22/2018
Csc20Student.java
=============================================================================*/
// This class defines Csc20Student's profile with extension of CsusStudent
// Csc20 lab 5 assignment
public class Csc20Student extends CsusStudent {

    // attributes
    private boolean preComputerMajor;
    private int numberOfComputerClassUnits;

    // constructor   
    public Csc20Student(String name, int id, String address, String phone, 
            String email, boolean preCsMajor, int csUnits) {
        super(name, id, address, phone, email);
        setPreComputerMajor(preCsMajor);
        setNumberofCsUnits(csUnits);
    }

    // getPreComputerMajor 
    public boolean getPreComputerMajor() {
        return preComputerMajor;
    }

    // setPreComputerMajor
    public void setPreComputerMajor(boolean value) {
        preComputerMajor = value;
    }

    // getNumberofCsUnits
    public int getNumberofCsUnits() {
        return numberOfComputerClassUnits;
    }

    // setNumberofCsUnits
    public void setNumberofCsUnits(int units) {
        numberOfComputerClassUnits = units;
    }

    // Override toSTring method
    /** Return a string value by combining all values from class's attributes*/
    public String toString() {
        return String.format(
            super.toString() +
            "Is a Pre-Computer Science Major: %b\n" + 
            "Total number of Computer Science units: %d\n",
            getPreComputerMajor(), getNumberofCsUnits());
    }
}
