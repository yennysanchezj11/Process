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
	
	public JFramePrincipal(ActionListener actionListener) {
		super("Process");
		this.sizeRecover();
		this.jPanelPrincipal = new JPanel();
		this.headerProcess = new HeaderProcess();
		this.centerTable = new JTableData();
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
		this.add(jPanelPrincipal);

		jPanelPrincipal.add(centerTable, BorderLayout.CENTER);

//		footerPanel = new FooterPanel();
//		jPanelPrincipal.add(footerPanel, BorderLayout.SOUTH);

		
	}
	
	public void cleanRowsTable() {
		centerTable.cleanRowsTable();
	}
	
	public void addElementToTablePrincipalTable(ArrayList<Object[]> datasList) {
		centerTable.addElementToTable(datasList);
	}
	
	public static void main(String[] args) {
		new JFramePrincipal(null);
	}
}
