/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import javax.swing.JOptionPane;

/**
 * Esta clase contiene los atributos y metodos de un Grafo
 * @author Paula Alonso y Marielena Ginez
 */
public class Grafo {
    private boolean EsDirigido;
    private int NumAlmacenes;
    private Lista<Almacen> listaAlm;
    private Lista<Ruta> listaRutas;

    
     /**
     * Metodo constructor por defecto
     */
    public Grafo() {
        this.EsDirigido = EsDirigido;
        this.NumAlmacenes = 0;
        this.listaAlm = new Lista<Almacen>();
        this.listaRutas = new Lista<Ruta>();
    }
    
     /**
     * @return the NumAlmacenes == 0 Boolean que verifica si el almacen esta vacio
     */
    public boolean isEmpty(){
        return NumAlmacenes == 0;
    }
    
     /**
     * Metodo Busca el almacen por el nombre, si no lo encuentra o la lista de almacenes está vacia, retorna null
     * @param nombre Nombre del almacen buscado
     * @return almacen
     */
    public Nodo<Almacen> BuscarAlmacen(String nombre){
        if(!listaAlm.isEmpty()){
            Nodo<Almacen> almacen = (Nodo<Almacen>) getListaAlm().getFirst();
            for(int i = 0; i<getListaAlm().getSize(); i++){
                if(almacen.getData().getNombre().equalsIgnoreCase(nombre)){
                    return almacen;
                }almacen = almacen.getpNext();
            }return null;
        }return null;
    }
    
     /**
     * Metodo Busca y devuelve el número de vértice, si no lo encuentra regresa -1
     * @param nombre Nombre del vertice buscado
     * @return num Devuelve el numero del vertice
     */
    public int numAlmacen(String nombre) {
        Almacen v = new Almacen(nombre);
        Nodo<Almacen> encontrado = BuscarAlmacen(nombre);
        if(encontrado != null){
            int num = encontrado.getData().getNumvertice();
            return num;
        }else{
            return -1;
        }
    }
    
     /**
     * Metodo Crea un nuevo almacen
     * @param almacen Almacen creado
     */
    public void nuevoAlmacen (Almacen almacen) {
        String nombre = almacen.getNombre();
        boolean existe = false; 
        if(BuscarAlmacen(nombre)!= null){
            existe = true;
        }
        if (!existe){
            almacen.asigVert(NumAlmacenes);
            listaAlm.InsertInFinal(almacen);
            NumAlmacenes++;
        }
    } 
    
     /**
     * Metodo Retorna si un vertice es adyacente
     * @param a Nombre vertice 1
     * @param b Nombre vertice 2
     * @return boolean
     */
    public boolean adyacente(String a, String b){
        int v1, v2;
        v1 = numAlmacen(a);
        v2 = numAlmacen(b);
        if(v1 < 0 || v2 < 0) {
            JOptionPane.showMessageDialog(null,"El vértice no existe");
        }
        Nodo<Almacen> almacen = BuscarAlmacen(a);
        Lista<Ruta> rutas = almacen.getData().getAdyacencia();
        Nodo<Ruta> ruta = (Nodo<Ruta>) rutas.getFirst();
        for(int i = 0; i<rutas.getSize(); i++){
            if (ruta.getData().getDestino_etiqueta().equalsIgnoreCase(b)){
                return true;
            }ruta = ruta.getpNext();
        }
            return false;
        }
    
     /**
     * Metodo para agregar una ruta al grafo
     * @param ruta Ruta a agregar
     */
    
    public void AgregarRuta(Ruta ruta){
        String a = ruta.getOrigen_etiqueta();
        String b = ruta.getDestino_etiqueta();
            if(!adyacente(a, b)){
            int v1 = numAlmacen(a);
            int v2 = numAlmacen(b);
            if(v1 < 0 || v2 < 0) {
                JOptionPane.showMessageDialog(null,"El vértice no existe");
            }else{
            Nodo<Almacen> almacen = BuscarAlmacen(a);
            almacen.getData().getAdyacencia().InsertInFinal(ruta);
            }  
        }
    }
    
    /**
     * Metodo para guardar almacenes en la lista de almacenes del grafo
     * @param lista Lista de almacenes
     */
    
    public void guardarAlmacenes(Lista<Almacen> lista){
        if(lista.isEmpty()){
            JOptionPane.showMessageDialog(null,"No hay almacenes guardados");
            }else{
            Nodo<Almacen> temp = (Nodo<Almacen>) lista.getFirst();
            while(temp != null){
            nuevoAlmacen(temp.getData());
            temp = temp.getpNext();}
        }
    } 


     /**
     * Metodo para guardar rutas en la lista de rutas
     * @param lista Lista de rutas en el grafo
     */    

        public void guardarRutas(Lista<Ruta> lista){
        Nodo<Ruta> temp = lista.getFirst();
        if(lista.isEmpty()){
            JOptionPane.showMessageDialog(null,"No se introdujo ninguna ruta");
            }
            while(temp != null){
            Ruta ruta = temp.getData();
            AgregarRuta(ruta);
            temp = temp.getpNext();
        }
    }  
             /**
     * Metodo para buscar un almacen por su numero
     * @param numAlmacen numero del almacen que se busca
     * @return almacen
     */
        public Almacen BuscarAlmacenNum(int numAlmacen){
            Nodo<Almacen> almacen = (Nodo<Almacen>) listaAlm.getFirst();
            while (almacen != null){
                if (almacen.getData().getNumvertice() == numAlmacen){
                    return almacen.getData();
                }almacen = almacen.getpNext();
            }return null;
        }

    /**
     * @return the NumAlmacenes
     */
    public int getNumAlmacenes() {
        return NumAlmacenes;
    }

    /**
     * @param NumAlmacenes the NumAlmacenes to set
     */
    public void setNumAlmacenes(int NumAlmacenes) {
        this.NumAlmacenes = NumAlmacenes;
    }

    /**
     * @return the EsDirigido
     */
    public boolean isEsDirigido() {
        return EsDirigido;
    }

    /**
     * @param EsDirigido the EsDirigido to set
     */
    public void setEsDirigido(boolean EsDirigido) {
        this.EsDirigido = EsDirigido;
    }
    

    /**
     * @return the listaAlm
     */
    public Lista<Almacen> getListaAlm() {
        return listaAlm;
    }

    /**
     * @param listaAlm the listaAlm to set
     */
    public void setListaAlm(Lista<Almacen> listaAlm) {
        this.listaAlm = listaAlm;
    }

    /**
     * @return the listaRutas
     */
    public Lista<Ruta> getListaRutas() {
        return listaRutas;
    }

    /**
     * @param listaRutas the listaRutas to set
     */
    public void setListaRutas(Lista<Ruta> listaRutas) {
        this.listaRutas = listaRutas;
    }

    
}
