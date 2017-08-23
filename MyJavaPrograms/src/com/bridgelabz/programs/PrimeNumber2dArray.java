package com.bridgelabz.programs;

public class PrimeNumber2dArray {

	int[][] primeNumbers;
	
	public static void main(String[] args) {

		//	class object
		PrimeNumber2dArray primeNumber2dArray = new PrimeNumber2dArray();
		primeNumber2dArray.findPrimes();
		primeNumber2dArray.print();
	}
	
	/**
	 * finds prime number and puts into the 2d array
	 */
	void findPrimes() {
		primeNumbers = new int[10][];	//	array to store the prime numbers
		
		for(int i = 0; i < 10; i++) {
			int count = 0;
			int[] tempArray = new int[100];
			for(int j = 1; j <= 100; j++) {
				int num = i * 100 + j;	//	current number
				if(isPrime(num)) {
					tempArray[count] = num;
					count++;
				}				
			}
			primeNumbers[i] = new int[count];
			for(int k = 0; k < count; k++) {	//	filling the array
				primeNumbers[i][k] = tempArray[k];
			}
		}
	}

	/**
	 * @param num  - number to be checked
	 * @returns true if number is prime else returns false
	 */
	boolean isPrime(int num) {
		for(int i = 2; i < num / 2; i++) {
			if((num % i) == 0) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * prints the array of prime numbers on the screen
	 */
	void print() {
		System.out.println("Prime numbers are:");
		for(int[] nums : primeNumbers) {
			for(int num : nums)
				System.out.println(num);
		}
	}
}