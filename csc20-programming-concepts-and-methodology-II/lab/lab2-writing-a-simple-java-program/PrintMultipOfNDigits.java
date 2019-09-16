
/*****************************************************************************\ 
|AUTHOR: Matthew Mendoza                                                     
|CSc 020: Programming Concepts and Methodology II - Spring 2018              
|LAB ASSIGNMENT 2: Long Multiplication                                       
|LAST EDIT DATE: 02/07/2018                                                  
|PrintMultipOfNDigits.java                                                   
*******************************************************************************
THIS PROGRAM PROMTS AN USER FOR TWO N-DIGIT INTEGERS, AND PRINTS THE SHIFTED
MULTIPLICAND, WITH THEIR FINAL PRODUCT.
*****************************************************************************/
impor.util.Scanner;
impor.util.ArrayList;

public class PrintMultipOfNDigits {
    /**************************************************************************
     * DECLARE "READ" AS AN OBJECT OF SCANNER CLASS "SYSTEM.IN" TELL THIS      * WILL BE SYSTEM INPUT. I.E. INPUT WILL BE GIVEN TO THE SYSTEM.  
     **************************************************************************/
    Scanner read = new Scanner(System.in);
    /**************************************************************************
     * DECLARE AN ARRAYLIST TO STORE AND PRINT OUT THE RESULTS OF THE 
     * SHIFTED MULTIPLICAND.  
     **************************************************************************/
    ArrayList<Double> shiftedMultiplicand = new ArrayList<Double>();
    private double multiplicand = 0.0, multiplier = 0.0, product = 0.0;
    private final double BASE_TEN = 10.0;
    private int input = 0, selection = 0;
    private final String PADDING = "=======================================\n";
    private final String UNDERLINE = "-------------\n";
    private final String SPACEING = "";

    /**************************************************************************
     * CONSTRUCTOR TO CALL ALL THE FUNCTIONS INSTEAD OF BUILDING IT IN MAIN 
     **************************************************************************/
    public PrintMultipOfNDigits() {
        header();
        setMultiplicand();
        setMultiplier();
        calcShiftedMultiplicand(getMultiplicand(), getMultiplier());
        showResults();
    }// END OF PrintMultipOfNDigits CONSTRUCTOR

    /**************************************************************************
     * PROMPTS THE USER WITH THE FOLLOWING MESSAGE  
     **************************************************************************/
    public void header() {
        System.out.printf(
                "%s%s" + "%s|PLEASE ENTER TWO INTEGERS WITH EITHER|\n" + "%s|THREE, FOUR, OR FIVE DIGITS         \n"
                        + "%s%s",
                /***********
                 Formatting
                 ***********/
                SPACEING, PADDING, SPACEING, SPACEING, SPACEING, PADDING);
    }// END OF header METHOD

    public void setInput() {
        System.out.printf("Enter number: ");
        input = read.nextInt();
    }// END OF setInput METHOD

    public void setInput(int inputPar) {
        input = inputPar;
    }// END OF setInput METHOD

    public int getInput() {
        return input;
    }// END OF getInput METHOD

    /**************************************************************************
     * CHECKS IF THE USER'S INPUT ARE 3, 4, OR 5 DIGITS AND ALLOWES THE USER TO 
     * ENTER A NUMBER THAT IS A VALID INPUT  
     **************************************************************************/
    public void checkInput(int inputPar) {
        while ((inputPar < 100)| (inputPar > 99999)) {
            System.out.printf("\t**%d Is not a within input range**\n" + "\tEnter between 99 and 100000: ", inputPar);
            inputPar = read.nextInt();
        }
        setInput(inputPar);
    }// END OF checkInput METHOD

    public void setMultiplicand() {
        setInput();
        checkInput(getInput());
        multiplicand = (double) getInput();
    }// END OF setMultiplicand METHOD

    public double getMultiplicand() {
        return multiplicand;
    }// END OF getMultiplicand METHOD

    public void setMultiplier() {
        setInput();
        checkInput(getInput());
        multiplier = (double) getInput();
    }// END OF setMultiplier METHOD

    public double getMultiplier() {
        return multiplier;
    }// END OF getMultiplier METHOD

    /**************************************************************************
     * DETERMINES IF THE MULTIPLIER VALUE IS IN THE HUNDREDS  
     **************************************************************************/
    private void isHundreds() {
        if ((getMultiplier() >= 100) && (getMultiplier() <= 999)) {
            selection = 3;
        }
    }// END OF isHundreds METHOD

