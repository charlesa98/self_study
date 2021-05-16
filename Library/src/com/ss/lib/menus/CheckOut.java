package com.ss.lib.menus;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.ss.lib.entity.Book;
import com.ss.lib.entity.BookLoans;
import com.ss.lib.entity.Borrower;
import com.ss.lib.entity.LibraryBranch;
import com.ss.lib.service.BorrowerService;

public class CheckOut {
	BorrowerService bs = new BorrowerService();

	private void header1()
	{
		System.out.println("\nHere are all the books available for your selected branch");
	}
	
	public void run(LibraryBranch lb, int cardNum)
	{
		header1();
		try {
			bs.readLibraryBranchBooksAvaialbe(lb, cardNum);
		}
		catch (Exception e)
		{
			e.printStackTrace();	
		}
	}
	public void run2(List<Book> bookList, Borrower bow, LibraryBranch lb) throws SQLException
	{
		Scanner input = new Scanner(System.in);
		
		int choice = Integer.parseInt(input.nextLine());
		Boolean quit = false;
		
		while(choice-1 <= bookList.size() && choice-1 >= 0 && quit != true)
		{	
			if(choice-1 == bookList.size())
			{
				System.out.println("Returning to previous menu\n\n");
				Main.run();
			}
			else
			{
				choice -= 1;		//this makes the choice = to the index of array since the array starts at index 0 but choice starts at 1
				Book[] bookArray = new Book[bookList.size()];
				bookArray = bookList.toArray(bookArray);
				
				Book b = new Book();
				
				b.setBookID(bookArray[choice].getBookID());
				b.setTitle(bookArray[choice].getTitle());
				b.setBookAuthorID(bookArray[choice].getBookAuthorID());
				b.setBookPubID(bookArray[choice].getBookPubID());
				
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  	//format the date and time
				LocalDateTime now = LocalDateTime.now();  					//the check out date
				LocalDateTime week = now.plusDays(7);						//the due date 1 week from checkout date
				
				System.out.println("You have picked "+b.getTitle()+" from branch "+lb.getBranchName());
				System.out.println("The checkout date is "+dtf.format(now));
				System.out.println("The due date is "+dtf.format(week));
				
				BookLoans loan = new BookLoans();
				loan.setLoanCardNum(bow);
				loan.setLoanBookID(b);
				loan.setLoanBranchID(lb);
				loan.setDateOut(dtf.format(now));
				loan.setDueDate(dtf.format(week));
				
				bs.createBookLoan(loan);
			}
		}
		input.close();
	}
}
