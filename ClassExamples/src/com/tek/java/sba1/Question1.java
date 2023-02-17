package com.tek.java.sba1;

import java.util.ArrayList;
import java.util.List;


public class Question1 {
	private List<String> list = new ArrayList<String>();
	
	public static void main(String[] args) {
		Question1 q1 = new Question1();
		
		String[] arr = {"Hi","Hey","Hello","Ahoy","Yo"};
		
		q1.convert(arr);
		q1.replace(2);
		q1.compact();
		
		
	}
	
	/**
	 * Convert array of strings to a list of strings
	 * @param arr
	 */
	public void convert(String[] arr) {
		for(String hello : arr) {
			list.add(hello);
		}
		
		System.out.println(list.toString());
	}
	
	/**
	 * In an ArrayList, write the value at inx to an empty String
	 * Print a message saying what the value of the position in the list is and the value you're overwiting with
	 */
	public void replace(int inx) {
		list.remove(inx);
		list.add(inx,"");
		
		System.out.println(list.toString());
	}
	
	/**
	 * Remove all values in the arrList that are empty strings
	 */
	public void compact() {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).equals("")) {
				list.remove(i);
			}
		}
		
		System.out.println(list.toString());
	}

}
















