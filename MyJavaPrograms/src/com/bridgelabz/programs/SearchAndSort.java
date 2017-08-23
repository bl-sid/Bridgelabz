package com.bridgelabz.programs;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class SearchAndSort {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);	//	scanner to get user input
		Utility utility = new Utility();	//	utility object
		
		System.out.print("Enter number of integers: ");
		int count = scanner.nextInt();	//	count
		int[] intArray = new int[count];	//original integer array
		
		//	fills the array
		System.out.print("Enter integers: ");
		for(int i = 0; i < count; i++) {
			intArray[i] = scanner.nextInt();
		}
		
		int[] copyIntArray = intArray;	//copy of integer array

		//insertion sort time
		long time1 = System.currentTimeMillis();		
		copyIntArray = utility.insertionSortDescending(intArray);		
		long time2 = System.currentTimeMillis();
		System.out.println("Time taken for insertion sort: " +  (((double)time2 - time1) / 1000) + "second.");		
		for(int i : intArray) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		
		//bubble sort time
		time1 = System.currentTimeMillis();
		copyIntArray = utility.bubbleSortDescending(intArray);		
		time2 = System.currentTimeMillis();
		System.out.println("Time taken for bubble sort: " +  (((double)time2 - time1) / 1000) + "second.");		
		for(int i : copyIntArray) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		intArray = copyIntArray;
		
		//binary search time
		System.out.print("Enter number to search:");
		int intSearch = scanner.nextInt();
		time1 = System.currentTimeMillis();
		if(utility.binarySearch(intSearch , intArray) > -1) {
			System.out.println("Number found");
		}
		else
			System.out.println("Not found");
		time2 = System.currentTimeMillis();
		System.out.println("Time taken for binary search: " +  (((double)time2 - time1) / 1000) + "second.");

		
		//Strings
		System.out.print("Enter number of strings: ");
		count = scanner.nextInt();
		String[] stringArray = new String[count];
		System.out.print("Enter strings: ");
		for(int i = 0; i < count; i++) {
			stringArray[i] = scanner.next();
		}
		
		String[] copyStringArray = stringArray;
		
		//insertion sort time
		time1 = System.currentTimeMillis();		
		copyStringArray = utility.insertionSortDescending(stringArray);		
		time2 = System.currentTimeMillis();
		System.out.println("Time taken for insertion sort: " +  (((double)time2 - time1) / 1000) + "second.");		
		for(String string : copyStringArray) {
			System.out.print(string + " ");
		}
		System.out.println();
		
		//bubble sort time
		time1 = System.currentTimeMillis();
		copyStringArray = utility.bubbleSort(stringArray);		
		time2 = System.currentTimeMillis();
		System.out.println("Time taken for bubble sort: " +  (((double)time2 - time1) / 1000) + "second.");		
		for(String string : copyStringArray) {
			System.out.print(string + " ");
		}
		System.out.println();
		
		stringArray = copyStringArray;
		
		
		//binary search time
		System.out.print("Enter string to search:");
		String stringSearch = scanner.next();
		time1 = System.currentTimeMillis();
		if(utility.binarySearch(stringSearch , stringArray) > -1) {
			System.out.println("String found");
		}
		else
			System.out.println("Not found");
		time2 = System.currentTimeMillis();
		System.out.println("Time taken for binary search: " +  (((double)time2 - time1) / 1000) + "second.");
		
		scanner.close();

	}
}
