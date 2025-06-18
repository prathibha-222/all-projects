package com.example;

public class Dog {
	int legs=4; // instance variable
	void eat() //instance method 
	{
		System.out.println("Eats Bones");
	}
	public static void main(String[] args) {
		Dog d = new Dog();  // creating object
		d.eat();   // calling reference
		System.out.println("Dog has " + d.legs + " legs");
	}

}
