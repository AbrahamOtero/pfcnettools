package net.javahispano.nettools.cliente;

/**
 * <p>T�tulo: NetTools </p>
 * <p>Descripcin: Administraci�n Remota Windows 2000</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Empresa: fenomenoweb </p>
 * @Programado por Juan Garrido Caballero y Adolfo Sanz
 * @version 2.0
 * Web: http://nettools20.cjb.net
 */


import net.javahispano.nettols.comunicaciones.Objeto;
import java.io.*;
import java.net.*;


public class Conexiones
{
  ObjectOutputStream Flujo_Salida=null;
  ObjectInputStream Flujo_Entrada=null;
  Socket cliente=null;
  public Conexiones(Socket cliente)
  {
    this.cliente=cliente;

  }
  public void Crea_Flujos()
  {
    try
    {
      Flujo_Salida = new ObjectOutputStream(cliente.getOutputStream());
      Flujo_Entrada = new ObjectInputStream(cliente.getInputStream());
    }
    catch(Exception event){System.out.println(event);}
  }

  public Objeto RecibeMensaje()
  {
    Objeto MensajeRecibido=null;
    try
    {
      MensajeRecibido = (Objeto) Flujo_Entrada.readObject();
      System.out.println("Mensaje Recibido");

    }
    catch(Exception event)
    {
     //JOptionPane.showConfirmDialog(null,"No se ha podido cargar el mensaje","NetTools",JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE);
     //System.exit(0);
    }
    return MensajeRecibido;
  }

  public void MandaMensaje(Objeto Mensaje)
  {
    try
    {
      Flujo_Salida.writeObject(Mensaje);
      Flujo_Salida.flush();
    }
    catch(Exception event)
    {
    // JOptionPane.showConfirmDialog(null,event,"NetTools",JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE);

    }
  }



}
