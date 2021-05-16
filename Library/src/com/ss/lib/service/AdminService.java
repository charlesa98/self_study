package com.ss.lib.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ss.lib.daos.*;
import com.ss.lib.entity.*;
import com.ss.lib.menus.Main;
/*
 * Main -> Admin1 -> Admin* ->AdminService
 */
public class AdminService {
	ConnectionUtil connUtil = new ConnectionUtil();

	//--------------------------AUTHOR-------------------------------------------
	public void addNewAuthor(Author a) throws SQLException 
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			Author temp = new Author();
			temp.setAuthorID(a.getAuthorID());
			temp.setAuthorName(a.getAuthorName());
			AuthorDAO adao = new AuthorDAO(conn);
			
			adao.addAuthor(temp);
			
			System.out.println("Added");
			conn.commit();					//if it is all good, commit the changes
		}catch (Exception e)
		{
			System.out.println("Something went wrong. You might have added 2 of the same author IDs");
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
			Main.run();						//calls the main menu run function to continue to run
		}
	}
	
	public void updateAuthor(Author a) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			Author temp = new Author();
			temp.setAuthorID(a.getAuthorID());
			temp.setAuthorName(a.getAuthorName());
			AuthorDAO adao = new AuthorDAO(conn);
			
			adao.updateAuthor(temp);
			
			System.out.println("Updated");
			conn.commit();					//if it is all good, commit the changes

		}catch (Exception e)
		{
			System.out.println("Something went wrong. The author ID may not exist");
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
			Main.run();
		}
	}	
	
	public void deleteAuthor(Integer id) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			Author temp = new Author();
			temp.setAuthorID(id);
			AuthorDAO adao = new AuthorDAO(conn);
			
			Book bookTemp = new Book();
			bookTemp.getBookAuthorID().setAuthorID(id); 
			BookDAO bdao = new BookDAO(conn);

			bdao.deleteBookAuthor(bookTemp); 		//need to delete the book with the deleted author
			adao.deleteAuthor(temp);			
			
			System.out.println("Deleted");
			conn.commit();					//if it is all good, commit the changes
		}catch (Exception e)
		{
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
			Main.run();
		}
	}

	public void readAllAuthors() throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AuthorDAO adao = new AuthorDAO(conn);
			
			
			List<Author> aList = adao.getAllAuthors();
			for(Author a: aList)
			{
				System.out.println(a.toString());
			}
		}catch (Exception e)
		{
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
			Main.run();
		}
	}
	
	public void showAllAuthors() throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AuthorDAO adao = new AuthorDAO(conn);
			
			
			List<Author> aList = adao.getAllAuthors();
			for(Author a: aList)
			{
				System.out.println(a.toString());
			}
		}catch (Exception e)
		{
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
		}
	}
	
	//---------------------------------BOOKS------------------------------------------------------
	public void addNewBook(Book b) throws SQLException 
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			Book temp = new Book();
			temp.setBookID(b.getBookID());
			temp.setTitle(b.getTitle());
			temp.setBookAuthorID(b.getBookAuthorID());
			temp.setBookPubID(b.getBookPubID());
			BookDAO bdao = new BookDAO(conn);
			
			bdao.addBook(temp);
			
			System.out.println("Added");
			conn.commit();					//if it is all good, commit the changes
		}catch (Exception e)
		{
			System.out.println("Something went wrong. You might have added 2 of the same Book IDs");
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
			Main.run();						//calls the main menu run function to continue to run
		}
	}
	
	public void updateBook(Book b) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			Book temp = new Book();
			//temp.setTitle(b.getTitle());
			temp.setBookAuthorID(b.getBookAuthorID());
			temp.setBookPubID(b.getBookPubID());
			BookDAO bdao = new BookDAO(conn);
			
			bdao.updateBook(temp);
			
			System.out.println("Updated");
			conn.commit();					//if it is all good, commit the changes

		}catch (Exception e)
		{
			System.out.println("Something went wrong. The author ID may not exist");
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
			Main.run();
		}
	}	
	
	public void updateBookTitle(Book b) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			Book temp = new Book();
			
			temp.setBookID(b.getBookID());
			temp.setTitle(b.getTitle());
			
			BookDAO bdao = new BookDAO(conn);
			
			bdao.updateBookTitle(temp);
			System.out.println("Updated");
			conn.commit();					//if it is all good, commit the changes

		}catch (Exception e)
		{
			System.out.println("Something went wrong. The ID might not exist");
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
		}
	}
	
	public void updateBookAuthor(Book b) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			Book temp = new Book();
			
			temp.setBookID(b.getBookID());
			temp.setBookAuthorID(b.getBookAuthorID());
			
			BookDAO bdao = new BookDAO(conn);
			
			bdao.updateBookAuthor(temp);
			System.out.println("Updated");
			conn.commit();					//if it is all good, commit the changes

		}catch (Exception e)
		{
			System.out.println("Something went wrong. The ID might not exist");
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
			Main.run();
		}
	}
	
	
	public void deleteBook(Integer id) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			Book temp = new Book();
			temp.setBookID(id);
			BookDAO bdao = new BookDAO(conn);
			
			BookCopies copiesTemp = new BookCopies();
			copiesTemp.getCopyBookID().setBookID(id);
			BookCopiesDAO bcdao = new BookCopiesDAO(conn);
			
			BookLoans loanTemp = new BookLoans();
			loanTemp.getLoanBookID().setBookID(id);
			BookLoansDAO bldao = new BookLoansDAO(conn);
			
			bldao.deleteBookLoanBookID(loanTemp);
			bcdao.deleteBookCopiesBookID(copiesTemp);
			bdao.deleteBook(temp);			
			
			System.out.println("Deleted");
			conn.commit();					//if it is all good, commit the changes
		}catch (Exception e)
		{
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
			Main.run();
		}
	}

	public void readAllBooks() throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookDAO bdao = new BookDAO(conn);
			
			
			List<Book> bList = bdao.getAllBooks();
			
			for(Book b : bList)
			{
				System.out.println(b.toString());
			}
		}catch (Exception e)
		{
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
			Main.run();
		}
	}
	
	public void showAllBooks() throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookDAO bdao = new BookDAO(conn);
			
			
			List<Book> bList = bdao.getAllBooks();
			
			for(Book b : bList)
			{
				System.out.println(b.toString());
			}
		}catch (Exception e)
		{
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
		}
	}
	
	//---------------BOOK COPIES--------------------------------------------------------------------------------
	public void addNewBookCopy(BookCopies bc) throws SQLException 
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookCopies temp = new BookCopies();
			temp.setCopyBookID(bc.getCopyBookID());
			temp.setCopyBranchID(bc.getCopyBranchID());
			temp.setNumCopies(bc.getNumCopies());

			BookCopiesDAO bcdao = new BookCopiesDAO(conn);
			
			bcdao.addBookCopies(temp);
			
			System.out.println("Added");
			conn.commit();					//if it is all good, commit the changes
		}catch (Exception e)
		{
			System.out.println("Something went wrong. One of the IDs might not exist");
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
			Main.run();						//calls the main menu run function to continue to run
		}
	}
	
	public void updateBookCopies(BookCopies bc) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookCopies temp = new BookCopies();
			temp.setCopyBookID(bc.getCopyBookID());
			temp.setCopyBranchID(bc.getCopyBranchID());
			temp.setNumCopies(bc.getNumCopies());

			BookCopiesDAO bcdao = new BookCopiesDAO(conn);
			
			bcdao.updateBookCopies(temp);
			System.out.println("Updated");
			conn.commit();					//if it is all good, commit the changes

		}catch (Exception e)
		{
			System.out.println("Something went wrong. One of the IDs might not exist");
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
			Main.run();
		}
	}	
	
	/*
	 * this will require both the book id and branch id
	 */
	
	public void deleteBookCopies(Integer id) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookCopies temp = new BookCopies();
			
			BookCopiesDAO bdao = new BookCopiesDAO(conn);

			
			bdao.deleteBookCopies(temp);			
			
			System.out.println("Deleted");
			conn.commit();					//if it is all good, commit the changes
		}catch (Exception e)
		{
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
			Main.run();
		}
	}

	public void readAllBookCopies() throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookCopiesDAO bcdao = new BookCopiesDAO(conn);
			
			
			List<BookCopies> bcList = bcdao.getAllBookCopies();
			for(BookCopies bc : bcList)
			{
				System.out.println(bc.toString());
			}
		}catch (Exception e)
		{
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
			Main.run();
		}
	}
	
	public void showAllBookCopies() throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookCopiesDAO bcdao = new BookCopiesDAO(conn);
			
			
			List<BookCopies> bcList = bcdao.getAllBookCopies();
			for(BookCopies bc : bcList)
			{
				System.out.println(bc.toString());
			}
		}catch (Exception e)
		{
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
		}
	}
	//---------------BOOK LOANS--------------------------------------------------------------------------------
	public void addNewBookLoan(BookLoans bl) throws SQLException 
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookLoans temp = new BookLoans();
			
			temp.setLoanBookID(bl.getLoanBookID());
			temp.setLoanBranchID(bl.getLoanBranchID());
			temp.setLoanCardNum(bl.getLoanCardNum());
			temp.setDateOut(bl.getDateOut());
			temp.setDueDate(bl.getDueDate());

			BookLoansDAO bldao = new BookLoansDAO(conn);
			
			bldao.addBookLoans(temp);
			
			System.out.println("Added");
			conn.commit();					//if it is all good, commit the changes
		}catch (Exception e)
		{
			System.out.println("Something went wrong. One of the IDs might not exist");
			conn.rollback();				//if it fails, roll back
		}
		finally
		{ 
			System.out.println("\n");
			Main.run();						//calls the main menu run function to continue to run
		}
	}
	
	public void updateBookLoan(BookLoans bl) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookLoans temp = new BookLoans();
			
			temp.setLoanBookID(bl.getLoanBookID());
			temp.setLoanBranchID(bl.getLoanBranchID());
			temp.setLoanCardNum(bl.getLoanCardNum());
			temp.setDateOut(bl.getDateOut());
			temp.setDueDate(bl.getDueDate());

			BookLoansDAO bldao = new BookLoansDAO(conn);
			
			bldao.updateBookLoans(temp);
			System.out.println("Updated");
			conn.commit();					//if it is all good, commit the changes

		}catch (Exception e)
		{
			System.out.println("Something went wrong. One of the IDs might not exist");
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
			Main.run();
		}
	}	
	
	public void deleteBookLoan(BookLoans bl) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookLoans temp = new BookLoans();
			temp.setLoanBookID(bl.getLoanBookID());
			temp.setLoanBranchID(bl.getLoanBranchID());
			temp.setLoanCardNum(bl.getLoanCardNum());
			temp.setDateOut(bl.getDateOut());
			temp.setDueDate(bl.getDueDate());
			
			BookLoansDAO bdao = new BookLoansDAO(conn);

			
			bdao.deleteBookLoans(temp);			
			
			System.out.println("Deleted");
			conn.commit();					//if it is all good, commit the changes
		}catch (Exception e)
		{
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
			Main.run();
		}
	}

	public void readAllBookLoans() throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookLoansDAO bldao = new BookLoansDAO(conn);
			
			
			List<BookLoans> blList = bldao.getAllBookLoans();
			for(BookLoans bl : blList)
			{
				System.out.println(bl.toString());
			}
		}catch (Exception e)
		{
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
			Main.run();
		}
	}	
	
	public void showAllBookLoans() throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookLoansDAO bldao = new BookLoansDAO(conn);
			
			
			List<BookLoans> blList = bldao.getAllBookLoans();
			for(BookLoans bl : blList)
			{
				System.out.println(bl.toString());
			}
		}catch (Exception e)
		{
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
		}
	}	
	
