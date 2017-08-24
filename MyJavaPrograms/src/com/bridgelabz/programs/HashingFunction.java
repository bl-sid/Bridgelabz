package com.bridgelabz.programs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class HashingFunction {
	BufferedReader bufferedReader = null;
	MyHash<Integer> myHash = new MyHash<Integer>();

	public static void main(String[] args) {
		HashingFunction function = new HashingFunction();
		function.readFile();
		function.searchNumber();
	}
	
	void readFile() {
		bufferedReader = null;
		try {
			FileReader fileReader = new FileReader("/home/bridgeit/Sid/Numbers.txt");
			bufferedReader = new BufferedReader(fileReader);
			
			String line;
			while((line = bufferedReader.readLine()) != null) {
				String[] strings = line.split(" ");
				for(String integers : strings) {
					myHash.add(Integer.parseInt(integers));
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found...");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			bufferedReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void searchNumber() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a number to search: ");
		int search = scanner.nextInt();
		scanner.close();
		if(myHash.contains(search)) {
			System.out.println("File contains number. Removing it.");
			myHash.pop(search);
		}
		else {
			System.out.println("File does not contain the number. Adding it to the file.");
			myHash.add(search);
		}
		int[] integerArray = myHash.getAll();
		PrintWriter printWriter = null;
		try {
			printWriter = new PrintWriter("/home/bridgeit/Sid/Numbers.txt" , "UTF-8");
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		for(int integer : integerArray) {
			printWriter.print(integer + " ");
		}		
		printWriter.close();
	}
}
