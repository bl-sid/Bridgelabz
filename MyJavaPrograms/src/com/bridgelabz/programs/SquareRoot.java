package com.bridgelabz.programs;

import com.bridgelabz.utility.Utility;

public class SquareRoot {

	public static void main(String[] args) {

		//	getting number from command line argument
		double number = Double.parseDouble(args[0]);	
		
		//	getting square root from utility class' method
		System.out.println(new Utility().sqrt(number , number));
	}

}
