package com.uade.mail.client.views;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;
import javax.swing.ListModel;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ListDataListener;

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
public class EditTrustedLinksFrame extends javax.swing.JFrame {
	private JPanel panel;
	private JList listTodas;
	private JScrollPane jScrollPane2;
	private JButton btnGuardar;
	private JButton btnEliminar;
	private JButton btnAgregar;
	private JLabel lblTodas;
	private JScrollPane jScrollPane1;
	private JList listConfianza;
	private JLabel lblVinculosActuales;
	private JLabel lblOficina;
	private JLabel lbl1;
	private MenuFrameController c;
	private MenuFrame vistaPadre;
	private OficinaDeCorreoVO oficinaSeleccionada;
	private OficinaListModel listTodasModel;
	private OficinaListModel listConfianzaModel;

	
	public EditTrustedLinksFrame(MenuFrameController c, MenuFrame menuFrame,
			OficinaDeCorreoVO oficinaSeleccionada) {
		super();
		this.c=c;
		this.vistaPadre=menuFrame;
		this.oficinaSeleccionada = oficinaSeleccionada;
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Editar Vinculos de Confianza");
			{
				panel = new JPanel();
				GroupLayout panelLayout = new GroupLayout((JComponent)panel);
				panel.setLayout(panelLayout);
				getContentPane().add(panel, BorderLayout.CENTER);
				panel.setPreferredSize(new java.awt.Dimension(595, 373));
				{
					lbl1 = new JLabel();
					lbl1.setText("Editando Oficina:");
				}
				{
					lblOficina = new JLabel();
					lblOficina.setText(this.oficinaSeleccionada.getNombreOficina());
				}
				{
					lblVinculosActuales = new JLabel();
					lblVinculosActuales.setText("Ofinas de Confianza");
				}
				{
					jScrollPane1 = new JScrollPane();
					{
						listConfianzaModel = new OficinaListModel(oficinaSeleccionada.getOficinasDeConfianza());
						listConfianza = new JList();
						jScrollPane1.setViewportView(listConfianza);
						listConfianza.setModel(listConfianzaModel);
						listConfianza.setPreferredSize(new java.awt.Dimension(147, 234));
					}
				}
				{
					lblTodas = new JLabel();
					lblTodas.setText("Todas las Oficinas");
				}
				{
					jScrollPane2 = new JScrollPane();
					{
						listTodasModel = new OficinaListModel(this.c.getOffices());
						listTodas = new JList();
						jScrollPane2.setViewportView(listTodas);
						listTodas.setModel(listTodasModel);
					}
				}
				{
					btnAgregar = new JButton();
					btnAgregar.setText("<- Agregar");
					btnAgregar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnAgregarActionPerformed(evt);
						}
					});
				}
				{
					btnEliminar = new JButton();
					btnEliminar.setText("Eliminar ->");
					btnEliminar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnEliminarActionPerformed(evt);
						}
					});
				}
				{
					btnGuardar = new JButton();
					btnGuardar.setText("Guardar");
					btnGuardar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnGuardarActionPerformed(evt);
						}
					});
				}
				panelLayout.setHorizontalGroup(panelLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(panelLayout.createParallelGroup()
					    .addGroup(GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
					        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
					        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					        .addGroup(panelLayout.createParallelGroup()
					            .addComponent(btnAgregar, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					            .addComponent(btnEliminar, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
					        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					        .addGroup(panelLayout.createParallelGroup()
					            .addGroup(panelLayout.createSequentialGroup()
					                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
					                .addGap(0, 0, Short.MAX_VALUE))
					            .addGroup(GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
					                .addGap(0, 94, Short.MAX_VALUE)
					                .addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))))
					    .addGroup(panelLayout.createSequentialGroup()
					        .addGroup(panelLayout.createParallelGroup()
					            .addComponent(lblVinculosActuales, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
					            .addComponent(lbl1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE))
					        .addGap(21)
					        .addGroup(panelLayout.createParallelGroup()
					            .addGroup(panelLayout.createSequentialGroup()
					                .addComponent(lblTodas, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE))
					            .addGroup(panelLayout.createSequentialGroup()
					                .addComponent(lblOficina, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)))
					        .addGap(0, 43, Short.MAX_VALUE)))
					.addContainerGap(63, 63));
				panelLayout.setVerticalGroup(panelLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(panelLayout.createParallelGroup()
					    .addComponent(lbl1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addGroup(GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
					        .addGap(7)
					        .addComponent(lblOficina, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					        .addGap(8)))
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(lblTodas, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(lblVinculosActuales, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addGroup(panelLayout.createParallelGroup()
					    .addComponent(jScrollPane2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
					    .addComponent(jScrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
					    .addGroup(GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
					        .addGap(60)
					        .addComponent(btnAgregar, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					        .addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					        .addGap(123)))
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(35, Short.MAX_VALUE));
			}
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void btnAgregarActionPerformed(ActionEvent evt) {
		System.out.println("btnAgregar.actionPerformed, event="+evt);
		OficinaDeCorreoVO oficinaSeleccionada = (OficinaDeCorreoVO) listTodasModel.getElementAt(listTodas.getSelectedIndex());
		listConfianzaModel.addOficinaDeCorreo(oficinaSeleccionada);
		listConfianza.updateUI();

	}
	
	private void btnEliminarActionPerformed(ActionEvent evt) {
		System.out.println("btnEliminar.actionPerformed, event="+evt);
		OficinaDeCorreoVO oficinaSeleccionada = (OficinaDeCorreoVO) listConfianzaModel.getElementAt(listConfianza.getSelectedIndex());
		listConfianzaModel.delOficinaDeCorreo(oficinaSeleccionada);
		listConfianza.updateUI();
	}
	
	private void btnGuardarActionPerformed(ActionEvent evt) {
		System.out.println("btnGuardar.actionPerformed, event="+evt);
		
		this.c.guardarVinculosDeConfianza(this.oficinaSeleccionada,listConfianzaModel.getDatalist());
		this.vistaPadre.updateWindow();
		this.dispose();
	}

}
