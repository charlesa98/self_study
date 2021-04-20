package com.ss.basics.part1;

/**
 * This assignment is to print 4 shapes with *
 */

/**
 * @author Charles
 *
 */
public class JavaBasics1 {
	
	//this will print the half pyramid from smallest to largest
	//takes in 1 int for the amount of rows
	public static void printHalfPyramid(int n)
	{
		
		System.out.println("1)");
		//control for the amount printed
		for(int i =0; i<n; i++)
		{
			//prints *			
			for(int j =0; j<=i; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println(".........");
	}
	
	//this will print the half pyramid from largest to smallest
	//takes in 1 int for the amount of rows
	public static void printHalfPyramidLarge(int n)
	{
			
			System.out.println("2)");
			System.out.println("..........");
			//control for the amount printed
			for(int i =n; i>=0; i--) {
				//prints *
				for(int j =0; j<i; j++)
				{
					System.out.print("*");
				}
				System.out.println();
			}
		}
	
	//this will print the full pyramid normally
	//takes in 1 int for the amount of rows
	public static void printPyramid(int n)
	{
		System.out.println("3)");
		//main control for building it
		for(int i=0; i<n; i++)
		{
			//for printing white spaces
			for(int s=n-i; s>-1; s--)
			{
				System.out.print(" ");
			}
			//prints the *
			//needs to be j<=i*2 because 2 more * get added every row
			for(int j=0; j<=i*2; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("...........");
	}
	
	//this will print the full pyramid upside down
	//takes in 1 int for the amount of rows
	public static void printPyramidUpsideDown(int n)
	{
		System.out.println("4)");
		System.out.println("............");	
		//main control for building it
		for(int i=n-1; i>=0; i--)
		{
			//for printing white spaces
			for(int s=n-i; s>-1; s--)
			{
				System.out.print(" ");
			}
			//prints the *
			//needs to be j<=i*2 because 2 more * get added every row
			for(int j=0; j<=i*2; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
		
	/**
	 * the main program to run. Only will call the methods to build the pyramids
	 */
	public static void main(String[] args) {
		
		printHalfPyramid(4);
		printHalfPyramidLarge(4);
		printPyramid(4);
		printPyramidUpsideDown(4);
	}

}
