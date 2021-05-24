package com.ss.utop.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ss.utop.dao.FlightDAO;
import com.ss.utop.dao.RouteDAO;
import com.ss.utop.entity.Flight;
import com.ss.utop.entity.Route;
import com.ss.utop.menu.Employee2;
import com.ss.utop.menu.Employee3;
import com.ss.utop.menu.Main;

public class EmployeeService {
	ConnectionUtil connUtil = new ConnectionUtil();
	
	public void readRoutes() throws SQLException
	{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			RouteDAO rdao = new RouteDAO(conn);	
			
			List<Route> rList = rdao.getAllRoutes();
				
			int count = 1;
			for(Route r : rList)
			{
				System.out.println(count+") "+r.getOrgAirport().getAirportCode()+" -> "+r.getDesAirport().getAirportCode());//+", "
//						+r.getOrgAirport().getCityName()+", "+r.getDesAirport().getCityName());
				count++;
			}
			System.out.println(count+") Quit\n");
			
			Employee2 e2 = new Employee2();
			e2.run2(rList);
		}catch (Exception e)
		{
			e.printStackTrace();	
		}
		finally
		{
			conn.close();					//close connection
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
	
	public void readAllFlightsBasedOnRoute(Route r) throws SQLException
	{
		Connection conn = null;
		try {			
			conn = connUtil.getConnection();
			FlightDAO fdao = new FlightDAO(conn);
			
			List<Flight> aList = fdao.getAllFlightsViaRoute(r);
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
			System.out.println("");
			Employee3 e3 = new Employee3();
			e3.run(r);
		}
	}
}
