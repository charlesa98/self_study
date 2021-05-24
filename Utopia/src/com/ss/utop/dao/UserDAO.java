package com.ss.utop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utop.entity.User;

public class UserDAO extends BaseDAO<User>{
	
	public UserDAO(Connection conn) {
		super(conn);
	}

	public Integer addUser(User user) throws ClassNotFoundException, SQLException
	{
		return saveWithPK("INSERT INTO user (role_id, given_name, family_name, username, email, password, phone) VALUES (?, ?, ?, ?, ?, ?, ?)",
				new Object[] {user.getUserRole().getId(), user.getfName(), user.getlName(), user.getUserName(),
						user.getEmail(), user.getPassword(), user.getPhone()});
	}
	
	public void updateUser(User user) throws ClassNotFoundException, SQLException
	{
		save("UPDATE user set role_id =? , given_name = ? family_name = ?, username = ?, email = ?, password = ?, phone = ? where id = ?", 
				new Object[] {user.getUserRole().getId(), user.getfName(), user.getlName(), user.getUserName(),
						user.getEmail(), user.getPassword(), user.getPhone(), user.getUserId()});
	}
	
	public void deleteUser(User user) throws ClassNotFoundException, SQLException
	{
		save("DELETE FROM user where id = ?", new Object[] {user.getUserId()});
	}
	
	public List<User> getAllUsers() throws ClassNotFoundException, SQLException
	{
		return read("select * from user", null);
	}
	
	@Override
	public List<User> extractData(ResultSet rs) throws ClassNotFoundException, SQLException
	{
		List<User> users = new ArrayList<>();
		
		while(rs.next())
		{
			User user = new User();
			user.setUserId(rs.getInt("id"));
			user.getUserRole().setId(rs.getInt("role_id"));
			user.setfName(rs.getString("given_name"));
			user.setlName(rs.getString("family_name"));
			user.setUserName(rs.getString("username"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setPhone(rs.getString("phone"));
			users.add(user);
		}
		return users;
	}
}