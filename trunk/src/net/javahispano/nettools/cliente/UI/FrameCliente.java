package net.javahispano.nettools.cliente.UI;

import javax.swing.table.TableModel;
import net.javahispano.nettols.comunicaciones.Objeto;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowListener;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeModel;
import net.javahispano.nettools.cliente.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileFilter;
import java.lang.Object;
import javax.swing.border.*;
import java.net.*;
import java.sql.Connection;
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
import javax.swing.tree.TreeSelectionModel;
//import net.javahispano.nettools.cliente.UI.java1415.MiRendererDeArbol;

/**
 * <p>T�tulo: NetTools </p>
 * <p>Descripción: Herramienta de Administración remota Windows 2000</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Empresa: fenomenoweb</p>
 * @author Juan Garrido Caballero y Abraham Otero y Adolfo Sanz 
 * @version 0.8
 */

public class FrameCliente extends JFrame implements Informable, TreeSelectionListener,TreeExpansionListener {
  private EjecutaComandos ejecutoDeComandos;
  JTabbedPane tabbedPane = new JTabbedPane();
        //ImageIcon icon = createImageIcon("images/middle.gif");
 DefaultTreeCellRenderer render=null;
  JTree arbol=null;
   DefaultMutableTreeNode nodeArbol;
 JPanel panel2 =new JPanel();
int entrar=0;
//JDialog panelprocesos = null;//new JDialog(this);
 //JDialog panelprocesos = new JDialog(this);
 JPanel paneltablaproces = new JPanel();
    JPanel panel3 = new JPanel();

 JDialog     panelInformacion =   null;


 public  JList lista;
public  JTree arbolprocesos;
public JTable table;
String prefix ="";
int estado=0;
int tipo_tam=0;
int contarr=0;
String rutacompleta2="";
/*final */  JDialog     panelImagen =   null; //new JDialog(this);
JLabel      etiqueta=   null;
JScrollPane scrollPane=   null;
ImageIcon   iIcon1=   null;
Image       img1=   null;
Image       img2=   null;
ImageIcon   iIcon2=   null;
JPanel      panel5=   null;
JButton     play=   null;
JButton     psize= null;
JButton     stop=   null;
JButton     pause=   null;
JButton     save=   null;
JButton     exit=   null;
JPanel      panel6=   null;
JPanel      panelbotonArbol=   null;

JButton     deletedir=   null;
JButton     deletefile=   null;
JButton    download=null;
JButton    closePestaña=null;
JButton clear = null;

Container   contentPane=   null;

 //JFrame panel2=new JFrame();
 int par=1;
   private JScrollPane scrlDir;
        private JTree treeDir;

    private JScrollPane scrlFiles;
        private DefaultListModel mdlFiles;
        private JList lstFiles;


TreeExpansionEvent au;
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
  ImageIcon iconoPlay = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/play1.gif"));
  ImageIcon iconobig =new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/big.png"));
  ImageIcon iconosmall =new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/small.png"));
  ImageIcon iconoStop = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/stop.gif"));
  ImageIcon iconoPause = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/pause.gif"));
  ImageIcon iconoExit = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/exit.gif"));
   ImageIcon iconorefresh = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/reload3.gif"));
 ImageIcon iconoclear = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/clear.gif"));
  //imagenes arbol
 ImageIcon iconoword = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/word2.png"));
 ImageIcon iconoexcel= new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/excel.png"));
 ImageIcon iconopowerpoint = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/powerpoint.png"));
 ImageIcon iconoadobe = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/adobe.png"));
  ImageIcon iconoinformacion = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/photo3.gif"));




  // playb


  JMenuBar jMenuBar1 = new JMenuBar();
  JMenu conexionMenu = new JMenu();
  JMenu jMenu2 = new JMenu();
  JMenuItem serviciosActivosMenu = new JMenuItem();
  JMenuItem registroRemotoMenu = new JMenuItem();
  JMenuItem abrirURLMenu = new JMenuItem();
  JMenuItem ejecutarMenu = new JMenuItem();
  JMenuItem formatearDisketeMenu = new JMenuItem();
  JMenuItem informacionEquipoMenu = new JMenuItem();
 // JMenuItem descargarFicheroMenu = new JMenuItem();
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
  //  jMenuItem2.setText("Matar Procesos");
    //jMenuItem2.addActionListener(new FrameCliente_MataProcess_actionAdapter(this));
    //jMenuItem2.setIcon(iconoKillProcess);


    jScrollPane1.getViewport().add(consola,null);
    //Shell.add(jScrollPane1,ShellCons);
clear=new JButton();
//clear.addActionListener(new FrameCliente_ListaProcess_actionAdapter(this));
clear.addActionListener (
            new ActionListener () {
                public void actionPerformed(ActionEvent e) {

                    System.out.println("LIMPIO ");
                   clearshell();
                    //adaptee.conectarRadioButton_actionPerformed(e);
                
                }
            } // clase interna anónima
        ); // Finalizar llamada para addActionListener
   clear.setIcon(iconoclear);
    jScrollPane1.setCorner(JScrollPane.LOWER_RIGHT_CORNER,
				clear);


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

   

   //  JButton boton4 = new JButton ("Boton 4");
//clear=new JButton();
    /*constraints.gridx = 2;
constraints.gridy = 2;
constraints.gridwidth = 1;
constraints.gridheight = 1;
this.getContentPane().add (boton4, constraints); */



//----    ShellCons = new GridBagConstraints();
//---   ShellCons.gridx=1;
//--   ShellCons.gridy=1;
//--   ShellCons.gridwidth=1;
 //---  ShellCons.gridheight=1;
//----ShellCons.fill = GridBagConstraints.NONE;
    /*ShellCons.weightx=0;
    ShellCons.weighty=0.1;*/
//---  ShellCons.fill=GridBagConstraints.SOUTHEAST;
 //--- ShellCons.insets=new java.awt.Insets(1,1,5,2);
  //deletedir= new JButton();
  //deletedir.setSize(0,0);
  //ButtName.setPreferredSize (nueva dimensión (buttonWidth, buttonHeight));
 // clear.setPreferredSize(new Dimension(1,1));//.setPreferredSize(1,1);
  //deletedir.setPressedIcon(borraDirectorio);
  
  //----  final int ICON_SIZE = 1;
  //--- clear.setIcon(iconoclear);
    
  //--- Shell.add(clear,ShellCons);





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
    setTitle("NetTools 0.7 Beta Administración Remota"); //T�tulo del frame
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
    informacionEquipoMenu.setText("Información Equipo");
     informacionEquipoMenu.addActionListener(new
     FrameCliente_informacionEquipoMenu_actionAdapter(this));
 //   descargarFicheroMenu.setIcon(downloadsIcono);
    //descargarFicheroMenu.setText("Descargar Fichero");
  //  descargarFicheroMenu.addActionListener(new
   //     FrameCliente_descargarFicheroMenu_actionAdapter(this));
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
   // jMenu2.addSeparator();
  //  jMenu2.add(descargarFicheroMenu);
    jMenu2.addSeparator();
    jMenu2.add(unidadesDeDiscoMenu);
    //jMenu2.addSeparator();
    //jMenu2.add(jMenu1);
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
 //   jMenu5.addSeparator();
   // jMenu5.add(jMenuItem2);
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
   // jMenu1.add(ListarDirectorioMenu);
    //jMenu1.add(directorioRemotoMenu);
   // jMenu1.add(borrarDirectorioMenu);
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

