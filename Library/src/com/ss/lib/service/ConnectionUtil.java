package com.ss.lib.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	private final String driver="com.mysql.cj.jdbc.Driver";
	private final String url="jdbc:mysql://localhost:3306/library";
	private final String username="rootuser";
	private final String password="root";
	
	public Connection getConnection() throws ClassNotFoundException, SQLException
	{
		//register the driver
		Class.forName(driver);
		//create the connection
		Connection conn = DriverManager.getConnection(url, username, password);
		
		conn.setAutoCommit(Boolean.FALSE);				//dont make changes till I say so
		return conn;
	}
}
