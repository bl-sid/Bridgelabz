package com.bridgelabz.utility;

import java.util.Arrays;

public class Utility {
	
	double epsilon = Math.pow(2.71828 , -15);
	
	/** Returns true if strings are anagram else returns false **/
	public boolean anagram(String string1, String string2) {
		if(string1.length() != string2.length()) {
			return false;
		}
		char[] array1 = string1.toCharArray();
		Arrays.sort(array1);
		char[] array2 = string2.toCharArray();
		Arrays.sort(array2);
		
		for(int i = 0; i < array1.length; i++) {
			if(array1[i] != array2[i]) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * @param range- up to which prime numbers are to be found
	 * @returns string array of prime numbers in  a given range
	 */
	public String[] prime(int range) {
		String[] array = new String[1000];
		int position = 0;
		for(int i = 2; i <= range; i++) {
			boolean isPrime = true;
			for(int j = 2; j <= i / 2; j++) {
				if((i % j) == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				array[position] = String.valueOf(i);
				position++;
			}
		}
		String[] returnArray = new String[position];
		for(int k = 0; k < position; k++) {
			returnArray[k] = array[k];
		}
		return returnArray;
	}
	
	
	
	/**
	 * @param string- string to check for palindrome
	 * @returns true if the string is palindrome else returns false
	 */
	public boolean palindrome(String string) {
		if(string.length() < 2) {
			return false;
		}
		char[] array = string.toCharArray();
		int n = array.length;
		for(int i = 0; i < n; i++) {
			if(array[i] != array[n - 1 - i]) {
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * @param search - integer to search
	 * @param binaryIntArray - integer array in which integer is to be searched
	 * @returns the position of the integer if found else returns -1
	 */
	public int binarySearch(int search , int[] binaryIntArray) {
		int first = 0, last = binaryIntArray.length - 1;
		int middle;
		
		while(first <= last) {
			middle = (first + last) / 2;
			if(binaryIntArray[middle] < search) {
				last = middle - 1;
			}
			else if(binaryIntArray[middle] > search) {
				first = middle + 1;
			}
			if(binaryIntArray[middle] == search) {
				return middle;
			}
		}
		return -1;
	}

	
	/**
	 * @param search - string to search
	 * @param binaryStringArray - array in which string is to be searched
	 * @returns position of the string if found else returns -1
	 */
	public int binarySearch(String search , String[] binaryStringArray) {
		int first = 0, last = binaryStringArray.length - 1;
		int middle;
		
		while(first <= last) {
			middle = (first + last) / 2;
			if(binaryStringArray[middle].compareTo(search) < 0) {
				last = middle - 1;
			}
			else if(binaryStringArray[middle].compareTo(search) > 0) {
				first = middle + 1;
			}
			if(binaryStringArray[middle].compareTo(search) == 0) {
				return middle;
			}
		}
		return -1;
	}
	
	
	
	/**
	 * @param binaryIntArray - integer array to sort
	 * @returns sorted integer array in descending order
	 */
	public int[] insertionSortDescending(int[] binaryIntArray) {
		
		for(int i = 1; i < binaryIntArray.length; i++) {
			int key = binaryIntArray[i];
			int j = i - 1;
			while((j > -1) && (binaryIntArray[j] < key)) {				
				binaryIntArray[j+1] = binaryIntArray[j];
				j--;
			}
			binaryIntArray[j+1] = key;
		}
		
		return binaryIntArray;
	}
	
	
	
	/**
	 * @param binaryStringArray - string array to sort
	 * @returns sorted string array in descending order
	 */
	public String[] insertionSortDescending(String[] binaryStringArray) {

		for(int i = 1; i < binaryStringArray.length; i++) {
			String key = binaryStringArray[i];
			int j = i - 1;
			while((j > -1) && (binaryStringArray[j].compareTo(key) < 0)) {				
				binaryStringArray[j+1] = binaryStringArray[j];
				j--;
			}
			binaryStringArray[j+1] = key;
		}
		
		return binaryStringArray;
	}
	
	
	/**
	 * @param binaryIntArray - integer array to sort
	 * @returns sorted integer array in descending order
	 */
	public int[] bubbleSortDescending(int[] binaryIntArray) {

		int n = binaryIntArray.length;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < (n - 1 - i); j++) {
				if(binaryIntArray[j] < binaryIntArray[j+1]) {
					int temp = binaryIntArray[j];
					binaryIntArray[j] = binaryIntArray[j+1];
					binaryIntArray[j+1] = temp;
				}
			}
		}
		
		return binaryIntArray;
	}
	
	
	
	/**
	 * @param binaryStringArray - string array to sort
	 * @returns sorted string array in descending order
	 */
	public String[] bubbleSort(String[] binaryStringArray) {

		int n = binaryStringArray.length;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < (n - 1 - i); j++) {
				if(binaryStringArray[j].compareTo(binaryStringArray[j+1]) < 0) {
					String temp = binaryStringArray[j];
					binaryStringArray[j] = binaryStringArray[j+1];
					binaryStringArray[j+1] = temp;
				}
			}
		}
		
		return binaryStringArray;
	}
	
	
	/**
	 * @param binaryStringArray - input string array to sort
	 * @returns array in ascending order
	 */
	public String[] insertionSortAscending(String[] binaryStringArray) {
		
		for(int i = 1; i < binaryStringArray.length; i++) {
			String key = binaryStringArray[i];
			int j = i - 1;
			while((j > -1) && (binaryStringArray[j].compareTo(key) > 0)) {				
				binaryStringArray[j+1] = binaryStringArray[j];
				j--;
			}
			binaryStringArray[j+1] = key;
		}
		
		return binaryStringArray;
	}
	
	
	 /**
	 * @param binaryIntArray - input integer array to sort
	 * @returns sorted integer array in ascending order
	 */
	public int[] bubbleSortAscending(int[] binaryIntArray) {

		 int n = binaryIntArray.length;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < (n - 1 - i); j++) {
					if(binaryIntArray[j] > binaryIntArray[j+1]) {
						int temp = binaryIntArray[j];
						binaryIntArray[j] = binaryIntArray[j+1];
						binaryIntArray[j+1] = temp;
					}
				}
			}
			return binaryIntArray;
	 }
	
	
	/**
	 * @param m - month of the year
	 * @param d - day of the month
	 * @param y - year
	 * @returns day of the week
	 */
	public int dayOfWeek(double m, double d, double y) {
		double y0 = y - ((14 - m) / 12);
		double x = y0 + (y0 / 4) - (y0 / 100) + (y0 / 400);
		double m0 = m + 12 * ((14 - m) / 12) - 2;
		double d0 = (d + x + (31 * m0 / 12)) % 7;
		return (int)d0;
	}	
	
	
	/**
	 * @param temperature - temperature to be converted
	 * @param unit - given temperature's unit
	 * @returns converted temperature
	 */
	public double tempConvert(double temperature , String unit) {
		if(unit.equals("f")){
			return ((double)temperature - 32) * 5 / 9;
		}
		else {
			return  (((double)temperature * 9 / 5) + 32);
		}
	}
	
	
	/**
	 * @param P
	 * @param Y
	 * @param R
	 * @returns monthly payment from given P, Y & R values
	 */
	public int monthlyPayment(double P, double Y, double R) {
		double r = R / (12 * 100);
		double n = - 1* 12 * Y;
		double payment = (P * r) / (1 - Math.pow((1 + r) , n));
		return (int)payment;
	}
	
