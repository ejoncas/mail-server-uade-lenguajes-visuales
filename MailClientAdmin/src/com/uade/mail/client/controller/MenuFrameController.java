package com.uade.mail.client.controller;

import javax.swing.JFrame;

import com.uade.mail.client.main.MailClient;
import com.uade.mail.client.views.MenuFrame;
import com.uade.mail.interfaces.MailService;

public class MenuFrameController {
	
	public MailService model;
	public MenuFrame frame;
	
	public MenuFrameController(){
		model = MailClient.getInstance().getServiceInterface();
		frame = new MenuFrame(new JFrame());
	}

	
	
}
