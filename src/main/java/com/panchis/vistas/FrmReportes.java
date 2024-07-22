/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.panchis.vistas;

import com.panchis.dao.Conexion;
import com.panchis.dao.Crud_Usuario;
import com.panchis.controlador.Ctrl_Reportes;
import com.panchis.controlador.Reportes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Jean
 */
public class FrmReportes extends javax.swing.JPanel {

    /**
     * Creates new form FrmReportes
     */
    public FrmReportes() {
        initComponents();
        // ncesario para poder ejecutar todos los metodos del controlador reportes(acciones de botones)
        Ctrl_Reportes controlador = new Ctrl_Reportes(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        btn_reporte_cliente = new javax.swing.JButton();
        btn_reporte_categorias = new javax.swing.JButton();
        btn_reporte_ventas = new javax.swing.JButton();
        btn_reporte_productos = new javax.swing.JButton();
        btn_reporte_auditorias = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Background.setBackground(new java.awt.Color(255, 255, 255));
        Background.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_reporte_cliente.setBackground(new java.awt.Color(0, 0, 0));
        btn_reporte_cliente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_reporte_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/panchis/imagenes/analytics.png"))); // NOI18N
        btn_reporte_cliente.setText("GENERAR REPORTE DE CLIENTES");
        btn_reporte_cliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_reporte_cliente.setContentAreaFilled(false);
        btn_reporte_cliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btn_reporte_categorias.setBackground(new java.awt.Color(0, 0, 0));
        btn_reporte_categorias.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_reporte_categorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/panchis/imagenes/analytics.png"))); // NOI18N
        btn_reporte_categorias.setText("GENERAR REPORTE DE CATEGORIAS");
        btn_reporte_categorias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_reporte_categorias.setContentAreaFilled(false);
        btn_reporte_categorias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btn_reporte_ventas.setBackground(new java.awt.Color(0, 0, 0));
        btn_reporte_ventas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_reporte_ventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/panchis/imagenes/analytics.png"))); // NOI18N
        btn_reporte_ventas.setText("GENERAR REPORTE DE VENTAS");
        btn_reporte_ventas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_reporte_ventas.setContentAreaFilled(false);
        btn_reporte_ventas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btn_reporte_productos.setBackground(new java.awt.Color(0, 0, 0));
        btn_reporte_productos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_reporte_productos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/panchis/imagenes/analytics.png"))); // NOI18N
        btn_reporte_productos.setText("GENERAR REPORTE DE PRODUCTOS");
        btn_reporte_productos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_reporte_productos.setContentAreaFilled(false);
        btn_reporte_productos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btn_reporte_auditorias.setBackground(new java.awt.Color(0, 0, 0));
        btn_reporte_auditorias.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_reporte_auditorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/panchis/imagenes/analytics.png"))); // NOI18N
        btn_reporte_auditorias.setText("GENERAR REPORTE DE EVENTOS");
        btn_reporte_auditorias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_reporte_auditorias.setContentAreaFilled(false);
        btn_reporte_auditorias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout BackgroundLayout = new javax.swing.GroupLayout(Background);
        Background.setLayout(BackgroundLayout);
        BackgroundLayout.setHorizontalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGap(301, 301, 301)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_reporte_auditorias, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_reporte_ventas, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_reporte_categorias, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_reporte_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_reporte_productos, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(359, Short.MAX_VALUE))
        );
        BackgroundLayout.setVerticalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btn_reporte_productos, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_reporte_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_reporte_categorias, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_reporte_ventas, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btn_reporte_auditorias, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    public static javax.swing.JButton btn_reporte_auditorias;
    public static javax.swing.JButton btn_reporte_categorias;
    public static javax.swing.JButton btn_reporte_cliente;
    public static javax.swing.JButton btn_reporte_productos;
    public static javax.swing.JButton btn_reporte_ventas;
    // End of variables declaration//GEN-END:variables

}



