package net.javahispano.nettools.cliente;

/**
 * <p>Title: JScanner for NetTools </p>
 * <p>Description: Scanner de puertos </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: fenomenoweb </p>
 * @author Juan Garrido Caballero
 * @version 1.0
 */


import javax.swing.border.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;



public class JScanner extends JFrame
{

  JLabel etiquetaHost=new JLabel("Host");
  JLabel etiquetaInicio=new JLabel("Inicio");
  JLabel etiquetaFin=new JLabel("Fin");
  JTextField campoHost=new JTextField();
  JTextField campoInicio=new JTextField();
  JTextField campoFin=new JTextField();
  JPanel PanelTodo=new JPanel();
  JPanel PanelConfiguration=new JPanel();
  JPanel PanelBotones=new JPanel();
  JButton Inicio=new JButton("Inicio");
  JButton Final=new JButton("Detener");
  JTable tabla;
  JPanel PanelPuertos=new JPanel();
  JScrollPane scroll=new JScrollPane();
  JProgressBar progreso=new JProgressBar();
  int PideParar=1;
  JTextField campoResuelto=new JTextField();
  JLabel etiquetaResuelta=new JLabel("Host Resuelto");
  String response;


  public JScanner(String respuesta)
  {
    initComponents();
    this.response=respuesta;
  }
  /**
    * Inicializa Componentes
    *
    */

