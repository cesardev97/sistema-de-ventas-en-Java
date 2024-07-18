/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Vistas.FrmAuditoria;
import static Vistas.FrmAuditoria.jTable_auditoria;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jean
 */
public class Crud_Auditoria {

    public static int id;

    /**
     * **************************************************
     * MÉTODO PARA CARGAR LA TABLA AUDITORIA DESDE LA BASE DE DATOS CON CONSULTA
     * SQL **************************************************
     */
    public static void CargarTablaAuditoria() {
        Connection con = Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "SELECT a.id, CONCAT(u.nombre, ' ', u.apellido) AS usuario, a.fecha_conexion, a.hora_conexion, a.accion_realizada, a.ip_computadora "
                + "FROM tb_auditoria a "
                + "INNER JOIN tb_usuario u ON a.idUsuario = u.idUsuario "
                + "ORDER BY a.id ASC";//se agregó esto porque se ordena por nombre y no por ID el jtable auditoria
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            // Agregar las columnas al modelo de tabla
            model.addColumn("N°");//ID
            model.addColumn("Usuario");
            model.addColumn("fecha");
            model.addColumn("hora");
            model.addColumn("acción");
            model.addColumn("ip");

            // Iterar sobre los resultados y agregarlos al modelo de tabla
            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("id"),
                    rs.getString("usuario"),//concatenado
                    rs.getString("fecha_conexion"),
                    rs.getString("hora_conexion"),
                    rs.getString("accion_realizada"),
                    rs.getString("ip_computadora")
                };
                model.addRow(fila);
            }
            // Configurar el modelo de tabla en la tabla visual
            FrmAuditoria.jTable_auditoria.setModel(model);

            // Cerrar la conexión
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla de auditoria desde el crud: " + e);
        }
        //evento para obtener campo al cual el usuario da click
        //y obtener la interfaz que mostrara la informacion general
        jTable_auditoria.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_auditoria.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    id = (int) model.getValueAt(fila_point, columna_point);
                    EnviarDatosAuditoriaSeleccionados(id);//metodo
                }
            }
        });

    }

    /**
     * ***********************************************************************
     * MÉTODO PARA ENVIAR DATOS SELECCIONADOS SEGÚN ID AL CLICKEAR LA TABLA
     * ************************************************************************
     */
    private static void EnviarDatosAuditoriaSeleccionados(int idAuditoria) {
        try {
            Connection con = Conexion.conectar();
            //query para que muestre concatenado el nombre + apeliido del usuario en vez SOLO del ID
            String sql = "SELECT a.id, CONCAT(u.nombre, ' ', u.apellido) AS usuario, a.fecha_conexion, a.hora_conexion, a.accion_realizada, a.ip_computadora "
                    + "FROM tb_auditoria a "
                    + "INNER JOIN tb_usuario u ON a.idUsuario = u.idUsuario "
                    + "WHERE a.id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, idAuditoria);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                FrmAuditoria.txt_nombre.setText(rs.getString("usuario"));
                FrmAuditoria.txt_fecha.setText(rs.getString("fecha_conexion"));
                FrmAuditoria.txt_hora.setText(rs.getString("hora_conexion"));
                FrmAuditoria.txt_accion.setText(rs.getString("accion_realizada"));
                FrmAuditoria.txt_ip.setText(rs.getString("ip_computadora"));
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al seleccionar auditoría: " + e);
        }
    }

}
