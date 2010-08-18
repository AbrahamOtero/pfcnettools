package net.javahispano.nettools.cliente;

/**
 * <p>T�tulo: NetTools 2.0</p>
 * <p>Descripci�n: Herramienta de Administraci�n remota Windows 2000</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Empresa: fenomenoweb</p>
 * @author Juan Garrido Caballero y Abraham Otero
 * @version 0.8
 */

import java.net.*;
import javax.swing.*;
import java.io.*;
import javax.swing.tree.DefaultMutableTreeNode;
import net.javahispano.nettools.cliente.UI.*;

public class EjecutaComandos {
  private Socket cliente = null;
  private Conexiones conexion = null;
  private String host = null;
  private Informable informable;

  private String comando_regedit = (
      "\nDebes quitar la protección NTLM del registro del sistema.");
  private String comando_regedit2 = (
      "\nEjecuta el registro remoto. Conéctate a la m�quina y ve a ");
  private String comando_regedit3 = (
      "\n[HKEY_LOCAL_MACHINE\\SOFTWARE\\Microsoft\\TelnetServer\\1.0]");
  private String comando_regedit4 = ("\nRegistro NTLM cambiar valor a 0.\nUna vez hecho esto debes reiniciar Telnet en el equipo remoto");
  private String registrin = comando_regedit + comando_regedit2 +
      comando_regedit3 + comando_regedit4;


   public EjecutaComandos() {

      System.out.println(this.informable);
  }


  public EjecutaComandos(Informable informable) {
    this.informable = informable;
      System.out.println(this.informable);
  }

  /**
   * M�todo que usamos para conectar con el Servidor
   */

  public void conectar(String host) throws NuestraExeption {
    try {
      this.host = host;
      cliente = new Socket(host, 65300);
      conexion = new Conexiones(cliente);
      conexion.Crea_Flujos();
      Thread hilo = new Thread(new Lector2(informable, conexion));
      hilo.start();
      if (informable.isConnected())
      {informable.StatusConex(host);}
    }
    catch (Exception e) {
      throw new NuestraExeption("No se ha podido establecer conexi�n");
    }
  }

  /**
   * M�todo que usamos para requerir informaci�n del Servidor
   */

  public void getInformacionHost() throws NuestraExeption {
    try {
      Objeto nuevoMensaje = new Objeto("informacion", "", null, 0, 0, null);
      conexion.MandaMensaje(nuevoMensaje);
    }
    catch (Exception e) {
      throw new NuestraExeption("No se ha podido recibir informaci�n del host");
    }
  }

  public void RundllConecta(String aplicacion) throws NuestraExeption
  {
    try
    {
      Objeto nuevoMensaje = new Objeto("abrir",aplicacion, null, 0, 0, null);
      conexion.MandaMensaje(nuevoMensaje);
    }
    catch(Exception e){}
  }

  /**
   *
   * Abre una urlmde la m�quia remota
   * @param url String
   * @throws NuestraExeption
   */
  public void abrirURL(String url) throws NuestraExeption {
    try {
      Objeto nuevoMensaje = new Objeto("url", url, null, 0, 0, null);
      conexion.MandaMensaje(nuevoMensaje);

    }
    catch (Exception event) {
      throw new NuestraExeption("No se puede abrir " + url);
    }

  }

  /**
   * Lo utilizamos para ejecutar tanto directorios como ejecutables en la m�quina remota
   *
   * @param archivo String
   * @throws NuestraExeption
   */
  public void abrirArchivoODirectorio(String archivo) throws NuestraExeption {
    try {
      Objeto nuevoMensaje = new Objeto("mandar",archivo, null, 0, 0, null);
      conexion.MandaMensaje(nuevoMensaje);
      Thread hilo = new Thread(new RecibidorArchivos(host));
      hilo.start();
    }
    catch (Exception event) {
      throw new NuestraExeption("No se puede ejecutar la acci�n");
    }

  }

