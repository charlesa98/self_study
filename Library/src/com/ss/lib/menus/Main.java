package com.ss.lib.menus;

import java.sql.SQLException;
import java.util.Scanner;

//main menu 
public class Main {
	//static Boolean exit = false;			//use later 
	
	//prints the headers for the starting menu
	private static void headerMain()
	{
		System.out.println("Welcome to the GCIT Library Management System. Which category of a user are you?\n");
		System.out.println("1) Librarian \n2) Administrator \n3) Borrower \n4) Exit \n");
	}
	
	//gets the users input to see if it is valid
	private static int getInput() throws SQLException
	{
		Scanner input = new Scanner(System.in);
		int choice = -1;
		while(choice > 0 || choice < 5)
		{
			try {
				choice = Integer.parseInt(input.nextLine());
				return choice;
			}catch (NumberFormatException e)
			{
				System.out.println("That is not a valid option. \nPlease enter 1, 2, 3 or 4");
			}
		}
		input.close();
		return choice;
	}
	
	//calls the header and gets the users input. then decides which class to go to depending on the input
	public static void run() throws SQLException
	{
		headerMain();				//prints the header
		int choice = getInput();	//checks if the input is valid
		
		switch(choice)
		{
			case 1:
				//open the librarian menu 1

				Lib1 lib1 = new Lib1();
				lib1.run();
				
				break;
				
			case 2:
				//open the Admin menu 1

				//opens the first admin menu
				Admin1 ad1 = new Admin1();
				ad1.run();
				
				break;
				
			case 3:
				//open traveler menu 1
				Bow1 bow1 = new Bow1();
				bow1.run();

				break;
				
			case 4:			
				System.out.println("Exiting");
				System.exit(0);
				break;
				
			default:
				System.out.println("That is not a valid option. \nPlease enter 1, 2 or 3");
		}
	}
	
	public static void main(String[] args) throws SQLException  {
		Main.run();			//starts the program
	}
}
