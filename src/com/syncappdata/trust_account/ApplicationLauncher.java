package com.syncappdata.trust_account;

import org.eclipse.swt.widgets.Display;

public class ApplicationLauncher {
	// Creating static so that can access from splash window code
	// In production code, use event handling
	public static MainScreen mainScreen;

	public ApplicationLauncher() {
		Display display = new Display();
		//mainScreen = new MainScreen(display);
		LoginScreen loginScreen = new LoginScreen(display);
		loginScreen.open();
		while ((Display.getCurrent().getShells().length != 0)
				&& !Display.getCurrent().getShells()[0].isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	public static void main(String[] args) {
		new ApplicationLauncher();
	}
}
