package rsa.shared;

/**
 * The role of the user in a ride.
 * @author Tiago Coelho e Vasco Soares;
 */

public enum RideRole implements java.io.Serializable {
	DRIVER,
	PASSENGER;
	
	String value;
	
	private RideRole() {
		value = this.toString();
	}
	
	public RideRole other() {
		if(value.equals("DRIVER"))
			return RideRole.PASSENGER;
		else
			return RideRole.DRIVER;
	}
}
