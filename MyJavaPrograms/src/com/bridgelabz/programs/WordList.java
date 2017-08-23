package com.bridgelabz.programs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class WordList {

	public static void main(String[] args) {

		FileReader file;
		String[] strings = null;	//	string array to store file words into strings
		BufferedReader bufferedReader = null;	//	buffered reader to read the file
		try {
			file = new FileReader("/home/bridgeit/Sid/myfile.txt");
			bufferedReader = new BufferedReader(file);
			String line;
			while((line = bufferedReader.readLine()) != null) {
				strings = line.split(",");	//	splits words by commas
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Utility utility = new Utility();	//	utility object	
		strings = utility.insertionSortDescending(strings);	//	sorted array
		
		Scanner scanner = new Scanner(System.in);	//	scanner to get user input
		System.out.print("Enter a word to search: ");
		String search = scanner.nextLine();	//	word to be searched
		
		if(utility.binarySearch(search , strings) != -1) {	//	word found
			System.out.println("Word found");
		}
		else {	//	word not found
			System.out.println("Word not found");
		}
		scanner.close();
	}

}
