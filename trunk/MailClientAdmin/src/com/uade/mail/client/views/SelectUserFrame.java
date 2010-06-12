package com.uade.mail.client.views;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
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
public class SelectUserFrame extends javax.swing.JFrame {
	private JPanel panel;
	private JButton btnCrearCuenta;
	private JLabel lblUsuarioNuevo;
	private JComboBox cmbUsuarios;
	private JLabel lblCombo;
	private JLabel labelUsr;
	private MenuFrameController c;
	private MenuFrame vistaPadre;
	private ComboBoxModel cmbUsuariosModel;

	
	public SelectUserFrame(MenuFrameController c, MenuFrame menuFrame) {
		this.c = c;
		this.vistaPadre = menuFrame;
		initGUI();
	}
	
	

	public JComboBox getCmbUsuarios() {
		return cmbUsuarios;
	}



	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Selección de usuario");
			{
				panel = new JPanel();
				GroupLayout panelLayout = new GroupLayout((JComponent)panel);
				panel.setLayout(panelLayout);
				getContentPane().add(panel, BorderLayout.CENTER);
				panel.setPreferredSize(new java.awt.Dimension(487, 173));
				{
					labelUsr = new JLabel();
					labelUsr.setText("Seleccione el Usuario al cual desea agregar una cuenta");
				}
				{
					btnCrearCuenta = new JButton();
					btnCrearCuenta.setText("Crear Cuenta");
					btnCrearCuenta.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnCrearCuentaActionPerformed(evt);
						}
					});
				}
				{
					lblCombo = new JLabel();
					lblCombo.setText("Usuario:");
				}
				{
					cmbUsuariosModel = new DefaultComboBoxModel(this.c.getUsuarios().toArray());
					cmbUsuarios = new JComboBox();
					cmbUsuarios.setModel(cmbUsuariosModel);
				}
				{
					lblUsuarioNuevo = new JLabel();
					lblUsuarioNuevo.setText("Usuario Nuevo?");
					lblUsuarioNuevo.setFont(new java.awt.Font("AlArabiya",3,12));
					lblUsuarioNuevo.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							lblUsuarioNuevoMouseClicked(evt);
						}
					});
				}
				panelLayout.setHorizontalGroup(panelLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(panelLayout.createParallelGroup()
					    .addGroup(GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
					        .addComponent(lblCombo, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					        .addGroup(panelLayout.createParallelGroup()
					            .addComponent(cmbUsuarios, GroupLayout.Alignment.LEADING, 0, 349, Short.MAX_VALUE)
					            .addGroup(panelLayout.createSequentialGroup()
					                .addGap(191)
					                .addGroup(panelLayout.createParallelGroup()
					                    .addGroup(panelLayout.createSequentialGroup()
					                        .addGap(0, 0, Short.MAX_VALUE)
					                        .addComponent(lblUsuarioNuevo, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
					                    .addGroup(GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
					                        .addGap(0, 26, Short.MAX_VALUE)
					                        .addComponent(btnCrearCuenta, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)))))
					        .addGap(59))
					    .addComponent(labelUsr, GroupLayout.Alignment.LEADING, 0, 506, Short.MAX_VALUE)));
				panelLayout.setVerticalGroup(panelLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelUsr, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(cmbUsuarios, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblCombo, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addComponent(lblUsuarioNuevo, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addComponent(btnCrearCuenta, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(110, Short.MAX_VALUE));
			}
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void lblUsuarioNuevoMouseClicked(MouseEvent evt) {
		System.out.println("lblUsuarioNuevo.mouseClicked, event="+evt);
		//TODO add your code for lblUsuarioNuevo.mouseClicked
		new NewUserFrame(c,this).setVisible(true);
		this.setVisible(false);
	}
	
	private void btnCrearCuentaActionPerformed(ActionEvent evt) {
		System.out.println("btnCrearCuenta.actionPerformed, event="+evt);
		new NewAccountFrame(c,vistaPadre, (Usuario)this.cmbUsuarios.getSelectedItem()).setVisible(true);
		this.dispose();
	}



	public void actualizarCombo() {
		this.cmbUsuariosModel = new DefaultComboBoxModel(this.c.getUsuarios().toArray());
		this.cmbUsuarios.setModel(cmbUsuariosModel);
		
	}

}
