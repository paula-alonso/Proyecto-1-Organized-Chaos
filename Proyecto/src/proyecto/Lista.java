/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author alons
 */
public class Lista<T> {
    private Nodo First;
    private Nodo Last;
    private int size;

    public Lista() {
        this.First = null;
        this.Last = null;
        this.size = 0;
    }
    
    public boolean isEmpty(){
        return getFirst() == null;
    }

    
    /**
     * @return the First
     */
    public Nodo getFirst() {
        return First;
    }

    /**
     * @param First the First to set
     */
    public void setFirst(Nodo First) {
        this.First = First;
    }

    /**
     * @return the Last
     */
    public Nodo getLast() {
        return Last;
    }

    /**
     * @param Last the Last to set
     */
    public void setLast(Nodo Last) {
        this.Last = Last;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    public void InsertAtFirst(Object elem){
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
    
    public void InsertInFinal(Object elem){
        Nodo nuevo = new Nodo(elem);
        if (isEmpty()){
            this.InsertAtFirst(elem);
        }else{
            Last.setpNext(nuevo);
            Last= nuevo;
            size++;    
        }
    }


    public String printProductos(){
        Nodo<Producto> temp = First;
        String object_string = "";
       if(this.isEmpty()){
        object_string = "No data to show.";
        }
        while(temp != null){
        String object = temp.getData().mostrar();
        object_string = object_string + "\n" + object;
        temp = temp.getpNext();
        }
        return object_string;
    }
    
    public String printRutas(){
        Nodo<Ruta> temp = First;
        String object_string = "";
       if(this.isEmpty()){
        object_string = "";
        }
        while(temp != null){
        String object = temp.getData().mostrar();
        object_string = object_string + object+ "\n";
        temp = temp.getpNext();
        }
        return object_string;
    }    
    
    public String print(){
        Nodo<Almacen> temp = First;
        String almacenes_string = "";
       if(this.isEmpty()){
        almacenes_string = "No data to show.";
        }
        while(temp != null){
        String object = temp.getData().mostrar();
        almacenes_string = almacenes_string + "\n" + object + "\n";
        temp = temp.getpNext();
        }
        return almacenes_string;
    }  
    
        public String nombresAlmacenes(){
        Nodo<Almacen> temp = First;
        String almacenes_string = "";
       if(this.isEmpty()){
        almacenes_string = "";
        }
        while(temp != null){
        String object = temp.getData().nombres();
        almacenes_string = almacenes_string + object;
        temp = temp.getpNext();
        }
        return almacenes_string;

      
        }    
        
        public String[] separarAdyacencias() {
        String[] ady;
        String ady_string = "";
        Nodo<Ruta> temp = First;

        while(temp != null){
        String object = temp.getData().getDestino_etiqueta();
        ady_string = ady_string + object + "\n";
        temp = temp.getpNext();
        }
        
        ady = ady_string.split("\n");
        
        return ady;
        }
    

        public String nombresProductos(){
            Nodo<Producto> producto = First;
            String productos_string = "";
           if(this.isEmpty()){
               productos_string = "";
            }
            while(producto != null){  
            productos_string += producto.getData().getNombre()+"\n";
            producto = producto.getpNext();
        }
        return productos_string;
        }
        
        


}
        


    

