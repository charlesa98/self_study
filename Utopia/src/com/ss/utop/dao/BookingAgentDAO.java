package com.ss.utop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utop.entity.BookingAgent;

public class BookingAgentDAO extends BaseDAO<BookingAgent>{
	
	public BookingAgentDAO(Connection conn) {
		super(conn);
	}

	public Integer addba(BookingAgent ba) throws ClassNotFoundException, SQLException
	{
		return saveWithPK("INSERT INTO booking_agent (booking_id, agent_id) VALUES (?, ?)",
				new Object[] {ba.getBookingAgentId().getId(), ba.getAgentId()});
	}
	
	public void updateba(BookingAgent ba) throws ClassNotFoundException, SQLException
	{
		save("UPDATE booking_agent set agent_id = ? where id = ?", 
				new Object[] {ba.getAgentId(), ba.getBookingAgentId().getId()});
	}
	
	public void deleteba(BookingAgent ba) throws ClassNotFoundException, SQLException
	{
		save("DELETE FROM booking_agent where id = ?", new Object[] {ba.getAgentId()});			//delete agent id and not booking id
	}
	
	public List<BookingAgent> getAllBookingAgents() throws ClassNotFoundException, SQLException
	{
		return read("select * from booking_agent", null);
	}
	
	@Override
	public List<BookingAgent> extractData(ResultSet rs) throws ClassNotFoundException, SQLException
	{
		List<BookingAgent> agents = new ArrayList<>();
		
		while(rs.next())
		{
			BookingAgent agent = new BookingAgent();
			agent.getBookingAgentId().setId(rs.getInt("booking_id"));
			agent.setAgentId(rs.getInt("agent_id"));
			agents.add(agent);
		}
		return agents;
	}
}
