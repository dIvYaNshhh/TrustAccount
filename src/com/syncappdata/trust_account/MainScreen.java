package com.syncappdata.trust_account;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

import com.syncappdata.utils.Constant;
import org.eclipse.swt.events.SelectionAdapter;

public class MainScreen implements Constant {
	public static String mFreeURL = "http://moodifyrelaxmelody.in/api/displaySounds.php";
	protected Shell shell;
	String output = "Hi";
	private Display display;
	private ClientInformation clientInfo;
	private HomeWindow homeWindow;
	private Composite contentPanel;
	private StackLayout layout;

	/**
	 * @wbp.parser.entryPoint
	 */
	// public MainScreen (Display display){
	// this.display = display;
	// }
	/**
	 * @wbp.parser.entryPoint
	 */
	// public MainScreen(){}
	/**
	 * Launch the application.
	 * 
	 * @param args
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		try {
			MainScreen window = new MainScreen();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		if (display == null) {
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
		shell = new Shell(display);
		// shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		// shell.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		shell.setText("Trust Account");
		createInnerWindow();
		createMenu();

	}

	private void createInnerWindow() {
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		contentPanel = new Composite(shell, SWT.RESIZE | SWT.FILL);
		layout = new StackLayout();
		contentPanel.setLayout(layout);
		
		homeWindow = new HomeWindow(contentPanel, SWT.RESIZE | SWT.FILL);
		
		layout.topControl = homeWindow;
		contentPanel.layout();
		// setInnerSize();

	}



	private void createMenu() {
		// Create the bar menu
		Menu menuBar = new Menu(shell, SWT.BAR);

		// Create the File item's dropdown menu
		Menu fileMenu = new Menu(menuBar);

		// Create the Account item's dropdown menu
		Menu accountMenu = new Menu(menuBar);

		// Create the Report item's dropdown menu
		Menu reportMenu = new Menu(menuBar);

		// Create the Help item's dropdown menu
		Menu helpMenu = new Menu(menuBar);

		// Create all the items in the bar menu
		MenuItem fileItem = new MenuItem(menuBar, SWT.CASCADE);
		fileItem.setText("File");
		fileItem.setMenu(fileMenu);

		// For Account
		MenuItem account = new MenuItem(menuBar, SWT.CASCADE);
		account.setText("Account");
		account.setMenu(accountMenu);
		
		MenuItem mntmClientInformation = new MenuItem(accountMenu, SWT.NONE);
		mntmClientInformation.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clientInfo = new ClientInformation(contentPanel, SWT.NONE);
				layout.topControl = clientInfo;
				contentPanel.layout();
				
			}
		});
		mntmClientInformation.setText("Client Information & Details");
		
		MenuItem mntmMasterLedger = new MenuItem(accountMenu, SWT.NONE);
		mntmMasterLedger.setText("Master Ledger");

		// For Report
		MenuItem report = new MenuItem(menuBar, SWT.CASCADE);
		report.setText("Report");
		report.setMenu(reportMenu);

		// Help
		MenuItem help = new MenuItem(menuBar, SWT.CASCADE);
		help.setText("Help");
		help.setMenu(helpMenu);

		// Create all the items in the File dropdown menu
		MenuItem mPreferecne = new MenuItem(fileMenu, SWT.NONE);
		mPreferecne.setText("Preference");
		MenuItem mBackup_Restore = new MenuItem(fileMenu, SWT.NONE);
		mBackup_Restore.setText("Backup & Restore Data");
		MenuItem mExit = new MenuItem(fileMenu, SWT.NONE);
		mExit.setText("Exit");

		mPreferecne.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				// MessageDialog.openConfirm(shell, "Success",
				// "Preference Press");

				// clientInfo.setVisible(true);
				

			}			
		});
		mBackup_Restore.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

				new BackUpDialog(shell, SWT.CLOSE).open();
			}

		});

		mExit.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				if (MessageDialog.openConfirm(shell, "Success", "Exit Press")) {
					System.exit(0);
				}
				;

			}

		});

		shell.setMenuBar(menuBar);
		

	}

	private void fetchData() {

		try {

			URL url = new URL(mFreeURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Authkey", "admin@123");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}
}
