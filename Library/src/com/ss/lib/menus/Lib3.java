package com.ss.lib.menus;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ss.lib.entity.Book;
import com.ss.lib.entity.BookCopies;
import com.ss.lib.entity.LibraryBranch;
import com.ss.lib.service.LibrarianService;

public class Lib3 {
	private LibrarianService service = new LibrarianService();
	private void header()
	{
		System.out.println("\n1) Update the details of the Library \n2) Add copies of a Book to the Branch \n"
				+ "3) Quit to previous menu");
	}
	
	public void run(LibraryBranch branch) throws SQLException
	{
		header();
		int choice = getInput();
		performAction(choice, branch);
	}
	
	private int getInput()
	{
		Scanner input = new Scanner(System.in);
		int choice = -1;
		while(choice > 0 || choice < 4)
		{
			try {
				choice = Integer.parseInt(input.nextLine());
				return choice;
			}catch (NumberFormatException e)
			{
				System.out.println("That is not a valid option. \nPlease enter a number between 1 and 3");
			}
		}
		input.close();
		return choice;
	}
	
	private void performAction(int choice, LibraryBranch branch) throws SQLException
	{
		switch(choice)
		{
		case 1:
			//this will get the branch to update based on what branch they are currently in
			updateBranch(branch);
			break;
			
		case 2:
			System.out.println("Add copies of a Book");
			//this will display the books currently in the branch 
			
			try {
				service.readLibraryBranchBooks(branch);
			}
			catch (Exception e)
			{
				e.printStackTrace();	
			}
			break;
			
		case 3:
			System.out.println("Going back");
			Lib2 l2 = new Lib2();
			l2.run();
			break;
			
		default:
			System.out.println("An error occured");
		}
	}
	
	private void updateBranch(LibraryBranch lb) throws SQLException
	{
		Scanner input = new Scanner(System.in);
		System.out.println("\nUPDATE LibraryBranch");
		
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
	
	public void updateBranchBook(List<Book> bookList, LibraryBranch lb) throws SQLException
	{
		System.out.println("\nWhich Book would you like to add?");
		Scanner input = new Scanner(System.in);
		
		int choice = Integer.parseInt(input.nextLine());
		Boolean quit = false;
		
		while(choice-1 <= bookList.size() && choice-1 >= 0 && quit != true)
		{	
			if(choice-1 == bookList.size())
			{
				System.out.println("Returning to previous menu\n\n");
				Lib2 l2 = new Lib2();
				l2.run();
			}
			else
			{
				choice -= 1;		//this makes the choice = to the index of array since the array starts at index 0 but choice starts at 1
				//create an array to convert the list so we can get the index (choice+1) of the book we want
				Book[] bookArray = new Book[bookList.size()];
				bookArray = bookList.toArray(bookArray);
				
				BookCopies bc = new BookCopies();

				bc.setCopyBookID(bookArray[choice]);
				bc.setCopyBranchID(lb);
				
				System.out.println("amount of copies of book "+bc.getCopyBookID().getBookID()+" at branch "+bc.getCopyBranchID().getBranchID() +
						" is ");
				
				
				
				
				
				System.out.println("What is the new amount of copies of this book at your location?");
				int amount = Integer.parseInt(input.nextLine());
				
				
				bc.setNumCopies(amount);
				
				service.updateCopies(bc);
				
				//System.out.print("Existing number of books at your branch: ");
				quit = true;
			}
		}
		input.close();
	}
}
