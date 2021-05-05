package com.ss.lib.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.lib.entity.Author;

public class AuthorDAO extends BaseDAO<Author>{

	public AuthorDAO(Connection conn) {
		super(conn);
	}

	public Integer addAuthor(Author author) throws ClassNotFoundException, SQLException
	{
		return saveWithPK("INSERT INTO tbl_author (authorId, authorName) VALUES (?, ?)",
				new Object[] {author.getAuthorID(), author.getAuthorName()});
	}
	
	public void updateAuthor(Author author) throws ClassNotFoundException, SQLException
	{
		save("UPDATE tbl_author set authorName = ? where authorId = ?", 
				new Object[] {author.getAuthorName(), author.getAuthorID()});
	}
	
	public void deleteAuthor(Author author) throws ClassNotFoundException, SQLException
	{
		save("DELETE FROM tbl_author where authorId = ?", new Object[] {author.getAuthorID()});
	}
	
	public List<Author> getAllAuthors() throws ClassNotFoundException, SQLException
	{
		return read("select * from tbl_author", null);
		
	}
	@Override
	public List<Author> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Author> authors = new ArrayList<>();
		
		while(rs.next())
		{
			Author author = new Author();
			author.setAuthorID(rs.getInt("authorId"));
			author.setAuthorName(rs.getString("authorName"));
			authors.add(author);
			
		}
		return authors;
	}
}