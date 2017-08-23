package com.bridgelabz.programs;

import java.util.Scanner;

public class PowerOf2 {

	public static void main(String[] args) {

		PowerOf2 powerOf2 = new PowerOf2();	//	class object
		powerOf2.test();		
	}

	void test(){
		Scanner scanner = new Scanner(System.in);	//	scanner to get user input
		System.out.print("Enter power of 2: ");
		int power = scanner.nextInt();	//	power up to which table is to be printed
		
		if((power >= 0) && (power <31)){	//	prints values
			System.out.println("Power\tAnswer\t\tLeap Year");
			for(int i = 0; i <= power; i++){
				System.out.println(i + "\t" +(int) (Math.pow(2 , i)) + "\t\t" + leap(Math.pow(2 , i)));
			}
		}
		else{	//	power is out of the limits
			System.out.println("Power should be positive and less than 31");
			test();
		}
		
		scanner.close();
	}

	/** returns 'Yes' if the number is leap year **/
	String leap(double i){
		if(i > 999){	
			return "Yes";
		}
		return "No";
	}
}