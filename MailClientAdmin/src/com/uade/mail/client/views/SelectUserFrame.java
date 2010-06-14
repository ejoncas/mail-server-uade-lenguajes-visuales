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

	private static final long serialVersionUID = 3602910491614355455L;
	private JPanel panel;
	private JButton btnCrearCuenta;
	private JButton btnUsuarioNuevo;
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
					btnUsuarioNuevo = new JButton();
					btnUsuarioNuevo.setText("Nuevo Usuario");
					btnUsuarioNuevo.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnUsuarioNuevoActionPerformed(evt);
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
					                .addGap(217)
					                .addGroup(panelLayout.createParallelGroup()
					                    .addGroup(panelLayout.createSequentialGroup()
					                        .addGap(0, 0, Short.MAX_VALUE)
					                        .addComponent(btnCrearCuenta, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
					                    .addComponent(btnUsuarioNuevo, GroupLayout.Alignment.LEADING, 0, 132, Short.MAX_VALUE))))
					        .addGap(59))
					    .addComponent(labelUsr, GroupLayout.Alignment.LEADING, 0, 506, Short.MAX_VALUE)));
				panelLayout.setVerticalGroup(panelLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelUsr, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(cmbUsuarios, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblCombo, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addComponent(btnUsuarioNuevo, 0, 20, Short.MAX_VALUE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addComponent(btnCrearCuenta, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(31, 31));
			}
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void btnUsuarioNuevoActionPerformed(ActionEvent evt) {
		System.out.println("btnUsuarioNuevo.actionPerormed, event="+evt);
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
