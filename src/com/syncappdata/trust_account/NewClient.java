package com.syncappdata.trust_account;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class NewClient extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Text text_7;
	private Text text_8;
	private Text text_9;
	private Text text_10;
	private Text text_11;
	private Text text_12;
	private Text text_13;
	private Text text_14;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public NewClient(Shell parent, int style) {
		super(parent, style);
		setText("Client Master");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), SWT.SHELL_TRIM | SWT.BORDER);
		shell.setSize(600, 500);
		shell.setText(getText());
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		
		Composite composite_1 = new Composite(composite, SWT.NONE);
		composite_1.setLayout(new FillLayout(SWT.HORIZONTAL));
		composite_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		ToolBar toolBar = new ToolBar(composite_1, SWT.FLAT | SWT.RIGHT);
		
		ToolItem tltmAdd = new ToolItem(toolBar, SWT.NONE);
		tltmAdd.setText("Add");
		
		new ToolItem(toolBar, SWT.SEPARATOR);
		
		ToolItem tltmEdit = new ToolItem(toolBar, SWT.NONE);
		tltmEdit.setText("Edit");
		
		new ToolItem(toolBar, SWT.SEPARATOR);
		
		ToolItem tltmSave = new ToolItem(toolBar, SWT.NONE);
		tltmSave.setText("Save");
		
		new ToolItem(toolBar, SWT.SEPARATOR);
		
		ToolItem tltmDeactive = new ToolItem(toolBar, SWT.NONE);
		tltmDeactive.setText("Deactive");
		
		new ToolItem(toolBar, SWT.SEPARATOR);
		
		ToolItem tltmNewItem = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
			}
		});
		tltmNewItem.setText("Cancel");
		
		Label label = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Group grpClientInformation = new Group(composite, SWT.NONE);
		grpClientInformation.setLayout(new FillLayout(SWT.HORIZONTAL));
		grpClientInformation.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
		grpClientInformation.setText("Client Information");
		
		Composite composite_2 = new Composite(grpClientInformation, SWT.NONE);
		composite_2.setLayout(new GridLayout(6, false));
		
		Label lblFileNo = new Label(composite_2, SWT.NONE);
		lblFileNo.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblFileNo.setText("File No");
		
		text = new Text(composite_2, SWT.BORDER);
		
		Label lblDateOpened = new Label(composite_2, SWT.NONE);
		lblDateOpened.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblDateOpened.setText("Date Opened");
		
		DateTime dateTime = new DateTime(composite_2, SWT.BORDER);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		
		Label lblAttorney = new Label(composite_2, SWT.NONE);
		lblAttorney.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblAttorney.setText("Attorney");
		
		Combo combo = new Combo(composite_2, SWT.NONE);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));
		new Label(composite_2, SWT.NONE);
		
		Label lblClientName = new Label(composite_2, SWT.NONE);
		lblClientName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblClientName.setText("Client Name");
		
		text_1 = new Text(composite_2, SWT.BORDER);
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));
		new Label(composite_2, SWT.NONE);
		
		Label lblInformation = new Label(composite_2, SWT.NONE);
		lblInformation.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblInformation.setText("Information");
		
		text_2 = new Text(composite_2, SWT.BORDER);
		text_2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 4, 3));
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		
		Label lblNewLabel = new Label(composite_2, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setText("Street Line 1");
		
		text_3 = new Text(composite_2, SWT.BORDER);
		text_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));
		new Label(composite_2, SWT.NONE);
		
		Label lblStreetLine = new Label(composite_2, SWT.NONE);
		lblStreetLine.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblStreetLine.setText("Street Line 2");
		
		text_4 = new Text(composite_2, SWT.BORDER);
		text_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));
		new Label(composite_2, SWT.NONE);
		
		Label lblStreetLine_1 = new Label(composite_2, SWT.NONE);
		lblStreetLine_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblStreetLine_1.setText("Street Line 3");
		
		text_5 = new Text(composite_2, SWT.BORDER);
		text_5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));
		new Label(composite_2, SWT.NONE);
		
		Label lblCity = new Label(composite_2, SWT.NONE);
		lblCity.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblCity.setText("City");
		
		text_6 = new Text(composite_2, SWT.BORDER);
		text_6.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label lblState = new Label(composite_2, SWT.NONE);
		lblState.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblState.setText("State");
		
		text_7 = new Text(composite_2, SWT.BORDER);
		text_7.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label lblZipcode = new Label(composite_2, SWT.NONE);
		lblZipcode.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblZipcode.setText("ZipCode");
		
		text_8 = new Text(composite_2, SWT.BORDER);
		text_8.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label lblWebsite = new Label(composite_2, SWT.NONE);
		lblWebsite.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblWebsite.setText("Website");
		
		text_9 = new Text(composite_2, SWT.BORDER);
		text_9.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		Label lblEmail = new Label(composite_2, SWT.NONE);
		lblEmail.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblEmail.setText("Email");
		
		text_10 = new Text(composite_2, SWT.BORDER);
		text_10.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		Label lblCellhomePh = new Label(composite_2, SWT.NONE);
		lblCellhomePh.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblCellhomePh.setText("Cell/Home Ph");
		
		text_11 = new Text(composite_2, SWT.BORDER);
		text_11.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		Label lblWorkPh = new Label(composite_2, SWT.NONE);
		lblWorkPh.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblWorkPh.setText("Work Ph");
		
		text_12 = new Text(composite_2, SWT.BORDER);
		text_12.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		Label lblFax = new Label(composite_2, SWT.NONE);
		lblFax.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblFax.setText("Fax");
		
		text_13 = new Text(composite_2, SWT.BORDER);
		text_13.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		Label lblDeposit = new Label(composite_2, SWT.NONE);
		lblDeposit.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblDeposit.setText("Deposit");
		
		text_14 = new Text(composite_2, SWT.BORDER);
		text_14.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		new Label(composite_2, SWT.NONE);
		
		Button btnSave = new Button(composite_2, SWT.NONE);
		btnSave.setText("Save");
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);

	}
}
