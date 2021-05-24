package com.ss.utop.menu;

import java.sql.SQLException;
import java.util.Scanner;

/*
 * The first of the admin options. Displays all of what the admin can do
 */

public class Admin1{
	private AdminFlights adF = new AdminFlights();
	private AdminAirport aap = new AdminAirport();
	//private AdminSeats aseats = new AdminSeats();
	//private AdminTickets tickets = new AdminTickets();
	private AdminTravelers travelers = new AdminTravelers();
	private AdminEmployees ame = new AdminEmployees();

	public void header1()
	{
		System.out.println("Welcome Admin. Which option would you like to perform?");
		System.out.println("1) ADD/UPDATE/DELETE/READ Flights \n"+
		"2) ADD/UPDATE/DELETE/READ Seats \n"+ "3) ADD/UPDATE/DELETE/READ Tickets and Passengers \n"+
		"4) ADD/UPDATE/DELETE/READ Airports \n" + "5) ADD/UPDATE/DELETE/READ Travelers\n" + "6) ADD/UPDATE/DELETE/READ Employees \n"
				+ "7) Over-ride Trip Cancellation for a ticket \n" +"8) Go back to main menu\n");
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
		while(choice > 0 || choice < 9)
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
	//AS OF NOW< ONLY THE ADMIN CLASS WORKS
	private void performAction(int choice) throws SQLException
	{
		switch(choice)
		{
			case 1:
				System.out.println("\nADD/UPDATE/DELETE/READ Flights");
				//calls the AdminFlights class
				adF.run();
				break;
				
			case 2:
				//open employee menu 1
				System.out.println("ADD/UPDATE/DELETE/READ Seats");
				
				break;
				
			case 3:
				//open traveler menu 1
				System.out.println("ADD/UPDATE/DELETE/READ Tickets and Passengers");

				break;
				
			case 4:
				System.out.println("\nADD/UPDATE/DELETE/READ Airports");
				//calls the AdminAirport class
				aap.performNext();
				break;
				
			case 5:
				//open employee menu 1
				System.out.println("ADD/UPDATE/DELETE/READ Travelers");
				travelers.performNext();
				break;
				
			case 6:
				//open traveler menu 1
				System.out.println("ADD/UPDATE/DELETE/READ Employees");
				ame.performNext();
				break;	
				
			case 7:
				//open traveler menu 1
				System.out.println("Over-ride Trip Cancellation for a ticket");
				
				break;		
				
			case 8:
				System.out.println("Exiting");
				Main.run();
				break;
				
			default:
				System.out.println("That is not a valid option. \nPlease enter a number between 1 - 8");
		}				
	}
}