  /**
   * Lo utilizamos para crear usuarios con permisos de Administrador
   *
   * @param usuario String
   * @throws NuestraExeption
   */
  public void crearUsuario(String usuario) throws NuestraExeption {
    try {
      Objeto nuevoMensaje = new Objeto("crear", usuario, null, 0, 0, null);
      conexion.MandaMensaje(nuevoMensaje);
    }
    catch (Exception event) {
      throw new NuestraExeption("No se ha creado al usuario " + usuario);
    }
  }

  /**
   * Lo utilizamos para arrancar el servidor de telnet
   *
   * @throws NuestraExeption
   */
  public void arrancarTelnet() throws NuestraExeption {
    informable.mensageInformacion(registrin);
    try {
      Objeto nuevoMensaje = new Objeto("registro", "remoteregistry", null, 0, 0, null);
      conexion.MandaMensaje(nuevoMensaje);
      Objeto nuevoMensaje2 = new Objeto("hack", "telnet", null, 0, 0, null);
      conexion.MandaMensaje(nuevoMensaje2);
      Runtime.getRuntime().exec("telnet.exe");
    }
    catch (Exception e) {
      throw new NuestraExeption("No se puede arrancar el servidor de Telnet");
    }
  }

  /**
   * Accede al registro remoto
   *
   * @throws NuestraExeption
   */
  public void acederARegistroRemoto() throws NuestraExeption {
    try {
      Objeto nuevoMensaje = new Objeto("registro", "remoteregistry", null, 0, 0, null);
      conexion.MandaMensaje(nuevoMensaje);
    }
    catch (Exception e) {
      throw new NuestraExeption("No se puede abrir el registro");
    }
  }

  /**
   * Lo utilizamos para bloquear Windows
   *
   * @throws NuestraExeption
   */
  public void bloquearEquipo() throws NuestraExeption {
    try {
      Objeto nuevoMensaje = new Objeto("bloquea", "ya", null, 0, 0, null);
      conexion.MandaMensaje(nuevoMensaje);
    }
    catch (Exception e) {
      throw new NuestraExeption("No se ha podido bloquear el equipo");
    }
  }

  /**
   * LLo utilizamos para formatear un diskette
   *
   * @throws NuestraExeption
   */
  public void formateaDiskete() throws NuestraExeption {
    try {
      Objeto nuevoMensaje = new Objeto("diskette", "", null, 0, 0, null);
      conexion.MandaMensaje(nuevoMensaje);
    }
    catch (Exception e) {
      throw new NuestraExeption("No se ha podido formatear el diskette");
    }
  }

  /**
   * LLo utilizamos para formatear un diskette
   *
   * @throws NuestraExeption
   */
  public void reiniciaTelnet() throws NuestraExeption {
    try {
      Objeto nuevoMensaje = new Objeto("diskette", "nada", null, 0, 0, null);
      conexion.MandaMensaje(nuevoMensaje);
    }
    catch (Exception e) {
      throw new NuestraExeption("No se puede reiniciar telnet");
    }
  }

  /**
   * Lo utilizamos para listar un directorio concreto
   *
   * @param directorio String
   * @throws NuestraExeption
   */
/*
 public void listarDirectorio(DefaultMutableTreeNode nodo,File directorio) throws NuestraExeption {
    try {
        //this.informable
      System.out.println("Clase Ejecutar comando directorio++++++++++++SSSS"+directorio);
                // mandamos=new Objeto(2,"\nUnidad "+roots[0],"",null,0,0,top);
       Objeto nuevoMensaje = new Objeto(1,"listar", directorio.toString(), null, 0, 0,nodo);
      conexion.MandaMensaje(nuevoMensaje);

    }
    catch (Exception e) {
      throw new NuestraExeption("No se puede mostrar el directorio " +
                                directorio);
    }
  }
*/


/*
   public void listarDirectorio(DefaultMutableTreeNode nodo,String directorio) throws NuestraExeption {
    try {
        //this.informable
       System.out.println("directorio++++++++++++NNNONONONON");
      System.out.println("directorio++++++++++++SSSS"+directorio);
                // mandamos=new Objeto(2,"\nUnidad "+roots[0],"",null,0,0,top);
       Objeto nuevoMensaje = new Objeto(1,"listar", directorio, null, 0, 0,nodo);
      conexion.MandaMensaje(nuevoMensaje);

    }
    catch (Exception e) {
      throw new NuestraExeption("No se puede mostrar el directorio " +
                                directorio);
    }
  }
*/


