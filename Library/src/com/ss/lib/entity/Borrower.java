package com.ss.lib.entity;

public class Borrower {
	private Integer cardNum;
	private String bName;
	private String bAddress;
	private String bPhone;
	
	@Override
	public String toString() {
		return "cardNum= " + cardNum + ", bName= " + bName + ", bAddress= " + bAddress + ", bPhone= " + bPhone;
	}
	
	public Integer getCardNum() {
		return cardNum;
	}
	public void setCardNum(Integer cardNum) {
		this.cardNum = cardNum;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getbAddress() {
		return bAddress;
	}
	public void setbAddress(String bAddress) {
		this.bAddress = bAddress;
	}
	public String getbPhone() {
		return bPhone;
	}
	public void setbPhone(String bPhone) {
		this.bPhone = bPhone;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bAddress == null) ? 0 : bAddress.hashCode());
		result = prime * result + ((bName == null) ? 0 : bName.hashCode());
		result = prime * result + ((bPhone == null) ? 0 : bPhone.hashCode());
		result = prime * result + ((cardNum == null) ? 0 : cardNum.hashCode());
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
		Borrower other = (Borrower) obj;
		if (bAddress == null) {
			if (other.bAddress != null)
				return false;
		} else if (!bAddress.equals(other.bAddress))
			return false;
		if (bName == null) {
			if (other.bName != null)
				return false;
		} else if (!bName.equals(other.bName))
			return false;
		if (bPhone == null) {
			if (other.bPhone != null)
				return false;
		} else if (!bPhone.equals(other.bPhone))
			return false;
		if (cardNum == null) {
			if (other.cardNum != null)
				return false;
		} else if (!cardNum.equals(other.cardNum))
			return false;
		return true;
	}
}
