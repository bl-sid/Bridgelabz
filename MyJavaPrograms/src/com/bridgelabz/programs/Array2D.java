package com.bridgelabz.programs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Array2D {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter number of rows and column: ");
		int rowCount = scanner.nextInt();
		int colCOunt = scanner.nextInt();
		scanner.close();
		
		String[][] array = new String[rowCount][colCOunt];
		File file = new File("/home/bridgeit/Pictures/Sid/array.txt");
		PrintWriter printWriter = null;
		try{
			scanner = new Scanner(file);
			for(int i = 0; i < rowCount; i++){
				for(int j = 0; j < colCOunt; j++){
					array[i][j] = scanner.next();
				}
			}
			printWriter = new PrintWriter(System.out);
			for(int i = 0; i < rowCount; i++){
				for(int j = 0; j < colCOunt; j++){
					printWriter.print(array[i][j] + "\t");
				}
				printWriter.println();
			}
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		finally {
			printWriter.flush();
			scanner.close();
		}
	}
}
