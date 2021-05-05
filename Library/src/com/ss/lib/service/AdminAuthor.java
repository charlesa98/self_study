package com.ss.lib.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.ss.lib.entity.Author;
/*
 * Main -> Admin1 -> AdminAuthor
 */
public class AdminAuthor {
	private AdminService service = new AdminService();
	private Author a = new Author();
	
	private void header1()
	{
		System.out.println("\nADD/UPDATE/DELETE/READ AUTHORS");
	}
	
	public void performNext() throws SQLException 
	{
		header1();
		Scanner input = new Scanner(System.in);
		String choice = input.nextLine();
		
		//uses if else statements instead of switch because it allows the user to type single letters and ignore case
		if(choice.equalsIgnoreCase("add") || choice.equalsIgnoreCase("a"))
		{
			addAuthor();
		}
		else if(choice.equalsIgnoreCase("update") || choice.equalsIgnoreCase("u"))
		{
			updateAuthor();
		}
		else if(choice.equalsIgnoreCase("delete") || choice.equalsIgnoreCase("d"))
		{
			deleteAuthor();
		}
		else if(choice.equalsIgnoreCase("read") || choice.equalsIgnoreCase("r"))
		{
			readAllAuthors();
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
	
	private void addAuthor() throws SQLException
	{
		try {
		Scanner input = new Scanner(System.in);
		System.out.println("\nADD a new Author");
		System.out.println("ID of Author?");
		int id = Integer.parseInt(input.nextLine());
		
		System.out.println("Name of Author?");
		String name = input.nextLine();
		
		a.setAuthorID(id);
		a.setAuthorName(name);
		
		service.addNewAuthor(a);
	
		input.close();
		}catch(NumberFormatException e)
		{
			System.out.println("You have entered a non number");
		}
	}
	
	private void updateAuthor() throws SQLException
	{
		try {
			Scanner input = new Scanner(System.in);
			System.out.println("\nUPDATE Authors");
			System.out.println("Enter the Author ID");
			int id = Integer.parseInt(input.nextLine());
			
			System.out.println("Name of Author?");
			String name = input.nextLine();
			
			a.setAuthorID(id);
			a.setAuthorName(name);
			
			service.updateAuthor(a);
			
			input.close();
		}
		catch(NumberFormatException e)
		{
			System.out.println("You have entered a non number");
		}
	}
	
	private void deleteAuthor() throws SQLException
	{
		try {
			Scanner input = new Scanner(System.in);
			
			System.out.println("DELETE Author");
			System.out.println("Author ID to delete?");
			int id = Integer.parseInt(input.nextLine());
			
			service.deleteAuthor(id);
			input.close();
		}
		catch(NumberFormatException e)
		{
			System.out.println("You have entered a non number");
		}
	}
	
	private void readAllAuthors() throws SQLException
	{
		service.readAllAuthors();
	}
}
