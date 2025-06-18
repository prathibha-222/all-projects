package com.example;

import javax.swing.JOptionPane;

public class Ex1 {
	public static void main(String[] args) {
		int n = Integer.parseInt(JOptionPane.showInputDialog("Enter a number"));
		
		boolean isPrime = true;
		
		
		if (n <= 1) 
		{
	        isPrime = false; 
	    } 
		else 
		{
	        for (int i = 2; i <= Math.sqrt(n); i++) 
	        {
	            if (n % i == 0) 
	            {
	                isPrime = false;
	                break;
	            }
	        }
	    }
		
		
		String result = isPrime ? "Prime" : "Not Prime";
		
		JOptionPane.showMessageDialog(null,"The number " + n +" is " + result);
		
	}
	
}
