package com.uade.web.util;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import com.uade.beans.entities.Casilla;
import com.uade.beans.entities.EstadosPosibles;
import com.uade.mail.beans.MailVO;
import com.uade.mail.interfaces.MailService;

public class JSPHelper {
	private static MailService model;
	
	public static List<MailVO> getListaEnviados(Casilla c){
		
		model = (MailService) AccesoRMI.getInstance().getServiceInterface();
		List<MailVO> mailsEnviados = new ArrayList<MailVO>();
		try {
			mailsEnviados = model.updateInbox(c, EstadosPosibles.SENT);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return mailsEnviados;
	}
	
	
	public static List<MailVO> getListEliminados(Casilla c){
		model = (MailService) AccesoRMI.getInstance().getServiceInterface();
		List<MailVO> mailsEliminados= new ArrayList<MailVO>();
		try {
			mailsEliminados = model.updateInbox(c, EstadosPosibles.TRASH);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return mailsEliminados;
	}
}
