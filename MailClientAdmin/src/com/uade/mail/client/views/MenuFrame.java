package com.uade.mail.client.views;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
public class MenuFrame extends javax.swing.JDialog {
	private JTabbedPane tabbedPane;
	private JPanel tab1;
	private JPanel tab2;
	private JScrollPane jScrollPane1;
	private JButton modificarBtn;
	private JPanel tab4;
	private JButton eliminarBtn;
	private JButton nuevoBtn;
	private JTable usuariosTable;
	private JPanel tab3;

	/**
	* Auto-generated main method to display this JDialog
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				MenuFrame inst = new MenuFrame(frame);
				inst.setVisible(true);
			}
		});
	}
	
	public MenuFrame(JFrame frame) {
		super(frame);
		initGUI();
	}
	
	private void initGUI() {
		try {
			
			//Icons
			ImageIcon groups = createImageIcon("resources/groups.png");
			ImageIcon office = createImageIcon("resources/sucs.gif");
			ImageIcon links = createImageIcon("resources/edit.png");
			ImageIcon passwd = createImageIcon("resources/passgen.gif");
			{
				tabbedPane = new JTabbedPane();
				getContentPane().add(tabbedPane, BorderLayout.CENTER);
				tabbedPane.setPreferredSize(new java.awt.Dimension(728, 457));
				{
					tab1 = new JPanel();
					GroupLayout tab1Layout = new GroupLayout((JComponent)tab1);
					tab1.setLayout(tab1Layout);
					tabbedPane.addTab("Usuarios", groups, tab1, "Administracion de Usuarios");
					tab1.setPreferredSize(new java.awt.Dimension(721, 432));
					{
						jScrollPane1 = new JScrollPane();
						{
							TableModel usuariosTableModel = 
								new DefaultTableModel(
										new String[][] { { "One", "Two" }, { "Three", "Four" } },
										new String[] { "Column 1", "Column 2" });
							usuariosTable = new JTable();
							jScrollPane1.setViewportView(usuariosTable);
							usuariosTable.setModel(usuariosTableModel);
						}
					}
					{
						modificarBtn = new JButton();
						modificarBtn.setText("Modificar");
					}
					{
						eliminarBtn = new JButton();
						eliminarBtn.setText("Eliminar");
					}
					{
						nuevoBtn = new JButton();
						nuevoBtn.setText("Nuevo");
					}
					tab1Layout.setHorizontalGroup(tab1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(tab1Layout.createParallelGroup()
						    .addGroup(GroupLayout.Alignment.LEADING, tab1Layout.createSequentialGroup()
						        .addComponent(nuevoBtn, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
						        .addGap(330)
						        .addComponent(eliminarBtn, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
						        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						        .addComponent(modificarBtn, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
						        .addGap(0, 38, Short.MAX_VALUE))
						    .addComponent(jScrollPane1, GroupLayout.Alignment.LEADING, 0, 727, Short.MAX_VALUE)));
					tab1Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {eliminarBtn, nuevoBtn, modificarBtn});
					tab1Layout.setVerticalGroup(tab1Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 359, GroupLayout.PREFERRED_SIZE)
						.addGap(24)
						.addGroup(tab1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						    .addComponent(nuevoBtn, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(eliminarBtn, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(modificarBtn, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(15, 15));
					tab1Layout.linkSize(SwingConstants.VERTICAL, new Component[] {eliminarBtn, nuevoBtn, modificarBtn});
				}
				{
					tab2 = new JPanel();
					GroupLayout tab2Layout = new GroupLayout((JComponent)tab2);
					tab2.setLayout(tab2Layout);
					tabbedPane.addTab("Centros de Correo", office, tab2, "Administracion de Oficinas de Correo");
					tab2Layout.setVerticalGroup(tab2Layout.createParallelGroup());
					tab2Layout.setHorizontalGroup(tab2Layout.createParallelGroup());
				}
				{
					tab3 = new JPanel();
					GroupLayout tab3Layout = new GroupLayout((JComponent)tab3);
					tab3.setLayout(tab3Layout);
					tabbedPane.addTab("Vinculos de Confianza", links, tab3, "Administracion de vinculos de confianza");
					tab3Layout.setVerticalGroup(tab3Layout.createParallelGroup());
					tab3Layout.setHorizontalGroup(tab3Layout.createParallelGroup());
				}
				{
					tab4 = new JPanel();
					GroupLayout tab4Layout = new GroupLayout((JComponent)tab4);
					tab4.setLayout(tab4Layout);
					tabbedPane.addTab("Contraseñas", passwd, tab4, "Administracion de Contraseñas");
					tab4Layout.setVerticalGroup(tab4Layout.createParallelGroup());
					tab4Layout.setHorizontalGroup(tab4Layout.createParallelGroup());
				}
			}
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
    	try{
            return new ImageIcon(path);
    	}catch (Exception e) {
    		e.printStackTrace();
    		return null;
		}
    }
}
