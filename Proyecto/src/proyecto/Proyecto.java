/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto;

import java.io.File;

/**
 *
 * @author alonso
 */
public class Proyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    File fichero = Funciones.FileChooser();
    Grafo grafo = Funciones.LeerTxt(fichero);
    Funciones.ActualizarRepositorio(grafo, fichero);
    }
    
    
}
