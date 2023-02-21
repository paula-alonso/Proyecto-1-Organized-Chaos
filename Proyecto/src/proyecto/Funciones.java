/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import Ventanas.SeleccionProductos;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author marie
 */
public class Funciones {
    
    
   private static Component areaTexto;

   public static File FileChooser() {
       
    File fichero = null;
       
    JFileChooser fileChooser = new JFileChooser();
    int seleccion = fileChooser.showSaveDialog(areaTexto);
    if (seleccion == JFileChooser.APPROVE_OPTION)
    {
   fichero = fileChooser.getSelectedFile();}
    
    return fichero;
   
   }
   
   public static void LeerFichero(File archivo) {
       
      if (archivo == null) {JOptionPane.showMessageDialog(null, "No ha seleccionado ningún archivo");} 
   
      else {
      
      FileReader fr = null;
      BufferedReader br = null;

      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero/////////////////////////////////////////////////////////////////////

      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
      }
   }

      public static Grafo LeerTxt(File archivo){

        Lista<Almacen> lista_almacenes = new Lista<>();
        Lista<Ruta> lista_rutas = new Lista<>();
        
          
        String line;
        String almacenestxt = "";
        //String path = "test\\amazon.txt";
        File file = archivo;
        try{
            if (!file.exists()){
                file.createNewFile();
            }else{
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while((line = br.readLine()) != null){
                    if (!line.isEmpty()){
                        almacenestxt += line + "\n";
                    }
                }
                if(!"".equals(almacenestxt)){
                
                String nombre_almacen = "";
                String[] datos = almacenestxt.split("\n");
                
                
                //En este bucle se buscan los almacenes registradss en el archivo seleccionado

                    int i = 0;
                    while ( i<datos.length-1){
                        if (datos[i].equalsIgnoreCase("rutas;")) {break;} //Se rompe el bucle al llegar a las rutas
                        
                            if(datos[i].contains(":")){
                                nombre_almacen = datos[i].replace(":", "");
                                nombre_almacen = String.valueOf(nombre_almacen.charAt(8));
                            }else if (!datos[i].equalsIgnoreCase("almacenes;")) {
                                Lista<Producto> lista_productos = new Lista<Producto>();
                                while(!datos[i].contains(":") && i<datos.length-1 && !datos[i].equalsIgnoreCase("rutas;")){
                                    String[] atrib = datos[i].split(",");
                                    if (atrib[1].contains(";")) {atrib[1]=atrib[1].replace(";", "");}
                                    Producto producto = new Producto(atrib[0],Integer.parseInt(atrib[1]));
                                    lista_productos.InsertInFinal(producto);
                                    i++;    
                                }
                                Almacen almacen = new Almacen(nombre_almacen);
                                almacen.setProductos(lista_productos);
                                lista_almacenes.InsertInFinal(almacen);
                                i--;
                            }i++;

                            
                        
                    }
                        
                    
                //En este bucle se buscan las rutas registradas en el archivo seleccionado
                    
                    while (datos[i].equalsIgnoreCase("rutas;")){
                        i++;
                            while(i<datos.length){
                                String[] atrib = datos[i].split(",");
                                Ruta ruta = new Ruta(atrib[0],atrib[1],Integer.parseInt(atrib[2]));
                                ruta.setOrigen_etiqueta(atrib[0]);
                                ruta.setDestino_etiqueta(atrib[1]);
                                lista_rutas.InsertInFinal(ruta);
                                i++;
                            }
                            if (i == datos.length) {break;}
                        

                            }
                    }
        
                br.close();
                JOptionPane.showMessageDialog(null, "Lectura exitosa");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);}
        
        
            Grafo grafo = new Grafo();
            grafo.guardarAlmacenes(lista_almacenes);
            grafo.setEsDirigido(true);
            grafo.guardarRutas(lista_rutas);
          
            // Eliminar arrayListas despues
            ArrayListas arr_list = new ArrayListas(lista_almacenes, lista_rutas);
        
            return grafo;
   
      
      }
      
