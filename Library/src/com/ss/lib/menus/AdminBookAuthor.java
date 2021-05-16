package com.ss.lib.menus;

import java.sql.SQLException;
import java.util.Scanner;

import com.ss.lib.service.AdminAuthor;
import com.ss.lib.service.AdminBook;

/*
 * lets the user pick if they want to update a book or author
 * 
 * Main -> Admin1 -> AdminBookAuthor
 */
public class AdminBookAuthor {

	private void header()
	{
		System.out.println("Would you like to change a Book or Author?\nElse type quit to go back");
	}

	public void run() throws SQLException
	{
		header();				//prints the header
		Scanner input = new Scanner(System.in);
		String bookOrAuthor = input.nextLine();
		
		if(bookOrAuthor.equalsIgnoreCase("author") || bookOrAuthor.equalsIgnoreCase("a"))
		{
			AdminAuthor aa = new AdminAuthor();
			aa.performNext();
		}
		else if(bookOrAuthor.equalsIgnoreCase("book") || bookOrAuthor.equalsIgnoreCase("b"))
		{
			AdminBook ab = new AdminBook();
			ab.performNext();
		}
		else if(bookOrAuthor.equalsIgnoreCase("quit") || bookOrAuthor.equalsIgnoreCase("q"))
		{
			Admin1 admin = new Admin1();
			admin.run();
		}
		else
		{
			System.out.println("There was an error in your choice");
		}
		input.close();
	}
}
