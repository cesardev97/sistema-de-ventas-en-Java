/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import DAO.Conexion;
import Vistas.Dashboard;
import java.awt.event.ActionListener;
import DAO.Crud_Dashboard;
import static DAO.Crud_Rol.idRol;
import DAO.Crud_Usuario;
import static Vistas.Dashboard.Contenido;
import static Vistas.Dashboard.ShowPanel;
import Vistas.*; //importan todos los componentes de las vistas(botones)
//
import static Vistas.Dashboard.btnCategoria;
import static Vistas.Dashboard.btnCliente;
import static Vistas.Dashboard.btnFacturar;
import static Vistas.Dashboard.btnHistorial;
import static Vistas.Dashboard.btnProducto;
import static Vistas.Dashboard.btnReportes;
import static Vistas.Dashboard.btnUsuario;
//
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
public class Ctrl_Dashboard implements ActionListener {
    //singleton

    private static Dashboard instance;
    private int idRol2;
    Dashboard vista;
    Crud_Dashboard crud;

    // Constructor que recibe la instancia de Dashboard
    public Ctrl_Dashboard(Dashboard vista) {

        this.vista = vista;

        this.vista.setResizable(false);//ESTO SIRVE PARA QUE NO SE PUEDA MAXIMIZAR

        this.crud = new Crud_Dashboard();
        // Agregar el ActionListener A los botones
        //Crud_Dashboard.CargarTablaCategorias();
        this.vista.btnUsuario.addActionListener(this);
        this.vista.btnCliente.addActionListener(this);
        this.vista.btnProducto.addActionListener(this);
        this.vista.btnCategoria.addActionListener(this);
        this.vista.btnFacturar.addActionListener(this);
        this.vista.btnReportes.addActionListener(this);
        this.vista.btnHistorial.addActionListener(this);
        this.vista.btnMenu.addActionListener(this);
        this.vista.btnSalir.addActionListener(this);
    }
    // al presionar el botón

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnUsuario) {
            FrmUsuario p1 = new FrmUsuario(); //muestra el formulario usuario(FrmUsuario)
            ShowPanel(p1); //mpetodo showPnael
            registrarAccion("Botón de Usuario presionado desde el ctrolador dasboarad"); //registra que se presionó el botón
        }
        if (e.getSource() == vista.btnCliente) {
            FrmCliente p3 = new FrmCliente();
            ShowPanel(p3);
            registrarAccion("Botón de Cliente presionado");
        }
        if (e.getSource() == vista.btnProducto) {
            FrmProducto p2 = new FrmProducto();
            ShowPanel(p2);
            registrarAccion("Botón de Producto presionado");
        }
        if (e.getSource() == vista.btnCategoria) {
            FrmCategoria p4 = new FrmCategoria();
            ShowPanel(p4);
            registrarAccion("Botón de Categoria presionado");
        }
        if (e.getSource() == vista.btnFacturar) {
            FrmFacturacion p5 = new FrmFacturacion();
            ShowPanel(p5);
            registrarAccion("Botón de Facturación presionado");
        }
        if (e.getSource() == vista.btnReportes) {
            FrmReportes p6 = new FrmReportes();
            ShowPanel(p6);
            registrarAccion("Botón de Reportes presionado");
        }
        if (e.getSource() == vista.btnHistorial) {
            FrmHistorialVentas p7 = new FrmHistorialVentas();
            ShowPanel(p7);
            registrarAccion("Botón Historial presionado");
        }
        if (e.getSource() == vista.btnMenu) {
            FrmMenu p8 = new FrmMenu();
            ShowPanel(p8);
            registrarAccion("Botón Menú presionado");
        }
        if (e.getSource() == vista.btnSalir) {
            int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION);

            // Si el usuario elige YES_OPTION dsaldra del programa
            if (opcion == JOptionPane.YES_OPTION) {
                registrarAccion("Botón de cerrar sesión presionado");
                System.exit(0);
            }
//            registrarAccion("Botón de cerrar sesión presionado");
//            System.exit(0);

        }
    }
    //nos sirve para cambiar entre jpanels cuando presionamos un boton en el dashboardd

    public static void ShowPanel(JPanel p) { //¿borre el static?

        p.setSize(1010, 500);// forzamos a darle el tamaño para evitar errores
        p.setLocation(0, 0); //centra
        Contenido.removeAll();
        Contenido.add(p, BorderLayout.CENTER);
        Contenido.revalidate();
        Contenido.repaint();

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
 //para mpostrar el nombre en el label
    public void setNombreUsuario(String nombreUsuario, String nombreApellido) {
            vista.txt_nombreUsuario.setText(nombreUsuario+" "+nombreApellido);
    }


}
