package net.javahispano.nettols.comunicaciones;

/**
 * <p>Título: NetTools </p>
 * <p>Descripción: Administraci�n Remota Windows 2000</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Empresa: fenomenoweb </p>
 * @Programado por Juan Garrido Caballero y Adolfo Sanz Palomanes
 * @version 2.0
 * Web: http://nettools20.cjb.net
 */


import java.io.*;
import javax.swing.*;
import javax.swing.tree.*;

public class Objeto implements Serializable
{
  public int peticion;
  public String orden,orden2;
  public ImageIcon imagen;
  public int alto;
  public int ancho;
  public DefaultMutableTreeNode root;


  public Objeto(String orden,String orden2,ImageIcon imagen,int ancho,int alto,DefaultMutableTreeNode root)
  {
   // this.peticion=peticion;
    this.orden=orden;
    this.orden2=orden2;
    this.imagen=imagen;
    this.alto=alto;
    this.ancho=ancho;
    this.root=root;
  }






    public Objeto(int peticion,String orden,String orden2,ImageIcon imagen,int ancho,int alto,DefaultMutableTreeNode root)
  {
    this.peticion=peticion;
    this.orden=orden;
    this.orden2=orden2;
    this.imagen=imagen;
    this.alto=alto;
    this.ancho=ancho;
    this.root=root;
  }






    /**
     * @return the peticion
     */
   /* public int getPeticion() {
        return peticion;
    }*/

    /**
     * @param peticion the peticion to set
     */
   /* public void setPeticion(int peticion) {
        this.peticion = peticion;
    }*/

}
