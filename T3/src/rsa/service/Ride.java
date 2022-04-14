package rsa.service;

import java.util.Comparator;
import rsa.quad.HasPoint;
import rsa.service.Matcher.RideMatch;
import rsa.shared.Location;
import rsa.shared.PreferredMatch;
import rsa.shared.RideMatchInfo;
import rsa.shared.RideRole;

/**
 * A user's (intention to) ride between two locations.
 * This class provides a comparator of ride matches adjusted to this ride.
 * @author Tiago Coelho e Vasco Soares;
 */

public class Ride implements HasPoint, RideMatchInfoSorter{
	private static int counter=0;
	long uniqueID;
	float cost;
	User user;
	Location current;
	Location from;
	Location to;
	String plate;
	RideMatch match;
	
	public Ride(User user,Location from,Location to,String plate,float cost) {
		counter++;
		this.uniqueID = counter;
		this.user = user;
		this.current = from;
		this.from = from;
		this.to = to;
		this.plate = plate;
		this.cost = cost;
		this.match = null;
	}
	
	public float getCost() {return cost;}
	
	public Location getFrom() {return from;}
	
	public Location getTo() {return to;}
	
	public Location getCurrent() {return current;}
	
	public long getId() {return uniqueID;}
	
	public String getPlate() {return plate;}
	
	public RideRole getRideRole() {
		if(plate == null) {
			return RideRole.PASSENGER;
		}
		else {
			return RideRole.DRIVER;
		}
	}
	
	public User getUser() {return user;}
	
	public double getX() {return current.getX();}
	
	public double getY() {return current.getY();}
	
	public boolean isDriver() {
		if(getRideRole().equals(RideRole.DRIVER)) {
			return true;
		}
		else
			return false;
	}
	
	public boolean isPassenger() {
		if(getRideRole().equals(RideRole.PASSENGER)) {
			return true;
		}
		else
			return false;
	}
	
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public void setCurrent(Location current) {
		this.current = current;
	}
	
	public void setFrom(Location from) {
		this.from = from;
	}
	
	public void setPlate(String plate) {
		this.plate = plate;
	}
	
	public void setTo(Location to) {
		this.to = to;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public RideMatch getMatch(){
		return match;		
	}
	
	public void setMatch(RideMatch match) {
		this.match = match;
	}
	
	public boolean isMatched() {
		if(this.match == null) {
			return false;
		}
		return true;
	}
	
	/**
	 * Instances of RideMatchInfo are compared based on the preferences of the ride's user (PreferredMatch).
	 * @return Comparator, a comparator of RideMatchInfo instances for the given ride.  
	 * @author Tiago Coelho e Vasco Soares;
	 */
	@Override
	public Comparator<RideMatchInfo> getComparator() {
		Comparator<RideMatchInfo> Comparator = new Comparator<RideMatchInfo>() {
            @Override
            public int compare(RideMatchInfo r1, RideMatchInfo r2) {
                if(user.getPreferredMatch().equals(PreferredMatch.BETTER)){
                	RideRole role = getRideRole().other();
                	return (int) (r2.getStars(role) - r1.getStars(role));
                }
                if(user.getPreferredMatch().equals(PreferredMatch.CLOSER)){
                	RideRole role = getRideRole().other();
                	double distance1 = current.getDistance(r1.getWhere(role).getX(), r1.getWhere(role).getY());
                	double distance2 = current.getDistance(r2.getWhere(role).getX(), r2.getWhere(role).getY());
                	return  (int) (distance1 - distance2);
                }
                else {
                	return (int) (r1.getCost() - r2.getCost());
                }
            }
		};
		return Comparator;
	}
}
