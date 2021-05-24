package com.ss.utop.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ss.utop.dao.AirplaneDAO;
import com.ss.utop.dao.AirplaneTypeDAO;
import com.ss.utop.dao.AirportDAO;
import com.ss.utop.dao.FlightBookingsDAO;
import com.ss.utop.dao.FlightDAO;
import com.ss.utop.dao.RouteDAO;
import com.ss.utop.dao.UserDAO;
import com.ss.utop.entity.Flight;
import com.ss.utop.entity.FlightBookings;
import com.ss.utop.entity.Route;
import com.ss.utop.entity.User;
import com.ss.utop.menu.Main;
import com.ss.utop.entity.Airport;
import com.ss.utop.entity.Airplane;
import com.ss.utop.entity.AirplaneType;

public class AdminService {
	ConnectionUtil connUtil = new ConnectionUtil();
//---------------- Airport ----------------------------------
	public void addNewAirport(Airport ap) throws SQLException			//create different methods to create stuff
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			Airport temp = new Airport();
			temp.setAirportCode(ap.getAirportCode());
			temp.setCityName(ap.getCityName());
			AirportDAO adao = new AirportDAO(conn);
			
			adao.addAirport(temp);
			
			System.out.println("Added");
			conn.commit();					//if it is all good, commit the changes
		}catch (Exception e)
		{
			System.out.println("Something went wrong. You might have added 2 of the same airport codes");
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection

			Main.run();						//calls the main menu run function to continue to run
		}
	}
	
	public void updateAirport(Airport ap) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			Airport temp = new Airport();
			temp.setAirportCode(ap.getAirportCode());
			temp.setCityName(ap.getCityName());
			AirportDAO adao = new AirportDAO(conn);
			
			adao.updateAirport(temp);
			
			System.out.println("Updated");
			conn.commit();					//if it is all good, commit the changes

		}catch (Exception e)
		{
			System.out.println("Something went wrong. The airport code may not exist");
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			Main.run();
		}
	}	
	
	public void updateAirportCode(Airport ap) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			Airport temp = new Airport();
			temp.setAirportCode(ap.getAirportCode());
			AirportDAO adao = new AirportDAO(conn);
			
			adao.updateAirport(temp);
			
			System.out.println("Updated");
			conn.commit();					//if it is all good, commit the changes

		}catch (Exception e)
		{
			System.out.println("Something went wrong. The airport code may not exist");
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			Main.run();
		}
	}	
	
	public void updateAirportCity(Airport ap) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			Airport temp = new Airport();
			temp.setCityName(ap.getCityName());
			AirportDAO adao = new AirportDAO(conn);
			
			adao.updateAirport(temp);
			
			System.out.println("Updated");
			conn.commit();					//if it is all good, commit the changes

		}catch (Exception e)
		{
			System.out.println("Something went wrong. The airport code may not exist");
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			Main.run();
		}
	}	
	
	public void deleteAirport(String code) throws SQLException
	{
		Connection conn = null;
		try {
			code = code.toUpperCase();
			conn = connUtil.getConnection();
			Airport temp = new Airport();
			temp.setAirportCode(code);
			AirportDAO adao = new AirportDAO(conn);

			
			adao.deleteAirport(temp);			
			
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
			Main.run();
		}
	}

	public void readAllAirports() throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirportDAO adao = new AirportDAO(conn);
			
			List<Airport> aList = adao.getAllAirports();
			for(Airport a : aList)
			{
				System.out.println(a.toString());
			}
			
		}catch (Exception e)
		{
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			Main.run();
		}
	}
