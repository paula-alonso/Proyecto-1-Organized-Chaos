/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author Paula Alonso
 */
public class Almacen {
    private String nombre;
    private int numvertice;
    private Lista<Producto> productos;
    private Lista<Ruta> adyacencia;

    public Almacen(String nombre) {
        this.nombre = nombre;
        this.numvertice = -1;
        this.productos = new Lista<Producto> ();
        this.adyacencia = new Lista<Ruta>();
    }
    
    public boolean equals(Almacen n){    //Retorna true si dos valores son iguales 
        return nombre.equals(n.nombre);
    }
    public void asigVert(int n) // establece el número de vértices
        {
         numvertice = n;
        }
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
     * @param name the name to set
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
    

    public String mostrar(){
    String almacen_string = "\n" + nombre + ": " + productos.printProductos();
    return almacen_string;}

    public String nombres(){
    String almacen_string =  nombre + "\n";
    return almacen_string;}    
    
    
}
