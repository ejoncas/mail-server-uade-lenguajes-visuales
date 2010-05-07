import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.uade.mail.beans.Casilla;
import com.uade.mail.beans.Mail;
import com.uade.mail.interfaces.MailService;
import com.uade.mail.server.LogMensajes;
import com.uade.mail.server.MailServer;
import com.uade.mail.server.MailServiceImpl;

import junit.framework.TestCase;


public class Test extends TestCase{
	
	public void testLog(){
		
		Casilla c1 = new Casilla();
		c1.setNombre("joncas@arnet.com.ar");
		Casilla c2 = new Casilla();
		c2.setNombre("lalala@lalal.com");
		Mail m = new Mail();
		m.setFrom(c1);
		m.setTo(c2);
		m.setSubject("sujeto 1");
		m.setMessage("Hola que tal la puta madre que peola anda esto");
		
		System.out.println(m.toString());
		LogMensajes.getInstance().addMessage(m);
	}

	public void testSendMail(){
		MailService serviceInterface;
		try {
			serviceInterface = (MailService) Naming.lookup(MailServer.SERVICE_URL);
			
			
			Casilla c1 = new Casilla();
			c1.setNombre("joncas@arnet.com.ar");
			Casilla c2 = new Casilla();
			c2.setNombre("lalala@lalal.com");
			
			Mail m = new Mail();
			m.setFrom(c1);
			m.setTo(c2);
			m.setSubject("Llamado desde la interfaz");
			m.setMessage("Probando la interfaz");
			
			serviceInterface.newAccout(c1);
			serviceInterface.newAccout(c2);
			serviceInterface.sendEmail(m);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}
