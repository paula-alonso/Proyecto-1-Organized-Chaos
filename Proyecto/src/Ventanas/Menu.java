/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import java.awt.Color;
import java.io.File;
import javax.swing.JOptionPane;
import proyecto.Funciones;
import proyecto.Grafo;
import Graficos.DemoGrafo;
import proyecto.Lista;
import proyecto.Nodo;
import proyecto.Producto;


/**
 *
 * @author marie
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null); // centrar pantalla
        this.getContentPane().setBackground(Color.WHITE); // cambiar el color de fondo
    }
     public static Menu menu = new Menu();
     public static Grafo grafo = new Grafo();


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        Header = new javax.swing.JPanel();
        Reporte = new javax.swing.JButton();
        Cargar = new javax.swing.JButton();
        Actualizar = new javax.swing.JButton();
        Pedido = new javax.swing.JButton();
        Agregar = new javax.swing.JButton();
        Gestion = new javax.swing.JButton();
        MostrarGrafo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Amazon Prime");

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 404, Short.MAX_VALUE)
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 73, Short.MAX_VALUE)
        );

        Reporte.setBackground(new java.awt.Color(82, 193, 225));
        Reporte.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        Reporte.setText("Reporte de disponibilidad");
        Reporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReporteActionPerformed(evt);
            }
        });

        Cargar.setBackground(new java.awt.Color(82, 193, 225));
        Cargar.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        Cargar.setText("Cargar datos");
        Cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarActionPerformed(evt);
            }
        });

        Actualizar.setBackground(new java.awt.Color(82, 193, 225));
        Actualizar.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        Actualizar.setText("Actualizar datos");
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        Pedido.setBackground(new java.awt.Color(82, 193, 225));
        Pedido.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        Pedido.setText("Realizar pedido");
        Pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PedidoActionPerformed(evt);
            }
        });

        Agregar.setBackground(new java.awt.Color(82, 193, 225));
        Agregar.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        Agregar.setText(" Agregar Almacén/Ruta");
        Agregar.setComponentPopupMenu(jPopupMenu1);
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });

        Gestion.setBackground(new java.awt.Color(82, 193, 225));
        Gestion.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        Gestion.setText("Gestión de stock");
        Gestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GestionActionPerformed(evt);
            }
        });

        MostrarGrafo.setBackground(new java.awt.Color(82, 193, 225));
        MostrarGrafo.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        MostrarGrafo.setText("Mostrar grafo");
        MostrarGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarGrafoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Reporte, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Gestion, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MostrarGrafo, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(108, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(Cargar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Actualizar)
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(Reporte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Pedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Agregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Gestion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MostrarGrafo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cargar)
                    .addComponent(Actualizar))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        // TODO add your handling code here:
        File fichero = Funciones.FileChooser();
        Funciones.ActualizarRepositorio(grafo, fichero);
    }//GEN-LAST:event_ActualizarActionPerformed

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
        // TODO add your handling code here:
        new Seleccion1().setVisible(true);
    }//GEN-LAST:event_AgregarActionPerformed

    private void ReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReporteActionPerformed
        // TODO add your handling code here:
        new ReporteDisponibilidad().setVisible(true);
        menu.setVisible(false);
        ReporteDisponibilidad.ReporteAncho.setText(Funciones.RecorridoAncho(grafo));
        ReporteDisponibilidad.ReporteProfundidad.setText(Funciones.RecorridoProfundidad(grafo));
    }//GEN-LAST:event_ReporteActionPerformed

    private void MostrarGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarGrafoActionPerformed
        // TODO add your handling code here:
        
        String almacenes = grafo.getListaAlm().nombresAlmacenes();
        String rutas = grafo.getListaRutas().printRutas();

        DemoGrafo.mostrar(almacenes, rutas);
       
  
    }//GEN-LAST:event_MostrarGrafoActionPerformed

    private void CargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarActionPerformed
        // TODO add your handling code here:
        
            File fichero = Funciones.FileChooser();
            if (grafo.isEmpty()) {
            grafo = Funciones.LeerTxt(fichero);
            } else {
            int dialogResult = JOptionPane.showConfirmDialog(null, "¿Desea actualizar los datos?");
                if (dialogResult == JOptionPane.YES_OPTION) {
                Funciones.ActualizarRepositorio(grafo, fichero);
                grafo = Funciones.LeerTxt(fichero);
                }
                else {
                grafo = Funciones.LeerTxt(fichero);
                }
            }
 
    }//GEN-LAST:event_CargarActionPerformed

    private void GestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GestionActionPerformed
        // TODO add your handling code here:
        
        if (!Menu.grafo.getListaAlm().isEmpty()) {
            new Seleccion2().setVisible(true);
            String items = Menu.grafo.getListaAlm().nombresAlmacenes(); //Obtiene los nombres de los almacenes cargados
            String[] items_split = items.split("\n"); //Se crea un array con cada nombre

            for (int i=0; i<items_split.length; i++) {
                Seleccion2.AlmacenesBox.addItem(items_split[i]); //Se asigna cada almacen a un item del combo box
            }
        
        } else {
            JOptionPane.showMessageDialog(null, "No hay datos registrados");
        }
    }//GEN-LAST:event_GestionActionPerformed

    private void PedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PedidoActionPerformed
        if(!Menu.grafo.isEmpty()){
        new RealizarPedido().setVisible(true);
        menu.setVisible(false);
        String items = Menu.grafo.getListaAlm().nombresAlmacenes(); //Obtiene los nombres de los almacenes cargados
        String[] items_split = items.split("\n"); //Se crea un array con cada nombre
        String productosText = "";
        Funciones.AsignarAlmacenes(items_split, RealizarPedido.AlmacenesBox);
        
        //la lista de productos vistos es la que se pondra en el text area
        Lista<Producto> productosVistos = new Lista<Producto>();
        for (int i = 0; i<items_split.length; i++){
            Lista<Producto> productos = Menu.grafo.BuscarAlmacen(items_split[i]).getData().getProductos();
            Nodo<Producto> productoNodo = (Nodo<Producto>) productos.getFirst();
            for (int j = 0; j<productos.getSize(); j++){
                String productoNombre = productoNodo.getData().getNombre();
                Producto producto = Funciones.BuscarProducto(productosVistos, productoNombre);
                
                // se crea una copia del producto para no alterar el valor del producto original
                Producto productoCopia = new Producto(productoNombre, productoNodo.getData().getCantidad());
                if (producto != null){
                    producto.setCantidad(producto.getCantidad()+ productoNodo.getData().getCantidad());
                }else{
                    productosVistos.InsertInFinal(productoCopia);
                }
                productoNodo = productoNodo.getpNext();
            }
        }
        Nodo<Producto> mostrarP = (Nodo<Producto>) productosVistos.getFirst();
        while (mostrarP != null){
            productosText += mostrarP.getData().mostrar()+"\n";
            mostrarP = mostrarP.getpNext();
        }
        RealizarPedido.pantalla.setText(productosText);
        }else{
            JOptionPane.showMessageDialog(null, "No hay datos registrados");
        }
    }//GEN-LAST:event_PedidoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              
                menu.setVisible(true);
              
                Imagen im = new Imagen(Header); 
                Header.add(im).repaint(); //Carga el logo de Amazon Prime
                
          
                }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton Agregar;
    private javax.swing.JButton Cargar;
    private javax.swing.JButton Gestion;
    private static javax.swing.JPanel Header;
    private javax.swing.JButton MostrarGrafo;
    private javax.swing.JButton Pedido;
    private javax.swing.JButton Reporte;
    private javax.swing.JPopupMenu jPopupMenu1;
    // End of variables declaration//GEN-END:variables
}
