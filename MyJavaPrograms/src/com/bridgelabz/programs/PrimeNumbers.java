package com.bridgelabz.programs;

import com.bridgelabz.utility.Utility;

public class PrimeNumbers {

	public static void main(String[] args) {

		Utility utility = new Utility();	//	utility object
		String[] integerArray = utility.prime(1000);	//	prime number array
		for(String string : integerArray) {	//	printing the array
			System.out.println(string);
		}
	}

}
