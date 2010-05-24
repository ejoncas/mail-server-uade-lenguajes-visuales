import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import junit.framework.TestCase;

import com.uade.beans.entities.Casilla;
import com.uade.beans.entities.EstadosPosibles;
import com.uade.beans.entities.EstadoMail;
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
		
		Casilla c2 = new Casilla();
		c2.setInfoUsuario(u);
		c2.setNombre("ejoncas3@lenguajes.edu.ar");
		c2.setPassword(PasswordEncrypt.generateMD5("1234"));
		
		
		List<Casilla> bloqueadosc  = new ArrayList<Casilla>();
		bloqueadosc.add(c2);
		bloqueadosc.add(c1);
		
		c.setBloqueados(bloqueadosc);
		
		
		Mail m = new Mail();
		m.setFrom(c);
		m.setTo(c1);
		m.setMessage("Hola como va?");
		m.setSubject("Como va?");
		
		EstadoMail i = new EstadoMail();
		i.setMail(m);
		i.setEstado(EstadosPosibles.READ);
		
		EstadoMail i1 = new EstadoMail();
		i1.setMail(m);
		i1.setEstado(EstadosPosibles.UNREAD);
		
		ArrayList<EstadoMail> lista = new ArrayList<EstadoMail>();
		lista.add(i);
		
		ArrayList<EstadoMail> lista2 = new ArrayList<EstadoMail>();
		lista.add(i1);
		
		c.setInbox(lista);
		c.setInbox(lista2);
		
		
		EntityManager em = HibernateUtils.getEntityManager();
		
		EntityTransaction t = em.getTransaction();
		
		//Transaccion que persiste todo lo creado
		t.begin();
		{
			em.persist(u);
			em.persist(m);
			em.persist(i);
			em.persist(i1);
			em.persist(c1);
			em.persist(c2);
			em.persist(c);
		}
		t.commit();
		
	}

}
