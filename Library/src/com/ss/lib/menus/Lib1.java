package com.ss.lib.menus;

import java.sql.SQLException;
import java.util.Scanner;

public class Lib1 {
	
	public void header1()
	{
		System.out.println("Welcome Librarian. Which option would you like to perform?");
		System.out.println("1) Enter Branch you manage\n"+"2) Go back to main menu\n");
	}
	
	//runs the lib1 class
	public void run() throws SQLException
	{
			header1();
			int choice = getInput();
			performAction(choice);
	}

	private int getInput()
	{
		Scanner input = new Scanner(System.in);
		int choice = -1;
		while(choice > 0 || choice < 3)
		{
			try {
				choice = Integer.parseInt(input.nextLine());
				return choice;
			}catch (NumberFormatException e)
			{
				System.out.println("That is not a valid option. \nPlease enter a number between 1 and 2");
			}
		}
		input.close();
		return choice;
	}
	
	//gets the input and determines where to go next
	private void performAction(int choice) throws SQLException
	{
		switch(choice)
		{
		case 1:
			System.out.println("Lisitng all the branches");
			//this will give the user branches to go to
			Lib2 lib2 = new Lib2();
			lib2.run();
			break;
			
		case 2:
			System.out.println("Going back to main menu");
			//returns to the main menu
			Main.run();
			
			break;
			
		default:
			System.out.println("An error occured");
		}
	}
}
