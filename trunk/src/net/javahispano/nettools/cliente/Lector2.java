package net.javahispano.nettools.cliente;

/**
 * <p>T�tulo: NetTools 2.0</p>
 * <p>Descripción: Herramienta de Administraci�n remota Windows 2000</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Empresa: fenomenoweb</p>
 * @author Juan Garrido Caballero, Abraham Otero y Adolfo Sanz
 * @version 0.8
 */

import net.javahispano.nettols.comunicaciones.Objeto;

import java.awt.image.*;
import java.awt.*;
import javax.swing.ImageIcon;





public class Lector2 implements Runnable {
  private Informable cliente;
  private Conexiones conexion;
  public static int ImageHeight = 0;
  public static int ImageWidth = 0;

  public Lector2(Informable cliente, Conexiones conexion) {
      System.out.println("CLIENTEEEEEEE|||||||||||||||_____>>>"+cliente.toString());
    this.cliente = cliente;
    this.conexion = conexion;
  }

  public void run() {
    String pantalla = "";
    String realizado = "                                                                                       Administración remota Windows 2000,NT,XP\n";
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
                 Mensaje.orden=Mensaje.orden.replaceAll(">#","\n");

                 System.out.println("Salimos");
             }


            if (Mensaje.peticion==2){
                System.out.println("Recibe Mensaje clase Lector --SSSSS");
                  System.out.println("PASAMOS");
                 // pantalla += Mensaje.orden;
                 //  cliente.
            cliente.mensageReconstruirArbol(Mensaje.orden);
       
                   Mensaje.orden=Mensaje.orden.replaceAll(">#","\n");
        

            }
             if (Mensaje.peticion==3){
                 System.out.println("Preparado para listar los procesoos 333");
                 System.out.println(Mensaje.orden);
              cliente.mensageInformacion(realizado + pantalla);
                cliente.mensageListarProcesos(Mensaje.orden);
                 Mensaje.orden=Mensaje.orden.replaceAll(">#","\n");
             }

              if (Mensaje.peticion==5){
                 System.out.println("Preparado para listar los procesoos 55555");
                 System.out.println(Mensaje.orden);
                cliente.mensageActualizarListarProcesos(Mensaje.orden);
                 Mensaje.orden=Mensaje.orden.replaceAll(">#","\n");
             }

             if (Mensaje.peticion==4){
                 System.out.println("Preparado para listar los procesoos");
                 System.out.println(Mensaje.orden);
                cliente.mensageServicios(Mensaje.orden);
                 Mensaje.orden=Mensaje.orden.replaceAll(">#","\n");
             }
             if (Mensaje.peticion==6){
                 System.out.println("Retardo y Enviamosss ------------------>>>[Infortion compter]");
                 cliente.mensageInformacionEquipo(Mensaje.orden);
             }



          System.out.println("---------->>>>> mostramos por terminal");
          pantalla += Mensaje.orden;
          
        }
          System.out.println("Justo antes de entrar"+Mensaje.imagen+ ">>>>--- alto"+Mensaje.ancho+ "ancho"+ Mensaje.alto);
        //if (Mensaje.imagen != null) {
         if (Mensaje.ancho != 0) {

          try {
              System.out.println("Justo  al entrar >>>>---");
            ImageHeight = Mensaje.ancho;
            ImageWidth = Mensaje.alto;
            System.out.println("Dentro <<<<<<<<<<<<<<<<<<<");
            BufferedImage NewBufferedImage = new BufferedImage(ImageWidth,
                ImageHeight, BufferedImage.TYPE_INT_RGB);
            Graphics g = NewBufferedImage.createGraphics();
          //  g.setColor(Color.BLACK);
            g.fillRect(0, 0, ImageWidth, ImageHeight);
               System.out.println("Antes ---->Run");
  
          //   g.drawImage(NewBufferedImage, 0, 0, null);
            // g.drawImage(Mensaje.imagen.getImage(), 0, 0, null);
               ImageIcon img = new ImageIcon("c:\\capturo.jpg");
      
           cliente.mensageVideo(Mensaje.orden);

           
             System.out.println("Antes ---->Run");
            /*Runtime.getRuntime().exec(
                "rundll32.exe url.dll FileProtocolHandler c:\\capturo.jpg");
 System.out.println("Despues ---->Runnnnnnn");*/
  
          }
          catch (Exception event) {
            cliente.mensageInformacion(realizado +
                                       "\nImposible cargar imagen del servidor");
          }
        }
        if (Mensaje.root != null) {
            System.out.println("Dentro del root22222222222255555559999999");
       
        }
         
        cliente.mensageInformacion(realizado + pantalla);
      }

    }

  }


/*
       public void run2() {
        for (int i = 0; i < 10 ; i++)
           // System.out.println(i + " " + getName());
        System.out.println("Termina thread);}
*/
}
