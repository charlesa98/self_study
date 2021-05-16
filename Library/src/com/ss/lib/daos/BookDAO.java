package com.ss.lib.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.lib.entity.Book;
import com.ss.lib.entity.BookCopies;

public class BookDAO extends BaseDAO<Book>{

	public BookDAO(Connection conn) {
		super(conn);
	}

	public Integer addBook(Book book) throws ClassNotFoundException, SQLException
	{
		return saveWithPK("INSERT INTO tbl_book (bookId, title, authId, pubId) VALUES (?, ?, ?, ?)",
				new Object[] {book.getBookID(), book.getTitle(), book.getBookAuthorID().getAuthorID(), book.getBookPubID().getPublisherID()});
	}
	
	public void updateBook(Book book) throws ClassNotFoundException, SQLException
	{
		save("UPDATE tbl_book set title = ?, authId = ?, pubId = ? where bookId = ?", 
				new Object[] {book.getTitle(), book.getBookAuthorID().getAuthorID(), book.getBookPubID().getPublisherID(), book.getBookID()});
	}
	
	public void updateBookTitle(Book book) throws ClassNotFoundException, SQLException
	{
		save("UPDATE tbl_book set title = ? where bookId = ?", 
				new Object[] {book.getTitle(), book.getBookID()});
	}
	
	public void updateBookAuthor(Book book) throws ClassNotFoundException, SQLException
	{
		save("UPDATE tbl_book set authId = ? where bookId = ?", 
				new Object[] {book.getBookAuthorID().getAuthorID(), book.getBookID()});
	}
	
	public void updateBookPub(Book book) throws ClassNotFoundException, SQLException
	{
		save("UPDATE tbl_book set pubId = ? where bookId = ?", 
				new Object[] {book.getBookPubID().getPublisherID(), book.getBookID()});
	}
	
	public void deleteBook(Book book) throws ClassNotFoundException, SQLException
	{
		save("DELETE FROM tbl_book where bookId = ?", new Object[] {book.getBookID()});
	}
	
	public void deleteBookAuthor(Book book)throws ClassNotFoundException, SQLException					//for when the author is deleted
	{
		save("DELETE FROM tbl_book where authId = ?", new Object[] {book.getBookAuthorID().getAuthorID()});
	}
	
	public void deleteBookPublisher(Book book)throws ClassNotFoundException, SQLException				//for when the publisher is deleted
	{
		save("DELETE FROM tbl_book where pubId = ?", new Object[] {book.getBookPubID().getPublisherID()});
	}
	
	public List<Book> getAllBooks() throws ClassNotFoundException, SQLException
	{
		return read("select * from tbl_book", null);
		
	}
	
	public List<Book> getAllBookID(BookCopies book) throws ClassNotFoundException, SQLException
	{
		return read("select title from tbl_book where bookId = ?", new Object[] {book.getCopyBookID().getBookID()});	
	}
	
	@Override
	public List<Book> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Book> books = new ArrayList<>();
		
		while(rs.next())
		{
			Book book = new Book();
			book.setBookID(rs.getInt("bookId"));
			book.setTitle(rs.getString("title"));
			book.getBookAuthorID().setAuthorID(rs.getInt("authId"));
			book.getBookPubID().setPublisherID(rs.getInt("pubId"));
			books.add(book);
		}
		return books;
	}
}
