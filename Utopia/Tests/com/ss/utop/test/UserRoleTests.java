package com.ss.utop.test;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.ss.utop.dao.UserRoleDAO;
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

public class UserRoleTests {
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
	//-----------------------USER ROLE------------------------------------------------
	@Test (timeout = 3000)
	public void testAddUserRole() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		UserRoleDAO urdao = new UserRoleDAO(conn);
		ur.setId(5);
		ur.setName("TESTING ADD");
		
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
	
	@Test (timeout = 3000)
	public void testUpdateUserRole() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		UserRoleDAO urdao = new UserRoleDAO(conn);
		ur.setId(5);
		ur.setName("TESTING UPDATE");
		
		try {
			urdao.deleteUserRole(ur);
			conn.commit();
			urdao.addUserRole(ur);
			conn.commit();
			ur.setId(5);
			ur.setName("TEST updating");
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
	
	@Test (timeout = 3000)
	public void testDeleteUserRole() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		UserRoleDAO urdao = new UserRoleDAO(conn);
		ur.setId(5);
		ur.setName("TESTING DELETE");
		
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
	
	@Test (timeout = 3000)
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
}
