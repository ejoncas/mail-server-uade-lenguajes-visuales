package com.uade.mail.server;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import com.uade.mail.beans.Mail;

public class LogMensajes {

	private StringBuffer log;
	private File logFile;
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
		this.logFile = new File(this.logPath);
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
		String msg = "\n["+this.formatter.format(new Date())+"] - Sending Message:"+m.toString();
		FileWriter writer;
		try {
			System.out.println("Grabando mensaje en el log");
			boolean append = true;
			writer = new FileWriter(this.logFile,append);
			writer.append(msg);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			System.out.println("No se pudo escribir el log");
			e.printStackTrace();
		}
	}

	public void setLog(StringBuffer log) {
		this.log = log;
	}
	
}
