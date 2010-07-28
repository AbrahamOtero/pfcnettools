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
        fichero.close();
        entrada.close();
        recibeArchivos = null;
      }


    }
    catch (Exception e) {e.printStackTrace();}
  }


}
