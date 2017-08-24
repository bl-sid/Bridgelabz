package com.bridgelabz.programs;


import com.bridgelabz.utility.Utility;

public class PrimeAnagramStack {

	MyStack<Integer> myStack;	//	stack to store prime anagrams
	PrimeNumber2dArray object;
	
	public static void main(String[] args) {

		//	class object
		PrimeAnagramStack primeAnagramStack = new PrimeAnagramStack();
		primeAnagramStack.fillStack();
	}

	
	/**
	 * fills prime anagrams in the stack
	 */
	void fillStack() {
		object = new PrimeNumber2dArray();
		object.findPrimes();
		myStack = new MyStack<Integer>();

		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < object.primeNumbers[i].length; j++) {
				int num = object.primeNumbers[i][j];
				for(int k = j+1; k < object.primeNumbers[i].length; k++) {
					if(isAnagram(num, object.primeNumbers[i][k])){
						myStack.push(num);
						myStack.push(object.primeNumbers[i][k]);
						break;
					}
				}
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
	 * prints stack elements
	 */
	void print() {
		while(!myStack.isEmpty())
			System.out.println(myStack.pop() + " " + myStack.pop());
	}
}