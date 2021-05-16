package com.ss.lib.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.lib.daos.BookDAO;
import com.ss.lib.daos.BookLoansDAO;
import com.ss.lib.daos.LibraryBranchDAO;
import com.ss.lib.entity.Book;
import com.ss.lib.entity.BookCopies;
import com.ss.lib.entity.BookLoans;
import com.ss.lib.entity.Borrower;
import com.ss.lib.entity.LibraryBranch;
import com.ss.lib.menus.Bow2O1;
import com.ss.lib.menus.CheckOut;
import com.ss.lib.menus.Main;
import com.ss.lib.menus.Return;

public class BorrowerService {
	ConnectionUtil connUtil = new ConnectionUtil();
	
	public void readLibraryBranchNamesCheckOut(int cardNum) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			LibraryBranchDAO ldao = new LibraryBranchDAO(conn);	
			
			List<LibraryBranch> branchList = ldao.getAllLibraryBranchs();
			
			System.out.println("\nHere are all the branches:");
			int count = 1;
			for(LibraryBranch b : branchList)
			{
				System.out.println(count+") "+b.getBranchName()+", "+b.getBranchAddress());
				count++;
			}
			System.out.println(count+") Quit\n");
			
			Bow2O1 b2 = new Bow2O1();
			b2.run2(branchList, cardNum);
		}catch (Exception e)
		{
			e.printStackTrace();	
		}
		finally
		{
			conn.close();					//close connection
		}
	}
	
	public void readLibraryBranchBooksAvaialbe(LibraryBranch lb, int cardNum) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			
			Borrower bow = new Borrower();
			bow.setCardNum(cardNum);
			
			BookCopies copy = new BookCopies();
			copy.getCopyBranchID().setBranchID(lb.getBranchID());
			

			int branchNum = lb.getBranchID();
			
			List<Book> bookList = new ArrayList<>();
			
			int count = 1;
			try {
				conn = connUtil.getConnection();
				String sql = "select a.* from tbl_book a, tbl_book_copies b where noOfCopies > 0 and a.bookId = b.bookId and b.branchId = '"+branchNum+"'";
				
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				ResultSet rs = pstmt.executeQuery(sql);
							
				while(rs.next())
				{
					Book book = new Book();
					book.setBookID(rs.getInt("bookId"));
					book.setTitle(rs.getString("title"));
					book.getBookAuthorID().setAuthorID(rs.getInt("authId"));
					book.getBookPubID().setPublisherID(rs.getInt("pubId"));
					System.out.println(count+") "+ rs.getString("title"));
					bookList.add(book);
					count++;
				}
			}catch(Exception e)
			{
				System.out.println("Something went wrong with entering the branch");
			}
			
	
			System.out.println(count+") Quit\n");

			//go back to the menu to pick which book you want
			CheckOut cout = new CheckOut();
			cout.run2(bookList, bow, lb);

		}catch (Exception e)
		{
			e.printStackTrace();	
		}
		finally
		{
			conn.close();					//close connection
		}
	}
	
	public void readBooks(BookCopies bc) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookDAO bdao = new BookDAO(conn);	
			
			List<Book> bookList = bdao.getAllBookID(bc);
			
			System.out.println("\nHere are all the books with the branch Id");
			int count = 1;
			for(Book book : bookList)
			{
				System.out.println(count+") "+book.getTitle()+", ");
				count++;
			}
			System.out.println(count+") Quit\n");

		}catch (Exception e)
		{
			e.printStackTrace();	
		}
		finally
		{
			conn.close();					//close connection
		}
	}
	
	public void createBookLoan(BookLoans bl) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookLoans temp = new BookLoans();
			temp.setLoanCardNum(bl.getLoanCardNum());
			temp.setLoanBookID(bl.getLoanBookID());
			temp.setLoanBranchID(bl.getLoanBranchID());
			temp.setDateOut(bl.getDateOut());
			temp.setDueDate(bl.getDueDate());
			BookLoansDAO bldao = new BookLoansDAO(conn);
			
			bldao.addBookLoans(temp);
			
			System.out.println("Added");
			conn.commit();					//if it is all good, commit the changes
		}catch (Exception e)
		{
			System.out.println("Something went wrong. Loan could not have been done. Returning to main menu");
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
			Main.run();						//calls the main menu run function to continue to run
		}
	}
	
	public void readLoanedBooks(int cardNum) throws SQLException
	{
		Connection conn = null;
		
		List<Book> bookList = new ArrayList<>();
		
		int count = 1;
		try {
			conn = connUtil.getConnection();
			String sql = "select a.* from tbl_book a, tbl_book_loans b where a.BookId = b.bookID AND b.cardNo = '"+cardNum+"'";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery(sql);
			System.out.println(" ");
			
			while(rs.next())
			{
				Book book = new Book();
				book.setBookID(rs.getInt("bookId"));
				book.setTitle(rs.getString("title"));
				book.getBookAuthorID().setAuthorID(rs.getInt("authId"));
				book.getBookPubID().setPublisherID(rs.getInt("pubId"));
				System.out.println(count+") "+ rs.getString("title"));
				bookList.add(book);
				count++;
			}
		}catch(Exception e)
		{
			System.out.println("Something went wrong with showing your book loans");
		}
		
		System.out.println(count+") Quit\n");
		
		Return ret = new Return();
		ret.run2(bookList, cardNum);
	}
	
	public void returnBook(BookLoans loan) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookLoans temp = new BookLoans();
			temp.setLoanCardNum(loan.getLoanCardNum());
			temp.setLoanBookID(loan.getLoanBookID());
			temp.setLoanBranchID(loan.getLoanBranchID());
			temp.setDateOut(loan.getDateOut());
			temp.setDueDate(loan.getDueDate());
			BookLoansDAO bldao = new BookLoansDAO(conn);
			
			bldao.deleteBookLoanBookCard(loan);
			
			System.out.println("Loan removed. Thank you for retuning the book");
			conn.commit();					//if it is all good, commit the changes
		}catch (Exception e)
		{
			System.out.println("Something went wrong. Loan could be deleted. Returning to main menu");
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
			Main.run();						//calls the main menu run function to continue to run
		}
	}
}
