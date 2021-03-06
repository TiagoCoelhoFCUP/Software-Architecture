package rsa.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * A location given by a pair of coordinates (doubles).
 * @author Tiago Coelho e Vasco Soares;
 */

public class Location implements IsSerializable {
	double x;
	double y;
	
	public Location() {};
	
	public Location(double x,double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}


	public double getY() {
		return y;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Location other = (Location) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}
	public double getDistance(double x,double y) {
		return Math.hypot(this.x-x, this.y-y);
	}
}
