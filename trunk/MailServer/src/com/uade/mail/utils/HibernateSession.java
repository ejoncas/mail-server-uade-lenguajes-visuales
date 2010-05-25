package com.uade.mail.utils;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class HibernateSession {
	
	private static EntityManager em = null;
	
	//Singleton
	public static EntityManager getEntityManager(){
		if(em==null)
			em = Persistence.createEntityManagerFactory("mail-server").createEntityManager();
		return em;
	}
	
	public static void close(){
		if(em!=null)
			em.close();
		em=null;
	}

}