  public void initComponents()
  {
    setTitle(" JScanner by NetTools");
    Toolkit toolkit;
    setIconImage(Toolkit.getDefaultToolkit().createImage(net.javahispano.nettools.cliente.UI.FrameCliente.class.getResource(("iconos/scanner.gif"))));
    //Inicializamos Paneles
    getContentPane().setLayout(new GridBagLayout());
    PanelTodo.setLayout(new GridBagLayout());
    PanelBotones.setLayout(new GridBagLayout());
    PanelPuertos.setLayout(new GridBagLayout());
    PanelConfiguration.setLayout(new GridBagLayout());
    GridBagConstraints constraints1;  //Manejador Panel Configuraci�n
    GridBagConstraints BigPanel;      //Manejador Panel Principal
    GridBagConstraints PanelTodoCons; //Manejador Gran Panel
    GridBagConstraints BotoneraCons;  //Manejador Panel Botones
    GridBagConstraints PuertoCons;    //Manejador Panel Puertos
    TitledBorder borde=new TitledBorder("Configuraci�n");


    //Panel Configuraci�n + Campo Host
    constraints1=new GridBagConstraints();
    PanelConfiguration.setBorder(borde);
    constraints1.gridx=1;
    constraints1.gridy=0;
    constraints1.gridwidth=4;
    constraints1.fill=constraints1.HORIZONTAL;
    constraints1.insets=new java.awt.Insets(5,5,5,5);
    constraints1.weightx=1.0;
    PanelConfiguration.add(campoHost,constraints1);

    //Etiqueta Host

    constraints1=new GridBagConstraints();
    constraints1.gridx=0;
    constraints1.gridy=0;
    constraints1.fill=constraints1.HORIZONTAL;
    constraints1.insets=new java.awt.Insets(5,5,5,5);
    PanelConfiguration.add(etiquetaHost,constraints1);

    //Etiqueta Inicio

    constraints1=new GridBagConstraints();
    constraints1.gridx=0;
    constraints1.gridy=2;
    constraints1.fill=constraints1.HORIZONTAL;
    constraints1.insets=new java.awt.Insets(5,5,5,5);
    PanelConfiguration.add(etiquetaInicio,constraints1);

    //Campo Inicio

    constraints1=new GridBagConstraints();
    constraints1.gridx=1;
    constraints1.gridy=2;
    constraints1.fill=constraints1.HORIZONTAL;
    constraints1.weightx=1.0;
    constraints1.insets=new java.awt.Insets(5,5,5,5);
    PanelConfiguration.add(campoInicio,constraints1);

    //Etiqueta Fin

    constraints1=new GridBagConstraints();
    constraints1.gridx=2;
    constraints1.gridy=2;
    constraints1.fill=constraints1.HORIZONTAL;
    constraints1.insets=new java.awt.Insets(5,5,5,5);
    PanelConfiguration.add(etiquetaFin,constraints1);

    //Campo Fin

    constraints1=new GridBagConstraints();
    constraints1.gridx=3;
    constraints1.gridy=2;
    constraints1.fill=constraints1.HORIZONTAL;
    constraints1.weightx=1.0;
    constraints1.insets=new java.awt.Insets(5,5,5,5);
    PanelConfiguration.add(campoFin,constraints1);

    //Campo Resuelto

    constraints1=new GridBagConstraints();
    constraints1.gridx=0;
    constraints1.gridy=1;
    constraints1.fill=constraints1.HORIZONTAL;
    constraints1.insets=new java.awt.Insets(5,5,5,5);
    PanelConfiguration.add(etiquetaResuelta,constraints1);

    //Campo HostResuelto

    campoResuelto.setEditable(false);
    constraints1=new GridBagConstraints();
    constraints1.gridx=1;
    constraints1.gridy=1;
    constraints1.gridwidth=4;
    constraints1.fill=constraints1.HORIZONTAL;
    constraints1.insets=new java.awt.Insets(5,5,5,5);
    constraints1.weightx=1.0;
    PanelConfiguration.add(campoResuelto,constraints1);


    //Lo introducimos en el Panel

    PanelTodoCons=new GridBagConstraints();
    PanelTodoCons.fill=PanelTodoCons.BOTH;
    PanelTodoCons.insets=new java.awt.Insets(5,5,5,5);
    PanelTodoCons.weightx=1.0;
    PanelTodo.add(PanelConfiguration,PanelTodoCons);


    ////////        PANEL BOTONES       /////////

    //Bot�n Inicio

    BotoneraCons=new GridBagConstraints();
    BotoneraCons.gridx=0;
    BotoneraCons.gridy=0;
    BotoneraCons.fill=BotoneraCons.HORIZONTAL;
    BotoneraCons.insets=new java.awt.Insets(5,5,5,5);
    BotoneraCons.weightx=1.0;
    PanelBotones.add(Inicio,BotoneraCons);

    //Bot�n Parada

    BotoneraCons=new GridBagConstraints();
    BotoneraCons.gridx=0;
    BotoneraCons.gridy=1;
    BotoneraCons.fill=BotoneraCons.HORIZONTAL;
    BotoneraCons.insets=new java.awt.Insets(5,5,5,5);
    BotoneraCons.weightx=1.0;
    PanelBotones.add(Final,BotoneraCons);

    //Introducimos Panel Botones en el Panel

    PanelTodoCons=new GridBagConstraints();
    PanelTodoCons.gridx=1;
    PanelTodoCons.gridy=0;
    PanelTodoCons.fill=PanelTodoCons.BOTH;
    PanelTodoCons.insets=new java.awt.Insets(5,5,5,5);
    PanelTodoCons.weightx=0.0;
    PanelTodo.add(PanelBotones,PanelTodoCons);


    // ---------- PANEL CAPTURA DE PUERTOS ----------

    DefaultTableModel modelo=new DefaultTableModel();
    modelo.addColumn("Puerto");
    modelo.addColumn("Protocolo");
    modelo.addColumn("Estado");
    tabla=new JTable(modelo);
    TitledBorder bordePuerto=new TitledBorder("Puertos Disponibles");
    PanelPuertos.setBorder(bordePuerto);
    scroll.setViewportView(tabla);
    PuertoCons=new GridBagConstraints();
    PuertoCons.gridx=0;
    PuertoCons.gridy=0;
    PuertoCons.gridwidth=2;
    PuertoCons.fill=PuertoCons.BOTH;
    PuertoCons.insets=new java.awt.Insets(5,5,5,5);
    PuertoCons.weightx=1.0;
    PuertoCons.weighty=1.0;
    PanelPuertos.add(scroll,PuertoCons);


    // Barra de Progreso

    progreso.setStringPainted(true);
    PuertoCons=new GridBagConstraints();
    PuertoCons.gridx=1;
    PuertoCons.gridy=1;
    PuertoCons.fill=PuertoCons.BOTH;
    PuertoCons.insets=new java.awt.Insets(5,5,5,5);
    PuertoCons.weightx=0.5;
    PuertoCons.weighty=0;
    PanelPuertos.add(progreso,PuertoCons);

    // Introducimos Panel Puertos en el Panel Principal
    PanelTodoCons=new GridBagConstraints();
    PanelTodoCons.gridx=0;
    PanelTodoCons.gridy=1;
    PanelTodoCons.gridwidth=2;
    PanelTodoCons.fill=PanelTodoCons.BOTH;
    PanelTodoCons.insets=new java.awt.Insets(5,5,5,5);
    PanelTodoCons.weightx=1.0;
    PanelTodoCons.weighty=1.0;
    PanelTodo.add(PanelPuertos,PanelTodoCons);

    //Panel Principal

    BigPanel=new GridBagConstraints();
    BigPanel.fill=BigPanel.BOTH;
    BigPanel.weightx=1.0;
    BigPanel.weighty=1.0;
    getContentPane().add(PanelTodo,BigPanel);
    pack();
    Dimension dimension=new Dimension(600,600);
    this.setSize(dimension);


    // ------------  Implementamos los oyentes de los botones ------------

    Inicio.addActionListener(new ActionListener()
    {
    public void actionPerformed(ActionEvent e)
     {
      if(campoHost.getText().equals(""))
       {
            rellena();
       }
       else if(campoInicio.getText().equals(""))
       {
         rellena();
       }
       else if( campoFin.getText().equals(""))
       {
         rellena();
       }
       else
       {
          borracolumnas();
          PideParar=1;
          Inicio.setEnabled(false);
          campoInicio.setEditable(false);
          campoHost.setEditable(false);
          campoFin.setEditable(false);
          int inicio = Integer.parseInt(campoInicio.getText());
          int fin = Integer.parseInt(campoFin.getText());
          int start =inicio;
          progreso.setMinimum(inicio);
          progreso.setMaximum(fin);
          progreso.setValue(0);
          String host;
          InetAddress h=null;

         try
          {
            host=InetAddress.getByName(campoHost.getText()).getHostAddress();
            String resolve = InetAddress.getByName(campoHost.getText()).getCanonicalHostName();
            campoResuelto.setText(resolve);
            h=InetAddress.getByName(host);
            FabricaPuertos fabrica=new FabricaPuertos(h,inicio,fin);
                for (;start<=400;start++)
                {
                 FastThread t= new FastThread(fabrica);
                 t.start();
                }

          }
          catch(Exception event){
            JOptionPane.showConfirmDialog(null,"No se ha podido resolver el Host","Host",JOptionPane.CLOSED_OPTION,JOptionPane.ERROR_MESSAGE);
            Inicio.setEnabled(true);
            campoInicio.setEditable(true);
            campoHost.setEditable(true);
            campoFin.setEditable(true);

          };

       }

     }
    });

    Final.addActionListener(new ActionListener()
    {
    public void actionPerformed(ActionEvent e)
     {
      PideParar=0;
      Inicio.setEnabled(true);
      campoInicio.setEditable(true);
      campoHost.setEditable(true);
      campoFin.setEditable(true);
      Toolkit.getDefaultToolkit().beep();
     }
    });


  } //Fin initComponents();

//Se encarga de pasar al constructor el host y el siguiente puerto a escanear

class FabricaPuertos
{
  InetAddress _host=null;
  int PuertoInicio=-1;
  int PuertoFin=-1;
  int SiguientePuerto=-1;
  public FabricaPuertos(InetAddress host,int inicio,int fin)
      {
        this._host=host;
        this.SiguientePuerto=inicio++;
        this.PuertoFin=fin;

      }

