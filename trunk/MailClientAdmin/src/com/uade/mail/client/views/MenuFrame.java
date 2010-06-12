package com.uade.mail.client.views;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import com.uade.beans.entities.Casilla;
import com.uade.beans.entities.OficinaDeCorreo;
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
public class MenuFrame extends javax.swing.JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7263844117190098177L;
	private JTabbedPane tabbedPane;
	private JPanel tab1;
	private JPanel tab2;
	private JScrollPane jScrollPane1;
	private JButton modificarBtn;
	private JButton btnNuevo;
	private JButton btnVinculos;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnContrasenia;
	private JScrollPane jScrollPane2;
	private JButton eliminarBtn;
	private JButton nuevoBtn;
	private JTable usuariosTable;
	private JTable centrosTable;

	private CasillaTableModel modelCasilla;
	private CentroTableModel modelCentros;
	//Controller
	private MenuFrameController c;

	/**
	* Auto-generated main method to display this JDialog
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MenuFrame inst = new MenuFrame(new MenuFrameController());
				inst.setVisible(true);
			}
		});
	}
	
	public MenuFrame(MenuFrameController controller) {
		super();
		c = controller;
		if(c.getModel()==null)
			JOptionPane.showMessageDialog(null, "No se pudo conectar al servidor RMI");
		else
			initGUI();
	}
	
	private void initGUI() {
		try {
			{
				this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				this.addWindowListener(new WindowAdapter() {
					public void windowClosed(WindowEvent evt) {
						thisWindowClosed(evt);
					}
				});
			}
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
					tabbedPane.addTab("Usuarios", groups, tab1, "Administración de usuarios");
					tab1.setPreferredSize(new java.awt.Dimension(721, 432));
					{
						jScrollPane1 = new JScrollPane();
						{
							usuariosTable = new JTable();
							jScrollPane1.setViewportView(usuariosTable);
							modelCasilla = new CasillaTableModel();
							modelCasilla.addCasillaList(c.getAccounts());
							usuariosTable.setModel(modelCasilla);
						}
					}
					{
						btnContrasenia = new JButton();
						btnContrasenia.setText("Contraseña");
						btnContrasenia.setIcon(passwd);
						btnContrasenia.setFont(new java.awt.Font("AlArabiya",0,10));
						btnContrasenia.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								btnContraseniaActionPerformed(evt);
							}
						});
					}
					{
						modificarBtn = new JButton();
						modificarBtn.setText("Modificar Usuario");
						modificarBtn.setFont(new java.awt.Font("AlArabiya",0,10));
						modificarBtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								modificarBtnActionPerformed(evt);
							}
						});
					}
					{
						eliminarBtn = new JButton();
						eliminarBtn.setText("Eliminar");
						eliminarBtn.setFont(new java.awt.Font("AlArabiya",0,10));
						eliminarBtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								eliminarBtnActionPerformed(evt);
							}
						});
					}
					{
						nuevoBtn = new JButton();
						nuevoBtn.setText("Nuevo");
						nuevoBtn.setFont(new java.awt.Font("AlArabiya",0,10));
						nuevoBtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								nuevoBtnActionPerformed(evt);
							}
						});
					}
					tab1Layout.setHorizontalGroup(tab1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(tab1Layout.createParallelGroup()
						    .addGroup(GroupLayout.Alignment.LEADING, tab1Layout.createSequentialGroup()
						        .addComponent(nuevoBtn, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
						        .addGap(0, 209, Short.MAX_VALUE)
						        .addComponent(btnContrasenia, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
						        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						        .addComponent(eliminarBtn, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
						        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						        .addComponent(modificarBtn, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
						    .addComponent(jScrollPane1, GroupLayout.Alignment.LEADING, 0, 695, Short.MAX_VALUE))
						.addContainerGap());
					tab1Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnContrasenia, eliminarBtn, modificarBtn});
					tab1Layout.setVerticalGroup(tab1Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jScrollPane1, 0, 367, Short.MAX_VALUE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(tab1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						    .addComponent(nuevoBtn, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(btnContrasenia, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(eliminarBtn, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(modificarBtn, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap());
					tab1Layout.linkSize(SwingConstants.VERTICAL, new Component[] {eliminarBtn, nuevoBtn, modificarBtn});
				}
				{
					tab2 = new JPanel();
					GroupLayout tab2Layout = new GroupLayout((JComponent)tab2);
					tab2.setLayout(tab2Layout);
					tabbedPane.addTab("Centros de Correo", office, tab2, "Administracion de Oficinas de Correo");
					{
						jScrollPane2 = new JScrollPane();
						{
							centrosTable = new JTable();
							jScrollPane2.setViewportView(centrosTable);
							modelCentros = new CentroTableModel();
							modelCentros.addOficinaDeCorreoList(c.getOffices());
							centrosTable.setModel(modelCentros);
						}
					}
					{
						btnEliminar = new JButton();
						btnEliminar.setText("Eliminar");
						btnEliminar.setFont(new java.awt.Font("AlArabiya",0,10));
						btnEliminar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								btnEliminarActionPerformed(evt);
							}
						});
					}
					{
						btnModificar = new JButton();
						btnModificar.setText("Modificar");
						btnModificar.setFont(new java.awt.Font("AlArabiya",0,10));
						btnModificar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								btnModificarActionPerformed(evt);
							}
						});
					}
					{
						btnVinculos = new JButton();
						btnVinculos.setText("Vinculos Confianza");
						btnVinculos.setIcon(links);
						btnVinculos.setFont(new java.awt.Font("AlArabiya",0,10));
						btnVinculos.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								btnVinculosActionPerformed(evt);
							}
						});
					}
					{
						btnNuevo = new JButton();
						btnNuevo.setText("Nuevo");
						btnNuevo.setFont(new java.awt.Font("AlArabiya",0,10));
						btnNuevo.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								btnNuevoActionPerformed(evt);
							}
						});
					}
					tab2Layout.setHorizontalGroup(tab2Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(tab2Layout.createParallelGroup()
						    .addGroup(GroupLayout.Alignment.LEADING, tab2Layout.createSequentialGroup()
						        .addComponent(btnNuevo, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
						        .addGap(0, 203, Short.MAX_VALUE)
						        .addComponent(btnVinculos, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
						        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						        .addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
						        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						        .addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
						    .addComponent(jScrollPane2, GroupLayout.Alignment.LEADING, 0, 695, Short.MAX_VALUE))
						.addContainerGap());
					tab2Layout.setVerticalGroup(tab2Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jScrollPane2, 0, 372, Short.MAX_VALUE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(tab2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						    .addComponent(btnNuevo, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(btnVinculos, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(btnEliminar, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(btnModificar, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(6));
					tab2Layout.linkSize(SwingConstants.VERTICAL, new Component[] {btnNuevo, btnVinculos, btnEliminar, btnModificar});
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
    
    private void nuevoBtnActionPerformed(ActionEvent evt) {
    	System.out.println("nuevoBtn.actionPerformed, event="+evt);
    	new SelectUserFrame(c, this).setVisible(true);
    }
    
    public void updateWindow(){
    	modelCasilla.getDatalist().removeAllElements();
    	modelCentros.getDatalist().removeAllElements();
    	modelCasilla.addCasillaList(c.getAccounts());
    	modelCentros.addOficinaDeCorreoList(c.getOffices());
    }
    
    private void btnContraseniaActionPerformed(ActionEvent evt) {
    	System.out.println("btnContrasenia.actionPerformed, event="+evt);
    	Casilla casilla = this.modelCasilla.getCasillAt(this.usuariosTable.getSelectedRow());
    	if(casilla!=null)
    		new ChangPasswdFrame(c,this,casilla).setVisible(true);
    	else
    		JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna casilla");

    }
    
    private void eliminarBtnActionPerformed(ActionEvent evt) {
    	System.out.println("eliminarBtn.actionPerformed, event="+evt);
    	Casilla casilla = this.modelCasilla.getCasillAt(this.usuariosTable.getSelectedRow());
    	if(casilla!=null){
    		this.c.eliminarCasilla(casilla);
    		this.updateWindow();
    	}
    	else
    		JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna casilla");
    }
    
    private void modificarBtnActionPerformed(ActionEvent evt) {
    	System.out.println("modificarBtn.actionPerformed, event="+evt);
    	Casilla casilla = this.modelCasilla.getCasillAt(this.usuariosTable.getSelectedRow());
    	if(casilla!=null){
    		new EditUserFrame(c,this,casilla.getInfoUsuario()).setVisible(true);
    	}
    }
    
    private void btnNuevoActionPerformed(ActionEvent evt) {
    	System.out.println("btnNuevo.actionPerformed, event="+evt);
    	new NewOfficeFrame(c,this).setVisible(true);
    }
    
    private void btnModificarActionPerformed(ActionEvent evt) {
    	System.out.println("btnModificar.actionPerformed, event="+evt);
    	OficinaDeCorreo oficinaSelected = this.modelCentros.getOficinaDeCorreoAt(this.centrosTable.getSelectedRow());
    	new EditOfficeFrame(c,this,oficinaSelected).setVisible(true);
    }
    
    private void btnEliminarActionPerformed(ActionEvent evt) {
    	System.out.println("btnEliminar.actionPerformed, event="+evt);
    	OficinaDeCorreo oficinaSeleccionada = this.modelCentros.getOficinaDeCorreoAt(this.centrosTable.getSelectedRow());
    	this.c.eliminarOficinaDeCorreo(oficinaSeleccionada);
    	this.updateWindow();
    }
    
    private void btnVinculosActionPerformed(ActionEvent evt) {
    	System.out.println("btnVinculos.actionPerformed, event="+evt);
    	OficinaDeCorreo oficinaSeleccionada = this.modelCentros.getOficinaDeCorreoAt(this.centrosTable.getSelectedRow());
    	new EditTrustedLinksFrame(c,this,oficinaSeleccionada).setVisible(true);
    }
    
    private void thisWindowClosed(WindowEvent evt) {
    	System.out.println("this.windowClosed, event="+evt);
    	
    	
    	//setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	
    	//Sergio: Da error al cerrar, por alguna razon no reconoce
    	//ese parametro como valido. Lo correcto sería:
    	//setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    	//Pero cierra la ventana y no la aplicacion. Eso es porque deben quedar
    	//eventos referenciados, por ejemplo, todo el proceso de baja de
    	//de los controladores, vistas, etc.
    	   	
    	//Con esto lo cierro si o si al programa, pero de todas formas
    	//No es lo correcto.
    	
    	System.exit(0);

    }
}
