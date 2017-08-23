package com.bridgelabz.programs;

import com.bridgelabz.utility.Utility;

public class Distance {

	public static void main(String[] args) {
		
		double xCoOrdinate = Double.parseDouble(args[0]);	//x coordinate
		double yCoOrdinate = Double.parseDouble(args[1]);	//y coordinate
		
		Utility utility = new Utility();	//	utility object
		
		//	variable to store distance
		double distance = utility.measureDistance(xCoOrdinate, yCoOrdinate);
		
		//	printing distance
		System.out.format("The distance of (%.2f , %.2f) from origin is %.2f" ,
				xCoOrdinate , yCoOrdinate , distance);
	
	}

	
}