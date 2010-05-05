package com.uade.mail.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncrypt {
	
	public static String generateMD5(String p){
		MessageDigest m;
		String md5=null;
		try {
			m = MessageDigest.getInstance("MD5");
		    m.update(p.getBytes(),0,p.length());
		    md5 = new BigInteger(1,m.digest()).toString(16);
		    System.out.println("MD5: "+md5);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("No se pudo crear la contraseña en MD5");
			e.printStackTrace();
		}
		return md5;
	}

}
