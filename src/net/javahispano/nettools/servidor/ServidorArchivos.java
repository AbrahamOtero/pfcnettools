package net.javahispano.nettools.servidor;

/**
 * <p>T�tulo: NetTools </p>
 * <p>Descripción: Administración Remota Windows 2000</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Empresa: fenomenoweb </p>
 * @Programado por Juan Garrido Caballero y Adolfo Sanz
 * @version 2.0
 * Web: http://nettools20.cjb.net
 */


import java.net.*;
import java.io.*;

public class ServidorArchivos implements Runnable
{
  public static int puerto=65302;
  public static int n=0;
  public static int BUFFER_SIZE = 1024;
  public static byte[] buff=null;
  String archivo;
  int operacion;
  public ServidorArchivos(String archivo)
  {
    this.archivo=archivo;
      System.out.println("Archivo del servidor a descargar"+this.archivo);
    this.operacion=0;
  }
public ServidorArchivos(String archivo,int operacion)
  {
    this.archivo=archivo;
    operacion=1;
    
  }
  public void run()
   {
     try {
       ServerSocket servidor = new ServerSocket(puerto);
       Socket cliente = servidor.accept();
       FileInputStream fichero = new FileInputStream(archivo);
       BufferedOutputStream salida = new BufferedOutputStream(cliente.
           getOutputStream());
       buff = new byte[BUFFER_SIZE];
       while ( (n = fichero.read(buff)) != -1) {
         salida.write(buff, 0, n);
       }
       salida.flush();
       salida.close();
       servidor.close();
       cliente.close();

     }
     catch (Exception event) {}
  }



}
