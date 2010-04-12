package com.uade.mail.server;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import com.uade.mail.beans.Mail;

public class LogMensajes {

	private StringBuffer log;
	private SimpleDateFormat formatter;
	private String logPath;
	private static LogMensajes instance=null;
		
	//Private Constructor
	private LogMensajes(){
		PropertiesConfiguration conf=null;
		try {
			conf = new PropertiesConfiguration("config.properties");
		} catch (ConfigurationException e) {
			System.out.println("No se pudo cargar la configuracion");
			e.printStackTrace();
		}
		this.log = new StringBuffer();
		this.formatter = new SimpleDateFormat(conf.getString("mail.log.dateformat","yyyyMMdd"));
		this.logPath = conf.getString("mail.log.path","");
	}
	
	//SINGLETON
	public static LogMensajes getInstance(){
		if(instance==null)
			instance = new LogMensajes();
		return instance;
			
	}

	public StringBuffer getLog() {
		return log;
	}
	
	public void addMessage(Mail m){
		this.log.append("\n["+this.formatter.format(new Date())+"] - Sending Message:"+m.toString());
	}

	public void setLog(StringBuffer log) {
		this.log = log;
	}
	
	
	
	
}
