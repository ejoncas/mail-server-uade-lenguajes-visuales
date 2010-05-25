package com.uade.mail.client.views;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import com.uade.beans.entities.Usuario;
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
public class NewAccountFrame extends javax.swing.JFrame {
	private JPanel panel;
	private JTextField inputNombreCasilla;
	private JButton btnCrear;
	private JPasswordField inputPasswd2;
	private JPasswordField inputPasswd1;
	private JLabel txtContrasenia2;
	private JLabel txtContrasenia;
	private JLabel txtNombreCuenta;
	private MenuFrameController c;
	private MenuFrame vistaPadre;
	private Usuario userSelected;
	
	
	public NewAccountFrame(MenuFrameController c, MenuFrame selectUserFrame, Usuario user) {
		super();
		this.c=c;
		this.vistaPadre = selectUserFrame;
		this.userSelected = user;
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Nueva Casilla");

			{
				panel = new JPanel();
				GroupLayout panelLayout = new GroupLayout((JComponent)panel);
				panel.setLayout(panelLayout);
				getContentPane().add(panel, BorderLayout.CENTER);
				panel.setPreferredSize(new java.awt.Dimension(484, 172));
				{
					txtNombreCuenta = new JLabel();
					txtNombreCuenta.setText("Nombre de Cuenta:");
				}
				{
					txtContrasenia = new JLabel();
					txtContrasenia.setText("Contraseña");
				}
				{
					txtContrasenia2 = new JLabel();
					txtContrasenia2.setText("Repita su Contraseña");
				}
				{
					inputNombreCasilla = new JTextField();
				}
				{
					inputPasswd1 = new JPasswordField();
				}
				{
					inputPasswd2 = new JPasswordField();
					inputPasswd2.addFocusListener(new FocusAdapter() {
						public void focusLost(FocusEvent evt) {
							inputPasswd2FocusLost(evt);
						}
					});
				}
				{
					btnCrear = new JButton();
					btnCrear.setText("Crear");
					btnCrear.setEnabled(false);
					btnCrear.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnCrearActionPerformed(evt);
						}
					});
				}
				panelLayout.setHorizontalGroup(panelLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(panelLayout.createParallelGroup()
					    .addComponent(txtNombreCuenta, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
					    .addComponent(txtContrasenia, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
					    .addComponent(txtContrasenia2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addGroup(panelLayout.createParallelGroup()
					    .addComponent(inputNombreCasilla, GroupLayout.Alignment.LEADING, 0, 247, Short.MAX_VALUE)
					    .addComponent(inputPasswd1, GroupLayout.Alignment.LEADING, 0, 247, Short.MAX_VALUE)
					    .addComponent(inputPasswd2, GroupLayout.Alignment.LEADING, 0, 247, Short.MAX_VALUE)
					    .addGroup(GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
					        .addGap(0, 110, Short.MAX_VALUE)
					        .addComponent(btnCrear, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap());
				panelLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {txtContrasenia2, txtContrasenia});
				panelLayout.setVerticalGroup(panelLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(inputNombreCasilla, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(txtNombreCuenta, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(inputPasswd1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(txtContrasenia, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(inputPasswd2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(txtContrasenia2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(0, 37, Short.MAX_VALUE)
					.addComponent(btnCrear, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addContainerGap());
			}
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void btnCrearActionPerformed(ActionEvent evt) {
		System.out.println("btnCrear.actionPerformed, event="+evt);
		c.crearCuenta(inputNombreCasilla.getText(), inputPasswd1.getPassword(),this.userSelected);
		dispose();
		this.vistaPadre.updateWindow();
	}
	
	private void inputPasswd2FocusLost(FocusEvent evt) {
		System.out.println("inputPasswd2.focusLost, event="+evt);
		//Validar Form
		if(inputNombreCasilla.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Nombre de Cuenta no definido");
			btnCrear.setEnabled(false);
		}
//		else if(inputNombre.getText().isEmpty()){
//			JOptionPane.showMessageDialog(null, "Nombre no definido");
//			btnCrear.setEnabled(false);
//		}
//		else if(inputApellido.getText().isEmpty()){
//			JOptionPane.showMessageDialog(null, "Apellido no defnido");
//			btnCrear.setEnabled(false);	
//		}
		else if(!compararPasswords(inputPasswd1.getPassword(),inputPasswd2.getPassword())){
			JOptionPane.showMessageDialog(null, "Passwords no coinciden");
			btnCrear.setEnabled(false);
		}
		else
			btnCrear.setEnabled(true);
	}
	
	private boolean compararPasswords(char[] a, char[] b){
		for(int i=0; i<a.length;i++)
			if(a[i]!=b[i])return false;
		return true;
	}

}
