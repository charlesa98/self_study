package com.ss.utop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utop.entity.FlightBookings;

public class FlightBookingsDAO extends BaseDAO<FlightBookings>{
	
	public FlightBookingsDAO(Connection conn) {
		super(conn);
	}

	public Integer addFlightBookings(FlightBookings fb) throws ClassNotFoundException, SQLException
	{
		return saveWithPK("INSERT INTO flight_bookings (flight_id, booking_id) VALUES (?, ?)",
				new Object[] {fb.getFlightBookingId().getFlightId(), fb.getBookingId().getId()});
	}
	
	public void updateFlightBookings(FlightBookings fb) throws ClassNotFoundException, SQLException
	{
		save("UPDATE flight_bookings set flight_id =? where booking_id = ?", 
				new Object[] {fb.getFlightBookingId().getFlightId(), fb.getBookingId().getId()});
	}
	
	public void deleteFlightBookings(FlightBookings fb) throws ClassNotFoundException, SQLException
	{
		save("DELETE FROM flight_bookings where flight_id = ?", new Object[] {fb.getFlightBookingId()});
	}
	
	public List<FlightBookings> getAllFlightBookingss() throws ClassNotFoundException, SQLException
	{
		return read("select * from flight_bookings", null);
	}
	
	@Override
	public List<FlightBookings> extractData(ResultSet rs) throws ClassNotFoundException, SQLException
	{
		List<FlightBookings> fbs = new ArrayList<>();
		
		while(rs.next())
		{
			FlightBookings fb = new FlightBookings();
			fb.getFlightBookingId().setFlightId(rs.getInt("flight_id"));
			fb.getBookingId().setId(rs.getInt("booking_id"));
			fbs.add(fb);
		}
		return fbs;
	}
}