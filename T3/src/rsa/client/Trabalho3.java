package rsa.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class Trabalho3 implements EntryPoint {
	public void onModuleLoad() {
		final Login login = new Login();
		RootPanel.get().add(login);
	}
}