	/**
	 * @param c
	 * @param t
	 * @returns square root of the number
	 */
	public double sqrt(double c, double t) {
		
		t = ((c / t) + t) / 2;
		if(Math.abs(t - (c / t)) > (epsilon * t)) {
			return t;
		}
		return sqrt(c , t);
	}
	
	
	/**
	 * @param number
	 * @returns string representing binary of number
	 */
	public String toBinary(int number) {
		if(number == 1) {
			return String.valueOf(number);
		}
		int remainder = number % 2;
		return toBinary(number / 2) + String.valueOf(remainder);
	}
	
	/** Converts binary number to decimal. **/
	public int binaryToInteger(int binary) {
		String binaryString = String.valueOf(binary);
		int number = 0;
		for (int index = 0; index < binaryString.length(); index++) {
			int tempDigit = binaryString.charAt(index) - '0';
			number = number * 2 + tempDigit; 
		}
		return number;
	}
	
	/**	Swaps nibbles in the given binary **/
	public int swapNibbles(String binaryString) {
		int size = binaryString.length();
		for(int i = 0; i < 8 - size; i++) {
			binaryString = "0" + binaryString;
		}
		String nibble1 = binaryString.substring(0, 4);
		String nibble2 = binaryString.substring(4);
		return Integer.parseInt(nibble2 + nibble1);
	}
	
