package com.uade.mail.client.views;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


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
	private JPanel panel;
	private JButton btnCambiar;
	private JPasswordField txtPassword2;
	private JPasswordField txtPassword1;
	private JPasswordField txtPassordVieja;
	private JLabel lblPasswordNueva2;
	private JLabel lblPasswordNueva1;
	private JLabel lblPassVieja;
	private JLabel lblUsuarioSeleccionado;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ChangPasswdFrame inst = new ChangPasswdFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ChangPasswdFrame() {
		super();
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
					lblUsuarioSeleccionado.setText("[Usuario]");
				}
				{
					lblPassVieja = new JLabel();
					lblPassVieja.setText("Password Anterior");
				}
				{
					lblPasswordNueva1 = new JLabel();
					lblPasswordNueva1.setText("Ingrese la Nueva Password");
				}
				{
					lblPasswordNueva2 = new JLabel();
					lblPasswordNueva2.setText("Ingrese Nuevamente la password");
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
				}
				panelLayout.setHorizontalGroup(panelLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(panelLayout.createParallelGroup()
					    .addGroup(GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
					        .addComponent(lblUsuarioSeleccionado, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					        .addGap(100))
					    .addComponent(lblPassVieja, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblPasswordNueva1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblPasswordNueva2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE))
					.addGap(57)
					.addGroup(panelLayout.createParallelGroup()
					    .addGroup(panelLayout.createSequentialGroup()
					        .addGap(0, 0, Short.MAX_VALUE)
					        .addComponent(txtPassordVieja, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
					    .addGroup(panelLayout.createSequentialGroup()
					        .addGap(0, 0, Short.MAX_VALUE)
					        .addComponent(txtPassword1, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
					    .addGroup(panelLayout.createSequentialGroup()
					        .addGap(0, 0, Short.MAX_VALUE)
					        .addComponent(txtPassword2, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
					    .addGroup(GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
					        .addGap(0, 87, Short.MAX_VALUE)
					        .addComponent(btnCambiar, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap());
				panelLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {txtPassword2, txtPassordVieja, txtPassword1});
				panelLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {lblPasswordNueva2, lblPasswordNueva1, lblPassVieja});
				panelLayout.setVerticalGroup(panelLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblUsuarioSeleccionado, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
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
					.addComponent(btnCambiar, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(38, Short.MAX_VALUE));
			}
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
