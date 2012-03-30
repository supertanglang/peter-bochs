package com.peterbochs;

import com.apple.eawt.ApplicationAdapter;
import com.apple.eawt.ApplicationEvent;

public class MacAboutBoxHandler extends ApplicationAdapter {

	public void handleAbout(ApplicationEvent event) {
		event.setHandled(true);
		new JAboutUsDialog(null).setVisible(true);
	}
}
