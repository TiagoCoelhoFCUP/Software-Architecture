package rsa.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

import rsa.service.Ride;

/**
 * The info of a match between 2 rides (driver and passenger).
 * Data Access Object that provides information on current ride matches to external components. 
 * @author Tiago Coelho e Vasco Soares;
 */

public class RideMatchInfo extends java.lang.Object implements IsSerializable{
	public long id;
	public Ride driver_ride;
	public Ride passenger_ride;
	
	/**
	 * Constructor based on a instance of the class Matcher.RideMatch.
	 * @param match, o Matcher.RideMatch de referência.
	 * @author Tiago Coelho e Vasco Soares;
	 */
	
	public RideMatchInfo() {};
	
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
