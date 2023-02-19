/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import java.awt.Component;
import static java.awt.image.ImageObserver.HEIGHT;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
         System.out.print(LeerTxt(archivo).getLista_almacenes().print());
         System.out.print(LeerTxt(archivo).getLista_rutas().printRutas());
        
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

      public static ArrayListas LeerTxt(File archivo){

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

                    int i = 0;
                    while ( i<datos.length-1){
                        if (datos[i].equalsIgnoreCase("rutas;")) {break;}
                        
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
                        
                    
                
                    
                    while (datos[i].equalsIgnoreCase("rutas;")){
                        i++;
                        while(!datos[i].equalsIgnoreCase("rutas;") && i<datos.length-1){
                            String[] atrib = datos[i].split(",");
                            Ruta ruta = new Ruta(0,Integer.parseInt(atrib[2]));
                            ruta.setOrigen_etiqueta(atrib[0]);
                            ruta.setDestino_etiqueta(atrib[1]);
                            lista_rutas.InsertInFinal(ruta);
                            i++;
                            }

                            }
                    }
        
                br.close();
                JOptionPane.showMessageDialog(null, "Lectura exitosa");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);}
        
        
            Grafo grafo = new Grafo(lista_almacenes.getSize());
            Lista<Almacen> almacenes = new Lista<>();
            
            grafo.guardarAlmacenes(lista_almacenes, almacenes);
            grafo.setEsDirigido(true);
            grafo.guardarRutas(lista_rutas);
          
            ArrayListas arr_list = new ArrayListas(lista_almacenes, lista_rutas);
        
            return arr_list;
   
      
      }
       
      
      
      
        
        
    }
        

        
        