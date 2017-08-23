package com.bridgelabz.programs;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class BubbleSort {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of integers to sort: ");
		int count = scanner.nextInt();
		
		int[] array = new int[count];	//array to store integers
		
		//fills the array asking user input
		System.out.print("Enter integers to sort: ");
		for(int i = 0; i < count; i++) {
			array[i] = scanner.nextInt();
		}
		
		Utility utility = new Utility();
		array = utility.bubbleSortAscending(array);	//sorts the array
		
		//prints the array
		for(int element : array) {
			System.out.println(element);
		}
		scanner.close();
	}

}
