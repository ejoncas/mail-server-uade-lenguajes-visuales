
import com.uade.mail.utils.PasswordEncrypt;

import junit.framework.TestCase;


public class TestMD5 extends TestCase{
	
	public void testMd5(){
		PasswordEncrypt.generateMD5("lala12341");
		
	}

}