    /**************************************************************************
     * DETERMINES IF THE MULTIPLIER VALUE IS IN THE THOUSANDS  
     **************************************************************************/
    private void isThousands() {
        if ((getMultiplier() >= 1000) && (getMultiplier() <= 9999)) {
            selection = 4;
        }
    }// END OF isThousands METHOD

    /**************************************************************************
     * DETERMINES IF THE MULTIPLIER VALUE IS IN THE TEN-THOUSANDS  
     **************************************************************************/
    private void isTenThousands() {
        if ((getMultiplier() >= 10000) && (getMultiplier() <= 99999)) {
            selection = 5;
        }
    }// END OF isTenThousands METHOD

    private int getSelection() {
        return selection;
    }// END OF getSelection METHOD

    /**************************************************************************
     * TAKES IN BOTH VALUES OF MULTIPLICAND AND THE MULTIPLIER AND ISOLATE EACH
     * PLACE HOLDER VALUE OF THE MULTIPLIER AND MULTIPLIES THOSE VALUES BY THE
     * MULTIPLICAND  
     **************************************************************************/
    public void calcShiftedMultiplicand(double multiplicandPar, double multiplierPar) {
        double step1 = 0.0, step2 = 0.0, result = 0.0;
        isHundreds();
        isThousands();
        isTenThousands();
        for (int counter = 0; counter < getSelection(); counter++) {
            step1 = multiplierPar % Math.pow(BASE_TEN, (double) counter + 1.0);
            step2 = step1 % Math.pow(BASE_TEN, (double) counter);
            result = (step1 - step2);
            step1 = result / Math.pow(BASE_TEN, (double) counter);
            step2 = multiplicandPar * step1;
            result = step2 * Math.pow(BASE_TEN, (double) counter);
            setShiftedMultiplicand(result);
            setProduct(result);
        } // END OF for LOOP
    }// END OF calcShiftedMultiplicand METHOD

    /**************************************************************************
     * TAKES IN THE RESULT AND ADDS THAT VALUE TO THE NEXT ELEMENT OF THE ARRAY
     **************************************************************************/
    public void setShiftedMultiplicand(double resultPar) {
        shiftedMultiplicand.add(resultPar);
    }// END OF setShiftedMultiplicand METHOD

    /**************************************************************************
     * ITERATES THROUGH THE ARRAY AND RETURNS THE VALUE IN THE DEFINED FORMAT  
     **************************************************************************/
    public void showShiftedMultiplicand() {
        for (int counter = 0; counter < getSelection(); counter++) {
            System.out.printf("%21.0f\n", shiftedMultiplicand.get(counter));
        } // END OF for LOOP
    }// END OF showShiftedMultiplicand METHOD

    /**************************************************************************
     * THE RESULTS ARE ACCUMULATED AND THEN THE FINAL VALUE IS THE PRODUCT OF
     * THE MULTIPLICAND MULTIPLIED BY THE MULTIPLIER  
     **************************************************************************/
    public void setProduct(double resultPar) {
        product += resultPar;
    }// END OF setProduct METHOD

    public double getProduct() {
        return product;
    }// END OF getProduct METHOD
    /**************************************************************************
     * DISPLAYS THE USER'S INPUTS AND RESULTING VALUES IN THE FOLLOWING FORMAT
     **************************************************************************/
    public void showResults() {
        System.out.printf("%s" + /* ========================= */
                "%10sLONG MULTIPLICATION\n" + /* LONG MULTIPLICATION */
                "%s" + /* ========================= */
                "%16s%5.0f\n" + /* (SPACEING) + MULTIPLICAND */
                "%14sx%6.0f\n" + /* (SPACEING) + x MULTIPLIER */
                "%9s%s", /* (SPACEING) + (UNDERLINE) */
                /***********
                 *Formatting
                 ***********/
                PADDING, SPACEING, /* LONGDIVISION */
                PADDING, SPACEING, getMultiplicand(), SPACEING, getMultiplier(), SPACEING, UNDERLINE);
        showShiftedMultiplicand();
        System.out.printf("%9s%s" + /* (SPACEING) + (UNDERLINE) */
                "%6s%15.0f\n", /* (SPACEING) + PRODUCT */
                /***********
                 *Formatting
                 ***********/
                SPACEING, UNDERLINE, SPACEING, getProduct());
    }// END OF showResults METHOD
}// END OF PrintMultipOfNDigits CLASS
