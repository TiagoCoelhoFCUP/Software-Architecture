package rsa.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Login extends Composite {
	private VerticalPanel login = new VerticalPanel();
	private Label statusText;
	private TextBox nick,name;
	private PasswordTextBox password;
	
	public Login() {
		initWidget(this.login);
		login.setStyleName("background");
		login.setSize("250px", "250px");
		login.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		login.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		login.setSpacing(10); 
		
		Label label1 = new Label("Autentication");
		label1.setStyleName("titleText");
		login.add(label1);
		
		Label label2= new Label("Nick:");
		label2.setStyleName("wineText");
		login.add(label2);
		nick = new TextBox();
		nick.setStyleName("box");
		login.add(nick);
		
		Label label3= new Label("Name:");
		label3.setStyleName("wineText");
		login.add(label3);
		name = new TextBox();
		name.setStyleName("box");
		login.add(name);
		
		Label label4= new Label("Password:");
		label4.setStyleName("wineText");
		login.add(label4);
		password = new PasswordTextBox();
		password.setStyleName("box");
		login.add(password);
		
		statusText = new Label("");
		statusText.setStyleName("redText");
		login.add(statusText);
		
		HorizontalPanel buttons_panel = new HorizontalPanel();
		buttons_panel.setSpacing(20); 
		
		Button log = new Button("Login");
		log.addClickHandler(new loginClickHandler());
		log.setStyleName("loginButton");
		
		Button register = new Button("Register");
		register.addClickHandler(new registerClickHandler());
		register.setStyleName("loginButton");
		
		buttons_panel.add(log);
		buttons_panel.add(register);
		login.add(buttons_panel);
		
	}
	
	private class loginClickHandler implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			Menu menu = new Menu();
			RootPanel.get().clear();
			RootPanel.get().add(menu);
		}
	}
	
	private class registerClickHandler implements ClickHandler{
		public void onClick(ClickEvent event) {
			nick.setText("");
			name.setText("");
			password.setText("");
			statusText.setText("Registration Sucessfull.");
			 Timer timer = new Timer(){
		        @Override
		        public void run(){
		        	statusText.setText("");
		        }
		      };
		     timer.schedule(1000);
		}
	}
}
