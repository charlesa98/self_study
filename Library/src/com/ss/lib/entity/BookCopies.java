package com.ss.lib.entity;

public class BookCopies {
	private Book copyBookID = new Book();
	private LibraryBranch copyBranchID = new LibraryBranch();
	private Integer numCopies;
	
	@Override
	public String toString() {
		return "copyBookID= " + copyBookID + ", copyBranchID= " + copyBranchID + ", numCopies= " + numCopies;
	}
	
	public Book getCopyBookID() {
		return copyBookID;
	}
	public void setCopyBookID(Book copyBookID) {
		this.copyBookID = copyBookID;
	}
	public LibraryBranch getCopyBranchID() {
		return copyBranchID;
	}
	public void setCopyBranchID(LibraryBranch copyBranchID) {
		this.copyBranchID = copyBranchID;
	}
	public Integer getNumCopies() {
		return numCopies;
	}
	public void setNumCopies(Integer numCopies) {
		this.numCopies = numCopies;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((copyBookID == null) ? 0 : copyBookID.hashCode());
		result = prime * result + ((copyBranchID == null) ? 0 : copyBranchID.hashCode());
		result = prime * result + ((numCopies == null) ? 0 : numCopies.hashCode());
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
		BookCopies other = (BookCopies) obj;
		if (copyBookID == null) {
			if (other.copyBookID != null)
				return false;
		} else if (!copyBookID.equals(other.copyBookID))
			return false;
		if (copyBranchID == null) {
			if (other.copyBranchID != null)
				return false;
		} else if (!copyBranchID.equals(other.copyBranchID))
			return false;
		if (numCopies == null) {
			if (other.numCopies != null)
				return false;
		} else if (!numCopies.equals(other.numCopies))
			return false;
		return true;
	}
}
