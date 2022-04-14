package rsa.shared;

import rsa.service.Matcher.RideMatch;
import rsa.service.Ride;

public class RideMatchInfo extends java.lang.Object{
	long id;
	Ride driver_ride;
	Ride passenger_ride;
	public RideMatchInfo(RideMatch match) {
		this.id = match.getId();
		this.driver_ride = match.getRide(RideRole.DRIVER);
		this.passenger_ride = match.getRide(RideRole.PASSENGER);
	}
	
	public long getMatchId() {return id;};
	
	public java.lang.String getName(RideRole role){
		if(role.equals(RideRole.DRIVER)) {
			return driver_ride.getUser().getName();
		}
		else {
			return passenger_ride.getUser().getName();
		}
	}
	
	public float getStars(RideRole role) {
		if(role.equals(RideRole.DRIVER)) {
			return driver_ride.getUser().getAverage(RideRole.DRIVER);
		}
		else {
			return passenger_ride.getUser().getAverage(RideRole.PASSENGER);
		}
	}
	
	public Location getWhere(RideRole role) {
		if(role.equals(RideRole.DRIVER)) {
			return driver_ride.getCurrent();
		}
		else {
			return passenger_ride.getCurrent();
		}
	}
	
	public Car getCar() {
		return driver_ride.getUser().getCar(driver_ride.getPlate());
	}
	
	public float getCost() {
		return driver_ride.getCost();
	}
}
