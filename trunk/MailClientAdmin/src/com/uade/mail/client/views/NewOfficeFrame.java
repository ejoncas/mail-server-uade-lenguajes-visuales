package com.uade.mail.client.views;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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
public class NewOfficeFrame extends javax.swing.JFrame {
	private JPanel panel;
	private JButton btnCrear;
	private JScrollPane jScrollPane1;
	private JTable tableCasillas;
	private JLabel lblSeleccion;
	private JTextField txtNombreOficina;
	private JLabel lblNombre;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				NewOfficeFrame inst = new NewOfficeFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public NewOfficeFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				panel = new JPanel();
				GroupLayout panelLayout = new GroupLayout((JComponent)panel);
				panel.setLayout(panelLayout);
				getContentPane().add(panel, BorderLayout.CENTER);
				panel.setPreferredSize(new java.awt.Dimension(685, 438));
				{
					lblNombre = new JLabel();
					lblNombre.setText("Nombre Oficina de Correo");
				}
				{
					txtNombreOficina = new JTextField();
				}
				{
					lblSeleccion = new JLabel();
					lblSeleccion.setText("Seleccione las casillas integrantes");
				}
				{
					jScrollPane1 = new JScrollPane();
					{
						TableModel tableCasillasModel = 
							new DefaultTableModel(
									new String[][] { { "One", "Two" }, { "Three", "Four" } },
									new String[] { "Column 1", "Column 2" });
						tableCasillas = new JTable();
						jScrollPane1.setViewportView(tableCasillas);
						tableCasillas.setModel(tableCasillasModel);
					}
				}
				{
					btnCrear = new JButton();
					btnCrear.setText("Crear");
				}
				panelLayout.setHorizontalGroup(panelLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(panelLayout.createParallelGroup()
					    .addGroup(panelLayout.createSequentialGroup()
					        .addGroup(panelLayout.createParallelGroup()
					            .addComponent(lblSeleccion, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
					            .addGroup(GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
					                .addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
					                .addGap(60)))
					        .addGroup(panelLayout.createParallelGroup()
					            .addGroup(panelLayout.createSequentialGroup()
					                .addComponent(txtNombreOficina, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)
					                .addGap(0, 0, Short.MAX_VALUE))
					            .addGroup(GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
					                .addGap(0, 259, Short.MAX_VALUE)
					                .addComponent(btnCrear, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))))
					    .addGroup(panelLayout.createSequentialGroup()
					        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 653, GroupLayout.PREFERRED_SIZE)
					        .addGap(0, 0, Short.MAX_VALUE)))
					.addContainerGap(47, 47));
				panelLayout.setVerticalGroup(panelLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(txtNombreOficina, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblNombre, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(lblSeleccion, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
					.addGap(0, 17, Short.MAX_VALUE)
					.addComponent(btnCrear, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(31, 31));
			}
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
