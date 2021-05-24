package com.ss.utop.entity;

public class Airplane {
	private Integer apId;
	private AirplaneType aptype = new AirplaneType();

	public Integer getAPId() {
		return apId;
	}
	public void setAPId(Integer aptypeId) {
		this.apId = aptypeId;
	}
	public AirplaneType getType() {
		return aptype;
	}
	public void setType(AirplaneType aptype) {
		this.aptype = aptype;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apId == null) ? 0 : apId.hashCode());
		result = prime * result + ((aptype == null) ? 0 : aptype.hashCode());
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
		Airplane other = (Airplane) obj;
		if (apId == null) {
			if (other.apId != null)
				return false;
		} else if (!apId.equals(other.apId))
			return false;
		if (aptype == null) {
			if (other.aptype != null)
				return false;
		} else if (!aptype.equals(other.aptype))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "apId= " + apId + ", aptype= " + aptype.getId();
	}	
}
