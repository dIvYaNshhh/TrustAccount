package com.syncappdata.trust_account;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class ClientInformation extends Composite {
	private Table table;
	private Combo combo;
	private Composite active_client_selection;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public ClientInformation(Composite parent, int style) {
		super(parent, SWT.H_SCROLL | SWT.V_SCROLL);
		setLayout(new GridLayout(1, false));

		Group grpClientInformation = new Group(this, SWT.NONE);
		grpClientInformation.setLayout(new FillLayout(SWT.HORIZONTAL));

		grpClientInformation.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
				true, true, 1, 1));
		grpClientInformation.setText("Client Information");

		Composite composite = new Composite(grpClientInformation, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));

		Label lblClient = new Label(composite, SWT.NONE);
		lblClient.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
		lblClient.setText("Client Files");

		Composite composite_1 = new Composite(composite, SWT.NONE);
		composite_1.setLayout(new GridLayout(2, false));
		composite_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));

		combo = new Combo(composite_1, SWT.DROP_DOWN|SWT.READ_ONLY);
		GridData gd_combo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1,
				1);
		gd_combo.widthHint = 140;
		combo.setLayoutData(gd_combo);
		combo.add("Active Client");
		combo.add("All Client");
		combo.add("Archive Client");
		combo.select(0);
		combo.pack();
		//onActiveClient();
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int position = combo.getSelectionIndex();
				if(position==0){
					onActiveClient();
				}else if(position==1){
					onAllClient();
				}else if(position==2){
					onArchiveClient();
				}
			}
		});
				

		Composite row_layout = new Composite(composite_1, SWT.NONE);
		row_layout.setLayout(new FillLayout(SWT.HORIZONTAL));
		row_layout.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		active_client_selection = new Composite(row_layout, SWT.NONE);
		active_client_selection.setLayout(new FillLayout(SWT.HORIZONTAL));
		

		ToolBar acive_client_toolBar = new ToolBar(active_client_selection, SWT.FLAT
				| SWT.RIGHT);

		new ToolItem(acive_client_toolBar, SWT.SEPARATOR);
		ToolItem tltmNewClient = new ToolItem(acive_client_toolBar, SWT.NONE);
		tltmNewClient.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new NewClient(getShell(), SWT.CLOSE).open();
			}
		});
		tltmNewClient.setText("New Client");
		new ToolItem(acive_client_toolBar, SWT.SEPARATOR);
		ToolItem tltmEdit = new ToolItem(acive_client_toolBar, SWT.NONE);
		tltmEdit.setText("Edit");
		new ToolItem(acive_client_toolBar, SWT.SEPARATOR);
		ToolItem tltmDeactive = new ToolItem(acive_client_toolBar, SWT.NONE);
		tltmDeactive.setText("Deactive");
		new ToolItem(acive_client_toolBar, SWT.SEPARATOR);
		
		new ToolItem(acive_client_toolBar, SWT.SEPARATOR);
		ToolItem tltmSearch = new ToolItem(acive_client_toolBar, SWT.NONE);
		tltmSearch.setText("Search");
		new ToolItem(acive_client_toolBar, SWT.SEPARATOR);
		ToolItem tltmLedger = new ToolItem(acive_client_toolBar, SWT.NONE);
		tltmLedger.setText("Ledger");

		table = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn tblclmnSr = new TableColumn(table, SWT.NONE);
		tblclmnSr.setWidth(31);
		tblclmnSr.setText("Sr");

		TableColumn tblclmnName = new TableColumn(table, SWT.NONE);
		tblclmnName.setWidth(130);
		tblclmnName.setText("Name");

		TableColumn tblclmnFile = new TableColumn(table, SWT.NONE);
		tblclmnFile.setWidth(100);
		tblclmnFile.setText("File#");

		TableColumn tblclmnAtt = new TableColumn(table, SWT.NONE);
		tblclmnAtt.setWidth(152);
		tblclmnAtt.setText("Attorney");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	
	
	private void onActiveClient(){
		active_client_selection.setVisible(true);
		active_client_selection.getParent().pack();
	}
	
	private void onAllClient(){
		active_client_selection.setVisible(false);
		active_client_selection.getParent().pack();
	}
	

	private void onArchiveClient(){
		
		active_client_selection.setVisible(false);
		active_client_selection.getParent().pack();
	}
}
