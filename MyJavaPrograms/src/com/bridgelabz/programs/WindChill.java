package com.bridgelabz.programs;


import java.util.Scanner;

public class WindChill {

	public static void main(String[] args) {

		WindChill windChill = new WindChill();	//	class object
		windChill.calculateWindChill();			
	}

	/**
	 * takes user input for temperature and velocity
	 * and calculates and prints wind chill
	 */
	void calculateWindChill() {
		double t, v, windchill; //represents temperature, velocity and wind chill
		Scanner scanner = new Scanner(System.in);	//	scanner to get user input

		System.out.print("Enter temperature and speed of the air: ");
		t = scanner.nextInt();
		v = scanner.nextInt();
		
		scanner.close();
		
		if(t > 50) {	//	invalid temperature
			System.out.println("temperature should not be greater than 50");
			calculateWindChill();
			return;
		}
		if((v > 120) || (v < 3)) {	//	invalid velocity
			System.out.println("velocity should be greater than 3 and less than 120");
			calculateWindChill();
			return;
		}
		
		//	wind chill formula
		windchill = 35.74 + 0.6215 * t + (0.4275 * t - 35.75) * (Math.pow(v, 0.16));
		
		//	prints wind chill
		System.out.println("Windchill : " + windchill);
	}
}