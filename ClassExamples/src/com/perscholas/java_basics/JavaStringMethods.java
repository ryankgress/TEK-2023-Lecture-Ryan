package com.perscholas.java_basics;

import java.util.Arrays;
import java.util.StringJoiner;

public class JavaStringMethods {

	public static void main(String[] args) {
		String str1 = "Java";
		String str2 = "";
		
		System.out.println(str1.length());
		System.out.println(str2.length());
		System.out.println("Java".length());
		System.out.println("Java\n".length());
		System.out.println("Learn Java".length());
		
		// isEmpty()
		System.out.println("\n");
		
		String s1 = "";
		String s2 = "hello";
		System.out.println(s1.isEmpty());
		System.out.println(s2.isEmpty());
		
		// Trim()
		System.out.println("\n");
		
		s1 = "  hello  ";
		System.out.println(s1 + " how are you");
		System.out.println(s1.trim() + " how are you");

		// toLowerCase() & toUpperCase()
		System.out.println("\n");
		
		s1 = "HELLO HOW Are You?";
		String s1Lower = s1.toLowerCase();
		System.out.println(s1Lower);
		
		System.out.println(s1Lower.toUpperCase());
		
		// concat()
		System.out.println("\n");
		
		str1 = "Learn ";
		str2 = "Java";
		
		System.out.println(str1.concat(str2));
		System.out.println(str2.concat(str1));
		
		String s3 = "hello";
		String s4 = "Learners";
		String s5 = s3 + s4;
		
		String message = "Welcome " + "to " + "Java";
		String s = "Chapter" + 2;
		s1 = "Supplement" + "B";
		
		// split()
		System.out.println("\n");
		
		String vowels = "a::b::c::d:e";
		String[] result = vowels.split("::");
		
		System.out.println("result = " + Arrays.toString(result));
		
		// charAt() & compareTo()
		System.out.println("\n");
		
		message = "Welcome to Java";
		System.out.println("The first character is " + message.charAt(0));
		
		s1 = s2 = "hello";
		s3 = "hemlo";
		s4 = "flag";
		
		System.out.println(s1.compareTo(s2));	// s1 = s2, so 0
		System.out.println(s1.compareTo(s3));	// s1 < s3, so negative number (-1)
		System.out.println(s1.compareTo(s4));	// S1 > S4, so positive number (2)
		
		// substring() & indexOf()
		System.out.println("\n");
		
		str1 = "java is fun";
		System.out.println(str1.substring(0,4));
		
		str1 = "Java is fun";
		
		int iResult = str1.indexOf('s');
		System.out.println(iResult);
		
		iResult = str1.lastIndexOf('J');
		System.out.println(iResult);
		
		iResult = str1.lastIndexOf('a');
	    System.out.println(iResult); // 3

	    iResult = str1.lastIndexOf('j');
	    System.out.println(iResult); // -1

	       
	    iResult = str1.lastIndexOf("ava");
	    System.out.println(iResult); // 1

	    iResult = str1.lastIndexOf("java");
	    System.out.println(iResult); // -1
		
	    // contains() & replace()
	    System.out.println("\n");
	    
	    str1 = "Learn Java";
	    System.out.println(str1.contains("Java"));
	    System.out.println(str1.contains("Python"));
	    System.out.println(str1.contains(""));
	    
	    str1 = "abc cba";
	    
	    System.out.println(str1.replace('a','z'));	// replace a's with z's
	    System.out.println("Hello".replace('4', 'J'));
	    
	    System.out.println("aa bb aa zz".replace("aa", "zz"));
	    
	    // equals() vs ==
	    System.out.println("\n");
	    
	    s1 = "PerScholas";
	    s2 = "PerScholas";
	    s5 = new String("PerScholas");
	    s4 = "Teksystem";
	    
	    System.out.println(s1.equals(s2));	//true
	    System.out.println(s1.equals(s5));	//true 
	    System.out.println(s1.equals(s4));	//false

	    // Only is true if same instance, rather than value
	    System.out.println(s1==s2);
	    System.out.println(s1==s3);
	    
	    // compareTo()
	    System.out.println("\n");
	    
	    s3 = "PerScholas";
	    
	    System.out.println(s1.compareTo(s2));	
	    System.out.println(s1.compareTo(s3));	
	    System.out.println(s3.compareTo(s1));	
	    
	    StringJoiner joinNames = new StringJoiner(",");
	    
	    joinNames.add("Java");
	    joinNames.add("Python");
	    joinNames.add("HTML");
	    joinNames.add("JavaScript");
	    
	    System.out.println("\nNew String: " + joinNames);
	    
	}

}










