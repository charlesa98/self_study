package com.ss.lib.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.lib.entity.BookCopies;
import com.ss.lib.entity.LibraryBranch;

public class BookCopiesDAO extends BaseDAO<BookCopies>{
	
	public BookCopiesDAO(Connection conn) {
		super(conn);
	}

	public Integer addBookCopies(BookCopies copy) throws ClassNotFoundException, SQLException
	{
		return saveWithPK("INSERT INTO tbl_book_copies (bookId, branchId, noOfCopies) VALUES (?, ?, ?)",
				new Object[] {copy.getCopyBookID().getBookID(), copy.getCopyBranchID().getBranchID(), copy.getNumCopies()});
	}
	
	public void updateBookCopies(BookCopies copy) throws ClassNotFoundException, SQLException
	{
		save("UPDATE tbl_book_copies set noOfCopies = ? where bookId = ? AND branchId = ?", 
				new Object[] {copy.getNumCopies(), copy.getCopyBookID().getBookID(), copy.getCopyBranchID().getBranchID()});
	}
	
	public void deleteBookCopies(BookCopies copy) throws ClassNotFoundException, SQLException
	{
		save("DELETE FROM tbl_book_copies where bookId = ? AND branchId = ?", new Object[] {copy.getCopyBookID().getBookID(), copy.getCopyBranchID().getBranchID()});
	}
	
	public List<BookCopies> getAllBookCopies() throws ClassNotFoundException, SQLException
	{
		return read("select * from tbl_book_copies", null);
		
	}
	
	public List<BookCopies> getAllBookCopiesBranch(BookCopies lb) throws ClassNotFoundException, SQLException
	{
		return read("select bookId from tbl_book_copies where noOfCopies >0 AND branchId = ?", new Object[] {lb.getCopyBranchID().getBranchID()});
		
	}
	
	@Override
	public List<BookCopies> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookCopies> copies = new ArrayList<>();
		
		while(rs.next())
		{
			BookCopies copy = new BookCopies();
			copy.getCopyBookID().setBookID(rs.getInt("bookId"));
			copy.getCopyBranchID().setBranchID(rs.getInt("branchId"));
			copy.setNumCopies(rs.getInt("noOfCopies"));
			copies.add(copy);
		}
		return copies;
	}
}
