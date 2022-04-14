package rsa.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Menu extends Composite {
	private VerticalPanel menu = new VerticalPanel();
	private Button cars, pref, rides;
	private DeckPanel deckPanel = new DeckPanel();
	
	public Menu() {
		initWidget(this.menu);
		menu.setStyleName("background");
		menu.setSize("600px", "600px");
		menu.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		menu.setSpacing(10);
		
		Cars cars_div = new Cars();
		Preferences pref_div = new Preferences();
		Rides rides_div = new Rides();
		
		deckPanel.add(cars_div);
		deckPanel.add(pref_div);
		deckPanel.add(rides_div);
		deckPanel.showWidget(0);
		
		HorizontalPanel sub_menu = new HorizontalPanel();
		sub_menu.setSpacing(10);
		
		cars = new Button("Vehicles");
		cars.setStyleName("selectedmenuButton");
		cars.addClickHandler(new carsClickHandler());
		pref = new Button("Preferences");
		pref.setStyleName("menuButton");
		pref.addClickHandler(new prefClickHandler());
		rides = new Button("Rides");
		rides.setStyleName("menuButton");
		rides.addClickHandler(new ridesClickHandler());
		
		sub_menu.add(cars);
		sub_menu.add(pref);
		sub_menu.add(rides);
				
		menu.add(sub_menu);
		menu.add(deckPanel);
	}
	
	private class carsClickHandler implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			deckPanel.showWidget(0);
			cars.setStyleName("selectedmenuButton");
			pref.setStyleName("menuButton");
			rides.setStyleName("menuButton");
		}
	}
	
	private class prefClickHandler implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			deckPanel.showWidget(1);
			pref.setStyleName("selectedmenuButton");
			cars.setStyleName("menuButton");
			rides.setStyleName("menuButton");
		}
	}
	
	private class ridesClickHandler implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			deckPanel.showWidget(2);
			rides.setStyleName("selectedmenuButton");
			cars.setStyleName("menuButton");
			pref.setStyleName("menuButton");
		}
	}
}
