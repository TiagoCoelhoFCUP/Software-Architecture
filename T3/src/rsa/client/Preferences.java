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
import com.google.gwt.user.client.ui.VerticalPanel;

public class Preferences extends Composite {
	private VerticalPanel wrapper = new VerticalPanel();
	private Label statusText = new Label("");
	private Button b1,b2,b3;
	
	public Preferences() {
		initWidget(this.wrapper);
		wrapper.setSize("450px", "375px");
		wrapper.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		wrapper.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		wrapper.setStyleName("submenu");
		wrapper.setSpacing(10); 
		
		HorizontalPanel better = new HorizontalPanel();
		better.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		better.setSize("400px", "110px");
		better.setSpacing(20);
		HorizontalPanel cheaper = new HorizontalPanel();
		cheaper.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		cheaper.setSize("400px", "110px");
		cheaper.setSpacing(20);
		HorizontalPanel closer = new HorizontalPanel();
		closer.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		closer.setSize("400px", "110px");
		closer.setSpacing(20);
		
		Label label1 = new Label("Prefer to ride with better users");
		label1.setStyleName("wineText");
		Label label2 = new Label("Prefer cheaper rides");
		label2.setStyleName("wineText");
		Label label3 = new Label("Prefer to ride with nearby users");
		label3.setStyleName("wineText");
		
		b1 = new Button("Better");
		b1.setStyleName("selectedsubmenuButton");
		b1.addClickHandler(new betterClickHandler());
		b2 = new Button("Cheaper");
		b2.setStyleName("submenuButton");
		b2.addClickHandler(new cheaperClickHandler());
		b3 = new Button("Closer");
		b3.setStyleName("submenuButton");
		b3.addClickHandler(new closerClickHandler());
		
		better.add(b1);
		better.add(label1);
		
		cheaper.add(b2);
		cheaper.add(label2);
		
		closer.add(b3);
		closer.add(label3);
		
		wrapper.add(better);
		wrapper.add(cheaper);
		wrapper.add(closer);
		
		statusText.setStyleName("redText");
		wrapper.add(statusText);
		
	}
	
	private class betterClickHandler implements ClickHandler{
		public void onClick(ClickEvent event) {
			b1.setStyleName("selectedsubmenuButton");
			b2.setStyleName("submenuButton");
			b3.setStyleName("submenuButton");
			statusText.setText("Preference set to BETTER");
			 Timer timer = new Timer(){
			        @Override
			        public void run(){
			        	statusText.setText("");
			        }
			      };
			     timer.schedule(1000);
		}
	}
	
	private class cheaperClickHandler implements ClickHandler{
		public void onClick(ClickEvent event) {
			b1.setStyleName("submenuButton");
			b2.setStyleName("selectedsubmenuButton");
			b3.setStyleName("submenuButton");
			statusText.setText("Preference set to CHEAPER");
			 Timer timer = new Timer(){
			        @Override
			        public void run(){
			        	statusText.setText("");
			        }
			      };
			     timer.schedule(1000);
		}
	}
	
	private class closerClickHandler implements ClickHandler{
		public void onClick(ClickEvent event) {
			b1.setStyleName("submenuButton");
			b2.setStyleName("submenuButton");
			b3.setStyleName("selectedsubmenuButton");
			statusText.setText("Preference set to CLOSER");
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
