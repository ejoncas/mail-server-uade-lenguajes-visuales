import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import junit.framework.TestCase;

import com.uade.beans.entities.OficinaDeCorreo;
import com.uade.mail.interfaces.MailService;
import com.uade.mail.server.MailServer;


public class TestRMI extends TestCase{
	
	public void testRMI(){
		MailService serviceInterface;
		try {
			
			serviceInterface = (MailService) Naming.lookup(MailServer.SERVICE_URL);
			/**ListarUsuarios
			ArrayList<Usuario> usuarios = serviceInterface.getAllUsers();
			for(Usuario u: usuarios)
				System.out.println(u);
			*/
			/**AgregarUsuario
			Usuario user = new Usuario("Marina", "Castro", "sadasda","123452");
			serviceInterface.addNewUser(user);
			*/
			/**RemoveUser
			for(Usuario usuario : usuarios)
				if(usuario.getNombre().contains("Mari"))
					serviceInterface.removeUser(usuario);
			*/
			/**ModifyUser
			for(Usuario usuario : usuarios)
				if(usuario.getNombre().contains("Jon")){
					usuario.setApellido("CastroModif");
					usuario.setDireccion("DireccionModif");
					usuario.setDni("DNIMODIF");
					usuario.setNombre("JonatanModif");
					serviceInterface.modifUser(usuario);
				}
			*/
			List<OficinaDeCorreo> oficinas = serviceInterface.getAllOfices();
			for(OficinaDeCorreo o : oficinas)
				System.out.println(o.toString());
					
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

}