//---------------BORROWER--------------------------------------------------------------------------------
	public void addNewBorrower(Borrower borw) throws SQLException 
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			Borrower temp = new Borrower();
			
			temp.setCardNum(borw.getCardNum());
			temp.setbName(borw.getbName());
			temp.setbAddress(borw.getbAddress());
			temp.setbPhone(borw.getbPhone());
			
			BorrowerDAO borwdao = new BorrowerDAO(conn);
			
			borwdao.addBorrower(temp);
			
			System.out.println("Added");
			conn.commit();					//if it is all good, commit the changes
		}catch (Exception e)
		{
			System.out.println("Something went wrong. One of the IDs might not exist");
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
			Main.run();						//calls the main menu run function to continue to run
		}
	}
	
	public void updateBorrower(Borrower borw) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			Borrower temp = new Borrower();
			
			temp.setCardNum(borw.getCardNum());
			temp.setbName(borw.getbName());
			temp.setbAddress(borw.getbAddress());
			temp.setbPhone(borw.getbPhone());
			
			BorrowerDAO borwdao = new BorrowerDAO(conn);
			
			borwdao.updateBorrower(temp);
			System.out.println("Updated");
			conn.commit();					//if it is all good, commit the changes

		}catch (Exception e)
		{
			System.out.println("Something went wrong. One of the IDs might not exist");
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
			Main.run();
		}
	}
	
	public void updateBorrowerName(Borrower borw) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			Borrower temp = new Borrower();
			
			temp.setCardNum(borw.getCardNum());
			temp.setbName(borw.getbName());
			
			BorrowerDAO borwdao = new BorrowerDAO(conn);
			
			borwdao.updateBorrowerName(temp);
			System.out.println("Updated");
			conn.commit();					//if it is all good, commit the changes

		}catch (Exception e)
		{
			System.out.println("Something went wrong. One of the IDs might not exist");
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
		}
	}
	
	public void updateBorrowerAddress(Borrower borw) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			Borrower temp = new Borrower();
			
			temp.setCardNum(borw.getCardNum());
			temp.setbAddress(borw.getbAddress());			
			BorrowerDAO borwdao = new BorrowerDAO(conn);
			
			borwdao.updateBorrowerAddress(temp);
			System.out.println("Updated");
			conn.commit();					//if it is all good, commit the changes

		}catch (Exception e)
		{
			System.out.println("Something went wrong. One of the IDs might not exist");
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
		}
	}
	
	public void updateBorrowerPhone(Borrower borw) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			Borrower temp = new Borrower();
			
			temp.setCardNum(borw.getCardNum());
			temp.setbPhone(borw.getbPhone());		
			BorrowerDAO borwdao = new BorrowerDAO(conn);
			
			borwdao.updateBorrowerPhone(temp);
			System.out.println("Updated");
			conn.commit();					//if it is all good, commit the changes

		}catch (Exception e)
		{
			System.out.println("Something went wrong. One of the IDs might not exist");
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
		}
	}
	
	public void deleteBorrower(int id) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			Borrower temp = new Borrower();
			temp.setCardNum(id);
			BorrowerDAO borwdao = new BorrowerDAO(conn);
			
			borwdao.deleteBorrower(temp);			
			
			System.out.println("Deleted");
			conn.commit();					//if it is all good, commit the changes
		}catch (Exception e)
		{
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
			Main.run();
		}
	}

	public void readAllBorrowers() throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BorrowerDAO borwdao = new BorrowerDAO(conn);			
			
			List<Borrower> borwList = borwdao.getAllBorrowers();
			
			for(Borrower borw : borwList)
			{
				System.out.println(borw.toString());
			}
		}catch (Exception e)
		{
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
			Main.run();
		}
	}	
	
	public void showAllBorrowers() throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BorrowerDAO borwdao = new BorrowerDAO(conn);			
			
			List<Borrower> borwList = borwdao.getAllBorrowers();
			
			for(Borrower borw : borwList)
			{
				System.out.println(borw.toString());
			}
		}catch (Exception e)
		{
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
		}
	}	
	
