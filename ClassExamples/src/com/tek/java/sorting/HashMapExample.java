package com.tek.java.sorting;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {
		Map<String, String> strMap = new HashMap<>();
		strMap.put("key", "value");
		strMap.put("concat", "To add 2 strings together");
		strMap.put("intantiate", "to create a new object");
		
		
		Set<String> keySet = strMap.keySet();
		for(String key : keySet) {
			System.out.println(key + ":    \t" + strMap.get(key));
		}
		

	}

}
