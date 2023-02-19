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
    private int NumVertices;
    private int NumMaxVert;
    private Vertice[] tablaAdy;

    public Grafo(int maxVert) {
        this.EsDirigido = EsDirigido;
        this.NumVertices = 0;
        this.NumMaxVert = maxVert;
        this.tablaAdy = new Vertice[maxVert];
    }
    
     // Busca y devuelve el número de vértice, si no lo encuentra regresa -1
    public int numVertice(String nombre) {
        Vertice v = new Vertice(nombre);
        boolean encontrado = false;
        int i = 0;
        for (; (i < NumVertices) && !encontrado;){
            encontrado = tablaAdy[i].equals(v);
            if (!encontrado){
                i++;
            }
        }if(NumVertices > i){
            return i;
        }
        return -1;
    }

    // Crea un nuevo vértice
    public void nuevoVertice (String nombre) {
        boolean existe = false; 
        if(numVertice(nombre) >= 0){
            existe = true;
        }
        if (!existe){
            Vertice v = new Vertice(nombre);
            v.asigVert(NumVertices);
            tablaAdy[NumVertices++] = v;
        }
    } 
    
    public Lista<Arco> BuscarListaAdVertice(String a){
        int posicionVertice = numVertice(a);
        Vertice vertice = tablaAdy[posicionVertice];
        Lista<Arco> arcos = vertice.getAdyacencia();
        return arcos;
    }

    
     // Comprueba si dos vertices son adyacentes
    boolean adyacente(String a, String b){
        int v1, v2;
        v1 = numVertice(a);
        v2 = numVertice(b);
        if(v1 < 0 || v2 < 0) {
            JOptionPane.showMessageDialog(null,"El vértice no existe");
        }
        Lista<Arco> arcos = BuscarListaAdVertice(a);
        Nodo<Arco> arco = (Nodo<Arco>) arcos.getFirst();
        for(int i = 0; i<arcos.getSize(); i++){
            if (arco.getData().getDestino() == v2){
                return true;
            }arco = arco.getpNext();
        }
            return false;
        }
    
    public void AgregarArco(String a, String b, double peso){
        if(!adyacente(a,b)){
            int v1 = numVertice(a);
            int v2 = numVertice(b);
            if(v1 < 0 || v2 < 0) {
                JOptionPane.showMessageDialog(null,"El vértice no existe");
            }
            Arco ab = new Arco(v2, peso);
            Lista<Arco> arcos = BuscarListaAdVertice(a);
            //arcos.InsertarAlFinal(ab);  Hacer funcion de insertar al final
        }
    }

    /**
     * @return the NumVertices
     */
    public int getNumVertices() {
        return NumVertices;
    }

    /**
     * @param NumVertices the NumVertices to set
     */
    public void setNumVertices(int NumVertices) {
        this.NumVertices = NumVertices;
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
    public Vertice[] getTablaAdy() {
        return tablaAdy;
    }

    /**
     * @param tablaAdy the tablaAdy to set
     */
    public void setTablaAdy(Vertice[] tablaAdy) {
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
