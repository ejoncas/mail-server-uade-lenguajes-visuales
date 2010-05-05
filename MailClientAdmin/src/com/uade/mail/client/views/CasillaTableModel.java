package com.uade.mail.client.views;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import com.uade.mail.beans.Casilla;


public class CasillaTableModel extends AbstractTableModel{

	private String [] columnNames = {"Casilla","Dueño"};
	private Vector<Casilla> datalist = new Vector<Casilla>();
	
	
	public CasillaTableModel(){}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return this.datalist.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Casilla j = datalist.get(row);
		switch (col) {
		case 0:
			return j.getNombre();
		case 1:
			return j.getNombreDuenio();
		default:
			return null;
		}
	}
	
	@Override
	public String getColumnName(int col){
		return columnNames[col];
	}

	public Casilla getCasillAt(int row){
		return datalist.get(row);
	}

	public Casilla removeCasillaAt(int row){
		Casilla j = datalist.remove(row);
		fireTableDataChanged();
		return j;
	}

	public void addCasilla(Casilla w) {
		datalist.add(w);
		fireTableDataChanged();
	}

	public void addCasillaList(Vector<Casilla> l) {
		datalist.addAll(l);
		fireTableDataChanged();
	}

	
	
	public Vector<Casilla> getDatalist() {
		return datalist;
	}




}
