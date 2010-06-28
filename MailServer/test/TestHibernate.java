import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import junit.framework.TestCase;

import com.uade.beans.entities.Casilla;
import com.uade.beans.entities.EstadoMail;
import com.uade.beans.entities.EstadosPosibles;
import com.uade.beans.entities.Mail;
import com.uade.beans.entities.OficinaDeCorreo;
import com.uade.beans.entities.Usuario;
import com.uade.mail.utils.HibernateSession;
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
		//m.setTo(c1);
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
		lista2.add(i1);
		
		c.setInbox(lista);
		c2.setInbox(lista2);
		
		OficinaDeCorreo o1 = new OficinaDeCorreo();
		o1.setNombreOficina("Oficina de Correo 1");
		
		OficinaDeCorreo o2 = new OficinaDeCorreo();
		o2.setNombreOficina("Oficina de Correo 2");
		
		OficinaDeCorreo o3 = new OficinaDeCorreo();
		o3.setNombreOficina("Oficina de Correo 3");
		
		List<Casilla> miembros1 = new ArrayList<Casilla>();//todos
		miembros1.add(c);
		miembros1.add(c1);
		miembros1.add(c2);
		List<Casilla> miembros2 = new ArrayList<Casilla>();//solo c1
		miembros2.add(c1);
		List<Casilla> miembros3 = new ArrayList<Casilla>();//c1 y c2
		miembros3.add(c1);
		miembros3.add(c2);
		
		o1.setCasillasMiembro(miembros1);
		o2.setCasillasMiembro(miembros2);
		o3.setCasillasMiembro(miembros3);
		
		List<OficinaDeCorreo> confianza1 = new ArrayList<OficinaDeCorreo>();
		confianza1.add(o2);
		confianza1.add(o3);
		
		o1.setOficinasDeConfianza(confianza1);
		
		
		EntityManager em = HibernateSession.getEntityManager();
		
		EntityTransaction t = em.getTransaction();
		
		//Transaccion que persiste todo lo creado
		t.begin();
		{
			em.persist(u);
			em.persist(m);

			em.persist(c1);
			em.persist(c2);
			em.persist(c);
			
			em.persist(i);
			em.persist(i1);
			
			em.persist(o1);
			em.persist(o2);
			em.persist(o3);
		}
		t.commit();
		
		Query query = em.createQuery("SELECT c from Casilla c");
		
		List<Casilla> casillas = query.getResultList();
		for(Casilla cselect : casillas)
			System.out.println(cselect.toString());
		
	}
	

}
