package com.ss.utop.menu;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ss.utop.entity.Flight;
import com.ss.utop.service.TravelerService;

public class BookTicket2 {
	TravelerService ts = new TravelerService();
	
	private void header1()
	{
		System.out.println("\nPick a seat you wish to book a ticket for");
	}
	
	public void run(Flight f, int cardNum)
	{
		header1();
		try {
			ts.readSeatsAvailalbe(f, cardNum);
		}
		catch (Exception e)
		{
			e.printStackTrace();	
		}
	}
	
	public void run2(List<Flight> flightList) throws SQLException
	{
		Scanner input = new Scanner(System.in);
		
		int choice = Integer.parseInt(input.nextLine());
		Boolean quit = false;
		
		while(choice-1 <= flightList.size() && choice-1 >= 0 && quit != true)
		{	
			if(choice-1 == flightList.size())
			{
				System.out.println("Returning to previous menu\n\n");
				Main.run();
			}
			else
			{
				choice -= 1;		//this makes the choice = to the index of array since the array starts at index 0 but choice starts at 1
				
			}
		}
		input.close();
	}
}
