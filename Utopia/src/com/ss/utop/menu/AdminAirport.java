package com.ss.utop.menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.ss.utop.entity.Airport;
import com.ss.utop.service.AdminService;

public class AdminAirport {
	private AdminService service = new AdminService();
	Airport ap = new Airport();
	
	public void performNext() throws SQLException 
	{
		Scanner input = new Scanner(System.in);
		String choice = input.nextLine();
		
		//uses if else statements instead of switch because it allows the user to type single letters and ignore case
		if(choice.equalsIgnoreCase("add") || choice.equalsIgnoreCase("a"))
		{
			addNewAirport();
		}
		else if(choice.equalsIgnoreCase("update") || choice.equalsIgnoreCase("u"))
		{
			updateAirport();
		}
		else if(choice.equalsIgnoreCase("delete") || choice.equalsIgnoreCase("d"))
		{
			deleteAirport();
		}
		else if(choice.equalsIgnoreCase("read") || choice.equalsIgnoreCase("r"))
		{
			readAllAirports();
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
	
	private void addNewAirport() throws SQLException
	{
		
		Scanner input = new Scanner(System.in);		
		//input everything that is required by the flights table (ids, time, etc)
		//then add everything to the array list and call the function from admin service to show it all
		System.out.println("\nADD to Airports\n");
		System.out.println("3 letter code for the airport?");
		String code = input.nextLine();
		code = code.toUpperCase();
		
		if(code.length() != 3)
		{
			System.out.println("Error, each airport code has to have 3 letters");
			input.close();
			throw new IllegalArgumentException();
		}
		else
		{
			ap.setAirportCode(code);
			System.out.println("City for the airport?");
			String city = input.nextLine();
			if(city.length() >45 || city.length()<1)
			{
				System.out.println("Error, cities have to be under 45 characters");
				input.close();
				throw new IllegalArgumentException();
			}
			else
			{
				ap.setCityName(city);
				service.addNewAirport(ap);
			}
		}
		input.close();
	}
	
	//update flights
	private void updateAirport() throws SQLException
	{
		Scanner input = new Scanner(System.in);
		
		service.readAllAirports();
		
		System.out.println("UPDATE Airports");
		System.out.println("Enter the airport code");
		String code = input.nextLine();
		code = code.toUpperCase();
		
		if(code.isEmpty() == false && code.length() == 3)
		{
			ap.setAirportCode(code);
			service.updateAirportCode(ap);
		}			
		
		System.out.println("New city for the airport?");
		String city = input.nextLine();
		if(city.isEmpty() == false)
		{
			ap.setCityName(city);
			service.updateAirportCity(ap);
		}
		
		if(city.isEmpty() == true && code.isEmpty() == true)
		{
			System.out.println("Nothing was changed. Returning");
			Main.run();
		}
		
		input.close();
	}
	
	//this will delete flights based on an ID
	private void deleteAirport() throws SQLException
	{
		Scanner input = new Scanner(System.in);
		
		service.readAllAirports();
		
		System.out.println("DELETE Airports");
		System.out.println("Airport code to delete?");
		String code = input.nextLine();
		
		service.deleteAirport(code);
		input.close();
	}
	
	//this will call the readAllAirports method to print all flights
	private void readAllAirports() throws SQLException
	{
		service.readAllAirports();
	}
}
