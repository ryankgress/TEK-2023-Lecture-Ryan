package com.tek.java.coffee;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Will contain all functionality for working with our coffee shop. 
 * @author Ryan Gress
 *
 */
public class CoffeeShop {
	
	private Scanner keyboard = new Scanner(System.in);
	public static final int EXIT = 0;
	public static final int PRINT_MENU = 1;
	public static final int ORDER_ITEM = 2;
	public static final int VIEW_CART = 3;
	
	private List<MenuItem> menuItems = new ArrayList<>();
	private List<MenuItem> cart = new ArrayList<MenuItem>();
	
	/**
	 * Initializes the MenuItems in the Coffee Shop
	 */
	public void initialize() {
		MenuItem item1 = new MenuItem();
		item1.setName("Small Coffee");
		item1.setPrice(4.30);
		item1.setInStock(20);
		
		MenuItem item2 = new MenuItem();
		item2.setName("Large Coffee");
		item2.setPrice(5.99);
		item2.setInStock(75);
		
		MenuItem item3 = new MenuItem("Choc Chip Cookie", 3.25, 30);
		
		menuItems.add(item1);
		menuItems.add(item2);
		menuItems.add(item3);

		// Reducing the item addition to one line
		menuItems.add(new MenuItem("Egg Sandwich", 14.30, 10));
		
		// in-line addition of a Comparator functionality.
//		menuItems.sort(new Comparator<MenuItem>() {
//			@Override
//			public int compare(MenuItem o1, MenuItem o2) {
//				Double p1 = o1.getPrice();
//				Double p2 = o2.getPrice();
//				
//				return p1.compareTo(p2);
//			}
//		});
		
		// Single line implementation of above, using streams
		menuItems.sort(Comparator.comparing(MenuItem::getPrice));
	}
	
	/**
	 * Displays the menu 
	 */
	public void printMenuItems() {
		System.out.println("\n==============================================");
		System.out.println("Item Name\t\tStock\t\tPrice");
		System.out.println("----------------------------------------------");
		
		for( MenuItem item : menuItems) {
			System.out.println(item.getName() + "      \t" + item.getInStock() + "\t\t$" + formatPrice(item.getPrice()));
		}
		System.out.println("==============================================\n");
	}
	
	/**
	 * Displays the menu and prompts for a selection
	 * @return int matching the selection from the menu
	 */
	public int menuPrompt() {		
		System.out.println("Welcome to Ryan's Coffee Shop.\n");
		System.out.println("   " + PRINT_MENU + ") Print Menu");
		System.out.println("   " + ORDER_ITEM + ") Order Item");
		System.out.println("   " + VIEW_CART  + ") View Cart");
		System.out.println("   " + EXIT		  + ") Exit");
		System.out.print("\nMake Selection: ");
		
		int selection = PRINT_MENU;
		// Is now infinite looping on bad input. Work on this.
		try {
			selection = keyboard.nextInt();
			return selection;
		} catch(Exception e) {
			System.out.println("\nInvalid Input");
//			return PRINT_MENU;
		}
		
		return selection;
		
	}
	
	/**
	 * Right now, it just adds an item to the ArrayList 'cart' if findMenuItem confirms it matches
	 */
	public void orderItem() {
		printMenuItems();
		
		System.out.print("Enter Item Name: ");
		keyboard.nextLine();
		String itemName = keyboard.nextLine();
		
		if(findMenuItem(itemName) != null) {
			System.out.println("\n" + findMenuItem(itemName).getName() + " was added to cart.");
			cart.add(findMenuItem(itemName));
		} else {
			System.out.println(itemName + " was not found\n");
		}
	}
	
	/**
	 * Will print the cart into the console
	 */
	public void viewCart() {
		double totalPrice = 0;
		
		System.out.println("\nThere are " + cart.size() + " items in your Cart\n");
		System.out.println("==============================================");
		System.out.println("Item Name\t\tPrice\t\tTotal");
		System.out.println("----------------------------------------------");
		
		for( MenuItem item : cart) {
			totalPrice += item.getPrice();
			System.out.println(item.getName() + "      \t$" + formatPrice(item.getPrice()) +"      \t$" + formatPrice(totalPrice));
		}
		
		System.out.println("==============================================\n");
		System.out.println("Total Price: $" + formatPrice(totalPrice) + "\n");
	}
	
	/**
	 * Checks the list of menu items for the inputted item, case inensitive
	 * @param itemName User input
	 * @return null if not found, the matching MenuItem object if found
	 */
	private MenuItem findMenuItem(String itemName) {
		if(itemName == null) {
			return null;
		}
		
		for( MenuItem item : menuItems) {
			if(item.getName().equalsIgnoreCase(itemName.trim())) 
				return item;	
		}
		
		return null;
	}
	
	private String formatPrice(double price) {
		DecimalFormat moneyFormat = new DecimalFormat("###,###.00");
		return moneyFormat.format(price);
	}
	
	/**
	 * Closes the keyboard input stream
	 */
	public void close() {
		keyboard.close();
	}
}







