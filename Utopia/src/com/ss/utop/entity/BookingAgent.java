package com.ss.utop.entity;

public class BookingAgent {
	private Booking bookingAgentId = new Booking();			//booking id is the fk to booking agent
	private Integer agentId;
	
	public Booking getBookingAgentId() {
		return bookingAgentId;
	}
	public void setBookingAgentId(Booking bookingAgentId) {
		this.bookingAgentId = bookingAgentId;
	}
	public Integer getAgentId() {
		return agentId;
	}
	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agentId == null) ? 0 : agentId.hashCode());
		result = prime * result + ((bookingAgentId == null) ? 0 : bookingAgentId.hashCode());
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
		BookingAgent other = (BookingAgent) obj;
		if (agentId == null) {
			if (other.agentId != null)
				return false;
		} else if (!agentId.equals(other.agentId))
			return false;
		if (bookingAgentId == null) {
			if (other.bookingAgentId != null)
				return false;
		} else if (!bookingAgentId.equals(other.bookingAgentId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "bookingAgentId= " + bookingAgentId.getId() + ", agentId= " + agentId;
	}				
}
