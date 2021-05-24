package com.ss.utop.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import com.ss.utop.entity.Route;

public class RouteTest {
	
	@Test
	public void testGetId()
	{
		Route r = new Route();
		r.setId(10);
		assertEquals(r.getId(), 10.0, .0001);
	}
	
	@Test
	public void testSetId()
	{
		Route r = new Route();
		r.setId(10);
		assertEquals(r.getId(), 10.0, .0001);
	}
	
	@Test
	public void testGetOrg()
	{
		Route r = new Route();
		r.getOrgAirport().setAirportCode("ABC");
		assertNotEquals("BCD", r.getOrgAirport());
	}
	
	@Test
	public void testSetOrg()
	{
		Route r = new Route();
		r.getOrgAirport().setAirportCode("ABC");
		assertNotEquals("BCD", r.getOrgAirport());
	}
	
	@Test
	public void testGetDes()
	{
		Route r = new Route();
		r.getDesAirport().setAirportCode("ABC");
		assertNotEquals("BCD", r.getDesAirport());
	}
	
	@Test
	public void testSetDes()
	{
		Route r = new Route();
		r.getDesAirport().setAirportCode("ABC");
		assertNotEquals("BCD", r.getDesAirport());
	}
}
