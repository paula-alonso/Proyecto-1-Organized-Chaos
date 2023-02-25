/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author alons
 */
public class Camino {
    private int distancia;
    private Lista<Almacen> almacenes;

    public Camino(int distancia, Lista<Almacen> almacenes) {
        this.distancia = distancia;
        this.almacenes = almacenes;
    }

    public void MostrarCamino(){
        Nodo<Almacen> almacen = almacenes.getFirst();
        while(almacen != null){
            System.out.println(almacen.getData().getNombre());
            almacen = almacen.getpNext();
        }
        System.out.println(distancia);
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
    
    
    
}
