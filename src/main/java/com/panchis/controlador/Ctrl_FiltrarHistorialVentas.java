/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panchis.controlador;

import com.panchis.dao.Conexion;
import static com.panchis.dao.Crud_HistorialVentas.EnviarDatosVentaSeleccionada;
import static com.panchis.dao.Crud_HistorialVentas.idCliente;
import java.awt.event.ActionListener;
import com.panchis.dao.Crud_Usuario;
import static com.panchis.vistas.Dashboard.ShowPanel;
import com.panchis.vistas.*; //importan todos los componentes de las vistas(botones)
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JEAN
 */
public class Ctrl_FiltrarHistorialVentas implements ActionListener {

    FrmFiltroHistorialVentas vista;
//    Crud_Auditoria crud;

    // Constructor que recibe la instancia de Dashboard
    public Ctrl_FiltrarHistorialVentas(FrmFiltroHistorialVentas vista) {
        this.vista = vista;
        this.vista.btn_filtrar.addActionListener(this);
        this.vista.btn_regresarVentas.addActionListener(this);

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
        if (e.getSource() == FrmFiltroHistorialVentas.btn_filtrar) {
            // Lógica para filtrar la tabla por fecha seleccionada
            FiltrarTablaPorFecha();
            registrarAccion("Botón Filtrar presionado");
        }
        if (e.getSource() == vista.btn_regresarVentas) {
            FrmHistorialVentas p22 = new FrmHistorialVentas();
            Dashboard.ShowPanel(p22);
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
            CargarTablaVentasConFecha(fecha);
        } else {
            // Mostrar mensaje de error si no se ha seleccionado ninguna fecha
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fecha.");
        }
    }

    private void CargarTablaVentasConFecha(String fecha) {
        Connection con = Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "select cv.idCabeceraVenta as id, concat(c.nombre, ' ', c.apellido) as cliente, "
                + "cv.valorPagar as total, cv.fechaVenta as fecha, cv.estado "
                + "from tb_cabecera_venta as cv, tb_cliente as c where cv.idCliente = c.idCliente;";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            FrmFiltroHistorialVentas.jTable_ventas = new JTable(model);
            FrmFiltroHistorialVentas.jScrollPane1.setViewportView(FrmFiltroHistorialVentas.jTable_ventas);

            model.addColumn("N°");//ID
            model.addColumn("Cliente");
            model.addColumn("Total Pagar");
            model.addColumn("Fecha Venta");
            model.addColumn("estado");

            while (rs.next()) {
                Object fila[] = new Object[5];
                //CAMBIA LOS VALORES 1 Y 0 A ACTIVO O INACTIVO
                for (int i = 0; i < 5; i++) {
                    if (i == 4) {
                        String estado = String.valueOf(rs.getObject(i + 1));
                        if (estado.equalsIgnoreCase("1")) {
                            fila[i] = "Activo";
                        } else {
                            fila[i] = "Inactivo";
                        }
                    } else {
                        fila[i] = rs.getObject(i + 1);
                    }
                }
                model.addRow(fila);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla de ventas: " + e);
        }
        //evento para obtener campo al cual el usuario da click
        //y obtener la interfaz que mostrara la informacion general
        FrmFiltroHistorialVentas.jTable_ventas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = FrmFiltroHistorialVentas.jTable_ventas.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    idCliente = (int) model.getValueAt(fila_point, columna_point);
                    EnviarDatosVentaSeleccionada(idCliente);//metodo
                }
            }
        });
    }
    // Método para limpiar la tabla

    private void limpiarTabla() {
        DefaultTableModel model = (DefaultTableModel) vista.jTable_ventas.getModel();
        model.setRowCount(0);
    }

    // Método para registrar las acciones en la tabla de auditoría
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