        public static void ActualizarRepositorio(Grafo grafo, File fichero){

            if (fichero == null) {JOptionPane.showMessageDialog(null, "No ha seleccionado ningún archivo");} 
            
            else {
            

            String path = fichero.getAbsolutePath();
            String infoAlm = "";
            String infoRut = "";
            String amazontxt = "";
            if (!grafo.isEmpty()){
                
                // En esta primera parte del algoritmo se obtiene la informacion de los almacenes
                Lista<Almacen> listaDeAlmacenes = grafo.getListaAlm();
                Nodo<Almacen> almacen = listaDeAlmacenes.getFirst();
                infoAlm += "Almacenes;\n";
                infoRut += "Rutas;\n";
                for (int i = 0; i<listaDeAlmacenes.getSize(); i++){
                    
//                    Formato de almacen:
//                    Almacen A:
//                    Pantalla,3
//                    RAM,2
//                    Procesador,1;

                    infoAlm += "Almacen "+almacen.getData().getNombre()+":\n";
                    Lista<Producto> productos = almacen.getData().getProductos();
                    Nodo<Producto> producto = productos.getFirst();
                    for (int j = 0; j<productos.getSize();j++){
                        if(producto.getpNext() == null){
                           infoAlm += producto.getData().getNombre()+","+producto.getData().getCantidad()+";\n"; 
                        }else{
                            infoAlm += producto.getData().getNombre()+","+producto.getData().getCantidad()+"\n";
                            
                        }producto = producto.getpNext();
                    }
                    
                    //Se recorren las listas de adyacencia para obtener las rutas
                    
                    Lista<Ruta> rutas = almacen.getData().getAdyacencia();
                    Nodo<Ruta> ruta = rutas.getFirst();
                    for (int a = 0; a<rutas.getSize(); a++){
                        
                        // A,B,10 Formato de ruta 
                        
                        infoRut+= ruta.getData().getOrigen_etiqueta()+","+ruta.getData().getDestino_etiqueta()+","+ruta.getData().getPeso()+"\n";
                        ruta = ruta.getpNext();
                    }
                    almacen = almacen.getpNext();
                }
                amazontxt = infoAlm + infoRut;
            }try{
                PrintWriter pw = new PrintWriter(path);
                pw.print(amazontxt);
                pw.close();
                JOptionPane.showMessageDialog(null, "Guardado exitoso");

            }catch(Exception err){
                JOptionPane.showMessageDialog(null, err);
            }

            
            }

          }
       
<<<<<<< HEAD
      public static void AsignarAlmacenes(String[] array_almacenes, JComboBox combo_box) {
      
          
            for (int i=0; i<array_almacenes.length; i++) {
            combo_box.addItem(array_almacenes[i]); //Se asigna cada almacen a un item del combo box
                
            }
=======

    public static boolean ValidarNumero(String text) {
        try{
              int num = Integer.parseInt(text);
              return true;
          }catch(Exception e){
              JOptionPane.showMessageDialog(null, "Introduzca una cifra válida");
          }return false;
    }
    
    public static Producto BuscarProducto(Lista<Producto> lista, String nombre){
            Nodo<Producto> producto = (Nodo<Producto>) lista.getFirst();
                
                //Busca el nodo que contiene el producto en la lista productos del almacen y le suma la cantidad agregada
                
                while(producto != null){
                    if (producto.getData().getNombre().equalsIgnoreCase(nombre)){
                        return producto.getData();
                    }
                    producto = producto.getpNext();
                }
                return null;
    }
>>>>>>> 2ba8210e93c905ce7e03a8121e4da3ab589b05cf
      
      }
      
      public static String RecorridoAncho(Grafo grafo){
       
          
        String visitado = "";
        Cola<Almacen> cola = new Cola();
        Lista<Almacen> lista_recorrido = new Lista<>();
        
        
            Lista<Almacen> lista_almacenes = grafo.getListaAlm();
            
            if (!lista_almacenes.isEmpty()){
            Almacen almacen = (Almacen) lista_almacenes.getFirst().getData();
            
            visitado = visitado + almacen.getNombre(); //String que almacena los almacenes visitados
            cola.Encolar(almacen);
            lista_recorrido.InsertInFinal(almacen);
            
            while (!cola.isEmpty()) {
                
                almacen = (Almacen) cola.getFirst().getData();
                String[] adyacencias = almacen.getAdyacencia().separarAdyacencias(); //arroja las adyacencias en un array
                
                for (int i = 0; i<adyacencias.length;i++){
                   if (!visitado.contains(adyacencias[i])){ //verifica que el almacen  adyacente no haya sido visitado
                   Almacen aux = grafo.BuscarAlmacen(adyacencias[i]).getData();
                   cola.Encolar(aux); //encola los almacenes adyacentes
                   visitado = visitado + adyacencias[i]; //agrega el almacen visitado a un string
                   
                   lista_recorrido.InsertInFinal(aux);
                   
                   }
                }
                cola.Desencolar();
            }
            }
            
            String stock = lista_recorrido.print();
            

        return stock;
    }
      

      public static String RecorridoProfundidad(Grafo grafo){
       
          
        String visitado = "";
        Pila<Almacen> pila = new Pila();
        Lista<Almacen> lista_recorrido = new Lista<>();
        
        
            Lista<Almacen> lista_almacenes = grafo.getListaAlm();
            
            if (!lista_almacenes.isEmpty()){
            Almacen almacen = (Almacen) lista_almacenes.getFirst().getData();
            
            visitado = visitado + almacen.getNombre(); //String que almacena los almacenes visitados
            pila.Apilar(almacen);
            
            
            while (!pila.isEmpty()) {
                
                almacen = (Almacen) pila.getFirst().getData();
                lista_recorrido.InsertInFinal(almacen);
                pila.Desapilar();
                String[] adyacencias = almacen.getAdyacencia().separarAdyacencias(); //arroja las adyacencias en un array
                
                for (int i = 0; i<adyacencias.length;i++){
                   if (!visitado.contains(adyacencias[i])){ //verifica que el almacen  adyacente no haya sido visitado
                   Almacen aux = grafo.BuscarAlmacen(adyacencias[i]).getData();
                   pila.Apilar(aux); //apila los almacenes adyacentes
                   visitado = visitado + adyacencias[i]; //agrega el almacen visitado a un string
                   }
                }
                
            }
            }
            
            String stock = lista_recorrido.print();
            

        return stock;
    }      
        
        
    }
        

        
        