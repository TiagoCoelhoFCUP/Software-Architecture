package rsa.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * A car used in rides, with a license plate (that can be used as key) a make, model and color. 
 * @author Tiago Coelho e Vasco Soares;
 */
public class Car implements IsSerializable{
	private String plate;
	private String make;
	private String model;
	private String color;
	
	public Car() {};
	
	public Car(String plate,String make,String model,String color) {
		this.plate = plate;
		this.make = make;
		this.model = model;
		this.color = color;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}

