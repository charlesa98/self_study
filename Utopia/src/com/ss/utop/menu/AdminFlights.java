package com.ss.utop.menu;

import java.sql.SQLException;
import java.util.Scanner;

/*
 * This class will call another menu class depending on what part of the flights category the user wants to change
 */

public class AdminFlights {
	static Boolean exit = false;
	
	public void header()
	{
		System.out.println("Which flight option would you like to perform?");
		System.out.println("1) ADD/UPDATE/DELETE/READ Flights \n"+
		"2) ADD/UPDATE/DELETE/READ Routes \n"+ "3) ADD/UPDATE/DELETE/READ Airplanes \n"+
				"4) ADD/UPDATE/DELETE/READ Airplane Types\n");
	}
	private void header2()
	{
		System.out.println("ADD/UPDATE/DELETE/READ");
	}
	
	public void run() throws SQLException
	{
			header();
			int choice = getInput();
			performNext(choice);
	}
	
	private int getInput()
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
				System.out.println("That is not a valid option. \nPlease enter 1, 2 or 3");
			}
		}
		input.close();
		return choice;
	}
	
	public void performNext(int choice) throws SQLException {
		header2();
		switch(choice)
		{
		case 1:
			AdminFlights2 af2 = new AdminFlights2();
			//calls the AdminFlights2 class
			af2.performNext();
			break;
		case 2:
			AdminRoutes ar = new AdminRoutes();
			//calls the AdminRoutes class
			ar.performNextRoute();
			break;
		case 3:
			AdminAirplanes aPlanes = new AdminAirplanes();
			//calls the AdminAirplanes class
			aPlanes.performNext();
			break;
		case 4:
			AdminAirplaneType apt = new AdminAirplaneType();
			//calls the AdminAirplaneType class
			apt.performNext();
			break;	
		}
		
	}
}
