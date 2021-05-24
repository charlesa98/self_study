package com.ss.utop.entity;

public class Flight {
	private Integer flightId;
	private Route routeId = new Route();
	private Airplane airplaneId = new Airplane();
	private String departTime;
	private Integer resSeats;
	private Float price;
	
	public Integer getFlightId() {
		return flightId;
	}
	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}
	public Route getRouteId() {
		return routeId;
	}
	public void setRouteId(Route routeId) {
		this.routeId = routeId;
	}
	public Airplane getAirplaneId() {
		return airplaneId;
	}
	public void setAirplaneId(Airplane airplaneId) {
		this.airplaneId = airplaneId;
	}
	public String getDepartTime() {
		return departTime;
	}
	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}
	public Integer getResSeats() {
		return resSeats;
	}
	public void setResSeats(Integer resSeats) {
		this.resSeats = resSeats;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airplaneId == null) ? 0 : airplaneId.hashCode());
		result = prime * result + ((departTime == null) ? 0 : departTime.hashCode());
		result = prime * result + ((flightId == null) ? 0 : flightId.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((resSeats == null) ? 0 : resSeats.hashCode());
		result = prime * result + ((routeId == null) ? 0 : routeId.hashCode());
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
		Flight other = (Flight) obj;
		if (airplaneId == null) {
			if (other.airplaneId != null)
				return false;
		} else if (!airplaneId.equals(other.airplaneId))
			return false;
		if (departTime == null) {
			if (other.departTime != null)
				return false;
		} else if (!departTime.equals(other.departTime))
			return false;
		if (flightId == null) {
			if (other.flightId != null)
				return false;
		} else if (!flightId.equals(other.flightId))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (resSeats == null) {
			if (other.resSeats != null)
				return false;
		} else if (!resSeats.equals(other.resSeats))
			return false;
		if (routeId == null) {
			if (other.routeId != null)
				return false;
		} else if (!routeId.equals(other.routeId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "flightId= " + flightId + ", routeId= " + routeId.getId() + ", airplaneId= " + airplaneId.getAPId() + ", departTime= "
				+ departTime + ", resSeats= " + resSeats + ", price= " + price;
	}
}
