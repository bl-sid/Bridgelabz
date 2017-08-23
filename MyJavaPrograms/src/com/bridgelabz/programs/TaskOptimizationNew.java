package com.bridgelabz.programs;

import java.util.Scanner;

public class TaskOptimizationNew {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Number of tasks: ");
		int count = scanner.nextInt();
		
		int[] deadlineArray = new int[count];
		int[] timeArray = new int[count];
		
		for(int i = 0; i < count; i++) {
			System.out.print("Enter deadline and time required for the task number :" + (i+1) + " ");;
			deadlineArray[i] = scanner.nextInt();
			timeArray[i] = scanner.nextInt();
		}
		scanner.close();

	}

	static void opt(int[] deadlineArray, int[] timeArray) {
		for(int i = 0; i < timeArray.length; i++) {
			int[] newDeadArray = new int[timeArray.length - 1];
			int[] newTimeArray = new int[timeArray.length - 1];
			int k = 0;
			for (int j = 0; j < timeArray.length - 1; k++) {
				if(j != i) {
					newDeadArray[j] = deadlineArray[k]; 
					newTimeArray[j] = timeArray[k];
					j++;
				}
			}
		}
	}
}
