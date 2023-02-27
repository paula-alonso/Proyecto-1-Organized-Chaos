/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 * Esta clase contiene los atributos y metodos de un camino
 * @author Paula Alonso y Marielena Ginez
 */
public class Camino {
    private int distancia;
    private Lista<Almacen> almacenes;
    private Lista<Ruta> rutas;

     /**
     * Metodo constructor parametrizado
     * @param distancia Distancia total del camino
     * @param almacenes Lista de almacenes recorridos
     */
    public Camino(int distancia, Lista<Almacen> almacenes) {
        this.distancia = distancia;
        this.almacenes = almacenes;
        this.rutas = rutas;
    }

    /**
     * @return the str_almacenes String de todos los almacenes
     */
    public String MostrarCamino(){
        Nodo<Almacen> almacen = almacenes.getFirst();
        String str_almacenes = "Ruta:\n";
        String str_distancia = "";
        while(almacen != null){
            str_almacenes += almacen.getData().getNombre() + "<-";
            almacen = almacen.getpNext();
        }
        str_distancia = String.valueOf(distancia);
        str_almacenes += "\nDistancia: " + str_distancia;
        return str_almacenes;
    }
    /**
     * @return the distancia
     */
    public int getDistancia() {
        return distancia;
    }

    /**
     * @param distancia the distancia to set
     */
    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    /**
     * @return the almacenes
     */
    public Lista<Almacen> getAlmacenes() {
        return almacenes;
    }

    /**
     * @param almacenes the almacenes to set
     */
    public void setAlmacenes(Lista<Almacen> almacenes) {
        this.almacenes = almacenes;
    }
    
    
    public Lista<Ruta> getRutas() {
        return rutas;
    }

      
}
