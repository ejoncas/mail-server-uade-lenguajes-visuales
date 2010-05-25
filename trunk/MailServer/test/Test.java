import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import junit.framework.TestCase;

import com.uade.beans.entities.Casilla;
import com.uade.beans.entities.Mail;
import com.uade.beans.entities.OficinaDeCorreo;
import com.uade.mail.interfaces.MailService;
import com.uade.mail.server.LogMensajes;
import com.uade.mail.server.MailServer;


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
			Casilla c2 = new Casilla();
			Casilla c3 = new Casilla();
			c1.setNombre("cuenta1@"+Casilla.SERVER_DOMAIN);
			c2.setNombre("cuenta2@"+Casilla.SERVER_DOMAIN);
			c3.setNombre("cuenta3@"+Casilla.SERVER_DOMAIN);
			
			
			OficinaDeCorreo o1 = new OficinaDeCorreo();
			OficinaDeCorreo o2 = new OficinaDeCorreo();
			o1.setNombreOficina("Oficina Loca 1");
			o2.setNombreOficina("Oficina Uade");
			
			o1.addCasillaMiembro(c1);
			o2.addCasillaMiembro(c1);
			o2.addCasillaMiembro(c2);
			o2.addCasillaMiembro(c3);
			
			
			Mail m = new Mail();
			m.setFrom(c1);
			m.setTo(c2);
			m.setSubject("Llamado desde la interfaz");
			m.setMessage("Probando la interfaz");
			
			serviceInterface.newAccout(c1);
			serviceInterface.newAccout(c2);
			serviceInterface.sendEmail(m);
			
			serviceInterface.newAccout(c1);
			serviceInterface.newAccout(c2);
			serviceInterface.newAccout(c3);
			
			serviceInterface.newOffice(o1);
			serviceInterface.newOffice(o2);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}
