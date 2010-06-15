package com.uade.mail.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.uade.beans.entities.Casilla;
import com.uade.beans.entities.EstadoMail;
import com.uade.beans.entities.EstadosPosibles;
import com.uade.beans.entities.Mail;
import com.uade.beans.entities.OficinaDeCorreo;
import com.uade.beans.entities.Usuario;
import com.uade.beans.entities.UsuarioAdm;
import com.uade.mail.interfaces.MailService;
import com.uade.mail.utils.HibernateSession;

@SuppressWarnings("unchecked")	
public class MailServiceImpl extends UnicastRemoteObject implements MailService{
	
	/**
	 * STATIC 
	 */
	
	private static final long serialVersionUID = -210094816812915149L;
	
	
	/**
	 * Model
	 */
	
	
	protected MailServiceImpl() throws RemoteException {
		super();
	
	}
	
	@Override
	public void addTrustedLink(OficinaDeCorreo o1, OficinaDeCorreo o2)
			throws RemoteException {
		System.out.println("Method invocation [addTrustedLink]");

		//UPDATE
		EntityManager em = HibernateSession.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		{

			OficinaDeCorreo oficina1 = em.find(OficinaDeCorreo.class, o1.getId());
			OficinaDeCorreo oficina2 = em.find(OficinaDeCorreo.class, o2.getId());
			
			oficina1.addOficinaDeConfianza(oficina2);
			//Es bidireccional?
			//oficina2.addOficinaDeConfianza(oficina1);

			em.persist(oficina1);
			em.persist(oficina2);
		}
		tx.commit();
		
		
	}
	
	@Override
	public void deleteTrustedLink(OficinaDeCorreo o1, OficinaDeCorreo o2)
			throws RemoteException {
		System.out.println("Method invocation [deleteTrutedLink]");
		
		//UPDATE
		EntityManager em = HibernateSession.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		{

			OficinaDeCorreo oficina1 = em.find(OficinaDeCorreo.class, o1.getId());
			OficinaDeCorreo oficina2 = em.find(OficinaDeCorreo.class, o2.getId());
			
			oficina1.removeOficinaDeConfianza(oficina2);
			//Es bidireccional?
			//oficina2.removeOficinaDeConfianza(oficina1);

			em.persist(oficina1);
			em.persist(oficina2);
		}
		tx.commit();
		
		
	}

	@Override
	public void deleteAccount(Casilla c) throws RemoteException {
		System.out.println("Method invocation [deleteAccount]");
		//DELETE
		EntityManager em = HibernateSession.getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		{
			Casilla casillaAEliminar = em.find(Casilla.class, c.getId());
			//Remuevo el usuario si queda huerfano
			List<Casilla> casillasDeUsuario = this.getCasillasParaUsuario(casillaAEliminar.getInfoUsuario());
			if(casillasDeUsuario !=null){
				casillasDeUsuario.remove(casillaAEliminar);
				if(casillasDeUsuario.isEmpty())
					em.remove(casillaAEliminar.getInfoUsuario());
			}
			//Remuevo de las oficinas existentes este miembro
			List<OficinaDeCorreo> oficinasParaCasilla = this.getOficinasParaCasilla(casillaAEliminar);
			for(OficinaDeCorreo o : oficinasParaCasilla){
				o.removeCasillaMiembro(casillaAEliminar);
				em.persist(o);
			}
			
			//TODO - Cuando existan mails y bloqueados hay que modificar las referencias
			
			em.remove(casillaAEliminar);
		}
		t.commit();

	}

	@Override
	public void deleteOffice(OficinaDeCorreo o) throws RemoteException {
		System.out.println("Method invocation [deleteOffice]");
		//DELETE
		EntityManager em = HibernateSession.getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		{
			OficinaDeCorreo oficinaAEliminar = em.find(OficinaDeCorreo.class, o.getId());
			em.remove(oficinaAEliminar);
			
		}
		t.commit();

	}

	@Override
	public void modifAccout(Casilla c) throws RemoteException {
		System.out.println("Method invocation [modifAccount]");
		//UPDATE
		EntityManager em = HibernateSession.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		{
			Casilla casillaAModificar = em.find(Casilla.class, c.getId());
			//casillaAModificar.setPassword(p);//No cambiamos la password - para eso utilizamos el metodo modifpassword
			casillaAModificar.setBloqueados(c.getBloqueados());
			casillaAModificar.setInbox(c.getInbox());
			casillaAModificar.setInfoUsuario(c.getInfoUsuario());
			casillaAModificar.setNombre(c.getNombre());
			em.persist(casillaAModificar);
		}
		tx.commit();

	}

