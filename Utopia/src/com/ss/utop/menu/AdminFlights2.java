package com.ss.utop.menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.ss.utop.entity.Flight;
import com.ss.utop.service.AdminService;

/*
 * This class will handle if the user wants to add, update, delete, or read a Flight
 */

public class AdminFlights2 {
	private AdminService service = new AdminService();
	
	public void performNext() throws SQLException 
	{
		Scanner input2 = new Scanner(System.in);
		String choice = input2.nextLine();
		
		//uses if else statements instead of switch because it allows the user to type single letters and ignore case
		if(choice.equalsIgnoreCase("add") || choice.equalsIgnoreCase("a"))
		{
			addNewFlight();
		}
		else if(choice.equalsIgnoreCase("update") || choice.equalsIgnoreCase("u"))
		{
			updateFlight();
		}
		else if(choice.equalsIgnoreCase("delete") || choice.equalsIgnoreCase("d"))
		{
			deleteFlight();
		}
		else if(choice.equalsIgnoreCase("read") || choice.equalsIgnoreCase("r"))
		{
			readAllFlights();
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
		input2.close();
	}
	
	//add a new flight
	private void addNewFlight() throws SQLException
	{
		try {
		Flight f = new Flight();
		Scanner input2 = new Scanner(System.in);
		//input everything that is required by the flights table (ids, time, etc)
		//then add everything to the array list and call the function from admin service to show it all
		System.out.println("\nADD to Flights\n");
		System.out.println("ID of flight?");
		int id = Integer.parseInt(input2.nextLine());
		
		System.out.println("ID of route?");
		int rId = Integer.parseInt(input2.nextLine());
		
		System.out.println("Airplane ID?");
		int aId = Integer.parseInt(input2.nextLine());
		
		System.out.println("Date and time? Format YYYY-MM-DD hh:mm:ss");
		String date = input2.nextLine();
		
		System.out.println("Reserved seats?");
		int rSeats = Integer.parseInt(input2.nextLine());

		System.out.println("Price?");
		Float price = Float.parseFloat(input2.nextLine());
		
		if(price < 0)
		{
			System.out.println("Price can not be negative");
		}
		else
		{
			f.setPrice(price);
		}
		
		f.setFlightId(id);
		f.getRouteId().setId(rId);
		f.getAirplaneId().setAPId(aId);
		f.setResSeats(rSeats);
		f.setAirplaneId(f.getAirplaneId());
		f.setDepartTime(date);

		service.addNewFlight(f);
		input2.close();
		}
		catch(NumberFormatException e)
		{
			System.out.println("You have entered a non number");
		}
	}
	
	//update flights
	private void updateFlight() throws SQLException
	{
		try {
		Flight f = new Flight();
		Scanner input2 = new Scanner(System.in);
		service.readAllFlights();
		System.out.println("UPDATE Flights");
		
		System.out.println("ID of flight?");
		int id = Integer.parseInt(input2.nextLine());
		
		System.out.println("ID of route?");
		int rId = Integer.parseInt(input2.nextLine());
		f.getRouteId().setId(rId);
		
		System.out.println("Airplane ID?");
		int aId = Integer.parseInt(input2.nextLine());
		f.getAirplaneId().setAPId(aId);
		
		System.out.println("Date and time? Format YYYY-MM-DD hh:mm:ss");
		String date = input2.nextLine();
		
		System.out.println("Reserved seats?");
		System.out.println(f.getAirplaneId().getType().getCapacity());
		int rSeats = Integer.parseInt(input2.nextLine());
		
		System.out.println("Price?");
		Float price = Float.parseFloat(input2.nextLine());
		
		if(price < 0)
		{
			System.out.println("Price can not be negative");

			input2.close();
			throw new IllegalArgumentException();
		}
		else
		{
			f.setPrice(price);
		}
		f.setResSeats(rSeats);
		f.setFlightId(id);
		f.setDepartTime(date);	

		service.updateFlight(f);
		input2.close();
		}
		catch(NumberFormatException e)
		{
			System.out.println("You have entered a non number");
		}
	}
	
	//this will delete flights based on an ID
	private void deleteFlight() throws SQLException
	{
		try {
		Scanner input2 = new Scanner(System.in);
		
		service.readAllFlights();
		
		System.out.println("DELETE Flights");
		System.out.println("Flight ID to delete?");
		int id = Integer.parseInt(input2.nextLine());
		
		service.deleteFlight(id);
		input2.close();
		}catch(NumberFormatException e)
		{
			System.out.println("You have entered a non number");
		}
	}
	
	//this will call the readAllFlights method to print all flights
	private void readAllFlights() throws SQLException
	{
		service.readAllFlights();
	}
}
