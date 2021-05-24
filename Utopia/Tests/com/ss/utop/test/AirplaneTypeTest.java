package com.ss.utop.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ss.utop.entity.AirplaneType;

public class AirplaneTypeTest {
	
	@Test
	public void testGetID()
	{
		AirplaneType at = new AirplaneType();
		at.setId(10);
		assertEquals(at.getId(), 10.0, .0001);
	}
	
	@Test
	public void testSetID()
	{
		AirplaneType at = new AirplaneType();
		at.setId(10);
		assertEquals(at.getId(), 10.0, .0001);
	}
	
	@Test
	public void testGetCap()
	{
		AirplaneType at = new AirplaneType();
		at.setCapacity(100);
		assertEquals(at.getCapacity(), 100.0, .0001);
	}
	
	@Test
	public void testSetCap()
	{
		AirplaneType at = new AirplaneType();
		at.setCapacity(100);
		assertEquals(at.getCapacity(), 100.0, .0001);
	}
}
