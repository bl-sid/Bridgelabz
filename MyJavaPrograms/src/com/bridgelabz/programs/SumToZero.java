package com.bridgelabz.programs;

import java.util.Scanner;

public class SumToZero {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);	//	scanner to get user input
		int count = 0;	//	triples count
		
		System.out.print("Enter number of integers: ");
		int numberOfElements = scanner.nextInt();	//	number of elements
		int[] a = new int[numberOfElements];	//	number's array
		
		//	fills the array
		for(int i = 0; i < numberOfElements; i++){
			a[i] = scanner.nextInt();
		}
		scanner.close();
		
		System.out.println("Triples are:");
		
		//	searches for triples and prints them if found
		for(int i = 0; i < numberOfElements; i++){
			for(int j = i; j < numberOfElements; j++){
				for(int k = j; k < numberOfElements; k++){
					if((i != j) && (i != k) && (j != k)){
						if((a[i] + a[j] + a[k]) == 0){
							count++;	//	increases the count
							System.out.println(a[i] + " " + a[j] + " " + a[k]);
						}
					}
				}
			}
		}
		System.out.println("Total number of triples are: " + count);
	}
}