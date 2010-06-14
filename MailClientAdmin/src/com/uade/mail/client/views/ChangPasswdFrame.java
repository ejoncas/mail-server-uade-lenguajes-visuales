package com.uade.mail.client.views;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import com.uade.beans.entities.Casilla;
import com.uade.mail.client.controller.MenuFrameController;
import com.uade.mail.utils.PasswordEncrypt;



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
public class ChangPasswdFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = 416245764768143801L;
	private JPanel panel;
	private JButton btnCambiar;
	private JPasswordField txtPassword2;
	private JPasswordField txtPassword1;
	private JPasswordField txtPassordVieja;
	private JLabel lblPasswordNueva2;
	private JLabel lblPasswordNueva1;
	private JLabel lblPassVieja;
	private JLabel lblUsuarioSeleccionado;
	private MenuFrameController c;
	private MenuFrame vistaPadre;
	private Casilla casillaAModificar;

	public ChangPasswdFrame(MenuFrameController c, MenuFrame menuFrame,
			Casilla casilla) {
		super();
		this.c = c;
		this.vistaPadre = menuFrame;
		this.casillaAModificar = casilla;
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Cambiar Password");
			{
				panel = new JPanel();
				GroupLayout panelLayout = new GroupLayout((JComponent)panel);
				panel.setLayout(panelLayout);
				getContentPane().add(panel, BorderLayout.CENTER);
				{
					lblUsuarioSeleccionado = new JLabel();
					lblUsuarioSeleccionado.setText(this.casillaAModificar.getNombre());
				}
				{
					lblPassVieja = new JLabel();
					lblPassVieja.setText("Contraseña anterior");
				}
				{
					lblPasswordNueva1 = new JLabel();
					lblPasswordNueva1.setText("Ingrese una nueva contraseña");
				}
				{
					lblPasswordNueva2 = new JLabel();
					lblPasswordNueva2.setText("Ingrese nuevamente la contraseña");
				}
				{
					txtPassordVieja = new JPasswordField();
				}
				{
					txtPassword1 = new JPasswordField();
				}
				{
					txtPassword2 = new JPasswordField();
				}
				{
					btnCambiar = new JButton();
					btnCambiar.setText("Cambiar");
					btnCambiar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnCambiarActionPerformed(evt);
						}
					});
				}
				panelLayout.setHorizontalGroup(panelLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(panelLayout.createParallelGroup()
					    .addComponent(lblUsuarioSeleccionado, GroupLayout.Alignment.LEADING, 0, 292, Short.MAX_VALUE)
					    .addGroup(GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
					        .addComponent(lblPassVieja, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
					        .addGap(0, 53, Short.MAX_VALUE))
					    .addGroup(GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
					        .addComponent(lblPasswordNueva1, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
					        .addGap(0, 53, Short.MAX_VALUE))
					    .addGroup(GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
					        .addComponent(lblPasswordNueva2, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
					        .addGap(0, 53, Short.MAX_VALUE)))
					.addGroup(panelLayout.createParallelGroup()
					    .addComponent(txtPassword2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
					    .addComponent(txtPassword1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
					    .addComponent(txtPassordVieja, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
					    .addGroup(GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
					        .addGap(87)
					        .addComponent(btnCambiar, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap());
				panelLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {lblPasswordNueva2, lblPasswordNueva1, lblPassVieja});
				panelLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {txtPassword2, txtPassordVieja, txtPassword1});
				panelLayout.setVerticalGroup(panelLayout.createSequentialGroup()
					.addComponent(lblUsuarioSeleccionado, 0, 21, Short.MAX_VALUE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(txtPassordVieja, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblPassVieja, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(txtPassword1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblPasswordNueva1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(txtPassword2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblPasswordNueva2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addComponent(btnCambiar, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(35, 35));
			}
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void btnCambiarActionPerformed(ActionEvent evt) {
		System.out.println("btnCambiar.actionPerformed, event="+evt);
		if(!PasswordEncrypt.generateMD5(txtPassordVieja.getPassword()).equals(casillaAModificar.getPassword()))
			JOptionPane.showMessageDialog(null, "Password Vieja no coincide");
		else if(!comparePasswordsEquals(txtPassword1.getPassword(), txtPassword2.getPassword()))
			JOptionPane.showMessageDialog(null, "El reingreso de password no coincide");
		else{
			this.c.cambiarPassword(this.casillaAModificar, PasswordEncrypt.generateMD5(txtPassword1.getPassword()));
			JOptionPane.showMessageDialog(null, "Password Cambiado!");
			this.vistaPadre.updateWindow();
			this.dispose();
		}
			
	}
	
	private boolean comparePasswordsEquals(char[] a, char[] b){
		for(int i=0; i< a.length; i++){
			if(a[i]!=b[i])
				return false;
		}
		return true;
	}

}
