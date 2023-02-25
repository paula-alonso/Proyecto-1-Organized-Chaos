/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import java.awt.Color;
import javax.swing.JOptionPane;
import proyecto.Almacen;
import proyecto.Camino;
import proyecto.Funciones;
import proyecto.Lista;
import proyecto.Nodo;
import proyecto.Producto;

/**
 *
 * @author alons
 */
public class RealizarPedido extends javax.swing.JFrame {

    /**
     * Creates new form RealizarPedido
     */
    public RealizarPedido() {
        initComponents();
        this.setLocationRelativeTo(null); // centrar pantalla
        this.getContentPane().setBackground(Color.WHITE); // cambiar el color de fondo
        Imagen im = new Imagen(Header); 
        Header.add(im).repaint();
        instrucciones.setText("<html><p>Escriba los productos que necesita con su cantidad separados por comas (,)<b><p> Por ejemplo: pantalla,3,grafica,2</p></html>");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pantalla = new javax.swing.JTextArea();
        input = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        AlmacenesBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        RealizarPedido = new javax.swing.JButton();
        instrucciones = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 590, 10));

        jPanel3.setBackground(new java.awt.Color(255, 102, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 570, 10));

        Header.setBackground(new java.awt.Color(255, 255, 255));
        Header.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel1.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 230, 40));

        pantalla.setEditable(false);
        pantalla.setColumns(20);
        pantalla.setRows(5);
        jScrollPane1.setViewportView(pantalla);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 300, 240));
        jPanel1.add(input, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 190, -1));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Productos disponibles");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, -1, -1));

        jPanel1.add(AlmacenesBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 300, 100, 30));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Almacen: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, -1, 30));

        RealizarPedido.setBackground(new java.awt.Color(51, 153, 255));
        RealizarPedido.setText("Realizar pedido");
        RealizarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RealizarPedidoActionPerformed(evt);
            }
        });
        jPanel1.add(RealizarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 380, -1, -1));

        instrucciones.setForeground(new java.awt.Color(0, 0, 0));
        instrucciones.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(instrucciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 190, 130));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RealizarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RealizarPedidoActionPerformed
        try{
            String[] pedido = input.getText().split(",");
            if(pedido.length%2 !=0){
                throw new Exception ("Datos inválidos");
            }
            Almacen almacen = Menu.grafo.BuscarAlmacen((String) AlmacenesBox.getSelectedItem()).getData();
            Lista<Producto> productos = almacen.getProductos();
            for ( int i = 0; i<pedido.length-1; i++){
                if(i%2 == 0){
                Producto producto = Funciones.BuscarProducto(productos, pedido[i]);
                if(producto != null){
                    int cantidad = Integer.parseInt(pedido[i+1]);
                    int resta = producto.getCantidad()-cantidad;
                    if(resta<0){
                        producto.setCantidad(0);
                        //llamar al algoritmo de la ruta mas corta
                    }else{
                        producto.setCantidad(resta);
                    }
                }//Aqui va el algoritmo de la ruta mas corta
                else{
                    Camino camino = Funciones.Dijkstra(Menu.grafo, Menu.grafo.BuscarAlmacen((String) AlmacenesBox.getSelectedItem()), Menu.grafo.BuscarAlmacen("D"));
                    camino.MostrarCamino();
                }
                }
                
            }JOptionPane.showMessageDialog(null, "Pedido exitoso");
            dispose();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Datos inválidos");
        }
        
        
    }//GEN-LAST:event_RealizarPedidoActionPerformed

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
            java.util.logging.Logger.getLogger(RealizarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RealizarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RealizarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RealizarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RealizarPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> AlmacenesBox;
    private static javax.swing.JPanel Header;
    private javax.swing.JButton RealizarPedido;
    private javax.swing.JTextField input;
    private javax.swing.JLabel instrucciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextArea pantalla;
    // End of variables declaration//GEN-END:variables
}