package com.ss.utop.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.junit.Test;

import com.ss.utop.entity.*;
import com.ss.utop.dao.*;
import com.ss.utop.service.ConnectionUtil;

public class Tests {
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
	
//---------------------Airplane Type------------------------------------------------
/*	@Test
	public void testAddAirplaneType() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		AirplaneTypeDAO aptdao = new AirplaneTypeDAO(conn);
		apt.setCapacity(999999);
		
		try {
			aptdao.deleteAirplaneType(apt);
			conn.commit();
			aptdao.addAirplaneType(apt);
			conn.commit();
			aptdao.deleteAirplaneType(apt);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testUpdateAirplaneType() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		AirplaneTypeDAO aptdao = new AirplaneTypeDAO(conn);
		apt.setCapacity(999999);
		
		try {
			aptdao.deleteAirplaneType(apt);
			conn.commit();
			aptdao.addAirplaneType(apt);
			conn.commit();
			apt.setCapacity(500);
			aptdao.updateAirplaneType(apt);
			conn.commit();
			aptdao.deleteAirplaneType(apt);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testDeleteAirplaneType() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		AirplaneTypeDAO aptdao = new AirplaneTypeDAO(conn);
		apt.setCapacity(999999);
		
		try {
			aptdao.deleteAirplaneType(apt);
			conn.commit();
			aptdao.addAirplaneType(apt);
			conn.commit();
			aptdao.deleteAirplaneType(apt);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testReadAllAirplaneTypes() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		AirplaneTypeDAO aptdao = new AirplaneTypeDAO(conn);
		
		try {	
			List<AirplaneType> types = aptdao.getAllAirplaneTypes();
			for(AirplaneType t : types)
			{
				System.out.println(t.toString());
			}
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}*/
//-------------------Airport---------------------------------------------------
	@Test
	public void testAddAirport() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		AirportDAO apdao = new AirportDAO(conn);
		port.setAirportCode("ZYX");
		port.setCityName("TEST CITY");
		
