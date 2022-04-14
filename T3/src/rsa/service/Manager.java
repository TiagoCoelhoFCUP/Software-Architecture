package rsa.service;

import rsa.shared.*;

/**
 * An instance of this class is responsible for managing the ride sharing service, handling user requests and matching their rides.
 * @author Tiago Coelho e Vasco Soares;
 */

public class Manager {
	private static Manager manager = null;
	Users allUsers;
	Matcher matcher;
	
	public static Manager getInstance() {
		if(manager == null) {
			manager = new Manager(); 
		}
		return manager; 
	}
	
	private Manager() {
		allUsers = Users.getInstance();
		matcher = new Matcher();
	}
	
	void reset() {
		allUsers.reset();
		allUsers = Users.getInstance();
		matcher = new Matcher();
	}
	
	public boolean register(String nick,String name,String password) {
		return allUsers.register(nick, name, password);
	}
	
	public boolean updatePassword(String nick,String oldPassword,String newPassword) {
		return allUsers.updatePassword(nick, oldPassword, newPassword);
	}
	
	public boolean authenticate(String nick,String password) {
		return allUsers.authenticate(nick, password);
	}
	
	public PreferredMatch getPreferredMatch(String nick,String password) throws RideSharingAppException {
		if(authenticate(nick,password)) {
			return allUsers.getUser(nick).getPreferredMatch();
		}
		else {throw new RideSharingAppException("Authentication failed");}
	}
	public void setPreferredMatch(String nick,String password,PreferredMatch preferred) throws RideSharingAppException {
		if(authenticate(nick,password)) {
			allUsers.getUser(nick).setPreferredMatch(preferred);
		}
		else {throw new RideSharingAppException("Authentication failed");}
	}
	
	public long addRide(String nick,String password,Location from,Location to,String plate,float cost)  throws RideSharingAppException {
		if(authenticate(nick,password)) {
			return matcher.addRide(allUsers.getUser(nick), from, to, plate, cost);
		}
		else {throw new RideSharingAppException("Authentication failed");}
	}
	
	public java.util.Set<RideMatchInfo> updateRide(long rideId,Location current){
		return matcher.updateRide(rideId, current);
	}
	
	public void acceptMatch(long rideId,long matchId) {
		matcher.acceptMatch(rideId, matchId);
	}
	
	public void concludeRide(long rideId,UserStars classification) {
		matcher.concludeRide(rideId, classification);
	}
	
	public double getAverage(String nick,RideRole role) throws RideSharingAppException{
		if(allUsers.getUser(nick) == null) {
			throw new RideSharingAppException("User's nick not found");
		}
		return allUsers.getUser(nick).getAverage(role);
	}
	
	public User getUser(String nick,String password) throws RideSharingAppException{
		if(authenticate(nick,password)) {
			if(allUsers.getUser(nick) == null) {
				throw new RideSharingAppException("User's nick not found");
			}
			return allUsers.getUser(nick);
		}
		else {throw new RideSharingAppException("Authentication failed");}
	}
}
