package com.ss.utop.menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.ss.utop.entity.Airplane;
import com.ss.utop.service.AdminService;

/*
 * This class is for dealing with all the options for the admin in the airplane table
 */

public class AdminAirplanes {
	private AdminService service = new AdminService();
	private Airplane plane = new Airplane();

	public void performNext() throws SQLException 
	{
		Scanner input = new Scanner(System.in);
		String choice = input.nextLine();
		
		//uses if else statements instead of switch because it allows the user to type single letters and ignore case
		if(choice.equalsIgnoreCase("add") || choice.equalsIgnoreCase("a"))
		{
			addNewAirplane();
		}
		else if(choice.equalsIgnoreCase("update") || choice.equalsIgnoreCase("u"))
		{
			updateAirplane();
		}
		else if(choice.equalsIgnoreCase("delete") || choice.equalsIgnoreCase("d"))
		{
			deleteAirplane();
		}
		else if(choice.equalsIgnoreCase("read") || choice.equalsIgnoreCase("r"))
		{
			readAllAirplanes();
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

	private void addNewAirplane() throws SQLException
	{
		try {
		Scanner input = new Scanner(System.in);
		System.out.println("\nADD to Airplanes\n");
	
		System.out.println("Type of airplane?");
		int type = Integer.parseInt(input.nextLine());
		
		plane.getAPId();							//get the airplane id
		plane.getType().setId(type);				//add the type of airplane from the airplane_type
		service.addNewAirplane(plane);
	
		input.close();
		}catch(NumberFormatException e)
		{
			System.out.println("You have entered a non number");
		}
	}
	
	//update flights
	private void updateAirplane() throws SQLException
	{
		try {
		Scanner input = new Scanner(System.in);
		System.out.println("UPDATE Airplanes");
		System.out.println("Enter the airplane ID");
		int id = Integer.parseInt(input.nextLine());
		
		System.out.println("Type of airplane?");
		int type = Integer.parseInt(input.nextLine());
		
		plane.setAPId(id);
		plane.getType().setId(type);
		
		input.close();
		}catch(NumberFormatException e)
		{
			System.out.println("You have entered a non number");
		}
	}
	
	//this will delete flights based on an ID
	private void deleteAirplane() throws SQLException
	{
		try {
		Scanner input = new Scanner(System.in);
		
		System.out.println("DELETE Airplanes");
		System.out.println("Airplane code to delete?");
		int id = Integer.parseInt(input.nextLine());
		
		service.deleteAirplane(id);
		input.close();
		}catch(NumberFormatException e)
		{
			System.out.println("You have entered a non number");
		}
	}
	
	//this will call the readAllAirplanes method to print all flights
	private void readAllAirplanes() throws SQLException
	{
		service.readAllAirplanes();
	}

}
