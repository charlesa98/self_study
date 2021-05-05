package com.ss.lib.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ss.lib.daos.BookCopiesDAO;
import com.ss.lib.daos.BookDAO;
import com.ss.lib.daos.LibraryBranchDAO;
import com.ss.lib.entity.Book;
import com.ss.lib.entity.BookCopies;
import com.ss.lib.entity.LibraryBranch;
import com.ss.lib.menus.Lib2;
import com.ss.lib.menus.Lib3;
import com.ss.lib.menus.Main;

public class LibrarianService {
	ConnectionUtil connUtil = new ConnectionUtil();
	
	public void readLibraryBranchNames() throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			LibraryBranchDAO ldao = new LibraryBranchDAO(conn);	
			
			List<LibraryBranch> branchList = ldao.getAllLibraryBranchs();
				
			int count = 1;
			for(LibraryBranch b : branchList)
			{
				System.out.println(count+") "+b.getBranchName()+", "+b.getBranchAddress());
				count++;
			}
			System.out.println(count+") Quit\n");
			
			Lib2 l2 = new Lib2();
			l2.run2(branchList);
		}catch (Exception e)
		{
			e.printStackTrace();	
		}
		finally
		{
			conn.close();					//close connection
		}
	}
	
	public void readLibraryBranchBooks(LibraryBranch lb) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookDAO bdao = new BookDAO(conn);
			
			List<Book> bookList = bdao.getAllBooks();
				
			int count = 1;
			for(Book b : bookList)
			{
				System.out.println(count+") "+b.getTitle());
				count++;
			}
			System.out.println(count+") Quit\n");
			
			Lib3 l3 = new Lib3();
			l3.updateBranchBook(bookList, lb);

		}catch (Exception e)
		{
			e.printStackTrace();	
		}
		finally
		{
			conn.close();					//close connection
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
			Main.run();
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
			Main.run();
		}
	}
	
	public void addBookToBranch(LibraryBranch lb, Book book, Integer num) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookCopies temp = new BookCopies();
			
			temp.setCopyBookID(book);
			temp.setCopyBranchID(lb);
			temp.setNumCopies(num);
			
			BookCopiesDAO cdao = new BookCopiesDAO(conn);
			
			cdao.updateBookCopies(temp);
			
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
	
	public void getCopies(Integer lb, Integer book) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			//BookCopies temp = new BookCopies();
			
			//temp.setCopyBookID(book);
			//temp.setCopyBranchID(lb);
			
			//BookCopiesDAO cdao = new BookCopiesDAO(conn);
			

			
			System.out.println();
			
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
			Lib3 l3 = new Lib3();
			l3.run(null);
		}
	}
	
	public void updateCopies(BookCopies bc) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookCopies temp = new BookCopies();
			
			temp.setCopyBookID(bc.getCopyBookID());
			temp.setCopyBranchID(bc.getCopyBranchID());
			temp.setNumCopies(bc.getNumCopies());
			
			BookCopiesDAO cdao = new BookCopiesDAO(conn);
			
			cdao.updateBookCopies(temp);
			
			System.out.println("Added");
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
			Lib3 l3 = new Lib3();
			l3.run(null);
		}
	}

}
