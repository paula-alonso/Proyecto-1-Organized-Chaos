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
    
    static File fichero = Funciones.FileChooser();
    static Grafo grafo = Funciones.LeerTxt(fichero);
    
    
    public void main(){
        // TODO code application logic here

    Funciones.ActualizarRepositorio(grafo, fichero); 
 
    }
    
    public static Grafo getGrafo() {
    return grafo;
    }

      
    
}