//----------------- Airplane -----------------------------------------

	public void addNewAirplane(Airplane plane) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			Airplane temp = new Airplane();
			temp.setAPId(plane.getAPId());
			temp.setType(plane.getType());
			
			AirplaneDAO apdao = new AirplaneDAO(conn);
			
			apdao.addAirplane(temp);
			
			System.out.println("Added");
			conn.commit();					//if it is all good, commit the changes
		}catch (Exception e)
		{
			System.out.println("Something went wrong. You might have added 2 of the same airplane ID's");
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			Main.run();
		}		
	}
	
	public void updateAirplane(Airplane plane) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			Airplane temp = new Airplane();
			temp.setAPId(plane.getAPId());
			temp.setType(plane.getType());
			AirplaneDAO apdao = new AirplaneDAO(conn);
			
			apdao.updateAirplane(temp);
			
			System.out.println("Updated");
			conn.commit();					//if it is all good, commit the changes
		}catch (Exception e)
		{
			System.out.println("Something went wrong. The airport code may not exist");
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			Main.run();
		}
	}	
	
	public void deleteAirplane(int id) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			Airplane temp = new Airplane();
			temp.setAPId(id);
			AirplaneDAO apdao = new AirplaneDAO(conn);
			
			apdao.deleteAirplane(temp);			
			
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
			Main.run();
		}
	}

	public void readAllAirplanes() throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirplaneDAO apdao = new AirplaneDAO(conn);
			
			List<Airplane> aList = apdao.getAllAirplanes();
			for(Airplane a : aList)
			{
				System.out.println(a.toString());
			}
		}catch (Exception e)
		{
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			Main.run();
		}
	}
//----------------- Airplane Types -----------------------------------
	public void addNewAirplaneType(AirplaneType type) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirplaneType temp = new AirplaneType();
			
			temp.setCapacity(type.getCapacity());
			
			AirplaneTypeDAO apdao = new AirplaneTypeDAO(conn);
			
			apdao.addAirplaneType(temp);
			System.out.println("Added");
			conn.commit();					//if it is all good, commit the changes
		}catch (Exception e)
		{
			System.out.println("Something went wrong. You might have added 2 of the same airplane ID's");
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			Main.run();
		}		
	}
	
	public void updateAirplaneType(AirplaneType type) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirplaneType temp = new AirplaneType();
			temp.setCapacity(type.getCapacity());

			AirplaneTypeDAO apdao = new AirplaneTypeDAO(conn);
			
			apdao.updateAirplaneType(temp);
			
			System.out.println("Updated");
			conn.commit();					//if it is all good, commit the changes
		}catch (Exception e)
		{
			System.out.println("Something went wrong. The airport code may not exist");
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			Main.run();
		}
	}	
	
	public void deleteAirplaneType(int id) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirplaneType temp = new AirplaneType();

			temp.setId(id);
			
			AirplaneTypeDAO apdao = new AirplaneTypeDAO(conn);
			
			apdao.deleteAirplaneType(temp);			
			
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
			Main.run();
		}
	}

	public void readAllAirplaneTypes() throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirplaneTypeDAO apdao = new AirplaneTypeDAO(conn);
			
			List<AirplaneType> aList = apdao.getAllAirplaneTypes();
			for(AirplaneType a : aList)
			{
				System.out.println(a.toString());
			}
		}catch (Exception e)
		{
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			Main.run();
		}
	}
