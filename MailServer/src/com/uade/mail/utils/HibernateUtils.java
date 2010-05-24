package com.uade.mail.utils;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class HibernateUtils {
	
	public static EntityManager getEntityManager(){
		return Persistence.createEntityManagerFactory("mail-server").createEntityManager();
	}

}
