package com.uptc.viewer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class JTableData extends JPanel {

	private static final long serialVersionUID = 1L;
	private DefaultTableModel dtmElements;

	public DefaultTableModel getDtmElements() {
		return dtmElements;
	}

	public void setDtmElements(DefaultTableModel dtmElements) {
		this.dtmElements = dtmElements;
	}

	private JTable jtElements;
	private JScrollPane jsTable;

	public JTableData() {
		initComponents();
	}

	private void initComponents() {
		String[] headers = { "ID","FECHA CONSULTA", "CAUSA EXTERNA", "EDAD(AÑOS)", "SEXO", "DESCRIPCION", "ESPECIALIDAD",
				"NOMBRE DIAGNOSTICO", "TIPO DIAGNOSTICO", "RESPONSABLE DE PAGO", "TIPO DE CONTRATO", "DEPARTAMENTO",
				"CIUDAD", "ESTADO CIVIL", "NIVEL EDUCATIVO" };
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBackground(Color.decode("#30373D"));
		dtmElements = new DefaultTableModel();
		dtmElements.setColumnIdentifiers(headers);
		jtElements = new JTable();
		jtElements.setModel(dtmElements);
		jtElements.getTableHeader().setResizingAllowed(false);
		jtElements.getTableHeader().setReorderingAllowed(false);
		jtElements.getTableHeader().setBackground(Constants.DATA_PANEL_HEADERS_TABLE_COLOR);
		jtElements.getTableHeader().setPreferredSize(new Dimension(0, 60));
		jtElements.getTableHeader().setForeground(Color.BLACK);
		jtElements.getTableHeader().setFont(Constants.DATA_PANEL_HEADERS_TABLE_FONT);
		jtElements.setBackground(Color.WHITE);
		jtElements.setFont(Constants.DATA_PANEL_HEADERS_TABLE_FONT);
		jtElements.setFillsViewportHeight(true);
		jtElements.setRowHeight(50);
		jtElements.setBorder(null);
		this.centerTextInCell();
		jsTable = new JScrollPane(jtElements, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsTable.setForeground(Color.RED);
		jsTable.setBorder(null);
		jsTable.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.add(jsTable, BorderLayout.PAGE_END);
		this.setBorder(null);

	}

	public void addElementToTable(ArrayList<Object[]> datasList) {
		for (Object[] datasObject : datasList) {
			dtmElements.addRow(datasObject);
		}
	}

	public void cleanRowsTable() {
		dtmElements.setNumRows(0);
	}

	private void centerTextInCell() {
		DefaultTableCellRenderer centerModel = new DefaultTableCellRenderer();
		centerModel.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < dtmElements.getColumnCount(); i++) {
			jtElements.getColumnModel().getColumn(i).setCellRenderer(centerModel);
		}
	}
}