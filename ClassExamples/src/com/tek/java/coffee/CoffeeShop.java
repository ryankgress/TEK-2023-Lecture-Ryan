package com.tek.java.coffee;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Will contain all functionality for working with out coffee shop. 
 * @author Ryan Gress
 *
 */
public class CoffeeShop {
	
	private List<MenuItem> menuItems = new ArrayList<>();
	
	public void initialize() {
		MenuItem item1 = new MenuItem();
		item1.setName("Small Coffee");
		item1.setPrice(4.30);
		
		MenuItem item2 = new MenuItem();
		item2.setName("Large Coffee");
		item2.setPrice(5.99);
		
		menuItems.add(item1);
		menuItems.add(item2);
	}
	
	public void printMenuItems() {
		String t = "###,###.00";
		DecimalFormat moneyFormat = new DecimalFormat(t);
		
		for( MenuItem item : menuItems) {
			System.out.println(item.getName() + "\t$" + moneyFormat.format(item.getPrice()));
		}
	}
}
