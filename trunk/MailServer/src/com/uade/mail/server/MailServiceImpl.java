package com.uade.mail.server;

import java.util.*;

import com.uade.mail.beans.Casilla;
import com.uade.mail.beans.Mail;
import com.uade.mail.beans.OficinaDeCorreo;
import com.uade.mail.exceptions.MailServiceException;
import com.uade.mail.interfaces.MailService;

public class MailServiceImpl implements MailService{

	private static String SERVER_DOMAIN = "lenguajes.edu.ar";
	private static int MAX_CHARACTERS = 20;
	
	
	@Override
	public void addTrustedLink(OficinaDeCorreo o1, OficinaDeCorreo o2)
			throws MailServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAccount(Casilla c) throws MailServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOffice(OficinaDeCorreo o) throws MailServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTrustedLink(OficinaDeCorreo o1, OficinaDeCorreo o2)
			throws MailServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifAccout(Casilla c) throws MailServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifOffice(OficinaDeCorreo o) throws MailServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifPassword(Casilla c, String p) throws MailServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void newAccout(Casilla c) throws MailServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void newOffice(OficinaDeCorreo o) throws MailServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendEmail(Mail m) throws MailServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Mail> updateInbox(Casilla c) throws MailServiceException {
		// TODO Auto-generated method stub
		return null;
	}
	


	
	
}
