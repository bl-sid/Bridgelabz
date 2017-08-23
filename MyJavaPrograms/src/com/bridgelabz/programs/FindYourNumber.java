package com.bridgelabz.programs;

import java.util.Scanner;

public class FindYourNumber {

	int[] numberArray;	//	array of numbers of given range
	Scanner scanner;	//	scanner to get user input
	int count = 0;	
	int  ans;	//	the number in mind
	int N;	//	range	
	double  maxCount = 0;	//	number of times question will be asked
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FindYourNumber findYourNumber = new FindYourNumber();
		findYourNumber.start();
	}

	/**
	 * takes range from user
	 */
	void start() {
		scanner = new Scanner(System.in);
		System.out.print("Enter limit N: ");
		N = scanner.nextInt();

		numberArray = new int[N];	//	array initialisation
		//	fills the array 
		for(int i = 0; i < N; i++) {
			numberArray[i] = i;
		}
		
		//	calculates maximum count of questions
		maxCount = (Math.log(N) / Math.log(2));
		System.out.println("Number of tries required to guess: " + ((int)maxCount + 1));
		binarySearch(0, N-1);
	}
	
	
	/**
	 * @param first - first element in range
	 * @param last - last element in the range
	 * asks user if the number is in given range and reduces the range
	 */
	void binarySearch(int first, int last) {
		if(count < maxCount) {
			int	middle = (first + last) / 2;
			count++;
			System.out.println("Is number between " + first  + " and " + middle + "?");
			String temp = scanner.next();
			if(temp.equals("y")) {
				change(middle+1 , last);
				binarySearch(first , middle);				
			}
			else if(temp.equals("n")){
				change(first , middle);
				binarySearch(middle + 1, last);
			}
		}
		else {
			for(int i : numberArray) {
				if(i != -1) {
					System.out.println("The number is: " + i);
				}
			}
		}
	}
	
	/**
	 * replaces all the integer in the array to -1 as the number is not in this range
	 * @param first - first element in the range
	 * @param last - last element in the range
	 */
	void change(int first , int last) {
		for(int i = first; i <= last; i++) {
			numberArray[i] = -1;
		}
	}
}
