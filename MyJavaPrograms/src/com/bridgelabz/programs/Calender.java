package com.bridgelabz.programs;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Calender {

	int maxDays; // number of days in a month
	int maxWeeks; // number of weeks in the month
	int[][] daysArray; // array to store dates

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		// gets user input for month and year
		System.out.print("Enter month and year: ");
		int month = scanner.nextInt();
		int year = scanner.nextInt();
		scanner.close();

		// prints month and year
		System.out.println("\n" + (new DateFormatSymbols().getMonths()[month - 1]) + " " + year + "\n");

		System.out.println("Su\tM\tT\tW\tTh\tF\tSa"); // prints weekdays names

		Calender calender = new Calender(); // class object
		calender.fillArray(month, year); // fills array
		calender.print(); // prints array

	}

	/**
	 * @param month
	 *            - month number of the year
	 * @param year
	 *            fills array of month
	 */
	void fillArray(int month, int year) {
		// adds 0 to month number if month number is single digit
		String yearAndMonth = month < 10 ? "0" + String.valueOf(month) + " " + String.valueOf(year)
				: String.valueOf(month) + String.valueOf(year);

		// format for representing a date
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy");
		try {
			Date date = simpleDateFormat.parse("01 " + yearAndMonth);
			Calendar cal = Calendar.getInstance(); // instance of calendar
			cal.setTime(date); // sets calendar to first day of month

			// gets number of days in the month
			maxDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			// gets number of weeks in the month
			maxWeeks = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
			// initialises the days array
			daysArray = new int[maxWeeks][maxDays];

			// fills the array
			for (int day = 1; day <= maxDays; day++) {
				// adds 0 to the day number if the number is less than 10
				String dayNumString = day < 10 ? "0" + String.valueOf(day) : String.valueOf(day);

				date = simpleDateFormat.parse(dayNumString + " " + yearAndMonth);
				cal.setTime(date);

				int weekNum = cal.get(Calendar.WEEK_OF_MONTH); // gets week number
				int dayNum = cal.get(Calendar.DAY_OF_WEEK); // gets day name
				daysArray[weekNum - 1][dayNum - 1] = day; // adds in the array
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/** Prints the calendar **/
	void print() {
		for (int week = 0; week < maxWeeks; week++) { // represents a week
			for (int day = 0; day < 7; day++) { // represents a day in the week
				if (daysArray[week][day] != 0) {
					// prints the day if that day has a date
					System.out.print(daysArray[week][day] + "\t");
				} else {
					// else prints nothing and adds spaces
					System.out.print("\t");
				}
			}
			System.out.println();	//	prints new line after printing a week's data
		}

	}

}
