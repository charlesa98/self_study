package com.ss.utop.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetAllRoutes {
	private static final String driver="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/utopia";
	private static final String username="rootuser";
	private static final String password="root";
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException	{
		//register driver
		Class.forName(driver);
		//create connection 
		Connection conn = DriverManager.getConnection(url, username, password);
		//create a statement
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("select * from route");
		while(rs.next())
		{
			System.out.println("Airport route details: "+rs.getInt("id")+" "+rs.getString("origin_id")+" "+rs.getString("destination_id"));
		}
	}
}
