package net.javahispano.nettools.cliente.UI;

import java.beans.PropertyChangeListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.*;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeModel;
import net.javahispano.nettools.cliente.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileFilter;
import java.lang.Object;
import javax.swing.border.*;
import java.net.*;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Position;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/**
 * <p>T�tulo: NetTools </p>
 * <p>Descripci�n: Herramienta de Administraci�n remota Windows 2000</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Empresa: fenomenoweb</p>
 * @author Juan Garrido Caballero y Abraham Otero
 * @version 0.8
 */

public class FrameCliente extends JFrame implements Informable, TreeSelectionListener,TreeExpansionListener {
  private EjecutaComandos ejecutoDeComandos;
  JTabbedPane tabbedPane = new JTabbedPane();
        //ImageIcon icon = createImageIcon("images/middle.gif");
  JTree arbol=null;
   DefaultMutableTreeNode nodeArbol;
 JPanel panel2 =new JPanel();
 public  JList lista;
public  JTree arbolprocesos;
 //JFrame panel2=new JFrame();
 int par=1;
   private JScrollPane scrlDir;
        private JTree treeDir;

    private JScrollPane scrlFiles;
        private DefaultListModel mdlFiles;
        private JList lstFiles;



  TreeSelectionEvent auxx;

  JLabel statusBar = new JLabel();
  ImageIcon iconoListProcess=new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/l_connect.gif"));
  ImageIcon iconoKillProcess=new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/l_cancel.gif"));
  ImageIcon informacionIcono = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/iconinfo.gif"));
  ImageIcon temasIcono = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/help.gif"));
  ImageIcon acercaIcono = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/logo.gif"));
  ImageIcon principalIcono = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/explorer.gif"));
  ImageIcon conectarIcono = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/conexion.gif"));
  ImageIcon desconectarIcono = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/desconexion.gif"));
  ImageIcon telnetIcono = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/telnet.gif"));
  ImageIcon telnet_noIcono = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/telnet.gif"));
  ImageIcon servicesIcono = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/Servicios.gif"));
  ImageIcon creaUsuarioIcono = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/usuario.gif"));
  ImageIcon borra_UsuarioIcono = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/drop.gif"));
  ImageIcon executeIcono = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/Ejecutar.gif"));
  ImageIcon listarIcono = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/listar.gif"));
  ImageIcon formatIcono = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/diskette.gif"));
  ImageIcon regeditIcono = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/regedit.gif"));
  ImageIcon urlIcono = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/explorer.gif"));
  ImageIcon normalIcono = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/scanner.gif"));
  ImageIcon trojansIcono = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/scanner.gif"));
  ImageIcon blockIcono = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/bloqueo.gif"));
  ImageIcon shutdownIcono = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/shutdown.gif"));
  ImageIcon rebootIcono = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/reboot.gif"));
  ImageIcon imagenIcono = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/imagen.gif"));
  ImageIcon downloadsIcono = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/down.gif"));
  ImageIcon unidadesIcono = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/discos.gif"));
  ImageIcon directoryIcono = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/directorio.gif"));
  ImageIcon carpetaIcono = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/directorio.gif"));
  ImageIcon conexion=new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/conex1.gif"));
  ImageIcon help=new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/help2.gif"));
  ImageIcon services=new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/services2.gif"));
  ImageIcon admin=new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/Admin1.gif"));
  ImageIcon action=new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/accion.gif"));
  ImageIcon subdirectories=new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/sub1.gif"));
  ImageIcon scanner=new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/scan.gif"));
  ImageIcon servidor=new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/server.gif"));
  ImageIcon borraDirectorio=new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/borrar_directorio.gif"));
  ImageIcon netTools = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/net.gif"));
  ImageIcon iconoExplorer = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/iexplore.gif"));
  ImageIcon iconoCarpeta = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/carpeta.gif"));
  ImageIcon iconoDownload = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/download.gif"));

  JMenuBar jMenuBar1 = new JMenuBar();
  JMenu conexionMenu = new JMenu();
  JMenu jMenu2 = new JMenu();
  JMenuItem serviciosActivosMenu = new JMenuItem();
  JMenuItem registroRemotoMenu = new JMenuItem();
  JMenuItem abrirURLMenu = new JMenuItem();
  JMenuItem ejecutarMenu = new JMenuItem();
  JMenuItem formatearDisketeMenu = new JMenuItem();
  JMenuItem informacionEquipoMenu = new JMenuItem();
  JMenuItem descargarFicheroMenu = new JMenuItem();
  JMenuItem unidadesDeDiscoMenu = new JMenuItem();
  JMenu jMenu3 = new JMenu();
  JMenu jMenu4 = new JMenu();
  JMenuItem servidorTelnetMenu = new JMenuItem();
  JMenuItem stopTelnetMenu = new JMenuItem();
  JMenu jMenu5 = new JMenu();
  JMenuItem crearUsuarioMenu = new JMenuItem();
  JMenuItem borrarUsuarioMenu = new JMenuItem();
  JMenuItem imagenservidorMenu = new JMenuItem();
  JMenu jMenu6 = new JMenu();
  JMenuItem scanerPuertosMenu = new JMenuItem();
  JMenuItem scannerTroyanosMenu = new JMenuItem();
  JMenu jMenu7 = new JMenu();
  JMenuItem bloquearEquipoMenu = new JMenuItem();
  JMenuItem reinicirEquipoMenu = new JMenuItem();
  JMenuItem apagarEquipoMenu = new JMenuItem();
  JMenu jMenu8 = new JMenu();
  JMenuItem temasDeAyudaMenu = new JMenuItem();
  JMenuItem acercaDeNettolsMenu = new JMenuItem();
  JMenuItem paginaPrincipalMenu = new JMenuItem();
  BorderLayout borderLayout2 = new BorderLayout();
  JRadioButtonMenuItem conectarRadioButton = new JRadioButtonMenuItem();
  JRadioButtonMenuItem desconectarRadioButton = new JRadioButtonMenuItem();
  ButtonGroup buttonGroup1 = new ButtonGroup();
  JMenu jMenu1 = new JMenu();
  JMenuItem ListarDirectorioMenu = new JMenuItem();
  JMenuItem directorioRemotoMenu = new JMenuItem();
  JMenuItem borrarDirectorioMenu = new JMenuItem();
  JScrollPane jScrollPane1 = new JScrollPane();
  JEditorPane consola = new JEditorPane();
  
  JMenuItem jMenuItem1 = new JMenuItem();
  JMenuItem jMenuItem2 = new JMenuItem();
    private TreeExpansionEvent even;

