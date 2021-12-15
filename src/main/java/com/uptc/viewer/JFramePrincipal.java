package com.uptc.viewer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFramePrincipal extends JFrame{

	private static final long serialVersionUID = 1L;

	private JPanel jPanelPrincipal;
	private HeaderProcess headerProcess;
	private JTableData centerTable;
	private MenuBarReports menuBarr;
	String [] headers = {"Nombre del proceso", "Tiempo del proceso", "Bloqueado", "Editar", "Eliminar"};
	
	public JFramePrincipal(ActionListener actionListener) {
		super("Process");
		this.setSize(900,600);
		this.jPanelPrincipal = new JPanel();
		this.headerProcess = new HeaderProcess(actionListener);
		this.centerTable = new JTableData(headers);
		this.menuBarr = new MenuBarReports(actionListener);
		this.initComponents(actionListener);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
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