  public void clearshell(){
      System.out.println("Limpiamos CONSOLAAAA------>>>>>>");
     String texto="ADOLFO    ES COJONUDO";
    ejecutoDeComandos.ClearShell();
     
     //consola.setText(texto);
     // mensageError(texto);
      //statusBar.setText("Conectado a "+status);


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
                                         "conexión", JOptionPane.DEFAULT_OPTION,
                                         blockIcono, null, null);
    if (opcion == null) {
       // System.out.println("Compruebo la ip");
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
                                              "Desea arrancar el servicio de telnet?",
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
    Object objeto = JOptionPane.showInputDialog(null, "Directorio a listar?",
                                                "directorio",
                                                JOptionPane.DEFAULT_OPTION,
                                                iconoCarpeta, null, null);

    try {

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
                                  "desconexión", JOptionPane.CLOSED_OPTION,
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
        "Aplicación realizada en Java y C.\nProgramado por Juan Garrido Caballero y \n Abraham Otero Quintana y \n Adolfo Sanz",
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
        "Atención!! Va usted a borrar directorios\nen la máquina remota",
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
      System.out.println("----[CLIENTE][imagenservidorMenu_actionPerformed] Inicio...");
  try {
        System.out.println("----[CLIENTE][imagenservidorMenu_actionPerformed] Llamando a EJECUTOR (ejecutoDeComandos.recibirImagenServidor)...");
        ejecutoDeComandos.recibirImagenServidor();
    }
    catch (NuestraExeption ex) {
      JOptionPane.showConfirmDialog(null, ex.getMessage(), "conexion",
                                    JOptionPane.CLOSED_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE);
    }
      //DON// MostrarImagen("Hola");
  }

  void descargarFicheroMenu_actionPerformed(ActionEvent e) {

    Object objeto = JOptionPane.showInputDialog(null,
                                                "Nombre del archivo a descargar",
                                                "Download Files",
                                                JOptionPane.YES_NO_OPTION,
                                                iconoDownload, null, null);

    try {
         ejecutoDeComandos.recibirImagenServidor(objeto.toString());
     // ejecutoDeComandos.abrirArchivoODirectorio(objeto.toString());
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
      Runtime.getRuntime().exec(new String[] {"winhlp32.exe", "C:/NETTOOLS.HLP"});

    }
    catch (Exception event) {
      JOptionPane.showConfirmDialog(null, "Ayuda no encontrada", "Help Files",
                                    JOptionPane.CLOSED_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE);
    }
  } 
  
  void this_windowClosing(WindowEvent e) {
    System.exit(0);
    contarr=0;
  }
//se produce el evento de expandir el arbol
  public void ExpandirArbol(String Datosarbol)
  {
      int inicio = 0,fin=0,cont=0;
        String separador = ">#";
        String aux=null;
        String esdirectorio="";
         String h="";
        //int campos=NumeroDeSubdirectorios(Datosarbol,separador);
       // Object[] hierarchy=new Object[campos];
System.out.println("Dentro del Expandir"+Datosarbol);
        //DefaultMutableTreeNode top = new DefaultMutableTreeNode(f);
        //-->populateNode(top, f);
       DefaultMutableTreeNode node =null;
    //  new DefaultMutableTreeNode(hierarchy[0]);
DefaultMutableTreeNode hijo=null;
DefaultMutableTreeNode nieto=null;

     int startRow = 0;

     fin=Datosarbol.indexOf(separador,inicio);
    aux=Datosarbol.substring(inicio, fin);
      System.out.println("AUXXXXXXXXX "+aux);
     //    int startRow=level;
//------->>>String prefix = nodeArbol.toString();
      System.out.println("nodeArbol prefix"+prefix);
String prefix2 ="";
    //  String prefix ="/";
     TreePath path = treeDir.getNextMatch(prefix, startRow, Position.Bias.Forward);
      System.out.println("PATTTTTHHH"+path);
     // TreePath path=(auxx.getPath());
      DefaultMutableTreeNode node2 = (DefaultMutableTreeNode)(MutableTreeNode) path.getLastPathComponent();
      //MutableTreeNode node2 = (MutableTreeNode)path.getLastPathComponent();
     DefaultTreeModel model = (DefaultTreeModel) treeDir.getModel();
DefaultTreeModel model2 ;
MutableTreeNode node3;
     inicio=fin+2;

//     model.removeNodeFromParent(node2);
//     node2.remove(nieto);
//     System.out.println("NOOOOOOOOODEEE"+node2);
    // node2.removeAllChildren();
     System.out.println("Numero de hojos"+node2.getNextNode().getChildCount());
System.out.println("QQQQQQQQQQQQQ"+Datosarbol);
System.out.println("Numero de hojos----------->>>>>>>>"+node2.getChildCount());
    /* if (Datosarbol.equalsIgnoreCase(aux+separador)){
    System.out.println("QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ");
   node2.getNextNode().removeAllChildren();
     }*/
if (node2.getChildCount()==1)
{
//   model.removeNodeFromParent(node.getNextNode());
//node.removeAllChildren();
   // else
  //  {
  //   if (node2.getChildCount()==1 || node2.getChildCount()==0){
     System.out.println("zzzzzzzzzzzzzzzzzzZZZZ"+node2.getLevel());
      //node2.remove(node2.getLevel()+1);
     //node2.removeAllChildren();
     //node2.getNextNode().removeAllChildren();
    // model.removeNodeFromParent(node2.getNextNode());
//----     node2.getNextNode().removeAllChildren();
   // model.removeNodeFromParent(node2);
    // node2.removeAllChildren();
     //   }
      //top.removeAllChildren();
    //  model.reload();



     while(inicio<Datosarbol.length()){
     fin=Datosarbol.indexOf(separador,inicio);
    aux=Datosarbol.substring(inicio, fin-1);
         System.out.println("EL primer AAAAAAAAAAAAAArchivo");
    //prefix2=nodeArbol.toString()+aux;
     //    System.out.println("PPPPPPPPPPPPPPPPPPPPPP"+prefix2);
     esdirectorio=Datosarbol.substring(fin-1,fin);
      //System.out.println("esdirectorio######"+esdirectorio);
     hijo = new DefaultMutableTreeNode(aux);
     //model.insertNodeInto( (DefaultMutableTreeNode) hijo, (DefaultMutableTreeNode) node2, node2.getChildCount());
     if (esdirectorio.endsWith("1")){
        //     System.out.println("creo un hijo");
             nieto = new DefaultMutableTreeNode(h);
             hijo.add(nieto);
         }
     else{
         System.out.println("ponemos icono en arbol");
      // render.setLeafIcon(new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/word2.png")));
     //  render.setLeafIcon(new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/excel.png")));
        //ImageIcon iconoexcel= new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/excel.png"));
         //render.setLeafIcon(iconoword);
      // render.setLeafIcon(new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/word2.gif")));//.setLeafIcon(new ImageIcon("d:/fut));

//         ext = name.substring(name.lastIndexOf('.') + 1, name.length());


          }
    
     model.insertNodeInto( (DefaultMutableTreeNode) hijo, (DefaultMutableTreeNode) node2, node2.getChildCount());
  //    render.setLeafIcon(new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/excel.png")));
     //render.setLeafIcon(new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/word2.png")));
     //7iconoExit           ImageIcon
      //ImageIcon iconoword = new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/word2.gif"));
  //-----   render.setLeafIcon(new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/word2.gif")));
 //   hierarchy[cont]=(aux);
 //  System.out.println(hierarchy[cont] + "bucle");
    //System.out.println(aux+"aux");
   // System.out.println(inicio +"inicio" + fin +"fin");
        inicio=fin+2;
        cont++;
    }
 // }

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
        //this.setLayout(new BorderLayout());
        panel2.setLayout(new BorderLayout());
        panelbotonArbol  =   new JPanel();
        Container container = this.getContentPane();
      //  panelbotonArbol.setLayout(new FlowLayout(FlowLayout.RIGHT,40,40));
          panelbotonArbol.setLayout(new GridLayout(4,1,20,20));
         // panelbotonArbol.setBorder(javax.swing.BorderFactory.createTitledBorder("menu opciones"));
         panelbotonArbol.setBorder(javax.swing.BorderFactory.createTitledBorder(null,"Operaciones d"));
        deletedir= new JButton();
        deletedir.setIcon(borraDirectorio);
        deletedir.setText("Borrar directorio");
        deletedir.addActionListener (
        new ActionListener () {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("----[Borrando][Fichero del arbol].borrar: 1");
                   //Strin rutacompleta="";
     System.out.println("La ruta completa  a listar que vamos eliminnNNNNNNNNNNNNar: "+rutacompleta2);

                      javax.swing.tree.TreePath rutaNodoSeleccionado = treeDir.getSelectionPath();
                    if (rutaNodoSeleccionado==null){
                          JOptionPane.showConfirmDialog(null, "Debe seleccionar el elemento que desea eliminar", "Delete Process",
                                    JOptionPane.CLOSED_OPTION,
                                    JOptionPane.WARNING_MESSAGE); return;}

                      DefaultMutableTreeNode nodoSeleccionado=(DefaultMutableTreeNode)
                     rutaNodoSeleccionado.getLastPathComponent();

                      if (nodoSeleccionado.isRoot())return;
                    JPanel frame=new JPanel();
                    int n = JOptionPane.showConfirmDialog(null,
                    "Confirma que desea eliminar " + nodoSeleccionado.toString() +" ?",
                    "Seleccione opcion para continuar",
                    JOptionPane.YES_NO_OPTION);
                   if (n==1){//cancela la eliminacion
                        System.out.println("Confirmado cancelación");
                        JOptionPane.showConfirmDialog(null,"Interrumpido proceso de eliminacion", "Eliminación cancelada",
                                                                JOptionPane.CLOSED_OPTION,
                                                                JOptionPane.INFORMATION_MESSAGE);
                   }else{    //comienza la eliminación del archivo
                      DefaultTreeModel modeloArbol=
                         (DefaultTreeModel)treeDir.getModel();
                          modeloArbol.removeNodeFromParent(nodoSeleccionado);


                            try {
                                  ejecutoDeComandos.borrarDirectorio(rutacompleta2);
                               }
                                catch (NuestraExeption ex) {
                                  JOptionPane.showConfirmDialog(null, ex.getMessage(), "conexion",
                                                                JOptionPane.CLOSED_OPTION,
                                                                JOptionPane.INFORMATION_MESSAGE);
                                }
                   }
                  }
            } // clase interna anónima
        ); // Finalizar llamada para addActionListener


        deletefile=new JButton();
        deletefile.setIcon(borraDirectorio);
        deletefile.setText("Borrar fichero ");

        deletefile.addActionListener (
        new ActionListener () {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("----[Borrando][Fichero del arbol].borrar: 1");
                   //Strin rutacompleta="";

     System.out.println("La ruta completa  a listar que vamos eliminnNNNNNNNNNNNNar: "+rutacompleta2);
                    /*Object objeto = JOptionPane.showInputDialog(null,
                                                "Nombre del archivo a descargar",
                                                "Download Files",
                                                JOptionPane.YES_NO_OPTION,
                                                iconoDownload, null, null);*/

    /*try {
      //ejecutoDeComandos.abrirArchivoODirectorio(objeto.toString());
      ejecutoDeComandos.recibirImagenServidor(objeto.toString());
    }
    catch (NuestraExeption ex) {
      JOptionPane.showConfirmDialog(null, ex.getMessage(), "conexion",
                                    JOptionPane.CLOSED_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE);
    }*/
                }
            } // clase interna anónima
        ); // Finalizar llamada para addActionListener



        download=new JButton();
        download.setIcon(downloadsIcono);
        download.setText("Descargar Fichero");

          download.addActionListener (
            new ActionListener () {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("----[CLIENTE][MostrarImagen2].save: 1");
                       
                  //obtenemo la ruta del fichero a listar
                 javax.swing.tree.TreePath rutaNodoSeleccionado = treeDir.getSelectionPath();
                    if (rutaNodoSeleccionado==null){
                          JOptionPane.showConfirmDialog(null, "Debe seleccionar el elemento que desea descargar", "download Process",
                                    JOptionPane.CLOSED_OPTION,
                                    JOptionPane.WARNING_MESSAGE); return;}

                    System.out.println("la ruta selecciona es:--------[rutaNodoSeleccionado]"+rutaNodoSeleccionado.toString());
                    //Object objeto =treeDir.getSelectionPath();

                     TreePath path=treeDir.getSelectionPath();
                    /******************************************/

                /*     rutacompleta2="";
                    Object [] nodos3 = path.getPath();
         System.out.print("Path seleccionado: ");
         int cont=0;
		for (Object nodo3: nodos3){
		  if (cont>2)
                      rutacompleta2+=nodo3.toString()+"/";
                  else{
                    rutacompleta2+=nodo3.toString()+"/";
                    cont++;
                    }

		System.out.println("++++++++++++"+rutacompleta2);
                }
             int n=nodos3.length;
             System.out.println("AAAAA BIENNNNN"+nodos3[n-1].toString());
                System.out.println("ruta del nodo a descargar---->: "+rutacompleta2);
*/
   DefaultMutableTreeNode nodoSeleccionado=(DefaultMutableTreeNode)
                     rutaNodoSeleccionado.getLastPathComponent();


   Object[] options = {"Si, descarga",
                       "No, descarge!"};
   int n = JOptionPane.showOptionDialog(null,
    "Confirma que desea descargar el fichero " + nodoSeleccionado.toString() +" ?",
    "Download Files",
    JOptionPane.YES_NO_OPTION,
    JOptionPane.QUESTION_MESSAGE,
    iconoDownload,     //do not use a custom Icon
    options,  //the titles of buttons
    options[0]); //default button title

   
   
   
   
   /*   int n = JOptionPane.showConfirmDialog(null,
                   "Interrumpido proceso de eliminacion", "Eliminación cancelada",
                                                               // JOptionPane.CLOSED_OPTION,
                                                                JOptionPane.YES_NO_OPTION,
                   //"Confirma que desea eliminar " + nodoSeleccionado.toString() +" ?",
                   // "Seleccione opcion para continuar",
                   // JOptionPane.YES_NO_OPTION,
                     iconoDownload);

                   if (n==1){//cancela la eliminacion
                        System.out.println("Confirmado cancelación");
                        JOptionPane.showConfirmDialog(null,"Interrumpido proceso de eliminacion", "Eliminación cancelada",
                                                                JOptionPane.CLOSED_OPTION,
                                                                JOptionPane.INFORMATION_MESSAGE,
                                                                iconoDownload);
                   }else{    //comienza la eliminación del archivo

*/




                    //System.out.println("EL pad es el siguiente" + objeto.toString());
             /*     Object objeto = JOptionPane.showInputDialog(null,
                                                "Nombre del archivo a descargar",
                                                "Download Files",
                                                JOptionPane.YES_NO_OPTION,
                                                iconoDownload, null, null);

               */



    try {
      //ejecutoDeComandos.abrirArchivoODirectorio(objeto.toString());
      ejecutoDeComandos.recibirImagenServidor2(rutacompleta2);
    }
    catch (NuestraExeption ex) {
      JOptionPane.showConfirmDialog(null, ex.getMessage(), "conexion",
                                    JOptionPane.CLOSED_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE);
    }
  //              }
            } // clase interna anónima
          }
                ); // Finalizar llamada para addActionListener
        

