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
    private int NumAlmacens;
    private int NumMaxVert;
    private Almacen[] tablaAdy;

    public Grafo(int maxVert) {
        this.EsDirigido = EsDirigido;
        this.NumAlmacens = 0;
        this.NumMaxVert = maxVert;
        this.tablaAdy = new Almacen[maxVert];
    }
    
     // Busca y devuelve el número de vértice, si no lo encuentra regresa -1
    public int numAlmacen(String nombre) {
        Almacen v = new Almacen(nombre);
        boolean encontrado = false;
        int i = 0;
        for (; (i < NumAlmacens) && !encontrado;){
            encontrado = tablaAdy[i].equals(v);
            if (!encontrado){
                i++;
            }
        }if(NumAlmacens > i){
            return i;
        }
        return -1;
    }

    // Crea un nuevo vértice
    public void nuevoAlmacen (String nombre) {
        boolean existe = false; 
        if(numAlmacen(nombre) >= 0){
            existe = true;
        }
        if (!existe){
            Almacen v = new Almacen(nombre);
            v.asigVert(NumAlmacens);
            tablaAdy[NumAlmacens++] = v;
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
            Lista<Ruta> rutas = BuscarListaAdAlmacen(a);
            //rutas.InsertarAlFinal(ab);  Hacer funcion de insertar al final
        }
    }

    /**
     * @return the NumAlmacens
     */
    public int getNumAlmacens() {
        return NumAlmacens;
    }

    /**
     * @param NumAlmacens the NumAlmacens to set
     */
    public void setNumAlmacens(int NumAlmacens) {
        this.NumAlmacens = NumAlmacens;
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
    
    
    
}
