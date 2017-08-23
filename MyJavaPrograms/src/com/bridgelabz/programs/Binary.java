package com.bridgelabz.programs;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class Binary {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number to convert into binary: ");
		
		Utility utility = new Utility();
		
		int number = scanner.nextInt();	// number to convert into binary
		//storing binary into string
		String binaryString = utility.toBinary(number);
		
		System.out.println("Binary representation of the number: " + binaryString);
		//prints padded string
		System.out.println("Addition: " + utility.paddedString(number));
		
		scanner.close();
	}

}