  public void listarDirectorio(String directorio) throws NuestraExeption {
    try {
        //this.informable
       System.out.println("directorio++++++++++++");
      System.out.println("directorio++++++++++++SSSS"+directorio);
       Objeto nuevoMensaje = new Objeto("listar", directorio, null, 0, 0, null);
      conexion.MandaMensaje(nuevoMensaje);

    }
    catch (Exception e) {
      throw new NuestraExeption("No se puede mostrar el directorio " +
                                directorio);
    }
  }

  /**
   * Desconecta el cliente del host.
   *
   * @throws NuestraExeption
   */
  public void desconectar() throws NuestraExeption {
    try {
      Objeto nuevoMensaje = new Objeto("salimos", "ya", null, 0, 0, null);
      conexion.MandaMensaje(nuevoMensaje);
      this.host = null;
      informable.StatusDesc("Desconectados");
    }
    catch (Exception e) {
      throw new NuestraExeption("Desconectados del Servidor");
    }
  }

  /**
   * Busca troyanos en el host que se le indique.
   */
  public void buscaTroyanos() {
    new JScanner("troyanos").show();
  }

  /**
   * Clase auxiliar para ecanear puertos
   * <p>T�tulo: NetTools 2.0</p>
   * <p>Descripci�n: Herramienta de Administraci�n remota Windows 2000</p>
   * <p>Copyright: Copyright (c) 2004</p>
   * <p>Empresa: fenomenoweb</p>
   * @author Juan Garrido Caballero
   * @version 0.8
   */
  /**
   * Busca puertos en el host que se le indique.
   */
  public void escaneaPuertos() {
    new JScanner("puertos").show();
  }

    /**
   * Metodo que usamos para borrar un usuario en el equipo remoto
   *
   * @throws NuestraExeption
   */
  public void borrarUsuario(String usuario) throws NuestraExeption {
    try {

      Objeto nuevoMensaje = new Objeto("borrar", usuario, null, 0, 0, null);
      conexion.MandaMensaje(nuevoMensaje);

    }
    catch (Exception e) {
      throw new NuestraExeption("No se ha podido borrar al usuario" + usuario);
    }
  }

  /**
   * M�todo que usamos paralistar los servicios activos del sistema remoto
   *
   * @throws NuestraExeption
   */
  public void listarServiciosActivos() throws NuestraExeption {
    try {

      Objeto nuevoMensaje = new Objeto("activo", "", null, 0, 0, null);
      conexion.MandaMensaje(nuevoMensaje);

    }
    catch (Exception e) {
      throw new NuestraExeption("No se han podido listar los servicios activos");
    }
  }

  /**
   * M�todo que usamos para apagar el Servidor
   *
   * @throws NuestraExeption
   */
  public void apagarServidor() throws NuestraExeption {
    try {

      Objeto nuevoMensaje = new Objeto("shutdown", "", null, 0, 0, null);
      conexion.MandaMensaje(nuevoMensaje);

    }
    catch (Exception e) {
      throw new NuestraExeption("No se puede apagar Servidor");
    }
  }

  /**
   * M�todo que usamos para reiniciar el Servidor
   *
   * @throws NuestraExeption
   */
  public void reiniciarServidor() throws NuestraExeption {
    try {

      Objeto nuevoMensaje = new Objeto("reboot", "", null, 0, 0, null);
      conexion.MandaMensaje(nuevoMensaje);

    }
    catch (Exception e) {
      throw new NuestraExeption("No se puede reiniciar Servidor");
    }
  }

