package net.javahispano.nettools.cliente;

/**
 * <p>Tìtulo: NetTools </p>
 * <p>Descripción: Administraci�n Remota Windows 2000</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Empresa: fenomenoweb </p>
 * @Programado por Juan Garrido Caballero y adolfo Sanz
 * @version 2.0
 * Web: http://nettools20.cjb.net
 */

import java.net.*;
import java.io.*;
import net.javahispano.nettools.cliente.UI.DarRutaFichero;


public class RecibidorArchivos implements Runnable {

    public static int puerto = 65302;
    FileOutputStream fichero;
    BufferedInputStream entrada = null;
    int BUFF_SIZE = 1024;
    byte[] buffer;
    int n;
    String host;
    int operacion;
    //----clase  -->>JFileChooser Guarda_Archivos = null;

    public RecibidorArchivos(String host) {
        this.host = host;
        this.operacion = 0;
    }

    public RecibidorArchivos(String host, int operacion) {
        this.host = host;
        this.operacion = 1;
    }

    public void run() {
        try {
            System.out.println("Antes ---->RecibirArchivo");
            Socket recibeArchivos = new Socket(host, puerto);
           DarRutaFichero fich=new DarRutaFichero();
            if (operacion == 1) {
                fich.DarRutaFichero1(operacion);

                //----clase  -->>             Guarda_Archivos = new JFileChooser();

                fichero = new FileOutputStream("c:\\capturo12.jpg");

                entrada = new BufferedInputStream(recibeArchivos.getInputStream());
                buffer = new byte[BUFF_SIZE];
                while ((n = entrada.read(buffer)) != -1) {
                    fichero.write(buffer, 0, n);


                }
        

                System.out.println("Despues ---->Guardado archivo");
                fichero.close();
                entrada.close();
                recibeArchivos = null;
            } else {
                fichero =fich.DarRutaFichero2(operacion);

     //----clase  -->>                Guarda_Archivos = new JFileChooser();
     //----clase  -->>                int opcion = Guarda_Archivos.showSaveDialog(null);
     //----clase  -->>               if (opcion == Guarda_Archivos.APPROVE_OPTION) {
     //----clase  -->>                    fichero = new FileOutputStream(Guarda_Archivos.getSelectedFile().
    //----clase  -->>                        getAbsolutePath());
                    entrada = new BufferedInputStream(recibeArchivos.getInputStream());
                    buffer = new byte[BUFF_SIZE];
                    while ((n = entrada.read(buffer)) != -1) {
                        fichero.write(buffer, 0, n);


                    }
                    fichero.close();
                    entrada.close();
                    recibeArchivos = null;
          //----clase  -->>   }




            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
