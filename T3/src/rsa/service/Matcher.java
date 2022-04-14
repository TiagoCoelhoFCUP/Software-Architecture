package rsa.service;

import java.util.LinkedList;

import java.util.SortedSet;
import java.util.TreeSet;

import rsa.shared.Location;
import rsa.shared.RideMatchInfo;
import rsa.shared.RideRole;
import rsa.shared.UserStars;

/**
 * An instance of this class will match pair of rides suitable for matching.
 * Matching occurs when rides positions are updated.
 * @author Tiago Coelho e Vasco Soares;
 */


public class Matcher implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	static Location bottomRight;
	static Location topLeft;
	static double radius;
	private static long counter=0;
	LinkedList<Ride> rides;
	LinkedList<RideMatch> matches;
	
	public Matcher() {
		rides = new LinkedList<Ride>();
		matches = new LinkedList<RideMatch>();
	}
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
	
	public long addRide(User user,Location from,Location to,String plate,float cost) {
		Ride r = new Ride(user,from,to,plate,cost);
		rides.add(r);
		return r.getId();
	}
	
	RideMatchInfo getRideMatchInfo(RideMatch match){
		RideMatchInfo rmi = new RideMatchInfo();
		rmi.id = match.getId();
		rmi.driver_ride = match.getRide(RideRole.DRIVER);
		rmi.passenger_ride = match.getRide(RideRole.PASSENGER);
		return rmi;
	}
	
	/**
	 * Accepts a proposed match.
	 * @param rideId, Ride's instance identifier.
	 * @param matchId, RideMatch's instance identifier.
	 * Selects match based on matchID and atributes that match to ride who's id is rideId.
	 * @author Tiago Coelho e Vasco Soares;
	 */
	public void acceptMatch(long rideId,long matchId) {
		RideMatch match = null;
		for(RideMatch rm : matches) {
			if(rm.getId() == matchId) {
				match = rm;
				break;
			}
		}
		for(Ride r : rides) {
			if(r.getId() == rideId) {
				r.setMatch(match);
			}
		}
	}
	
	/**
	 * @param rideId, Ride's instance identifier.
	 * @param stars, evaluation given to the other user.
	 * Selects ride based on rideId and ads user evaluation to the other user.
	 * Removes all possible matches stored for that ride and removes said ride.
	 * @author Tiago Coelho e Vasco Soares;
	 */
	
	public void concludeRide(long rideId,UserStars stars) {
		Ride ride = null;
		for(Ride r : rides) {
			if(r.getId() == rideId) {
				ride = r;
				RideRole role = r.getRideRole().other();
				RideMatch match = r.getMatch();
				Ride other = match.getRide(role);
				other.getUser().addStars(stars, role);
				break;
			}
		}
		for(RideMatch rm : matches) {
			if(rm.getRide(ride.getRideRole()).getId() == ride.getId()) {
				matches.remove(rm);
			}
		}
		rides.remove(ride);
	}
	
	/**
	 * Updates ride's current position.
	 * Determines if rides are matchable and returns a set of the ones that are.
	 * @param rideId, Ride's instance identifier.
	 * @param current, updated current location.
	 * @return match_set, sorted set with all possible matches for given ride.
	 * @author Tiago Coelho e Vasco Soares;
	 */
	java.util.SortedSet<RideMatchInfo> updateRide(long rideId,Location current){
		SortedSet<RideMatchInfo> match_set = new TreeSet<RideMatchInfo>();
		for(Ride r1 : rides) {
			if(r1.getId() == rideId) {
				r1.setCurrent(current);
				match_set = new TreeSet<RideMatchInfo>(r1.getComparator());
				for(Ride r2 : rides) {
					RideMatch rm = new RideMatch(r1,r2);
					if(rm.matchable()) {
						matches.add(rm);
						match_set.add(getRideMatchInfo(rm));
					}
				}
				break;
			}
		}
		return match_set;
	}
	
	/**
	 * A match between 2 rides.
	 * @author Tiago Coelho e Vasco Soares;
	 */
	
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
		
		/**
		 * Verifies if the match is valid.
		 * Valid matches must fill both roles, have both ride's unmatched.
		 * Valid matched must also be in (roughly) the same location and have (roughly) the same destination.  
		 * @author Tiago Coelho e Vasco Soares;
		 */
		
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