      public boolean hasMoreElements()
      {
        return (SiguientePuerto<=PuertoFin);
      }

      public Object nextElement()
      {
        return new JPuertos(_host,SiguientePuerto++);

      }
}

    //Clase que gestiona los puertos para el escaneo

    class JPuertos
    {
      InetAddress _host=null;
      int puerto=-1;

      public JPuertos(InetAddress host, int port)
      {
        this._host=host;
        this.puerto=port;

      }

      void StartScanPorts()
      {

        try
        {
          Socket escucha=new Socket(_host,puerto);
          if(escucha.isConnected())
          {
            archivo_aceptarSuperScan(puerto);
            escucha.close();
          }

        }
        catch(Exception e)
        {

        }
      }
      void StartScanTrojans()
      {
        try
        {
          Socket escucha=new Socket(_host,puerto);
          if(escucha.isConnected())
          {
            archivo_troyano(puerto);
            escucha.close();
          }
        }
        catch(Exception event){};
      }
    }


    public void archivo_aceptarSuperScan(int sock) throws IOException
    {
        FileReader fichero = new FileReader("scanner/superscan.txt");
        FileReader fichero2 = new FileReader("scanner/puertos_scanner.txt");
        BufferedReader br = new BufferedReader(fichero);
        BufferedReader br2 = new BufferedReader(fichero2);
        String protocol;
        String puerto;
        String compara = String.valueOf(sock);
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        while ( (protocol = br.readLine()) != null && (puerto = br2.readLine()) != null) {
          if (puerto.compareTo(compara) == 0)
          {
            Object[] columna={puerto,protocol,"open"};
            modelo.addRow(columna);
            //tabla.sizeColumnsToFit(-1);
          }

        }
        fichero.close();
        fichero2.close();

      }

