package com.tek.java.coffee;

public class CoffeeMain {

	public static void main(String[] args) {
		CoffeeShop cs = new CoffeeShop();
		cs.initialize();
		
		while(true) {
			int select = cs.menuPrompt();
			
			if(select == CoffeeShop.PRINT_MENU) {
				cs.printMenuItems();
			} else if(select == CoffeeShop.ORDER_ITEM) {
				cs.orderItem();
			} else if(select == CoffeeShop.VIEW_CART) {
				cs.viewCart();
			} else if(select == CoffeeShop.EXIT) {
				System.out.println("\nThank you for coming. Have a nice day!");
				cs.close();
				System.exit(0);
			}
		}
		
		
	}

}
