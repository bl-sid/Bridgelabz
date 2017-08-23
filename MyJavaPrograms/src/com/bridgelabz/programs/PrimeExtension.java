package com.bridgelabz.programs;

import com.bridgelabz.utility.Utility;

public class PrimeExtension {

	PrimeNumber2dArray object;
	int[][] primeAnagrams;
	
	public static void main(String[] args) {		
		PrimeExtension extension = new PrimeExtension();
		extension.findAnagrams();
	}
	
	
	/**
	 * finds anagrams and puts them into array
	 */
	void findAnagrams() {
		primeAnagrams = new int[10][];
		
		object = new PrimeNumber2dArray();		
		
		object.findPrimes();
		
		for(int i = 0; i < 10; i++) {
			int count = 0;
			int[] tempArray = new int[object.primeNumbers[i].length];
			for(int j = 0; j < tempArray.length; j++) {
				int num = object.primeNumbers[i][j];
				for(int k = j+1; k < tempArray.length; k++) {
					if(isAnagram(num, object.primeNumbers[i][k])){
						tempArray[count] = num;
						count++;
						tempArray[count] = object.primeNumbers[i][k];
						count++;
						break;
					}
				}
			}
			primeAnagrams[i] = new int[count];
			for(int j = 0; j < count; j++) {
				primeAnagrams[i][j] = tempArray[j];
			}
		}
		print();
	}
	
	/**
	 * @param firstInterger - first number 
	 * @param secondInteger - second number
	 * @returns true if numbers are anagram else returns false
	 */
	boolean isAnagram(int firstInterger, int secondInteger) {
		if(firstInterger < 10) {
			return false;
		}
		Utility utility = new Utility();
		return utility.anagram(String.valueOf(firstInterger), 
				String.valueOf(secondInteger));
	}
	
	/**
	 * prints prime anagrams
	 */
	void print() {
		for(int[] nums : primeAnagrams) {
			for(int i = 0; i < nums.length; i++) {
				System.out.println(nums[i] + " " + nums[++i]);
			}
		}
	}
}



