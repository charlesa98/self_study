package com.ss.lib.menus;

import java.sql.SQLException;
import java.util.Scanner;

import com.ss.lib.service.AdminBorrowers;
import com.ss.lib.service.AdminLibraryBranches;
import com.ss.lib.service.AdminLoan;
import com.ss.lib.service.AdminPublisher;

/*
 * The first of the admin options. Displays all of what the admin can do
 * 
 * Main -> Admin1
 */

public class Admin1{
	static Boolean exit = false;

	public void header1()
	{
		System.out.println("Welcome Admin. Which option would you like to perform?");
		System.out.println("1) ADD/UPDATE/DELETE/READ Book and Author \n"+
		"2) ADD/UPDATE/DELETE/READ Publishers \n"+ "3) ADD/UPDATE/DELETE/READ Library Branches \n"+
		"4) ADD/UPDATE/DELETE/READ Borrowers \n" + "5) Over-ride Due Date for a Book Loan\n"+"6) Go back to main menu\n");
	}
	
	//runs the admin class
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
		while(choice > 0 || choice < 7)
		{
			try {
				choice = Integer.parseInt(input.nextLine());
				return choice;
			}catch (NumberFormatException e)
			{
				System.out.println("That is not a valid option. \nPlease enter a number between 1 and 8");
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
				//calls the AdminBookAutor class
				AdminBookAuthor ba = new AdminBookAuthor();
				ba.run();
				break;
				
			case 2:
				//calls the AdminPublisher class
				AdminPublisher ap = new AdminPublisher();
				ap.performNext();
				break;
				
			case 3:
				//calls the AdminLibraryBranches class
				AdminLibraryBranches alb = new AdminLibraryBranches();
				alb.performNext();

				break;
				
			case 4:
				//calls the AdminBorrowers class
				AdminBorrowers aborw = new AdminBorrowers();
				aborw.performNext();
				
				break;
				
			case 5:
				//calls the AdminLoan class
				AdminLoan al = new AdminLoan();
				al.performNext();

				break;	
				
			case 6:
				//goes back to the main menu
				System.out.println("Going back to main menu\n");
				Main.run();
				break;
				
			default:
				System.out.println("That is not a valid option. \nPlease enter a number between 1 - 6");
		}				
	}
}
