package com.uade.mail.client.views;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import com.uade.mail.beans.Casilla;
import com.uade.mail.beans.OficinaDeCorreo;

public class CentroTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2653781189034583870L;
	private String[] columnNames = { "Nombre Oficina", "Casillas Miembro",
			"Oficinas de Confianza" };
	private Vector<OficinaDeCorreo> datalist = new Vector<OficinaDeCorreo>();

	public CentroTableModel() {
	}

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
		OficinaDeCorreo j = datalist.get(row);
		switch (col) {
		case 0:
			return j.getNombreOficina();
		case 1:
			String r="";
			for(Casilla c: j.getCasillasMiembro())
				r+=c.getNombre()+"|";
			return r;
		case 2:
			String or="";
			for(OficinaDeCorreo o: j.getOficinasDeConfianza())
				or+=o.getNombreOficina()+"|";
			return or;
		default:
			return null;
		}
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	public OficinaDeCorreo getOficinaDeCorreoAt(int row) {
		return datalist.get(row);
	}

	public OficinaDeCorreo removeOficinaDeCorreoAt(int row) {
		OficinaDeCorreo j = datalist.remove(row);
		fireTableDataChanged();
		return j;
	}

	public void addOficinaDeCorreo(OficinaDeCorreo w) {
		datalist.add(w);
		fireTableDataChanged();
	}

	public void addOficinaDeCorreoList(List<OficinaDeCorreo> l) {
		datalist.addAll(l);
		fireTableDataChanged();
	}

	public Vector<OficinaDeCorreo> getDatalist() {
		return datalist;
	}

}
