package com.bridgelabz.programs;

public class MyHash<T> {

	MyOrderedList<Integer> s0,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10;
	public MyHash(){
		s0 = new MyOrderedList<Integer>();
		s1 = new MyOrderedList<Integer>();
		s2 = new MyOrderedList<Integer>();
		s3 = new MyOrderedList<Integer>();
		s4 = new MyOrderedList<Integer>();
		s5 = new MyOrderedList<Integer>();
		s6 = new MyOrderedList<Integer>();
		s7 = new MyOrderedList<Integer>();
		s8 = new MyOrderedList<Integer>();
		s9 = new MyOrderedList<Integer>();
		s10 = new MyOrderedList<Integer>();
	}
	
	public void add(int item) {

		int remainder = item % 11;
		
		switch(remainder) {
		
		case 0:
			s0.add(item);
			break;
		
		case 1:
			s1.add(item);
			break;
		
		case 2:
			s2.add(item);
			break;
			
		case 3:
			s3.add(item);
			break;
			
		case 4:
			s4.add(item);
			break;
			
		case 5:
			s5.add(item);
			break;
			
		case 6:
			s6.add(item);
			break;
			
		case 7:
			s7.add(item);
			break;
			
		case 8:
			s8.add(item);
			break;
			
		case 9:
			s9.add(item);
			break;
			
		case 10:
			s10.add(item);
			break;	
		}
	}

	public boolean contains(int item) {

		
		int remainder = item % 11;
		
		switch(remainder) {
		
		case 0:
			if(!s0.isEmpty())
				return s0.search(item);
		
		case 1:
			if(!s1.isEmpty())
				return s1.search(item);
		
		case 2:
			if(!s2.isEmpty())
				return s2.search(item);
			
		case 3:
			if(!s3.isEmpty())
				return s3.search(item);
			
		case 4:
			if(!s4.isEmpty())
				return s4.search(item);
			
		case 5:
			if(!s5.isEmpty())
				return s5.search(item);
			
		case 6:
			if(!s6.isEmpty())
				return s6.search(item);
			
		case 7:
			if(!s7.isEmpty())
				return s7.search(item);
			
		case 8:
			if(!s8.isEmpty())
				return s8.search(item);
			
		case 9:
			if(!s9.isEmpty())
				return s9.search(item);
		
		case 10:
			if(!s10.isEmpty())
				return s10.search(item);
		}
		return false;
	}

	public void pop(int item) {

		int remainder = item % 11;
		
		switch(remainder) {
		
		case 0:
			s0.remove(item);
			break;
		
		case 1:
			s1.remove(item);
			break;
		
		case 2:
			s2.remove(item);
			break;
			
		case 3:
			s3.remove(item);
			break;
			
		case 4:
			s4.remove(item);
			break;
			
		case 5:
			s5.remove(item);
			break;
			
		case 6:
			s6.remove(item);
			break;
			
		case 7:
			s7.remove(item);
			break;
			
		case 8:
			s8.remove(item);
			break;
			
		case 9:
			s9.remove(item);
			break;
			
		default:
			s10.remove(item);
			break;	
		}
	}

	public int[] getAll() {

		int[] a = new int[s0.size() + s1.size() + s2.size() + s3.size() + s4.size() + s5.size()
			+ s6.size() + s7.size() + s8.size() + s9.size() + s10.size()];
		int i = 0;
		while(!s0.isEmpty()) {
			a[i] = s0.pop(0);
			i++;
		}
		while(!s1.isEmpty()) {
			a[i] = s1.pop(0);
			i++;
		}
		while(!s2.isEmpty()) {
			a[i] = s2.pop(0);
			i++;
		}
		while(!s3.isEmpty()){
			a[i] = s3.pop(0);
			i++;
		}
		while(!s4.isEmpty()) {
			a[i] = s4.pop(0);
			i++;
		}
		while(!s5.isEmpty()) {
			a[i] = s5.pop(0);
			i++;
		}
		while(!s6.isEmpty()) {
			a[i] = s6.pop(0);
			i++;
		}
		while(!s7.isEmpty()) {
			a[i] = s7.pop(0);
			i++;
		}
		while(!s8.isEmpty()) {
			a[i] = s8.pop(0);
			i++;
		}
		while(!s9.isEmpty()) {
			a[i] = s9.pop(0);
			i++;
		}
		while(!s10.isEmpty()) {
			a[i] = s10.pop(0);
			i++;
		}
		
		return a;
	}

}
