package com.bridgelabz.programs;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class StringPermutation {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);	//	scanner to get user input
		System.out.println("Enter string to find permutations: ");
		String stringToPermute = scanner.next();	// string to be permuted
		scanner.close();
		Utility utility = new Utility();	//	utility object
		//	prints permutations of the given string
		utility.permute("", stringToPermute);	
	}	
}
