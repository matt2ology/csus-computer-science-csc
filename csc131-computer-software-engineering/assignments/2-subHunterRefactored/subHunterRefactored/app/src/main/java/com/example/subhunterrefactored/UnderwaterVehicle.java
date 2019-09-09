package com.example.subhunterrefactored;

/**
 * <h1> abstract class UnderwaterVehicle </h1>
 * <p>So that in the future if one were to be asked to make 
 * other submarine varients (Attack Sub or a Radar Sub) this are
 * the universial functions that would apply to all submarine varients.
 * </p>
 */
public abstract class UnderwaterVehicle {
	abstract int getSubHorizontalPosition();
	abstract int setSubHorizontalPosition();
	abstract int getSubVerticalPosition();
	abstract int setSubVerticalPosition();
	abstract boolean subIsHit();
}
