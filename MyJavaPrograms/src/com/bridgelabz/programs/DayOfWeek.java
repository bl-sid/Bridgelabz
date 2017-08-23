package com.bridgelabz.programs;

import com.bridgelabz.utility.Utility;

public class DayOfWeek {

	public static void main(String[] args) {

		//	gets month, year and day from command line arguments
		double month  = Double.parseDouble(args[0]);
		double day = Double.parseDouble(args[1]);
		double year = Double.parseDouble(args[2]);
		
		//prints day of the week
		System.out.println(new Utility().dayOfWeek(month, day, year));
	}

}