	@Override
	public void modifOffice(OficinaDeCorreo o) throws RemoteException {
		System.out.println("Method invocation [modifOffice]");
		//UPDATE
		EntityManager em = HibernateSession.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		{
			OficinaDeCorreo oficinaAModificar = em.find(OficinaDeCorreo.class, o.getId());
			oficinaAModificar.setCasillasMiembro(o.getCasillasMiembro());
			oficinaAModificar.setNombreOficina(o.getNombreOficina());
			//Estas se editan desde la seccion "Editar Trusted Links"
			//oficinaAModificar.setOficinasDeConfianza(o.getOficinasDeConfianza());
			em.persist(oficinaAModificar);
		}
		tx.commit();
	}

	@Override
	public void modifPassword(Casilla c, String p) throws RemoteException {
		System.out.println("Method invocation [modifPassword]");
		//UPDATE
		EntityManager em = HibernateSession.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		{
			Casilla casillaAModificar = em.find(Casilla.class, c.getId());
			casillaAModificar.setPassword(p);
			em.persist(casillaAModificar);
		}
		tx.commit();
	}

	@Override
	public void newAccout(Casilla c) throws RemoteException {
		System.out.println("Method invocation [newAccount]");
		
		EntityManager em = HibernateSession.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		{
			//Sergio: BUG: Si no hay usuarios, la aplicacion pincha porque da un
			//nullpointer exception. hay que implementar algo que si no existen
			//usuarios, no ejecute este punto.
			
			Usuario infoUsuario = em.find(Usuario.class, c.getInfoUsuario().getId());
			c.setInfoUsuario(infoUsuario);
			em.persist(c);
		}
		tx.commit();
	}

	@Override
	public void newOffice(OficinaDeCorreo o) throws RemoteException {
		System.out.println("Method invocation [newOffice]");
		//INSERT
		EntityManager em = HibernateSession.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		{
			em.persist(o);
		}
		tx.commit();
		
	}

	@Override
	public void sendEmail(Mail m) throws RemoteException {
		System.out.println("Method invocation [sendEmail]");
		//TODO - Para interfaz web
		//SEND MAIL
		Casilla from = m.getFrom();
		Casilla to = m.getTo();
		EstadoMail estado1 = new EstadoMail();
		estado1.setMail(m);
		estado1.setEstado(EstadosPosibles.SENT);
		EstadoMail estado2 = new EstadoMail();
		estado2.setMail(m);
		estado2.setEstado(EstadosPosibles.UNREAD);
		
		from.getInbox().add(estado1);
		to.getInbox().add(estado2);
		
		LogMensajes.getInstance().addMessage(m);
	}

	@Override
	public List<Mail> updateInbox(Casilla c) throws RemoteException {
		System.out.println("Method invocation [updateInbox]");
		return null;
	}

	@Override
	public List<Casilla> getContacts(Casilla c) throws RemoteException {
		System.out.println("Method invocation [getContacts]");
		EntityManager em = HibernateSession.getEntityManager();
		Query query = em.createQuery("SELECT c from Casilla c");
		List<Casilla> casillas= query.getResultList();
		//Filtrar las casillas a las que le puede mandar mensajes
		List<Casilla> r = new ArrayList<Casilla>();
		//Oficinas a las que pertenece
		List<OficinaDeCorreo> oficinas = this.getOficinasParaCasilla(c);
		
		for(Casilla casilla : casillas){
			if(!casilla.getBloqueados().contains(c)){//Si no lo tienen bloqueado
				for(OficinaDeCorreo o: oficinas){
					if(o.getCasillasMiembro().contains(casilla))//SI pertenece a alguna de sus oficinas
						r.add(casilla);
					//TODO - Verificar Vinculos de Confianza
				}
			}
		}
		
		return null;
	}
	
	private List<OficinaDeCorreo> getOficinasParaCasilla(Casilla c){//Devuelve todas las oficinas de confianza donde se encuentra la casilla
		List<OficinaDeCorreo> r = new ArrayList<OficinaDeCorreo>();
		List<OficinaDeCorreo> todas;
		EntityManager em = HibernateSession.getEntityManager();
		Query query = em.createQuery("SELECT o from OficinaDeCorreo o");
		todas= query.getResultList();
		for(OficinaDeCorreo o : todas){
			if(o.getCasillasMiembro().contains(c))
				r.add(o);
		}
		return r;
	}

	private List<Casilla> getCasillasParaUsuario(Usuario u) {
		List<Casilla> r = new ArrayList<Casilla>();
		List<Casilla> todas=null;
		EntityManager em = HibernateSession.getEntityManager();
		Query query = em.createQuery("SELECT c from Casilla c");
		todas= query.getResultList();
		for(Casilla o : todas){
			if(o.getInfoUsuario().getId().equals(u.getId()))
				r.add(o);
		}
		return r;
	}

	@Override
	public List<Casilla> getAllAccounts() throws RemoteException {
		System.out.println("Method invocation [getAllAccounts]");
		//SELECT
		EntityManager em = HibernateSession.getEntityManager();
		Query query = em.createQuery("SELECT c from Casilla c");
		List<Casilla> casillas= query.getResultList();
		return casillas;
	}

