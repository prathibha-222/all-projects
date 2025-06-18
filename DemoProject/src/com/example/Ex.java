package com.example;

import javax.swing.JOptionPane;

public class Ex {
	public static void main(String[] args) {
		/*String n1 = JOptionPane.showInputDialog("Enter a number");
		String n2 = JOptionPane.showInputDialog("Enter another number");
		int a= Integer.parseInt(n1);
		int b = Integer.parseInt(n2);
		JOptionPane.showMessageDialog(null, "The addition of " + n1 + " and " + n2 +" is "+ (a+b)); */
		
		int n = Integer.parseInt(JOptionPane.showInputDialog("Enter a number"));
		
		String result = (n % 2 == 0) ? "Even" : "Odd";
		
		JOptionPane.showMessageDialog(null, "The number " + n +" is " + result);
		
		
		
		
		
	}

}
