package com.ss.utop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utop.entity.UserRole;
public class UserRoleDAO extends BaseDAO<UserRole>{
	
	public UserRoleDAO(Connection conn) {
		super(conn);
	}

	public Integer addUserRole(UserRole ur) throws ClassNotFoundException, SQLException
	{
		return saveWithPK("INSERT INTO user_role (name) VALUES (?)",
				new Object[] {ur.getName()});
	}
	
	public void updateUserRole(UserRole ur) throws ClassNotFoundException, SQLException
	{
		save("UPDATE user_role set name =? where id = ?", 
				new Object[] {ur.getName(), ur.getId()});
	}
	
	public void deleteUserRole(UserRole ur) throws ClassNotFoundException, SQLException
	{
		save("DELETE FROM user_role where id = ?", new Object[] {ur.getId()});
	}
	
	public List<UserRole> getAllUserRoles() throws ClassNotFoundException, SQLException
	{
		return read("select * from user_role", null);
	}
	
	@Override
	public List<UserRole> extractData(ResultSet rs) throws ClassNotFoundException, SQLException
	{
		List<UserRole> roles = new ArrayList<>();
		
		while(rs.next())
		{
			UserRole role = new UserRole();
			role.setId(rs.getInt("id"));
			role.setName(rs.getString("name"));
			roles.add(role);
		}
		return roles;
	}
}
