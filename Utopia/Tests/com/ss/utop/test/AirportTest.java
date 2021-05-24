package com.ss.utop.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

import com.ss.utop.entity.Airport;

public class AirportTest {
	
	@Test
	public void testGetAirportCode()
	{
		Airport ap = new Airport();
		assertNull(ap.getAirportCode());
		ap.setAirportCode("ABC");
		assertEquals("ABC", ap.getAirportCode());
		assertNotEquals("gfd", ap.getAirportCode());
	}
	
	@Test
	public void testSetAirportCode()
	{
		Airport ap = new Airport();
		assertNull(ap.getAirportCode());
		ap.setAirportCode("ABC");
		assertEquals("ABC", ap.getAirportCode());
		assertNotEquals("gfd", ap.getAirportCode());
	}
	
	@Test
	public void testGetAirportCity()
	{
		Airport ap = new Airport();
		assertNull(ap.getCityName());
		ap.setCityName("Some City");
		assertEquals("Some City", ap.getCityName());
		assertNotEquals("gfd", ap.getCityName());
	}
	
	@Test
	public void testSetAirportCity()
	{
		Airport ap = new Airport();
		assertNull(ap.getCityName());
		ap.setCityName("Some City");
		assertEquals("Some City", ap.getCityName());
		assertNotEquals("gfd", ap.getCityName());
	}
}
