/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ventanas;


import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Esta clase es para la implementación de imágenes
 * @author Paula Alonso y Marielena Ginez
 * @version 1.0
 * @see javax.swing.JPanel
 */

public class Imagen extends javax.swing.JPanel {
    
    int x, y;
     /**
     * Metodo para la impletación de la imagen
     * @param jPanel1 panel donde se colocara la imagen
     */
    public Imagen(JPanel jPanel1) {
        
        this.x = jPanel1.getWidth();
        this.y = jPanel1.getHeight();
        this.setSize(x, y);
    }

     /**
     * Override
     * @param g Graficos
     */
    @Override
    public void paint(Graphics g) {
        
        ImageIcon Img = new ImageIcon(getClass().getResource("/Images/imagen1.png"));
        g.drawImage(Img.getImage(), 0, 0, x, y, null);
    }    

}


