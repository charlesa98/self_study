package com.ss.lib.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.ss.lib.entity.Publisher;
import com.ss.lib.menus.Admin1;
import com.ss.lib.menus.Main;

/*
 * Main -> Admin1 -> AdminPublisher
 */

public class AdminPublisher {
	private AdminService service = new AdminService();
	private Publisher p = new Publisher();
	
	private void header1()
	{
		System.out.println("\nADD/UPDATE/DELETE/READ PUBLISHERS or QUIT to return");
	}
	
	public void performNext() throws SQLException 
	{
		header1();
		Scanner input = new Scanner(System.in);
		String choice = input.nextLine();
		
		//uses if else statements instead of switch because it allows the user to type single letters and ignore case
		if(choice.equalsIgnoreCase("add") || choice.equalsIgnoreCase("a"))
		{
			addPublisher();
		}
		else if(choice.equalsIgnoreCase("update") || choice.equalsIgnoreCase("u"))
		{
			updatePublisher();
		}
		else if(choice.equalsIgnoreCase("delete") || choice.equalsIgnoreCase("d"))
		{
			deletePublisher();
		}
		else if(choice.equalsIgnoreCase("read") || choice.equalsIgnoreCase("r"))
		{
			readAllPublishers();
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
	
	private void addPublisher() throws SQLException
	{
		try {
		Scanner input = new Scanner(System.in);
		System.out.println("\nADD a new Publisher");
		System.out.println("ID of Publisher?");
		int id = Integer.parseInt(input.nextLine());
		
		System.out.println("Name of Publisher?");
		String name = input.nextLine();
		
		System.out.println("Address of Publisher?");
		String addr = input.nextLine();
		
		System.out.println("Phone number of Publisher?");
		String phone = input.nextLine();
		
		p.setPublisherID(id);
		p.setPublisherName(name);
		p.setPublisherAddress(addr);
		p.setPublisherPhone(phone);
		
		service.addNewPublisher(p);
	
		input.close();
		}catch(NumberFormatException e)
		{
			System.out.println("You have entered a non number and will be returned to the previous menu");
			Admin1 a1 = new Admin1();
			a1.run();
		}
	}
	
	private void updatePublisher() throws SQLException
	{
		try {
			Scanner input = new Scanner(System.in);
			
			service.showAllPublishers();
			
			System.out.println("\nUPDATE Publishers");
			System.out.println("Enter the Publisher ID");
			int id = Integer.parseInt(input.nextLine());
			
			System.out.println("Name of Publisher?");
			String name = input.nextLine();
			
			System.out.println("Address of Publisher?");
			String addr = input.nextLine();
			
			System.out.println("Phone number of Publisher?");
			String phone = input.nextLine();
			
			p.setPublisherID(id);		
			if(name.isEmpty() == false)
			{	
				p.setPublisherName(name);
				service.updatePublisherName(p);
			}
			if(addr.isEmpty() == false)
			{
				p.setPublisherAddress(addr);
				service.updatePublisherAddress(p);
			}
			if(phone.isEmpty() == false)
			{
				p.setPublisherPhone(phone);
				service.updatePublisherPhone(p);
			}	
			if(name.isEmpty() == true && addr.isEmpty() == true && phone.isEmpty() == true)
			{
				System.out.println("Nothing was changed. Returning to previous menu");
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
	
	private void deletePublisher() throws SQLException
	{
		try {
			Scanner input = new Scanner(System.in);
			
			service.showAllPublishers();
			
			System.out.println("DELETE Publisher");
			System.out.println("Publisher ID to delete?");
			int id = Integer.parseInt(input.nextLine());
			
			service.deletePublisher(id);
			input.close();
		}
		catch(NumberFormatException e)
		{
			System.out.println("You have entered a non number and will be returned to the previous menu");
			Admin1 a1 = new Admin1();
			a1.run();
		}
	}
	
	private void readAllPublishers() throws SQLException
	{
		service.readAllPublishers();
	}
}
