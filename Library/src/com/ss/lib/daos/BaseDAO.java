package com.ss.lib.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author Charles Alms
 *
 */
public abstract class BaseDAO<T> {
	
	public static Connection conn = null; 
	
	@SuppressWarnings("static-access")		//just to keep the warnings down
	public BaseDAO(Connection conn)
	{
		this.conn = conn;
	}
	
	public void save(String sql, Object[] vals) throws ClassNotFoundException, SQLException
	{
		PreparedStatement pstmt = conn.prepareStatement(sql);		//passed in the sql statement into the prepared statement
		int count = 1;
		for(Object o : vals)
		{
			pstmt.setObject(count, o);
			count++;
		}
		pstmt.executeUpdate();			//execute it after
	}
	
	//helps with thread safety
	public Integer saveWithPK(String sql, Object[] vals) throws ClassNotFoundException, SQLException
	{
		PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);		//passed in the sql statement into the prepared statement
		int count = 1;
		for(Object o : vals)
		{
			pstmt.setObject(count, o);
			count++;
		}
		pstmt.executeUpdate();			//execute it after
		ResultSet rs = pstmt.getGeneratedKeys();
		
		if(rs.next())
		{
			return rs.getInt(1);
		}
		return null;
	}
	
	//reads the sql statement and returns it into the abstract function 
	public List<T> read(String sql, Object[] vals) throws ClassNotFoundException, SQLException
	{
		PreparedStatement pstmt = conn.prepareStatement(sql);		//passed in the sql statement into the prepared statement
		int count = 1;
		if (vals != null) {
            for (Object o : vals) {
                pstmt.setObject(count, o);
                count++;
            }
        }
		ResultSet rs = pstmt.executeQuery();			//execute it after
		return extractData(rs);
	}
	
	public abstract List<T> extractData(ResultSet rs) throws ClassNotFoundException, SQLException;
}
