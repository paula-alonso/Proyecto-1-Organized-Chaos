/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import Graficos.DemoGrafo;
import Ventanas.Menu;
import static Ventanas.RealizarPedido.AlmacenesBox;
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
            
            grafo.setListaRutas(lista_rutas);
          
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
            try{
                PrintWriter pw = new PrintWriter(path);
                pw.print(amazontxt);
                pw.close();
                JOptionPane.showMessageDialog(null, "Guardado exitoso");

            }catch(Exception err){
                JOptionPane.showMessageDialog(null, err);
            }
                } else {JOptionPane.showMessageDialog(null, "No hay datos para guardar");}
            }

          }
       

      public static void AsignarAlmacenes(String[] array_almacenes, JComboBox combo_box) {
      
          
            for (int i=0; i<array_almacenes.length; i++) {
            combo_box.addItem(array_almacenes[i]); //Se asigna cada almacen a un item del combo box
                
            }
      }

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
            
            visitado = visitado + almacen.getNombre() + ","; //String que almacena los almacenes visitados
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
                   visitado = visitado + adyacencias[i] + ","; //agrega el almacen visitado a un string
                   }
                }
                
            }
            }
            
            String stock = lista_recorrido.print();
            

        return stock;
    }   
      
      public static Camino Dijkstra (Grafo g, Nodo<Almacen> origen, Nodo<Almacen> destino){
        //          //Usaremos un vector para guardar las distancias del nodo salida al resto
        int[] distancia = new int[g.getNumAlmacenes()];
      
        //  booleano visto[n] 
        boolean[] visto = new boolean[g.getNumAlmacenes()];
        //  //vector de boleanos para controlar los vértices de los que ya tenemos la distancia mínima
          //  //Inicializamos el vector con distancias iniciales
          // Si un vector u es adyacente al origen se asigna el peso, si no se asigna infinito
        Lista<Almacen> listaAlmacenes = g.getListaAlm();
        Nodo<Almacen> nodo = (Nodo<Almacen>)listaAlmacenes.getFirst();
        Nodo<Ruta> rutaO = (Nodo<Ruta>) origen.getData().getAdyacencia().getFirst();        
        for (int i = 0; i<origen.getData().getAdyacencia().getSize(); i++){
            distancia[g.BuscarAlmacen(rutaO.getData().getDestino_etiqueta()).getData().getNumvertice()] = rutaO.getData().getPeso();
            g.BuscarAlmacen(rutaO.getData().getDestino_etiqueta()).getData().setPrev(origen.getData());
            rutaO = rutaO.getpNext();
        }
        for(int i = 0; i<distancia.length; i++){
            if(distancia[i] == 0){
                distancia[i] = Integer.MAX_VALUE;
            }
        }
        // el primer nodo se marca como visitado porque es el origen
        distancia[origen.getData().getNumvertice()] = 0;
        visto[origen.getData().getNumvertice()] = true;
        
        boolean x = VistosTodos(visto); // Si todos los nodos fueron visitados retorna true, sino false
        while(!x){
            int vertice = minimoValor(distancia, visto);//busca el valor minimo en la lista de distancias
            visto[vertice] = true;
            Lista<Ruta> rutasdeV = g.BuscarAlmacenNum(vertice).getAdyacencia();
            Nodo<Ruta> rutaV = (Nodo<Ruta>) rutasdeV.getFirst();
            for (int i = 0; i<rutasdeV.getSize(); i++){
                int verticeDest = g.BuscarAlmacen(rutaV.getData().getDestino_etiqueta()).getData().getNumvertice();
                if(distancia[verticeDest]>distancia[vertice]+rutaV.getData().getPeso()){
                    distancia[verticeDest] = distancia[vertice]+rutaV.getData().getPeso();
                    Menu.grafo.BuscarAlmacenNum(verticeDest).setPrev(Menu.grafo.BuscarAlmacenNum(vertice));
                }rutaV = rutaV.getpNext();
            }x = VistosTodos(visto);
        }int NumAlmD = destino.getData().getNumvertice();
        Lista recorrido = new Lista();
        Almacen aux = destino.getData();
        while(aux!=null){
            recorrido.InsertInFinal(aux); 
            aux = aux.getPrev();
        }
        Camino camino = new Camino(distancia[NumAlmD],recorrido);
        return camino;

      }
      
      public static int minimoValor(int [] distancia, boolean [] visto){
          int minVal = Integer.MAX_VALUE;
          int Vertice = -1;
          for (int i = 0; i<distancia.length; i++){
              if (visto[i] == false && distancia[i]<minVal){
                  minVal = distancia[i];
                  Vertice = i;
              }
              
          }
          return Vertice;
      }
      
      public static boolean VistosTodos(boolean[] visto){
          boolean vistos = true;
          for(int i = 0; i<visto.length; i++){
              if (visto[i] == false){
                  return false;
              }
          }return vistos;
      }
      
                 public static void RutaCercana(String[] pedido, int i, int cantidad) {
         
                    Nodo<Almacen> seleccion = Menu.grafo.BuscarAlmacen((String) AlmacenesBox.getSelectedItem());
                    Camino camino = null;
                    Producto producto = null;
                    Nodo<Almacen>  temp = Menu.grafo.getListaAlm().getFirst();
                    for (int j=0;j<Menu.grafo.getListaAlm().getSize();j++) {
                        producto = Funciones.BuscarProducto(temp.getData().getProductos(), pedido[i]);
                        if (producto!= null && !seleccion.getData().equals(temp.getData())) {
                        Camino caminoAux = Funciones.Dijkstra(Menu.grafo, temp, seleccion);
                            if ((camino==null || caminoAux.getDistancia() < camino.getDistancia()) && producto.getCantidad()!=0){
                                camino = caminoAux;
                            }
                        }
                        temp = temp.getpNext();
                    }
                        if (camino!=null) {
                        JOptionPane.showMessageDialog(null, "El almacen seleccionado no cuenta con suficiente stock del producto solicitado.\nSe buscó en el almacén  más cercano:\n"+camino.MostrarCamino());
                        
                        
                        String almacenes = camino.getAlmacenes().nombresAlmacenes();
                        String[] alm_split = almacenes.split("\n");
                        
                        Lista<Ruta> lista_rutas = new Lista<Ruta>();
        
                        for (int k=0;k<alm_split.length-1;k++) {
                        Ruta ruta = Menu.grafo.getListaRutas().BuscarRuta(alm_split[k+1], alm_split[k]);
                        lista_rutas.InsertInFinal(ruta);
                        }

                        String rutas = lista_rutas.printRutas();
                        
                        DemoGrafo.mostrar(almacenes, rutas);
                        
                        Almacen almacen_destino =(Almacen) camino.getAlmacenes().getLast().getData();
                        producto = Funciones.BuscarProducto(almacen_destino.getProductos(), pedido[i]);
                        
                        producto.setCantidad(producto.getCantidad()-cantidad);
                            if (producto.getCantidad()<0){
                                JOptionPane.showMessageDialog(null, "No hay suficiente stock del producto solicitado en el almacén más cercano. Faltante: " + String.valueOf(0-producto.getCantidad()));
                                producto.setCantidad(0);
                            }
                            
                            
                        } else {
                        JOptionPane.showMessageDialog(null, "No hay suficiente stock del producto solicitado");
                        }
     }
        
    }
        

        
        