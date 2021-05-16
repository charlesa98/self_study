package com.ss.lib.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

/*
 * Main -> Lib1 -> Lib2 
 * Main -> Lib1 -> Lib2 -> Lib3
 */

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
	
	public void addBookCopies(BookCopies bc) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookCopies temp = new BookCopies();
			
			temp.setCopyBookID(bc.getCopyBookID());
			temp.setCopyBranchID(bc.getCopyBranchID());
			temp.setNumCopies(bc.getNumCopies());
			
			BookCopiesDAO cdao = new BookCopiesDAO(conn);
			
			cdao.addBookCopies(temp);
			conn.commit();					//if it is all good, commit the changes
			
		}catch (Exception e)
		{
			System.out.println("Something went wrong.");
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
		}
	}
	
	public void updateCopies(BookCopies bc, LibraryBranch lb) throws SQLException
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
			
			System.out.println("updated");
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
			l3.run(lb);						//send the branch back to the run method
		}
	}
	
	public List<BookCopies> showCopies(int branchNum, int bookNum)
	{
		ConnectionUtil connUtil = new ConnectionUtil();
		Connection conn = null;
		
		List<BookCopies> copiesList = new ArrayList<>();
		
		try {
			conn = connUtil.getConnection();
			String sql = "Select * from tbl_book_copies where branchId = '"+branchNum+"' and bookId = '"+bookNum+"'";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery(sql);
			if(rs.next())
			{
				BookCopies copies = new BookCopies();
				copies.getCopyBookID().setBookID(rs.getInt("bookId"));
				copies.getCopyBranchID().setBranchID(rs.getInt("branchId"));
				copies.setNumCopies(rs.getInt("noOfCopies"));
				
				copiesList.add(copies);
			}
			else
			{
				BookCopies bc = new BookCopies();
				Book b = new Book();
				LibraryBranch lb = new LibraryBranch();
				b.setBookID(bookNum);
				lb.setBranchID(branchNum);
				
				bc.setCopyBookID(b);
				bc.setCopyBranchID(lb);
				bc.setNumCopies(0);
				
				try {
					BookCopiesDAO bcdao = new BookCopiesDAO(conn);
				
					bcdao.addBookCopies(bc);
					conn.commit();
				}catch(Exception e)
				{
					System.out.println("Something went wrong");
				}
				finally
				{
					copiesList.add(bc);
				}
			}
		}catch(Exception e)
		{
			System.out.println("Something went wrong");
		}
	
		return copiesList;
	}
}
