package com.bridgelabz.programs;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class BinaryExtended {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number to convert into binary: ");
		
		Utility utility = new Utility();
		
		String binaryString = utility.toBinary(scanner.nextInt());
		System.out.println("Binary representation of the number: " + binaryString);
		
		//stores swapped binary nibbles
		int SwappedBinary = utility.swapNibbles(binaryString);
		System.out.println("Binary after swapping: " + SwappedBinary);
		
		//stores new integer
		int swappedBinaryInteger = utility.binaryToInteger(SwappedBinary);
		System.out.println("Number after swapping nibbles: " + swappedBinaryInteger);;
		
		//checks if number is power of two and prints
		if(utility.isPowerOfTwo(SwappedBinary)) {
			System.out.println("The number is power of two");
		} else {
			System.out.println("The number is not power of two");
		}
		scanner.close();
	}

}
