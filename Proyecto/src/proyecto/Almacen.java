/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author Paula Alonso y Marielena Ginez
 */
public class Almacen {
    private String nombre;
    private int numvertice;
    private Lista<Producto> productos;
    private Lista<Ruta> adyacencia;
    private Almacen prev;
    
    
     /**
     * Metodo constructor parametrizado
     * @param nombre Nombre del almacen
     */
    public Almacen(String nombre) {
        this.nombre = nombre;
        this.numvertice = -1;
        this.productos = new Lista<Producto> ();
        this.adyacencia = new Lista<Ruta>();
        this.prev = null;
    }
    
    /**
     * @param n Almacen a comparar
     * @return nombre.equals(n.nombre) Boolean si dos valores son iguales
     */    
    public boolean equals(Almacen n){    //Retorna true si dos valores son iguales 
        return nombre.equals(n.nombre);
    }
    
    /**
     * Metodo para establecer el numero de vertices
     * @param n Numero de vertices
     */    
    public void asigVert(int n) // establece el número de vértices
        {
         numvertice = n;
        }
    
    /**
     * @return nombre(numvertice) Características del vértice
     */      
    public String toString() // características del vértice
    {
        return nombre + " (" + numvertice + ")";
    }
 
    
    /**
     * @return the name
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the name to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the numvertice
     */
    public int getNumvertice() {
        return numvertice;
    }

    /**
     * @param numvertice the numvertice to set
     */
    public void setNumvertice(int numvertice) {
        this.numvertice = numvertice;
    }

    /**
     * @return the productos
     */
    public Lista<Producto> getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(Lista<Producto> productos) {
        this.productos = productos;
    }

    /**
     * @return the adyacencia
     */
    public Lista<Ruta> getAdyacencia() {
        return adyacencia;
    }

    /**
     * @param adyacencia the adyacencia to set
     */
    public void setAdyacencia(Lista<Ruta> adyacencia) {
        this.adyacencia = adyacencia;
    }
    
    /**
     * @return almacen_string String del almacen
     */  
    public String mostrar(){
    String almacen_string = "\n" + nombre + ": " + productos.printProductos();
    return almacen_string;}

    public String nombres(){
    String almacen_string =  nombre + "\n";
    return almacen_string;}    

    /**
     * @return the prev
     */
    public Almacen getPrev() {
        return prev;
    }

    /**
     * @param prev the prev to set
     */
    public void setPrev(Almacen prev) {
        this.prev = prev;
    }
    
    
}
