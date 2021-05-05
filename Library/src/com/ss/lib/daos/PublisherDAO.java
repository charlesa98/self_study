package com.ss.lib.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.lib.entity.Publisher;

public class PublisherDAO extends BaseDAO<Publisher>{

	public PublisherDAO(Connection conn) {
		super(conn);
	}

	public Integer addPublisher(Publisher pub) throws ClassNotFoundException, SQLException
	{
		return saveWithPK("INSERT INTO tbl_publisher (publisherId, publisherName, publisherAddress, publisherPhone) VALUES (?, ?, ?, ?)",
				new Object[] {pub.getPublisherID(), pub.getPublisherName(), pub.getPublisherAddress(), pub.getPublisherPhone()});
	}
	
	public void updatePublisher(Publisher pub) throws ClassNotFoundException, SQLException
	{
		save("UPDATE tbl_publisher set publisherName = ?, publisherAddress = ?, publisherPhone = ? where publisherId = ?", 
				new Object[] {pub.getPublisherName(), pub.getPublisherAddress(), pub.getPublisherPhone(), pub.getPublisherID()});
	}
	
	public void updatePublisherName(Publisher pub) throws ClassNotFoundException, SQLException
	{
		save("UPDATE tbl_publisher set publisherName = ? where publisherId = ?", 
				new Object[] {pub.getPublisherName(), pub.getPublisherID()});
	}
	
	public void updatePublisherAddress(Publisher pub) throws ClassNotFoundException, SQLException
	{
		save("UPDATE tbl_publisher set publisherAddress = ? where publisherId = ?", 
				new Object[] {pub.getPublisherAddress(), pub.getPublisherID()});
	}
	
	public void updatePublisherPhone(Publisher pub) throws ClassNotFoundException, SQLException
	{
		save("UPDATE tbl_publisher set publisherPhone = ? where publisherId = ?", 
				new Object[] {pub.getPublisherPhone(), pub.getPublisherID()});
	}
	
	public void deletePublisher(Publisher pub) throws ClassNotFoundException, SQLException
	{
		save("DELETE FROM tbl_publisher where publisherId = ?", new Object[] {pub.getPublisherID()});
	}
	
	public List<Publisher> getAllPublishers() throws ClassNotFoundException, SQLException
	{
		return read("select * from tbl_publisher", null);
		
	}
	@Override
	public List<Publisher> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Publisher> pubs = new ArrayList<>();
		
		while(rs.next())
		{
			Publisher pub = new Publisher();
			pub.setPublisherID(rs.getInt("pubisherId"));
			pub.setPublisherName(rs.getString("publisherName"));
			pub.setPublisherAddress(rs.getString("publisherAddress"));
			pub.setPublisherPhone(rs.getString("publisherPhone"));			
			pubs.add(pub);
		}
		return pubs;
	}
}
