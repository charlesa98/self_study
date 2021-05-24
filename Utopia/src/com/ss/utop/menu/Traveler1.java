package com.ss.utop.menu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.ss.utop.entity.Passenger;
import com.ss.utop.service.ConnectionUtil;

public class Traveler1 {
	Passenger p = new Passenger();
	ConnectionUtil connUtil = new ConnectionUtil();

	public void header1()
	{
		System.out.println("Welcome. Please enter your membership/id number");
	}
	
	public void header2()
	{
		System.out.println("\nWhat would you like to do?");
		System.out.println("1) Book a Ticket \n2) Cancel an upcoming trip \n3) Quit back to main menu");
	}
	
	//this will check is the card number is valid or not first
	private int getCard() throws SQLException
	{
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int number = -1;
		Boolean quit = false;
		while(quit != true)
		{
			number = Integer.parseInt(input.nextLine());
			
			Connection conn = null;
			try {
				conn = connUtil.getConnection();
				Statement stmt = conn.createStatement();
				String sql = "select id from passenger where id = '"+number+"'";		
				
				ResultSet rs = stmt.executeQuery(sql);
				
				if(rs.next())
				{
					System.out.println("That is a valid number");
					quit = true;
					return number;
				}
				else
				{
					System.out.println("That is not a valid number. Enter again\n");
				}
			}catch(Exception e)
			{
				System.out.println("Something went wrong with entering the card");
			}
		}
		//input.close();			//this causes issues
		return number;
	}
	
	public void run() throws SQLException
	{
			header1();
			int cardNum = getCard();
			
			header2();
			int choice2 = getInput();
			performAction(choice2, cardNum);
	}
	
	private int getInput()
	{
		Scanner input = new Scanner(System.in);
		int choice2 = -1;
		while(choice2 > 0 || choice2 < 4)
		{
			try {
				choice2 = Integer.parseInt(input.nextLine());
				return choice2;
			}catch (NumberFormatException e)
			{
				System.out.println("That is not a valid option. \nPlease enter a number between 1 and 3");
			}
		}
		input.close();
		return choice2;
	}
	
	private void performAction(int choice, int cardNum) throws SQLException
	{
		switch(choice)
		{
			case 1:
				BookTicket bt = new BookTicket();
				bt.run(cardNum);
				
				break;
				
			case 2:
				CancelTrip ct = new CancelTrip();
				ct.run(cardNum);
				
				break;
				
			case 3:
				//goes back to the main menu
				System.out.println("Going back previous menu\n");
				Main.run();
				break;
				
			default:
				System.out.println("That is not a valid option. \nPlease enter a number between 1 - 3");
		}				
	}
}
