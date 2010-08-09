package net.javahispano.nettools.cliente;

/**
 * <p>T�tulo: NetTools 2.0</p>
 * <p>Descripci�n: Herramienta de Administraci�n remota Windows 2000</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Empresa: fenomenoweb</p>
 * @author Juan Garrido Caballero y Abraham Otero
 * @version 0.8
 */

import java.io.*;
import javax.imageio.*;
import java.awt.image.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;

public class Lector2 implements Runnable {
  private Informable cliente;
  private Conexiones conexion;
  public static int ImageHeight = 0;
  public static int ImageWidth = 0;

  public Lector2(Informable cliente, Conexiones conexion) {
    this.cliente = cliente;
    this.conexion = conexion;
  }

  public void run() {
    String pantalla = "";
    String realizado = "                                                                                       Administraci�n remota Windows 2000,NT,XP\n";
    cliente.mensageInformacion(realizado);
    while (cliente.isConnected()) {
      Objeto Mensaje = conexion.RecibeMensaje();
        //System.out.println("ESTOOOOOOOO"+conexion.RecibeMensaje());
      if (Mensaje != null) {
        if (Mensaje.orden != null) {
          // System.out.println("Llamamos a lista procesossSSSSS");
             if (Mensaje.peticion==1){
                 System.out.println("Todos las unidades de disco"+Mensaje.orden);
                 cliente.mensageInformacionArbol(Mensaje.orden);

       /* JTree tree = new JTree(Mensaje.root);
        JFrame v = new JFrame();
        JScrollPane scroll = new JScrollPane(tree);
        v.getContentPane().add(scroll);
        v.pack();
        v.setVisible(true);*/
      //  v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                 System.out.println("Salimos");
             }


            if (Mensaje.peticion==2){
                System.out.println("Recibe Mensaje clase Lector --SSSSS");
                  System.out.println("PASAMOS");
                 // pantalla += Mensaje.orden;
                 //  cliente.
            cliente.mensageReconstruirArbol(Mensaje.orden);
          // String Cadena
                   Mensaje.orden=Mensaje.orden.replaceAll(">#","\n");
             //   System.out.println("cadena++++"+Cadena);
           //JTree tree = new JTree(Mensaje.root);
       /* JFrame v = new JFrame();
        JScrollPane scroll = new JScrollPane(tree);
        v.getContentPane().add(scroll);
        v.pack();
        v.setVisible(true);*/
            //      Tree arbol=new Tree (Mensaje.orden);


            }
             if (Mensaje.peticion==3){
                 System.out.println("Preparado para listar los procesoos");
                 System.out.println(Mensaje.orden);
                cliente.mensageListarProcesos(Mensaje.orden);
                 Mensaje.orden=Mensaje.orden.replaceAll(">#","\n");




             }
              else
                System.out.println("1111111111"+Mensaje.orden);

          pantalla += Mensaje.orden;
          
        }
        if (Mensaje.imagen != null) {
          try {
            ImageHeight = Mensaje.ancho;
            ImageWidth = Mensaje.alto;
            BufferedImage NewBufferedImage = new BufferedImage(ImageWidth,
                ImageHeight, BufferedImage.TYPE_INT_RGB);
            Graphics g = NewBufferedImage.createGraphics();
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, ImageWidth, ImageHeight);
            g.drawImage(Mensaje.imagen.getImage(), 0, 0, null);
            g.dispose();
            File outfile = new File("c:\\capturo.jpg");
            ImageIO.write(NewBufferedImage, "jpg", outfile);
            Runtime.getRuntime().exec(
                "rundll32.exe url.dll FileProtocolHandler c:\\capturo.jpg");

          }
          catch (Exception event) {
            cliente.mensageInformacion(realizado +
                                       "\nImposible cargar imagen del servidor");
          }
        }
        if (Mensaje.root != null) {
            System.out.println("Dentro del root22222222222255555559999999");
       //   Frame2 nuevo = new Frame2(Mensaje.root);
   //       nuevo.show();
        }
        cliente.mensageInformacion(realizado + pantalla);
      }

    }
  }
}
