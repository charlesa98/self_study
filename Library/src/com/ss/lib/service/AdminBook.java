package com.ss.lib.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.ss.lib.entity.Book;

public class AdminBook {
	private AdminService service = new AdminService();
	private Book b = new Book();
	
	private void header1()
	{
		System.out.println("\nADD/UPDATE/DELETE/READ BOOKS");
	}
	
	public void performNext() throws SQLException 
	{
		header1();
		Scanner input = new Scanner(System.in);
		String choice = input.nextLine();
		
		//uses if else statements instead of switch because it allows the user to type single letters and ignore case
		if(choice.equalsIgnoreCase("add") || choice.equalsIgnoreCase("a"))
		{
			addBook();
		}
		else if(choice.equalsIgnoreCase("update") || choice.equalsIgnoreCase("u"))
		{
			updateBook();
		}
		else if(choice.equalsIgnoreCase("delete") || choice.equalsIgnoreCase("d"))
		{
			deleteBook();
		}
		else if(choice.equalsIgnoreCase("read") || choice.equalsIgnoreCase("r"))
		{
			readAllBooks();
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
	
	private void addBook() throws SQLException
	{
		try {
		Scanner input = new Scanner(System.in);
		System.out.println("\nADD a new Book");
		System.out.println("ID of Book?");
		int id = Integer.parseInt(input.nextLine());
		
		System.out.println("Title of Book?");
		String title = input.nextLine();
		
		System.out.println("ID of Author?");
		int aid = Integer.parseInt(input.nextLine());
		
		System.out.println("ID of Publisher?");
		int pid = Integer.parseInt(input.nextLine());
		
		b.setBookID(id);
		b.setTitle(title);
		b.getBookAuthorID().setAuthorID(aid);
		b.getBookPubID().setPublisherID(pid);
		
		service.addNewBook(b);
	
		input.close();
		}catch(NumberFormatException e)
		{
			System.out.println("You have entered a non number");
		}
	}
	
	private void updateBook() throws SQLException
	{
		try {
			Scanner input = new Scanner(System.in);
			System.out.println("\nUPDATE Books");
			System.out.println("Enter the Book ID");
			int id = Integer.parseInt(input.nextLine());
			
			System.out.println("Name of Book?");
			String name = input.nextLine();
			
			System.out.println("ID of Author?");
			int author = Integer.parseInt(input.nextLine());
			
			System.out.println("ID of Publisher?");
			int pub = Integer.parseInt(input.nextLine());
			
			b.setBookID(id);
			
			if(name.isEmpty() == false)
			{
				b.setTitle(name);
				service.updateBookTitle(b);
			}
			
			input.close();
		}
		catch(NumberFormatException e)
		{
			System.out.println("You have entered a non number");
		}
	}
	
	private void deleteBook() throws SQLException
	{
		try {
			Scanner input = new Scanner(System.in);
			
			System.out.println("DELETE Book");
			System.out.println("Book ID to delete?");
			int id = Integer.parseInt(input.nextLine());
			
			service.deleteBook(id);
			input.close();
		}
		catch(NumberFormatException e)
		{
			System.out.println("You have entered a non number");
		}
	}
	
	private void readAllBooks() throws SQLException
	{
		service.readAllBooks();
	}
}