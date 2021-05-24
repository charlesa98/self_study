package com.ss.utop.menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.ss.utop.entity.AirplaneType;
import com.ss.utop.service.AdminService;

public class AdminAirplaneType {
	private AdminService service = new AdminService();
	private AirplaneType atype = new AirplaneType();

	public void performNext() throws SQLException 
	{
		Scanner input = new Scanner(System.in);
		String choice = input.nextLine();
		
		//uses if else statements instead of switch because it allows the user to type single letters and ignore case
		if(choice.equalsIgnoreCase("add") || choice.equalsIgnoreCase("a"))
		{
			addNewAirplaneType();
		}
		else if(choice.equalsIgnoreCase("update") || choice.equalsIgnoreCase("u"))
		{
			updateAirplaneType();
		}
		else if(choice.equalsIgnoreCase("delete") || choice.equalsIgnoreCase("d"))
		{
			deleteAirplaneType();
		}
		else if(choice.equalsIgnoreCase("read") || choice.equalsIgnoreCase("r"))
		{
			readAllAirplaneTypes();
		}
		else if(choice.equalsIgnoreCase("quit") || choice.equalsIgnoreCase("q"))
		{
			System.out.println("Quitting");
		}
		else
		{
				System.out.println("That is not a valid option. \nPlease enter \"add\", \"update\", \"delete\", \"read\", or \"quit\"");
				performNext();
		}
		input.close();
	}

	private void addNewAirplaneType() throws SQLException
	{
		try {
		Scanner input = new Scanner(System.in);
		//input everything that is required by the flights table (ids, time, etc)
		//then add everything to the array list and call the function from admin service to show it all
		System.out.println("\nADD to AirplaneTypes\n");
	
		System.out.println("Max capacity of airplane?");
		int cap = Integer.parseInt(input.nextLine());
		
		atype.getId();
		atype.setCapacity(cap);
		
		service.addNewAirplaneType(atype);
	
		input.close();
		}catch(NumberFormatException e)
		{
			System.out.println("You have entered a non number");
		}
	}
	
	//update flights
	private void updateAirplaneType() throws SQLException
	{
		try {
		Scanner input = new Scanner(System.in);
		System.out.println("UPDATE AirplaneTypes");
		System.out.println("ID of the type?");
		int id = Integer.parseInt(input.nextLine());
		
		System.out.println("Max capacity?");
		int type = Integer.parseInt(input.nextLine());
		
		atype.setId(id);
		atype.setCapacity(type);
		
		service.updateAirplaneType(atype);
		input.close();
		}catch(NumberFormatException e)
		{
			System.out.println("You have entered a non number");
		}
	}
	
	//this will delete flights based on an ID
	private void deleteAirplaneType() throws SQLException
	{
		try {
		Scanner input = new Scanner(System.in);
		
		System.out.println("DELETE AirplaneTypes");
		System.out.println("AirplaneType ID to delete?");
		int id = Integer.parseInt(input.nextLine());
		
		service.deleteAirplaneType(id);
		input.close();
		}catch(NumberFormatException e)
		{
			System.out.println("You have entered a non number");
		}
	}
	
	//this will call the readAllAirplaneTypeTypes method to print all flights
	private void readAllAirplaneTypes() throws SQLException
	{
		service.readAllAirplaneTypes();
	}
}
