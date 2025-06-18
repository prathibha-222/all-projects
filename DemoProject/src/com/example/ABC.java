package com.example;

public class ABC {
	public static void main(String[] args) {
		Dog dog = new Dog();
		System.out.println(dog.legs);
		dog.eat();
		Calculator c1 = new Calculator();
		System.out.println(c1.cube(3));
		Bank bank = new Bank();
		System.out.println("First Object "+ bank.amount);
	}

}
