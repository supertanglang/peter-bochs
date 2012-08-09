package com.peterbochs;

import com.apple.eawt.ApplicationAdapter;
import com.apple.eawt.ApplicationEvent;

@SuppressWarnings("deprecation")
public class MacAboutBoxHandler extends ApplicationAdapter {

	public void handleAbout(ApplicationEvent event) {
		event.setHandled(true);
		new AboutUsDialog(null).setVisible(true);
	}

	public void handleQuit(ApplicationEvent event) {
		System.exit(0);
	}
}
