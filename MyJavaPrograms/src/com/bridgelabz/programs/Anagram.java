package com.bridgelabz.programs;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter string1 and string2 to check for anagram: ");
		
		String string1 = scanner.next();	//first string
		String string2 = scanner.next(); //second string
		
		Utility utility = new Utility();
		
		if(utility.anagram(string1, string2)) {
			System.out.println("Strings are anagram.");
		}
		else {
			System.out.println("Strings are not anagram.");
		}
		scanner.close();
	}

}
