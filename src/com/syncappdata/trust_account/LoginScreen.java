package com.syncappdata.trust_account;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.syncappdata.utils.Constant;
import org.eclipse.wb.swt.SWTResourceManager;

public class LoginScreen implements Constant{

	protected Shell shell;
	private Display display ;
	private Text username;
	private Text password;
	public LoginScreen(Display display){
		this.display = display;
	}
	
	public LoginScreen(){}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			LoginScreen window = new LoginScreen();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		if(display!=null){
			display = Display.getDefault();
		}
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setImage(SWTResourceManager.getImage(LoginScreen.class, "/com/syncappdata/icons/app_icon.ico"));
		shell.setSize(550, 399);
		shell.setText("Login");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setLayout(new GridLayout(7, false));
		
		Label lblWelcomeAdmin = new Label(composite, SWT.NONE);
		lblWelcomeAdmin.setFont(SWTResourceManager.getFont("Segoe UI Symbol", 13, SWT.BOLD));
		GridData gd_lblWelcomeAdmin = new GridData(SWT.CENTER, SWT.CENTER, true, false, 7, 1);
		gd_lblWelcomeAdmin.heightHint = 28;
		lblWelcomeAdmin.setLayoutData(gd_lblWelcomeAdmin);
		lblWelcomeAdmin.setText("Welcome  To Trust Account");
		
		Label lblUsername = new Label(composite, SWT.NONE);
		lblUsername.setLayoutData(new GridData(SWT.RIGHT, SWT.BOTTOM, true, false, 5, 1));
		lblUsername.setText("UserName");
		new Label(composite, SWT.NONE);
		
		username = new Text(composite, SWT.BORDER);
		GridData gd_username = new GridData(SWT.LEFT, SWT.BOTTOM, true, false, 1, 1);
		gd_username.widthHint = 111;
		username.setLayoutData(gd_username);
		
		Label lblPassword = new Label(composite, SWT.NONE);
		lblPassword.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 5, 1));
		lblPassword.setText("Password");
		new Label(composite, SWT.NONE);
		
		password = new Text(composite, SWT.PASSWORD|SWT.BORDER);
		GridData gd_password = new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1);
		gd_password.widthHint = 111;
		password.setLayoutData(gd_password);
	
		
		Button btnLogin = new Button(composite, SWT.NONE);
		btnLogin.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setLogin();
			}
		});
		GridData gd_btnLogin = new GridData(SWT.CENTER, SWT.FILL, false, false, 7, 1);
		gd_btnLogin.widthHint = 111;
		btnLogin.setLayoutData(gd_btnLogin);
		btnLogin.setText("Login");

	}

	private void setLogin(){
		if(username.getText().equals(password.getText())){
			shell.dispose();
			ApplicationLauncher.mainScreen.open();
			
		}
		else{
			MessageDialog.openError(shell, "Error", "Your UserName or Password is incorrect!!");
		}
	}

}

