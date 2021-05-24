package com.ss.utop.menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.ss.utop.entity.Route;
import com.ss.utop.service.AdminService;

public class AdminRoutes {
	
	private Route r = new Route();
	private AdminService service = new AdminService();
	
	public void performNextRoute() throws SQLException
	{
		Scanner input = new Scanner(System.in);
		String choice = input.nextLine();
		
		//uses if else statements instead of switch because it allows the user to type single letters and ignore case
		if(choice.equalsIgnoreCase("add") || choice.equalsIgnoreCase("a"))
		{
			addNewRoute();
		}
		else if(choice.equalsIgnoreCase("update") || choice.equalsIgnoreCase("u"))
		{
			updateRoute();
		}
		else if(choice.equalsIgnoreCase("delete") || choice.equalsIgnoreCase("d"))
		{
			deleteRoute();
		}
		else if(choice.equalsIgnoreCase("read") || choice.equalsIgnoreCase("r"))
		{
			readAllRoutes();
		}
		else if(choice.equalsIgnoreCase("quit") || choice.equalsIgnoreCase("q"))
		{
			System.out.println("Quitting");
		}
		else
		{
				System.out.println("That is not a valid option. \nPlease enter \"add\", \"update\", \"delete\", \"read\", or \"quit\"");
				performNextRoute();
		}
		input.close();
	}
	
	private void addNewRoute() throws SQLException
	{
		Scanner input = new Scanner(System.in);
		//input everything that is required by the flights table (ids, time, etc)
		//then add everything to the array list and call the function from admin service to show it all
		System.out.println("\nADD to Routes\n");
		System.out.println("What is the origin?");
		String org = input.nextLine();
		
		if(org.length() != 3)
		{
			System.out.println("Error, each airport code has to have 3 letters");
			input.close();
			throw new IllegalArgumentException();
		}
		
		System.out.println("What is the destination?");
		String des = input.nextLine();
		
		if(des.length() != 3)
		{
			System.out.println("Error, each airport code has to have 3 letters");
			input.close();
			throw new IllegalArgumentException();
		}
		
		r.getId();
		r.getOrgAirport().setAirportCode(org);
		r.getDesAirport().setAirportCode(des);
		
		service.addNewRoute(r);
	
		input.close();
	}
	
	//update flights
	private void updateRoute() throws SQLException
	{
		try {
		Scanner input = new Scanner(System.in);
		
		service.readAllRoutes();
		
		System.out.println("UPDATE Routes");
		System.out.println("Enter route ID");
		int id = Integer.parseInt(input.nextLine());
		r.setId(id);
		
		System.out.println("What is the origin?");
		String org = input.nextLine();
		
		if(org.isEmpty() == false)
		{
			r.getOrgAirport().setAirportCode(org);
			service.updateRouteOrg(r);
		}
		
		System.out.println("What is the destination?");
		String des = input.nextLine();
		
		if(des.isEmpty()==false)
		{
			r.getDesAirport().setAirportCode(des);
			service.updateRouteDes(r);
		}
				
		input.close();
		Main.run();
		}catch(NumberFormatException e)
		{
			System.out.println("You have entered a non number");
		}
	}
	
	//this will delete flights based on an ID
	private void deleteRoute() throws SQLException
	{
		try {
		Scanner input = new Scanner(System.in);
		service.readAllRoutes();
		
		System.out.println("DELETE Routes");
		System.out.println("Route code to delete?");
		int id = Integer.parseInt(input.nextLine());
		
		service.deleteRoute(id);
		input.close();
		}catch(NumberFormatException e)
		{
			System.out.println("You have entered a non number");
			Main.run();
		}
	}
	
	//this will call the readAllRoutes method to print all flights
	private void readAllRoutes() throws SQLException
	{
		service.readAllRoutes();
	}
}
