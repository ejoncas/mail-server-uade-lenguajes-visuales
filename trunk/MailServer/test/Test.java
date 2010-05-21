import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.uade.mail.beans.CasillaVO;
import com.uade.mail.beans.MailVO;
import com.uade.mail.beans.OficinaDeCorreoVO;
import com.uade.mail.interfaces.MailService;
import com.uade.mail.server.LogMensajes;
import com.uade.mail.server.MailServer;
import com.uade.mail.server.MailServiceImpl;

import junit.framework.TestCase;


public class Test extends TestCase{
	
	public void testLog(){
		
		CasillaVO c1 = new CasillaVO();
		c1.setNombre("joncas@arnet.com.ar");
		CasillaVO c2 = new CasillaVO();
		c2.setNombre("lalala@lalal.com");
		MailVO m = new MailVO();
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
			
			
			
			
			CasillaVO c1 = new CasillaVO();
			CasillaVO c2 = new CasillaVO();
			CasillaVO c3 = new CasillaVO();
			c1.setNombre("cuenta1@"+CasillaVO.SERVER_DOMAIN);
			c2.setNombre("cuenta2@"+CasillaVO.SERVER_DOMAIN);
			c3.setNombre("cuenta3@"+CasillaVO.SERVER_DOMAIN);
			
			
			OficinaDeCorreoVO o1 = new OficinaDeCorreoVO();
			OficinaDeCorreoVO o2 = new OficinaDeCorreoVO();
			o1.setNombreOficina("Oficina Loca 1");
			o2.setNombreOficina("Oficina Uade");
			
			o1.addCasillaMiembro(c1);
			o2.addCasillaMiembro(c1);
			o2.addCasillaMiembro(c2);
			o2.addCasillaMiembro(c3);
			
			
			MailVO m = new MailVO();
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
