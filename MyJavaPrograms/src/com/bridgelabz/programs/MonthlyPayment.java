package com.bridgelabz.programs;

import com.bridgelabz.utility.Utility;

public class MonthlyPayment {

	public static void main(String[] args) {

		//	gets P, Y and R values from command line
		double P = Double.parseDouble(args[0]);
		double Y = Double.parseDouble(args[1]);
		double R = Double.parseDouble(args[2]);
		
		//	prints monthly payment required
		System.out.println("Monthly payment required: " + new Utility().monthlyPayment(P, Y, R));
	}

}
