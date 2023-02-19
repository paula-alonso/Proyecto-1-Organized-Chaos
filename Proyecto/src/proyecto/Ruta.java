/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author alons
 */
public class Ruta {
    private int destino;
    private double peso;

    public Ruta(int destino, double peso) {
    
        this.destino = destino;
        this.peso = peso;
    }
    
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
    public double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(double peso) {
        this.peso = peso;
    } 

    /**
     * @return the origen
     */
    
    public String mostrar() {
        String ruta = getDestino() + ","+ String.valueOf(getPeso());
        return ruta;        
                
    }   
    
}
