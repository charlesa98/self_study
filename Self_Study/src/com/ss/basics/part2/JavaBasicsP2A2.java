package com.ss.basics.part2;

/**
 * @author Charles Alms 
 *
 */
public class JavaBasicsP2A2 {
	/**
	 * the main part of the program that calculates the totals from numbers
	 * that the user has entered
	 */
	public static void main(String[] args) {
		int total=0, number = 0;
		for(int i =0; i<args.length; i++)
		{
			try {
				number = Integer.parseInt(args[i]);
				total += number;
			}
			catch (NumberFormatException e) {			//this is to check if the user entered numbers or non numbers
				System.out.println("Found an unknown number but will continue to add those that are numbers");
			}
		}
		System.out.println("The total is "+total);
	}
}