	@Override
	public List<OficinaDeCorreo> getAllOfices() throws RemoteException {
		System.out.println("Method invocation [getAllOfices]");
		//SELECT
		EntityManager em = HibernateSession.getEntityManager();
		Query query = em.createQuery("SELECT o from OficinaDeCorreo o");
		List<OficinaDeCorreo> oficinas = query.getResultList();
		return oficinas;
	}

	@Override
	public void addNewUser(Usuario user) throws RemoteException {
		System.out.println("Method invocation [addNewUser]");
		EntityManager em = HibernateSession.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		{
			
			em.persist(user);
		}
		tx.commit();
	}

	@Override
	public List<Usuario> getAllUsers() throws RemoteException {
		System.out.println("Method invocation [getAllUsers]");
		//SELECT
		EntityManager em = HibernateSession.getEntityManager();
		Query query = em.createQuery("SELECT u from Usuario u");
		List<Usuario> usuarios = query.getResultList();
		return usuarios;
	}

	@Override
	public void modifUser(Usuario user) throws RemoteException {
		System.out.println("Method invocation [modifUser]");
		//UPDATE
		EntityManager em = HibernateSession.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		{
			Usuario usuarioAModificar = em.find(Usuario.class, user.getId());
			usuarioAModificar.setApellido(user.getApellido());
			usuarioAModificar.setDireccion(user.getDireccion());
			usuarioAModificar.setDni(user.getDni());
			usuarioAModificar.setNombre(user.getNombre());
			em.persist(usuarioAModificar);
		}
		tx.commit();
		
	}

	@Override
	public void removeUser(Usuario user) throws RemoteException {
		System.out.println("Method invocation [removeUser]");
		//DELETE
		EntityManager em = HibernateSession.getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		{
			Usuario usuarioAEliminar = em.find(Usuario.class, user.getId());
			em.remove(usuarioAEliminar);
		}
		t.commit();
	}

	@Override
	public List<OficinaDeCorreo> getTrustedOffices(OficinaDeCorreo o)
			throws RemoteException {
		//SELECT
		EntityManager em = HibernateSession.getEntityManager();
		EntityTransaction t = em.getTransaction();
		List<OficinaDeCorreo> oficinas=new ArrayList<OficinaDeCorreo>();
		t.begin();
		{
			OficinaDeCorreo oficina = em.find(OficinaDeCorreo.class, o.getId());
			List<OficinaDeCorreo> todas =  this.getAllOfices();
			for(OficinaDeCorreo of : todas)
				if(oficina.getOficinasDeConfianza().contains(of))
					oficinas.add(of);
		}
		t.commit();
		return oficinas;
	}

	@Override
	public void clearTrustedLink(OficinaDeCorreo o) throws RemoteException{
		//DELETE
		EntityManager em = HibernateSession.getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		{
			OficinaDeCorreo oficinaAModificar = em.find(OficinaDeCorreo.class, o.getId());
			List<OficinaDeCorreo> aEliminar = oficinaAModificar.getOficinasDeConfianza();
			oficinaAModificar.getOficinasDeConfianza().removeAll(aEliminar);
			em.persist(oficinaAModificar);
		}
		t.commit();
	}


	@Override
	public Casilla loginAccount(String usuario, String password)
			throws RemoteException {
		//SELECT
		try{
			EntityManager em = HibernateSession.getEntityManager();
			Query query = em.createQuery("SELECT c from Casilla c");
			List<Casilla> casillas = query.getResultList();
			for(Casilla c : casillas)
				if(c.getNombre().equalsIgnoreCase(usuario) && c.getPassword().equalsIgnoreCase(password))
					return c;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean validoUsuarioAdm(String username, String claveMD5)	throws RemoteException {
		System.out.println("Method invocation [validoUsuarioAdm]");
		
		UsuarioAdm usuarioAValidar,usuarioValidado;
		
		usuarioAValidar= new UsuarioAdm();
		usuarioAValidar.setUsername(username);
		usuarioAValidar.setPassword(claveMD5);
		
		//VALIDO
		EntityManager em = HibernateSession.getEntityManager();
		Query query = em.createQuery("SELECT u FROM UsuarioAdm u WHERE username='"+username+"'");
		
		usuarioValidado = (UsuarioAdm) query.getSingleResult();
		
		if(usuarioAValidar.getPassword().equals(usuarioValidado.getPassword())){
			return true;
		}else
		{
			return false;
		}
	}

	@Override
	public void newUserAdmin(UsuarioAdm u) throws RemoteException {
		System.out.println("Method invocation [newUserAdmin]");
		
		EntityManager em = HibernateSession.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		{
			em.persist(u);
		}
		tx.commit();
	}
		
}

