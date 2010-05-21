package com.uade.mail.client.views;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
public class NewUserFrame extends javax.swing.JFrame {
	private JPanel panel;
	private JTextField txtNombre;
	private JButton btnCrear;
	private JTextField txtDni;
	private JTextField txtDireccion;
	private JTextField txtApellido;
	private JLabel lblDni;
	private JLabel lblDireccion;
	private JLabel lblApellido;
	private JLabel lblNombre;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				NewUserFrame inst = new NewUserFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public NewUserFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Crear Usuario");
			{
				panel = new JPanel();
				GroupLayout panelLayout = new GroupLayout((JComponent)panel);
				panel.setLayout(panelLayout);
				getContentPane().add(panel, BorderLayout.CENTER);
				panel.setPreferredSize(new java.awt.Dimension(554, 176));
				{
					lblNombre = new JLabel();
					lblNombre.setText("Nombre");
				}
				{
					lblApellido = new JLabel();
					lblApellido.setText("Apellido");
				}
				{
					lblDireccion = new JLabel();
					lblDireccion.setText("Direccion");
				}
				{
					lblDni = new JLabel();
					lblDni.setText("DNI");
				}
				{
					txtNombre = new JTextField();
				}
				{
					txtApellido = new JTextField();
				}
				{
					txtDireccion = new JTextField();
				}
				{
					txtDni = new JTextField();
				}
				{
					btnCrear = new JButton();
					btnCrear.setText("Crear!");
				}
				panelLayout.setHorizontalGroup(panelLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(panelLayout.createParallelGroup()
					    .addComponent(lblNombre, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblApellido, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblDireccion, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblDni, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
					.addGap(111)
					.addGroup(panelLayout.createParallelGroup()
					    .addGroup(panelLayout.createSequentialGroup()
					        .addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
					        .addGap(0, 0, Short.MAX_VALUE))
					    .addGroup(panelLayout.createSequentialGroup()
					        .addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
					        .addGap(0, 0, Short.MAX_VALUE))
					    .addGroup(panelLayout.createSequentialGroup()
					        .addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
					        .addGap(0, 0, Short.MAX_VALUE))
					    .addComponent(txtDni, GroupLayout.Alignment.LEADING, 0, 254, Short.MAX_VALUE)
					    .addGroup(GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
					        .addGap(0, 112, Short.MAX_VALUE)
					        .addComponent(btnCrear, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(49, 49));
				panelLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {txtDireccion, txtNombre, txtApellido, txtDni});
				panelLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {lblDni, lblDireccion, lblApellido, lblNombre});
				panelLayout.setVerticalGroup(panelLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(txtNombre, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblNombre, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(txtApellido, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblApellido, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(txtDireccion, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblDireccion, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(txtDni, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblDni, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(0, 75, Short.MAX_VALUE)
					.addComponent(btnCrear, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap());
			}
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
