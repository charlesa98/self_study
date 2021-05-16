package com.ss.lib.entity;

public class Book {
	private Integer bookID;
	private String title;
	private Author bookAuthorID = new Author();
	private Publisher bookPubID = new Publisher();
	
	@Override
	public String toString() {
		return "bookID= " + bookID + ", title= " + title + ", bookAuthorID= " + bookAuthorID.getAuthorID() + ", bookPubID= "+ bookPubID.getPublisherID();
	}
	
	public Publisher getBookPubID() {
		return bookPubID;
	}
	public void setBookPubID(Publisher bookPubID) {
		this.bookPubID = bookPubID;
	}
	public Integer getBookID() {
		return bookID;
	}
	public void setBookID(Integer bookID) {
		this.bookID = bookID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Author getBookAuthorID() {
		return bookAuthorID;
	}
	public void setBookAuthorID(Author bookAuthorID) {
		this.bookAuthorID = bookAuthorID;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookAuthorID == null) ? 0 : bookAuthorID.hashCode());
		result = prime * result + ((bookID == null) ? 0 : bookID.hashCode());
		result = prime * result + ((bookPubID == null) ? 0 : bookPubID.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (bookAuthorID == null) {
			if (other.bookAuthorID != null)
				return false;
		} else if (!bookAuthorID.equals(other.bookAuthorID))
			return false;
		if (bookID == null) {
			if (other.bookID != null)
				return false;
		} else if (!bookID.equals(other.bookID))
			return false;
		if (bookPubID == null) {
			if (other.bookPubID != null)
				return false;
		} else if (!bookPubID.equals(other.bookPubID))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
}
