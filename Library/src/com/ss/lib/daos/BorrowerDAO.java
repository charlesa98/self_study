package com.ss.lib.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.lib.entity.Borrower;

public class BorrowerDAO extends BaseDAO<Borrower>{

	public BorrowerDAO(Connection conn) {
		super(conn);
	}

	public Integer addBorrower(Borrower bow) throws ClassNotFoundException, SQLException
	{
		return saveWithPK("INSERT INTO tbl_borrower (cardNo, name, address, phone) VALUES (?, ?, ?, ?)",
				new Object[] {bow.getCardNum(), bow.getbName(), bow.getbAddress(), bow.getbPhone()});
	}
	
	public void updateBorrower(Borrower bow) throws ClassNotFoundException, SQLException
	{
		save("UPDATE tbl_borrower set name = ?, address = ?, phone = ? where cardNo = ?", 
				new Object[] {bow.getbName(), bow.getbAddress(), bow.getbPhone(), bow.getCardNum()});
	}
	
	public void updateBorrowerName(Borrower bow) throws ClassNotFoundException, SQLException
	{
		save("UPDATE tbl_borrower set name = ? where cardNo = ?", 
				new Object[] {bow.getbName(), bow.getCardNum()});
	}
	
	public void updateBorrowerAddress(Borrower bow) throws ClassNotFoundException, SQLException
	{
		save("UPDATE tbl_borrower set address = ? where cardNo = ?", 
				new Object[] {bow.getbAddress(), bow.getCardNum()});
	}
	
	public void updateBorrowerPhone(Borrower bow) throws ClassNotFoundException, SQLException
	{
		save("UPDATE tbl_borrower set phone = ? where cardNo = ?", 
				new Object[] {bow.getbPhone(), bow.getCardNum()});
	}
	
	public void deleteBorrower(Borrower bow) throws ClassNotFoundException, SQLException
	{
		save("DELETE FROM tbl_borrower where cardNo = ?", new Object[] {bow.getCardNum()});
	}
	
	public List<Borrower> getAllBorrowers() throws ClassNotFoundException, SQLException
	{
		return read("select * from tbl_borrower", null);
		
	}
	
	public void checkCard(Borrower bow) throws ClassNotFoundException, SQLException
	{
		save("select cardNo from tbl_borrower where cardNo = ?", new Object[] {bow.getCardNum()});
	}
	
	@Override
	public List<Borrower> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Borrower> bows = new ArrayList<>();
		
		while(rs.next())
		{
			Borrower bow = new Borrower();
			bow.setCardNum(rs.getInt("cardNo"));
			bow.setbName(rs.getString("name"));
			bow.setbAddress(rs.getString("address"));
			bow.setbPhone(rs.getString("phone"));
			bows.add(bow);
		}
		return bows;
	}
}
