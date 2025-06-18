package com.example;

public class Calculator {
	void square (int x)
	{
		int result = x*x;
		System.out.println("Square is " + result);
	}
    static void add(int x, int y) 
    {
    	System.out.println("The addition of " + x + " and " + y + " is " + (x+y));
    }
    int cube(int x)
    {
    	return(x*x*x);
    }
    public static void main(String[] args) {
		Calculator c = new Calculator();
		c.square(5);
		add(22, 33);
		int output = c.cube(5);
		System.out.println(output);
	}
}
