package com.perscholas.java_basics.polymorphism;

public class WaterMonster extends Monster{
	
	public WaterMonster(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String attack() {
		return (this.getName() + " Attacks with Water!");
	}
}
