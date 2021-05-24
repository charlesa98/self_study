package com.ss.utop.menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.ss.utop.entity.FlightBookings;
import com.ss.utop.service.AdminService;

public class AdminTickets {
	private AdminService service = new AdminService();
	FlightBookings fb = new FlightBookings();
	
	public void performNext() throws SQLException 
	{
		Scanner input = new Scanner(System.in);
		String choice = input.nextLine();
		
		//uses if else statements instead of switch because it allows the user to type single letters and ignore case
		if(choice.equalsIgnoreCase("add") || choice.equalsIgnoreCase("a"))
		{
			addNewTicket();
		}
		else if(choice.equalsIgnoreCase("update") || choice.equalsIgnoreCase("u"))
		{
			updateTicket();
		}
		else if(choice.equalsIgnoreCase("delete") || choice.equalsIgnoreCase("d"))
		{
			deleteTicket();
		}
		else if(choice.equalsIgnoreCase("read") || choice.equalsIgnoreCase("r"))
		{
			readAllTickets();
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
	
	private void addNewTicket() throws SQLException
	{
		
		Scanner input = new Scanner(System.in);		
		try {
			System.out.println("\nADD to Flight Booking\n");
			System.out.println("Id of the booking?");
			int bid = Integer.parseInt(input.nextLine());
			
			System.out.println("Id of the flight?");
			int fid = Integer.parseInt(input.nextLine());
			
			fb.getBookingId().setId(bid);
			fb.getFlightBookingId().setFlightId(fid);
			
			service.addNewTicket(fb);
			
			input.close();
		}catch(NumberFormatException e)
		{
			System.out.println("You have entered a non number");
		}
	}
	
	private void updateTicket() throws SQLException
	{
		Scanner input = new Scanner(System.in);
		
		service.readAllTickets();
		
		try {
			System.out.println("UPDATE Tickets");
			System.out.println("Id of the booking?");
			int bid = Integer.parseInt(input.nextLine());
			
			System.out.println("Id of the flight?");
			int fid = Integer.parseInt(input.nextLine());
			
			fb.getBookingId().setId(bid);
			fb.getFlightBookingId().setFlightId(fid);
			
			service.updateTicket(fb);
			
			input.close();
		}catch(NumberFormatException e)
		{
			System.out.println("You have entered a non number");
		}
	}
	
	//this will delete flights based on an ID
	private void deleteTicket() throws SQLException
	{
		Scanner input = new Scanner(System.in);
		
		service.readAllTickets();
		
		try {
			System.out.println("DELETE Tickets");
			System.out.println("Id of the booking?");
			int bid = Integer.parseInt(input.nextLine());
			
			System.out.println("Id of the flight?");
			int fid = Integer.parseInt(input.nextLine());
			
			fb.getBookingId().setId(bid);
			fb.getFlightBookingId().setFlightId(fid);
			
			service.deleteTicket(fb);
			
			input.close();
		}catch(NumberFormatException e)
		{
			System.out.println("You have entered a non number");
		}
	}
	
	//this will call the readAllAirports method to print all flights
	private void readAllTickets() throws SQLException
	{
		service.readAllTickets();
	}
}
