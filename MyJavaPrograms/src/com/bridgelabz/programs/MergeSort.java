package com.bridgelabz.programs;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class MergeSort {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);	//	scanner to get user input
		System.out.print("Enter number of strings: ");
		int numberOfStrings = scanner.nextInt();	//	strings count
		//	strings array to store strings entered by user
		String[] strings = new String[numberOfStrings];
		
		//	filling array from user input
		for(int i = 0; i < numberOfStrings; i++) {
			strings[i] = scanner.next();
		}
		scanner.close();
		
		Utility utility = new Utility();	//	utility object
		strings = utility.mergeSort(strings);	//	sorting strings
		
		System.out.println("Sorted list:");
		//prints sorted array
		for(String string : strings) {
			System.out.println(string);
		}
	}

}