	/** Returns true if number is power of two **/
	public boolean isPowerOfTwo(int binary) {
		String binaryString = String.valueOf(binary);
		
		for (int index = 1; index < binaryString.length(); index++) {
			if(binaryString.charAt(index) != '0') {
				return false;
			}
		}
		return true;
	}
	
	/**	Represents number as addition of numbers which arte power of two **/
	public String paddedString(int number) {
		int i = 2;
		String returnString = "";
		String plusCharacter = "";
		while(number > 0) {
			if ((number / i) == 0) {
				if(returnString.length() != 0) {
					plusCharacter = " + ";
				}
				returnString = returnString + plusCharacter + (i/2);
				number -= (i/2);
				i = 2;
			}
			else if(number == 1){
				return returnString + " + 1";
			} else {
				i *= 2;
			}
		}
		return returnString;
	}
	/**
	 * @param array - String array to be sorted
	 * @returns sorted array in ascending order
	 */
	public String[] mergeSort(String[] array){
		if(array.length == 1){
			return array;
		}
		String first[] = new String[array.length / 2];
		String last[] = new String[array.length - (array.length / 2)];
		for(int i = 0; i < first.length; i++){
			first[i] = array[i];
		}
		int j = 0;
		for(int i = first.length; i < array.length; i++){
			last[j] = array[i];
			j++;
		}
		first = mergeSort(first);
		last = mergeSort(last);
		
		String[] returnArray = new String[array.length];
		int firstPos = 0, lastPos = 0;
		for(int i = 0; i < returnArray.length; i++){
			if(lastPos == last.length){
				returnArray[i] = first[firstPos];
				firstPos++;
			}
			else if(firstPos == first.length){
				returnArray[i] = last[lastPos];
				lastPos++;
			}
			else if(first[firstPos].compareTo(last[lastPos]) > 0){
				returnArray[i] = last[lastPos];
				lastPos++;
			}
			else{
				returnArray[i] = first[firstPos];
				firstPos++;
			}
		}
		return returnArray;
	}
	
	/** prints all possible permutations of a string **/
	public void permute(String first, String last) {
		int size = last.length();
		if (size == 0) {
			System.out.println(first);
		} else {
			for (int i = 0; i < size; i++) {
				String myFirst = first + last.charAt(i);
				String myLast = last.substring(0, i) + last.substring(i + 1 , size);
				permute(myFirst, myLast);
			}
		}
	}
	
	/** returns number of binary trees possible **/
	public int treeCount(int number) {
		int intSum = 0;
		if(number == 0 || number == 1) {
			return 1;
		} else if(number == 2) {
			return 2;
		} else {
			for(int i = 0; i < number; i++) {
				 intSum = intSum + treeCount(i) * treeCount(number - i - 1);
			}		
			return intSum;
		}
		
	}
	
	/**
	 * @param xCoOrdinate x coordinate of the point
	 * @param yCoOrdinate y coordinate of the point
	 * returns distance between given point and origin
	 */
	public double measureDistance(double xCoOrdinate, double yCoOrdinate) {
		return Math.pow((Math.pow(xCoOrdinate , 2) + Math.pow(yCoOrdinate , 2)), 0.5);
	}
}