//----------------- Flights ------------------------------------------	
	public void addNewFlight(Flight f) throws SQLException			//create different methods to create stuff
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			Flight temp = new Flight();
			temp.setFlightId(f.getFlightId());
			temp.setRouteId(f.getRouteId());
			temp.setAirplaneId(f.getAirplaneId());
			temp.setDepartTime(f.getDepartTime());
			temp.setResSeats(f.getResSeats());
			temp.setPrice(f.getPrice());
			FlightDAO fdao = new FlightDAO(conn);
			
			fdao.addFlight(temp);
			
			conn.commit();					//if it is all good, commit the changes
			System.out.println("Added");
		}catch (Exception e)
		{
			System.out.println("Something went wrong when you tried to add the flight. Maybe a key doesn't exist or the flight ID already does");
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			Main.run();
		}
	}
	
	public void updateFlight(Flight f) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			Flight temp = new Flight();
			temp.setFlightId(f.getFlightId());
			temp.setRouteId(f.getRouteId());
			temp.setAirplaneId(f.getAirplaneId());
			temp.setDepartTime(f.getDepartTime());
			temp.setResSeats(f.getResSeats());
			temp.setPrice(f.getPrice());
			FlightDAO fdao = new FlightDAO(conn);
			
			fdao.updateFlight(temp);
			
			
			System.out.println("Updated");
			conn.commit();					//if it is all good, commit the changes
		}catch (Exception e)
		{
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			Main.run();
		}
	}	
	
	public void deleteFlight(int id) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			Flight temp = new Flight();
			temp.setFlightId(id);
			FlightDAO fdao = new FlightDAO(conn);
			
			//call the delete function in the FlightDAO class
			fdao.deleteFlight(temp);			
			
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
			Main.run();
		}
	}

	public void readAllFlights() throws SQLException
	{
		Connection conn = null;
		try {			
			conn = connUtil.getConnection();
			FlightDAO fdao = new FlightDAO(conn);
			
			List<Flight> aList = fdao.getAllFlights();
			for(Flight a : aList)
			{
				System.out.println(a.toString());
			}
			
		}catch (Exception e)
		{
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			Main.run();
		}
	}
	
//--------------------- routes -----------------------
	public void addNewRoute(Route r) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			Route temp = new Route();
			
			temp.setId(r.getId());
			temp.setOrgAirport(r.getDesAirport());
			temp.setDesAirport(r.getDesAirport());

			RouteDAO rdao = new RouteDAO(conn);
			
			rdao.addRoute(r);
			
			System.out.println("Added");
			conn.commit();					//if it is all good, commit the changes
		}catch (Exception e)
		{
			System.out.println("Something went wrong");	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			Main.run();
		}
	}
	
	public void updateRoute(Route r) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			Route temp = new Route();
			
			temp.setId(r.getId());
			temp.setOrgAirport(r.getDesAirport());
			temp.setDesAirport(r.getDesAirport());

			RouteDAO rdao = new RouteDAO(conn);
			
			rdao.updateRoute(temp);
			
			
			System.out.println("Updated");
			conn.commit();					//if it is all good, commit the changes
		}catch (Exception e)
		{
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			Main.run();
		}
	}	
	
	public void updateRouteOrg(Route r) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			Route temp = new Route();
			
			temp.setId(r.getId());
			temp.setOrgAirport(r.getDesAirport());

			RouteDAO rdao = new RouteDAO(conn);
			
			rdao.updateRoute(temp);
			
			
			System.out.println("Updated");
			conn.commit();					//if it is all good, commit the changes
		}catch (Exception e)
		{
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
		}
	}	
	
	public void updateRouteDes(Route r) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			Route temp = new Route();
			
			temp.setId(r.getId());
			temp.setDesAirport(r.getDesAirport());

			RouteDAO rdao = new RouteDAO(conn);
			
			rdao.updateRoute(temp);
			
			
			System.out.println("Updated");
			conn.commit();					//if it is all good, commit the changes
		}catch (Exception e)
		{
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
		}
	}	
	
	public void deleteRoute(int id) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			Route temp = new Route();
			temp.setId(id);
			RouteDAO rdao = new RouteDAO(conn);
						
			rdao.deleteRoute(temp);			
			
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
			Main.run();
		}
	}	
	
	public void readAllRoutes() throws SQLException
	{
		Connection conn = null;
		try {		
			conn = connUtil.getConnection();
			RouteDAO rdao = new RouteDAO(conn);
			
			List<Route> aList = rdao.getAllRoutes();
			for(Route a : aList)
			{
				System.out.println(a.toString());
			}
		}catch (Exception e)
		{
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			Main.run();
		}
	}
