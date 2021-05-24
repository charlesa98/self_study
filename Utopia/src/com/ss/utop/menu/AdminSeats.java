package com.ss.utop.menu;

import java.sql.SQLException;
import java.util.Scanner;


import com.ss.utop.service.AdminService;

public class AdminSeats {
	private AdminService service = new AdminService();
	
	public void performNext() throws SQLException 
	{
		Scanner input = new Scanner(System.in);
		String choice = input.nextLine();
		
		//uses if else statements instead of switch because it allows the user to type single letters and ignore case
		if(choice.equalsIgnoreCase("add") || choice.equalsIgnoreCase("a"))
		{
			addNewSeats();
		}
		else if(choice.equalsIgnoreCase("update") || choice.equalsIgnoreCase("u"))
		{
			updateSeats();
		}
		else if(choice.equalsIgnoreCase("delete") || choice.equalsIgnoreCase("d"))
		{
			deleteSeats();
		}
		else if(choice.equalsIgnoreCase("read") || choice.equalsIgnoreCase("r"))
		{
			readAllSeatss();
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
	
	private void addNewSeats() throws SQLException
	{
		
		
	}
	
	//update flights
	private void updateSeats() throws SQLException
	{
		
	}
	
	//this will delete flights based on an ID
	private void deleteSeats() throws SQLException
	{
		
	}
	
	//this will call the readAllSeatss method to print all flights
	private void readAllSeatss() throws SQLException
	{
		
	}
}
