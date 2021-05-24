package com.ss.utop.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.ss.utop.dao.AirplaneDAO;
import com.ss.utop.dao.AirplaneTypeDAO;
import com.ss.utop.entity.Airplane;
import com.ss.utop.entity.AirplaneType;
import com.ss.utop.service.ConnectionUtil;

public class AirplaneTest {
	ConnectionUtil connUtil = new ConnectionUtil();
	Connection conn = null;
	AirplaneType apt = new AirplaneType();
	Airplane ap = new Airplane();
	//--------------------Airplane---------------------------------------------------------------------
		@Test
		public void testAddAirplane() throws ClassNotFoundException, SQLException
		{
			conn = connUtil.getConnection();
			AirplaneDAO adao = new AirplaneDAO(conn);
			AirplaneTypeDAO tdao = new AirplaneTypeDAO(conn);
			Airplane plane = new Airplane();
			plane.setAPId(1);
			AirplaneType type = new AirplaneType();
			type.setId(1);
			type.setCapacity(10);
			plane.setType(type);
			try {
				tdao.addAirplaneType(type);
				adao.addAirplane(plane);
				adao.deleteAirplane(plane);
				tdao.deleteAirplaneType(type);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				fail();
			}
		}
		
		
		
		@Test
		public void testReadAllAirplane() throws ClassNotFoundException, SQLException
		{
			conn = connUtil.getConnection();
			AirplaneDAO apdao = new AirplaneDAO(conn);
			
			try {
				List<Airplane> planes = apdao.getAllAirplanes();
				for(Airplane p : planes)
				{
					System.out.println(p.toString());
				}
			}catch(ClassNotFoundException | SQLException e)
			{
				e.printStackTrace();
				fail();
			}
		}
}
