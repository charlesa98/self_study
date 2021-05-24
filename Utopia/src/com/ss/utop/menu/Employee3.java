package com.ss.utop.menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.ss.utop.entity.Airport;
import com.ss.utop.entity.Flight;
import com.ss.utop.entity.Route;
import com.ss.utop.service.EmployeeService;

public class Employee3 {
	private EmployeeService service = new EmployeeService();
	private void header()
	{
		System.out.println("\n1) View more details about the Flight \n2) Update the details fo the Flight \n"
				+ "3) Add seats to the flight \n4) Quit to previous menu");
	}
	
	public void run(Route route) throws SQLException
	{
		header();
		int choice = getInput();
		performAction(choice, route);
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
				System.out.println("That is not a valid option. \nPlease enter a number between 1 and 4");
			}
		}
		input.close();
		return choice;
	}
	
	private void performAction(int choice, Route route) throws SQLException
	{
		switch(choice)
		{
		case 1:
			System.out.println("Reading Flights");
			readFlight(route);
			break;
			
		case 2:
			System.out.println("Update Flight");
			
			updateFlight(route);
			break;
			
		case 3:
			System.out.println("Add seats");
			
			break;
			
		case 4:
			System.out.println("Going back\n");
			Employee2 e2 = new Employee2();
			e2.run();
			break;	
			
		default:
			System.out.println("An error occured");
		}
	}
	
	private void readFlight(Route route) throws SQLException {
		Route temp = new Route();
		temp.setId(route.getId());
		temp.setOrgAirport(route.getOrgAirport());
		temp.setDesAirport(route.getDesAirport());
		
		service.readAllFlightsBasedOnRoute(temp);
	}

	private void updateFlight(Route route) throws SQLException
	{
		try {
			Flight f = new Flight();
			Scanner input2 = new Scanner(System.in);
			service.readAllFlights();
			System.out.println("UPDATE Flights");
			
			System.out.println("ID of flight?");
			int id = Integer.parseInt(input2.nextLine());
			f.setFlightId(id);
			
			System.out.println("ID of route?");
			int rId = Integer.parseInt(input2.nextLine());
			f.getRouteId().setId(rId);
			
			System.out.println("Airplane ID?");
			int aId = Integer.parseInt(input2.nextLine());
			f.getAirplaneId().setAPId(aId);
			
			System.out.println("Date and time? Format YYYY-MM-DD hh:mm:ss");
			String date = input2.nextLine();
			f.setDepartTime(date);	
			
			System.out.println("Reserved seats?");
			System.out.println(f.getAirplaneId().getType().getCapacity());
			int rSeats = Integer.parseInt(input2.nextLine());
			f.setResSeats(rSeats);
			
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
			
			service.updateFlight(f);
			input2.close();
			}
			catch(NumberFormatException e)
			{
				System.out.println("You have entered a non number");
			}
	}
}
