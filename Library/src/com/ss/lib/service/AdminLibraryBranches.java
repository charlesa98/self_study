package com.ss.lib.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.ss.lib.entity.LibraryBranch;
/*
 * Main -> Admin1 -> AdminLibraryBranches
 */
public class AdminLibraryBranches{
	private AdminService service = new AdminService();
	private LibraryBranch lb = new LibraryBranch();
	
	private void header1()
	{
		System.out.println("\nADD/UPDATE/DELETE/READ LIBRARY BRANCHES");
	}
	
	public void performNext() throws SQLException 
	{
		header1();
		Scanner input = new Scanner(System.in);
		String choice = input.nextLine();
		
		//uses if else statements instead of switch because it allows the user to type single letters and ignore case
		if(choice.equalsIgnoreCase("add") || choice.equalsIgnoreCase("a"))
		{
			addLibraryBranch();
		}
		else if(choice.equalsIgnoreCase("update") || choice.equalsIgnoreCase("u"))
		{
			updateLibraryBranch();
		}
		else if(choice.equalsIgnoreCase("delete") || choice.equalsIgnoreCase("d"))
		{
			deleteLibraryBranch();
		}
		else if(choice.equalsIgnoreCase("read") || choice.equalsIgnoreCase("r"))
		{
			readAllLibraryBranches();
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
	
	private void addLibraryBranch() throws SQLException
	{
		try {
		Scanner input = new Scanner(System.in);
		System.out.println("\nADD a new LibraryBranch");
		System.out.println("ID of LibraryBranch?");
		int id = Integer.parseInt(input.nextLine());
		
		System.out.println("Name of LibraryBranch?");
		String name = input.nextLine();
		
		System.out.println("Address of LibraryBranch?");
		String addr = input.nextLine();
		
		lb.setBranchID(id);
		lb.setBranchName(name);
		lb.setBranchAddress(addr);
		
		service.addNewLibraryBranch(lb);
	
		input.close();
		}catch(NumberFormatException e)
		{
			System.out.println("You have entered a non number");
		}
	}
	
	private void updateLibraryBranch() throws SQLException
	{
		try {
			Scanner input = new Scanner(System.in);
			System.out.println("\nUPDATE LibraryBranchs");
			System.out.println("Enter the LibraryBranch ID");
			int id = Integer.parseInt(input.nextLine());
			
			lb.setBranchID(id);
			
			System.out.println("Name of LibraryBranch?");
			String name = input.nextLine();
						
			System.out.println("Address of LibraryBranch?");
			String addr = input.nextLine();
			
			if(addr.isEmpty() == false)
			{
				lb.setBranchAddress(addr);
				service.updateBranchAddress(lb);
			}
			if(name.isEmpty() == false)
			{
				lb.setBranchName(name);
				service.updateBranchName(lb);
			}
			
			input.close();
		}
		catch(NumberFormatException e)
		{
			System.out.println("You have entered a non number");
		}
	}
	
	private void deleteLibraryBranch() throws SQLException
	{
		try {
			Scanner input = new Scanner(System.in);
			
			System.out.println("DELETE LibraryBranch");
			System.out.println("LibraryBranch ID to delete?");
			int id = Integer.parseInt(input.nextLine());
			
			service.deleteLibraryBranch(id);
			input.close();
		}
		catch(NumberFormatException e)
		{
			System.out.println("You have entered a non number");
		}
	}
	
	private void readAllLibraryBranches() throws SQLException
	{
		service.readAllLibraryBranches();
	}
}
