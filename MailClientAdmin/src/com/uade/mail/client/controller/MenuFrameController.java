package com.uade.mail.client.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.uade.mail.beans.CasillaVO;
import com.uade.mail.beans.OficinaDeCorreoVO;
import com.uade.mail.beans.UsuarioVO;
import com.uade.mail.client.main.MailClient;
import com.uade.mail.client.views.MenuFrame;
import com.uade.mail.interfaces.MailService;
import com.uade.mail.utils.PasswordEncrypt;

public class MenuFrameController {

	private MailService model = null;
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

	public ArrayList<CasillaVO> getAccounts() {
		try {
			return this.model.getAllAccounts();
		} catch (RemoteException e) {
			e.printStackTrace();
			System.out.println("No se pudo obtener todas las casillas");
			return null;
		}
	}

	public ArrayList<OficinaDeCorreoVO> getOffices() {
		try {
			return this.model.getAllOfices();
		} catch (RemoteException e) {
			e.printStackTrace();
			System.out.println("No se pudo obtener todas las oficinas");
			return null;
		}
	}

	public ArrayList<UsuarioVO> getUsuarios() {
		try {
			return this.model.getAllUsers();
		} catch (RemoteException e) {
			e.printStackTrace();
			System.out.println("No se pudo obtener los usuarios");
			return null;
		}
	}

	public void crearCuenta(String nombreCuenta, char[] password,
			UsuarioVO usuarioVO) {
		CasillaVO c = new CasillaVO();
		// TODO - Verificar el max de caracteres - Preferentemente en la ventana
		// TODO - Adaptar a la nueva clase usuario. Dbeeria preguntar cuando
		// crees crear una cuenta si es para un usuario nuevo o un usuario
		// existente... De ahi saldrían dos metodos al controlador, uno que
		// reciba un usuario, y otro que reciba la data del usuario para crearlo
		c.setNombre(nombreCuenta + "@" + CasillaVO.SERVER_DOMAIN);
		c.setInfoUsuario(usuarioVO);
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
		UsuarioVO u = new UsuarioVO(nombre, apellido, direccion, dni);
		try {
			this.model.addNewUser(u);
		} catch (RemoteException e) {
			System.out.println("No se pudo crear el usuario");
			e.printStackTrace();
		}

	}

	public void cambiarPassword(CasillaVO casillaAModificar, String generateMD5) {

		try {
			this.model.modifPassword(casillaAModificar, generateMD5);
		} catch (RemoteException e) {
			System.out.println("No se pudo cambiar la password");
			e.printStackTrace();
		}
	}

	public void eliminarCasilla(CasillaVO casilla) {
		try {
			this.model.deleteAccount(casilla);
		} catch (RemoteException e) {
			System.out.println("No se pudo eliminar la casilla en cuestión");
			e.printStackTrace();
		}
	}

	public void modificarUsuario(UsuarioVO infoUsuario, String nombre,
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
			ArrayList<CasillaVO> seleccionadas) {
		try {
			OficinaDeCorreoVO nuevaOficina = new OficinaDeCorreoVO();
			nuevaOficina.setNombreOficina(text);
			for (CasillaVO c : seleccionadas)
				nuevaOficina.addCasillaMiembro(c);
			this.model.newOffice(nuevaOficina);
		} catch (RemoteException e) {
			System.out.println("No se pudo crear la oficina de correo");
			e.printStackTrace();
		}
	}

	public void modifOficinaDeCorreo(OficinaDeCorreoVO oficinaAModificar,
			String nombreNuevo, ArrayList<CasillaVO> nuevaSeleccionCasillas) {
		try {
			oficinaAModificar.setNombreOficina(nombreNuevo);
			HashSet<CasillaVO> nuevas = new HashSet<CasillaVO>();
			for (CasillaVO c : nuevaSeleccionCasillas)
				nuevas.add(c);
			oficinaAModificar.setCasillasMiembro(nuevas);
			this.model.modifOffice(oficinaAModificar);
		} catch (RemoteException e) {
			System.out.println("No se pudo crear la oficina de correo");
			e.printStackTrace();
		}
	}

	public void eliminarOficinaDeCorreo(OficinaDeCorreoVO oficinaSeleccionada) {
		try {
			this.model.deleteOffice(oficinaSeleccionada);
		} catch (RemoteException e) {
			System.out.println("No se pudo borrar la oficina seleccionada");
			e.printStackTrace();
		}
	}

	public void guardarVinculosDeConfianza(
			OficinaDeCorreoVO oficinaSeleccionada,
			List<OficinaDeCorreoVO> datalist) {
		try {
			for (OficinaDeCorreoVO o : datalist)
				this.model.addTrustedLink(oficinaSeleccionada, o);
		} catch (RemoteException e) {
			System.out.println("No se pudo guardar las nuevas oficinas de correo");
			e.printStackTrace();
		}

	}

}
