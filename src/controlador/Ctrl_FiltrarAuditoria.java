/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import DAO.Conexion;
import DAO.Crud_Auditoria;
import Vistas.FrmFiltroAuditoria;
import java.awt.event.ActionListener;

import DAO.Crud_Usuario;

import static Vistas.Dashboard.ShowPanel;
import Vistas.*; //importan todos los componentes de las vistas(botones)
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
public class Ctrl_FiltrarAuditoria implements ActionListener {

    FrmFiltroAuditoria vista;
    Crud_Auditoria crud;

    // Constructor que recibe la instancia de Dashboard
    public Ctrl_FiltrarAuditoria(FrmFiltroAuditoria vista) {
        this.vista = vista;
        this.vista.btn_filtrar.addActionListener(this);
        this.vista.btn_regresarAuditoria.addActionListener(this);

        // Añadir PropertyChangeListener al JDateChooser
        this.vista.jDateEvento.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    Date fechaSeleccionada = vista.jDateEvento.getDate();
                    if (fechaSeleccionada != null) {
                        Date fechaActual = new Date();
                        if (fechaSeleccionada.after(fechaActual)) {
                            vista.btn_filtrar.setEnabled(false);
                            limpiarTabla();
                            JOptionPane.showMessageDialog(null, "No se puede seleccionar una fecha futura.");
                        } else {
                            vista.btn_filtrar.setEnabled(true);
                        }
                    }
                }
            }
        });
    }

    // al presionar el botón
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btn_filtrar) {
            // Lógica para filtrar la tabla por fecha seleccionada
            FiltrarTablaPorFecha();
            registrarAccion("Botón Filtrar presionado");
        }
        if (e.getSource() == vista.btn_regresarAuditoria) {
            FrmAuditoria p21 = new FrmAuditoria();
            Dashboard.ShowPanel(p21);
        }
    }

    private void FiltrarTablaPorFecha() {
        // Obtener la fecha seleccionada del JDateChooser
        Date fechaSeleccionada = vista.jDateEvento.getDate();
        if (fechaSeleccionada != null) {
            // Convertir la fecha al formato deseado en la consulta SQL
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fecha = sdf.format(fechaSeleccionada);
            // Cargar la tabla de auditoría con la fecha seleccionada
            CargarTablaAuditoriaConFecha(fecha);
        } else {
            // Mostrar mensaje de error si no se ha seleccionado ninguna fecha
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fecha.");
        }
    }

    private void CargarTablaAuditoriaConFecha(String fecha) {
        Connection con = Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "SELECT a.id, CONCAT(u.nombre, ' ', u.apellido) AS usuario, a.fecha_conexion, a.hora_conexion, a.accion_realizada, a.ip_computadora "
                + "FROM tb_auditoria a "
                + "INNER JOIN tb_usuario u ON a.idUsuario = u.idUsuario "
                + "WHERE a.fecha_conexion = ? "
                + "ORDER BY a.id ASC";

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, fecha);
            ResultSet rs = pst.executeQuery();

            model.addColumn("N°");
            model.addColumn("Usuario");
            model.addColumn("Fecha");
            model.addColumn("Hora");
            model.addColumn("Acción");
            model.addColumn("IP");

            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("id"),
                    rs.getString("usuario"),
                    rs.getString("fecha_conexion"),
                    rs.getString("hora_conexion"),
                    rs.getString("accion_realizada"),
                    rs.getString("ip_computadora")
                };
                model.addRow(fila);
            }

            vista.jTable_auditoria.setModel(model);
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al cargar la tabla de auditoría con la fecha seleccionada: " + e);
        }
    }
    // Método para limpiar la tabla

    private void limpiarTabla() {
        DefaultTableModel model = (DefaultTableModel) vista.jTable_auditoria.getModel();
        model.setRowCount(0);
    }

    // Método para registrar las acciones en la tabla de auditoría
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
