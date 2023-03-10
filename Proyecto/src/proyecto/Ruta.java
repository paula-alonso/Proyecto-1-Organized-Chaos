/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author Paula Alonso y Marielena Ginez
 */
public class Ruta {
    private String origen_etiqueta;
    private String destino_etiqueta;
    private int destino;
    private int peso;
    
     /**
     * Metodo constructor parametrizado
     * @param origen_etiqueta Etiqueta origen
     * @param destino_etiqueta Etiqueta destino
     * @param peso Distancia
     */

    public Ruta(String origen_etiqueta, String destino_etiqueta, int peso) {
        
        this.origen_etiqueta = origen_etiqueta;
        this.destino_etiqueta = destino_etiqueta;
        this.peso = peso;
    }
    
    /**
     * Metodo verifica si dos rutas son iguales
     * @param n Ruta a comparar
     * @return destino == a.destino Boolean retorna si son iguales
     */    
    
    public boolean equals(Object n){
        Ruta a = (Ruta)n;
        return destino == a.destino;
    }


    /**
     * @return the destino
     */
    public int getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(int destino) {
        this.destino = destino;
    }

    /**
     * @return the peso
     */
    public int getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(int peso) {
        this.peso = peso;
    } 

    /**
     * @return the origen
     */
    
     

    /**
     * @return the origen_etiqueta
     */
    public String getOrigen_etiqueta() {
        return origen_etiqueta;
    }

    /**
     * @param origen_etiqueta the origen_etiqueta to set
     */
    public void setOrigen_etiqueta(String origen_etiqueta) {
        this.origen_etiqueta = origen_etiqueta;
    }

    /**
     * @return the destino_etiqueta
     */
    public String getDestino_etiqueta() {
        return destino_etiqueta;
    }

    /**
     * @param destino_etiqueta the destino_etiqueta to set
     */
    public void setDestino_etiqueta(String destino_etiqueta) {
        this.destino_etiqueta = destino_etiqueta;
    }
    
        /**
     * Metodo para mostrar la ruta
     * @return ruta String de la ruta
     */
    
    public String mostrar() {
        String ruta = getOrigen_etiqueta() + "," + getDestino_etiqueta() + "," + String.valueOf(getPeso());
        return ruta;        
                
    } 
    
        /**
     * Metodo para devolver las etiquetas de las rutas
     * @return ruta
     */
        public String etiquetas() {
        String ruta = getOrigen_etiqueta() + "," + getDestino_etiqueta();
        return ruta;        
                
    }      
    
}
