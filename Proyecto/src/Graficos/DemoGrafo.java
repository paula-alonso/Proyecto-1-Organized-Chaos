/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package Graficos;


import javax.swing.JOptionPane;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.view.Viewer;
import proyecto.Camino;
import proyecto.Grafo;
import proyecto.Lista;
import proyecto.Nodo;
import proyecto.Ruta;
    
public class DemoGrafo {
    public static void mostrar(String almacenes, String rutas) {
        
        Graph graph = new SingleGraph("Gráfico");
        graph.setStrict(false);
        graph.setAutoCreate(true);      
        
        
        System.setProperty("org.graphstream.ui.renderer",
                "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
       
        
        
     
        
        if (!almacenes.equalsIgnoreCase("")) {
            
        String[] alm_split = almacenes.split("\n");
        
        
        for (int i=0; i<alm_split.length ;i++) {
            String nombre_almacen  = alm_split[i];
            graph.addNode(nombre_almacen);
        }
 
        String stylesheet = "node{" 
                + "text-mode: normal; text-alignment: center; text-size: 25;"
                + "size: 40px; fill-mode: plain; fill-color: purple;} "
                + ""
                + "edge {" 
                + "text-size: 15;"
                + "text-background-mode: plain;"
                + "text-background-color: white;" 
                + "arrow-shape: arrow; arrow-size: 5;"
                + "fill-mode: dyn-plain; }";
        
        for (Node node : graph) {
        node.setAttribute("ui.label", node.getId());
        }
        
        

        if (!rutas.equalsIgnoreCase("")) {
            
        String[] rutas_split = rutas.split("\n"); 
        
        for (int i=0; i<rutas_split.length ;i++) {
            String ruta  = rutas_split[i];
            String[] partes = ruta.split(",");
            String origen = partes[0];
            String destino = partes[1];
            String distancia = partes[2];
            graph.addEdge(origen+destino, origen, destino, true).setAttribute("ui.label", distancia);
           
        }   
        
        }
        
        graph.setAttribute("ui.stylesheet", stylesheet);
        
        Viewer view = graph.display();
        view.setCloseFramePolicy(Viewer.CloseFramePolicy.CLOSE_VIEWER);
        view.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY); } else {
        JOptionPane.showMessageDialog(null,"No hay almacenes para mostrar");
        }
    }
    
}

  
