package com.ss.lib.tests;
import org.junit.Test;

import com.ss.lib.entity.*;
import com.ss.lib.service.ConnectionUtil;
import com.ss.lib.daos.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;

public class Tests {
	ConnectionUtil connUtil = new ConnectionUtil();
	Connection conn = null;
	Author a = new Author();
	Book b = new Book();
	Publisher p = new Publisher();
	Borrower bow = new Borrower();
	LibraryBranch lb = new LibraryBranch();
	BookLoans bl = new BookLoans();
	BookCopies bc = new BookCopies();
	
	@Test
	public void testAddAuthor() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		AuthorDAO adao = new AuthorDAO(conn);
		a.setAuthorID(1200001);
		a.setAuthorName("John");
		
		try {
			adao.addAuthor(a);
			adao.deleteAuthor(a);
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testUpdateAuthor() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		AuthorDAO adao = new AuthorDAO(conn);
		a.setAuthorID(1200002);
		a.setAuthorName("John");
		
		try {
			adao.addAuthor(a);
			a.setAuthorName("Kyle");
			adao.updateAuthor(a);
			
			adao.deleteAuthor(a);
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testDeleteAuthor() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		AuthorDAO adao = new AuthorDAO(conn);
		a.setAuthorID(1200003);
		a.setAuthorName("John");
		
		try {
			adao.addAuthor(a);
			adao.deleteAuthor(a);
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testGetAllAuthors() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		AuthorDAO adao = new AuthorDAO(conn);
		a.setAuthorID(1200004);
		a.setAuthorName("John");
		
		try {
			adao.addAuthor(a);
			assertEquals(53, adao.getAllAuthors().size());		//I created 53
			adao.deleteAuthor(a);
			assertEquals(52, adao.getAllAuthors().size());
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testAddBook() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		BookDAO bdao = new BookDAO(conn);
		AuthorDAO adao = new AuthorDAO(conn);
		PublisherDAO pdao = new PublisherDAO(conn);
		
		a.setAuthorID(1200005);
		a.setAuthorName("John");
		
		p.setPublisherID(111111);
		p.setPublisherName("Jim");
		p.setPublisherAddress("123 street");
		p.setPublisherPhone("1800");
		
		b.setBookAuthorID(a);
		b.setBookID(123456);
		b.setBookPubID(p);
		b.setTitle("Book title");
		
		try {
			adao.addAuthor(a);
			pdao.addPublisher(p);
			bdao.addBook(b);
			
			adao.deleteAuthor(a);
			pdao.deletePublisher(p);
			bdao.deleteBook(b);
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
}
