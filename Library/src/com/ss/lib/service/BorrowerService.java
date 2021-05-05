package com.ss.lib.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ss.lib.daos.BookCopiesDAO;
import com.ss.lib.daos.BookDAO;
import com.ss.lib.daos.BorrowerDAO;
import com.ss.lib.daos.LibraryBranchDAO;
import com.ss.lib.entity.Book;
import com.ss.lib.entity.BookCopies;
import com.ss.lib.entity.Borrower;
import com.ss.lib.entity.LibraryBranch;
import com.ss.lib.menus.Bow2O1;

public class BorrowerService {
	ConnectionUtil connUtil = new ConnectionUtil();
	
	public void readLibraryBranchNames(int cardNum) throws SQLException
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
	
	public void readLibraryBranchBooksAvaialbe(LibraryBranch lb) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			
			BookCopies copy = new BookCopies();
			copy.getCopyBranchID().setBranchID(lb.getBranchID());
			
			BookCopiesDAO bcdao = new BookCopiesDAO(conn);
			
			List<BookCopies> copyList = bcdao.getAllBookCopiesBranch(copy);
			
			int count = 1;
			for(BookCopies bc : copyList)
			{
				
				//maybe we have to get the id of the branch and book then do a print title from tbl_book where bookId = bc.getCopyBookId???
				
				System.out.println(bc.getCopyBranchID());
				System.out.println(bc.getCopyBookID());
				Book bookid = bc.getCopyBookID();
				//System.out.println(bookid.getTitle());
				//System.out.println(count+") "+bc.getCopyBookID().getTitle());
				count++;
			}
			System.out.println(count+") Quit\n");

			//go back to the menu to pick which book you want
			

		}catch (Exception e)
		{
			e.printStackTrace();	
		}
		finally
		{
			conn.close();					//close connection
		}
	}
}
