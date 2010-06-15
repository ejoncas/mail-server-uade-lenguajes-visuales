package com.uade.mail.client.controller;

import java.rmi.RemoteException;
import java.util.List;
import com.uade.beans.entities.OficinaDeCorreo;
import com.uade.mail.client.main.MailClient;

/**
 * Esta clase fue creada ya que el @FetchType.EAGER no funciona en la relacion Oficinas - Oficinas porque sería recursivo (?)
 * No esta bien, pero por el momento lo solucioné asi, tengo que preguntarle a Julián como puedo hacer un value Object que vaya al server
 * cuando necesite las oficinas de confianza.
 * @author jonatan
 *
 */

public class RMIHelper{

	
	public static List<OficinaDeCorreo> getOficinasDeConfianza(OficinaDeCorreo o){
		try {
			return MailClient.getInstance().getServiceInterface().getTrustedOffices(o);
		} catch (RemoteException e) {
			System.out.println("No se pudo obtenr las oficinas de confianza");
			e.printStackTrace();
			return null;
		}
	}
}
