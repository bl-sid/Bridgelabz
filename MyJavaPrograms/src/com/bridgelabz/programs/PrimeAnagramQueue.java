package com.bridgelabz.programs;

import com.bridgelabz.utility.Utility;

public class PrimeAnagramQueue {

	MyQueue<Integer> myQueue ;	//	queue
	PrimeNumber2dArray object;
	
	public static void main(String[] args) {

		//	class object
		PrimeAnagramQueue primeAnagramQueue = new PrimeAnagramQueue();
		primeAnagramQueue.fillQueue();
	}

	
	/** finds prime anagrams and queues them into the queue **/
	void fillQueue() {
		object = new PrimeNumber2dArray();
		object.findPrimes();
		myQueue = new MyQueue<Integer>();
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < object.primeNumbers[i].length; j++) {
				int num = object.primeNumbers[i][j];
				for(int k = j+1; k < object.primeNumbers[i].length; k++) {
					if(isAnagram(num, object.primeNumbers[i][k])){
						myQueue.enqueue(num);
						myQueue.enqueue(object.primeNumbers[i][k]);
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
		Utility utility = new Utility();	//	utility object
		return utility.anagram(String.valueOf(firstInterger), 
				String.valueOf(secondInteger));
	}
	
	/** prints the queue **/
	void print() {
		while(!myQueue.isEmpty())
			System.out.println(myQueue.dequeue() + " " + myQueue.dequeue());
	}
}