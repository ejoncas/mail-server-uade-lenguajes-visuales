import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import junit.framework.TestCase;


public class TestMD5 extends TestCase{
	
	public void testMd5(){
		String s="lala1234";
	    MessageDigest m;
		try {
			m = MessageDigest.getInstance("MD5");
		    m.update(s.getBytes(),0,s.length());
		    System.out.println("MD5: "+new BigInteger(1,m.digest()).toString(16));
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}
	}

}
