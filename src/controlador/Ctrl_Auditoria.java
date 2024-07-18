/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import DAO.Conexion;
import DAO.Crud_Auditoria;
import Vistas.FrmAuditoria;
import java.awt.event.ActionListener;

import DAO.Crud_Usuario;

import static Vistas.Dashboard.ShowPanel;
import Vistas.*; //importan todos los componentes de las vistas(botones)
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author JEAN
 */

public class Ctrl_Auditoria implements ActionListener {
   
    FrmAuditoria vista;
    Crud_Auditoria crud;

    // Constructor que recibe la instancia de FrmAuditoria
    public Ctrl_Auditoria(FrmAuditoria  vista) {
        this.vista = vista;
        this.vista.btn_Refrescar.addActionListener(this);
        this.vista.btn_filtrar.addActionListener(this);
        this.vista.btn_regresarUsuario.addActionListener(this);

    }
    // al presionar el botón

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btn_Refrescar) {
            Crud_Auditoria.CargarTablaAuditoria();
            registrarAccion("Botón Refrescar Tabla auditoria presionado"); //registra que se presionó el botón
        }
          if (e.getSource() == vista.btn_filtrar) {
            FrmFiltroAuditoria p20 = new FrmFiltroAuditoria();
            Dashboard.ShowPanel(p20);
            registrarAccion("Presionó el botón FILTRAR");
        }
          if (e.getSource() == vista.btn_regresarUsuario) {
            FrmUsuario p20 = new FrmUsuario();
            Dashboard.ShowPanel(p20);
            registrarAccion("Presionó el botón FILTRAR");
        }

    
    }


    // Métodoo para registrar laS acciones en la tabla de auditoría
   private void registrarAccion(String accion) {
        try {
            Connection con = DAO.Conexion.conectar();
            //se coloca los valores en ? para evitar injection SQl
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
