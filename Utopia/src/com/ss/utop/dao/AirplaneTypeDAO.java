package com.ss.utop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utop.entity.AirplaneType;

public class AirplaneTypeDAO extends BaseDAO<AirplaneType>{
	
	public AirplaneTypeDAO(Connection conn) {
		super(conn);
	}

	public Integer addAirplaneType(AirplaneType at) throws ClassNotFoundException, SQLException
	{
		//the id will auto increment 
		return saveWithPK("INSERT INTO airplane_type (max_capacity) VALUES (?)",
				new Object[] {at.getCapacity()});
	}
	
	public void updateAirplaneType(AirplaneType at) throws ClassNotFoundException, SQLException
	{
		save("UPDATE airplane_type set max_capacity =? where id = ?", 
				new Object[] {at.getCapacity(), at.getId()});
	}
	
	public void deleteAirplaneType(AirplaneType at) throws ClassNotFoundException, SQLException
	{
		save("DELETE FROM airplane_type where id = ?", new Object[] {at.getId()});
	}
	
	public List<AirplaneType> getAllAirplaneTypes() throws ClassNotFoundException, SQLException
	{
		return read("select * from airplane_type", null);
	}
	
	@Override
	public List<AirplaneType> extractData(ResultSet rs) throws ClassNotFoundException, SQLException
	{
		List<AirplaneType> types = new ArrayList<>();
		
		while(rs.next())
		{
			AirplaneType type = new AirplaneType();
			type.setId(rs.getInt("id"));
			type.setCapacity(rs.getInt("max_capacity"));
			types.add(type);
		}
		return types;
	}
}