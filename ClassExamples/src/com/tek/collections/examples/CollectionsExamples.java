package com.tek.collections.examples;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionsExamples {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		
		set.add("element1");
		set.add("element2");
		set.add("element3");
		set.add("element1");

		// Adding element1 twice overrides, as no duplicates allowed in Set
		for(String e : set) {
			System.out.print(e + " : ");
		}
		
		List<String> list = new ArrayList<String>();
		
		list.add("element1");
		list.add("element2");
		list.add("element3");
		list.add("element1");
		
		System.out.println("\n");
		
		// Will store the last element since duplicates are allowed. 
		for(String e : list) {
			System.out.print(e + " : ");
		}
	}

}
