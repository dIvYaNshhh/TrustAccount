package com.syncappdata.trust_account;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Table;

public class HomeWindow extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public HomeWindow(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(1, false));
		
		Label lblWelcomeAdmin = new Label(this, SWT.NONE);
		lblWelcomeAdmin.setEnabled(false);
		lblWelcomeAdmin.setAlignment(SWT.CENTER);
		lblWelcomeAdmin.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblWelcomeAdmin.setText("WelCome Admin");
		
		Label lblHelloAdmin = new Label(this, SWT.NONE);
		lblHelloAdmin.setAlignment(SWT.CENTER);
		lblHelloAdmin.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		lblHelloAdmin.setText("Hello Admin");
		
		

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
