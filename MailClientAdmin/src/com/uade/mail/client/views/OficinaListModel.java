package com.uade.mail.client.views;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.event.ListDataListener;

import com.uade.beans.entities.OficinaDeCorreo;

public class OficinaListModel extends AbstractListModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4264614789882968034L;
	ArrayList<OficinaDeCorreo> datalist = new ArrayList<OficinaDeCorreo>();
	
	public OficinaListModel(Collection<OficinaDeCorreo> oficinas){
		datalist.addAll(oficinas);
	}
	
	@Override
	public void addListDataListener(ListDataListener arg0) {
	}

	public void addOficinaDeCorreo(OficinaDeCorreo o){
		datalist.add(o);
		fireContentsChanged(datalist, 0, datalist.size());
	}
	@Override
	public Object getElementAt(int arg0) {
		return datalist.get(arg0);
	}

	@Override
	public int getSize() {
		return datalist.size();
	}

	@Override
	public void removeListDataListener(ListDataListener arg0) {
	}

	public void delOficinaDeCorreo(OficinaDeCorreo oficinaSeleccionada) {
		this.datalist.remove(oficinaSeleccionada);
	}
	
	public List<OficinaDeCorreo> getDatalist(){
		return this.datalist;
	}

}
