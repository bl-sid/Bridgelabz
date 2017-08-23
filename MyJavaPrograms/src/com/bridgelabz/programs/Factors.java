package com.bridgelabz.programs;

import java.util.Scanner;

public class Factors {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in); // scanner to get user input
		System.out.print("Enter number: ");
		int num = scanner.nextInt();
		scanner.close();

		if (num < 1) {
			System.out.println("Number should be greater than 0");
		} else {
			System.out.print("The prime factors are: ");

			for (int i = 2; i * i <= num; i++) {
				//	checks if number is factor and prime
				if (((num % i) == 0) && isPrime(i)) {
					System.out.print(i + " ");
					int oppositeNum = num / i;	//	checks if the divider is a prime number
					if ((oppositeNum != i) && isPrime(oppositeNum)) {
						System.out.print((oppositeNum) + " ");
					}
				}
			}
			System.out.println();
		}
	}

	/** checks if the number is prime **/
	static boolean isPrime(int number) {
		for (int i = 2; i * i <= number; i++) {
			if ((number % i) == 0) {
				return false;
			}
		}
		return true;
	}
}