    closePestaña=new JButton("Cerrar pestana");
     closePestaña.setIcon(iconoExit);
     closePestaña.addActionListener (
           new ActionListener () {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("----[Cerrando][Pestaña del arbol].Cerrar : 1");
                    //Strin rutacompleta="";
                 //int i = panel2..indexOfTabComponent(this);
                 //if (i != -1) {
                  //panel2.remove(0);
                 panel2.removeAll();
                 panelbotonArbol.removeAll();
                  tabbedPane.remove(1);

                }
            } // clase interna anónima
        ); // Finalizar llamada para addActionListener


        panelbotonArbol.add(deletedir,BorderLayout.BEFORE_LINE_BEGINS);
        panelbotonArbol.add(deletefile,BorderLayout.BEFORE_FIRST_LINE);
        panelbotonArbol.add(download,BorderLayout.AFTER_LAST_LINE);
        panelbotonArbol.add(closePestaña,BorderLayout.AFTER_LAST_LINE);



        /** Que tan grandes son los iconos que voy a mostrar en la lista */
        final int ICON_SIZE = 32;

        /*
        panel3.add(boton3, BorderLayout.WEST);
        panel3.add(boton2, BorderLayout.EAST);
        panel3.add(boton, BorderLayout.SOUTH);
        //     container.add(boton,BorderLayout.EAST);
        container.add(panel3);
        //panel3.add(container);

        boton3.addActionListener(
                new ActionListener() {

*/










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
        inicio=fin+2;
        cont++;
    }


   //DefaultMutableTreeNode root22 = processHierarchy(hierarchy);

                   /*
             category = new DefaultMutableTreeNode(roots[i]);
             top.add(category);*/
      /*
     MiRendererDeArbol nuevorender=new MiRendererDeArbol();
   treeDir.setCellRenderer(nuevorender);//.setCellRenderer( new MiRendererDeArbol() );
*/
      /* java1415 s= new java1415();
       treeDir.setCellRenderer();
*/


         treeDir = new JTree(processHierarchy(hierarchy));
        /**
         * El CellRenderer me permite modificar la manera en que se despliega
         * la informacion en mi JTree, es un poco complicado de implementar
         * pero me da mucha libertad en cuanto a como se dibuja el control en
         * la pantalla
         */

         //CustomIconRenderer=new
         treeDir.setCellRenderer(new CustomIconRenderer());
        //treeDir.setCellRenderer(new DirectoryRenderer(ICON_SIZE));


        /**
         * setPreferredSize me permite determinar un ancho y un alto
         * preferentes, que cuando utilizamos el metodo pack se utilizan para
         * generar la interfaz.
         */
        //treeDir.setPreferredSize(new Dimension(500, 500));
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
        treeDir.getSelectionModel().setSelectionMode
                (TreeSelectionModel.SINGLE_TREE_SELECTION);

        // Indicamos que el árbol va a estar controlado por nuestra aplicación
    // y que el sistema nos debe dejar el campo libre
    //   treeDir.setCellRenderer(new MiRendererDeArbol());

       // DefaultTreeCellRenderer

    //  tree.setCellRenderer(new MiRender());


