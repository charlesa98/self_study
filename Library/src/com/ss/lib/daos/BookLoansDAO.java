package com.ss.lib.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.lib.entity.BookLoans;

public class BookLoansDAO extends BaseDAO<BookLoans>{

	public BookLoansDAO(Connection conn) {
		super(conn);
	}

	/*
	 * must fix this so the bookid, branchid, and cardNo are all the primary keys
	 */
	
	public Integer addBookLoans(BookLoans loan) throws ClassNotFoundException, SQLException
	{
		return saveWithPK("INSERT INTO tbl_book_loans (bookId, branchId, cardNo, dateOut, dueDate) VALUES (?, ?, ?, ?, ?)",
				new Object[] {loan.getLoanBookID().getBookID(), loan.getLoanBranchID().getBranchID(), loan.getLoanCardNum().getCardNum(), 
						loan.getDateOut(), loan.getDueDate()});
	}
	
	public void updateBookLoans(BookLoans loan) throws ClassNotFoundException, SQLException
	{
		save("UPDATE tbl_book_loans set dateOut = ?, dueDate = ? where bookId = ? and branchId = ? and cardNo = ?", 
				new Object[] {loan.getDateOut(), loan.getDueDate(), loan.getLoanBookID().getBookID(), loan.getLoanBranchID().getBranchID(), 
						loan.getLoanCardNum().getCardNum()});
	}
	
	public void updateBookLoansDateOut(BookLoans loan) throws ClassNotFoundException, SQLException
	{
		save("UPDATE tbl_book_loans set dateOut = ? where bookId = ? and branchId = ? and cardNo = ?", 
				new Object[] {loan.getDateOut(), loan.getLoanBookID().getBookID(), loan.getLoanBranchID().getBranchID(), 
						loan.getLoanCardNum().getCardNum()});
	}
	
	public void updateBookLoansDueDate(BookLoans loan) throws ClassNotFoundException, SQLException
	{
		save("UPDATE tbl_book_loans set dueDate = ? where bookId = ? and branchId = ? and cardNo = ?", 
				new Object[] {loan.getDueDate(), loan.getLoanBookID().getBookID(), loan.getLoanBranchID().getBranchID(), 
						loan.getLoanCardNum().getCardNum()});
	}
	
	public void deleteBookLoans(BookLoans loan) throws ClassNotFoundException, SQLException
	{
		save("DELETE FROM tbl_book_loans where bookId = ? and branchId = ? and cardNo = ?", new Object[] {loan.getLoanBookID().getBookID(),
				loan.getLoanBranchID().getBranchID(), loan.getLoanCardNum().getCardNum()});
	}
	
	public void deleteBookLoanBookID(BookLoans loan) throws ClassNotFoundException, SQLException
	{
		save("DELETE FROM tbl_book_loans where bookId = ?", new Object[] {loan.getLoanBookID().getBookID()});
	}
	
	public void deleteBookLoanBookCard(BookLoans loan) throws ClassNotFoundException, SQLException
	{
		save("DELETE FROM tbl_book_loans where bookId = ? and cardNo = ?", new Object[] {loan.getLoanBookID().getBookID(), loan.getLoanCardNum().getCardNum()});
	}
	
	public List<BookLoans> getAllBookLoans() throws ClassNotFoundException, SQLException
	{
		return read("select * from tbl_book_loans", null);
	}
	
	public List<BookLoans> getBookLoans(BookLoans b) throws ClassNotFoundException, SQLException
	{
		return read("select a.* from tbl_book a, tbl_book_loans b where a.BookId = b.bookID AND b.cardNo = ?", new Object[] {b.getLoanCardNum().getCardNum()});	
	}
	
	@Override
	public List<BookLoans> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookLoans> loans = new ArrayList<>();
		
		while(rs.next())
		{
			BookLoans loan = new BookLoans();
			loan.getLoanBookID().setBookID(rs.getInt("bookId"));
			loan.getLoanBranchID().setBranchID(rs.getInt("branchId"));
			loan.getLoanCardNum().setCardNum(rs.getInt("cardNo"));
			loan.setDateOut(rs.getString("dateOut"));
			loan.setDueDate(rs.getString("dueDate"));
			loans.add(loan);
		}
		return loans;
	}
}
