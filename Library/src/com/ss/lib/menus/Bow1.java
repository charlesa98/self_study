package com.ss.lib.menus;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.ss.lib.entity.Borrower;
import com.ss.lib.service.ConnectionUtil;

public class Bow1 {
	Borrower b = new Borrower();
	ConnectionUtil connUtil = new ConnectionUtil();

	public void header1()
	{
		System.out.println("Welcome. Please enter your card number");
	}
	
	public void header2()
	{
		System.out.println("\nWhat would you like to do?");
		System.out.println("1) Check out a Book \n2) Return a Book \n3) Quit back to main menu");
	}
	
	//this will check is the card number is valid or not first
	private int getCard() throws SQLException
	{
		Scanner input = new Scanner(System.in);
		int number = -1;
		
		number = Integer.parseInt(input.nextLine());
		
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "select cardNo from tbl_borrower where cardNo = '"+number+"'";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next())
			{
				System.out.println("That is a valid number");
				return number;
			}
			else
			{
				System.out.println("That is not a valid number\n");
			}
		}catch(Exception e)
		{
			System.out.println("Something went wrong with entering the card");
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
				//check out a book
				Bow2O1 b2 = new Bow2O1();
				b2.run(cardNum);
				
				break;
				
			case 2:
				//return a book
				//Bow2O2 b2 = new Bow2O2();
				//b2.run();
				
				break;
				
			case 3:
				//goes back to the main menu
				System.out.println("Going back previous menu\n");
				Bow1 bow1 = new Bow1();
				bow1.run();
				break;
				
			default:
				System.out.println("That is not a valid option. \nPlease enter a number between 1 - 3");
		}				
	}
}
