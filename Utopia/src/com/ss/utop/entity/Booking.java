package com.ss.utop.entity;

public class Booking {
	private Integer id;
	private Integer active;			//tiny int?
	private String confermationCode;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
	public String getConfermationCode() {
		return confermationCode;
	}
	public void setConfermationCode(String confermationCode) {
		this.confermationCode = confermationCode;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((confermationCode == null) ? 0 : confermationCode.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Booking other = (Booking) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (confermationCode == null) {
			if (other.confermationCode != null)
				return false;
		} else if (!confermationCode.equals(other.confermationCode))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "id= " + id + ", active= " + active + ", confermationCode= " + confermationCode;
	}
}
