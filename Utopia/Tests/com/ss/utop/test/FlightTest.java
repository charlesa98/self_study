package com.ss.utop.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.ss.utop.dao.AirplaneDAO;
import com.ss.utop.dao.AirplaneTypeDAO;
import com.ss.utop.dao.AirportDAO;
import com.ss.utop.dao.FlightDAO;
import com.ss.utop.dao.RouteDAO;
import com.ss.utop.entity.Airplane;
import com.ss.utop.entity.AirplaneType;
import com.ss.utop.entity.Airport;
import com.ss.utop.entity.Booking;
import com.ss.utop.entity.BookingAgent;
import com.ss.utop.entity.BookingGuest;
import com.ss.utop.entity.BookingPayment;
import com.ss.utop.entity.BookingUser;
import com.ss.utop.entity.Flight;
import com.ss.utop.entity.FlightBookings;
import com.ss.utop.entity.Passenger;
import com.ss.utop.entity.Route;
import com.ss.utop.entity.User;
import com.ss.utop.entity.UserRole;
import com.ss.utop.service.ConnectionUtil;

public class FlightTest {
	ConnectionUtil connUtil = new ConnectionUtil();
	Connection conn = null;
	AirplaneType apt = new AirplaneType();
	Airplane ap = new Airplane();
	Airport port = new Airport();
	Route r = new Route();
	Flight f = new Flight();
	FlightBookings fb = new FlightBookings();
	Booking b = new Booking();
	BookingPayment bpay = new BookingPayment();
	BookingAgent ba = new BookingAgent();
	BookingPayment bp = new BookingPayment();
	BookingUser bu = new BookingUser();
	BookingGuest bg = new BookingGuest();
	User u = new User();
	UserRole ur = new UserRole();
	Passenger p = new Passenger();
	//-------------------Flight---------------------------------------------------
		@Test
		public void testAddFlight() throws ClassNotFoundException, SQLException
		{
			conn = connUtil.getConnection();
			FlightDAO fdao = new FlightDAO(conn);
			RouteDAO rdao = new RouteDAO(conn);
			AirplaneDAO airpdao = new AirplaneDAO(conn);
			AirplaneTypeDAO aptdao = new AirplaneTypeDAO(conn);
			AirportDAO apdao = new AirportDAO(conn);
			
			port.setAirportCode("ZYX");
			port.setCityName("TEST CITY");
			
			Airport port2 = new Airport();
			
			port2.setAirportCode("ABC");
			port2.setCityName("TEST CITY 2");
			
			r.setId(998743);
			r.setOrgAirport(port);
			r.setDesAirport(port2);
			
			
			apt.setCapacity(999999);
			
			ap.setAPId(465654);
			ap.setType(apt);

			f.setFlightId(453545);
			f.setRouteId(r);
			f.setAirplaneId(ap);
			f.setDepartTime("2022-05-24 20:34:42");
			f.setResSeats(20);
			f.setPrice((float) 19.99);
			
			try {
				fdao.deleteFlight(f);
				rdao.deleteRoute(r);
				apdao.deleteAirport(port);
				apdao.deleteAirport(port2);
				airpdao.deleteAirplane(ap);
				aptdao.deleteAirplaneType(apt);
				conn.commit();
				apdao.addAirport(port);
				apdao.addAirport(port2);
				rdao.addRoute(r);
				aptdao.addAirplaneType(apt);
				fdao.addFlight(f);
				conn.commit();
				fdao.deleteFlight(f);
				rdao.deleteRoute(r);
				apdao.deleteAirport(port);
				apdao.deleteAirport(port2);
				airpdao.deleteAirplane(ap);
				aptdao.deleteAirplaneType(apt);
				conn.commit();
			}catch(ClassNotFoundException | SQLException e)
			{
				e.printStackTrace();
				fail();
			}
		}
		