//---------------------USER-------------------------------------------
	public void addNewUser(User u) throws SQLException			//create different methods to create stuff
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			User temp = new User();
			
			temp.setUserId(u.getUserId());
			temp.setUserRole(u.getUserRole());
			temp.setfName(u.getfName());
			temp.setlName(u.getlName());
			temp.setUserName(u.getUserName());
			temp.setEmail(u.getEmail());
			temp.setPassword(u.getPassword());
			temp.setPhone(u.getPhone());
			
			UserDAO udao = new UserDAO(conn);
			
			udao.addUser(u);
			
			System.out.println("Added");
			conn.commit();					//if it is all good, commit the changes
		}catch (Exception e)
		{
			System.out.println("Something went wrong. You might have added 2 of the same users");
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			Main.run();						//calls the main menu run function to continue to run
		}
	}
	
	public void updateUserFName(User u) throws SQLException			//create different methods to create stuff
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			User temp = new User();
			
			temp.setUserId(u.getUserId());
			temp.setfName(u.getfName());
			
			UserDAO udao = new UserDAO(conn);
			
			udao.updateUser(u);
			
			System.out.println("Updated");
			conn.commit();					//if it is all good, commit the changes
		}catch (Exception e)
		{
			System.out.println("Something went wrong. You might have added 2 of the same users");
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
		}
	}
	
	public void updateUserLName(User u) throws SQLException			//create different methods to create stuff
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			User temp = new User();
			
			temp.setUserId(u.getUserId());
			temp.setlName(u.getlName());
			
			UserDAO udao = new UserDAO(conn);
			
			udao.updateUser(u);
			
			System.out.println("Updated");
			conn.commit();					//if it is all good, commit the changes
		}catch (Exception e)
		{
			System.out.println("Something went wrong. You might have added 2 of the same users");
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
		}
	}
	
	public void updateUserUName(User u) throws SQLException			//create different methods to create stuff
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			User temp = new User();
			
			temp.setUserId(u.getUserId());
			temp.setUserName(u.getUserName());
			
			UserDAO udao = new UserDAO(conn);
			
			udao.updateUser(u);
			
			System.out.println("Updated");
			conn.commit();					//if it is all good, commit the changes
		}catch (Exception e)
		{
			System.out.println("Something went wrong. You might have added 2 of the same users");
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
		}
	}
	
	public void updateUserEmail(User u) throws SQLException			//create different methods to create stuff
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			User temp = new User();
			
			temp.setUserId(u.getUserId());
			temp.setEmail(u.getEmail());
			
			UserDAO udao = new UserDAO(conn);
			
			udao.updateUser(u);
			
			System.out.println("Updated");
			conn.commit();					//if it is all good, commit the changes
		}catch (Exception e)
		{
			System.out.println("Something went wrong. You might have added 2 of the same users");
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
		}
	}
	
	public void updateUserPw(User u) throws SQLException			//create different methods to create stuff
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			User temp = new User();
			
			temp.setUserId(u.getUserId());
			temp.setPassword(u.getPassword());
			
			UserDAO udao = new UserDAO(conn);
			
			udao.updateUser(u);
			
			System.out.println("Updated");
			conn.commit();					//if it is all good, commit the changes
		}catch (Exception e)
		{
			System.out.println("Something went wrong. You might have added 2 of the same users");
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
		}
	}
	
	public void updateUserPhone(User u) throws SQLException			//create different methods to create stuff
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			User temp = new User();
			
			temp.setUserId(u.getUserId());
			temp.setPhone(u.getPhone());
			
			UserDAO udao = new UserDAO(conn);
			
			udao.updateUser(u);
			
			System.out.println("Updated");
			conn.commit();					//if it is all good, commit the changes
		}catch (Exception e)
		{
			System.out.println("Something went wrong. You might have added 2 of the same users");
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
		}
	}
	
	public void updateUser(User u) throws SQLException			//create different methods to create stuff
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			User temp = new User();
			
			temp.setUserId(u.getUserId());
			temp.setUserRole(u.getUserRole());
			temp.setfName(u.getfName());
			temp.setlName(u.getlName());
			temp.setUserName(u.getUserName());
			temp.setEmail(u.getEmail());
			temp.setPassword(u.getPassword());
			temp.setPhone(u.getPhone());
			
			UserDAO udao = new UserDAO(conn);
			
			udao.updateUser(u);
			
			System.out.println("Updated");
			conn.commit();					//if it is all good, commit the changes
		}catch (Exception e)
		{
			System.out.println("Something went wrong. You might have added 2 of the same users");
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			Main.run();						//calls the main menu run function to continue to run
		}
	}
	
	public void deleteUser(int id) throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			User temp = new User();
			temp.setUserId(id);
			UserDAO udao = new UserDAO(conn);
						
			udao.deleteUser(temp);			
			
			System.out.println("Deleted");
			conn.commit();					//if it is all good, commit the changes
		}catch (Exception e)
		{
			System.out.println("Something went wrong.");
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			Main.run();
		}
	}	
	
	
	public void readAllUsers() throws SQLException
	{
		Connection conn = null;
		try {		
			conn = connUtil.getConnection();
			UserDAO udao = new UserDAO(conn);
			
			List<User> aList = udao.getAllUsers();
			for(User a : aList)
			{
				System.out.println(a.toString());
			}
		}catch (Exception e)
		{
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			Main.run();
		}
	}
