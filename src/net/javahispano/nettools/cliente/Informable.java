package net.javahispano.nettools.cliente;


import net.javahispano.nettols.comunicaciones.Objeto;

/**
 * <p>Tìtulo: NetTools 2.0</p>
 * <p>Descripción: Herramienta de Administración remota Windows 2000</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Empresa: fenomenoweb</p>
 * @author Juan Garrido Caballero, Abraham Otero y Adolfo Sanz
 * @version 0.8
 */

public interface Informable {


public void mensageListarProcesos (String ListaDirectorios);
/**Actualizara la lista de mensajes*/
public void mensageActualizarListarProcesos (String ListaDirectorios);


 /**
   * Envia imagen del pc
   * @param texto String
   */
     public void mensageVideo(String NombreCaptura);





 /**
   * Envia un modelo datos jerárquicos para presentar al usuario
   * @param texto String
   */
     public void mensageServicios(String ServiciosActivos);


      /**
   * Envia Información del equipo servidor y estadistica
   * @param texto String
   */
     public void mensageInformacionEquipo(String informacionEquipo);




     /**
   * Envia un modelo datos jerárquicos para presentar al usuario
   * @param texto String
   */
  public void clearShell2();


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
   * Envia un entero entre 0 y 100 informando del progreso de una acción.
   * @param progreso int
   */
  public void informaSobreElProgreso(int progreso);

  /**
   * Metodo que informa si se ha de desconectar o no del servidor.
   * @return boolean
   */

  public boolean isConnected();

  /**
    * Devuelve la dirección del servidor en caso de conexión correcta.
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
