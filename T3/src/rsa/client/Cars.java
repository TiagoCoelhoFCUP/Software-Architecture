package rsa.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;


public class Cars extends Composite {
	private HorizontalPanel cars = new HorizontalPanel();
	private Label status_add = new Label("");
	private Label status_del = new Label("");
	private TextBox plate,make,model,color,plate1;
	
	public Cars() {
		initWidget(this.cars);
		
		VerticalPanel add = new VerticalPanel();
		add.setStyleName("submenu");
		add.setSize("300px", "375px");
		add.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		add.setSpacing(10); 
		
		Label label1 = new Label("Add Car");
		label1.setStyleName("titleText");
		add.add(label1);
		
		Label label2 = new Label("Plate:");
		label2.setStyleName("wineText");
		plate = new TextBox();
		plate.setStyleName("box");
		add.add(label2);
		add.add(plate);
		
		Label label3 = new Label("Make:");
		label3.setStyleName("wineText");
		make = new TextBox();
		make.setStyleName("box");
		add.add(label3);
		add.add(make);
		
		Label label4 = new Label("Model:");
		label4.setStyleName("wineText");
		model = new TextBox();
		model.setStyleName("box");
		add.add(label4);
		add.add(model);
		
		Label label5 = new Label("Color:");
		label5.setStyleName("wineText");
		color = new TextBox();
		color.setStyleName("box");
		add.add(label5);
		add.add(color);
		
		status_add.setStyleName("redText");
		add.add(status_add);
		
		Button confirm = new Button("Confirm");
		confirm.setStyleName("loginButton");
		confirm.addClickHandler(new addClickHandler());
		add.add(confirm);
		
		cars.add(add);
		
		VerticalPanel remove = new VerticalPanel();
		remove.setStyleName("submenu");
		remove.setSize("300px", "375px");
		remove.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		remove.setSpacing(10); 
		
		Label label6 = new Label("Remove Car");
		label6.setStyleName("titleText");
		remove.add(label6);
		
		Label label7 = new Label("Plate:");
		label7.setStyleName("wineText");
		plate1 = new TextBox();
		plate1.setStyleName("box");
		remove.add(label7);
		remove.add(plate1);
		
		status_del.setStyleName("redText");
		remove.add(status_del);
		
		Button confirm1= new Button("Confirm");
		confirm1.setStyleName("loginButton");
		confirm1.addClickHandler(new delClickHandler());
		remove.add(confirm1);
		
		cars.add(remove);
		
	}
	
	private class addClickHandler implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			plate.setText("");
			make.setText("");
			model.setText("");
			color.setText("");
			status_add.setText("Car added sucessfully");
			 Timer timer = new Timer(){
			        @Override
			        public void run(){
			        	status_add.setText("");
			        }
			      };
			     timer.schedule(1000);
		}
	}
	
	private class delClickHandler implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			plate1.setText("");
			status_del.setText("Car removed sucessfully");
			 Timer timer = new Timer(){
			        @Override
			        public void run(){
			        	status_del.setText("");
			        }
			      };
			     timer.schedule(1000);
		}
	}	
}
