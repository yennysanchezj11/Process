package com.uptc.viewer;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import com.uptc.controller.Commands;

public class MenuBarReports extends JMenuBar {

	private static final long serialVersionUID = 1L;

	private JMenu report;
	private JMenuItem report1, report2, report3, report4, report5, report6, report7;

	public MenuBarReports(ActionListener actionListener) {
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 210, 15));
		this.setBackground(Constants.COLOR_MENUBAR);
		this.initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {

		report = new JMenu(Constants.TOP_PANEL_MENU_PRINCIPAL_REPORT);
		report.setFont(Constants.FONT_MENUBAR);
		report.setForeground(Color.BLACK);

		report1 = new JMenuItem(Constants.TOP_T_MENUITEM_REPORT1);
		report1.setFont(Constants.FONT_MENUBAR);
		report1.addActionListener(actionListener);
		report1.setActionCommand(Commands.C_REPORT1.toString());
		report.add(report1);
		this.add(report);
		report.addSeparator();

		report2 = new JMenuItem(Constants.TOP_T_MENUITEM_REPORT2);
		report2.setFont(Constants.FONT_MENUBAR);
		report2.addActionListener(actionListener);
		report2.setActionCommand(Commands.C_REPORT2.toString());
		report.add(report2);
		this.add(report);
		report.addSeparator();

		report3 = new JMenuItem(Constants.TOP_T_MENUITEM_REPORT3);
		report3.setFont(Constants.FONT_MENUBAR);
		report3.addActionListener(actionListener);
		report3.setActionCommand(Commands.C_REPORT3.toString());
		report.add(report3);
		this.add(report);
		report.addSeparator();

		report4 = new JMenuItem(Constants.TOP_T_MENUITEM_REPORT4);
		report4.setFont(Constants.FONT_MENUBAR);
		report4.addActionListener(actionListener);
		report4.setActionCommand(Commands.C_REPORT4.toString());
		report.add(report4);
		this.add(report);
		report.addSeparator();

		report5 = new JMenuItem(Constants.TOP_T_MENUITEM_REPORT5);
		report5.setFont(Constants.FONT_MENUBAR);
		report5.addActionListener(actionListener);
		report5.setActionCommand(Commands.C_REPORT5.toString());
		report.add(report5);
		this.add(report);
		report.addSeparator();

		report6 = new JMenuItem(Constants.TOP_T_MENUITEM_REPORT6);
		report6.setFont(Constants.FONT_MENUBAR);
		report6.addActionListener(actionListener);
		report6.setActionCommand(Commands.C_REPORT6.toString());
		report.add(report6);
		this.add(report);
		report.addSeparator();

		report7 = new JMenuItem(Constants.TOP_T_MENUITEM_REPORT7);
		report7.setFont(Constants.FONT_MENUBAR);
		report7.addActionListener(actionListener);
		report7.setActionCommand(Commands.C_REPORT7.toString());
		report.add(report7);
		this.add(report);
		report.addSeparator();
	}
}