package com.bridgelabz.programs;

import java.util.Random;
import java.util.Scanner;

public class CouponNumbers {

	int[] couponArray;	//	array to store numbers which has already occurred
	int  pos = 0;	//	position to which the new generated number is to add
	int randomCount = 0;	//	keeps number of trials required
	public static void main(String[] args){
		
		CouponNumbers couponNumbers = new CouponNumbers();	//	class object
		
		couponNumbers.start();
		
	}
	
	/** Asks user input **/
	void start() {
		Scanner scanner = new Scanner(System.in);	//	to get user input
		System.out.print("Enter Number of Coupons: ");
		int couponCount = scanner.nextInt();
		scanner.close();
		
		//initialising array
		couponArray = new int[couponCount];
		
		random(couponCount);
	}

	/** generates random number and adds to the array **/
	void random(int couponCount){
		randomCount++;
		Random random = new Random();
		int randomInteger = random.nextInt(couponCount) + 1;
		if(isPresent(randomInteger))
			random(couponCount);
		else{
			couponArray[pos] = randomInteger;
			pos++;
			if(pos == couponCount){
				System.out.println("Number of trials required: " + randomCount);
				return;
			}
			random(couponCount);
		}
	}

	/** checks if the generated number has occurred before **/
	boolean isPresent(int n){
		for(int i =0; i < couponArray.length; i++){
			if(couponArray[i] == n)
				return true;
		}
		return false;
	}
}