		try {
			apdao.deleteAirport(port);
			conn.commit();
			apdao.addAirport(port);
			conn.commit();
			apdao.deleteAirport(port);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testUpdateAirport() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		AirportDAO apdao = new AirportDAO(conn);
		port.setAirportCode("ZYX");
		port.setCityName("TEST CITY");
		
		try {
			apdao.deleteAirport(port);
			conn.commit();
			apdao.addAirport(port);
			conn.commit();
			port.setAirportCode("ZZZ");
			port.setCityName("TEST UPDATE");
			apdao.updateAirport(port);
			conn.commit();
			apdao.deleteAirport(port);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testDeleteAirprt() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		AirportDAO apdao = new AirportDAO(conn);
		port.setAirportCode("ZYX");
		port.setCityName("TEST CITY");
		
		try {
			apdao.deleteAirport(port);
			conn.commit();
			apdao.addAirport(port);
			conn.commit();
			apdao.deleteAirport(port);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testReadAllAirport() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		AirportDAO apdao = new AirportDAO(conn);
		
		try {	
			List<Airport> ports = apdao.getAllAirports();
			for(Airport t : ports)
			{
				System.out.println(t.toString());
			}
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
//-------------------Route---------------------------------------------------
	@Test
	public void testAddRoute() throws ClassNotFoundException, SQLException
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
		
		try {
			rdao.deleteRoute(r);
			apdao.deleteAirport(port);
			apdao.deleteAirport(port2);
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
	public void testUpdateRoute() throws ClassNotFoundException, SQLException
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
		
		Airport port3 = new Airport();
		port3.setAirportCode("EFG");
		port3.setCityName("TEST CITY 3");
		
		RouteDAO rdao = new RouteDAO(conn);
		
		try {
			rdao.deleteRoute(r);
			apdao.deleteAirport(port);
			apdao.deleteAirport(port2);
			conn.commit();
			apdao.addAirport(port);
			apdao.addAirport(port2);
			rdao.addRoute(r);
			conn.commit();
			r.setOrgAirport(port3);
			rdao.updateRoute(r);
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
	public void testDeleteRoute() throws ClassNotFoundException, SQLException
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
		
		try {
			rdao.deleteRoute(r);
			apdao.deleteAirport(port);
			apdao.deleteAirport(port2);
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
	public void testReadAllRoutes() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		RouteDAO rdao = new RouteDAO(conn);
		
		try {	
			List<Route> routes = rdao.getAllRoutes();
			for(Route t : routes)
			{
				System.out.println(t.toString());
			}
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
//------------------------BOOKING------------------------------
/*	@Test
	public void testAddBooking() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		BookingDAO bdao = new BookingDAO(conn);
		b.setId(98709);
		b.setActive(0);
		b.setConfermationCode("TESTING BOOKING");
		
		try {
			bdao.deleteBooking(b);
			conn.commit();
			bdao.addBooking(b);
			conn.commit();
			b.setActive(1);
			b.setConfermationCode("TSEETSETESR");
			bdao.updateBooking(b);
			conn.commit();
			bdao.deleteBooking(b);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testUpdateBooking() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		BookingDAO bdao = new BookingDAO(conn);
		b.setId(98709);
		b.setActive(0);
		b.setConfermationCode("TESTING BOOKING");
		
		try {
			bdao.deleteBooking(b);
			conn.commit();
			bdao.addBooking(b);
			conn.commit();
			bdao.deleteBooking(b);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testDeleteBooking() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		BookingDAO bdao = new BookingDAO(conn);
		b.setId(98709);
		b.setActive(0);
		b.setConfermationCode("TESTING BOOKING");
		
		try {
			bdao.deleteBooking(b);
			conn.commit();
			bdao.addBooking(b);
			conn.commit();
			bdao.deleteBooking(b);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testReadAllBookings() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		BookingDAO bdao = new BookingDAO(conn);
		
		try {	
			List<Booking> types = bdao.getAllBookings();
			for(Booking t : types)
			{
				System.out.println(t.toString());
			}
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}*/
//-----------------------USER ROLE------------------------------------------------
	@Test
	public void testAddUserRole() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		UserRoleDAO urdao = new UserRoleDAO(conn);
		ur.setId(5);
		ur.setName("TEST ADD");
		
		try {
			urdao.deleteUserRole(ur);
			conn.commit();
			urdao.addUserRole(ur);
			conn.commit();
			urdao.deleteUserRole(ur);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testUpdateUserRole() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		UserRoleDAO urdao = new UserRoleDAO(conn);
		ur.setId(5);
		ur.setName("TEST UPDATE");
		
		try {
			urdao.deleteUserRole(ur);
			conn.commit();
			urdao.addUserRole(ur);
			conn.commit();
			ur.setName("TEST UPDATE");
			urdao.updateUserRole(ur);
			conn.commit();
			urdao.deleteUserRole(ur);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testDeleteUserRole() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		UserRoleDAO urdao = new UserRoleDAO(conn);
		ur.setId(5);
		ur.setName("TEST DELETE");
		
		try {
			urdao.deleteUserRole(ur);
			conn.commit();
			urdao.addUserRole(ur);
			conn.commit();
			urdao.deleteUserRole(ur);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testReadAllUserRoles() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		UserRoleDAO urdao = new UserRoleDAO(conn);
		
		try {	
			List<UserRole> types = urdao.getAllUserRoles();
			for(UserRole t : types)
			{
				System.out.println(t.toString());
			}
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
//-----------------------USER-----------------------------------------------------	
/*	@Test
	public void testAddUser() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		UserDAO bdao = new UserDAO(conn);
		b.setId(98709);
		b.setActive(0);
		b.setConfermationCode("TESTING BOOKING");
		
		try {
			bdao.deleteBooking(b);
			conn.commit();
			bdao.addBooking(b);
			conn.commit();
			b.setActive(1);
			b.setConfermationCode("TSEETSETESR");
			bdao.updateBooking(b);
			conn.commit();
			bdao.deleteBooking(b);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testUpdateUser() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		UserDAO bdao = new UserDAO(conn);
		b.setId(98709);
		b.setActive(0);
		b.setConfermationCode("TESTING BOOKING");
		
		try {
			bdao.deleteBooking(b);
			conn.commit();
			bdao.addBooking(b);
			conn.commit();
			bdao.deleteBooking(b);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testDeleteUser() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		UserDAO bdao = new UserDAO(conn);
		b.setId(98709);
		b.setActive(0);
		b.setConfermationCode("TESTING BOOKING");
		
		try {
			bdao.deleteBooking(b);
			conn.commit();
			bdao.addBooking(b);
			conn.commit();
			bdao.deleteBooking(b);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testReadAllUsers() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		UserDAO bdao = new UserDAO(conn);
		
		try {	
			List<Booking> types = bdao.getAllBookings();
			for(Booking t : types)
			{
				System.out.println(t.toString());
			}
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}*/
}
