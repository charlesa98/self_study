package com.ss.lib.tests;
import org.junit.Test;

import com.ss.lib.entity.*;
import com.ss.lib.service.ConnectionUtil;
import com.ss.lib.daos.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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
//------------------------AUTHOR----------------------------
	@Test
	public void testAddAuthor() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		AuthorDAO adao = new AuthorDAO(conn);
		a.setAuthorID(1200001);
		a.setAuthorName("John");
		
		try {
			adao.deleteAuthor(a);									//delete it first just in case it was already created before
			conn.commit();
			adao.addAuthor(a);
			conn.commit();
			adao.deleteAuthor(a);
			conn.commit();
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
			adao.deleteAuthor(a);
			conn.commit();
			adao.addAuthor(a);
			a.setAuthorName("Kyle");
			adao.updateAuthor(a);
			conn.commit();
			
			adao.deleteAuthor(a);
			conn.commit();
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
			adao.deleteAuthor(a);
			conn.commit();
			adao.addAuthor(a);
			conn.commit();
			adao.deleteAuthor(a);
			conn.commit();
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
			adao.deleteAuthor(a);								//delete it first just in case it was already created before
			conn.commit();
			adao.addAuthor(a);
			conn.commit();
			assertEquals(58, adao.getAllAuthors().size());		//I created 57
			adao.deleteAuthor(a);
			conn.commit();
			assertEquals(57, adao.getAllAuthors().size());
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void listAuthors() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		AuthorDAO adao = new AuthorDAO(conn);
		
		List<Author> authors = adao.getAllAuthors();
		for(Author a : authors)
		{
			System.out.println(a.toString());
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
			pdao.deletePublisher(p);
			conn.commit();
			pdao.addPublisher(p);
			conn.commit();
			pdao.deletePublisher(p);
			conn.commit();
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
			pdao.deletePublisher(p);
			conn.commit();
			pdao.addPublisher(p);
			p.setPublisherName("Jimmy");
			p.setPublisherAddress("124 street");
			p.setPublisherPhone("1-800-032-4231");
			pdao.updatePublisher(p);
			conn.commit();
			pdao.deletePublisher(p);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testUpdatePublisherName() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		PublisherDAO pdao = new PublisherDAO(conn);
		p.setPublisherID(543535);
		p.setPublisherName("Jim");
		p.setPublisherAddress("123 street");
		p.setPublisherPhone("1800");
		
		try {
			pdao.deletePublisher(p);
			conn.commit();
			pdao.addPublisher(p);
			p.setPublisherName("Jimmy");
			pdao.updatePublisher(p);
			conn.commit();
			pdao.deletePublisher(p);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testUpdatePublisherAddress() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		PublisherDAO pdao = new PublisherDAO(conn);
		p.setPublisherID(543535);
		p.setPublisherName("Jim");
		p.setPublisherAddress("123 street");
		p.setPublisherPhone("1800");
		
		try {
			pdao.deletePublisher(p);
			conn.commit();
			pdao.addPublisher(p);
			p.setPublisherAddress("124 street");
			pdao.updatePublisher(p);
			conn.commit();
			pdao.deletePublisher(p);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testUpdatePublisherPhone() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		PublisherDAO pdao = new PublisherDAO(conn);
		p.setPublisherID(543535);
		p.setPublisherName("Jim");
		p.setPublisherAddress("123 street");
		p.setPublisherPhone("1800");
		
		try {
			pdao.deletePublisher(p);
			conn.commit();
			pdao.addPublisher(p);
			p.setPublisherPhone("1-800-000-0000");
			pdao.updatePublisher(p);
			conn.commit();
			pdao.deletePublisher(p);
			conn.commit();
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
			pdao.deletePublisher(p);
			conn.commit();
			pdao.addPublisher(p);
			conn.commit();
			assertEquals(53, pdao.getAllPublishers().size());		//I created 53
			pdao.deletePublisher(p);
			conn.commit();
			assertEquals(52, pdao.getAllPublishers().size());		
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
			pdao.deletePublisher(p);
			conn.commit();
			pdao.addPublisher(p);
			conn.commit();
			pdao.deletePublisher(p);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void listPublishers() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		PublisherDAO pdao = new PublisherDAO(conn);
		
		List<Publisher> pubs = pdao.getAllPublishers();
		for(Publisher p : pubs)
		{
			System.out.println(p.toString());
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
			lbdao.deleteLibraryBranch(lb);
			conn.commit();
			lbdao.addLibraryBranch(lb);
			conn.commit();
			lbdao.deleteLibraryBranch(lb);
			conn.commit();
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
			lbdao.deleteLibraryBranch(lb);
			conn.commit();
			lbdao.addLibraryBranch(lb);
			lb.setBranchName("Test Branch");
			lb.setBranchAddress("Some Street");
			lbdao.updateLibraryBranch(lb);
			conn.commit();
			lbdao.deleteLibraryBranch(lb);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testUpdateBranchName() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		LibraryBranchDAO lbdao = new LibraryBranchDAO(conn);
		lb.setBranchID(54326);
		lb.setBranchName("Test branch");
		lb.setBranchAddress("Test street");
		
		try {
			lbdao.deleteLibraryBranch(lb);
			conn.commit();
			lbdao.addLibraryBranch(lb);
			lb.setBranchName("Test Branch");
			lbdao.updateLibraryBranch(lb);
			conn.commit();
			lbdao.deleteLibraryBranch(lb);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testUpdateBranchAddress() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		LibraryBranchDAO lbdao = new LibraryBranchDAO(conn);
		lb.setBranchID(54326);
		lb.setBranchName("Test branch");
		lb.setBranchAddress("Test street");
		
		try {
			lbdao.deleteLibraryBranch(lb);
			conn.commit();
			lbdao.addLibraryBranch(lb);
			lb.setBranchAddress("Some Street");
			lbdao.updateLibraryBranch(lb);
			conn.commit();
			lbdao.deleteLibraryBranch(lb);
			conn.commit();
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
			lbdao.deleteLibraryBranch(lb);
			conn.commit();
			lbdao.addLibraryBranch(lb);
			conn.commit();
			assertEquals(52, lbdao.getAllLibraryBranchs().size());		//I created 51
			lbdao.deleteLibraryBranch(lb);
			conn.commit();
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
			lbdao.deleteLibraryBranch(lb);
			conn.commit();
			lbdao.addLibraryBranch(lb);
			conn.commit();
			lbdao.deleteLibraryBranch(lb);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void listBranches() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		LibraryBranchDAO lbdao = new LibraryBranchDAO(conn);
		
		List<LibraryBranch> branches = lbdao.getAllLibraryBranchs();
		for(LibraryBranch lb : branches)
		{
			System.out.println(lb.toString());
		}
	}
//---------------BOOKS---------------------------------------------------------------
	@Test (timeout = 3000)
	public void testAddBook() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		BookDAO bdao = new BookDAO(conn);
		AuthorDAO adao = new AuthorDAO(conn);
		PublisherDAO pdao = new PublisherDAO(conn);
		
		a.setAuthorID(45436543);
		a.setAuthorName("John");
		
		p.setPublisherID(42343543);
		p.setPublisherName("Jim");
		p.setPublisherAddress("123 street");
		p.setPublisherPhone("1800");
		
		b.setBookID(45623456);
		b.setTitle("Test Book Title");
		b.setBookAuthorID(a);
		b.setBookPubID(p);		
		
		try {
			bdao.deleteBook(b);
			adao.deleteAuthor(a);
			pdao.deletePublisher(p);
			conn.commit();
			
			adao.addAuthor(a);
			pdao.addPublisher(p);
			bdao.addBook(b);				
			conn.commit();
			
			bdao.deleteBook(b);
			adao.deleteAuthor(a);
			pdao.deletePublisher(p);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}	
	
	@Test(timeout = 3000)
	public void testUpdateBook() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		BookDAO bdao = new BookDAO(conn);
		AuthorDAO adao = new AuthorDAO(conn);
		PublisherDAO pdao = new PublisherDAO(conn);
		
		a.setAuthorID(756468);
		a.setAuthorName("John");
		
		p.setPublisherID(423435567);
		p.setPublisherName("Jim");
		p.setPublisherAddress("123 street");
		p.setPublisherPhone("1800");
		
		b.setBookID(456235676);
		b.setTitle("Test Book Title");
		b.setBookAuthorID(a);
		b.setBookPubID(p);		
		
		try {
			bdao.deleteBook(b);
			adao.deleteAuthor(a);
			pdao.deletePublisher(p);
			conn.commit();
			adao.addAuthor(a);
			pdao.addPublisher(p);	
			b.setTitle("Test New Title");
			b.setBookAuthorID(a);
			b.setBookPubID(p);
			bdao.updateBook(b);
			conn.commit();
			
			bdao.deleteBook(b);
			adao.deleteAuthor(a);
			pdao.deletePublisher(p);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}	
	
	@Test(timeout = 3000)
	public void testUpdateBookTitle() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		BookDAO bdao = new BookDAO(conn);
		AuthorDAO adao = new AuthorDAO(conn);
		PublisherDAO pdao = new PublisherDAO(conn);
		
		a.setAuthorID(756468);
		a.setAuthorName("John");
		
		p.setPublisherID(423435567);
		p.setPublisherName("Jim");
		p.setPublisherAddress("123 street");
		p.setPublisherPhone("1800");
		
		b.setBookID(456235676);
		b.setTitle("Test Book Title");
		b.setBookAuthorID(a);
		b.setBookPubID(p);		
		
		try {
			bdao.deleteBook(b);
			adao.deleteAuthor(a);
			pdao.deletePublisher(p);
			conn.commit();
			adao.addAuthor(a);
			pdao.addPublisher(p);	
			b.setTitle("Test New Title");
			bdao.updateBook(b);
			conn.commit();
			
			bdao.deleteBook(b);
			adao.deleteAuthor(a);
			pdao.deletePublisher(p);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test(timeout = 3000)
	public void testUpdateBookAuthor() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		BookDAO bdao = new BookDAO(conn);
		AuthorDAO adao = new AuthorDAO(conn);
		PublisherDAO pdao = new PublisherDAO(conn);
		
		a.setAuthorID(756468);
		a.setAuthorName("John");
		
		p.setPublisherID(423435567);
		p.setPublisherName("Jim");
		p.setPublisherAddress("123 street");
		p.setPublisherPhone("1800");
		
		b.setBookID(456235676);
		b.setTitle("Test Book Title");
		b.setBookAuthorID(a);
		b.setBookPubID(p);		
		
		try {
			bdao.deleteBook(b);
			adao.deleteAuthor(a);
			pdao.deletePublisher(p);
			conn.commit();
			adao.addAuthor(a);
			pdao.addPublisher(p);	
			a.setAuthorID(45564);
			b.setBookAuthorID(a);
			bdao.updateBook(b);
			conn.commit();
			
			bdao.deleteBook(b);
			adao.deleteAuthor(a);
			pdao.deletePublisher(p);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test(timeout = 3000)
	public void testUpdateBookPublisher() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		BookDAO bdao = new BookDAO(conn);
		AuthorDAO adao = new AuthorDAO(conn);
		PublisherDAO pdao = new PublisherDAO(conn);
		
		a.setAuthorID(756468);
		a.setAuthorName("John");
		
		p.setPublisherID(423435567);
		p.setPublisherName("Jim");
		p.setPublisherAddress("123 street");
		p.setPublisherPhone("1800");
		
		b.setBookID(456235676);
		b.setTitle("Test Book Title");
		b.setBookAuthorID(a);
		b.setBookPubID(p);		
		
		try {
			bdao.deleteBook(b);
			adao.deleteAuthor(a);
			pdao.deletePublisher(p);
			conn.commit();
			adao.addAuthor(a);
			pdao.addPublisher(p);	
			p.setPublisherID(6453);
			b.setBookPubID(p);
			bdao.updateBook(b);
			conn.commit();
			
			bdao.deleteBook(b);
			adao.deleteAuthor(a);
			pdao.deletePublisher(p);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test (timeout = 3000)
	public void testDeleteBook() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		BookDAO bdao = new BookDAO(conn);
		AuthorDAO adao = new AuthorDAO(conn);
		PublisherDAO pdao = new PublisherDAO(conn);
		
		a.setAuthorID(7560);
		a.setAuthorName("John");
		
		p.setPublisherID(42343543);
		p.setPublisherName("Jim");
		p.setPublisherAddress("123 street");
		p.setPublisherPhone("1800");
		
		b.setBookID(45623459);
		b.setTitle("Test Book Title");
		b.setBookAuthorID(a);
		b.setBookPubID(p);		
		
		try {
			bdao.deleteBook(b);
			adao.deleteAuthor(a);
			pdao.deletePublisher(p);
			conn.commit();
			adao.addAuthor(a);
			pdao.addPublisher(p);
			bdao.addBook(b);				
			conn.commit();
			bdao.deleteBook(b);
			adao.deleteAuthor(a);
			pdao.deletePublisher(p);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test (timeout = 3000)
	public void testDeleteBookAuthor() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		BookDAO bdao = new BookDAO(conn);
		AuthorDAO adao = new AuthorDAO(conn);
		PublisherDAO pdao = new PublisherDAO(conn);
		
		a.setAuthorID(7560);
		a.setAuthorName("John");
		
		p.setPublisherID(42343543);
		p.setPublisherName("Jim");
		p.setPublisherAddress("123 street");
		p.setPublisherPhone("1800");
		
		b.setBookID(45623459);
		b.setTitle("Test Book Title");
		b.setBookAuthorID(a);
		b.setBookPubID(p);		
		
		try {
			bdao.deleteBook(b);
			adao.deleteAuthor(a);
			pdao.deletePublisher(p);
			conn.commit();
			adao.addAuthor(a);
			pdao.addPublisher(p);
			bdao.addBook(b);				
			conn.commit();
			bdao.deleteBookAuthor(b);
			adao.deleteAuthor(a);
			pdao.deletePublisher(p);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test (timeout = 3000)
	public void testDeleteBookPublisher() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		BookDAO bdao = new BookDAO(conn);
		AuthorDAO adao = new AuthorDAO(conn);
		PublisherDAO pdao = new PublisherDAO(conn);
		
		a.setAuthorID(7560);
		a.setAuthorName("John");
		
		p.setPublisherID(42343543);
		p.setPublisherName("Jim");
		p.setPublisherAddress("123 street");
		p.setPublisherPhone("1800");
		
		b.setBookID(45623459);
		b.setTitle("Test Book Title");
		b.setBookAuthorID(a);
		b.setBookPubID(p);		
		
		try {
			bdao.deleteBook(b);
			adao.deleteAuthor(a);
			pdao.deletePublisher(p);
			conn.commit();
			adao.addAuthor(a);
			pdao.addPublisher(p);
			bdao.addBook(b);				
			conn.commit();
			bdao.deleteBookPublisher(b);
			adao.deleteAuthor(a);
			pdao.deletePublisher(p);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testGetAllBooks() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		BookDAO bdao = new BookDAO(conn);
		AuthorDAO adao = new AuthorDAO(conn);
		PublisherDAO pdao = new PublisherDAO(conn);
		
		a.setAuthorID(6254435);
		a.setAuthorName("John");
		
		p.setPublisherID(54325434);
		p.setPublisherName("Jim");
		p.setPublisherAddress("123 street");
		p.setPublisherPhone("1800");
		
		b.setBookID(58675678);
		b.setTitle("Test Book Title");
		b.setBookAuthorID(a);
		b.setBookPubID(p);		
		
		try {
			bdao.deleteBook(b);
			adao.deleteAuthor(a);
			pdao.deletePublisher(p);
			conn.commit();
			adao.addAuthor(a);
			pdao.addPublisher(p);
			bdao.addBook(b);	
			conn.commit();
			assertEquals(47, bdao.getAllBooks().size());		//I created 48
			bdao.deleteBook(b);
			conn.commit();
			assertEquals(46, bdao.getAllBooks().size());
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void listBooks() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		BookDAO bdao = new BookDAO(conn);
		
		List<Book> books = bdao.getAllBooks();
		for(Book b : books)
		{
			System.out.println(b.toString());
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
			bowdao.deleteBorrower(bow);
			conn.commit();
			bowdao.addBorrower(bow);
			conn.commit();
			bowdao.deleteBorrower(bow);
			conn.commit();
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
			bowdao.deleteBorrower(bow);
			conn.commit();
			bowdao.addBorrower(bow);
			bow.setbName("Jan");
			bow.setbAddress("122 Street");
			bow.setbPhone("1-800-000-0000");
			bowdao.updateBorrower(bow);
			conn.commit();
			bowdao.deleteBorrower(bow);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testUpdateBorrowerName() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		BorrowerDAO bowdao = new BorrowerDAO(conn);
		bow.setCardNum(543535);
		bow.setbName("Jim");
		bow.setbAddress("123 street");
		bow.setbPhone("1800");
		
		try {
			bowdao.deleteBorrower(bow);
			conn.commit();
			bowdao.addBorrower(bow);
			bow.setbName("Jan");
			bowdao.updateBorrower(bow);
			conn.commit();
			bowdao.deleteBorrower(bow);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testUpdateBorrowerAddress() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		BorrowerDAO bowdao = new BorrowerDAO(conn);
		bow.setCardNum(543535);
		bow.setbName("Jim");
		bow.setbAddress("123 street");
		bow.setbPhone("1800");
		
		try {
			bowdao.deleteBorrower(bow);
			conn.commit();
			bowdao.addBorrower(bow);
			bow.setbAddress("122 Street");
			bowdao.updateBorrower(bow);
			conn.commit();
			bowdao.deleteBorrower(bow);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testUpdateBorrowerPhone() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		BorrowerDAO bowdao = new BorrowerDAO(conn);
		bow.setCardNum(543535);
		bow.setbName("Jim");
		bow.setbAddress("123 street");
		bow.setbPhone("1800");
		
		try {
			bowdao.deleteBorrower(bow);
			conn.commit();
			bowdao.addBorrower(bow);
			bow.setbPhone("1-800-000-0000");
			bowdao.updateBorrower(bow);
			conn.commit();
			bowdao.deleteBorrower(bow);
			conn.commit();
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
			bowdao.deleteBorrower(bow);
			conn.commit();
			bowdao.addBorrower(bow);
			conn.commit();
			bowdao.deleteBorrower(bow);
			conn.commit();
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
			bowdao.deleteBorrower(bow);
			conn.commit();
			bowdao.addBorrower(bow);
			conn.commit();
			assertEquals(22, bowdao.getAllBorrowers().size());
			bowdao.deleteBorrower(bow);
			conn.commit();
			assertEquals(21, bowdao.getAllBorrowers().size());
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void listBorrowers() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		BorrowerDAO bowdao = new BorrowerDAO(conn);
		
		List<Borrower> bows = bowdao.getAllBorrowers();
		for(Borrower bow : bows)
		{
			System.out.println(bow.toString());
		}
	}
//------------------BOOK COPIES------------------------------------------------
	@Test
	public void testAddBookCopies() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		BookCopiesDAO bcdao = new BookCopiesDAO(conn);
		BookDAO bdao = new BookDAO(conn);
		AuthorDAO adao = new AuthorDAO(conn);
		PublisherDAO pdao = new PublisherDAO(conn);
		LibraryBranchDAO lbdao = new LibraryBranchDAO(conn);
		
		a.setAuthorID(9542435);
		a.setAuthorName("John");
		
		p.setPublisherID(7992719);
		p.setPublisherName("Jim");
		p.setPublisherAddress("123 street");
		p.setPublisherPhone("1800");
		
		b.setBookID(178146812);
		b.setTitle("Test Book Title");
		b.setBookAuthorID(a);
		b.setBookPubID(p);		
		
		lb.setBranchID(8617345);
		lb.setBranchName("Test branch");
		lb.setBranchAddress("Test street");
		
		bc.setCopyBookID(b);
		bc.setCopyBranchID(lb);
		bc.setNumCopies(10);
		
		try {
			bcdao.deleteBookCopies(bc);
			lbdao.deleteLibraryBranch(lb);
			bdao.deleteBook(b);
			pdao.deletePublisher(p);
			adao.deleteAuthor(a);
			conn.commit();
			adao.addAuthor(a);
			pdao.addPublisher(p);
			bdao.addBook(b);
			lbdao.addLibraryBranch(lb);
			bcdao.addBookCopies(bc);
			conn.commit();
			bcdao.deleteBookCopies(bc);
			lbdao.deleteLibraryBranch(lb);
			bdao.deleteBook(b);
			pdao.deletePublisher(p);
			adao.deleteAuthor(a);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testUpdateBookCopies() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		BookCopiesDAO bcdao = new BookCopiesDAO(conn);
		BookDAO bdao = new BookDAO(conn);
		AuthorDAO adao = new AuthorDAO(conn);
		PublisherDAO pdao = new PublisherDAO(conn);
		LibraryBranchDAO lbdao = new LibraryBranchDAO(conn);
		
		a.setAuthorID(9542435);
		a.setAuthorName("John");
		
		p.setPublisherID(7992719);
		p.setPublisherName("Jim");
		p.setPublisherAddress("123 street");
		p.setPublisherPhone("1800");
		
		b.setBookID(178146812);
		b.setTitle("Test Book Title");
		b.setBookAuthorID(a);
		b.setBookPubID(p);		
		
		lb.setBranchID(8617345);
		lb.setBranchName("Test branch");
		lb.setBranchAddress("Test street");
		
		bc.setCopyBookID(b);
		bc.setCopyBranchID(lb);
		bc.setNumCopies(10);
		
		try {
			bcdao.deleteBookCopies(bc);
			lbdao.deleteLibraryBranch(lb);
			bdao.deleteBook(b);
			pdao.deletePublisher(p);
			adao.deleteAuthor(a);
			conn.commit();
			adao.addAuthor(a);
			pdao.addPublisher(p);
			bdao.addBook(b);
			lbdao.addLibraryBranch(lb);
			bcdao.addBookCopies(bc);
			bc.setNumCopies(15);
			bcdao.updateBookCopies(bc);
			conn.commit();
			bcdao.deleteBookCopies(bc);
			lbdao.deleteLibraryBranch(lb);
			bdao.deleteBook(b);
			pdao.deletePublisher(p);
			adao.deleteAuthor(a);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testDeleteBookCopies() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		BookCopiesDAO bcdao = new BookCopiesDAO(conn);
		BookDAO bdao = new BookDAO(conn);
		AuthorDAO adao = new AuthorDAO(conn);
		PublisherDAO pdao = new PublisherDAO(conn);
		LibraryBranchDAO lbdao = new LibraryBranchDAO(conn);
		
		a.setAuthorID(9542435);
		a.setAuthorName("John");
		
		p.setPublisherID(7992719);
		p.setPublisherName("Jim");
		p.setPublisherAddress("123 street");
		p.setPublisherPhone("1800");
		
		b.setBookID(178146812);
		b.setTitle("Test Book Title");
		b.setBookAuthorID(a);
		b.setBookPubID(p);		
		
		lb.setBranchID(8617345);
		lb.setBranchName("Test branch");
		lb.setBranchAddress("Test street");
		
		bc.setCopyBookID(b);
		bc.setCopyBranchID(lb);
		bc.setNumCopies(10);
		
		try {
			bcdao.deleteBookCopies(bc);
			lbdao.deleteLibraryBranch(lb);
			bdao.deleteBook(b);
			pdao.deletePublisher(p);
			adao.deleteAuthor(a);
			conn.commit();
			adao.addAuthor(a);
			pdao.addPublisher(p);
			bdao.addBook(b);
			lbdao.addLibraryBranch(lb);
			bcdao.addBookCopies(bc);
			conn.commit();
			bcdao.deleteBookCopies(bc);
			lbdao.deleteLibraryBranch(lb);
			bdao.deleteBook(b);
			pdao.deletePublisher(p);
			adao.deleteAuthor(a);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testGetAllBookCopies() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		BookCopiesDAO bcdao = new BookCopiesDAO(conn);
		BookDAO bdao = new BookDAO(conn);
		AuthorDAO adao = new AuthorDAO(conn);
		PublisherDAO pdao = new PublisherDAO(conn);
		LibraryBranchDAO lbdao = new LibraryBranchDAO(conn);
		
		a.setAuthorID(9542435);
		a.setAuthorName("John");
		
		p.setPublisherID(7992719);
		p.setPublisherName("Jim");
		p.setPublisherAddress("123 street");
		p.setPublisherPhone("1800");
		
		b.setBookID(178146812);
		b.setTitle("Test Book Title");
		b.setBookAuthorID(a);
		b.setBookPubID(p);		
		
		lb.setBranchID(8617345);
		lb.setBranchName("Test branch");
		lb.setBranchAddress("Test street");
		
		bc.setCopyBookID(b);
		bc.setCopyBranchID(lb);
		bc.setNumCopies(10);
		
		try {
			bcdao.deleteBookCopies(bc);
			lbdao.deleteLibraryBranch(lb);
			bdao.deleteBook(b);
			pdao.deletePublisher(p);
			adao.deleteAuthor(a);
			conn.commit();
			adao.addAuthor(a);
			pdao.addPublisher(p);
			bdao.addBook(b);
			lbdao.addLibraryBranch(lb);
			bcdao.addBookCopies(bc);
			conn.commit();
			assertEquals(53, bcdao.getAllBookCopies().size());
			bcdao.deleteBookCopies(bc);
			lbdao.deleteLibraryBranch(lb);
			bdao.deleteBook(b);
			pdao.deletePublisher(p);
			adao.deleteAuthor(a);
			conn.commit();
			assertEquals(52, bcdao.getAllBookCopies().size());
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void listCopies() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		BookCopiesDAO bcdao = new BookCopiesDAO(conn);
		
		List<BookCopies> copies = bcdao.getAllBookCopies();
		for(BookCopies bc : copies)
		{
			System.out.println(bc.toString());
		}
	}

//---------------------------------BOOK LOANS-----------------------------------------------------
	@Test
	public void testAddBookLoans() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		BookLoansDAO bldao = new BookLoansDAO(conn);
		BookDAO bdao = new BookDAO(conn);
		AuthorDAO adao = new AuthorDAO(conn);
		PublisherDAO pdao = new PublisherDAO(conn);
		LibraryBranchDAO lbdao = new LibraryBranchDAO(conn);
		BorrowerDAO bowdao = new BorrowerDAO(conn);
		
		bow.setCardNum(543534);
		bow.setbName("Jim");
		bow.setbAddress("123 street");
		bow.setbPhone("1800");
		
		a.setAuthorID(9542435);
		a.setAuthorName("John");
		
		p.setPublisherID(7992719);
		p.setPublisherName("Jim");
		p.setPublisherAddress("123 street");
		p.setPublisherPhone("1800");
		
		b.setBookID(178146812);
		b.setTitle("Test Book Title");
		b.setBookAuthorID(a);
		b.setBookPubID(p);		
		
		lb.setBranchID(8617345);
		lb.setBranchName("Test branch");
		lb.setBranchAddress("Test street");
		
		bl.setLoanBookID(b);
		bl.setLoanBranchID(lb);
		bl.setLoanCardNum(bow);
		bl.setDateOut("2021-05-08");
		bl.setDueDate("2021-05-15");
		
		try {
			bldao.deleteBookLoanBookCard(bl);
			bowdao.deleteBorrower(bow);
			lbdao.deleteLibraryBranch(lb);
			bdao.deleteBook(b);
			pdao.deletePublisher(p);
			adao.deleteAuthor(a);
			conn.commit();
			
			bowdao.addBorrower(bow);
			adao.addAuthor(a);
			pdao.addPublisher(p);
			bdao.addBook(b);
			lbdao.addLibraryBranch(lb);
			bldao.addBookLoans(bl);
			conn.commit();
		
			bldao.deleteBookLoans(bl);
			bowdao.deleteBorrower(bow);
			lbdao.deleteLibraryBranch(lb);
			bdao.deleteBook(b);
			pdao.deletePublisher(p);
			adao.deleteAuthor(a);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testUpdateBookLoans() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		BookLoansDAO bldao = new BookLoansDAO(conn);
		BookDAO bdao = new BookDAO(conn);
		AuthorDAO adao = new AuthorDAO(conn);
		PublisherDAO pdao = new PublisherDAO(conn);
		LibraryBranchDAO lbdao = new LibraryBranchDAO(conn);
		BorrowerDAO bowdao = new BorrowerDAO(conn);
		
		bow.setCardNum(543534);
		bow.setbName("Jim");
		bow.setbAddress("123 street");
		bow.setbPhone("1800");
		
		a.setAuthorID(9542435);
		a.setAuthorName("John");
		
		p.setPublisherID(7992719);
		p.setPublisherName("Jim");
		p.setPublisherAddress("123 street");
		p.setPublisherPhone("1800");
		
		b.setBookID(178146812);
		b.setTitle("Test Book Title");
		b.setBookAuthorID(a);
		b.setBookPubID(p);		
		
		lb.setBranchID(8617345);
		lb.setBranchName("Test branch");
		lb.setBranchAddress("Test street");
		
		bl.setLoanBookID(b);
		bl.setLoanBranchID(lb);
		bl.setLoanCardNum(bow);
		bl.setDateOut("2021-05-08");
		bl.setDueDate("2021-05-15");
		
		try {
			bldao.deleteBookLoanBookCard(bl);
			bowdao.deleteBorrower(bow);
			lbdao.deleteLibraryBranch(lb);
			bdao.deleteBook(b);
			pdao.deletePublisher(p);
			adao.deleteAuthor(a);
			conn.commit();
			
			bowdao.addBorrower(bow);
			adao.addAuthor(a);
			pdao.addPublisher(p);
			bdao.addBook(b);
			lbdao.addLibraryBranch(lb);
			bldao.addBookLoans(bl);
			conn.commit();
			
			bl.setDueDate("2021-05-18");
			bldao.updateBookLoans(bl);
			conn.commit();
		
			bldao.deleteBookLoans(bl);
			bowdao.deleteBorrower(bow);
			lbdao.deleteLibraryBranch(lb);
			bdao.deleteBook(b);
			pdao.deletePublisher(p);
			adao.deleteAuthor(a);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testUpdateBookLoansOut() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		BookLoansDAO bldao = new BookLoansDAO(conn);
		BookDAO bdao = new BookDAO(conn);
		AuthorDAO adao = new AuthorDAO(conn);
		PublisherDAO pdao = new PublisherDAO(conn);
		LibraryBranchDAO lbdao = new LibraryBranchDAO(conn);
		BorrowerDAO bowdao = new BorrowerDAO(conn);
		
		bow.setCardNum(543534);
		bow.setbName("Jim");
		bow.setbAddress("123 street");
		bow.setbPhone("1800");
		
		a.setAuthorID(9542435);
		a.setAuthorName("John");
		
		p.setPublisherID(7992719);
		p.setPublisherName("Jim");
		p.setPublisherAddress("123 street");
		p.setPublisherPhone("1800");
		
		b.setBookID(178146812);
		b.setTitle("Test Book Title");
		b.setBookAuthorID(a);
		b.setBookPubID(p);		
		
		lb.setBranchID(8617345);
		lb.setBranchName("Test branch");
		lb.setBranchAddress("Test street");
		
		bl.setLoanBookID(b);
		bl.setLoanBranchID(lb);
		bl.setLoanCardNum(bow);
		bl.setDateOut("2021-05-08");
		bl.setDueDate("2021-05-15");
		
		try {
			bldao.deleteBookLoanBookCard(bl);
			bowdao.deleteBorrower(bow);
			lbdao.deleteLibraryBranch(lb);
			bdao.deleteBook(b);
			pdao.deletePublisher(p);
			adao.deleteAuthor(a);
			conn.commit();
			
			bowdao.addBorrower(bow);
			adao.addAuthor(a);
			pdao.addPublisher(p);
			bdao.addBook(b);
			lbdao.addLibraryBranch(lb);
			bldao.addBookLoans(bl);
			conn.commit();
			
			bl.setDateOut("2021-05-18");
			bldao.updateBookLoans(bl);
			conn.commit();
		
			bldao.deleteBookLoans(bl);
			bowdao.deleteBorrower(bow);
			lbdao.deleteLibraryBranch(lb);
			bdao.deleteBook(b);
			pdao.deletePublisher(p);
			adao.deleteAuthor(a);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testUpdateBookLoansDue() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		BookLoansDAO bldao = new BookLoansDAO(conn);
		BookDAO bdao = new BookDAO(conn);
		AuthorDAO adao = new AuthorDAO(conn);
		PublisherDAO pdao = new PublisherDAO(conn);
		LibraryBranchDAO lbdao = new LibraryBranchDAO(conn);
		BorrowerDAO bowdao = new BorrowerDAO(conn);
		
		bow.setCardNum(543534);
		bow.setbName("Jim");
		bow.setbAddress("123 street");
		bow.setbPhone("1800");
		
		a.setAuthorID(9542435);
		a.setAuthorName("John");
		
		p.setPublisherID(7992719);
		p.setPublisherName("Jim");
		p.setPublisherAddress("123 street");
		p.setPublisherPhone("1800");
		
		b.setBookID(178146812);
		b.setTitle("Test Book Title");
		b.setBookAuthorID(a);
		b.setBookPubID(p);		
		
		lb.setBranchID(8617345);
		lb.setBranchName("Test branch");
		lb.setBranchAddress("Test street");
		
		bl.setLoanBookID(b);
		bl.setLoanBranchID(lb);
		bl.setLoanCardNum(bow);
		bl.setDateOut("2021-05-08");
		bl.setDueDate("2021-05-15");
		
		try {
			bldao.deleteBookLoanBookCard(bl);
			bowdao.deleteBorrower(bow);
			lbdao.deleteLibraryBranch(lb);
			bdao.deleteBook(b);
			pdao.deletePublisher(p);
			adao.deleteAuthor(a);
			conn.commit();
			
			bowdao.addBorrower(bow);
			adao.addAuthor(a);
			pdao.addPublisher(p);
			bdao.addBook(b);
			lbdao.addLibraryBranch(lb);
			bldao.addBookLoans(bl);
			conn.commit();
			
			bl.setDueDate("2021-05-18");
			bldao.updateBookLoans(bl);
			conn.commit();
		
			bldao.deleteBookLoans(bl);
			bowdao.deleteBorrower(bow);
			lbdao.deleteLibraryBranch(lb);
			bdao.deleteBook(b);
			pdao.deletePublisher(p);
			adao.deleteAuthor(a);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testDeleteBookLoans() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		BookLoansDAO bldao = new BookLoansDAO(conn);
		BookDAO bdao = new BookDAO(conn);
		AuthorDAO adao = new AuthorDAO(conn);
		PublisherDAO pdao = new PublisherDAO(conn);
		LibraryBranchDAO lbdao = new LibraryBranchDAO(conn);
		BorrowerDAO bowdao = new BorrowerDAO(conn);
		
		bow.setCardNum(543534);
		bow.setbName("Jim");
		bow.setbAddress("123 street");
		bow.setbPhone("1800");
		
		a.setAuthorID(9542435);
		a.setAuthorName("John");
		
		p.setPublisherID(7992719);
		p.setPublisherName("Jim");
		p.setPublisherAddress("123 street");
		p.setPublisherPhone("1800");
		
		b.setBookID(178146812);
		b.setTitle("Test Book Title");
		b.setBookAuthorID(a);
		b.setBookPubID(p);		
		
		lb.setBranchID(8617345);
		lb.setBranchName("Test branch");
		lb.setBranchAddress("Test street");
		
		bl.setLoanBookID(b);
		bl.setLoanBranchID(lb);
		bl.setLoanCardNum(bow);
		bl.setDateOut("2021-05-08");
		bl.setDueDate("2021-05-15");
		
		try {
			bldao.deleteBookLoanBookCard(bl);
			bowdao.deleteBorrower(bow);
			lbdao.deleteLibraryBranch(lb);
			bdao.deleteBook(b);
			pdao.deletePublisher(p);
			adao.deleteAuthor(a);
			conn.commit();
			
			bowdao.addBorrower(bow);
			adao.addAuthor(a);
			pdao.addPublisher(p);
			bdao.addBook(b);
			lbdao.addLibraryBranch(lb);
			bldao.addBookLoans(bl);
			conn.commit();
		
			bldao.deleteBookLoans(bl);
			bowdao.deleteBorrower(bow);
			lbdao.deleteLibraryBranch(lb);
			bdao.deleteBook(b);
			pdao.deletePublisher(p);
			adao.deleteAuthor(a);
			conn.commit();
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testGetAllBookLoans() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		BookLoansDAO bldao = new BookLoansDAO(conn);
		BookDAO bdao = new BookDAO(conn);
		AuthorDAO adao = new AuthorDAO(conn);
		PublisherDAO pdao = new PublisherDAO(conn);
		LibraryBranchDAO lbdao = new LibraryBranchDAO(conn);
		BorrowerDAO bowdao = new BorrowerDAO(conn);
		
		bow.setCardNum(543534);
		bow.setbName("Jim");
		bow.setbAddress("123 street");
		bow.setbPhone("1800");
		
		a.setAuthorID(9542435);
		a.setAuthorName("John");
		
		p.setPublisherID(7992719);
		p.setPublisherName("Jim");
		p.setPublisherAddress("123 street");
		p.setPublisherPhone("1800");
		
		b.setBookID(178146812);
		b.setTitle("Test Book Title");
		b.setBookAuthorID(a);
		b.setBookPubID(p);		
		
		lb.setBranchID(8617345);
		lb.setBranchName("Test branch");
		lb.setBranchAddress("Test street");
		
		bl.setLoanBookID(b);
		bl.setLoanBranchID(lb);
		bl.setLoanCardNum(bow);
		bl.setDateOut("2021-05-08");
		bl.setDueDate("2021-05-15");
		
		try {
			bldao.deleteBookLoanBookCard(bl);
			bowdao.deleteBorrower(bow);
			lbdao.deleteLibraryBranch(lb);
			bdao.deleteBook(b);
			pdao.deletePublisher(p);
			adao.deleteAuthor(a);
			conn.commit();
			
			bowdao.addBorrower(bow);
			adao.addAuthor(a);
			pdao.addPublisher(p);
			bdao.addBook(b);
			lbdao.addLibraryBranch(lb);
			bldao.addBookLoans(bl);
			conn.commit();
			assertEquals(21, bldao.getAllBookLoans().size());
		
			bldao.deleteBookLoans(bl);
			bowdao.deleteBorrower(bow);
			lbdao.deleteLibraryBranch(lb);
			bdao.deleteBook(b);
			pdao.deletePublisher(p);
			adao.deleteAuthor(a);
			conn.commit();
			assertEquals(20, bldao.getAllBookLoans().size());
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void listLoans() throws ClassNotFoundException, SQLException
	{
		conn = connUtil.getConnection();
		BookLoansDAO loandao = new BookLoansDAO(conn);
		
		List<BookLoans> loans = loandao.getAllBookLoans();
		for(BookLoans l : loans)
		{
			System.out.println(l.toString());
		}
	}
	
}
