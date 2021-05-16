package com.ss.lib.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.ss.lib.entity.BookLoans;
import com.ss.lib.menus.Admin1;

public class AdminLoan {

	private AdminService service = new AdminService();
	private BookLoans bl = new BookLoans();
	
	private void header1()
	{
		System.out.println("\nADD/UPDATE/DELETE/READ BOOK LOANS or QUIT to return");
	}
	
	public void performNext() throws SQLException 
	{
		header1();
		Scanner input = new Scanner(System.in);
		String choice = input.nextLine();
		
		//uses if else statements instead of switch because it allows the user to type single letters and ignore case
		if(choice.equalsIgnoreCase("add") || choice.equalsIgnoreCase("a"))
		{
			addBookLoan();
		}
		else if(choice.equalsIgnoreCase("update") || choice.equalsIgnoreCase("u"))
		{
			updateBookLoan();
		}
		else if(choice.equalsIgnoreCase("delete") || choice.equalsIgnoreCase("d"))
		{
			deleteBookLoan();
		}
		else if(choice.equalsIgnoreCase("read") || choice.equalsIgnoreCase("r"))
		{
			readAllBookLoans();
		}
		else if(choice.equalsIgnoreCase("quit") || choice.equalsIgnoreCase("q"))
		{
			System.out.println("Quitting");
			Admin1 a1 = new Admin1();
			a1.run();
		}
		else
		{
				System.out.println("That is not a valid option. \nPlease enter \"add\", \"update\", \"delete\", \"read\", or \"quit\"");
				performNext();
		}
		input.close();
	}
	
	private void addBookLoan() throws SQLException
	{
		try {
		Scanner input = new Scanner(System.in);
		System.out.println("\nADD a new BookLoan");
		System.out.println("ID of Book?");
		int bid = Integer.parseInt(input.nextLine());
		
		System.out.println("ID of Library Branch?");
		int lbid = Integer.parseInt(input.nextLine());
		
		System.out.println("Card Number of the Borrower?");
		int borwid = Integer.parseInt(input.nextLine());
		
		System.out.println("Check out date? yyyy-mm-dd");
		String coDate = input.nextLine();
		
		System.out.println("Due date? yyyy-mm-dd");
		String dueDate = input.nextLine();

		bl.getLoanBookID().setBookID(bid);
		bl.getLoanBranchID().setBranchID(lbid);
		bl.getLoanCardNum().setCardNum(borwid);
		bl.setDateOut(coDate);
		bl.setDueDate(dueDate);
		
		service.addNewBookLoan(bl);
	
		input.close();
		}catch(NumberFormatException e)
		{
			System.out.println("You have entered a non number and will be returned to the previous menu");
			Admin1 a1 = new Admin1();
			a1.run();
		}
	}
	
	private void updateBookLoan() throws SQLException
	{
		try {
			Scanner input = new Scanner(System.in);
			
			service.showAllBookLoans();
			
			System.out.println("\nUPDATE BookLoans");
			System.out.println("ID of Book?");
			int bid = Integer.parseInt(input.nextLine());
			
			System.out.println("ID of Library Branch?");
			int lbid = Integer.parseInt(input.nextLine());
			
			System.out.println("Card Number of the Borrower?");
			int borwid = Integer.parseInt(input.nextLine());
			
			System.out.println("Check out date?");
			String coDate = input.nextLine();
			
			System.out.println("Due date?");
			String dueDate = input.nextLine();

			bl.getLoanBookID().setBookID(bid);
			bl.getLoanBranchID().setBranchID(lbid);
			bl.getLoanCardNum().setCardNum(borwid);
			bl.setDateOut(coDate);
			bl.setDueDate(dueDate);
			
			service.updateBookLoan(bl);
			
			input.close();
		}
		catch(NumberFormatException e)
		{
			System.out.println("You have entered a non number and will be returned to the previous menu");
			Admin1 a1 = new Admin1();
			a1.run();
		}
	}
	
	private void deleteBookLoan() throws SQLException
	{
		try {
			Scanner input = new Scanner(System.in);
			
			service.showAllBookLoans();
			
			System.out.println("DELETE BookLoan");
			System.out.println("ID of Book?");
			int bid = Integer.parseInt(input.nextLine());
			
			System.out.println("ID of Library Branch?");
			int lbid = Integer.parseInt(input.nextLine());
			
			System.out.println("Card Number of the Borrower?");
			int borwid = Integer.parseInt(input.nextLine());
			
			bl.getLoanBookID().setBookID(bid);
			bl.getLoanBranchID().setBranchID(lbid);
			bl.getLoanCardNum().setCardNum(borwid);
			
			service.deleteBookLoan(bl);
			input.close();
		}
		catch(NumberFormatException e)
		{
			System.out.println("You have entered a non number and will be returned to the previous menu");
			Admin1 a1 = new Admin1();
			a1.run();
		}
	}
	
	private void readAllBookLoans() throws SQLException
	{
		service.readAllBookLoans();
	}
}