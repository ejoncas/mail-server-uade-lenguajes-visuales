import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import junit.framework.TestCase;

import com.uade.beans.entities.Casilla;
import com.uade.beans.entities.Estado;
import com.uade.beans.entities.Inbox;
import com.uade.beans.entities.Mail;
import com.uade.beans.entities.Usuario;
import com.uade.mail.utils.HibernateUtils;
import com.uade.mail.utils.PasswordEncrypt;


public class TestHibernate extends TestCase{
	
	public void testPersistence(){
		
		Usuario u = new Usuario();
		u.setNombre("Jonatan");
		u.setApellido("Castro");
		u.setDni("23344555");
		u.setDireccion("a la vuelta");
		
		Casilla c = new Casilla();
		c.setInfoUsuario(u);
		c.setNombre("ejoncas@lenguajes.edu.ar");
		c.setPassword(PasswordEncrypt.generateMD5("1234"));
		
		
		Casilla c1 = new Casilla();
		c1.setInfoUsuario(u);
		c1.setNombre("ejoncas2@lenguajes.edu.ar");
		c1.setPassword(PasswordEncrypt.generateMD5("1234"));
		
		Mail m = new Mail();
		m.setFrom(c);
		m.setTo(c1);
		m.setMessage("Hola como va?");
		m.setSubject("Como va?");
		
		Inbox i = new Inbox();
		HashMap<Mail, String> inbox = new HashMap<Mail, String>();
		
		inbox.put(m, Estado.UNREAD);
		i.setEstadoInbox(inbox);
		
		Inbox i1 = new Inbox();
		HashMap<Mail, String> inbox1 = new HashMap<Mail, String>();
		inbox.put(m, Estado.SENT);
		i1.setEstadoInbox(inbox1);
		
		c.setInbox(i1);
		c.setInbox(i);
		
		
		EntityManager em = HibernateUtils.getEntityManager();
		
		EntityTransaction t = em.getTransaction();
		
		//Transaccion que persiste todo lo creado
		t.begin();
		{
			em.persist(u);
			em.persist(c);
			em.persist(c1);
			em.persist(m);
			em.persist(i1);
			em.persist(i);
		}
		t.commit();
		
	}

}
