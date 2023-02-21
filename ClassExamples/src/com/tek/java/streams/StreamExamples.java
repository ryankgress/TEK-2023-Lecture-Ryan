package com.tek.java.streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExamples {

	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		names.add("Larry");
		names.add("Steven");
		names.add("Eric");
		names.add("Jessica");
		names.add("Ellen");
		
		// Sort the original names list by length
		// When length is the same, sort alphabetically
		List<String> tempNames = names;
		Collections.sort(tempNames);
		List<String> lengthList = names.stream()
				.sorted(Comparator.comparingInt(String::length))
				.collect(Collectors.toList());
		System.out.println(String.join("\n", lengthList) + "\n");
		System.out.println("=========================");
		
		
		
		
		List<String> sortedList = names.stream()
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		System.out.println(String.join("\n", sortedList) + "\n");
		
		System.out.println("=========================");
		
		// remove all names from the list that contain 'n'
		sortedList.removeIf(name -> name.contains("n"));
		System.out.println(String.join("\n", sortedList));

		System.out.println("=========================");
		
		sortedList.forEach(name -> System.out.println(name));
	}

}
