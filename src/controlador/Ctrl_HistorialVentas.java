/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import DAO.Crud_GestionarVentas;
import DAO.Crud_HistorialVentas;
import DAO.Crud_Usuario;
import Vistas.Dashboard;
import Vistas.FrmFiltroHistorialVentas;
import Vistas.FrmHistorialVentas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Jean
 */
public class Ctrl_HistorialVentas implements ActionListener {

    FrmHistorialVentas vista;
    Crud_HistorialVentas crud;

    public Ctrl_HistorialVentas(FrmHistorialVentas vista) {
        this.vista = vista;
        this.crud = new Crud_HistorialVentas();
        this.vista.btn_filtrar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.btn_filtrar) {

            FrmFiltroHistorialVentas p40 = new FrmFiltroHistorialVentas();
            Dashboard.ShowPanel(p40);
            registrarAccion("Presionó el botón FILTRO DE VENTAS");
//            //actualizar la tabla en tiempo real
//            Crud_Auditoria.CargarTablaAuditoria();
        }

    }
    // Métodoo para registrar laS acciones en la tabla de auditoría

    private void registrarAccion(String accion) {
        try {
            Connection con = DAO.Conexion.conectar();
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
