package com.ss.lib.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.ss.lib.entity.Borrower;
import com.ss.lib.menus.Admin1;
import com.ss.lib.menus.Main;
/*
 * Main -> Admin1 -> AdminBorrowers
 */
public class AdminBorrowers {

	private AdminService service = new AdminService();
	private Borrower borw = new Borrower();
	
	private void header1()
	{
		System.out.println("\nADD/UPDATE/DELETE/READ BORROWERS or QUIT to previous menu");
	}
	
	public void performNext() throws SQLException 
	{
		header1();
		Scanner input = new Scanner(System.in);
		String choice = input.nextLine();
		
		//uses if else statements instead of switch because it allows the user to type single letters and ignore case
		if(choice.equalsIgnoreCase("add") || choice.equalsIgnoreCase("a"))
		{
			addBorrower();
		}
		else if(choice.equalsIgnoreCase("update") || choice.equalsIgnoreCase("u"))
		{
			updateBorrower();
		}
		else if(choice.equalsIgnoreCase("delete") || choice.equalsIgnoreCase("d"))
		{
			deleteBorrower();
		}
		else if(choice.equalsIgnoreCase("read") || choice.equalsIgnoreCase("r"))
		{
			readAllBorrowers();
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
	
	private void addBorrower() throws SQLException
	{
		try {
		Scanner input = new Scanner(System.in);
		System.out.println("\nADD a new Borrower");
		System.out.println("Card Number of Borrower?");
		int id = Integer.parseInt(input.nextLine());
		
		System.out.println("Name of Borrower?");
		String name = input.nextLine();
		
		System.out.println("Address of Borrower?");
		String addr = input.nextLine();
		
		System.out.println("Phone number of Borrower?");
		String phone = input.nextLine();
		
		borw.setCardNum(id);
		borw.setbName(name);
		borw.setbAddress(addr);
		borw.setbPhone(phone);

		service.addNewBorrower(borw);
	
		input.close();
		}catch(NumberFormatException e)
		{
			System.out.println("You have entered a non number and will be returned to the previous menu");
			Admin1 a1 = new Admin1();
			a1.run();
		}
	}
	
	private void updateBorrower() throws SQLException
	{
		try {
			Scanner input = new Scanner(System.in);
			
			service.showAllBorrowers();
			
			System.out.println("\nUPDATE Borrowers");
			System.out.println("Enter the Borrower Card Number");
			int id = Integer.parseInt(input.nextLine());
			
			System.out.println("Name of Borrower?");
			String name = input.nextLine();
			
			System.out.println("Address of Borrower?");
			String addr = input.nextLine();
			
			System.out.println("Phone number of Borrower?");
			String phone = input.nextLine();
			
			borw.setCardNum(id);
			
			if(name.isEmpty() == false)			//if the user did input a value to change, change it
			{
				borw.setbName(name);
				service.updateBorrowerName(borw);
			}
			if(addr.isEmpty() == false)
			{
				borw.setbAddress(addr);
				service.updateBorrowerAddress(borw);
			}
			if(phone.isEmpty()==false)
			{
				borw.setbPhone(phone);
				service.updateBorrowerPhone(borw);
			}			
			if(name.isEmpty() == true && addr.isEmpty() == true && phone.isEmpty() == true)
			{
				System.out.println("Nothing has been changed. Returning to previous menu\n");
				Admin1 a1 = new Admin1();
				a1.run();
			}
			input.close();
			Main.run();
		}
		catch(NumberFormatException e)
		{
			System.out.println("You have entered a non number and will be returned to the previous menu");
			Admin1 a1 = new Admin1();
			a1.run();
		}
	}
	
	private void deleteBorrower() throws SQLException
	{
		try {
			Scanner input = new Scanner(System.in);
			
			service.showAllBorrowers();
			
			System.out.println("DELETE Borrower");
			System.out.println("Borrower to delete?");
			int id = Integer.parseInt(input.nextLine());
			
			service.deleteBorrower(id);
			input.close();
		}
		catch(NumberFormatException e)
		{
			System.out.println("You have entered a non number and will be returned to the previous menu");
			Admin1 a1 = new Admin1();
			a1.run();
		}
	}
	
	private void readAllBorrowers() throws SQLException
	{
		service.readAllBorrowers();
	}
}
