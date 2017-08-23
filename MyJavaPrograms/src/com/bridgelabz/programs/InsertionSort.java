package com.bridgelabz.programs;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class InsertionSort {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);	//	scanner to get user input
		System.out.println("Enter number of words to sort: ");
		int count = scanner.nextInt();	//	count of words
		String[] strings = new String[count];	//	string array to store words
		System.out.print("Enter words to sort: ");
		//	filling the array
		for(int i = 0; i < count; i++) {
			strings[i] = scanner.next();
		}
		
		Utility utility = new Utility();
		//	sorting words in the array
		strings = utility.insertionSortAscending(strings);
		
		//	printing sorted array
		for(String string : strings) {
			System.out.println(string);
		}
		scanner.close();
	}

}
