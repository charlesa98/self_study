package com.ss.utop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utop.entity.BookingPayment;

public class BookingPaymentDAO extends BaseDAO<BookingPayment>{
	
	public BookingPaymentDAO(Connection conn) {
		super(conn);
	}

	public Integer addBookingPayment(BookingPayment bp) throws ClassNotFoundException, SQLException
	{
		return saveWithPK("INSERT INTO booking_payment (booking_id, stripe_id, refund) VALUES (?, ?, ?)",
				new Object[] {bp.getBookingPaymentId().getId(), bp.getStripe(), bp.getRefund()});
	}
	
	public void updateBookingPayment(BookingPayment bp) throws ClassNotFoundException, SQLException
	{
		save("UPDATE booking_payment set stripe_id =? , refund = ? where booking_id = ?", 
				new Object[] {bp.getStripe(), bp.getRefund(), bp.getBookingPaymentId().getId()});
	}
	
	public void deleteBookingPayment(BookingPayment bp) throws ClassNotFoundException, SQLException
	{
		save("DELETE FROM booking_payment where booking_id = ?", new Object[] {bp.getBookingPaymentId()});
	}
	
	public List<BookingPayment> getAllBookingPayments() throws ClassNotFoundException, SQLException
	{
		return read("select * from booking_payment", null);
	}
	
	@Override
	public List<BookingPayment> extractData(ResultSet rs) throws ClassNotFoundException, SQLException
	{
		List<BookingPayment> bps = new ArrayList<>();
		
		while(rs.next())
		{
			BookingPayment bp = new BookingPayment();
			bp.getBookingPaymentId().setId(rs.getInt("id"));
			bp.setStripe(rs.getString("stripe_id"));
			bp.setRefund(rs.getInt("refund"));
			bps.add(bp);
		}
		return bps;
	}
}