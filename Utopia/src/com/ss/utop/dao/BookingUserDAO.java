package com.ss.utop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utop.entity.BookingUser;

public class BookingUserDAO extends BaseDAO<BookingUser>{
	
	public BookingUserDAO(Connection conn) {
		super(conn);
	}

	public Integer addBookingUser(BookingUser bu) throws ClassNotFoundException, SQLException
	{
		return saveWithPK("INSERT INTO booking_user (booking_id, user_id) VALUES (?, ?)",
				new Object[] {bu.getBookingUserId().getId(), bu.getUserId()});
	}
	
	public void updateBookingUser(BookingUser bu) throws ClassNotFoundException, SQLException
	{
		save("UPDATE booking_user set user_id =? where booking_id = ?", 
				new Object[] {bu.getUserId(), bu.getBookingUserId().getId()});
	}
	
	public void deleteBookingUser(BookingUser bu) throws ClassNotFoundException, SQLException
	{
		save("DELETE FROM booking_user where user_id = ?", new Object[] {bu.getUserId()});
	}
	
	public List<BookingUser> getAllBookingUsers() throws ClassNotFoundException, SQLException
	{
		return read("select * from booking_user", null);
	}
	
	@Override
	public List<BookingUser> extractData(ResultSet rs) throws ClassNotFoundException, SQLException
	{
		List<BookingUser> bus = new ArrayList<>();
		
		while(rs.next())
		{
			BookingUser bu = new BookingUser();
			bu.getBookingUserId().setId(rs.getInt("booking_id"));
			bu.setUserId(rs.getInt("user_id"));
			bus.add(bu);
		}
		return bus;
	}
}
