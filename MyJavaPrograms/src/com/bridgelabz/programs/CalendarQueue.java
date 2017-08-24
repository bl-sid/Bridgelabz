package com.bridgelabz.programs;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarQueue {

	public static void main(String[] args) {

		MyQueue<Week> weekQue = new MyQueue<Week>();	//Queue to store week objects
		Calendar calendar = null;
		
		int mon = Integer.parseInt(args[0]);
		//adding 0 if month number is single digit
		String month = mon < 10 ? ("0" + String.valueOf(mon)) : String.valueOf(mon); 
		SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
		
		System.out.println(new DateFormatSymbols().getMonths()[mon - 1] + " " + args[1]);
		System.out.println("\nSu\tM\tT\tW\tTh\tF\tSa");
		
		Date date;
		try {
			date = sdf.parse("01 " + month + " " + args[1]);
			calendar = Calendar.getInstance();
			calendar.setTime(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//getting maximum number of days in the month
		int totalDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		//getting first day of the month
		int firstDay = calendar.get(Calendar.DAY_OF_WEEK);	
		//getting total number of weeks in a month
		int totalWeeks = calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);
		
		int currentDate = 1;	//starting from day 1
		for(int i = 0; i < totalWeeks; i++) {
			Week weekNum = new Week();	//week object for a week
			weekQue.enqueue(weekNum);
			for(int j = 0; j < 7; j++) {
				//enqueues a day
				if((i == 0) && j < (firstDay - 1)) {
					weekNum.weekDayQue.enqueue(new WeekDay(dayName(j) , " "));
				}
				else if(currentDate <= totalDays){
					weekNum.weekDayQue.enqueue(new WeekDay(dayName(j) , String.valueOf(currentDate)));
					currentDate++;
				}
				else
					weekNum.weekDayQue.enqueue(new WeekDay(" " , " "));
			}
		}
		
		//dequeue and print
		for(int i = 0; i < totalWeeks; i++) {
			Week weekNum = weekQue.dequeue();
			for(int j = 0; j < 7; j++) {
				WeekDay weekDay = weekNum.weekDayQue.dequeue();				
				System.out.print(weekDay.date + "\t");
				
			}
			System.out.println();
		}
		
	}
	
	//returns day from integer
	static String dayName(int i) {
		switch(i) {
		case 1:
			return "Su";
		case 2:
			return "M";
		case 3:
			return "T";
		case 4:
			return "W";
		case 5:
			return "Th";
		case 6:
			return "F";
		default:
			return "Sa";
		}
		
	}
}