  public FrameCliente() {
    try {
      jbInit();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
    ejecutoDeComandos = new EjecutaComandos(this);
    setIconImage(Toolkit.getDefaultToolkit().createImage(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource(("iconos/logo.gif"))));
  }

  void jbInit() throws Exception {
    JPanel contentPane;
    JPanel PanelTodo;
    JPanel Shell;
    JPanel Status;
    BorderLayout borderLayout1 = new BorderLayout();
    Shell=new JPanel();
    contentPane = (JPanel) this.getContentPane();
    contentPane.setLayout(new GridBagLayout());
    Shell.setLayout(new GridBagLayout());
    GridBagConstraints ShellCons;
    GridBagConstraints TodoCons;
    GridBagConstraints BigPanel;
    GridBagConstraints StatusCons;
//Aspecto de la Shell
    TitledBorder borde=new TitledBorder("Remote Shell");
    Shell.setBorder(borde);
    ShellCons = new GridBagConstraints();
    ShellCons.gridx=0;
    ShellCons.gridy=0;
    ShellCons.fill=ShellCons.BOTH;
    ShellCons.gridwidth=2;
    ShellCons.insets=new java.awt.Insets(5,5,5,5);
    ShellCons.weightx=1.0;
    ShellCons.weighty=1.0;
    consola.setBackground(Color.black);
    consola.setForeground(Color.green);
    consola.setPreferredSize(new Dimension(36, 21));

    


    jMenuItem1.setText("Listar Procesos");
    jMenuItem1.setIcon(iconoListProcess);
    jMenuItem1.addActionListener(new FrameCliente_ListaProcess_actionAdapter(this));
    jMenuItem2.setText("Matar Procesos");
    jMenuItem2.addActionListener(new FrameCliente_MataProcess_actionAdapter(this));
    jMenuItem2.setIcon(iconoKillProcess);
    jScrollPane1.getViewport().add(consola,null);
    //Shell.add(jScrollPane1,ShellCons);

     tabbedPane.addTab("Remota Shell", null, jScrollPane1,
                "Does nothing");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

     tabbedPane.setPreferredSize(new Dimension(400, 300));
    Shell.add(tabbedPane,ShellCons);





    //Status Bar

    ShellCons = new GridBagConstraints();
    ShellCons.gridx=0;
    ShellCons.gridy=1;
    ShellCons.insets=new java.awt.Insets(5,5,5,5);
    ShellCons.fill=ShellCons.HORIZONTAL;
    statusBar.setText("Inicializado en "+InetAddress.getLocalHost().getCanonicalHostName());
    Shell.add(statusBar,ShellCons);



//PANEL PRINCIPAL

    PanelTodo=new JPanel();
    PanelTodo.setLayout(new GridBagLayout());
    TodoCons=new GridBagConstraints();
    TodoCons.gridx=0;
    TodoCons.gridy=0;
    TodoCons.fill=TodoCons.BOTH;
    TodoCons.insets=new java.awt.Insets(5,5,5,5);
    TodoCons.weightx=1.0;
    TodoCons.weighty=1.0;
    PanelTodo.add(Shell,TodoCons);
// Lo introducimos todo

    BigPanel=new GridBagConstraints();
    BigPanel.fill=BigPanel.BOTH;
    BigPanel.weightx=1.0;
    BigPanel.weighty=1.0;
    contentPane.add(PanelTodo,BigPanel);

    this.setJMenuBar(jMenuBar1);
    this.addWindowListener(new FrameCliente_this_windowAdapter(this));
    conexionMenu.setHorizontalTextPosition(SwingConstants.TRAILING);
    conexionMenu.setIcon(conexion
                         );
    setTitle("NetTools 0.7 Beta Administraci�n Remota"); //T�tulo del frame
    conexionMenu.setText("Conexión");
    jMenu2.setActionCommand("Servicios");
    jMenu2.setIcon(services);
    jMenu2.setMargin(new Insets(2, 2, 2, 2));
    jMenu2.setText("Servicios");
    serviciosActivosMenu.setIcon(servicesIcono);
    serviciosActivosMenu.setText("Servicios Activos");
    serviciosActivosMenu.addActionListener(new
        FrameCliente_serviciosActivosMenu_actionAdapter(this));
    registroRemotoMenu.setIcon(regeditIcono);
    registroRemotoMenu.setText("Registro Remoto");
    registroRemotoMenu.addActionListener(new
        FrameCliente_registroRemotoMenu_actionAdapter(this));
    abrirURLMenu.setIcon(urlIcono);
    abrirURLMenu.setText("Abrir Url");
    abrirURLMenu.addActionListener(new FrameCliente_abrirURLMenu_actionAdapter(this));
    ejecutarMenu.setMaximumSize(new Dimension(32767, 32767));
    ejecutarMenu.setIcon(executeIcono);
    ejecutarMenu.setText("Ejecutar");
    ejecutarMenu.addActionListener(new FrameCliente_ejecutarMenu_actionAdapter(this));
    formatearDisketeMenu.setIcon(formatIcono);
    formatearDisketeMenu.setMnemonic('0');
    formatearDisketeMenu.setText("Formatear Diskete");
    formatearDisketeMenu.addActionListener(new
        FrameCliente_formatearDisketeMenu_actionAdapter(this));
    informacionEquipoMenu.setIcon(informacionIcono);
    informacionEquipoMenu.setMargin(new Insets(2, 2, 2, 2));
    informacionEquipoMenu.setText("Informaci�n Equipo");
    informacionEquipoMenu.addActionListener(new
        FrameCliente_informacionEquipoMenu_actionAdapter(this));
    descargarFicheroMenu.setIcon(downloadsIcono);
    descargarFicheroMenu.setText("Descargar Fichero");
    descargarFicheroMenu.addActionListener(new
        FrameCliente_descargarFicheroMenu_actionAdapter(this));
    unidadesDeDiscoMenu.setIcon(unidadesIcono);
    unidadesDeDiscoMenu.setText("Unidades de disco");
    unidadesDeDiscoMenu.addActionListener(new
        FrameCliente_unidadesDeDiscoMenu_actionAdapter(this));
    servidorTelnetMenu.setText("Directorios");
    servidorTelnetMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke('R',
        java.awt.event.KeyEvent.ALT_MASK, false));
    servidorTelnetMenu.addActionListener(new
        FrameCliente_servidorTelnetMenu_actionAdapter(this));
    jMenu4.setIcon(servidor);
    jMenu4.setMargin(new Insets(2, 2, 2, 2));
    jMenu4.setText("Servidores");
    servidorTelnetMenu.setIcon(telnetIcono);
    servidorTelnetMenu.setText("Servidor Telnet");
    stopTelnetMenu.setIcon(telnet_noIcono);
    stopTelnetMenu.setText("Stop Telnet");
    stopTelnetMenu.addActionListener(new
                                     FrameCliente_stopTelnetMenu_actionAdapter(this));
    jMenu5.setIcon(admin);
    jMenu5.setMargin(new Insets(2, 2, 2, 2));
    jMenu5.setText("Administración");
    crearUsuarioMenu.setIcon(creaUsuarioIcono);
    crearUsuarioMenu.setMargin(new Insets(2, 2, 2, 2));
    crearUsuarioMenu.setText("Crear Usuario");
    crearUsuarioMenu.addActionListener(new
        FrameCliente_crearUsuarioMenu_actionAdapter(this));
    borrarUsuarioMenu.setMaximumSize(new Dimension(32767, 32767));
    borrarUsuarioMenu.setIcon(borra_UsuarioIcono);
    borrarUsuarioMenu.setText("Borrar Usuario");
    borrarUsuarioMenu.addActionListener(new
        FrameCliente_borrarUsuarioMenu_actionAdapter(this));
    imagenservidorMenu.setIcon(imagenIcono);
    imagenservidorMenu.setMnemonic('0');
    imagenservidorMenu.setText("Imagen Servidor");
    imagenservidorMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke('I',
        java.awt.event.KeyEvent.ALT_MASK, false));
    imagenservidorMenu.addActionListener(new
        FrameCliente_imagenservidorMenu_actionAdapter(this));
    jMenu6.setIcon(scanner);
    jMenu6.setMargin(new Insets(2, 2, 2, 2));
    jMenu6.setText("Scanner");
    scanerPuertosMenu.setIcon(trojansIcono);
    scanerPuertosMenu.setText("Scanner Puertos");
    scanerPuertosMenu.addActionListener(new
        FrameCliente_scanerPuertosMenu_actionAdapter(this));
    scannerTroyanosMenu.setIcon(trojansIcono);
    scannerTroyanosMenu.setText("Scanner Troyanos");
    scannerTroyanosMenu.addActionListener(new
        FrameCliente_scannerTroyanosMenu_actionAdapter(this));
    jMenu7.setIcon(action);
    jMenu7.setMargin(new Insets(2, 2, 2, 2));
    jMenu7.setText("Acciones");
    bloquearEquipoMenu.setIcon(blockIcono);
    bloquearEquipoMenu.setText("Bloquear Equipo");
    bloquearEquipoMenu.addActionListener(new
        FrameCliente_bloquearEquipoMenu_actionAdapter(this));
    reinicirEquipoMenu.setIcon(rebootIcono);
    reinicirEquipoMenu.setText("Reiniciar Equipo");
    reinicirEquipoMenu.addActionListener(new
        FrameCliente_reinicirEquipoMenu_actionAdapter(this));
    apagarEquipoMenu.setIcon(shutdownIcono);
    apagarEquipoMenu.setText("Apagar Equipo");
    apagarEquipoMenu.addActionListener(new
        FrameCliente_apagarEquipoMenu_actionAdapter(this));
    jMenu8.setIcon(help);
    jMenu8.setText("Ayuda");
    temasDeAyudaMenu.setIcon(temasIcono);
    temasDeAyudaMenu.setText("Temas de ayuda");
    temasDeAyudaMenu.addActionListener(new
        FrameCliente_temasDeAyudaMenu_actionAdapter(this));
    acercaDeNettolsMenu.setMinimumSize(new Dimension(0, 0));
    acercaDeNettolsMenu.setIcon(acercaIcono);
    acercaDeNettolsMenu.setText("Acerca de NetTools");
    acercaDeNettolsMenu.addActionListener(new
        FrameCliente_acercaDeNettolsMenu_actionAdapter(this));
    paginaPrincipalMenu.setIcon(principalIcono);
    paginaPrincipalMenu.setText("Página principal de NetTools");
    paginaPrincipalMenu.addActionListener(new
        FrameCliente_paginaPrincipalMenu_actionAdapter(this));
    conectarRadioButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke('O',
        java.awt.event.KeyEvent.CTRL_MASK, false));
    conectarRadioButton.setIcon(conectarIcono);
    conectarRadioButton.setMinimumSize(new Dimension(0, 0));
    conectarRadioButton.setMnemonic('0');
    conectarRadioButton.setText("Conectar");
    conectarRadioButton.addActionListener(new
                                          FrameCliente_conectarRadioButton_actionAdapter(this));
    desconectarRadioButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
        'D', java.awt.event.KeyEvent.CTRL_MASK, false));
    desconectarRadioButton.setIcon(desconectarIcono);
    desconectarRadioButton.setSelected(true);
    desconectarRadioButton.setText("Desconectar");
    desconectarRadioButton.addActionListener(new
        FrameCliente_desconectarRadioButton_actionAdapter(this));
    jMenu1.setMaximumSize(new Dimension(32767, 32767));
    jMenu1.setIcon(subdirectories);
    jMenu1.setText("Directorios");
    ListarDirectorioMenu.setIcon(listarIcono);
    ListarDirectorioMenu.setMargin(new Insets(2, 2, 2, 2));
    ListarDirectorioMenu.setText("Listar Directorio");
    ListarDirectorioMenu.addActionListener(new
        FrameCliente_ListarDirectorioMenu_actionAdapter(this));
    directorioRemotoMenu.setIcon(directoryIcono);
    directorioRemotoMenu.setText("Directorio Remoto");
    directorioRemotoMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke('R',
        java.awt.event.KeyEvent.ALT_MASK, false));
    directorioRemotoMenu.addActionListener(new
        FrameCliente_directorioRemotoMenu_actionAdapter(this));
    borrarDirectorioMenu.setIcon(borraDirectorio);
    borrarDirectorioMenu.setText("Borrar Directorio");
    borrarDirectorioMenu.addActionListener(new
        FrameCliente_borrarDirectorioMenu_actionAdapter(this));
    jMenuBar1.add(conexionMenu);
    jMenuBar1.add(jMenu2);
    jMenuBar1.add(jMenu4);
    jMenuBar1.add(jMenu5);
    jMenuBar1.add(jMenu6);
    jMenuBar1.add(jMenu7);
    jMenuBar1.add(jMenu8);
    conexionMenu.add(conectarRadioButton);
    conexionMenu.add(desconectarRadioButton);
    jMenu2.add(serviciosActivosMenu);
    jMenu2.addSeparator();
    jMenu2.add(registroRemotoMenu);
    jMenu2.addSeparator();
    jMenu2.add(abrirURLMenu);
    jMenu2.addSeparator();
    jMenu2.add(ejecutarMenu);
    jMenu2.addSeparator();
    jMenu2.add(formatearDisketeMenu);
    jMenu2.addSeparator();
    jMenu2.add(informacionEquipoMenu);
    jMenu2.addSeparator();
    jMenu2.add(descargarFicheroMenu);
    jMenu2.addSeparator();
    jMenu2.add(unidadesDeDiscoMenu);
    jMenu2.addSeparator();
    jMenu2.add(jMenu1);
    jMenu2.add(servidorTelnetMenu);
    jMenu4.add(servidorTelnetMenu);
    jMenu4.addSeparator();
    jMenu4.add(stopTelnetMenu);
    jMenu5.add(crearUsuarioMenu);
    jMenu5.addSeparator();
    jMenu5.add(borrarUsuarioMenu);
    jMenu5.addSeparator();
    jMenu5.add(imagenservidorMenu);
    jMenu5.addSeparator();
    jMenu5.add(jMenuItem1);
    jMenu5.addSeparator();
    jMenu5.add(jMenuItem2);
    jMenu6.add(scanerPuertosMenu);
    jMenu6.addSeparator();
    jMenu6.add(scannerTroyanosMenu);
    jMenu7.add(bloquearEquipoMenu);
    jMenu7.addSeparator();
    jMenu7.add(reinicirEquipoMenu);
    jMenu7.addSeparator();
    jMenu7.add(apagarEquipoMenu);
    jMenu8.add(temasDeAyudaMenu);
    jMenu8.addSeparator();
    jMenu8.add(acercaDeNettolsMenu);
    jMenu8.addSeparator();
    jMenu8.add(paginaPrincipalMenu);
    buttonGroup1.add(conectarRadioButton);
    buttonGroup1.add(desconectarRadioButton);
    jMenu1.add(ListarDirectorioMenu);
    jMenu1.add(directorioRemotoMenu);
    jMenu1.add(borrarDirectorioMenu);
  }

  public static void main(String[] args) {

    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch (Exception ex) {
      JOptionPane.showConfirmDialog(null,
                                    "No se ha podido cargar entorno Windows",
                                    "Error Message", JOptionPane.ERROR_MESSAGE);
    }

    FrameCliente frameCliente = new FrameCliente();
    frameCliente.setSize(600, 400);
    frameCliente.setVisible(true);
    frameCliente.setLocationRelativeTo(null);
  }



  public void mensageReconstruirArbol(String SubdirectoriosArbol){
    this.ExpandirArbol(SubdirectoriosArbol);

  }



   /**
   *
   * @param texto String
   * @todo Implement this net.javahispano.nettools.ciente.Informable method
   */
  public void mensageInformacionArbol(String DatosArbol) {
        try {
            System.out.println("SSSSSSSSSS"+DatosArbol);
            this.NuevaPesta(DatosArbol);

            // consola.setText(texto);
        } catch (Exception ex) {
            Logger.getLogger(FrameCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
  }




  /**
   *
   * @param texto String
   * @todo Implement this net.javahispano.nettools.ciente.Informable method
   */
  public void mensageInformacion(String texto) {
    consola.setText(texto);
  }

  /**
   * Envia un mensage de error.
   *
   * @param texto String
   * @todo Implement this net.javahispano.nettools.ciente.Informable method
   */
  public void mensageError(String texto) {
    consola.setText(texto);
  }

  public void StatusConex(String status)
  {
    statusBar.setText("Conectado a "+status);
  }

public void StatusDesc(String desc)
{
  statusBar.setText(desc);
}
  /**
   * Envia un entero entre 0 y 100 informando del progreso de una acci�n.
   *
   * @param progreso int
   * @todo Implement this net.javahispano.nettools.ciente.Informable method
   */
  public void informaSobreElProgreso(int progreso) {
  }

  /**
   * M�todo que informa si se ha de desconectar o no del servidor.
   *
   * @return boolean
   * @todo Implement this net.javahispano.nettools.ciente.Informable method
   */
  public boolean isConnected() {
    return conectarRadioButton.isSelected();
  }

  /**
   * recibeMensaje
   *
   * @return Objeto
   * @todo Implement this net.javahispano.nettools.ciente.Informable method
   */
  public Objeto recibeMensaje() {
    return null;
  }

  void conectarRadioButton_actionPerformed(ActionEvent e) {
    Object opcion;
    opcion = JOptionPane.showInputDialog(null, "Terminal a conectar",
                                         "conexi�n", JOptionPane.DEFAULT_OPTION,
                                         blockIcono, null, null);
    if (opcion == null) {
      return;
    }
    try {
      ejecutoDeComandos.conectar(opcion.toString());
    }
    catch (Exception ex) {
      JOptionPane.showConfirmDialog(null, ex.getMessage(), "conexion",
                                    JOptionPane.DEFAULT_OPTION,
                                    JOptionPane.ERROR_MESSAGE);
      conectarRadioButton.setSelected(false);
    }

  }

  void informacionEquipoMenu_actionPerformed(ActionEvent e) {
    try {
      ejecutoDeComandos.getInformacionHost();
    }
    catch (Exception ex) {
      JOptionPane.showConfirmDialog(null, ex.getMessage(), "conexion",
                                    JOptionPane.CLOSED_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE);
    }

  }

  void abrirURLMenu_actionPerformed(ActionEvent e) {
    Object opcion = JOptionPane.showInputDialog(null, "Url a ejecutar",
                                                "explorer",
                                                JOptionPane.DEFAULT_OPTION,
                                                iconoExplorer, null, null);
    try {
      ejecutoDeComandos.abrirURL(opcion.toString());
    }
    catch (NuestraExeption ex) {
      JOptionPane.showConfirmDialog(null, ex.getMessage(), "conexion",
                                    JOptionPane.CLOSED_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE);
    }

  }

  void ejecutarMenu_actionPerformed(ActionEvent e) {
    Object opcion = JOptionPane.showInputDialog(null, "Escriba el nombre del programa,carpeta,documento o\nrecurso de internet que desea que Windows abra.",
                                                "Ejecutar",
                                                JOptionPane.YES_NO_OPTION,
                                                executeIcono, null, null);
    try {
      ejecutoDeComandos.RundllConecta(opcion.toString());
    }
    catch (NuestraExeption ex) {
      JOptionPane.showConfirmDialog(null, ex.getMessage(), "conexion",
                                    JOptionPane.CLOSED_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE);
    }

  }

  void crearUsuarioMenu_actionPerformed(ActionEvent e) {
    String usuario = JOptionPane.showInputDialog("Nombre usuario");
    try {
      ejecutoDeComandos.crearUsuario(usuario);
    }
    catch (NuestraExeption ex) {
      JOptionPane.showConfirmDialog(null, ex.getMessage(), "conexion",
                                    JOptionPane.CLOSED_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE);
    }

  }

  void registroRemotoMenu_actionPerformed(ActionEvent e) {

    int respuesta = JOptionPane.showConfirmDialog(null,
                                                  "Desea acceder al registro remoto?",
                                                  "telnet",
                                                  JOptionPane.
                                                  YES_NO_CANCEL_OPTION,
                                                  JOptionPane.
                                                  INFORMATION_MESSAGE);
    if (respuesta == JOptionPane.YES_OPTION) {
      try {
        ejecutoDeComandos.arrancarTelnet();
      }
      catch (NuestraExeption ex) {
        JOptionPane.showConfirmDialog(null, ex.getMessage(), "conexion",
                                      JOptionPane.CLOSED_OPTION,
                                      JOptionPane.INFORMATION_MESSAGE);
      }

    }

  }

  void servidorTelnetMenu_actionPerformed(ActionEvent e) {
    int respuesta;
    respuesta = JOptionPane.showConfirmDialog(null,
                                              "�Desea arrancar el servicio de telnet?",
                                              "telnet",
                                              JOptionPane.YES_NO_CANCEL_OPTION,
                                              JOptionPane.INFORMATION_MESSAGE);
    if (respuesta == JOptionPane.YES_OPTION) {
      try {
        ejecutoDeComandos.arrancarTelnet();
      }
      catch (NuestraExeption ex) {
        JOptionPane.showConfirmDialog(null, ex.getMessage(), "conexion",
                                      JOptionPane.CLOSED_OPTION,
                                      JOptionPane.INFORMATION_MESSAGE);
      }

    }

  }

  void stopTelnetMenu_actionPerformed(ActionEvent e) {
    try {
      ejecutoDeComandos.reiniciaTelnet();
    }
    catch (NuestraExeption ex) {
      JOptionPane.showConfirmDialog(null, ex.getMessage(), "conexion",
                                    JOptionPane.CLOSED_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE);
    }

  }

  void formatearDisketeMenu_actionPerformed(ActionEvent e) {
    try {
      ejecutoDeComandos.formateaDiskete();
    }
    catch (NuestraExeption ex) {
      JOptionPane.showConfirmDialog(null, ex.getMessage(), "conexion",
                                    JOptionPane.CLOSED_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE);
    }

  }

  void bloquearEquipoMenu_actionPerformed(ActionEvent e) {
    try {
      ejecutoDeComandos.bloquearEquipo();
    }
    catch (NuestraExeption ex) {
      JOptionPane.showConfirmDialog(null, ex.getMessage(), "conexion",
                                    JOptionPane.CLOSED_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE);
    }

  }

  void ListarDirectorioMenu_actionPerformed(ActionEvent e) {
        try {
    //        this.NuevaPesta();
        } catch (Exception ex) {
            Logger.getLogger(FrameCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    Object objeto = JOptionPane.showInputDialog(null, "�Directorio a listar?",
                                                "directorio",
                                                JOptionPane.DEFAULT_OPTION,
                                                iconoCarpeta, null, null);

    try {

    // ejecutoDeComandos.listarUnidades();
      ejecutoDeComandos.listarDirectorio(objeto.toString());
    }
    catch (NuestraExeption ex) {
      JOptionPane.showConfirmDialog(null, ex.getMessage(), "conexion",
                                    JOptionPane.CLOSED_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE);
    }

  }

  void desconectarRadioButton_actionPerformed(ActionEvent e) {
    try {
      ejecutoDeComandos.desconectar();
    }
    catch (NuestraExeption ex) {
      ex.printStackTrace();
    }
    JOptionPane.showConfirmDialog(null, "Desconectados del Servidor",
                                  "desconexi�n", JOptionPane.CLOSED_OPTION,
                                  JOptionPane.INFORMATION_MESSAGE);
    conectarRadioButton.setEnabled(true);
  }

  void scannerTroyanosMenu_actionPerformed(ActionEvent e) {
    ejecutoDeComandos.buscaTroyanos();
  }

  void scanerPuertosMenu_actionPerformed(ActionEvent e) {

    ejecutoDeComandos.escaneaPuertos();
  }

  void acercaDeNettolsMenu_actionPerformed(ActionEvent e) {
    JOptionPane.showConfirmDialog(null,
        "Aplicaci�n realizada en Java y C.\nProgramado por Juan Garrido Caballero y \n Abraham Otero Quintana y \n Adolfo Sanz",
                                  "NetTools 0.7", JOptionPane.CLOSED_OPTION,
                                  JOptionPane.CANCEL_OPTION, netTools);

  }

  void borrarUsuarioMenu_actionPerformed(ActionEvent e) {
    Object opcion = JOptionPane.showInputDialog(null,
        "Introduzca el nombre del usuario a borrar", "Usuarios",
                                                JOptionPane.DEFAULT_OPTION,
                                                creaUsuarioIcono, null, null);

    try {
      ejecutoDeComandos.borrarUsuario(opcion.toString());
    }
    catch (NuestraExeption ex) {
      JOptionPane.showConfirmDialog(null, ex.getMessage(), "conexion",
                                    JOptionPane.CLOSED_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE);
    }

  }

  void serviciosActivosMenu_actionPerformed(ActionEvent e) {
    try {
      ejecutoDeComandos.listarServiciosActivos();
    }
    catch (NuestraExeption ex) {
      JOptionPane.showConfirmDialog(null, ex.getMessage(), "conexion",
                                    JOptionPane.CLOSED_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE);
    }

  }

  void reinicirEquipoMenu_actionPerformed(ActionEvent e) {
    try {
      ejecutoDeComandos.reiniciarServidor();
    }
    catch (NuestraExeption ex) {
      JOptionPane.showConfirmDialog(null, ex.getMessage(), "conexion",
                                    JOptionPane.CLOSED_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE);
    }

  }

  void apagarEquipoMenu_actionPerformed(ActionEvent e) {
    try {
      ejecutoDeComandos.apagarServidor();
    }
    catch (NuestraExeption ex) {
      JOptionPane.showConfirmDialog(null, ex.getMessage(), "conexion",
                                    JOptionPane.CLOSED_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE);
    }

  }

  void paginaPrincipalMenu_actionPerformed(ActionEvent e) {
    try {
      Runtime.getRuntime().exec(
          "rundll32.exe url.dll FileProtocolHandler http://nettools.javahispano.net/");
      System.out.println(Runtime.getRuntime().maxMemory());
    }
    catch (Exception event) {
      JOptionPane.showConfirmDialog(null, "No se ha podido cargar la Web",
                                    "Web NetTools", JOptionPane.CLOSED_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE);
    }
  }

  void borrarDirectorioMenu_actionPerformed(ActionEvent e) {
    Object opcion;
    opcion = JOptionPane.showInputDialog(null,
        "Atenci�n!! Va usted a borrar directorios\nen la m�quina remota",
                                         "Borrar Directorio",
                                         JOptionPane.OK_OPTION, borraDirectorio, null, null);

    try {
      ejecutoDeComandos.borrarDirectorio(opcion.toString());
    }
    catch (NuestraExeption ex) {
      JOptionPane.showConfirmDialog(null, ex.getMessage(), "conexion",
                                    JOptionPane.CLOSED_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE);
    }

  }

  void imagenservidorMenu_actionPerformed(ActionEvent e) {
    try {
      ejecutoDeComandos.recibirImagenServidor();
    }
    catch (NuestraExeption ex) {
      JOptionPane.showConfirmDialog(null, ex.getMessage(), "conexion",
                                    JOptionPane.CLOSED_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE);
    }

  }

  void descargarFicheroMenu_actionPerformed(ActionEvent e) {
    Object objeto = JOptionPane.showInputDialog(null,
                                                "Nombre del archivo a descargar",
                                                "Download Files",
                                                JOptionPane.YES_NO_OPTION,
                                                iconoDownload, null, null);

    try {
      ejecutoDeComandos.abrirArchivoODirectorio(objeto.toString());
    }
    catch (NuestraExeption ex) {
      JOptionPane.showConfirmDialog(null, ex.getMessage(), "conexion",
                                    JOptionPane.CLOSED_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE);
    }

  }

  void unidadesDeDiscoMenu_actionPerformed(ActionEvent e) {
    try {
      ejecutoDeComandos.listarUnidades();
    }
    catch (NuestraExeption ex) {
      JOptionPane.showConfirmDialog(null, ex.getMessage(), "conexion",
                                    JOptionPane.CLOSED_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE);
    }

  }

  void directorioRemotoMenu_actionPerformed(ActionEvent e) {
    Object objeto = JOptionPane.showInputDialog(null,
                                                "Directorio a listar",
                                                "Directorio Remoto",
                                                JOptionPane.YES_NO_OPTION,
                                                iconoDownload, null, null);

    try {
      ejecutoDeComandos.listarCompleto(objeto.toString());
    }
    catch (NuestraExeption ex) {
      JOptionPane.showConfirmDialog(null, ex.getMessage(), "conexion",
                                    JOptionPane.CLOSED_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE);
    }

  }

  void ListaProcess_actionPerformed(ActionEvent e)
  {

    try
    {
      ejecutoDeComandos.ListarProcesos();
    }
    catch(Exception event)        
    {
      JOptionPane.showConfirmDialog(null, "Lista no inicializada", "List Process",
                                    JOptionPane.CLOSED_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE);
    };
  }

  void MataProcess_actionPerformed(ActionEvent e)
  {
    Object objeto = JOptionPane.showInputDialog(null,
                                                "Proceso a matar",
                                                "Kill Process",
                                                JOptionPane.YES_NO_OPTION,
                                                iconoDownload, null, null);
    try
     {
      ejecutoDeComandos.KillProcesos(objeto.toString());
     }
    catch(Exception event)
    {
      JOptionPane.showConfirmDialog(null, "El Proceso no se puede matar", "Kill Process",
                                    JOptionPane.CLOSED_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE);

    };
  }


  void temasDeAyudaMenu_actionPerformed(ActionEvent e) {
    try {
      Runtime.getRuntime().exec(new String[] {"winhlp32.exe", "NETTOOLS.HLP"});

    }
    catch (Exception event) {
      JOptionPane.showConfirmDialog(null, "Ayuda no encontrada", "Help Files",
                                    JOptionPane.CLOSED_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE);
    }
  }

  void this_windowClosing(WindowEvent e) {
    System.exit(0);
  }

  public void ExpandirArbol(String Datosarbol)
  {
      int inicio = 0,fin=0,cont=0;
        String separador = ">#";
        String aux=null;
        //int campos=NumeroDeSubdirectorios(Datosarbol,separador);
       // Object[] hierarchy=new Object[campos];
System.out.println("Dentro del Expandir"+Datosarbol);
        //DefaultMutableTreeNode top = new DefaultMutableTreeNode(f);
        //-->populateNode(top, f);
       DefaultMutableTreeNode node =null;
    //  new DefaultMutableTreeNode(hierarchy[0]);
DefaultMutableTreeNode hijo=null;


     int startRow = 0;

     fin=Datosarbol.indexOf(separador,inicio);
    aux=Datosarbol.substring(inicio, fin);
      System.out.println("AUXXXXXXXXX "+aux);
     //    int startRow=level;
String prefix = nodeArbol.toString();
    //  String prefix ="/";
     TreePath path = treeDir.getNextMatch(prefix, startRow, Position.Bias.Forward);
      // TreePath path=(auxx.getPath());
      MutableTreeNode node2 = (MutableTreeNode)path.getLastPathComponent();
     DefaultTreeModel model = (DefaultTreeModel) treeDir.getModel();
inicio=fin+2;
     while(inicio<Datosarbol.length()){
     fin=Datosarbol.indexOf(separador,inicio);
    aux=Datosarbol.substring(inicio, fin);

     hijo = new DefaultMutableTreeNode(aux);
     model.insertNodeInto( (DefaultMutableTreeNode) hijo, (DefaultMutableTreeNode) node2, node2.getChildCount());
 //   hierarchy[cont]=(aux);
 //  System.out.println(hierarchy[cont] + "bucle");
    //System.out.println(aux+"aux");
   // System.out.println(inicio +"inicio" + fin +"fin");
        inicio=fin+2;
        cont++;
    }
       

      /*System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYyyyyyyy3333333333333333333");
        
         System.out.println("Contenido evento33333"+even.getSource());
         JTree tree = (JTree) even.getSource();
        DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
        model.nodeStructureChanged(ModeltreeNuevo);

        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));*/

     /*TreePath path= auxx.getPath();

      DefaultMutableTreeNode node=(DefaultMutableTreeNode) path.getLastPathComponent();
    System.out.println("Expandir ArbollLLLLLL");
   if(node == null) return;
     setCursor (new Cursor(Cursor.WAIT_CURSOR));

     File f= (File) node.getUserObject();
*/


   //  DefaultMutableTreeNode nodoNuevo = new DefaultMutableTreeNode("Nuevo");
   /*   nodeArbol = (DefaultMutableTreeNode)arbol.getLastSelectedPathComponent() ;
     ModeltreeNuevo.add(nodeArbol);
      nodeArbol.setUserObject(new DefaultMutableTreeNode(ModeltreeNuevo));
     */
/*
   DefaultMutableTreeNode nodoNuevo = new DefaultMutableTreeNode("Nuevo");
    DefaultMutableTreeNode nodoActual = (DefaultMutableTreeNode)arbol.getLastSelectedPathComponent() ;
    nodoNuevo.add(new DefaultMutableTreeNode(nodoActual));
     nodoActual.setUserObject(new DefaultMutableTreeNode(nodoNuevo));
*/








   /*   System.out.println("AAAAAKKKKKKKIII"+path);
     JTree tree = new JTree(nodeArbol);
        JFrame v = new JFrame ();
        JScrollPane scroll = new JScrollPane(tree);
        v.setTitle("EEEEEEEEEEEEEEEEEEEEECOPIA");
        v.getContentPane().add(scroll);
        v.pack();
        v.setVisible(true);
*/
     //-----arbol.addSelectionPath(path);
     // nodeArbol.insertNodeInto(node, pa,path.getPathCount());
      /* arbol =(JTree)auxx.getSource();
     //arbol.(Modeltree);
     setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
     */
  /*     arbol.repaint();
       panel2.repaint();*/
     //panel2.add(arbol);



/*
JTree tree = new JTree(Modeltree);
        JFrame v = new JFrame();
        JScrollPane scroll = new JScrollPane(tree);
        v.setTitle("Cliente");
        v.getContentPane().add(scroll);
        v.pack();
        v.setVisible(true);*
 /* arbol = new JTree(Modeltree);
  arbol.repaint();
  panel2.add(arbol);*/
     System.out.println("EspannnndDDDDDDDd");
 /* TreePath path= event.getPath();
 DefaultMutableTreeNode node=(DefaultMutableTreeNode) path.getLastPathComponent();
    System.out.println("Expandir ArbollLLLLLL");
   if(node == null) return;
     setCursor (new Cursor(Cursor.WAIT_CURSOR));

     File f= (File) node.getUserObject();
    // populateNode(node,f);
     setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
this.repaint();
      //this.treeExpanded();
*/

  }


public void NuevaPesta(String Datosarbol) throws Exception{
// public void NuevaPesta(Tree arbol) throws Exception{
//tabbedPane
    //TreeSelectionEvent ex = null;
 //    this.comprueba=1;
     System.out.println("entra Funcion creacion arbol"+Datosarbol);
// JPanel Panel3 =new JPanel();
// DefaultMutableTreeNode root = null;    
   //  Panel2 panel2=new Panel2(Modeltree,this);


     String clase = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
      UIManager.setLookAndFeel(clase);
     //arbol = new JTree(Modeltree);
      //JTree arbol = new JTree(root);


      //JScrollBar scroll = new JScrollBar(root);
       // Cambiamos los iconos
   /*     DefaultTreeCellRenderer render= (DefaultTreeCellRenderer)arbol.getCellRenderer();
        render.setLeafIcon(new ImageIcon("C:/Documents and Settings/Usuario/Mis documentos/NetBeansProjects/proye/src/net/javahispano/nettools/cliente/UI/iconos/discos.gif"));
      render.setOpenIcon(new ImageIcon("C:/Documents and Settings/Usuario/Mis documentos/NetBeansProjects/proye/src/net/javahispano/nettools/cliente/UI/iconos/accion.gif"));
       render.setClosedIcon(new ImageIcon("C:/Documents and Settings/Usuario/Mis documentos/NetBeansProjects/proye/src/net/javahispano/nettools/cliente/UI/iconos/accion.gif"));
        setLayout(new BorderLayout());
*/
        this.setLayout(new BorderLayout());

        /** Que tan grandes son los iconos que voy a mostrar en la lista */
        final int ICON_SIZE = 32;

        /**
         * Creo un nuevo File, el constructor que estoy utilizando me permite
         * pasarle un String como la ruta base en la que debe empezar, estoy
         * pasandole "/" que significa el directorio raiz.
         */
        File f = new File("/");
        //File[] roots = File.listRoots();




        /**
         * DefaultMutableTreeNode es la clase que me permite agregar nodos a un
         * JTree, el metodo mas importante de esta clase es add(), con el que
         * podemos agregar nodos hijos
         */
         DefaultMutableTreeNode category = null;
          int inicio = 0,fin=0,cont=0;
        String separador = ">#";
        String aux=null;
        int campos=NumeroDeSubdirectorios(Datosarbol,separador);
        Object[] hierarchy=new Object[campos];
     DefaultMutableTreeNode top = new DefaultMutableTreeNode(f);
        //-->populateNode(top, f);
       DefaultMutableTreeNode node =null;
    //  new DefaultMutableTreeNode(hierarchy[0]);

       while(inicio<Datosarbol.length()){
     fin=Datosarbol.indexOf(separador,inicio);
    aux=Datosarbol.substring(inicio, fin);
    hierarchy[cont]=(aux);
   System.out.println(hierarchy[cont] + "bucle");
    //System.out.println(aux+"aux");
   // System.out.println(inicio +"inicio" + fin +"fin");
        inicio=fin+2;
        cont++;
    }


   //DefaultMutableTreeNode root22 = processHierarchy(hierarchy);

                   /*
             category = new DefaultMutableTreeNode(roots[i]);
             top.add(category);*/
               






         treeDir = new JTree(processHierarchy(hierarchy));
        /**
         * El CellRenderer me permite modificar la manera en que se despliega
         * la informacion en mi JTree, es un poco complicado de implementar
         * pero me da mucha libertad en cuanto a como se dibuja el control en
         * la pantalla
         */


        // treeDir.setCellRenderer(new DirectoryRenderer(ICON_SIZE));


        /**
         * setPreferredSize me permite determinar un ancho y un alto
         * preferentes, que cuando utilizamos el metodo pack se utilizan para
         * generar la interfaz.
         */
        treeDir.setPreferredSize(new Dimension(500, 500));
        /**
         * El JTree tiene dos eventos importantisimos, cuando seleccionan algo
         * utilizamos el TreeSelectionListener para manejar el evento
         */
        treeDir.getSelectionModel().addTreeSelectionListener(this);
        /**
         * El otro evento importante es el ExpansionListener, lo utilizamos
         * para no cargar todo a memoria de un solo golpe y que la aplicacion
         * corra lento.
         */
        treeDir.addTreeExpansionListener(this);
        /**
         * Utilizo un JScrollPane para que aparezcan barras de desplazamiento
         */
        //scrlDir = new JScrollPane(treeDir);
        scrlDir = new JScrollPane(treeDir);
        scrlDir.setVerticalScrollBarPolicy(
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrlDir.setPreferredSize (new Dimension(250,240));
     //   getContentPane().add(scrlDir, BorderLayout.WEST);
          //panel2.add(scrlDir);//.add(scrlDir, BorderLayout.WEST);

       //panel2.getViewport().add(scrlDir,null);
       panel2.add(scrlDir,null);
          mdlFiles = new DefaultListModel();
        lstFiles = new JList(mdlFiles);


        // lstFiles.setCellRenderer(new FileRenderer(ICON_SIZE));

        lstFiles.setPreferredSize(new Dimension(10, 10));
        lstFiles.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        lstFiles.setVisibleRowCount(-1);
        scrlFiles = new JScrollPane(lstFiles);
        scrlFiles.setVerticalScrollBarPolicy(
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
       // getContentPane().add(scrlFiles, BorderLayout.CENTER);
         panel2.add(scrlFiles, BorderLayout.CENTER);
     //   panel2.pack();
     //   panel2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //  panel2.setTitle("Arbol");
        panel2.setVisible(true);
        

         tabbedPane.addTab("Listado Directorios",null,panel2,
                "Does nothing");

      //   tabbedPane.insertTab("Ficha 3", null, Panel3, null,2);
    System.out.println("entra aqui  1");
        this.repaint();
        System.out.println("entra aqui  222");
     
     
     //    this.jbInit();
//    this.show();
}



  /* DefaultMutableTreeNode node1 =
   new DefaultMutableTreeNode(nodeArbol.toString());
    DefaultMutableTreeNode child = null;
    for(int i=1; i<hierarchy.length; i++) {
        System.out.println(hierarchy[i] + "ESTOooooooooooooooooooooooooooooooooo");
      Object nodeSpecifier = hierarchy[i];
      if (nodeSpecifier instanceof Object[])  // Ie node with children
        child = processHierarchy2((Object[])nodeSpecifier);
      else
        child = new DefaultMutableTreeNode(nodeSpecifier); // Ie Leaf
    // node1.add(child);
    }*/

/*
return(node1);
  }
*/




private DefaultMutableTreeNode processHierarchy(Object[] hierarchy) {
    System.out.println("DDEEEEDDDDDDD"+hierarchy.length);
  /*  DefaultMutableTreeNode node1 =
      new DefaultMutableTreeNode(hierarchy[0]);*/
    DefaultMutableTreeNode node1 =
      new DefaultMutableTreeNode("/");
    DefaultMutableTreeNode child;
    for(int i=1; i<hierarchy.length; i++) {
        System.out.println(hierarchy[i] + "ESTOooooooooooooooooooooooooooooooooo");
      Object nodeSpecifier = hierarchy[i];
      if (nodeSpecifier instanceof Object[])  // Ie node with children
        child = processHierarchy((Object[])nodeSpecifier);
      else
        child = new DefaultMutableTreeNode(nodeSpecifier); // Ie Leaf
      node1.add(child);
    }
    return(node1);
  }




public int NumeroDeSubdirectorios(String directorio,String patron){
int contador=0;
while (directorio.indexOf(patron) > -1) {
      directorio = directorio.substring(directorio.indexOf(
        patron)+patron.length(),directorio.length());
      contador++;
}
return contador;
}





  public void treeExpanded(TreeExpansionEvent event) {
  /*      TreePath path = event.getPath();
        DefaultMutableTreeNode node =
                (DefaultMutableTreeNode) path.getLastPathComponent();

        if (node == null) return;

        setCursor(new Cursor(Cursor.WAIT_CURSOR));

        File f = (File) node.getUserObject();
        even=event;
try {
           System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYyyyyyy");
            ejecutoDeComandos.listarDirectorio(node,f);//listarCompleto(node,f);
        } catch (NuestraExeption ex) {
            Logger.getLogger(FrameCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
       
     // populateNode(node,f);
 System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYyyyyyy");
*/
 /*
         JTree tree22 = new JTree(node);
        JFrame v = new JFrame();
        JScrollPane scroll = new JScrollPane(tree22);
        v.getContentPane().add(scroll);
        v.pack();
        v.setVisible(true);*/
   //   this.ExpandirArbol(node);
     
     }

    /**
     * Se ejecuta cuando se cierra una carpeta
     * @param event El evento que sucedio
     */
    public void treeCollapsed(TreeExpansionEvent event) {
    }


     public void valueChanged(TreeSelectionEvent e) {
   
         String rutacompleta="";
         TreePath path = e.getPath();
	 Object [] nodos3 = path.getPath();
         System.out.print("Path seleccionado: ");
         int cont=0;
		for (Object nodo3: nodos3){
		  if (cont>1)
                      rutacompleta+=nodo3.toString()+"/";
                  else{
                    rutacompleta+=nodo3.toString();
                    cont++;
                    }
                     
		System.out.println("++++++++++++"+rutacompleta);
                }
            System.out.println("La ruta completa  a listar es: "+rutacompleta);
           DefaultMutableTreeNode node =
                (DefaultMutableTreeNode) treeDir.getLastSelectedPathComponent();
        auxx=e;
        nodeArbol=node;
        try {
            ejecutoDeComandos.listarDirectorio(rutacompleta);
        } catch (NuestraExeption ex) {
            Logger.getLogger(FrameCliente.class.getName()).log(Level.SEVERE, null, ex);
        }


        }

    public void mensageListarProcesos(String Listaprocesos) {
     // Listaprocesos=Listaprocesos.replaceAll(">#","\n");
        Listar(Listaprocesos);
    }

public void  Listar(String procesos){
    int inicio=0,fin=0;
String separador=">#";
//final JDialog  panelprocesos = null;
final JDialog panelprocesos = new JDialog(this);
//Le pido al Frame su objeto contenedor
//Container contentpane = getContentPane();
//Creo un objeto de tipo JPanel
//JPanel panel = new JPanel();
//Añado el panel en el objeto contenedor del frame






//JPanel panel3=new JPanel ();
    DefaultListModel modelo = new DefaultListModel();
    DefaultTableModel modelo1 = new DefaultTableModel();

//JTable tabla = new JTable (modelo);


 String aux;
    //System.out.println("procesos.length()"+procesos.length());
    int total=NumeroDeSubdirectorios(procesos,separador);
    //System.out.println("total"+total);
    //int total=97;

            // while(inicio<procesos.length()){
            int cont=0;

    //modelo.setValueAt (fila, columna, persona.apellido);
    //columna++;

    String[] columnNames = {"Nombre de imagen", "Pid", "Nombre de sesion",
                                   "CPU", "Uso de memoria"};

    Object[][] data=new Object[total-3][5];
    /*
   Object[][] data = {
       {"Mary", "Campione", "Esquiar", new Integer(5), new Boolean(false)},
*/

String cadena1="";
 int estado=0;
int filas=0,columnas=0;
String campo1="";String campo2="";String campo3="";String campo4="";String campo5="";
  char anterior =' ',siguiente=' ';
int blancos=0;

int i;
int contador=0;
    System.out.println(procesos);
/*fin=procesos.indexOf(separador,inicio);

    inicio=procesos.indexOf(separador,100);
    fin=procesos.indexOf(separador,inicio);
    inicio=procesos.indexOf(separador,fin);
    fin=procesos.indexOf(separador,inicio);*/

    fin=procesos.indexOf(separador,0);

    System.out.println("comienzo encontrado1  "+fin);
    inicio=procesos.indexOf(separador,fin+2);
    System.out.println("comienzo encontrado2  "+inicio);
    fin=procesos.indexOf(separador,inicio+2);
    System.out.println("comienzo encontrado3  "+fin);
   //inicio=procesos.indexOf(separador,fin+2);
    inicio=fin+2;
    //System.out.println("comienzo encontrado4  "+inicio);

    System.out.println("El total sssss"+total);
while(filas<total-3){//total-4
     fin=procesos.indexOf(separador,inicio);
     //System.out.println("inicio"+inicio+ "FIN"+fin);
    aux=procesos.substring(inicio, fin);
    blancos=0;
    columnas=4;
    contador=0;
    System.out.println("AAAAAA33 y aux.leng"+aux +aux.length());
    for(int j=aux.length()-1;j>0;j--)
     {
         System.out.println("aux.charAt(j)"+aux.charAt(j));
    if (estado==0){
        System.out.println("Estamos en el estado 0");
        if (aux.charAt(j)==' '){
            blancos++;

         if (blancos==2)
         {

             System.out.println("Campo4"+campo1);
            data[filas][columnas]=VueltaCadena(campo1);
           campo1=" ";
  //      modelo1.setValueAt (filas, columnas,'');
         columnas--;
          estado=1;
         }
         else
             campo1+=aux.charAt(j);
           anterior=aux.charAt(j);
          // siguiente=aux.charAt(filas+1);

        }
         else
          // blancos++;
         campo1+=aux.charAt(j);
         //cadena1+=procesos.charAt(filas);
       //anterior=procesos.charAt(filas);
       //siguiente=procesos.charAt(filas+1);

      }
       if (estado==1)//campo 2
       {
         System.out.println("Estamos en el estado 1");
          if ((aux.charAt(j)==' ')&&(anterior!=' ')){
              System.out.println("Campo3"+campo1);
              data[filas][columnas]=VueltaCadena(campo1);
           campo1=" ";
           contador++;
  //       modelo1.setValueAt (filas, columnas,'');
         columnas--;
         if (contador==3){
             System.out.println("salimos estado 2");
             estado=2;
             campo1="";
         }
          }
          if (aux.charAt(j)!=' '){
              System.out.println("Concat"+aux.charAt(j));
            campo1+=aux.charAt(j);

          }

            anterior=aux.charAt(j);
       }
       if(estado==2)//ultimo campo
       {
           System.out.println("Estamos en el estado 2");
       if ((aux.charAt(j)==' ')&&(anterior!=' ')){

       }
       else{

        campo1+=aux.charAt(j);
       if (j==1){
          
           campo1+=aux.charAt(j-1);
           System.out.println("Acaba volvemos estado inicial"+campo1);
          data[filas][columnas]=VueltaCadena(campo1);
           campo1=" ";
        estado=0;

            }
          }
        }
    }
     //System.out.println("Campo1"+campo1);
     filas++;
     
     //modelo.addElement(aux);
        inicio=fin+2;
        cont++;

    }


//    final JTable table = new JTable(data, columnNames);
    final JTable table = new JTable(data, columnNames);
    table.setAutoCreateRowSorter(true);
    table.setPreferredScrollableViewportSize(new Dimension(500,300));


        //Creamos un JscrollPane y le agregamos la JTable
        JScrollPane scrollPane = new JScrollPane(table);

        //Agregamos el JScrollPane al contenedor
       // getContentPane().add(scrollPane, BorderLayout.CENTER);






   /*
       //lista.setModel(modelo);
   lista = new JList(modelo);
   // lista.setPreferredSize(new Dimension(300, 400));
   lista.setLayoutOrientation(JList.HORIZONTAL_WRAP);
  // lista.setLayoutOrientation(JList.VERTICAL_WRAP);
    //lista.setSelectionMode (ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION );


    lista.setVisibleRowCount(-1);
   lista.setVisible(true);
    scrlFiles = new JScrollPane(lista);
    scrlFiles.setPreferredSize (new Dimension(400,400));*/
  /*  scrlFiles.setVerticalScrollBarPolicy(
   ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
   ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);//.HORIZONTAL_SCROLLBAR_ALWAYS);
    */   // getContentPane().add(scrlFiles, BorderLayout.CENTER);
//         panel3.add(scrollPane, BorderLayout.SOUTH);

        JPanel panel3=new JPanel ();

        Container container = this.getContentPane();
        panel3.setLayout(new BorderLayout(1,1));
//((BorderLayout) container.getLayout()).setHgap(2);
//((BorderLayout) container.getLayout()).setVgap(2);
//panel3.setLayout(borderLayout);


//container.add(button, borderConsts[i]);
panel3.add(scrollPane,BorderLayout.NORTH);





       // panel3.add(scrollPane);
panel3.add(scrollPane,BorderLayout.NORTH);
//container.add(scrollPane,BorderLayout.NORTH);
        JButton boton = new JButton("Terminar proceso");
        JButton boton2 = new JButton("Refrescar proceso");
        JButton boton3 = new JButton("Cancelar");

panel3.add(boton3,BorderLayout.WEST);
panel3.add(boton2,BorderLayout.EAST);
panel3.add(boton,BorderLayout.SOUTH);
   //     container.add(boton,BorderLayout.EAST);
container.add(panel3);
 //panel3.add(container);

 boton3.addActionListener (

         new ActionListener () {

            public void actionPerformed(ActionEvent e) {
                System.out.println("Cerrar Ventana");

     try
     {

    panelprocesos.dispose();
     }
    catch(Exception event)
    {
      JOptionPane.showConfirmDialog(null, "La venta de procesos no se puede cerrar", "Close Windows",
                                    JOptionPane.CLOSED_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE);

              };

            }
         } // clase interna anónima
         //la clase interna anónima
      ); // Finalizar llamada para addActionListener






  boton2.addActionListener (

         new ActionListener () {

            public void actionPerformed(ActionEvent e) {
                System.out.println("Actualizando procesos");
               
     try
     {

        panelprocesos.dispose();
        ejecutoDeComandos.ListarProcesos();
     }
    catch(Exception event)
    {
      JOptionPane.showConfirmDialog(null, "Error,no se pudo Listar procesos", "error list process",
                                    JOptionPane.CLOSED_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE);

              };

            }
         } // clase interna anónima
         //la clase interna anónima
      ); // Finalizar llamada para addActionListener

         boton.addActionListener (

         new ActionListener () {

            public void actionPerformed(ActionEvent e) {
            int contador=0;//    throw new UnsupportedOperationException("Not supported yet.");
            
                //Object[] seleccionado=lista.getSelectedValues();

                // Object [] seleccionado=(Object[])(Object) table.getSelectedRows();

            int [] seleccionado=table.getSelectedRows();
            int cont=0;
            String  allpid="";
            String separador = ">#";
         if (table.getSelectedRowCount()==0){
                    System.out.println("Debe seleccionar algun proceso");
         JOptionPane.showConfirmDialog(null, "Debe seleccionar el proceso que desea Terminar", "Kill Process",
                                    JOptionPane.CLOSED_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE);
         
         }
            while(seleccionado.length-1>=cont)
            {
                System.out.println("Seleccionado " + table.getValueAt(seleccionado[cont],1).toString());
               allpid+=table.getValueAt(seleccionado[cont],1).toString()+separador;
                cont++;
            }
      try
     {
      ejecutoDeComandos.KillProcesos(allpid.toString());
     }
    catch(Exception event)
    {
      JOptionPane.showConfirmDialog(null, "El Proceso no se puede matar", "Kill Process",
                                    JOptionPane.CLOSED_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE);

              };

            }
         } // clase interna anónima
         //la clase interna anónima
      ); // Finalizar llamada para addActionListener



      panel3.add(boton);
//((Frame) ventanaPadre
//panelprocesos = new JDialog(this);
panelprocesos.setModal(true);
panelprocesos.setTitle("Lista de procesos");
Container contentPane = panelprocesos.getContentPane();
contentPane.add(panel3, BorderLayout.CENTER);
panelprocesos.pack();
panelprocesos.setSize(new Dimension(600, 400));
panelprocesos.setLocationRelativeTo(this);


//frameCliente.setLocationRelativeTo(null)

panelprocesos.show();
        // lstFiles.setCellRenderer(new FileRenderer(ICON_SIZE));





/*
JTree tree22 = new JList(node);
        JFrame v = new JFrame();
        JScrollPane scroll = new JScrollPane(tree22);
        v.getContentPane().add(scroll);
        v.pack();
        v.setVisible(true);
   //   this.ExpandirArbol(node);

*/
}


public String VueltaCadena(String sCadena){
    String sCadenaInvertida="";
    for (int x=sCadena.length()-1;x>=0;x--)
		sCadenaInvertida = sCadenaInvertida + sCadena.charAt(x);
    return sCadenaInvertida;

}



}




class FrameCliente_conectarRadioButton_actionAdapter implements java.awt.event.
    ActionListener {
  FrameCliente adaptee;

  FrameCliente_conectarRadioButton_actionAdapter(FrameCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.conectarRadioButton_actionPerformed(e);
  }
}

class FrameCliente_informacionEquipoMenu_actionAdapter implements java.awt.
    event.ActionListener {
  FrameCliente adaptee;

  FrameCliente_informacionEquipoMenu_actionAdapter(FrameCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.informacionEquipoMenu_actionPerformed(e);
  }
}

class FrameCliente_abrirURLMenu_actionAdapter implements java.awt.event.
    ActionListener {
  FrameCliente adaptee;

  FrameCliente_abrirURLMenu_actionAdapter(FrameCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.abrirURLMenu_actionPerformed(e);
  }
}

class FrameCliente_ejecutarMenu_actionAdapter implements java.awt.event.
    ActionListener {
  FrameCliente adaptee;

  FrameCliente_ejecutarMenu_actionAdapter(FrameCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.ejecutarMenu_actionPerformed(e);
  }
}

class FrameCliente_crearUsuarioMenu_actionAdapter implements java.awt.event.
    ActionListener {
  FrameCliente adaptee;

  FrameCliente_crearUsuarioMenu_actionAdapter(FrameCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.crearUsuarioMenu_actionPerformed(e);
  }
}

class FrameCliente_registroRemotoMenu_actionAdapter implements java.awt.event.
    ActionListener {
  FrameCliente adaptee;

  FrameCliente_registroRemotoMenu_actionAdapter(FrameCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.registroRemotoMenu_actionPerformed(e);
  }
}

class FrameCliente_servidorTelnetMenu_actionAdapter implements java.awt.event.
    ActionListener {
  FrameCliente adaptee;

  FrameCliente_servidorTelnetMenu_actionAdapter(FrameCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.servidorTelnetMenu_actionPerformed(e);
  }
}

class FrameCliente_stopTelnetMenu_actionAdapter implements java.awt.event.
    ActionListener {
  FrameCliente adaptee;

  FrameCliente_stopTelnetMenu_actionAdapter(FrameCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.stopTelnetMenu_actionPerformed(e);
  }
}

class FrameCliente_formatearDisketeMenu_actionAdapter implements java.awt.event.
    ActionListener {
  FrameCliente adaptee;

  FrameCliente_formatearDisketeMenu_actionAdapter(FrameCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.formatearDisketeMenu_actionPerformed(e);
  }
}

class FrameCliente_bloquearEquipoMenu_actionAdapter implements java.awt.event.
    ActionListener {
  FrameCliente adaptee;

  FrameCliente_bloquearEquipoMenu_actionAdapter(FrameCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.bloquearEquipoMenu_actionPerformed(e);
  }
}

class FrameCliente_ListarDirectorioMenu_actionAdapter implements java.awt.event.
    ActionListener {
  FrameCliente adaptee;

  FrameCliente_ListarDirectorioMenu_actionAdapter(FrameCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.ListarDirectorioMenu_actionPerformed(e);
  }
}

class FrameCliente_desconectarRadioButton_actionAdapter implements java.awt.
    event.ActionListener {
  FrameCliente adaptee;

  FrameCliente_desconectarRadioButton_actionAdapter(FrameCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.desconectarRadioButton_actionPerformed(e);
  }
}

class FrameCliente_scannerTroyanosMenu_actionAdapter implements java.awt.event.
    ActionListener {
  FrameCliente adaptee;

  FrameCliente_scannerTroyanosMenu_actionAdapter(FrameCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.scannerTroyanosMenu_actionPerformed(e);
  }
}

class FrameCliente_scanerPuertosMenu_actionAdapter implements java.awt.event.
    ActionListener {
  FrameCliente adaptee;

  FrameCliente_scanerPuertosMenu_actionAdapter(FrameCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.scanerPuertosMenu_actionPerformed(e);
  }
}

class FrameCliente_acercaDeNettolsMenu_actionAdapter implements java.awt.event.
    ActionListener {
  FrameCliente adaptee;

  FrameCliente_acercaDeNettolsMenu_actionAdapter(FrameCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.acercaDeNettolsMenu_actionPerformed(e);
  }
}

class FrameCliente_borrarUsuarioMenu_actionAdapter implements java.awt.event.
    ActionListener {
  FrameCliente adaptee;

  FrameCliente_borrarUsuarioMenu_actionAdapter(FrameCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.borrarUsuarioMenu_actionPerformed(e);
  }
}

class FrameCliente_serviciosActivosMenu_actionAdapter implements java.awt.event.
    ActionListener {
  FrameCliente adaptee;

  FrameCliente_serviciosActivosMenu_actionAdapter(FrameCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.serviciosActivosMenu_actionPerformed(e);
  }
}

class FrameCliente_reinicirEquipoMenu_actionAdapter implements java.awt.event.
    ActionListener {
  FrameCliente adaptee;

  FrameCliente_reinicirEquipoMenu_actionAdapter(FrameCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.reinicirEquipoMenu_actionPerformed(e);
  }
}

class FrameCliente_apagarEquipoMenu_actionAdapter implements java.awt.event.
    ActionListener {
  FrameCliente adaptee;

  FrameCliente_apagarEquipoMenu_actionAdapter(FrameCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.apagarEquipoMenu_actionPerformed(e);
  }
}

class FrameCliente_paginaPrincipalMenu_actionAdapter implements java.awt.event.
    ActionListener {
  FrameCliente adaptee;

  FrameCliente_paginaPrincipalMenu_actionAdapter(FrameCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.paginaPrincipalMenu_actionPerformed(e);
  }
}

class FrameCliente_borrarDirectorioMenu_actionAdapter implements java.awt.event.
    ActionListener {
  FrameCliente adaptee;

  FrameCliente_borrarDirectorioMenu_actionAdapter(FrameCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.borrarDirectorioMenu_actionPerformed(e);
  }
}

class FrameCliente_imagenservidorMenu_actionAdapter implements java.awt.event.
    ActionListener {
  FrameCliente adaptee;

  FrameCliente_imagenservidorMenu_actionAdapter(FrameCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.imagenservidorMenu_actionPerformed(e);
  }
}

class FrameCliente_descargarFicheroMenu_actionAdapter implements java.awt.event.
    ActionListener {
  FrameCliente adaptee;

  FrameCliente_descargarFicheroMenu_actionAdapter(FrameCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.descargarFicheroMenu_actionPerformed(e);
  }
}

class FrameCliente_unidadesDeDiscoMenu_actionAdapter implements java.awt.event.
    ActionListener {
  FrameCliente adaptee;

  FrameCliente_unidadesDeDiscoMenu_actionAdapter(FrameCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.unidadesDeDiscoMenu_actionPerformed(e);
  }
}

class FrameCliente_directorioRemotoMenu_actionAdapter implements java.awt.event.
    ActionListener {
  FrameCliente adaptee;

  FrameCliente_directorioRemotoMenu_actionAdapter(FrameCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.directorioRemotoMenu_actionPerformed(e);
  }
}

class FrameCliente_temasDeAyudaMenu_actionAdapter implements java.awt.event.
    ActionListener {
  FrameCliente adaptee;

  FrameCliente_temasDeAyudaMenu_actionAdapter(FrameCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.temasDeAyudaMenu_actionPerformed(e);
  }
}

class FrameCliente_ListaProcess_actionAdapter implements java.awt.event.ActionListener
 {
   FrameCliente adaptee;
   FrameCliente_ListaProcess_actionAdapter(FrameCliente adaptee)
   {
     this.adaptee=adaptee;
   }
   public void actionPerformed(ActionEvent e)
   {
     adaptee.ListaProcess_actionPerformed(e);
   }
 }

 class FrameCliente_MataProcess_actionAdapter implements java.awt.event.ActionListener
 {
   FrameCliente adaptee;
   FrameCliente_MataProcess_actionAdapter(FrameCliente adaptee)
   {
     this.adaptee=adaptee;
   }
   public void actionPerformed(ActionEvent e)
   {
     adaptee.MataProcess_actionPerformed(e);
   }
 }


class FrameCliente_this_windowAdapter extends java.awt.event.WindowAdapter {
  FrameCliente adaptee;

  FrameCliente_this_windowAdapter(FrameCliente adaptee) {
    this.adaptee = adaptee;
  }

  public void windowClosing(WindowEvent e) {
    adaptee.this_windowClosing(e);
  }
}
