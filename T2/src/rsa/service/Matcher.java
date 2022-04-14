package rsa.service;

import java.util.LinkedList;

import rsa.shared.Location;
import rsa.shared.RideRole;

public class Matcher implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	static Location bottomRight;
	static Location topLeft;
	static double radius;
	private static long counter=0;
	
	public Matcher() {};
	
	public static Location getBottomRight() {
		return bottomRight;
	}
	public static void setBottomRight(Location bottomRight) {
		Matcher.bottomRight = bottomRight;
	}
	public static Location getTopLeft() {
		return topLeft;
	}
	public static void setTopLeft(Location topLeft) {
		Matcher.topLeft = topLeft;
	}
	public static double getRadius() {
		return radius;
	}
	public static void setRadius(double radius) {
		Matcher.radius = radius;
	}
	
	public class RideMatch {
		long id;
		LinkedList<Ride> rides;
		
		public RideMatch(Ride left,Ride right) {
			rides = new LinkedList<Ride>();
			counter++;
			this.id=counter;
			rides.add(left);
			rides.add(right);
		}
		
		public long getId() {return id;}
		
		public Ride getRide(RideRole role) {
			Ride selected_ride = null;
			for(Ride ride:rides) {
				if(ride.getRideRole().equals(role)) {
					selected_ride = ride;
				}
			}
			return selected_ride;
		}
		
		public boolean matchable() {
			Ride r1 = rides.get(0);
			Ride r2 = rides.get(1);
			if(!r1.isMatched() && !r2.isMatched()) {
				if(!r1.getRideRole().equals(r2.getRideRole())) {
					if(r1.current.getDistance(r2.current.getX(), r2.current.getY()) <= Matcher.getRadius()){
						if(r1.to.getDistance(r2.to.getX(), r2.to.getY()) <= Matcher.getRadius()) {
							return true;
						}
					}
				}
			}
			return false;
		}
	}
}
