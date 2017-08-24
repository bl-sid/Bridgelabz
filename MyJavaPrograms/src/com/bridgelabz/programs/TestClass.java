package com.bridgelabz.programs;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyOrderedList<Integer> ol = new MyOrderedList<Integer>();
		ol.add(5);
		ol.add(1);
		ol.add(4);
		ol.add(3);
		ol.add(0);
		ol.list();
		
		System.out.println();
		
		/*OrderedList<String> o = new OrderedList<String>();
		o.add("hello");
		o.add("this");
		o.add("is");
		o.add("an");
		o.add("ordered");
		o.add("list");
		o.list();*/
	}

}
