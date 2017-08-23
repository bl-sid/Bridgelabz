package com.bridgelabz.programs;

import java.util.Scanner;

public class HarmonicNumber {

	public static void main(String[] args) {

		HarmonicNumber number = new HarmonicNumber();	//	class object
		number.start();
	}

	void start(){
		Scanner scanner = new Scanner(System.in);	//	scanner to get user input
		System.out.print("Enter position in series: ");
		int n = scanner.nextInt();	//	position of the element in the series
		if(n < 1){	// entered value 0 or negative
			System.out.println("Number should be greater than 0");
			start();
		}
		else{	//	prints elemnt in the series
			System.out.println(n +"th harmonic number is: " +
						((double)1 / n));
		}
		scanner.close();
	}	
}