//---------------LIBRARY BRANCHES--------------------------------------------------------------------------------
	public void addNewLibraryBranch(LibraryBranch lb) throws SQLException 
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			LibraryBranch temp = new LibraryBranch();
			
			temp.setBranchID(lb.getBranchID());
			temp.setBranchName(lb.getBranchName());
			temp.setBranchAddress(lb.getBranchAddress());
			
			LibraryBranchDAO lbdao = new LibraryBranchDAO(conn);
			
			lbdao.addLibraryBranch(temp);
			
			System.out.println("Added");
			conn.commit();					//if it is all good, commit the changes
		}catch (Exception e)
		{
			System.out.println("Something went wrong. One of the IDs might exist already");
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
			Main.run();						//calls the main menu run function to continue to run
		}
	}
	
	public void updateLibraryBranch(LibraryBranch lb) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			LibraryBranch temp = new LibraryBranch();
			
			temp.setBranchID(lb.getBranchID());
			temp.setBranchName(lb.getBranchName());
			temp.setBranchAddress(lb.getBranchAddress());
			
			LibraryBranchDAO lbdao = new LibraryBranchDAO(conn);
			
			lbdao.updateLibraryBranch(temp);
			System.out.println("Updated");
			conn.commit();					//if it is all good, commit the changes

		}catch (Exception e)
		{
			System.out.println("Something went wrong. One of the IDs might not exist");
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
			Main.run();
		}
	}
	
	public void updateBranchName(LibraryBranch lb) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			LibraryBranch temp = new LibraryBranch();
			
			temp.setBranchID(lb.getBranchID());
			temp.setBranchName(lb.getBranchName());
			
			LibraryBranchDAO lbdao = new LibraryBranchDAO(conn);
			
			lbdao.updateLibraryBranchName(temp);
			System.out.println("Updated");
			conn.commit();					//if it is all good, commit the changes

		}catch (Exception e)
		{
			System.out.println("Something went wrong. One of the IDs might not exist");
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
		}
	}
	
	public void updateBranchAddress(LibraryBranch lb) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			LibraryBranch temp = new LibraryBranch();
			
			temp.setBranchID(lb.getBranchID());
			temp.setBranchAddress(lb.getBranchAddress());
			
			LibraryBranchDAO lbdao = new LibraryBranchDAO(conn);
			
			lbdao.updateLibraryBranchAddress(temp);
			System.out.println("Updated");
			conn.commit();					//if it is all good, commit the changes

		}catch (Exception e)
		{
			System.out.println("Something went wrong. One of the IDs might not exist");
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
		}
	}
	public void deleteLibraryBranch(int id) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			LibraryBranch temp = new LibraryBranch();
			temp.setBranchID(id);
			LibraryBranchDAO lbdao = new LibraryBranchDAO(conn);
			
			lbdao.deleteLibraryBranch(temp);			
			
			System.out.println("Deleted");
			conn.commit();					//if it is all good, commit the changes
		}catch (Exception e)
		{
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
			Main.run();
		}
	}

	public void readAllLibraryBranches() throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			LibraryBranchDAO lbdao = new LibraryBranchDAO(conn);			
			
			List<LibraryBranch> lbList = lbdao.getAllLibraryBranchs();
			
			for(LibraryBranch lb : lbList)
			{
				System.out.println(lb.toString());
			}
		}catch (Exception e)
		{
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
			Main.run();
		}
	}	
	
	public void showAllLibraryBranches() throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			LibraryBranchDAO lbdao = new LibraryBranchDAO(conn);			
			
			List<LibraryBranch> lbList = lbdao.getAllLibraryBranchs();
			
			for(LibraryBranch lb : lbList)
			{
				System.out.println(lb.toString());
			}
		}catch (Exception e)
		{
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
		}
	}	
	
