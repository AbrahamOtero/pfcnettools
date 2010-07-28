package net.javahispano.nettools.cliente;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * <p>T�tulo: NetTools 2.0</p>
 * <p>Descripci�n: Herramienta de Administraci�n remota Windows 2000</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Empresa: fenomenoweb</p>
 * @author Juan Garrido Caballero y Abraham Otero
 * @version 0.8
 */

public interface Informable {


public void mensageListarProcesos (String ListaDirectorios);



    /**
   * Envia un modelo datos jerárquicos para presentar al usuario
   * @param texto String
   */
     public void mensageReconstruirArbol(String SubdirectoriosArbol);




    /**
   * Envia un modelo datos jerárquicos para presentar al usuario
   * @param texto String
   */
     public void mensageInformacionArbol(String datosArbol);


  /**
   * Envia un texto informando informativonpara presentar al usuario
   * @param texto String
   */
  public void mensageInformacion(String texto);
  /**
   * Envia un mensage de error.
   * @param texto String
   */
  public void mensageError(String texto);
  /**
   * Envia un entero entre 0 y 100 informando del progreso de una acci�n.
   * @param progreso int
   */
  public void informaSobreElProgreso(int progreso);

  /**
   * M�todo que informa si se ha de desconectar o no del servidor.
   * @return boolean
   */

  public boolean isConnected();

  /**
    * Devuelve la direcci�n del servidor en caso de conexi�n correcta.
    * @return boolean
    */

  public void StatusConex(String status);

  /**
     * Informa si nos hemos desconectado.
     * @return boolean
     */

  public void StatusDesc(String desc);


  public Objeto recibeMensaje();
}