		@Test
		public void testUpdateFlight() throws ClassNotFoundException, SQLException
		{
			conn = connUtil.getConnection();
			AirportDAO apdao = new AirportDAO(conn);
			port.setAirportCode("ZYX");
			port.setCityName("TEST CITY");
			
			Airport port2 = new Airport();
			
			port2.setAirportCode("ABC");
			port2.setCityName("TEST CITY 2");
			
			r.setOrgAirport(port);
			r.setDesAirport(port2);
			
			RouteDAO rdao = new RouteDAO(conn);
			
			AirplaneTypeDAO aptdao = new AirplaneTypeDAO(conn);
			apt.setCapacity(999999);
			
			AirplaneDAO airpdao = new AirplaneDAO(conn);
			ap.setAPId(9999);
			ap.setType(apt);
			
			FlightDAO fdao = new FlightDAO(conn);
			f.setRouteId(r);
			f.setAirplaneId(ap);
			f.setDepartTime("2022-05-24 20:34:42");
			f.setResSeats(20);
			f.setPrice((float) 19.99);
			
			
			try {
				fdao.deleteFlight(f);
				rdao.deleteRoute(r);
				apdao.deleteAirport(port);
				apdao.deleteAirport(port2);
				airpdao.deleteAirplane(ap);
				aptdao.deleteAirplaneType(apt);
				conn.commit();
				apdao.addAirport(port);
				apdao.addAirport(port2);
				rdao.addRoute(r);
				conn.commit();
				apdao.deleteAirport(port);
				apdao.deleteAirport(port2);
				rdao.deleteRoute(r);
				conn.commit();
			}catch(ClassNotFoundException | SQLException e)
			{
				e.printStackTrace();
				fail();
			}
		}
		
		@Test
		public void testDeleteFlight() throws ClassNotFoundException, SQLException
		{
			conn = connUtil.getConnection();
			AirportDAO apdao = new AirportDAO(conn);
			port.setAirportCode("ZYX");
			port.setCityName("TEST CITY");
			
			Airport port2 = new Airport();
			
			port2.setAirportCode("ABC");
			port2.setCityName("TEST CITY 2");
			
			r.setOrgAirport(port);
			r.setDesAirport(port2);
			
			RouteDAO rdao = new RouteDAO(conn);
			
			AirplaneTypeDAO aptdao = new AirplaneTypeDAO(conn);
			apt.setCapacity(999999);
			
			AirplaneDAO airpdao = new AirplaneDAO(conn);
			ap.setAPId(9999);
			ap.setType(apt);
			
			FlightDAO fdao = new FlightDAO(conn);
			f.setRouteId(r);
			f.setAirplaneId(ap);
			f.setDepartTime("2022-05-24 20:34:42");
			f.setResSeats(20);
			f.setPrice((float) 19.99);
			
			
			try {
				fdao.deleteFlight(f);
				rdao.deleteRoute(r);
				apdao.deleteAirport(port);
				apdao.deleteAirport(port2);
				airpdao.deleteAirplane(ap);
				aptdao.deleteAirplaneType(apt);
				conn.commit();
				apdao.addAirport(port);
				apdao.addAirport(port2);
				rdao.addRoute(r);
				conn.commit();
				apdao.deleteAirport(port);
				apdao.deleteAirport(port2);
				rdao.deleteRoute(r);
				conn.commit();
			}catch(ClassNotFoundException | SQLException e)
			{
				e.printStackTrace();
				fail();
			}
		}
		
		@Test
		public void testReadAllFlight() throws ClassNotFoundException, SQLException
		{
			conn = connUtil.getConnection();
			FlightDAO fdao = new FlightDAO(conn);
			
			try {	
				List<Flight> flights = fdao.getAllFlights();
				for(Flight t : flights)
				{
					System.out.println(t.toString());
				}
			}catch(ClassNotFoundException | SQLException e)
			{
				e.printStackTrace();
				fail();
			}
		}	
}
