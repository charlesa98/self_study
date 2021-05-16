package com.ss.lib.menus;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ss.lib.entity.Book;
import com.ss.lib.entity.BookLoans;
import com.ss.lib.service.BorrowerService;

public class Return {
	BorrowerService bs = new BorrowerService();
	private void header()
	{
		System.out.println("Returning a book. Please select your book you wish to return");
	}
	
	public void run(Integer cardNum)
	{
		try {
			//bs.readBookNamesReturn(cardNum);
			bs.readLoanedBooks(cardNum);
		}
		catch (Exception e)
		{
			e.printStackTrace();	
		}
	}	
	public void run2(List<Book> bookList, int cardNum) throws SQLException
	{
		header();
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
				//create an array to convert the list so we can get the index (choice+1) of the branch we want
				Book[] bookArray = new Book[bookList.size()];
				bookArray = bookList.toArray(bookArray);
				
				Book book = new Book();
				
				book.setBookID(bookArray[choice].getBookID());
				book.setTitle(bookArray[choice].getTitle());
				book.setBookAuthorID(bookArray[choice].getBookAuthorID());
				book.setBookPubID(bookArray[choice].getBookPubID());

			
				quit = true;
				
				System.out.println("You have selected book "+book.getTitle());
				
				BookLoans loan = new BookLoans();
				loan.setLoanBookID(book);
				loan.getLoanCardNum().setCardNum(cardNum);
				
				bs.returnBook(loan);
			}
		}
		input.close();
	}
}
