package com.example;

import java.util.Scanner;

public class Ex2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//System.out.println("Enter your name");
		//String name = sc.nextLine();
		//System.out.println("Hai " + name + " Welcome to Mphasis");
		
		System.out.println("Enter a number");
		int n1 = sc.nextInt();
		System.out.println("Enter another number");
		int n2 = sc.nextInt();
		System.out.println("The addition of " +n1 + " and " +n2 + " is " +(n1+n2));
		
	}

}
