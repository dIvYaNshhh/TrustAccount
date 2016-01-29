package com.syncappdata.trust_account;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import com.syncappdata.utils.Constant;

public class LoginScreen implements Constant{

	protected Shell shell;
	private Text user_name;
	private Text password;
	private Display display ;
	public LoginScreen(Display display){
		this.display = display;
	}

//	/**
//	 * Launch the application.
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		try {
//			LoginScreen window = new LoginScreen();
//			window.open();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Open the window.
	 */
	public void open() {
		
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
		shell.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		shell.setText("SWT Application");
		
		Label lblWelcomeToTrust = new Label(shell, SWT.NONE);
		lblWelcomeToTrust.setFont(SWTResourceManager.getFont(".SF NS Text", 14, SWT.BOLD));
		lblWelcomeToTrust.setBounds(128, 10, 197, 28);
		lblWelcomeToTrust.setText("WelCome To Trust Account");
		
		Label lblUsername = new Label(shell, SWT.NONE);
		lblUsername.setBounds(141, 65, 66, 14);
		lblUsername.setText("UserName :");
		
		user_name = new Text(shell, SWT.BORDER);
		user_name.setBounds(213, 62, 108, 19);
		
		Label lblPassword = new Label(shell, SWT.NONE);
		lblPassword.setBounds(141, 93, 66, 14);
		lblPassword.setText("Password   :");
		
		password = new Text(shell, SWT.BORDER);
		password.setBounds(213, 90, 108, 19);
		
		Button btnLogin = new Button(shell, SWT.NONE);
		btnLogin.setBounds(186, 148, 94, 28);
		btnLogin.setText("Login");
		btnLogin.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				confirmLogin(user_name,password);
			}
			
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});

	}
	
	
	private void confirmLogin(Text user,Text pass){
		String username = user.getText();
		String password = pass.getText();
		
		if(username.equals(password)){
			ApplicationLauncher.mainScreen.open();
			shell.close();
		}else{
			MessageDialog.openError(shell, "Error", "Your UserName or Password is incorrect!!");
		}
	}
}
