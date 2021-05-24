package com.ss.utop.entity;

public class BookingUser {
	private Booking bookingUserId = new Booking();
	private Integer userId;
	
	public Booking getBookingUserId() {
		return bookingUserId;
	}
	public void setBookingUserId(Booking bookingUserId) {
		this.bookingUserId = bookingUserId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookingUserId == null) ? 0 : bookingUserId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		BookingUser other = (BookingUser) obj;
		if (bookingUserId == null) {
			if (other.bookingUserId != null)
				return false;
		} else if (!bookingUserId.equals(other.bookingUserId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "bookingUserId= " + bookingUserId.getId() + ", userId= " + userId;
	}
}
