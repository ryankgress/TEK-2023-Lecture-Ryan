package com.perscholas.java_basics;

public class JavaBasics {

	public static void main(String[] args) {
		int i = 4;
		int j = 5;
		int k = i + j;
		final int THREE = 3;
		
		double di = 4.0;
		double dj = 5.0;
		double dk = di + dj;
		
		double coffee = 3.50;
		double biscuit = 1.00;
		double cream = 0.25;
		double subtotal;
		double totalSale;
		final double SALES_TAX = 0.06;
		
		System.out.println(k);
		System.out.println(dk);
		System.out.println(j / i);
		System.out.println(dj / di);
		System.out.println((int)(dj / di));
		System.out.println(k + THREE);
		
		subtotal = (3 * coffee) + (4 * biscuit) + (2 * cream);
		totalSale = subtotal + (subtotal * SALES_TAX);
		System.out.printf("$%.2f", totalSale);
		
	}

}
