package com.ss.utop.entity;

public class Route {
	private Integer id;
	private Airport orgAirport = new Airport();			//need this for 1 route for 1 airport while
	private Airport desAirport = new Airport();			//airports have 1 airport with many routes
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Airport getOrgAirport() {
		return orgAirport;
	}
	public void setOrgAirport(Airport orgAirport) {
		this.orgAirport = orgAirport;
	}
	public Airport getDesAirport() {
		return desAirport;
	}
	public void setDesAirport(Airport desAirport) {
		this.desAirport = desAirport;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desAirport == null) ? 0 : desAirport.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((orgAirport == null) ? 0 : orgAirport.hashCode());
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
		Route other = (Route) obj;
		if (desAirport == null) {
			if (other.desAirport != null)
				return false;
		} else if (!desAirport.equals(other.desAirport))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (orgAirport == null) {
			if (other.orgAirport != null)
				return false;
		} else if (!orgAirport.equals(other.orgAirport))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "id= " + id + ", orgAirport= " + orgAirport.getAirportCode() + ", desAirport= " + desAirport.getAirportCode();
	}
}
