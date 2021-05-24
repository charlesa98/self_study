package com.ss.utop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utop.dao.FlightBookingsDAO;
import com.ss.utop.entity.Flight;
import com.ss.utop.entity.FlightBookings;
import com.ss.utop.entity.Route;
import com.ss.utop.menu.BookTicket;
//import com.ss.utop.menu.BookTicket2;
import com.ss.utop.menu.CancelTrip;
import com.ss.utop.menu.Main;
import com.ss.utop.menu.Traveler1;

public class TravelerService {
	ConnectionUtil connUtil = new ConnectionUtil();
	
	/*public void readFlightsToBook(int cardNum) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightDAO fdao = new FlightDAO(conn);	
			
			List<Flight> fList = fdao.getAllFlightsWithRoute();
			//List<Flight> fList = fdao.getAllFlights();
			
			System.out.println("\nHere are all the Flights:");
			int count = 1;
			for(Flight f : fList)
			{
				System.out.println(count+") "+f.getFlightId() + " " + f.getRouteId().getId() +" to "+f.getRouteId().getDesAirport().getAirportCode()
						+" leaving at " + f.getDepartTime());
				count++;
			}
			System.out.println(count+") Quit\n");
			
			BookTicket bt = new BookTicket();
			bt.run2(fList, cardNum);
		}catch (Exception e)
		{
			e.printStackTrace();	
		}
		finally
		{
			conn.close();					//close connection
		}
	}*/
	
	public void readFlightsToBook(int cardNum) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();

			
			List<Flight> flightList = new ArrayList<>();
			
			int count = 1;
			try {
				conn = connUtil.getConnection();
				String sql = "select b.id, a.id, a.*, b.* from route a, flight b where a.id = b.route_id";
				
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				ResultSet rs = pstmt.executeQuery(sql);
							
				while(rs.next())
				{
					Route r = new Route();
					r.setId(rs.getInt("a.id"));
					r.getOrgAirport().setAirportCode(rs.getString("origin_id"));
					r.getDesAirport().setAirportCode(rs.getString("destination_id"));
					
					Flight flight = new Flight();
					flight.setFlightId(rs.getInt("b.id"));
					flight.getRouteId().setId(rs.getInt("route_id"));
					flight.getAirplaneId().setAPId(rs.getInt("airplane_id"));
					flight.setDepartTime(rs.getString("departure_time"));
					flight.setResSeats(rs.getInt("reserved_seats"));
					flight.setPrice(rs.getFloat("seat_price")); 
					
					System.out.println(count+") "+ r.getOrgAirport().getAirportCode() + " to "+ 
							r.getDesAirport().getAirportCode());
					flightList.add(flight);
					count++;
				}
			}catch(Exception e)
			{
				System.out.println("Something went wrong");
				Main.run();
			}
			
	
			System.out.println(count+") Quit\n");
			
			BookTicket bt = new BookTicket();
			bt.run2(flightList, cardNum);

		}catch (Exception e)
		{
			e.printStackTrace();	
		}
		finally
		{
			conn.close();					//close connection
		}
	}
	
	public void readSeatsAvailalbe(Flight f, int card) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			
			//AirplaneType apt = new AirplaneType();
			//apt.setId(f.getFlightId());
			
			//BookCopies copy = new BookCopies();
			//copy.getCopyBranchID().setBranchID(lb.getBranchID());
			

			//int branchNum = lb.getBranchID();
			
			List<Flight> flightList = new ArrayList<>();
			
			int count = 1;
			try {
				conn = connUtil.getConnection();
				String sql = "select a.* from flight a, airplane b, airplane_type c where c.max_capacity > a.reserved_seats and a.id = b.id and b.id = c.id and c.id ='"+f.getFlightId()+"'";
				
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				ResultSet rs = pstmt.executeQuery(sql);
							
				while(rs.next())
				{
					Flight flight = new Flight();
					flight.setFlightId(rs.getInt("id"));
					flight.getRouteId().setId(rs.getInt("route_id"));
					flight.getAirplaneId().setAPId(rs.getInt("airplane_id"));
					flight.setDepartTime(rs.getString("departure_time"));
					flight.setResSeats(rs.getInt("reserved_seats"));
					flight.setPrice(rs.getFloat("seat_price")); 
					
					System.out.println(count+") "+ flight.getRouteId().getOrgAirport().getAirportCode() + " to "+ 
							flight.getRouteId().getDesAirport().getAirportCode());
					flightList.add(flight);
					count++;
				}
			}catch(Exception e)
			{
				System.out.println("Something went wrong");
				Main.run();
			}
			
	
			System.out.println(count+") Quit\n");

			//go back to the menu to pick which flight you want
			//BookTicket2 bt2 = new BookTicket2();
			//bt2.run2(flightList, bow, lb);

		}catch (Exception e)
		{
			e.printStackTrace();	
		}
		finally
		{
			conn.close();					//close connection
		}
	}
	
	public void readUserTrips(int cardNum) throws SQLException
	{
		Connection conn = null;
		
		List<Route> userFlights = new ArrayList<>();
		List<FlightBookings> bookings = new ArrayList<>();
		
		int count = 1;
		try {
			conn = connUtil.getConnection();
			String sql = "select a.*, c.* from route a, flight b, flight_bookings c, booking d, passenger e, airport f where a.id = b.route_id and b.id = c.flight_id and "
					+ "c.booking_id = d.id and e.booking_id = d.id and e.id = '"+cardNum+"' group by id";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery(sql);
			System.out.println(" ");
			
			while(rs.next())
			{
				Route r = new Route();
				r.setId(rs.getInt("id"));
				r.getOrgAirport().setAirportCode(rs.getString("origin_id"));
				r.getDesAirport().setAirportCode(rs.getString("destination_id"));
				
				FlightBookings fb = new FlightBookings();
				fb.getBookingId().setId(rs.getInt("booking_id"));
				fb.getFlightBookingId().setFlightId(rs.getInt("flight_id"));
				bookings.add(fb);
				
				System.out.println(count+") "+ rs.getString("origin_id") + " to " + rs.getString("destination_id"));
				userFlights.add(r);
				count++;
			}
			
		}catch(Exception e)
		{
			System.out.println("Something went wrong with showing your book loans");
		}
		
		System.out.println(count+") Quit\n");
		
		CancelTrip ct = new CancelTrip();
		ct.run2(userFlights, bookings, cardNum);
	}
	
	public void deleteTrip(int cardNum, FlightBookings booking) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightBookings temp = new FlightBookings();
			temp.setBookingId(booking.getBookingId());
			temp.setFlightBookingId(booking.getFlightBookingId());
			FlightBookingsDAO fbdao = new FlightBookingsDAO(conn);
			
			fbdao.deleteFlightBookings(temp);
			
			System.out.println("Deleted");
			conn.commit();					//if it is all good, commit the changes
		}catch (Exception e)
		{
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			System.out.println("\n");
			Traveler1 t1 = new Traveler1();
			t1.run();
		}
	}
}
