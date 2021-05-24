package com.ss.utop.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddRoute {
	private static final String driver="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/utopia";
	private static final String username="rootuser";
	private static final String password="root";
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException	{
		//register driver
		Class.forName(driver);
		//create connection 
		Connection conn = DriverManager.getConnection(url, username, password);

		//PreparedStatement does not allow sql injection
		//adds a route from EXSITING airports. Must create them first 
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO route (origin_id, destination_id) VALUES (?, ?)");
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter origin airport code");
		String airportCode = scan.nextLine();
		
		System.out.println("Enter destiination airport code");
		String desAirportCode = scan.nextLine();
		
		pstmt.setString(1, airportCode);			//origin_id
		pstmt.setString(2, desAirportCode);			//destination_id
		
		pstmt.executeUpdate();
		scan.close();
	}
}
