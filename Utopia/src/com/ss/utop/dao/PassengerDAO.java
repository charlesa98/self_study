package com.ss.utop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utop.entity.Passenger;

public class PassengerDAO extends BaseDAO<Passenger>{
	
	public PassengerDAO(Connection conn) {
		super(conn);
	}

	public Integer addPassenger(Passenger passenger) throws ClassNotFoundException, SQLException
	{
		return saveWithPK("INSERT INTO passenger (booking_id, given_name, family_name, dob, gender, address) VALUES ( ?, ?, ?, ?, ?, ?)",
				new Object[] {passenger.getBookingID().getId(), passenger.getfName(),
						passenger.getlName(), passenger.getDob(), passenger.getGender(), passenger.getAddress()});
	}
	
	public void updatePassenger(Passenger passenger) throws ClassNotFoundException, SQLException
	{
		save("UPDATE passenger set booking_id =? , given_name = ?, family_name =?, dob = ?, gender = ?, address = ? where id = ?", 
				new Object[] {passenger.getBookingID().getId(), passenger.getfName(),passenger.getlName(), passenger.getDob(), 
						passenger.getGender(), passenger.getAddress(), passenger.getPassId()});
	}
	
	public void deletePassenger(Passenger passenger) throws ClassNotFoundException, SQLException
	{
		save("DELETE FROM passenger where id = ?", new Object[] {passenger.getPassId()});
	}
	
	public List<Passenger> getAllPassengers() throws ClassNotFoundException, SQLException
	{
		return read("select * from passenger", null);
	}
	
	@Override
	public List<Passenger> extractData(ResultSet rs) throws ClassNotFoundException, SQLException
	{
		List<Passenger> passengers = new ArrayList<>();
		
		while(rs.next())
		{
			Passenger passenger = new Passenger();
			passenger.setPassId(rs.getInt("id"));
			passenger.getBookingID().setId(rs.getInt("booking_id"));
			passenger.setfName(rs.getString("given_name"));
			passenger.setlName(rs.getString("family_name"));
			passenger.setDob(rs.getString("dob"));
			passenger.setGender(rs.getString("gender"));
			passenger.setAddress(rs.getString("address"));
			passengers.add(passenger);
		}
		return passengers;
	}
}
