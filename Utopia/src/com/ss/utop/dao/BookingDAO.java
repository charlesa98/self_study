package com.ss.utop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utop.entity.Booking;

public class BookingDAO extends BaseDAO<Booking>{
	
	public BookingDAO(Connection conn) {
		super(conn);
	}

	public Integer addBooking(Booking booking) throws ClassNotFoundException, SQLException
	{
		return saveWithPK("INSERT INTO booking (is_active, confirmation_code) VALUES (?, ?)",
				new Object[] {booking.getActive(), booking.getConfermationCode()});
	}
	
	public void updateBooking(Booking booking) throws ClassNotFoundException, SQLException
	{
		save("UPDATE booking set is_active =? , confirmation_code= ? where id = ?", 
				new Object[] {booking.getActive(), booking.getConfermationCode(), booking.getId()});
	}
	
	public void deleteBooking(Booking booking) throws ClassNotFoundException, SQLException
	{
		save("DELETE FROM booking where id = ?", new Object[] {booking.getId()});
	}
	
	public List<Booking> getAllBookings() throws ClassNotFoundException, SQLException
	{
		return read("select * from booking", null);
	}
	
	@Override
	public List<Booking> extractData(ResultSet rs) throws ClassNotFoundException, SQLException
	{
		List<Booking> bookings = new ArrayList<>();
		
		while(rs.next())
		{
			Booking booking = new Booking();
			booking.setId(rs.getInt("id"));
			booking.setActive(rs.getInt("is_active"));
			booking.setConfermationCode(rs.getString("confirmation_code"));
			bookings.add(booking);
		}
		return bookings;
	}
}
