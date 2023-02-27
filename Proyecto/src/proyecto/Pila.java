/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author Paula Alonso y Marielena Ginez
 */
public class Pila<T> {
    
    private Nodo First;
    private Nodo Last;
    private int size;

    /**
     * Metodo constructor 
     */
    public Pila() {
        this.First = null;
        this.Last = null;
        this.size = 0;
    }
    
    /**
     * Metodo para comprobar si la pila esta vacia
     * @return getFirst() == null Devuelve si la pila esta vacia
     */
    public boolean isEmpty(){
        return getFirst() == null;
    }
    
     /**
     * Metodo para vaciar la pila
     */   

    public void empty(){
        this.First = null;
        this.Last = null;
        this.size = 0;
    }
    
    /**
     * @return the First
     */
    public Nodo getFirst() {
        return First;
    }
    
    
    /**
     * Metodo apilar
     * @param elem Objeto a apilar
     */
    public void Apilar(Object elem){
        Nodo nuevo = new Nodo(elem);
        if(!isEmpty()){
            nuevo.setpNext(First);
            First = nuevo;}
        else{
            First = nuevo;
            First.setpNext(Last);
            Last = nuevo;
          
        }
        size++;
    }

    /**
     * Metodo desapilar
     */    
    public void Desapilar(){
      
        if(!this.isEmpty()){
        if (size == 1) {
        this.empty();
        }else{
        First = First.getpNext();
        size--;
        }
        
      
      }
        
    }    

    
    
}