/*      DefaultTreeCellRenderer render= (DefaultTreeCellRenderer)treeDir.getCellRenderer();
render.setLeafIcon(new ImageIcon(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource("iconos/word2.png")));
*/
        /**
         * Utilizo un JScrollPane para que aparezcan barras de desplazamiento
         */
        //scrlDir = new JScrollPane(treeDir);
        scrlDir = new JScrollPane(treeDir);
        scrlDir.setVerticalScrollBarPolicy(
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrlDir.setPreferredSize (new Dimension(260,240));
     //   getContentPane().add(scrlDir, BorderLayout.WEST);
          //panel2.add(scrlDir);//.add(scrlDir, BorderLayout.WEST);

       //panel2.getViewport().add(scrlDir,null);
       panel2.add(scrlDir,BorderLayout.WEST);
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
         panel2.add(panelbotonArbol,BorderLayout.CENTER);
        //---------       panel2.add(scrlFiles, BorderLayout.CENTER);
     //   panel2.pack();
     //   panel2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //  panel2.setTitle("Arbol");
        panel2.setVisible(true);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);


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

/*
 hijo = new DefaultMutableTreeNode(aux);
     //model.insertNodeInto( (DefaultMutableTreeNode) hijo, (DefaultMutableTreeNode) node2, node2.getChildCount());
     if (esdirectorio.endsWith("1")){
        //     System.out.println("creo un hijo");
             nieto = new DefaultMutableTreeNode(h);
             hijo.add(nieto);
         }
*/
private DefaultMutableTreeNode processHierarchy(Object[] hierarchy) {
    System.out.println("DDEEEEDDDDDDD"+hierarchy.length);
 String h="";
    /*  DefaultMutableTreeNode node1 =
      new DefaultMutableTreeNode(hierarchy[0]);*/
 DefaultMutableTreeNode nieto=null;
    DefaultMutableTreeNode aux =
      new DefaultMutableTreeNode(" ");
    DefaultMutableTreeNode node1 =
      new DefaultMutableTreeNode("/");
    DefaultMutableTreeNode child;
    for(int i=1; i<hierarchy.length; i++) {
        System.out.println(hierarchy[i] + "ESTOooooooooooooooooooooooooooooooooo");
      Object nodeSpecifier = hierarchy[i];
      if (nodeSpecifier instanceof Object[])  // Ie node with children
      { child = processHierarchy((Object[])nodeSpecifier);
        System.out.println("AKKKKK111111");}
      else{
          System.out.println("AKKKKK222222222");
        child = new DefaultMutableTreeNode(nodeSpecifier); // Ie Leaf
        nieto = new DefaultMutableTreeNode(h);
         child.add(nieto);
         }
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
      System.out.println("ADDDADADADADADDADADADADADADDDADDADADADDDADADADDADD");

         String rutacompleta="";
         TreePath path = event.getPath();


         Object [] nodos3 = path.getPath();
         System.out.print("Path seleccionado: ");
         int cont=0;
		for (Object nodo3: nodos3){
		  if (cont>2)
                      rutacompleta+=nodo3.toString()+"/";
                  else{
                    rutacompleta+=nodo3.toString()+"/";
                    cont++;
                    }

		System.out.println("++++++++++++"+rutacompleta);
                }
             int n=nodos3.length;
             System.out.println("AAAAA BIENNNNN"+nodos3[n-1].toString());
                System.out.println("La ruta completa  a listar es: "+rutacompleta);
           /*DefaultMutableTreeNode node =
                (DefaultMutableTreeNode) treeDir.getLastSelectedPathComponent();
        System.out.println("forma Nueva quedaria"+node.getUserObjectPath().toString());
        au=event;
       System.out.println("En el momento clik"+node.toString());
        System.out.println("En el momento Expandir"+node.toString());
        //nodeArbol=node;
        nodeArbol=node.toString();*/
        prefix = nodos3[n-1].toString();
        try {
            ejecutoDeComandos.listarDirectorio(rutacompleta);
        } catch (NuestraExeption ex) {
            Logger.getLogger(FrameCliente.class.getName()).log(Level.SEVERE, null, ex);
        }





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
   
         
         TreePath path = e.getPath();
	 Object [] nodos3 = path.getPath();
         System.out.print("Path seleccionado: ");
         int cont=0;
         rutacompleta2="";
		for (Object nodo3: nodos3){
		  if (cont>1)
                      rutacompleta2+=nodo3.toString()+"/";
                  else{
                    rutacompleta2+=nodo3.toString();
                    cont++;
                    }
                     
		System.out.println("+++Cmbiaaaa+++++"+rutacompleta2);
                }
            System.out.println("La ruta completa  a listar es1111111: "+rutacompleta2);
           /*DefaultMutableTreeNode node =
                (DefaultMutableTreeNode) treeDir.getLastSelectedPathComponent();
        auxx=e;
        System.out.println("En el momento clik"+node.toString());
        nodeArbol=node;
        prefix = nodeArbol.toString();
        /*
        try {
            ejecutoDeComandos.listarDirectorio(rutacompleta);
        } catch (NuestraExeption ex) {
            Logger.getLogger(FrameCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

      */
        }


    public void mensageListarProcesos(String Listaprocesos) {
     // Listaprocesos=Listaprocesos.replaceAll(">#","\n");
        Listar(Listaprocesos);
        //actualiza lista
    }

   public void ActualizarmensageListarProcesos(String Listaprocesos) {
     // Listaprocesos=Listaprocesos.replaceAll(">#","\n");


    }
    public void mensageActualizarListarProcesos(String listaprocesos) {
        //actualiza lista de procesos
     ActualizaLista(listaprocesos);





    }


   public void  ActualizaLista(String Listaprocesos){
      ModeloTabla model=new  ModeloTabla(Listaprocesos);
       System.out.println("LLLLLLLLLLLLLLLLLLLLTTTTTTTTTTTTTTTTTTTTTTTTTTTTAAAAA");
        ModeloTabla model1=new  ModeloTabla(Listaprocesos);
         DefaultTableModel modelll=new DefaultTableModel(model1.getData(),model1.getColumnNames());
         table.setModel(modelll);
         //DefaultTableModel mo=(DefaultTableModel) table.getModel();//setModel(model.getData(),model.getColumnNames());// = new JTable(model.getData(),model.getColumnNames());
         //mo.setDataVector(model.getData(),model.getColumnNames());
        // table = new JTable(model.getData(),model.getColumnNames());
 //     DefaultTableModel mo=new DefaultTableModel(model.getData(),model.getColumnNames());
//      table.setModel(mo);
        //table = new JTable(model.getData(),model.getColumnNames());
        //table.setModel((TableModel) model);
       // table.repaint();
       // paneltablaproces.repaint();
       // panelprocesos.repaint();
        //paneltablaproces.d

   }


//JDialog panelprocesos = new JDialog(this);

    public void Listar(String procesos) {
        int inicio = 0, fin = 0;
        String separador = ">#";
        final JDialog panelprocesos = new JDialog(this);
    //  panelprocesos = new JDialog(this);
      setDefaultCloseOperation (javax.swing.WindowConstants.DISPOSE_ON_CLOSE); 
//final JDialog  panelprocesos = null;
       // final
//Le pido al Frame su objeto contenedor
//Container contentpane = getContentPane();
//Creo un objeto de tipo JPanel
//JPanel panel = new JPanel();
//Añado el panel en el objeto contenedor del frame
//    final JTable table = new JTable(data, columnNames);
         ModeloTabla model1=new  ModeloTabla(procesos);
         DefaultTableModel model=new DefaultTableModel(model1.getData(),model1.getColumnNames());
         //table = new JTable(model.getData(),model.getColumnNames());
          table = new JTable(model);
         table.setAutoCreateRowSorter(true);
        table.setPreferredScrollableViewportSize(new Dimension(580,325));


        //Creamos un JscrollPane y le agregamos la JTable
        JScrollPane scrollPane = new JScrollPane(table);

        //Agregamos el JScrollPane al contenedor
        // getContentPane().add(scrollPane, BorderLayout.CENTER);
//         panel3.add(scrollPane, BorderLayout.SOUTH);

    //....    JPanel panel3 = new JPanel();
        
      //  Container container = this.getContentPane();
     //     Container container = panel3.getCon.getContentPane();
        panel3.setLayout(new BorderLayout(1, 0));
        paneltablaproces.setLayout(new BorderLayout(1,0));
//((BorderLayout) container.getLayout()).setHgap(2);
//((BorderLayout) container.getLayout()).setVgap(2);
//panel3.setLayout(borderLayout);


//container.add(button, borderConsts[i]);
      //-----------  panel3.add(scrollPane, BorderLayout.NORTH);

        paneltablaproces.add(scrollPane, BorderLayout.NORTH);




        // panel3.add(scrollPane);
      //  panel3.add(scrollPane, BorderLayout.NORTH);
//container.add(scrollPane,BorderLayout.NORTH);
        JButton boton = new JButton("Terminar proceso");
       // jMenuItem2.setIcon(iconoKillProcess);
       boton.setIcon(iconoKillProcess);
        JButton brefresh = new JButton("Refrescar proceso");
        brefresh.setIcon(iconorefresh);
        JButton boton3 = new JButton("Cancelar");
        boton3.setIcon(iconoExit);

        panel3.add(boton3, BorderLayout.WEST);
        panel3.add(brefresh, BorderLayout.EAST);
        panel3.add(boton, BorderLayout.SOUTH);
        //     container.add(boton,BorderLayout.EAST);
        //container.add(panel3);
        //panel3.add(container);

        boton3.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        //System.out.println("Cerrar Ventana");

                        try {
                          // panelprocesos.DISPOSE_ON_CLOSE
                           // prueba JPanel.removeAll()
                            panel3.removeAll();
                            paneltablaproces.removeAll();
                            //panelprocesos.setVisible(false);
                            panelprocesos.dispose();
                           
                           
                        } catch (Exception event) {
                            JOptionPane.showConfirmDialog(null, "La venta de procesos no se puede cerrar", "Close Windows",
                                    JOptionPane.CLOSED_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE);

                        }
                        ;

                    }
                } // clase interna anónima
                //la clase interna anónima
                ); // Finalizar llamada para addActionListener






        brefresh.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        //System.out.println("Actualizando procesos");

                        try {

                            //panelprocesos.dispose();
                            ejecutoDeComandos.ListarProcesos(1);
                        } catch (Exception event) {
                            JOptionPane.showConfirmDialog(null, "Error,no se pudo Listar procesos", "error list process",
                                    JOptionPane.CLOSED_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE);

                        }
                        ;

                    }
                } // clase interna anónima
                //la clase interna anónima
                ); // Finalizar llamada para addActionListener

        boton.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        int contador = 0;//    throw new UnsupportedOperationException("Not supported yet.");

                        Object[] options = {"Si, Terminar proceso",
                                            "No, Terminar proceso",
                                            };

                        int[] seleccionado = table.getSelectedRows();
                        int cont = 0;
                        String allpid = "";
                        String separador = ">#";
                        if (table.getSelectedRowCount() == 0) {
                            JOptionPane.showConfirmDialog(null, "Debe seleccionar el proceso que desea Terminar", "Kill Process",
                                    JOptionPane.CLOSED_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE);

                        }
                        else{
                           int n = JOptionPane.showOptionDialog(null,
                            "Si mata algun proceso importante!!!. El sistema puede verse afectado \n"
                            + "¿ Esta seguro que desea Terminar los proceso seleccionados ?",
                            "Atención",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.WARNING_MESSAGE,
                            null,
                            options,
                            options[1]);


                       if(n==0){
                        while (seleccionado.length - 1 >= cont) {
                            //System.out.println("Seleccionado " + table.getValueAt(seleccionado[cont], 1).toString());
                            allpid += table.getValueAt(seleccionado[cont], 1).toString() + separador;
                            cont++;
                        }
                        try {
                            ejecutoDeComandos.KillProcesos(allpid.toString());
                           Thread.sleep(1000); 
                           // panelprocesos.dispose();
                            ejecutoDeComandos.ListarProcesos(1);


                        } catch (Exception event) {
                            JOptionPane.showConfirmDialog(null, "El Proceso no se puede matar", "Kill Process",
                                    JOptionPane.CLOSED_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE);

                        };

                       }
                        }

                    }
                } // clase interna anónima
                //la clase interna anónima
                ); // Finalizar llamada para addActionListener



        panel3.add(boton);

