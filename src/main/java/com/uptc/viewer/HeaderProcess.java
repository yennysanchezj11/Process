package com.uptc.viewer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import com.uptc.controller.Commands;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class HeaderProcess extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextField CPUTime, processTime, nameProcess;
	private JLabel tittle;
	private JPanel tittlePanel, CPUPanel, dataProcess;
	private JButton saveButton, executeButton;
	private JCheckBox blockedProcess;
	
	public HeaderProcess(ActionListener actionListener) {
		super();
		this.tittlePanel = new JPanel();
		this.CPUPanel = new JPanel();
		this.dataProcess = new JPanel();
		this.initComponents(actionListener);
	}
	
	private void initComponents(ActionListener actionListener) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		tittlePanel.setBackground(Color.WHITE);
		tittlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		tittle = new JLabel();
		tittlePanel.add(Utilities.text(tittle, new Font("arial", Font.BOLD, 30), "Process", Color.BLACK));
		this.add(tittlePanel);
		
		CPUPanel.setBackground(Color.WHITE);
		CPUPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.CPUTime= new JTextField();
		CPUPanel.add(Utilities.textField(CPUTime, new Font("arial", Font.ITALIC, 15), "Ingresa el tiempo maximo de la CPU", Color.GRAY, 150, 70));
		this.add(CPUPanel);
		
		dataProcess.setLayout(new FlowLayout(FlowLayout.LEFT));
		dataProcess.setBackground(Color.WHITE);
		nameProcess = new JTextField();
		dataProcess.add(Utilities.textField(nameProcess, new Font("arial", Font.ITALIC, 15), "Ingresa el nombre del proceso", Color.GRAY, 150, 70));
		processTime= new JTextField();
		dataProcess.add(Utilities.textField(processTime, new Font("arial", Font.ITALIC, 15), "Ingresa el tiempo que el proceso requiere", Color.GRAY, 150, 70));
		blockedProcess = new JCheckBox();
		blockedProcess.setText("¿El proceso se bloqueara?");
		dataProcess.add(Utilities.checkBox(blockedProcess, new Font("arial", Font.ITALIC, 15), Color.GRAY, Color.WHITE, false));
		
		saveButton = new JButton();
		saveButton.addActionListener(actionListener);
		saveButton.setActionCommand(Commands.C_ADD_PROCESS.toString());
		dataProcess.add(Utilities.button(saveButton, new Dimension(100, 30), "Add"));
		this.add(dataProcess);

		executeButton = new JButton();
		executeButton.addActionListener(actionListener);
		executeButton.setActionCommand(Commands.C_EXECUTE_PROCESS.toString());
		dataProcess.add(Utilities.button(executeButton, new Dimension(100, 30), "Execute"));
		this.add(dataProcess);
	}

     public String getNameProcess(){
		 return nameProcess.getText();
	 }

	 public String getProcessTime(){
		return processTime.getText();
	 }

	 public Boolean getBlockedProcess(){
		return blockedProcess.isSelected();
	 }

	public int setTimeCPU() {
		return Integer.parseInt(CPUTime.getText());
	}

}