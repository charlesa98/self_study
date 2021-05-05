package com.ss.lib.entity;

public class BookLoans {
	@Override
	public String toString() {
		return "loanBookID= " + loanBookID + ", loanBranchID= " + loanBranchID + ", loanCardNum= " + loanCardNum
				+ ", dateOut= " + dateOut + ", dueDate= " + dueDate;
	}
	private Book loanBookID = new Book();
	private LibraryBranch loanBranchID = new LibraryBranch();
	private Borrower loanCardNum = new Borrower();
	private String dateOut;
	private String dueDate;
	
	public Book getLoanBookID() {
		return loanBookID;
	}
	public void setLoanBookID(Book loanBookID) {
		this.loanBookID = loanBookID;
	}
	public LibraryBranch getLoanBranchID() {
		return loanBranchID;
	}
	public void setLoanBranchID(LibraryBranch loanBranchID) {
		this.loanBranchID = loanBranchID;
	}
	public Borrower getLoanCardNum() {
		return loanCardNum;
	}
	public void setLoanCardNum(Borrower loanCardNum) {
		this.loanCardNum = loanCardNum;
	}
	public String getDateOut() {
		return dateOut;
	}
	public void setDateOut(String dateOut) {
		this.dateOut = dateOut;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOut == null) ? 0 : dateOut.hashCode());
		result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
		result = prime * result + ((loanBookID == null) ? 0 : loanBookID.hashCode());
		result = prime * result + ((loanBranchID == null) ? 0 : loanBranchID.hashCode());
		result = prime * result + ((loanCardNum == null) ? 0 : loanCardNum.hashCode());
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
		BookLoans other = (BookLoans) obj;
		if (dateOut == null) {
			if (other.dateOut != null)
				return false;
		} else if (!dateOut.equals(other.dateOut))
			return false;
		if (dueDate == null) {
			if (other.dueDate != null)
				return false;
		} else if (!dueDate.equals(other.dueDate))
			return false;
		if (loanBookID == null) {
			if (other.loanBookID != null)
				return false;
		} else if (!loanBookID.equals(other.loanBookID))
			return false;
		if (loanBranchID == null) {
			if (other.loanBranchID != null)
				return false;
		} else if (!loanBranchID.equals(other.loanBranchID))
			return false;
		if (loanCardNum == null) {
			if (other.loanCardNum != null)
				return false;
		} else if (!loanCardNum.equals(other.loanCardNum))
			return false;
		return true;
	}
}
