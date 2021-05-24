package com.ss.utop.menu;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ss.utop.entity.Flight;
import com.ss.utop.service.TravelerService;

public class BookTicket {
	TravelerService ts = new TravelerService();

	private void message()
	{
		System.out.println("Select your Flight or quit to quit to previous menu");
	}
	
	public void run(int cardNum) throws SQLException
	{
		try {
			ts.readFlightsToBook(cardNum);
		}
		catch (Exception e)
		{
			e.printStackTrace();	
		}
	}
	
	public void run2(List<Flight> flightList, int cardNum) throws SQLException
	{
		message();
		Scanner input = new Scanner(System.in);
				
		int choice = Integer.parseInt(input.nextLine());
		Boolean quit = false;
		
		while(choice-1 <= flightList.size() && choice-1 >= 0 && quit != true)
		{	
			if(choice-1 == flightList.size())
			{
				System.out.println("Returning to previous menu\n\n");
				Traveler1 t1 = new Traveler1();
				t1.run();
			}
			else
			{
				choice -= 1;		//this makes the choice = to the index of array since the array starts at index 0 but choice starts at 1
				//create an array to convert the list so we can get the index (choice+1) of the branch we want
				Flight[] flightArray = new Flight[flightList.size()];
				flightArray = flightList.toArray(flightArray);
				
				Flight flight = new Flight();
				
				flight.setFlightId(flightArray[choice].getFlightId());
				flight.setRouteId(flightArray[choice].getRouteId());
				flight.setAirplaneId(flightArray[choice].getAirplaneId());
				flight.setDepartTime(flightArray[choice].getDepartTime());
				flight.setResSeats(flightArray[choice].getResSeats());
				flight.setPrice(flightArray[choice].getPrice());
				

				
				quit = true;
				
				System.out.println("You have entered flight "+flight.getFlightId()+" from "+flight.getRouteId().getOrgAirport()+" to "+flight.getRouteId().getDesAirport());
				BookTicket2 bt2 = new BookTicket2();
				bt2.run(flight, cardNum);
			}
		}
		input.close();
	}
}
