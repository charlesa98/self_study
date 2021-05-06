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
//------------------PUBLISHER------------------------------------------------------
	@Test
	public void testAddPublisher() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		PublisherDAO pdao = new PublisherDAO(conn);
		p.setPublisherID(543534);
		p.setPublisherName("Jim");
		p.setPublisherAddress("123 street");
		p.setPublisherPhone("1800");
		
		try {
			pdao.addPublisher(p);
			pdao.deletePublisher(p);
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testUpdatePublisher() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		PublisherDAO pdao = new PublisherDAO(conn);
		p.setPublisherID(543535);
		p.setPublisherName("Jim");
		p.setPublisherAddress("123 street");
		p.setPublisherPhone("1800");
		
		try {
			pdao.addPublisher(p);
			p.setPublisherName("Jimmy");
			p.setPublisherAddress("124 street");
			p.setPublisherPhone("1800");
			pdao.updatePublisher(p);
			pdao.deletePublisher(p);
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testGetAllPublishers() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		PublisherDAO pdao = new PublisherDAO(conn);
		p.setPublisherID(543536);
		p.setPublisherName("Jim");
		p.setPublisherAddress("123 street");
		p.setPublisherPhone("1800");
		
		try {
			pdao.addPublisher(p);
			assertEquals(52, pdao.getAllPublishers().size());		//I created 52
			pdao.deletePublisher(p);
			assertEquals(51, pdao.getAllPublishers().size());		
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testDeletePublishers() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		PublisherDAO pdao = new PublisherDAO(conn);
		p.setPublisherID(543537);
		p.setPublisherName("Jim");
		p.setPublisherAddress("123 street");
		p.setPublisherPhone("1800");
		
		try {
			pdao.addPublisher(p);
			pdao.deletePublisher(p);
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
//-------------------LibraryBranch--------------------------------------------------------------
	@Test
	public void testAddBranch() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		LibraryBranchDAO lbdao = new LibraryBranchDAO(conn);
		lb.setBranchID(54325);
		lb.setBranchName("Test branch");
		lb.setBranchAddress("Test street");
		
		try {
			lbdao.addLibraryBranch(lb);
			lbdao.deleteLibraryBranch(lb);
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testUpdateBranch() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		LibraryBranchDAO lbdao = new LibraryBranchDAO(conn);
		lb.setBranchID(54326);
		lb.setBranchName("Test branch");
		lb.setBranchAddress("Test street");
		
		try {
			lbdao.addLibraryBranch(lb);
			lb.setBranchName("Test Branch");
			lbdao.updateLibraryBranch(lb);
			lbdao.deleteLibraryBranch(lb);
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testGetBranch() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		LibraryBranchDAO lbdao = new LibraryBranchDAO(conn);
		lb.setBranchID(54327);
		lb.setBranchName("Test branch");
		lb.setBranchAddress("Test street");
		
		try {
			lbdao.addLibraryBranch(lb);
			assertEquals(52, lbdao.getAllLibraryBranchs().size());		//I created 52
			lbdao.deleteLibraryBranch(lb);
			assertEquals(51, lbdao.getAllLibraryBranchs().size());
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testDeleteBranch() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		LibraryBranchDAO lbdao = new LibraryBranchDAO(conn);
		lb.setBranchID(54328);
		lb.setBranchName("Test branch");
		lb.setBranchAddress("Test street");
		
		try {
			lbdao.addLibraryBranch(lb);
			lbdao.deleteLibraryBranch(lb);
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
//----------------------BOOK------------------------------------------------------	

	@Test(timeout = 3000)
	public void testAddBook() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		BookDAO bdao = new BookDAO(conn);
		AuthorDAO adao = new AuthorDAO(conn);
		PublisherDAO pdao = new PublisherDAO(conn);
		
		a.setAuthorID(756467);
		a.setAuthorName("John");
		
		p.setPublisherID(42343543);
		p.setPublisherName("Jim");
		p.setPublisherAddress("123 street");
		p.setPublisherPhone("1800");
		
		b.setBookID(45623456);
		b.setTitle("Book title");
		b.setBookAuthorID(a);
		b.setBookPubID(p);		
		
		try {
			adao.addAuthor(a);
			pdao.addPublisher(p);
			bdao.addBook(b);				//something is wrong here
			
			bdao.deleteBook(b);
			adao.deleteAuthor(a);
			pdao.deletePublisher(p);
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
//---------------BORROWER------------------------------------------------------------	
	@Test
	public void testAddBorrower() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		BorrowerDAO bowdao = new BorrowerDAO(conn);
		bow.setCardNum(543534);
		bow.setbName("Jim");
		bow.setbAddress("123 street");
		bow.setbPhone("1800");
		
		try {
			bowdao.addBorrower(bow);
			bowdao.deleteBorrower(bow);
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	@Test
	public void testUpdateBorrower() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		BorrowerDAO bowdao = new BorrowerDAO(conn);
		bow.setCardNum(543535);
		bow.setbName("Jim");
		bow.setbAddress("123 street");
		bow.setbPhone("1800");
		
		try {
			bowdao.addBorrower(bow);
			bow.setbName("Jan");
			bowdao.updateBorrower(bow);
			bowdao.deleteBorrower(bow);
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testDeleteBorrower() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		BorrowerDAO bowdao = new BorrowerDAO(conn);
		bow.setCardNum(543536);
		bow.setbName("Jim");
		bow.setbAddress("123 street");
		bow.setbPhone("1800");
		
		try {
			bowdao.addBorrower(bow);
			bowdao.deleteBorrower(bow);
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testGetBorrower() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		BorrowerDAO bowdao = new BorrowerDAO(conn);
		bow.setCardNum(543534);
		bow.setbName("Jim");
		bow.setbAddress("123 street");
		bow.setbPhone("1800");
		
		try {
			bowdao.addBorrower(bow);
			assertEquals(22, bowdao.getAllBorrowers().size());
			bowdao.deleteBorrower(bow);
			assertEquals(21, bowdao.getAllBorrowers().size());
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
}
