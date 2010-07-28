/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.javahispano.nettools.cliente;
import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;

/**
 *
 * @author Usuario
 */
public class Tree extends JFrame {
    public static void main(String[] args) {
    new Tree();
  }
   public Tree(){}
    public Tree(String pantalla) {
    super("Contrenido del directorio");
    // WindowUtilities.setNativeLookAndFeel();
   // addWindowListener(new ExitListener());
     Container content = getContentPane();
    int inicio = 0,fin=0,cont=0;
    String separador = ">#";
    String aux=null;
    int campos=NumeroDeSubdirectorios(pantalla,separador);
    Object[] hierarchy=new Object[campos];
    while(inicio<pantalla.length()){
    fin=pantalla.indexOf(separador,inicio);
    aux=pantalla.substring(inicio, fin);
    hierarchy[cont]=(aux);
    //System.out.println(aux+"aux");
   // System.out.println(inicio +"inicio" + fin +"fin");
        inicio=fin+2;
        cont++;
    }


   DefaultMutableTreeNode root = processHierarchy(hierarchy);
    JTree tree = new JTree(root);
    content.add(new JScrollPane(tree), BorderLayout.CENTER);
    setSize(275, 300);
    setVisible(true);

    }

 private DefaultMutableTreeNode processHierarchy(Object[] hierarchy) {
    DefaultMutableTreeNode node =
      new DefaultMutableTreeNode(hierarchy[0]);
    DefaultMutableTreeNode child;
    for(int i=1; i<hierarchy.length; i++) {
      Object nodeSpecifier = hierarchy[i];
      if (nodeSpecifier instanceof Object[])  // Ie node with children
        child = processHierarchy((Object[])nodeSpecifier);
      else
        child = new DefaultMutableTreeNode(nodeSpecifier); // Ie Leaf
      node.add(child);
    }
    return(node);
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

}