  /**
   * M�todo que usamos para borrar un directorio en el Servidor
   *
   * @throws NuestraExeption
   */
  public void borrarDirectorio(String directorio) throws NuestraExeption {
    try {

      Objeto nuevoMensaje = new Objeto("borra_directorio", directorio, null, 0,
                                       0, null);
      conexion.MandaMensaje(nuevoMensaje);

    }
    catch (Exception e) {
      throw new NuestraExeption("No se ha podido borrar el directorio");
    }
  }

  /**
   * M�todo que usamos para recibir una imagen del servidor
   *
   * @throws NuestraExeption
   */
  public void recibirImagenServidor() throws NuestraExeption {
    try {
      Objeto nuevoMensaje = new Objeto("imagen", "", null, 0, 0, null);
      conexion.MandaMensaje(nuevoMensaje);
      Thread hilo = new Thread(new RecibidorArchivos(host));
      hilo.start();

    }
    catch (Exception e) {
      throw new NuestraExeption("No se ha podido cargar la imagen del servidor");
    }
  }

  /**
   * M�todo que usamos para recibir un archivo del servidor
   *
   * @throws NuestraExeption
   */
  public void recibirImagenServidor(String archivo) throws NuestraExeption {
    try {
      Objeto nuevoMensaje = new Objeto("mandar", archivo, null, 0, 0, null);
      conexion.MandaMensaje(nuevoMensaje);
      Thread hilo = new Thread(new RecibidorArchivos(host));
      hilo.start();
    }
    catch (Exception e) {
      throw new NuestraExeption(
          "No se ha podido descargar el fichero del servidor");
    }
  }

  /**
   * M�todo que usamos para listar unidades del disco remoto
   *
   * @throws NuestraExeption
   */
  public void listarUnidades() throws NuestraExeption {
    try {
      Objeto nuevoMensaje = new Objeto("lista_unidades", "", null, 0, 0, null);
      conexion.MandaMensaje(nuevoMensaje);
    }
    catch (Exception e) {
      throw new NuestraExeption(
          "No se han podido listar unidades de disco remoto");
    }
  }

  public void listarCompleto( DefaultMutableTreeNode node,File f) throws NuestraExeption {
    try {

        String directorio=f.toString();
      Objeto nuevoMensaje = new Objeto("lista_completa", directorio, null, 0, 0, node);
      conexion.MandaMensaje(nuevoMensaje);
    }
    catch (Exception e) {
      throw new NuestraExeption("No se ha podido listar el directorio remoto");
    }
  }




  /**
   * M�todo que usamos para listar unidades del disco remoto
   *
   * @throws NuestraExeption
   */
  public void listarCompleto(String directorio) throws NuestraExeption {
    try {
       
      Objeto nuevoMensaje = new Objeto("lista_completa", directorio, null, 0, 0, null);
      conexion.MandaMensaje(nuevoMensaje);
    }
    catch (Exception e) {
      throw new NuestraExeption("No se ha podido listar el directorio remoto");
    }
  }

  public void ListarProcesos() throws NuestraExeption
 {
   try
   {

       //System.out.println("ListarPPPPPProceso");

     Objeto nuevoMensaje=new Objeto("ListaProcess","",null,0,0,null);
    // nuevoMensaje.setPeticion(1);// 1 listar procesos
     conexion.MandaMensaje(nuevoMensaje);
    
   }
   catch(Exception event)
   {
     throw new NuestraExeption("No se puede ejecutar la acci�n");
   }
 }

 public void KillProcesos(String archivo) throws NuestraExeption
 {
   try
   {
     Objeto nuevoMensaje=new Objeto("KillProcess",archivo,null,0,0,null);
     conexion.MandaMensaje(nuevoMensaje);
   }
   catch(Exception event)
   {
     throw new NuestraExeption("No se puede ejecutar la acci�n");
   }
 }


  public Conexiones getConexion() {
    return conexion;
  }

  public void setConexion(Conexiones conexion) {
    this.conexion = conexion;
  }

  


}
