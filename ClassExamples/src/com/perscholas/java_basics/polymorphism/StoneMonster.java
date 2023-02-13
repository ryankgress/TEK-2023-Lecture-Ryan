package com.perscholas.java_basics.polymorphism;

public class StoneMonster extends Monster {
	
	public StoneMonster(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String attack() {
		return (this.getName() + " Attacks with Stones!");
	}

}
