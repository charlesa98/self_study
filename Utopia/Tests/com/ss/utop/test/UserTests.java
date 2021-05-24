package com.ss.utop.test;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.ss.utop.dao.UserDAO;
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

public class UserTests {
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
	
	@Test (timeout = 3000)
	public void testAddUser() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		UserDAO udao = new UserDAO(conn);
		UserRoleDAO urdao = new UserRoleDAO(conn);
		ur.setId(5);
		ur.setName("TESTING User ADD");
		
		u.setUserId(3769453);
		u.setUserRole(ur);
		u.setfName("First");
		u.setlName("Last");
		u.setUserName("User");
		u.setEmail("email");
		u.setPassword("pass");
		u.setPhone("800");
		
		try {
			udao.deleteUser(u);
			urdao.deleteUserRole(ur);
			conn.commit();
			urdao.addUserRole(ur);
			udao.addUser(u);
			conn.commit();
			udao.deleteUser(u);
			urdao.deleteUserRole(ur);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test (timeout = 3000)
	public void testUpdateUser() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		UserDAO udao = new UserDAO(conn);
		UserRoleDAO urdao = new UserRoleDAO(conn);
		ur.setId(5);
		ur.setName("TESTING user UPDATE");
		
		u.setUserId(3769453);
		u.setUserRole(ur);
		u.setfName("First");
		u.setlName("Last");
		u.setUserName("User");
		u.setEmail("email");
		u.setPassword("pass");
		u.setPhone("800");
		
		try {
			udao.deleteUser(u);
			urdao.deleteUserRole(ur);
			conn.commit();
			urdao.addUserRole(ur);
			udao.addUser(u);
			conn.commit();
			u.setUserRole(ur);
			u.setfName("First test");
			u.setlName("Last test");
			u.setUserName("User test");
			u.setEmail("email test");
			u.setPassword("pass test");
			u.setPhone("800 3453");
			udao.updateUser(u);
			conn.commit();
			udao.deleteUser(u);
			urdao.deleteUserRole(ur);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test (timeout = 3000)
	public void testDeleteUser() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		UserDAO udao = new UserDAO(conn);
		UserRoleDAO urdao = new UserRoleDAO(conn);
		ur.setId(5);
		ur.setName("TESTING user DELETE");
		
		u.setUserId(3769453);
		u.setUserRole(ur);
		u.setfName("First");
		u.setlName("Last");
		u.setUserName("User");
		u.setEmail("email");
		u.setPassword("pass");
		u.setPhone("800");
		
		try {
			udao.deleteUser(u);
			urdao.deleteUserRole(ur);
			conn.commit();
			urdao.addUserRole(ur);
			udao.addUser(u);
			conn.commit();
			udao.deleteUser(u);
			urdao.deleteUserRole(ur);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test (timeout = 3000)
	public void testReadAllUsers() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		UserDAO udao = new UserDAO(conn);
		
		try {	
			List<User> types = udao.getAllUsers();
			for(User t : types)
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