//---------------PUBLISHERS--------------------------------------------------------------------------------
	public void addNewPublisher(Publisher pub) throws SQLException 
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			Publisher temp = new Publisher();
			
			temp.setPublisherID(pub.getPublisherID());
			temp.setPublisherName(pub.getPublisherName());
			temp.setPublisherAddress(pub.getPublisherAddress());
			temp.setPublisherPhone(pub.getPublisherPhone());

			PublisherDAO pubdao = new PublisherDAO(conn);
			
			pubdao.addPublisher(temp);
			
			System.out.println("Added");
			conn.commit();					//if it is all good, commit the changes
		}catch (Exception e)
		{
			System.out.println("Something went wrong. One of the IDs might not exist");
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
			Main.run();						//calls the main menu run function to continue to run
		}
	}
	
	public void updatePublisher(Publisher pub) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			Publisher temp = new Publisher();
			
			temp.setPublisherID(pub.getPublisherID());
			temp.setPublisherName(pub.getPublisherName());
			temp.setPublisherAddress(pub.getPublisherAddress());
			temp.setPublisherPhone(pub.getPublisherPhone());

			PublisherDAO pubdao = new PublisherDAO(conn);
			
			pubdao.updatePublisher(temp);
			System.out.println("Updated");
			conn.commit();					//if it is all good, commit the changes

		}catch (Exception e)
		{
			System.out.println("Something went wrong. One of the IDs might not exist");
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
			Main.run();
		}
	}
	
	public void updatePublisherName(Publisher pub) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			Publisher temp = new Publisher();
			
			temp.setPublisherID(pub.getPublisherID());
			temp.setPublisherName(pub.getPublisherName());

			PublisherDAO pubdao = new PublisherDAO(conn);
			
			pubdao.updatePublisherName(temp);
			System.out.println("Updated");
			conn.commit();					//if it is all good, commit the changes

		}catch (Exception e)
		{
			System.out.println("Something went wrong. One of the IDs might not exist");
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
		}
	}
	
	public void updatePublisherAddress(Publisher pub) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			Publisher temp = new Publisher();
			
			temp.setPublisherID(pub.getPublisherID());
			temp.setPublisherAddress(pub.getPublisherAddress());

			PublisherDAO pubdao = new PublisherDAO(conn);
			
			pubdao.updatePublisherAddress(temp);
			System.out.println("Updated");
			conn.commit();					//if it is all good, commit the changes

		}catch (Exception e)
		{
			System.out.println("Something went wrong. One of the IDs might not exist");
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
		}
	}
	
	public void updatePublisherPhone(Publisher pub) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			Publisher temp = new Publisher();
			
			temp.setPublisherID(pub.getPublisherID());
			temp.setPublisherPhone(pub.getPublisherPhone());

			PublisherDAO pubdao = new PublisherDAO(conn);
			
			pubdao.updatePublisherPhone(temp);
			System.out.println("Updated");
			conn.commit();					//if it is all good, commit the changes

		}catch (Exception e)
		{
			System.out.println("Something went wrong. One of the IDs might not exist");
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
		}
	}
	
	public void deletePublisher(int id) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			Publisher temp = new Publisher();
			temp.setPublisherID(id);
			PublisherDAO pubdao = new PublisherDAO(conn);
			
			Book bookTemp = new Book();
			bookTemp.getBookPubID().setPublisherID(id);
			BookDAO bdao = new BookDAO(conn);

			bdao.deleteBookPublisher(bookTemp); 			//delete the book with the publisher id
			pubdao.deletePublisher(temp);			
			
			System.out.println("Deleted");
			conn.commit();					//if it is all good, commit the changes
		}catch (Exception e)
		{
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
			Main.run();
		}
	}

	public void readAllPublishers() throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			PublisherDAO pubdao = new PublisherDAO(conn);
			
			
			List<Publisher> pList = pubdao.getAllPublishers();
			
			for(Publisher p : pList)
			{
				System.out.println(p.toString());
			}
		}catch (Exception e)
		{
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
			Main.run();
		}
	}
	
	public void showAllPublishers() throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			PublisherDAO pubdao = new PublisherDAO(conn);
			
			
			List<Publisher> pList = pubdao.getAllPublishers();
			
			for(Publisher p : pList)
			{
				System.out.println(p.toString());
			}
		}catch (Exception e)
		{
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
		}
	}
}
