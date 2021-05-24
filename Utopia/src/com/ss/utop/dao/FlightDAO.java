package com.ss.utop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utop.entity.Flight;
import com.ss.utop.entity.Route;
public class FlightDAO extends BaseDAO<Flight>{
	
	public FlightDAO(Connection conn) {
		super(conn);
	}
	
	public Integer addFlight(Flight flight) throws ClassNotFoundException, SQLException
	{
		//flight id is not auto increment so we must add that
		return saveWithPK("INSERT INTO flight (id, route_id, airplane_id, departure_time, reserved_seats, seat_price) VALUES (?, ?, ?, ?, ?, ?)",
				new Object[] {flight.getFlightId(), flight.getRouteId().getId(), flight.getAirplaneId().getAPId(), flight.getDepartTime(),
						flight.getResSeats(), flight.getPrice()});
	}
	
	public void updateFlight(Flight flight) throws ClassNotFoundException, SQLException
	{
		save("UPDATE flight set departure_time = ?, reserved_seats = ?, seat_price = ? where id = ?", 
				new Object[] {flight.getDepartTime(), flight.getResSeats(), flight.getPrice(), flight.getFlightId()});
	}
	
	//passes data containing the sql statement and the object into the 
	public void deleteFlight(Flight flight) throws ClassNotFoundException, SQLException
	{
		save("delete from flight where id = ?", new Object[] {flight.getFlightId()});
	}
	
	public List<Flight> getAllFlights() throws ClassNotFoundException, SQLException
	{
		return read("select * from flight", null);
	}
	
	public List<Flight> getAllFlightsWithRoute() throws ClassNotFoundException, SQLException
	{
		return read("select a.origin_id, a.destination_id, b.* from route a, flight b, airport c where a.id = b.route_id group by b.id", null);
	}
	
	public List<Flight> getAllFlightsViaRoute(Route r) throws ClassNotFoundException, SQLException
	{
		return read("select * from flight where route_id =?", new Object[] {r.getId()});
	}
	
	@Override
	public List<Flight> extractData(ResultSet rs) throws ClassNotFoundException, SQLException
	{
		List<Flight> flights = new ArrayList<>();
		
		while(rs.next())
		{
			Flight flight = new Flight();
			flight.setFlightId(rs.getInt("id"));
			flight.getRouteId().setId(rs.getInt("route_id"));
			flight.getAirplaneId().setAPId(rs.getInt("airplane_id"));
			flight.setDepartTime(rs.getString("departure_time"));
			flight.setResSeats(rs.getInt("reserved_seats"));
			flight.setPrice(rs.getFloat("seat_price"));
			flights.add(flight);
		}
		return flights;
	}
}