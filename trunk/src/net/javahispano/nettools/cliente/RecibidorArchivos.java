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


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.net.*;
import java.io.*;
import javax.swing.*;

public class RecibidorArchivos implements Runnable
{
  public static int puerto=65302;
  FileOutputStream fichero;
  BufferedInputStream entrada=null;
  int BUFF_SIZE = 1024;
  byte[] buffer;
  int n;
  String host;
  JFileChooser Guarda_Archivos=null;
  public RecibidorArchivos(String host)
  {
    this.host=host;
  }
  public void run()
  {
    try {
        System.out.println("Antes ---->RecibirArchivo");
      Socket recibeArchivos = new Socket(host, puerto);
      Guarda_Archivos=new JFileChooser();

      int opcion=Guarda_Archivos.showSaveDialog(null);
      if(opcion==Guarda_Archivos.APPROVE_OPTION)
      {
        fichero = new FileOutputStream(Guarda_Archivos.getSelectedFile().
                                       getAbsolutePath());
        entrada = new BufferedInputStream(recibeArchivos.getInputStream());
        buffer = new byte[BUFF_SIZE];
        while ( (n = entrada.read(buffer)) != -1) {
          fichero.write(buffer, 0, n);
      

        }
        /*ImageIcon img = new ImageIcon(Guarda_Archivos.getSelectedFile().
                                       getAbsolutePath());*/
        ImageIcon img = new ImageIcon("C:/capturo.jpg");
          System.out.println(Guarda_Archivos.getSelectedFile().
                                       getAbsolutePath());
     JDialog panelImagen = new JDialog();
        JLabel etiqueta = new JLabel(img);
         JPanel panel5=new JPanel ();

     //   Container container = this.getContentPane();
        panel5.setLayout(new BorderLayout(1,1));


       panelImagen.setModal(true);
panelImagen.setTitle("Pantalla remota");
panel5.add(etiqueta);
Container contentPane = panelImagen.getContentPane();
contentPane.add(panel5, BorderLayout.CENTER);
panelImagen.pack();
panelImagen.setSize(new Dimension(900, 900));
//panelImagen.setLocationRelativeTo(this);


//frameCliente.setLocationRelativeTo(null)

panelImagen.show();


          JFrame v = new JFrame ();
        JScrollPane scroll = new JScrollPane();
        v.setTitle("EEEEEEEEEEEEEEEEEEEEECOPIA");
        v.getContentPane().add(scroll);
        v.pack();
        v.setVisible(true);



         System.out.println("Despues ---->Guardado archivo");
        fichero.close();
        entrada.close();
        recibeArchivos = null;
      }


    }
    catch (Exception e) {e.printStackTrace();}
  }


}