//----------------TICKETS-----------------------------------------
	public void addNewTicket(FlightBookings fb) throws SQLException			//create different methods to create stuff
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightBookings temp = new FlightBookings();
			
			temp.setBookingId(fb.getBookingId());
			temp.setFlightBookingId(fb.getFlightBookingId());
			
			FlightBookingsDAO fbdao = new FlightBookingsDAO(conn);
			
			fbdao.addFlightBookings(fb);
			
			System.out.println("Added");
			conn.commit();					//if it is all good, commit the changes
		}catch (Exception e)
		{
			System.out.println("Something went wrong. One of the IDs might not be correct");
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			Main.run();						//calls the main menu run function to continue to run
		}
	}
	
	public void updateTicket(FlightBookings fb) throws SQLException			//create different methods to create stuff
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightBookings temp = new FlightBookings();
			
			temp.setBookingId(fb.getBookingId());
			temp.setFlightBookingId(fb.getFlightBookingId());
			
			FlightBookingsDAO fbdao = new FlightBookingsDAO(conn);
			
			fbdao.updateFlightBookings(fb);
			
			System.out.println("Updated");
			conn.commit();					//if it is all good, commit the changes
		}catch (Exception e)
		{
			System.out.println("Something went wrong. One of the IDs might not be correct");
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			Main.run();						//calls the main menu run function to continue to run
		}
	}
	
	public void deleteTicket(FlightBookings fb) throws SQLException			//create different methods to create stuff
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightBookings temp = new FlightBookings();
			
			temp.setBookingId(fb.getBookingId());
			temp.setFlightBookingId(fb.getFlightBookingId());
			
			FlightBookingsDAO fbdao = new FlightBookingsDAO(conn);
			
			fbdao.deleteFlightBookings(fb);
			
			System.out.println("deleted");
			conn.commit();					//if it is all good, commit the changes
		}catch (Exception e)
		{
			System.out.println("Something went wrong. One of the IDs might not be correct");
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			Main.run();						//calls the main menu run function to continue to run
		}
	}
	
	public void readAllTickets()throws SQLException
	{
		Connection conn = null;
		try {		
			conn = connUtil.getConnection();
			FlightBookingsDAO fbdao = new FlightBookingsDAO(conn);
			
			List<FlightBookings> aList = fbdao.getAllFlightBookingss();
			for(FlightBookings a : aList)
			{
				System.out.println(a.toString());
			}
		}catch (Exception e)
		{
			e.printStackTrace();	
			conn.rollback();				//if it fails, roll back
		}
		finally
		{
			conn.close();					//close connection
			Main.run();
		}
	}
}
