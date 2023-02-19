/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

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
