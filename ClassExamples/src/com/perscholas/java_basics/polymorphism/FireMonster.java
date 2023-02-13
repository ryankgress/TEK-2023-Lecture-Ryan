package com.perscholas.java_basics.polymorphism;

public class FireMonster extends Monster {
	
	public FireMonster(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String attack() {
		return (this.getName() + " Attacks with Fire!");
	}
}
