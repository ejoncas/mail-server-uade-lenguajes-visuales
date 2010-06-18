package com.uade.mail.client.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import com.uade.beans.entities.Casilla;
import com.uade.beans.entities.OficinaDeCorreo;
import com.uade.beans.entities.Usuario;
import com.uade.beans.entities.UsuarioAdm;
import com.uade.mail.client.main.MailClient;
import com.uade.mail.client.views.MenuFrame;
import com.uade.mail.interfaces.MailService;
import com.uade.mail.utils.PasswordEncrypt;

public class MenuFrameController {

	private MailService model;
	private MenuFrame frame;

	public MenuFrameController() {
		model = MailClient.getInstance().getServiceInterface();
		frame = new MenuFrame(this);
	}

	public MailService getModel() {
		return model;
	}

	public void setModel(MailService model) {
		this.model = model;
	}

	public MenuFrame getFrame() {
		return frame;
	}

	public void setFrame(MenuFrame frame) {
		this.frame = frame;
	}

	public List<Casilla> getAccounts() {
		try {
			return this.model.getAllAccounts();
		} catch (RemoteException e) {
			e.printStackTrace();
			System.out.println("No se pudo obtener todas las casillas");
			return null;
		}
	}

	public List<OficinaDeCorreo> getOffices() {
		try {
			List<OficinaDeCorreo> oficinas = this.model.getAllOfices();
			return oficinas;
		} catch (RemoteException e) {
			e.printStackTrace();
			System.out.println("No se pudo obtener todas las oficinas");
			return null;
		}
	}

	public List<Usuario> getUsuarios() {
		try {
			return this.model.getAllUsers();
		} catch (RemoteException e) {
			e.printStackTrace();
			System.out.println("No se pudo obtener los usuarios");
			return null;
		}
	}

	public List<UsuarioAdm> getUsuariosAdm() {
		try {
			return this.model.getUsersAdmin();
		} catch (RemoteException e) {
			e.printStackTrace();
			System.out.println("No se pudo obtener los usuarios administradores");
			return null;
		}
	}
	
	public void crearCuenta(String nombreCuenta, char[] password,
			Usuario usuario) {
		Casilla c = new Casilla();
		// TODO - Verificar el max de caracteres - Preferentemente en la ventana
		// TODO - Adaptar a la nueva clase usuario. Dbeeria preguntar cuando
		// crees crear una cuenta si es para un usuario nuevo o un usuario
		// existente... De ahi saldrían dos metodos al controlador, uno que
		// reciba un usuario, y otro que reciba la data del usuario para crearlo
		c.setNombre(nombreCuenta + "@" + Casilla.SERVER_DOMAIN);
		c.setInfoUsuario(usuario);
		c.setPassword(PasswordEncrypt.generateMD5(password));
		try {
			model.newAccout(c);
		} catch (RemoteException e) {
			System.out.println("No se pudo agregar una "
					+ "nueva cuenta desde la ventana de Nuevo Usuario");
			e.printStackTrace();
		}
	}

	public void crearUsuario(String nombre, String apellido, String direccion,
			String dni) {
		Usuario u = new Usuario(nombre, apellido, direccion, dni);
		try {
			this.model.addNewUser(u);
		} catch (RemoteException e) {
			System.out.println("No se pudo crear el usuario");
			e.printStackTrace();
		}

	}

	public void cambiarPassword(Casilla casillaAModificar, String generateMD5) {

		try {
			this.model.modifPassword(casillaAModificar, generateMD5);
		} catch (RemoteException e) {
			System.out.println("No se pudo cambiar la password");
			e.printStackTrace();
		}
	}

	public void eliminarCasilla(Casilla casilla) {
		try {
			this.model.deleteAccount(casilla);
		} catch (RemoteException e) {
			System.out.println("No se pudo eliminar la casilla en cuestión");
			e.printStackTrace();
		}
	}

	public void modificarUsuario(Usuario infoUsuario, String nombre,
			String apellido, String direccion, String dni) {

		try {
			infoUsuario.setNombre(nombre);
			infoUsuario.setApellido(apellido);
			infoUsuario.setDireccion(direccion);
			infoUsuario.setDni(dni);
			this.model.modifUser(infoUsuario);
		} catch (RemoteException e) {
			System.out
					.println("No se pudo modificar la información del usuario");
			e.printStackTrace();
		}

	}

	public void crearOficinaDeCorreo(String text,
			ArrayList<Casilla> seleccionadas) {
		try {
			OficinaDeCorreo nuevaOficina = new OficinaDeCorreo();
			nuevaOficina.setNombreOficina(text);
			for (Casilla c : seleccionadas)
				nuevaOficina.addCasillaMiembro(c);
			this.model.newOffice(nuevaOficina);
		} catch (RemoteException e) {
			System.out.println("No se pudo crear la oficina de correo");
			e.printStackTrace();
		}
	}

	public void modifOficinaDeCorreo(OficinaDeCorreo oficinaAModificar,
			String nombreNuevo, ArrayList<Casilla> nuevaSeleccionCasillas) {
		try {
			oficinaAModificar.setNombreOficina(nombreNuevo);
			List<Casilla> nuevas = new ArrayList<Casilla>();
			for (Casilla c : nuevaSeleccionCasillas)
				nuevas.add(c);
			oficinaAModificar.setCasillasMiembro(nuevas);
			this.model.modifOffice(oficinaAModificar);
		} catch (RemoteException e) {
			System.out.println("No se pudo crear la oficina de correo");
			e.printStackTrace();
		}
	}

	public void eliminarOficinaDeCorreo(OficinaDeCorreo oficinaSeleccionada) {
		try {
			this.model.deleteOffice(oficinaSeleccionada);
		} catch (RemoteException e) {
			System.out.println("No se pudo borrar la oficina seleccionada");
			e.printStackTrace();
		}
	}

	public void guardarVinculosDeConfianza(
			OficinaDeCorreo oficinaSeleccionada,
			List<OficinaDeCorreo> datalist) {
		try {
			this.model.clearTrustedLink(oficinaSeleccionada);
			for (OficinaDeCorreo o : datalist)
				this.model.addTrustedLink(oficinaSeleccionada, o);
		} catch (RemoteException e) {
			System.out.println("No se pudo guardar las nuevas oficinas de correo");
			e.printStackTrace();
		}

	}

	public boolean validarUsuarioAdm (String username, String clavePlana)
	{
		String claveMD5 = PasswordEncrypt.generateMD5(clavePlana);
		
		
		try {
			if(this.model.validoUsuarioAdm(username,claveMD5)){
				System.out.println("Usuario validado");
				return true;	
			}
			
		} catch (RemoteException e) {
			System.out.println("No se pudo cambiar la password");
			e.printStackTrace();
		}
		return false;
		
	}

	public void crearUsuarioAdm(String username, String clavePlana) {
		
		UsuarioAdm u = new UsuarioAdm();
		u.setPassword(PasswordEncrypt.generateMD5(clavePlana));
		u.setUsername(username);
		
		try {
			this.model.newUserAdmin(u);
		} catch (RemoteException e) {
			System.out.println("No se pudo crear el usuario administrador");
			e.printStackTrace();
		}

	}
}