      public void archivo_troyano(int sock) throws IOException {

      FileReader fichero = new FileReader("scanner/trojans.txt");
      FileReader fichero2 = new FileReader("scanner/puertos_troyanos.txt");
      BufferedReader br = new BufferedReader(fichero);
      BufferedReader br2 = new BufferedReader(fichero2);
      String troyano;
      String puerto;
      String compara = String.valueOf(sock);
      String lista = "";
      DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
      while ( (troyano = br.readLine()) != null && (puerto = br2.readLine()) != null) {
        if (puerto.compareTo(compara) == 0)
        {
          Object[] columna={puerto,troyano,"open"};
          modelo.addRow(columna);
        }

      }
      fichero.close();
      fichero2.close();
    }


class FastThread extends Thread implements Runnable
{
  FabricaPuertos _puertos=null;

  public FastThread(FabricaPuertos puertos)
  {
    this._puertos=puertos;
  }
  public void run()
  {

    JPuertos ports = null;
    boolean parar = false;
    while (!parar && PideParar!=0) {
      ports = null;
      synchronized (_puertos) {
        progreso.setValue(_puertos.SiguientePuerto);
        if (!_puertos.hasMoreElements()) {
          parar = true;
          Inicio.setEnabled(true);
          campoInicio.setEditable(true);
          campoHost.setEditable(true);
          campoFin.setEditable(true);
          return;


        }
        ports = (JPuertos) _puertos.nextElement();

      }
      if(null!=ports)
      {
        if(response.compareTo("puertos")==0)
             ports.StartScanPorts();
             if(response.compareTo("troyanos")==0)
               ports.StartScanTrojans();
      }

    }
  }
}

 public void rellena()
    {
      JOptionPane.showConfirmDialog(null,"Faltan campos por rellenar","Host",JOptionPane.CLOSED_OPTION,JOptionPane.ERROR_MESSAGE);
    }



 /**
   * Subprograma que utilizamos para borrar columnas
   *
   */

 public void borracolumnas()
 {
   DefaultTableModel borrado=(DefaultTableModel) tabla.getModel();
   int columnas=tabla.getRowCount();
   for(int a=columnas;a>0;a--)
   {
     borrado.removeRow(a-1);
   }
 }

public static void main(String args[])
{
    try
      {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      }
      catch(Exception e){};



}



}
