package com.example.subhunterrefactored;
/**         "Thou shalt not cross 80 columns in thy file”
 * Changed the sub' position name convention; for, the previous
 * "subHorizontalPosition" and "subVerticalPosition" takes a bit long to
 * spot the subtle difference.  The words have similiar shapes.
 **/
public class Submarine extends UnderwaterVehicle {
    private int subHorizontalPosition;
    private int subVerticalPosition;
    private boolean isHit;
    public Submarine(){

    }
    int getSubHorizontalPosition(){
        return subHorizontalPosition;
    }
    int setSubHorizontalPosition(int gridHorizontalXPosition){
        subHorizontalPosition = gridHorizontalXPosition;
    }
    int getSubVerticalPosition(){

    }
    int setSubVerticalPosition(int gridVerticalPositionYPosition){
        subVerticalPosition = gridVerticalPositionYPosition;
    }
    boolean subIsHit(){
        isHit = true;
    }
    
}