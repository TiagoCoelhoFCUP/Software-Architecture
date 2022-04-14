package rsa.service;

import java.util.LinkedList;
import rsa.shared.Car;
import rsa.shared.PreferredMatch;
import rsa.shared.RideRole;
import rsa.shared.UserStars;

/**
 * An user of the Ride Sharing App.
 * An instance of this class records the user's authentication and other relevant data. 
 * @author Tiago Coelho e Vasco Soares;
 */

public class User implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	PreferredMatch preference;
	int n_driver;
	int n_passenger;
	float total_stars_driver;
	float total_stars_passenger;
	String nick;
	String name;
	String password;
	LinkedList<Car> vehicles;
	
	public User(String nick,String name,String password) {
		this.nick = nick;
		this.name = name;
		this.password = password;
		this.vehicles = new LinkedList<Car>();
		this.total_stars_driver = 0;
		this.total_stars_passenger = 0;
		this.n_driver = 0;
		this.n_passenger = 0;
		preference = PreferredMatch.BETTER;
	}
	
	String getNick() {
		return nick;
	}
	
	String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void addCar(Car car) {
		if(!vehicles.contains(car)) {
			vehicles.add(car);
		}
	}
	
	public Car getCar(String plate) {
		for (Car car : vehicles) {
			if(car.getPlate().equals(plate)) {
				return car;
			}
		}
		return null;
	}
	
	void deleteCar(String plate) {
		for (Car car : vehicles) {
			if(car.getPlate().equals(plate)) {
				vehicles.remove(car);
			}
		}				
	}
	
	public void addStars(UserStars moreStars, RideRole role) {
		int stars = moreStars.getStars();
		if(role.other().equals(RideRole.DRIVER)) {
			n_passenger++;
			total_stars_passenger += stars;
		}
		else {
			n_driver++;
			total_stars_driver+= stars;
		}
	}
	
	public float getAverage(RideRole role) {
		if(role.other().equals(RideRole.DRIVER)) {
			if(n_passenger != 0) {return (total_stars_passenger/n_passenger);}
			else {return 0;}
		}
		else {
			if(n_driver != 0) {return (total_stars_driver/n_driver);}
			else {return 0;}
		}
	}
	
	boolean authenticate(String password) {
		if(this.password.equals(password)) {
			return true;
		}
		else {return false;}
	}
	
	PreferredMatch getPreferredMatch() {
		return preference;
	}
	
	void setPreferredMatch(PreferredMatch preferredMatch) {
		if(preferredMatch != null) {
			preference = preferredMatch;
		}
		else
			preference = PreferredMatch.BETTER;
	}
}
