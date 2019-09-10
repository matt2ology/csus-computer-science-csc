package com.example.subhunterrefactored;
/**         "Thou shalt not cross 80 columns in thy file”
 * Changed the sub' position name convention; for, the previous
 * "subHorizontalPosition" and "subVerticalPosition" takes a bit long to
 * spot the subtle difference.  The words have similiar shapes.
 **/
public class Submarine extends UnderwaterVehicle {
    private int sub_Xposition = 0;
    private int sub_Yposition = 0;
    private boolean sub_isHit = false;
    public Submarine(int gridLatitude,int gridLongitude,boolean isHit){
        sub_Xposition = gridLatitude;
        sub_Yposition = gridLongitude;
        sub_isHit = isHit;
    }
    int getSub_Xposition(){
        return sub_Xposition;
    }
    int setSub_Xposition(int gridLatitude){
        sub_Xposition = gridLatitude;
    }
    int getSub_Yposition(){
        return sub_Yposition;
    }
    int setSub_Yposition(int gridLongitude){
        sub_Yposition = gridLongitude;
    }
    boolean subIsHit(){
        sub_isHit = true;
    }
    
}