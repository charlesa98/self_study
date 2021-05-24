package com.ss.utop.entity;

public class Passenger {
	private Integer passId;
	private Booking bookingID = new Booking();
	private String fName;
	private String lName;
	private String dob;
	private String gender;
	private String address;
	
	public Integer getPassId() {
		return passId;
	}
	public void setPassId(Integer passsId) {
		this.passId = passsId;
	}
	public Booking getBookingID() {
		return bookingID;
	}
	public void setBookingID(Booking bookingID) {
		this.bookingID = bookingID;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((bookingID == null) ? 0 : bookingID.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((fName == null) ? 0 : fName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((lName == null) ? 0 : lName.hashCode());
		result = prime * result + ((passId == null) ? 0 : passId.hashCode());
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
		Passenger other = (Passenger) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (bookingID == null) {
			if (other.bookingID != null)
				return false;
		} else if (!bookingID.equals(other.bookingID))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (fName == null) {
			if (other.fName != null)
				return false;
		} else if (!fName.equals(other.fName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (lName == null) {
			if (other.lName != null)
				return false;
		} else if (!lName.equals(other.lName))
			return false;
		if (passId == null) {
			if (other.passId != null)
				return false;
		} else if (!passId.equals(other.passId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "passId= " + passId + ", bookingID= " + bookingID.getId() + ", fName= " + fName + ", lName= " + lName
				+ ", dob= " + dob + ", gender= " + gender + ", address= " + address;
	}
}
