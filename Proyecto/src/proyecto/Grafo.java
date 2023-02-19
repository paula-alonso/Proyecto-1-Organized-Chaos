/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author alons
 */
public class Grafo {
    private boolean EsDirigido;
    private int NumAlmacenes;
    private int NumMaxVert;
    private Almacen[] tablaAdy;

    public Grafo(int maxVert) {
        this.EsDirigido = EsDirigido;
        this.NumAlmacenes = 0;
        this.NumMaxVert = maxVert;
        this.tablaAdy = new Almacen[maxVert];
    }
    
     // Busca y devuelve el número de vértice, si no lo encuentra regresa -1
    public int numAlmacen(String nombre) {
        Almacen v = new Almacen(nombre);
        boolean encontrado = false;
        int i = 0;
        for (; (i < NumAlmacenes) && !encontrado;){
            encontrado = tablaAdy[i].equals(v);
            if (!encontrado){
                i++;
            }
        }if(NumAlmacenes > i){
            return i;
        }
        return -1;
    }

    // Crea un nuevo vértice
    public void nuevoAlmacen (String nombre, Lista<Almacen> lista) {
        boolean existe = false; 
        if(numAlmacen(nombre) >= 0){
            existe = true;
        }
        if (!existe){
            Almacen v = new Almacen(nombre);
            lista.InsertInFinal(v);
            
            tablaAdy[NumAlmacenes++] = v;
        }
    } 
    
    public Lista<Ruta> BuscarListaAdAlmacen(String a){
        int posicionAlmacen = numAlmacen(a);
        Almacen vertice = tablaAdy[posicionAlmacen];
        Lista<Ruta> rutas = vertice.getAdyacencia();
        return rutas;
    }

    
     // Comprueba si dos vertices son adyacentes
    boolean adyacente(String a, String b){
        int v1, v2;
        v1 = numAlmacen(a);
        v2 = numAlmacen(b);
        if(v1 < 0 || v2 < 0) {
            JOptionPane.showMessageDialog(null,"El vértice no existe");
        }
        Lista<Ruta> rutas = BuscarListaAdAlmacen(a);
        Nodo<Ruta> arco = (Nodo<Ruta>) rutas.getFirst();
        for(int i = 0; i<rutas.getSize(); i++){
            if (arco.getData().getDestino() == v2){
                return true;
            }arco = arco.getpNext();
        }
            return false;
        }
    
    public void AgregarRuta(String a, String b, double peso){
        if(!adyacente(a,b)){
            int v1 = numAlmacen(a);
            int v2 = numAlmacen(b);
            if(v1 < 0 || v2 < 0) {
                JOptionPane.showMessageDialog(null,"El vértice no existe");
            }
            Ruta ab = new Ruta(v2, peso);
            Lista<Ruta> rutas = new Lista<>();
            rutas.InsertInFinal(ab);  
        }
    }

    /**
     * @return the NumAlmacenes
     */
    public int getNumAlmacenes() {
        return NumAlmacenes;
    }

    /**
     * @param NumAlmacenes the NumAlmacenes to set
     */
    public void setNumAlmacenes(int NumAlmacenes) {
        this.NumAlmacenes = NumAlmacenes;
    }

    /**
     * @return the NumMaxVert
     */
    public int getNumMaxVert() {
        return NumMaxVert;
    }

    /**
     * @param NumMaxVert the NumMaxVert to set
     */
    public void setNumMaxVert(int NumMaxVert) {
        this.NumMaxVert = NumMaxVert;
    }

    /**
     * @return the tablaAdy
     */
    public Almacen[] getTablaAdy() {
        return tablaAdy;
    }

    /**
     * @param tablaAdy the tablaAdy to set
     */
    public void setTablaAdy(Almacen[] tablaAdy) {
        this.tablaAdy = tablaAdy;
    }

    /**
     * @return the EsDirigido
     */
    public boolean isEsDirigido() {
        return EsDirigido;
    }

    /**
     * @param EsDirigido the EsDirigido to set
     */
    public void setEsDirigido(boolean EsDirigido) {
        this.EsDirigido = EsDirigido;
    }
    
    public void guardarAlmacenes(Lista<Almacen> lista, Lista<Almacen> nueva_lista){
        Nodo<Almacen> temp = lista.getFirst();
        if(lista.isEmpty()){
            JOptionPane.showMessageDialog(null,"No se introdujo ningún almacen");
            }
            while(temp != null){
            nuevoAlmacen(temp.getData().getNombre(), nueva_lista);
            temp = temp.getpNext();
        }
    }     

        public void guardarRutas(Lista<Ruta> lista){
        Nodo<Ruta> temp = lista.getFirst();
        if(lista.isEmpty()){
            JOptionPane.showMessageDialog(null,"No se introdujo ninguna ruta");
            }
            while(temp != null){
            String a = temp.getData().getOrigen_etiqueta();
            String b = temp.getData().getDestino_etiqueta();
            double peso = temp.getData().getPeso();
            AgregarRuta(a, b, peso);
            temp = temp.getpNext();
        }
    }  

    
}
