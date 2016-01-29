package com.syncappdata.trust_account;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class BackUpDialog extends Dialog {

	protected Object result;
	protected Shell shell;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public BackUpDialog(Shell parent, int style) {
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
		shell.setSize(497, 111);
		shell.setText(getText());
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setLayout(new GridLayout(3, true));
		
		Button btnBackup = new Button(composite, SWT.NONE);
		btnBackup.setImage(SWTResourceManager.getImage(BackUpDialog.class, "/com/syncappdata/icons/deactive.ico"));
		btnBackup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		btnBackup.setText("BackUp");
		
		Button btnRestoreData = new Button(composite, SWT.NONE);
		btnRestoreData.setAlignment(SWT.LEFT);
		btnRestoreData.setImage(SWTResourceManager.getImage(BackUpDialog.class, "/com/syncappdata/icons/deactive.ico"));
		btnRestoreData.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnRestoreData.setText("Restore Data");
		
		Button btnCloseButton = new Button(composite, SWT.NONE);
		btnCloseButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
			}
		});
		btnCloseButton.setImage(SWTResourceManager.getImage(BackUpDialog.class, "/com/syncappdata/icons/deactive.ico"));
		btnCloseButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnCloseButton.setText("Close");

	}

}
