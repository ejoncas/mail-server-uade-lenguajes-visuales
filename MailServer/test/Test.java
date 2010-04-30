import com.uade.mail.beans.Casilla;
import com.uade.mail.beans.Mail;
import com.uade.mail.server.LogMensajes;

import junit.framework.TestCase;


public class Test extends TestCase{
	
	public void testLog(){
		Mail m = new Mail();
		Casilla c1 = new Casilla();
		c1.setNombre("joncas@arnet.com.ar");
		Casilla c2 = new Casilla();
		c2.setNombre("lalala@lalal.com");
		
		m.setFrom(c1);
		m.setTo(c2);
		m.setSubject("sujeto 1");
		m.setMessage("Hola que tal la puta madre que peola anda esto");
		
		System.out.println(m.toString());
		LogMensajes.getInstance().addMessage(m);
	}

}
