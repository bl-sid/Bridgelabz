package com.bridgelabz.programs;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class TemperatureConversion {

	public static void main(String[] args) {

		//class object
		TemperatureConversion conversion = new TemperatureConversion();
		conversion.convert();
	}

	/**
	 * gets user input and converts temperature
	 */
	public void convert() {
		Scanner scanner = new Scanner(System.in);	//	scanner to get input
		Utility utility = new Utility();	//	utility object
		
		System.out.println("Enter temperature unit 'f' for Fahrenheit and 'c' for Celcius: ");
		String unit = scanner.next();	//	unit
		
		//	gets temperature and converts it
		if(unit.equals("f")){
			System.out.print("Enter temperature in fahrenheit: ");
			double fahrenheitTemp = scanner.nextDouble();
			System.out.format("Temperature in celcius is: %.2f" , utility.tempConvert(fahrenheitTemp, unit));
		}
		else if(unit.equals("c")){
			System.out.print("Enter temperature in celcius: ");
			double celciusTemp = scanner.nextDouble();
			System.out.format("Temperature in fahrenheit is: %.2f" , utility.tempConvert(celciusTemp, unit));
		}
		else {
			System.out.println("Enter proper character...");
			convert();
		}
		
		scanner.close();
	}
}
