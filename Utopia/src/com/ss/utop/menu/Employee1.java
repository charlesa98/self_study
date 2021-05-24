package com.ss.utop.menu;

import java.sql.SQLException;
import java.util.Scanner;

public class Employee1 {
	public void header1()
	{
		System.out.println("Welcome Employee. Which option would you like to perform?");
		System.out.println("1) Enter Flights you manage \n"+"2) Return to previous menu ");
	}
	
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
	//AS OF NOW< ONLY THE ADMIN CLASS WORKS
	private void performAction(int choice) throws SQLException
	{
		switch(choice)
		{
			case 1:
				System.out.println("\nEntering your flights");
				Employee2 e2 = new Employee2();
				e2.run();
				break;
				
			case 2:
				//open employee menu 1
				System.out.println("Returning to main menu\n\n");
				Main.run();
				break;
				
			default:
				System.out.println("That is not a valid option. \nPlease enter a number between 1 and 2");
		}				
	}
}
