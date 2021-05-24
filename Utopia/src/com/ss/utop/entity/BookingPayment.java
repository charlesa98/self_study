package com.ss.utop.entity;

public class BookingPayment {
	private Booking bookingPaymentId = new Booking();
	private String stripe;
	private Integer refund;		//tiny int
	
	public Booking getBookingPaymentId() {
		return bookingPaymentId;
	}
	public void setBookingPaymentId(Booking bookingPaymentId) {
		this.bookingPaymentId = bookingPaymentId;
	}
	public String getStripe() {
		return stripe;
	}
	public void setStripe(String stripe) {
		this.stripe = stripe;
	}
	public Integer getRefund() {
		return refund;
	}
	public void setRefund(Integer refund) {
		this.refund = refund;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookingPaymentId == null) ? 0 : bookingPaymentId.hashCode());
		result = prime * result + ((refund == null) ? 0 : refund.hashCode());
		result = prime * result + ((stripe == null) ? 0 : stripe.hashCode());
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
		BookingPayment other = (BookingPayment) obj;
		if (bookingPaymentId == null) {
			if (other.bookingPaymentId != null)
				return false;
		} else if (!bookingPaymentId.equals(other.bookingPaymentId))
			return false;
		if (refund == null) {
			if (other.refund != null)
				return false;
		} else if (!refund.equals(other.refund))
			return false;
		if (stripe == null) {
			if (other.stripe != null)
				return false;
		} else if (!stripe.equals(other.stripe))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "bookingPaymentId= " + bookingPaymentId.getId() + ", stripe= " + stripe + ", refund= " + refund;
	}
}
