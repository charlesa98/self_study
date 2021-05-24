package com.ss.utop.menu;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ss.utop.entity.Route;
import com.ss.utop.service.TravelerService;

public class CancelTrip {
	TravelerService ts = new TravelerService();
	
	private void header()
	{
		System.out.println("Cancelling a trip. Select which trip you would like to cancel");
	}
	
	public void run(Integer cardNum)
	{
		try {
			ts.readUserTrips(cardNum);
		}
		catch (Exception e)
		{
			e.printStackTrace();	
		}
	}	
	public void run2(List<Route> routeList, int cardNum) throws SQLException
	{
		header();
		Scanner input = new Scanner(System.in);
		
		int choice = Integer.parseInt(input.nextLine());
		Boolean quit = false;
		
		while(choice-1 <= routeList.size() && choice-1 >= 0 && quit != true)
		{	
			if(choice-1 == routeList.size())
			{
				System.out.println("Returning to previous menu\n\n");
				Main.run();
			}
			else
			{
				choice -= 1;		//this makes the choice = to the index of array since the array starts at index 0 but choice starts at 1
				//create an array to convert the list so we can get the index (choice+1) of the branch we want
				Route[] routeArray = new Route[routeList.size()];
				routeArray = routeList.toArray(routeArray);

				Route routes = new Route();
				
				routes.setId(routeArray[choice].getId());
				routes.setOrgAirport(routeArray[choice].getOrgAirport());
				routes.setDesAirport(routeArray[choice].getDesAirport());
			
				quit = true;
				
				System.out.println("\nYou have selected flight "+routes.getOrgAirport().getAirportCode() + " to " + routes.getDesAirport().getAirportCode());
				System.out.println("Are you sure you wish to cancel? y/n");
				
				Scanner input2 = new Scanner(System.in);
				String cont = input2.nextLine();
				
				if(cont.equalsIgnoreCase("y") || cont.equalsIgnoreCase("yes"))			//Confirmation from user to delete their flight
				{
					System.out.println("\ndeleting");
				}
				else
				{
					System.out.println("\nreturning");
					Traveler1 t1 = new Traveler1();
					t1.run();
				}
				input2.close();
			}
		}
		input.close();
	}
}
