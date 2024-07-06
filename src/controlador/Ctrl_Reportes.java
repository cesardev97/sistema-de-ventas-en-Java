/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import DAO.Crud_Usuario;
import Vistas.FrmReportes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author JEAN
 */
public class Ctrl_Reportes implements ActionListener {

    FrmReportes vista;
    // Constructor que recibe la instancia de Dashboard

    public Ctrl_Reportes(FrmReportes vista) {
        this.vista = vista;

        // Agregar el ActionListener A los botones
        //Crud_Dashboard.CargarTablaCategorias();
        this.vista.btn_reporte_productos.addActionListener(this);
        this.vista.btn_reporte_cliente.addActionListener(this);
        this.vista.btn_reporte_categorias.addActionListener(this);
        this.vista.btn_reporte_auditorias.addActionListener(this);
        this.vista.btn_reporte_ventas.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btn_reporte_productos) {
            Reportes reporte = new Reportes();
//            registrarAccion("Botón generar Reporte productos presionado");
            reporte.ReportesProductos();
        }
        if (e.getSource() == vista.btn_reporte_cliente) {
            Reportes reporte = new Reportes();
//            registrarAccion("Botón generar Reporte Clientes presionado");
            reporte.ReporteClientes();
        }
        if (e.getSource() == vista.btn_reporte_categorias) {
            Reportes reporte = new Reportes();
//            registrarAccion("Botón generar Reporte Categorias presionado");
            reporte.ReportesCategorias();
        }
        if (e.getSource() == vista.btn_reporte_ventas) {
            Reportes reporte = new Reportes();
//            registrarAccion("Botón generar Reporte ventas presionado");
            reporte.ReportesVentas();
        }
        if (e.getSource() == vista.btn_reporte_auditorias) {
            Reportes reporte = new Reportes();
//            registrarAccion("Botón generar Reporte eventos presionado");
            reporte.ReportesAuditorias();
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
