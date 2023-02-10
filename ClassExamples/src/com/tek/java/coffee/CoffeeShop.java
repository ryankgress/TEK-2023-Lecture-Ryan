package com.tek.java.coffee;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Will contain all functionality for working with our coffee shop. 
 * @author Ryan Gress
 *
 */
public class CoffeeShop {
	
	private Scanner keyboard = new Scanner(System.in);
	public static final int PRINT_MENU = 1;
	public static final int EXIT = 0;
	public static final int ORDER_ITEM = 2;
	
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
		
		System.out.println("\n==============================================");
		System.out.println("Item Name\t\tStock\t\tPrice");
		System.out.println("-----------------------------------------------");
		
		for( MenuItem item : menuItems) {
			System.out.println(item.getName() + "      \t" + item.getInStock() + "\t\t$" + moneyFormat.format(item.getPrice()));
		}
		System.out.println("==============================================\n");
	}
	
	public int menuPrompt() {
		
		System.out.println("Welcome to Ryan's Coffee Shop.\n");
		System.out.println("   " + PRINT_MENU + ") Print Menu");
		System.out.println("   " + ORDER_ITEM + ") Order Item");
		System.out.println("   " + EXIT		  + ") Exit Coffee Shop");
		System.out.print("\nMake Selection: ");
		
		int selection = keyboard.nextInt();
		
		return selection;
	}
	
	public void orderItem() {
		printMenuItems();
		
		System.out.print("Enter Item Name: ");
		keyboard.nextLine();
		String itemName = keyboard.nextLine();
		
		if(menuItemExists(itemName)) {
			System.out.println("\n" + itemName + " is valid.");
		} else {
			System.out.println(itemName + " is not a valid selection");
		}
	}
	
	private boolean menuItemExists(String itemName) {
		
		// Check to make sure the entered item is on the menu
		for( MenuItem item : menuItems) {
			if(item.getName().equalsIgnoreCase(itemName)) {
				return true;
			}
		}
		return false;
	}
	
	public void close() {
		keyboard.close();
	}
}