//   problema la refrescar consola ------>>>   panelprocesos.setModal(true);
        panelprocesos.setTitle("Lista de procesos");
       Container contentPane2 = panelprocesos.getContentPane();
       //  Container contentPane2 = this.getContentPane();
        contentPane2.add(paneltablaproces, BorderLayout.NORTH);
       contentPane2.add(panel3, BorderLayout.SOUTH);
      //panelprocesos.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panelprocesos.setSize(new Dimension(650, 500));
       
        panelprocesos.pack();
        panelprocesos.setLocationRelativeTo(this);
        //contentPane2.setVisible(true);
        //frameCliente.setLocationRelativeTo(null)
     panelprocesos.setVisible(true);
     
    // contentPane2.show();
    // contentPane2.setVisible(true);
     //panelprocesos.sh
     // panelprocesos.show();
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
public void sacarListaProcesosActivos(String ServiciosActivos)
{
    //System.out.println("Dentro proceso");
  int inicio=0, fin=4;
final JDialog panelServicios = new JDialog(this);
  JList lista = new JList();
DefaultListModel modelo = new DefaultListModel();
 String separador = ">#";
        String aux=null;
 int campos=NumeroDeSubdirectorios(ServiciosActivos,separador);
    //System.out.println("Numero Campos"+campos);


 if (campos==0)
 {
      JOptionPane.showConfirmDialog(null, "Se ha completado el comando de forma incorrectamente, Vuelva a intentarlo.", "Error command",
                                    JOptionPane.CLOSED_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE);

 }
 else
 {
    for(int i = 1; i<=campos; i++){
    fin=ServiciosActivos.indexOf(separador,inicio);
    aux=ServiciosActivos.substring(inicio, fin);
    modelo.addElement(aux);
    inicio=fin+2;
}
lista.setModel(modelo);  
JScrollPane scrollPane = new JScrollPane(lista);
        JPanel panel4=new JPanel ();
scrollPane.setPreferredSize (new Dimension(650, 450));
        Container container = this.getContentPane();
        panel4.setLayout(new BorderLayout(1,1));
panel4.add(scrollPane,BorderLayout.NORTH);
JButton boton = new JButton("  Cerrar  ");
boton.setIcon(iconoExit);
panel4.add(boton,BorderLayout.EAST);


 boton.addActionListener (

         new ActionListener () {

            public void actionPerformed(ActionEvent e) {
                //System.out.println("Cerrar Ventana");

     try
     {

    panelServicios.dispose();
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

//------------------------------------------panelServicios.setModal(true);
panelServicios.setTitle("Lista de servicios activos");
Container contentPane = panelServicios.getContentPane();
contentPane.add(panel4, BorderLayout.CENTER);

panelServicios.setSize(new Dimension(600, 600));
panelServicios.setLocationRelativeTo(this);
panelServicios.pack();

//frameCliente.setLocationRelativeTo(null)
panelServicios.setVisible(true);
//panelServicios.show();
 }
}

public void mensageServicios(String ServiciosActivos){
    System.out.println("Sacamos la lista con los procesos activos");
    sacarListaProcesosActivos(ServiciosActivos);
       //Listar(ServiciosActivos);
}



    @SuppressWarnings("static-access")
public void MostrarImagen(String Imagen){

System.out.println("----[CLIENTE][MostrarImagen2] Inicio (estado="+estado+")...");

//null
if (panelImagen  == null || entrar==1)

{
    entrar=0;
    System.out.println("----[CLIENTE][MostrarImagen2] Creando objetos...");

    panelImagen =   new JDialog(this);
    panelImagen.setTitle("Imagen desde servidor");

    etiqueta    =   new JLabel();
    scrollPane  =   new JScrollPane(etiqueta);

    iIcon1 =   new ImageIcon("c:/capturo12.jpg");
    img1   =   iIcon1.getImage();
    //img2   =   img1.getScaledInstance(800, 1280,  java.awt.Image.SCALE_SMOOTH);
    img2   =   img1.getScaledInstance(500, 500,  java.awt.Image.SCALE_SMOOTH);
    iIcon2 =   new ImageIcon(img2);
    etiqueta.setIcon(iIcon2);


    //etiqueta.setSize(350, 450);

    // Panel 15
    panel5      =   new JPanel();
    panel5.setLayout(new BorderLayout(1,2));
    //panel5.removeAll();
    //panel5.add(etiqueta);
    panel5.add(scrollPane);
    //panel5.add(scrollPane,BorderLayout.NORTH);
    panel5.repaint();

    // Botonera
    play   = new JButton();
 final int ICON_SIZE = 32;
    play.setIcon(iconoPlay);
   // play.setText("Play");
   iconoPlay.setImageObserver(play);
     

     psize= new JButton();
     psize.setIcon(iconobig);
   // play.setText("Play");
   iconoPlay.setImageObserver(psize);



    stop   = new JButton();
    stop.setIcon(iconoStop);
iconoPlay.setImageObserver(stop);

    pause  = new JButton();
    pause.setIcon(iconoPause);
iconoPause.setImageObserver(pause);



    save   = new JButton("Save");


    exit   = new JButton();//exit
   exit.setIcon(iconoExit);
iconoExit.setImageObserver(exit);




    psize.setEnabled(true);
    play.setEnabled(true);
    pause.setEnabled(false);
    stop.setEnabled(false);
    save.setEnabled(false);
    exit.setEnabled(true);
    panel6 = new JPanel();
    panel6.add(play,BorderLayout.SOUTH);
    panel6.add(stop,BorderLayout.SOUTH);
    panel6.add(pause,BorderLayout.WEST);
    panel6.add(save,BorderLayout.WEST);
    panel6.add(psize,BorderLayout.WEST);
    panel6.add(exit,BorderLayout.WEST);

        panelImagen.addWindowListener(
                new WindowListener() {
                     public void windowClosing(WindowEvent e) {
                        System.out.println("----[CLIENTE][MostrarImagen2].window: cerrando");
                        estado=0;
                        entrar=1;
                     }
                     public void windowClosed(WindowEvent e) {
                        System.out.println("Window Closed");
                     }
                     public void windowIconified(WindowEvent e) {
                        System.out.println("Window Iconified");
                     }
                     public void windowDeiconified(WindowEvent e) {
                        System.out.println("Window Deiconified");
                     }
                     public void windowOpened(WindowEvent e) {
                        System.out.println("Window Opened");
                     }
                     public void windowActivated(WindowEvent e) {
                        System.out.println("Window Activated");
                     }
                     public void windowDeactivated(WindowEvent e) {
                        System.out.println("Window Deactivated");
                     }

                }
                );

        psize.addActionListener (
            new ActionListener () {
                public void actionPerformed(ActionEvent e) {
                    tipo_tam=1;
                    contarr++;
                     if ((contarr % 2)==0)
                         tipo_tam=0;
                    System.out.println("----[Ampliar[IIIIIIIIIIIIIIIIIIIIIImagen2].AUMENTAR: 1");
                    /*Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
                    panelImagen.setSize(d);
		    panelImagen.setResizable(false);
                    panel5.setSize(d.height-40,d.width-40);
                    panelImagen.setLocationRelativeTo(null);
                    iIcon1 =   new ImageIcon("c:/capturo12.jpg");
                    img1   =   iIcon1.getImage();
*/
               //img2   =   img1.getScaledInstance(800, 1280,  java.awt.Image.SCALE_SMOOTH);
               //La inagen la hacemos mas grande
               if (tipo_tam==0){ //tamaño normal
                   System.out.println("----[Ampliar[iiiiiiiiiiiiiiiiiiiimagen2].disminuir: 0");
                   psize.setIcon(iconobig);
   // play.setText("Play");
                    iconoPlay.setImageObserver(psize);
                    panelImagen.setSize(new Dimension(500, 500));
                   panelImagen.setResizable(false);
                   // panel5.setSize(d.height-40,d.width-40);
                    panelImagen.setLocationRelativeTo(null);
                   //img2   =   img1.getScaledInstance(600, 600,  java.awt.Image.SCALE_SMOOTH);

                   img2   =   img1.getScaledInstance(600, 600,  java.awt.Image.SCALE_SMOOTH);
               }
                   else{
         //   Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
               psize.setIcon(iconosmall);
   // play.setText("Play");
               iconoPlay.setImageObserver(psize);
                        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
                    panelImagen.setSize(d);
		    panelImagen.setResizable(false);
                    panel5.setSize(d.height-40,d.width-40);
                    panelImagen.setLocationRelativeTo(null);
                    iIcon1 =   new ImageIcon("c:/capturo12.jpg");
                    img1   =   iIcon1.getImage();
                   img2   =   img1.getScaledInstance(d.width-40,d.height-80,  java.awt.Image.SCALE_SMOOTH);
                 }
               // img2   =   img1.getScaledInstance(d.width-40,d.height-80,  java.awt.Image.SCALE_SMOOTH);
               iIcon2 =   new ImageIcon(img2);
               etiqueta.setIcon(iIcon2);

psize.repaint();

                }
            } // clase interna anónima
        ); // Finalizar llamada para addActionListener



        save.addActionListener (
            new ActionListener () {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("----[CLIENTE][MostrarImagen2].save: 1");
                    try {
                        //panelImagen.dispose();
                        ejecutoDeComandos.recibirImagenServidor(1);
                        }
                    catch (NuestraExeption ex) {
                        JOptionPane.showConfirmDialog(null, ex.getMessage(), "conexion",
                                                    JOptionPane.CLOSED_OPTION,
                                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                }
            } // clase interna anónima
        ); // Finalizar llamada para addActionListener

        play.addActionListener (
            new ActionListener () {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("----[CLIENTE][MostrarImagen2].play: 1 (Me han pulsado)");

                    estado=1;

                    play.setEnabled(false);
                    pause.setEnabled(true);
                    stop.setEnabled(true);
                    save.setEnabled(true);

                   try {
                            System.out.println("----[CLIENTE][MostrarImagen2].play: 2 (Llamando a recibirImagenServidor())");
                          //  panelImagen.dispose();
                            ejecutoDeComandos.recibirImagenServidor();
                        }
                    catch (NuestraExeption ex) {
                        JOptionPane.showConfirmDialog(null, ex.getMessage(), "conexion", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            } // clase interna anónima
        ); // Finalizar llamada para addActionListener

        pause.addActionListener (
            new ActionListener () {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("----[CLIENTE][MostrarImagen2].pause: 1 (Me han pulsado)");
                    estado=0;

                    play.setEnabled(true);
                    pause.setEnabled(false);
                    stop.setEnabled(false);
                }
            } // clase interna anónima
        ); // Finalizar llamada para addActionListener

        stop.addActionListener (
            new ActionListener () {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("----[CLIENTE][MostrarImagen2].stop: 1 (Me han pulsado)");
                    estado=0;
                    play.setEnabled(true);
                    pause.setEnabled(false);
                    stop.setEnabled(false);
                }
            } // clase interna anónima
        ); // Finalizar llamada para addActionListener

        exit.addActionListener (
            new ActionListener () {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("----[CLIENTE][MostrarImagen2].exit: 1 (Me han pulsado)");
                    //esexittado=0;

                    panelImagen.setVisible(false);
                    entrar=1;
                    tipo_tam=0;
                    contarr=0;
                    //panelImagen.dispose();
                }
            } // clase interna anónima
        ); // Finalizar llamada para addActionListener


        //contentPane = new Container();
        contentPane = panelImagen.getContentPane();
        contentPane.add(panel5, BorderLayout.CENTER);
        contentPane.add(panel6, BorderLayout.SOUTH);
        contentPane.repaint();
        panelImagen.repaint();
        panelImagen.pack();
        panelImagen.setLocationRelativeTo(this);
        panelImagen.setSize(new Dimension(500, 500));
        //panelImagen.show();
        panelImagen.setVisible(true);

        System.out.println("----[CLIENTE][MostrarImagen2] Creando objetos 6...");

        estado=0;
        System.out.println("----[CLIENTE][MostrarImagen2] Objetos creados...");

}          // if (panelImagen  == null)

    System.out.println("----[CLIENTE][MostrarImagen2] Bucle (estado="+estado+")...");
    while(estado==1)
    {
            try {
                System.out.println("----[CLIENTE][MostrarImagen2] Bucle... Llamando a recibirImagenServidor()...");
                ejecutoDeComandos.recibirImagenServidor();
                }
            catch (NuestraExeption ex)
                {
                System.out.println("ERROR>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                Logger.getLogger(FrameCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            
    if (panelImagen != null) {

        iIcon1 =   new ImageIcon("c:/capturo12.jpg");
        img1   =   iIcon1.getImage();
        //img2   =   img1.getScaledInstance(800, 1280,  java.awt.Image.SCALE_SMOOTH);
       
        if (tipo_tam==0){ //tamaño normal
          panelImagen.setSize(new Dimension(500, 500));
         img2   =   img1.getScaledInstance(600, 600,  java.awt.Image.SCALE_SMOOTH);
        }
         else{
                    System.out.println("[SIZE]-------->>>>>>pintamos Imagen grande");
                    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
                  panelImagen.setSize(d);
                  img2   =   img1.getScaledInstance(d.width-40,d.height-80,  java.awt.Image.SCALE_SMOOTH);

            //Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
            //img2   =   img1.getScaledInstance(d.width-40,d.height-40,  java.awt.Image.SCALE_SMOOTH);
        }
        iIcon2 =   new ImageIcon(img2);
        etiqueta.setIcon(iIcon2);

        etiqueta.repaint();
       // panel5.repaint();
       // panelImagen.repaint();
    }


//    try {
//          System.out.println("----[CLIENTE][MostrarImagen2] Bucle... SLEEPING...");
//                Thread.sleep(3000); //Tarea que consume diez segundos.
//        }
//        catch (InterruptedException ex)
//            {
//            Logger.getLogger(FrameCliente.class.getName()).log(Level.SEVERE, null, ex);
//            }

        System.out.println("----[CLIENTE][MostrarImagen2] Bucle... Fin");
    }
    
System.out.println("----[CLIENTE][MostrarImagen2] Fin.");

}



//recibe imagen
public void mensageVideo(String NombreCaptura){
    MostrarImagen(NombreCaptura);
}

    public void clearShell2() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mensageInformacionEquipo(String informacionEquipo) {
        //throw new UnsupportedOperationException("Not supported yet.");
       panelInformacion=new JDialog(this);
       panelInformacion.getContentPane().setLayout (new GridBagLayout());
        Container contentPane = panelInformacion.getContentPane();
        System.out.println("Dispuesto a mostrar ------------------>>>[Infortion compter]");
       JPanel panelInfor=new JPanel();
       GridBagConstraints constraints = new GridBagConstraints();
       JPanel panelInfoArea=new JPanel();

       JPanel ZonaButton=new JPanel();
       JLabel etiqueta2=new JLabel ();

       JButton sal=new JButton();
//clear.addActionListener(new FrameCliente_ListaProcess_actionAdapter(this));
     sal.setIcon(iconoExit);
       constraints.gridx = 3;
    constraints.gridy = 3;
    constraints.gridwidth = 1;
    constraints.gridheight = 1;constraints.anchor = GridBagConstraints.SOUTHEAST;
//constraints.weighty = 0.0;
constraints.weightx = 0.0;
constraints.weighty = 0.0;
constraints.fill = GridBagConstraints.NONE;
panelInformacion.getContentPane().add (sal, constraints);
constraints.weighty = 0.0; // Restauramos el valor por defecto.
       //sal.setPreferredSize(new Dimension(5,5));
      
   //----------->>>>>>>    ZonaButton.add(sal);
       etiqueta2.setIcon(iconoinformacion);
       JScrollPane jScrollPan = new JScrollPane();
       JTextArea area=new JTextArea (informacionEquipo);
       area.setEditable(false);
       

       //panelInfoArea.add(jScrollPan);

       
       
       constraints.gridx = 0; // El área de texto empieza en la columna cero.
       constraints.gridy = 0; // El área de texto empieza en la fila cero
      constraints.gridwidth = 2; // El área de texto ocupa dos columnas.
      constraints.gridheight = 2; // El área de texto ocupa 2 filas.
     
     // this.getContentPane().add (p);
    //  constraints.fill = GridBagConstraints.EAST;
constraints.weightx = 0.0;
constraints.weighty = 0.0;
constraints.fill = GridBagConstraints.CENTER;
//gbc.fill = GridBagConstraints.NONE;
//constraints.gridwidth = GridBagConstraints.RELATIVE;
jScrollPan.getViewport().add(area,constraints);
     panelInformacion.getContentPane().add (jScrollPan,constraints);
      //panelInformacion.getContentPane().add (jScrollPan);
       //panelInfoArea.add(stop);

constraints.weighty = 0.0; // Restauramos el valor por defecto.
       panelInformacion.setTitle("Informacion del equipo");
       //.setLayout (new GridBagLayout());
      




       //------------------>>>>>panelInfor.add(etiqueta);

       constraints.gridx = 3;
constraints.gridy = 0;
constraints.gridwidth = 1;
constraints.gridheight = 1;
//constraints.fill = GridBagConstraints.WEST;
constraints.weightx = 0.0;
constraints.weighty = 0.0;
constraints.fill = GridBagConstraints.WEST;
//constraints.gridwidth = GridBagConstraints.RELATIVE;
panelInformacion.getContentPane().add (etiqueta2, constraints);
constraints.weighty = 0.0; // Restauramos el valor por defecto.
/* ESTTTTTT------------------------------->>>>>>>>>>>>>*/
      //contentPane.add(panelInfor, BorderLayout.CENTER);
  //    contentPane.add(panelInfor, BorderLayout.SOUTH);
  //    contentPane.add(panelInfoArea, BorderLayout.WEST);
  //    contentPane.add(ZonaButton,BorderLayout.EAST);



panelInformacion.setSize(new Dimension(700, 700));
       panelInformacion.setLocationRelativeTo(this);
       panelInformacion.pack();

//frameCliente.setLocationRelativeTo(null)
       panelInformacion.setVisible(true);


       sal.addActionListener (
            new ActionListener () {
                public void actionPerformed(ActionEvent e) {

                //    System.out.println("LIMPIO ");
                panelInformacion.dispose();
                    //adaptee.conectarRadioButton_actionPerformed(e);

                }
            } // clase interna anónima
        ); // Finalizar llamada para addActionListener






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
