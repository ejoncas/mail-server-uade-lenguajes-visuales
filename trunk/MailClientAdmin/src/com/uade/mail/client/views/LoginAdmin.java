package com.uade.mail.client.views;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import com.uade.mail.client.controller.MenuFrameController;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class LoginAdmin extends javax.swing.JFrame {

	private static final long serialVersionUID = 3744310089938234429L;
	private JLabel jLblUsername;
	private JTextField jTxtUsrAdm;
	private JLabel jLbl;
	private JPasswordField jTxtClave;
	private JButton jBtnSalir;
	private JButton jBtnAceptar;
	private MenuFrameController controlador;

	public LoginAdmin(MenuFrameController controlador) {
		super();
		this.controlador=controlador;
		initGUI();
	}
	
	private void initGUI() {
		try {
			GridLayout thisLayout = new GridLayout(3, 2);
			thisLayout.setColumns(2);
			thisLayout.setHgap(5);
			thisLayout.setVgap(5);
			thisLayout.setRows(3);
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setAlwaysOnTop(true);
			this.setTitle("Acceso a la consola de administración");
			{
				jLblUsername = new JLabel();
				getContentPane().add(jLblUsername);
				jLblUsername.setText("Ingrese su usuario:");
			}
			{
				jTxtUsrAdm = new JTextField();
				getContentPane().add(jTxtUsrAdm);
			}
			{
				jLbl = new JLabel();
				getContentPane().add(jLbl);
				jLbl.setText("Ingrese su contraseña:");
			}
			{
				jTxtClave = new JPasswordField();
				getContentPane().add(jTxtClave);
				
			}
			{
				jBtnAceptar = new JButton();
				getContentPane().add(jBtnAceptar);
				jBtnAceptar.setText("Aceptar");
				jBtnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnAceptarActionPerformed(evt);
					}
			});
			}
			{
				jBtnSalir = new JButton();
				getContentPane().add(jBtnSalir);
				jBtnSalir.setText("Salir");
				jBtnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnSalirActionPerformed(evt);
					}
			});
			}
			pack();
			this.setSize(366, 137);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void btnAceptarActionPerformed(ActionEvent evt) {
		System.out.println("btnCambiar.actionPerformed, event="+evt);
		
		//no le saco el warning porque habria que corregir la funcion por
		//una solucion correcta.
		//hay que "castear" o convertir, getPassword, CHAR, a un String
		//o cambiar toda la funcion controlador... le podria pasar ya
		//directamente el MD5.
		
		if(controlador.validarUsuarioAdm(jTxtUsrAdm.getText(),jTxtClave.getText())){
			new MenuFrame(controlador).setVisible(true);
			this.dispose();
		}else
		{
			JOptionPane.showMessageDialog(null, "La contraseña ingresada no es correcta!");
		}
	}
	
	private void btnSalirActionPerformed(ActionEvent evt) {
		System.out.println("btnCambiar.actionPerformed, event="+evt);
		
		this.dispose();
	}

}
