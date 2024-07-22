/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panchis.controlador;

import com.panchis.dao.Conexion;
import com.panchis.dao.Crud_Auditoria;
import com.panchis.vistas.FrmFiltroAuditoria;
import java.awt.event.ActionListener;

import com.panchis.dao.Crud_Usuario;

import static com.panchis.vistas.Dashboard.ShowPanel;
import com.panchis.vistas.*; //importan todos los componentes de las vistas(botones)
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JEAN
 */
public class Ctrl_Pago implements ActionListener {

    FrmPago  vista;
//    Crud_Auditoria crud;

    // Constructor que recibe la instancia de Dashboard
    public Ctrl_Pago(FrmPago vista) {
        this.vista = vista;
        this.vista.btn_regresarFacturacion.addActionListener(this);

    }
    // al presionar el botón

    public void actionPerformed(ActionEvent e) {

         if (e.getSource() == vista.btn_regresarFacturacion) {
            // Lógica para filtrar la tabla por fecha seleccionada
           FrmFacturacion p22= new FrmFacturacion();
            Dashboard.ShowPanel(p22);
//            registrarAccion("");
        }

    }
    

    // Métodoo para registrar laS acciones en la tabla de auditoría
    private void registrarAccion(String accion) {
        try {
            Connection con = com.panchis.dao.Conexion.conectar();
            String sql = "INSERT INTO tb_auditoria (idUsuario, fecha_conexion, hora_conexion, accion_realizada, ip_computadora) "
                    + "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Crud_Usuario.idUsuarioAuditoria); //
            ps.setTimestamp(2, new Timestamp(new Date().getTime())); // Fecha actual
            ps.setTimestamp(3, new Timestamp(new Date().getTime())); // Hora actual
            ps.setString(4, accion); // Acción realizada
            ps.setString(5, Crud_Usuario.obtenerDireccionIP()); // IP de la computadora
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al registrar la acción en la auditoría: " + e);
        }
    }

}
