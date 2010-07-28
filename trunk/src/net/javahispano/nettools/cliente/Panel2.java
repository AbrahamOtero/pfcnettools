package net.javahispano.nettools.cliente;

/**
 * <p>T�tulo: NetTools </p>
 * <p>Descripci�n: Administraci�n Remota Windows 2000</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Empresa: fenomenoweb </p>
 * @Programado por Juan Garrido Caballero
 * @version 2.0
 * Web: http://nettools20.cjb.net
 */


import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.*;
import net.javahispano.nettools.cliente.UI.FrameCliente;

  class Frame2 extends JFrame{

  Toolkit kit = Toolkit.getDefaultToolkit();
  public static final int ancho=200;
  public static final int alto=134;
  DefaultMutableTreeNode root;

  public Frame2(DefaultMutableTreeNode root)
  {
      //this.setTitle("JJJJJJJJJJJJ");
    this.root=root;
    Image img = kit.getImage("iconos/remoto.gif");
    setIconImage(img);
    setSize(ancho,alto);
    setTitle("NOOOOOOOOOOO");
    Panel2 dentro=new Panel2(root);
    Container contenido=getContentPane();
    contenido.add(dentro);
  }

}

public class Panel2 extends JPanel implements TreeSelectionListener  {

private EjecutaComandos ejecutoDeComandos;
public JTree arbol;
 public Panel2(DefaultMutableTreeNode root)
  {
  }
 


public Panel2(DefaultMutableTreeNode root,FrameCliente ff)
  {

   // setIconImage(Toolkit.getDefaultToolkit().createImage(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource(("iconos/logo.gif"))));
      // Frame2 ff= new Frame2(root);



/*       JTree tree = new JTree(root);
       JFrame v = new JFrame();
       v.setTitle("LLEEGA TODO DDDDESDE");
        JScrollPane scroll = new JScrollPane(tree);
     //   v.getContentPane().add(scroll);
        v.getContentPane().add(tree);
        v.pack();
        v.setVisible(true);
        v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
*/

    try
    {
      String clase = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
      UIManager.setLookAndFeel(clase);
      arbol = new JTree(root);
      //JTree arbol = new JTree(root);

      //JScrollBar scroll = new JScrollBar(root);
       // Cambiamos los iconos
        DefaultTreeCellRenderer render= (DefaultTreeCellRenderer)arbol.getCellRenderer();
        render.setLeafIcon(new ImageIcon("C:/Documents and Settings/Usuario/Mis documentos/NetBeansProjects/proye/src/net/javahispano/nettools/cliente/UI/iconos/discos.gif"));
      render.setOpenIcon(new ImageIcon("C:/Documents and Settings/Usuario/Mis documentos/NetBeansProjects/proye/src/net/javahispano/nettools/cliente/UI/iconos/accion.gif"));
       render.setClosedIcon(new ImageIcon("C:/Documents and Settings/Usuario/Mis documentos/NetBeansProjects/proye/src/net/javahispano/nettools/cliente/UI/iconos/accion.gif"));
        setLayout(new BorderLayout());
      arbol.setRootVisible(true);
       arbol.getSelectionModel().addTreeSelectionListener((TreeSelectionListener) this);
       add(new JScrollPane( (JTree) arbol), "Center");





    }
    catch(Exception event){

}
// 
  }



public void valueChanged (TreeSelectionEvent e){
 //       try {
            System.out.println("Llemamos para generar nodo nuevo del arbol");
            DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) arbol.getLastSelectedPathComponent();
           ejecutoDeComandos = new EjecutaComandos();
            //String path=(String) nodo.getUserObject();
           String f = nodo.getUserObject().toString();
            System.out.println(f);
        try {

            ejecutoDeComandos.listarDirectorio(f);
            /*try {
            //Objeto nuevoMensaje = new Objeto("listar", f, null, 0, 0, null);
            ejecutoDeComandos.listarDirectorio(f);
            //  conexion.MandaMensaje(nuevoMensaje);
            //       } catch (NuestraExeption ex) {
            //           Logger.getLogger(Panel2.class.getName()).log(Level.SEVERE, null, ex);
            //       }
            } catch (NuestraExeption ex) {
            Logger.getLogger(Panel2.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        } catch (NuestraExeption ex) {
            Logger.getLogger(Panel2.class.getName()).log(Level.SEVERE, null, ex);
        }




}

    public void mensageInformacionArbol(DefaultMutableTreeNode Modeltree) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mensageInformacion(String texto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mensageError(String texto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void informaSobreElProgreso(int progreso) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isConnected() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void StatusConex(String status) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void StatusDesc(String desc) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Objeto recibeMensaje() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

