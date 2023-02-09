package com.tek.java.coffee;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Will contain all functionality for working with our coffee shop. 
 * @author Ryan Gress
 *
 */
public class CoffeeShop {
	
	private List<MenuItem> menuItems = new ArrayList<>();
	
	public void initialize() {
		MenuItem item1 = new MenuItem();
		item1.setName("Small Coffee");
		item1.setPrice(4.30);
		item1.setInStock(20);
		
		MenuItem item2 = new MenuItem();
		item2.setName("Large Coffee");
		item2.setPrice(5.99);
		item2.setInStock(75);
		
		MenuItem item3 = new MenuItem("Choc Chip Cookie", 4.25, 30);
		
		menuItems.add(item1);
		menuItems.add(item2);
		menuItems.add(item3);

		// Reducing the item addition to one line
		menuItems.add(new MenuItem("Egg Sandwich", 14.30, 10));
		
	}
	
	public void printMenuItems() {
		String t = "###,###.00";
		DecimalFormat moneyFormat = new DecimalFormat(t);
		
		System.out.println("Item\t\t\tStock\t\tPrice");
		
		for( MenuItem item : menuItems) {
			System.out.println(item.getName() + "      \t" + item.getInStock() + "\t\t$" + moneyFormat.format(item.getPrice()));
		}
	}
}
