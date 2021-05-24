package com.ss.utop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utop.entity.Airplane;

public class AirplaneDAO extends BaseDAO<Airplane>{
	
	public AirplaneDAO(Connection conn) {
		super(conn);
	}
	public Integer addAirplane(Airplane airplane) throws ClassNotFoundException, SQLException
	{
		return saveWithPK("INSERT INTO airplane (type_id) VALUES (?)",
				new Object[] {airplane.getType().getId()});
	}
	
	public void updateAirplane(Airplane airplane) throws ClassNotFoundException, SQLException
	{
		save("UPDATE airplane set type_id = ? where id = ?", 
				new Object[] {airplane.getType().getId(), airplane.getAPId()});
	}
	
	public void deleteAirplane(Airplane airplane) throws ClassNotFoundException, SQLException
	{
		save("DELETE FROM airplane where id = ?", new Object[] {airplane.getAPId()});
	}
	
	public List<Airplane> getAllAirplanes() throws ClassNotFoundException, SQLException
	{
		return read("select * from airplane", null);
	}

	@Override
	public List<Airplane> extractData(ResultSet rs) throws ClassNotFoundException, SQLException
	{
		List<Airplane> planes = new ArrayList<>();
		
		while(rs.next())
		{
			Airplane plane = new Airplane();
			plane.setAPId(rs.getInt("id"));
			plane.getType().setId(rs.getInt("type_id"));
			planes.add(plane);
		}
		return planes;
	}
}
