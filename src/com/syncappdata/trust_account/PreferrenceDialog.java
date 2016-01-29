package com.syncappdata.trust_account;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class PreferrenceDialog extends Dialog {

	protected Object result;
	protected Shell shell;
	Text text_0;
	private Text text_1;
	private Text text_2;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public PreferrenceDialog(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
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
		shell = new Shell(getParent(), getStyle());
		shell.setSize(711, 585);
		shell.setText(getText());
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		
		Button btnSave = new Button(composite, SWT.NONE);
		btnSave.setText("Save");
		
		Button btnCancel = new Button(composite, SWT.NONE);
		btnCancel.setText("Cancel");
		
		Label label = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		Group grpSettings = new Group(composite, SWT.NONE);
		grpSettings.setLayout(new GridLayout(2, false));
		grpSettings.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		grpSettings.setText("Settings");
		
		Group grpDatabaseInformation = new Group(grpSettings, SWT.NONE);
		grpDatabaseInformation.setLayout(new RowLayout(SWT.HORIZONTAL));
		grpDatabaseInformation.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		grpDatabaseInformation.setText("Database Information");
		
		Label lblDatabasePath = new Label(grpDatabaseInformation, SWT.NONE);
		lblDatabasePath.setText("Database Path");
		
		text_0 = new Text(grpDatabaseInformation, SWT.BORDER);
		
		Group grpDefaultPrinitingFor = new Group(grpSettings, SWT.NONE);
		grpDefaultPrinitingFor.setLayout(new GridLayout(2, false));
		grpDefaultPrinitingFor.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		grpDefaultPrinitingFor.setText("Default Priniting for check printing");
		
		Label lblPrinter = new Label(grpDefaultPrinitingFor, SWT.NONE);
		lblPrinter.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblPrinter.setText("Printer");
		
		Combo combo_1 = new Combo(grpDefaultPrinitingFor, SWT.NONE);
		combo_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblFontName = new Label(grpDefaultPrinitingFor, SWT.NONE);
		lblFontName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblFontName.setText("Font Name");
		
		Combo combo = new Combo(grpDefaultPrinitingFor, SWT.NONE);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblFontSize = new Label(grpDefaultPrinitingFor, SWT.NONE);
		lblFontSize.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblFontSize.setText("Font Size");
		
		Combo combo_2 = new Combo(grpDefaultPrinitingFor, SWT.NONE);
		GridData gd_combo_2 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_combo_2.widthHint = 80;
		combo_2.setLayoutData(gd_combo_2);
		
		Group grpLocationInformation = new Group(grpSettings, SWT.NONE);
		grpLocationInformation.setLayout(new GridLayout(6, false));
		grpLocationInformation.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		grpLocationInformation.setText("Location Information");
		
		Label lblDefaultLocation = new Label(grpLocationInformation, SWT.NONE);
		lblDefaultLocation.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblDefaultLocation.setText("Default Location");
		
		Combo combo_3 = new Combo(grpLocationInformation, SWT.NONE);
		GridData gd_combo_3 = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_combo_3.widthHint = 85;
		combo_3.setLayoutData(gd_combo_3);
		
		Button btnSetAsDefault = new Button(grpLocationInformation, SWT.NONE);
		btnSetAsDefault.setText("Set as Default");
		
		Button btnNew = new Button(grpLocationInformation, SWT.NONE);
		btnNew.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		btnNew.setText("New");
		
		Button btnEdit = new Button(grpLocationInformation, SWT.NONE);
		btnEdit.setText("Edit");
		
		Button btnDelete = new Button(grpLocationInformation, SWT.NONE);
		btnDelete.setText("Delete");
		
		Label lblDefaultZipcode = new Label(grpLocationInformation, SWT.NONE);
		lblDefaultZipcode.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblDefaultZipcode.setText("Default ZipCode");
		
		text_1 = new Text(grpLocationInformation, SWT.BORDER);
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblZipLength = new Label(grpLocationInformation, SWT.NONE);
		lblZipLength.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblZipLength.setText("Zip Length");
		
		text_2 = new Text(grpLocationInformation, SWT.BORDER);
		text_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button btnAlphanumericZipcode = new Button(grpLocationInformation, SWT.CHECK);
		btnAlphanumericZipcode.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		btnAlphanumericZipcode.setText("AlphaNumeric ZipCode");
		
		Group grpDateFormat = new Group(grpSettings, SWT.NONE);
		grpDateFormat.setLayout(new RowLayout(SWT.HORIZONTAL));
		grpDateFormat.setText("Date Format");
		
		Label lblDefaultFormat = new Label(grpDateFormat, SWT.NONE);
		lblDefaultFormat.setText("Default Format");
		
		Combo combo_4 = new Combo(grpDateFormat, SWT.NONE);
		combo_4.setLayoutData(new RowData(121, SWT.DEFAULT));
		
		Group grpCurrencyFormat = new Group(grpSettings, SWT.NONE);
		grpCurrencyFormat.setLayout(new RowLayout(SWT.HORIZONTAL));
		grpCurrencyFormat.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		grpCurrencyFormat.setText("Currency Format");
		
		Label lblDefaultFormat_1 = new Label(grpCurrencyFormat, SWT.NONE);
		lblDefaultFormat_1.setText("Default Format");
		
		Combo combo_5 = new Combo(grpCurrencyFormat, SWT.NONE);
		combo_5.setLayoutData(new RowData(99, SWT.DEFAULT));
		
		Group grpIfBalanceIs = new Group(grpSettings, SWT.NONE);
		grpIfBalanceIs.setLayout(new GridLayout(1, false));
		grpIfBalanceIs.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		grpIfBalanceIs.setText("If Balance is not enough then check writting");
		
		Button btnRadioButton = new Button(grpIfBalanceIs, SWT.RADIO);
		btnRadioButton.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		btnRadioButton.setText("Warn when issuing check that exceeds clients account balance");
		
		Button btnRadioButton_1 = new Button(grpIfBalanceIs, SWT.RADIO);
		btnRadioButton_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		btnRadioButton_1.setText("Do not allow check which would exceed client account balance");

	}
}
