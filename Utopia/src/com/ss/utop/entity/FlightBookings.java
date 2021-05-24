package com.ss.utop.entity;

public class FlightBookings {
	private Flight flightBookingId = new Flight();
	private Booking bookingId = new Booking();
	
	public Flight getFlightBookingId() {
		return flightBookingId;
	}
	public void setFlightBookingId(Flight flightBookingId) {
		this.flightBookingId = flightBookingId;
	}
	public Booking getBookingId() {
		return bookingId;
	}
	public void setBookingId(Booking bookingId) {
		this.bookingId = bookingId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookingId == null) ? 0 : bookingId.hashCode());
		result = prime * result + ((flightBookingId == null) ? 0 : flightBookingId.hashCode());
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
		FlightBookings other = (FlightBookings) obj;
		if (bookingId == null) {
			if (other.bookingId != null)
				return false;
		} else if (!bookingId.equals(other.bookingId))
			return false;
		if (flightBookingId == null) {
			if (other.flightBookingId != null)
				return false;
		} else if (!flightBookingId.equals(other.flightBookingId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "flightBookingId= " + flightBookingId.getFlightId() + ", bookingId= " + bookingId.getId();
	}
}
