package com.uptc.viewer;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JFramePrincipal extends JFrame{

	private static final long serialVersionUID = 1L;

	private JPanel jPanelPrincipal;
	private HeaderProcess headerProcess;
	private JTableData centerTable;
	private MenuBarReports menuBarr;
	
	public JFramePrincipal(ActionListener actionListener) {
		super("Process");
		this.sizeRecover();
		this.jPanelPrincipal = new JPanel();
		this.headerProcess = new HeaderProcess(actionListener);
		this.centerTable = new JTableData();
		this.menuBarr = new MenuBarReports(actionListener);
		this.initComponents(actionListener);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void sizeRecover() {
		Toolkit jFrameWindow = Toolkit.getDefaultToolkit();
		Dimension screenSize = jFrameWindow.getScreenSize();
		this.setSize(screenSize);
	}
	
	private void initComponents(ActionListener actionListener) {
		jPanelPrincipal.setBackground(Color.WHITE);
		jPanelPrincipal.setLayout(new BorderLayout());
		jPanelPrincipal.add(headerProcess, BorderLayout.NORTH);
		

		jPanelPrincipal.add(centerTable, BorderLayout.CENTER);

		jPanelPrincipal.add(menuBarr, BorderLayout.SOUTH);
		
		this.add(jPanelPrincipal);
	}
	
	public void cleanRowsTable() {
		centerTable.cleanRowsTable();
	}

	public ArrayList<Object[]> getInformation(){
		return centerTable.getProcessInformation();
	}
	
	
	public void addElementToTablePrincipalTable() {
		centerTable.addElementToTable(getInformation());
	}
	
	public void setInformationProcessTable(){
		Object[] data={headerProcess.getNameProcess(),headerProcess.getProcessTime(),headerProcess.getBlockedProcess()};
		centerTable.addElementUniqueToTable(data);
	}

	public int getTimeCPU() {
		return headerProcess.setTimeCPU();
	}
}
