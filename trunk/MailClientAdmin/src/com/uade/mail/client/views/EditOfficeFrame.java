package com.uade.mail.client.views;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

import com.uade.mail.beans.CasillaVO;
import com.uade.mail.beans.OficinaDeCorreoVO;
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
public class EditOfficeFrame extends javax.swing.JFrame {
	private JPanel panel;
	private JButton btnCrear;
	private JScrollPane jScrollPane1;
	private JTable tableCasillas;
	private JLabel lblSeleccion;
	private JTextField txtNombreOficina;
	private JLabel lblNombre;
	
	private MenuFrameController c;
	private CasillaTableModel modelCasilla;
	private MenuFrame vistaPadre;
	private OficinaDeCorreoVO oficinaAModificar;

	
	public EditOfficeFrame(MenuFrameController c, MenuFrame menuFrame, OficinaDeCorreoVO oficinaAModificar) {
		super();
		this.c=c;
		this.vistaPadre = menuFrame;
		this.oficinaAModificar = oficinaAModificar;
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Editar Oficina de Correo");
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
					txtNombreOficina.setText(this.oficinaAModificar.getNombreOficina());
				}
				{
					lblSeleccion = new JLabel();
					lblSeleccion.setText("Seleccione las casillas integrantes [CTRL+Click para varias]");
				}
				{
					jScrollPane1 = new JScrollPane();
					{
						modelCasilla = new CasillaTableModel();
						modelCasilla.addCasillaList(this.c.getAccounts());
						tableCasillas = new JTable();
						jScrollPane1.setViewportView(tableCasillas);
						tableCasillas.setModel(modelCasilla);
						
						
					}
				}
				{
					btnCrear = new JButton();
					btnCrear.setText("Modificar");
					btnCrear.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnCrearActionPerformed(evt);
						}
					});
				}
				panelLayout.setHorizontalGroup(panelLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(panelLayout.createParallelGroup()
					    .addGroup(panelLayout.createSequentialGroup()
					        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 653, GroupLayout.PREFERRED_SIZE)
					        .addGap(0, 0, Short.MAX_VALUE))
					    .addGroup(GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
					        .addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
					        .addGap(60)
					        .addGroup(panelLayout.createParallelGroup()
					            .addGroup(panelLayout.createSequentialGroup()
					                .addComponent(txtNombreOficina, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)
					                .addGap(0, 0, Short.MAX_VALUE))
					            .addGroup(GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
					                .addGap(0, 259, Short.MAX_VALUE)
					                .addComponent(btnCrear, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))))
					    .addGroup(panelLayout.createSequentialGroup()
					        .addComponent(lblSeleccion, GroupLayout.PREFERRED_SIZE, 653, GroupLayout.PREFERRED_SIZE)
					        .addGap(0, 0, Short.MAX_VALUE)))
					.addContainerGap(16, 16));
				panelLayout.setVerticalGroup(panelLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(txtNombreOficina, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblNombre, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addComponent(lblSeleccion, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
					.addGap(0, 15, Short.MAX_VALUE)
					.addComponent(btnCrear, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(28, 28));
			}
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void btnCrearActionPerformed(ActionEvent evt) {
		System.out.println("btnCrear.actionPerformed, event="+evt);
		
		ArrayList<CasillaVO> seleccionadas = armarCasillasSeleccionadas(this.tableCasillas.getSelectedRows());
		
		this.c.modifOficinaDeCorreo(this.oficinaAModificar,txtNombreOficina.getText(), seleccionadas);
		this.vistaPadre.updateWindow();
		this.dispose();
	}

	private ArrayList<CasillaVO> armarCasillasSeleccionadas(int[] selectedRows) {
		ArrayList<CasillaVO> result = new ArrayList<CasillaVO>();
		for(int i : selectedRows){
			result.add(this.modelCasilla.getCasillAt(i));
		}
		return result;
	}

}
