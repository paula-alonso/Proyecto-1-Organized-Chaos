/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author marie
 */
public class Cola<T> {
    
    private Nodo First;
    private Nodo Last;
    private int size;

    public Cola() {
        this.First = null;
        this.Last = null;
        this.size = 0;
    }
    
    public boolean isEmpty(){
        return getFirst() == null;
    }

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
    
    
    
    public void Encolar(T elem){
        Nodo nuevo = new Nodo(elem);
        if (isEmpty()){
            nuevo.setpNext(First);
            First = nuevo;
            First.setpNext(Last);
            Last = nuevo;
        }
        else{
            Last.setpNext(nuevo);
            Last = nuevo; 
            size++;
        }
    }
    
    public void Desencolar(){
      
        if(!this.isEmpty()){
        if (size == 1) { 
        this.empty();
        }
        else{ 
        First = First.getpNext();
        size--;
        }
        
      }
    }    
    
    
}
