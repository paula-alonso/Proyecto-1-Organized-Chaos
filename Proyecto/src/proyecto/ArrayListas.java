/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author marie
 */
public class ArrayListas {
    private Lista<Almacen> lista_almacenes;
    private Lista<Ruta> lista_rutas;

    public ArrayListas(Lista<Almacen> lista_almacenes, Lista<Ruta> lista_rutas) {
        this.lista_almacenes = lista_almacenes;
        this.lista_rutas = lista_rutas;
    }

    /**
     * @return the lista_almacenes
     */
    public Lista<Almacen> getLista_almacenes() {
        return lista_almacenes;
    }

    /**
     * @return the lista_rutas
     */
    public Lista<Ruta> getLista_rutas() {
        return lista_rutas;
    }
}
