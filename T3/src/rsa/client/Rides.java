package rsa.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;


public class Rides extends Composite {
	private HorizontalPanel rides = new HorizontalPanel();
	private Label status_driver = new Label("");
	private Label status_passenger = new Label("");
	private TextBox price,plate;
	private ListBox lb,lb1;
	
	public Rides() {
		initWidget(this.rides);
		
		VerticalPanel driver = new VerticalPanel();
		driver.setStyleName("submenu");
		driver.setSize("300px", "375px");
		driver.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		driver.setSpacing(10); 
		
		Label label1 = new Label("Driver");
		label1.setStyleName("titleText");
		driver.add(label1);
		
		
		Label label2 = new Label("Destination:");
		label2.setStyleName("wineText");
		lb = new ListBox();
		lb.setStyleName("box");
		lb.addItem("Porto, (41.1, 8.6)");
	    lb.addItem("Lisboa, (38.7, -9.1)");
	    lb.addItem("Braga, (41,5, -8.4)");
	    lb.addItem("Coimbra, (40.2, -8.4)");
	    lb.addItem("Viseu, (40.6, -7.9)");
	    driver.add(label2);
	    driver.add(lb);
		
		Label label3 = new Label("Price:");
		label3.setStyleName("wineText");
		price = new TextBox();
		price.setStyleName("box");
		driver.add(label3);
		driver.add(price);
		
		Label label4 = new Label("Car Plate:");
		label4.setStyleName("wineText");
		plate = new TextBox();
		plate.setStyleName("box");
		driver.add(label4);
		driver.add(plate);
		
		status_driver.setStyleName("redText");
		driver.add(status_driver);
		
		Button confirm = new Button("Start Ride");
		confirm.setStyleName("loginButton");
		confirm.addClickHandler(new driverClickHandler());
		driver.add(confirm);
		
		rides.add(driver);
		
		VerticalPanel passenger = new VerticalPanel();
		passenger.setStyleName("submenu");
		passenger.setSize("300px", "375px");
		passenger.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		passenger.setSpacing(10); 
		
		Label label6 = new Label("Passenger");
		label6.setStyleName("titleText");
		passenger.add(label6);
		
		Label label7 = new Label("Destination:");
		label7.setStyleName("wineText");
		lb1 = new ListBox();
		lb1.setStyleName("box");
		lb1.addItem("Porto, (41.1, 8.6)");
	    lb1.addItem("Lisboa, (38.7, -9.1)");
	    lb1.addItem("Braga, (41,5, -8.4)");
	    lb1.addItem("Coimbra, (40.2, -8.4)");
	    lb1.addItem("Viseu, (40.6, -7.9)");
	    passenger.add(label7);
	    passenger.add(lb1);
		
		status_passenger.setStyleName("redText");
		passenger.add(status_passenger);
		
		Button confirm1= new Button("Start Ride");
		confirm1.setStyleName("loginButton");
		confirm1.addClickHandler(new passengerClickHandler());
		passenger.add(confirm1);
		
		rides.add(passenger);
		
	}
	
	private class driverClickHandler implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			plate.setText("");
			price.setText("");
			lb.setItemSelected(0,true);
			status_driver.setText("Ride added sucessfully");
			 Timer timer = new Timer(){
			        @Override
			        public void run(){
			        	status_driver.setText("");
			        }
			      };
			     timer.schedule(1000);
		}
	}
	
	private class passengerClickHandler implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			lb1.setItemSelected(0,true);
			status_passenger.setText("Ride added sucessfully");
			 Timer timer = new Timer(){
			        @Override
			        public void run(){
			        	status_passenger.setText("");
			        }
			      };
			     timer.schedule(1000);
		}
	}	
}