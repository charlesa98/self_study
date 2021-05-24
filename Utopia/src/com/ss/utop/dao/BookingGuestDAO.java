package com.ss.utop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utop.entity.BookingGuest;

public class BookingGuestDAO extends BaseDAO<BookingGuest>{
	
	public BookingGuestDAO(Connection conn) {
		super(conn);
	}

	public Integer addBookingGuest(BookingGuest bg) throws ClassNotFoundException, SQLException
	{
		return saveWithPK("INSERT INTO booking_guest (booking_id, contact_email, contact_phone) VALUES (?, ?, ?)",
				new Object[] {bg.getBookingId().getId(), bg.getEmail(), bg.getPhone()});
	}
	
	public void updateBookingGuest(BookingGuest bg) throws ClassNotFoundException, SQLException
	{
		save("UPDATE booking_guest set contact_email =? , contact_phone = ? where booking_id = ?", 
				new Object[] {bg.getEmail(), bg.getPhone(), bg.getBookingId().getId()});
	}
	
	public void deleteBookingGuest(BookingGuest bg) throws ClassNotFoundException, SQLException
	{
		save("DELETE FROM booking_guest where booking_id = ?", new Object[]{bg.getBookingId()});
	}
	
	public List<BookingGuest> getAllBookingGuests() throws ClassNotFoundException, SQLException
	{
		return read("select * from booking_guest", null);
	}
	
	@Override
	public List<BookingGuest> extractData(ResultSet rs) throws ClassNotFoundException, SQLException
	{
		List<BookingGuest> guests = new ArrayList<>();
		
		while(rs.next())
		{
			BookingGuest guest = new BookingGuest();
			guest.getBookingId().setId(rs.getInt("booking_id"));
			guest.setEmail(rs.getString("contact_email"));
			guest.setPhone(rs.getInt("contact_phone"));
			guests.add(guest);
		}
		return guests;
	}
}
