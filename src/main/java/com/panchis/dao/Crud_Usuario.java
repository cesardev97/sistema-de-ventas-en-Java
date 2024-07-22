/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panchis.dao;

import com.panchis.vistas.Dashboard;
import com.panchis.vistas.FrmUsuario;
import static com.panchis.vistas.FrmUsuario.btn_NoShowGestionar;
import static com.panchis.vistas.FrmUsuario.btn_ShowGestionar;
import static com.panchis.vistas.FrmUsuario.jTable_usuario;
import static com.panchis.vistas.FrmUsuario.txt_gestionar_password;
import com.panchis.controlador.Ctrl_Dashboard;
import com.panchis.controlador.Ctrl_encoder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.panchis.modelo.Usuario;

/**
 *
 * @author Jean
 */
public class Crud_Usuario extends Conexion {

    public Crud_Usuario() {

    }
    //inicializar 2 id para evitar conflictos

    //sirve para saber que id hace cambios en el sistema
    public static int idUsuarioAuditoria;
    //Para el login
    public static int idUsuario;

//metodo para lograr el login
    public boolean loginUser(Usuario objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        Ctrl_encoder encoder = new Ctrl_encoder(); // Crear una instancia del encriptador
        String sql = "SELECT idUsuario, idRol, nombre, apellido, usuario, PASSWORD FROM tb_usuario where usuario = ? AND PASSWORD = ?";
        PreparedStatement stmt = null;

        try {
            stmt = cn.prepareStatement(sql);
            stmt.setString(1, objeto.getUsuario());
            stmt.setString(2, encoder.encode(objeto.getPassword())); // Encriptar la contraseña
//            stmt.setString(2, objeto.getPassword());

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                //******************************************//
                // Obtener el ID del rol del usuario para bloquear botones en el dashboard
                int idRol2 = rs.getInt("idRol");
                // Pasar el ID del rol a la ventana del dashboard
                Dashboard.getInstance().setIdRol(idRol2); // Establecer el ID del rol en la instancia única
                Dashboard.getInstance().setVisible(true); // Mostrar la instancia única
                //******************************************//
                respuesta = true;
                idUsuarioAuditoria = rs.getInt("idUsuario");
                //obtener nombre y apellido de ussuario
                String nombreUsuario = rs.getString("nombre");  // Obtener el nombre del usuario
                String apellidoUsuario = rs.getString("apellido");  // Obtener el apellido del usuario

                // Establecer nombre y apellido en el objeto Usuario
                objeto.setNombre(nombreUsuario);
                objeto.setApellido(apellidoUsuario);

//                // Registrar la acción de inicio de sesión en la tabla de auditoría
//                registrarAccion("Inicio de sesión mediante el lñogin crud_ussuario", idUsuarioAuditoria, obtenerDireccionIP());
            }

        } catch (SQLException e) {
            System.out.println("Error al iniciar sesión: " + e);
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión");
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e);
            }
        }
        return respuesta;
    }
// metodo para registrar accionen en tb_auditoria

    public static void registrarAccion(String accion, int idUsuarioAuditoria, String ipComputadora) {
        Connection cn = Conexion.conectar();
        String sql = "INSERT INTO tb_auditoria (idUsuario, fecha_conexion, hora_conexion, accion_realizada, ip_computadora) VALUES (?, CURDATE(), CURTIME(), ?, ?)";

        try {
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setInt(1, idUsuarioAuditoria);
            stmt.setString(2, accion);
            stmt.setString(3, ipComputadora);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al registrar la acción en la tabla de auditoría: " + e);
            JOptionPane.showMessageDialog(null, "Error al registrar la acción en la tabla de auditoría");
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e);
            }
        }
    }

    // Método para obtener la dirección IP de la computadora
    public static String obtenerDireccionIP() {
        String ip = "";
        try {
            InetAddress localhost = InetAddress.getLocalHost();
            ip = localhost.getHostAddress();
        } catch (UnknownHostException e) {
            System.out.println("Error al obtener la dirección IP: " + e);
        }
        return ip;
    }

    public int obtenerIdRolUsuario(int idUsuarioAuditoria) {
        int idRol2 = 0;
        Connection cn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            cn = Conexion.conectar();
            String sql = "SELECT idRol FROM tb_usuario WHERE idUsuario = ?";
            stmt = cn.prepareStatement(sql);
            stmt.setInt(1, idUsuarioAuditoria);
            rs = stmt.executeQuery();

            if (rs.next()) {
                idRol2 = rs.getInt("idRol");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el ID del rol del usuario: " + e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e);
            }
        }

        return idRol2;
    }

    /**
     *
     * metodo panel derecho
     */
    //limpiar datosd e la izquierda
    public static void Limpiar() {
        FrmUsuario.txt_nombre.setText("");
        FrmUsuario.txt_apellido.setText("");
        FrmUsuario.txt_dni.setText("");
        FrmUsuario.txt_usuario.setText("");
        FrmUsuario.txt_password.setText("");
        FrmUsuario.txt_telefono.setText("");

    }
// Limpiar datos de la derecha

    public static void Limpiar2() {
        FrmUsuario.txt_gestionar_nombre.setText("");
        FrmUsuario.txt_gestionar_apellido.setText("");
        FrmUsuario.txt_gestionar_dni.setText("");
        FrmUsuario.txt_gestionar_usuario.setText("");
        FrmUsuario.txt_gestionar_password.setText("");
        FrmUsuario.txt_gestionar_telefono.setText("");
        FrmUsuario.txt_buscar_dniUsuario.setText("");

    }

    public static void CargarComboRol() {
        Connection cn = Conexion.conectar();
        String sql = "select * from tb_Rol";
        Statement st;
        try {

            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            FrmUsuario.jComboBoxRol.removeAllItems();
            FrmUsuario.jComboBoxRol.addItem("Seleccione rol:");
            while (rs.next()) {
                FrmUsuario.jComboBoxRol.addItem(rs.getString("rol"));
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("¡Error al cargar Roles!");
        }
    }
    /**
     *
     * metodo panel izquierdo
     */

    static String descripcionRol = "";

    public static void CargarTablaUsuarios() {
        Connection con = Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "select * from tb_usuario";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            FrmUsuario.jTable_usuario = new JTable(model);
            FrmUsuario.jScrollPane1.setViewportView(FrmUsuario.jTable_usuario);

            model.addColumn("N°");//ID
            model.addColumn("Nombre");
            model.addColumn("Apellido");
            model.addColumn("Rol");
            model.addColumn("Dni");
            model.addColumn("Usuario");
            model.addColumn("Contraseña");
            model.addColumn("Telefono");
            model.addColumn("Estado");
            while (rs.next()) {
                Object fila[] = new Object[9];
                for (int i = 0; i < 9; i++) {
                    if (i == 3) {
                        String rol = String.valueOf(rs.getObject(i + 1));
                        if (rol.equalsIgnoreCase("1")) {
                            fila[i] = "ADMIN";
                        } else if (rol.equalsIgnoreCase("2")) {
                            fila[i] = "CAJERO";
                        } else if (rol.equalsIgnoreCase("3")) {
                            fila[i] = "MESERO";
                        }
                    } else if (i == 8) {
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
            System.out.println("Error al llenar la tabla usuarios: " + e);
        }
        //evento para obtener campo al cual el usuario da click
        //y obtener la interfaz que mostrara la informacion general
        jTable_usuario.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_usuario.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    idUsuario = (int) model.getValueAt(fila_point, columna_point);
                    EnviarDatosUsuariosSeleccionados(idUsuario);//metodo
                    btn_ShowGestionar.setVisible(true);
                    btn_NoShowGestionar.setVisible(false);
                    txt_gestionar_password.setEchoChar('*');
                }
            }
        });
    }

    //metodo enviar los datos seleccionados
    private static void EnviarDatosUsuariosSeleccionados(int idUsuario) {
        //crea un instancia para encriptar o desencriptar contraeña
        Ctrl_encoder mEncoder = new Ctrl_encoder();
        try {
            try (Connection con = Conexion.conectar()) {
                PreparedStatement pst = con.prepareStatement(
                        "SELECT * FROM tb_usuario WHERE idUsuario ='" + idUsuario + "'");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    FrmUsuario.txt_gestionar_nombre.setText(rs.getString("nombre")); //"
                    FrmUsuario.txt_gestionar_apellido.setText(rs.getString("apellido")); //"
                    FrmUsuario.txt_gestionar_dni.setText(rs.getString("dni")); //"
                    FrmUsuario.txt_gestionar_usuario.setText(rs.getString("usuario")); //"
//                  FrmUsuario.txt_gestionar_password.setText(rs.getString("password")); //"
                    String passwordEncriptada = rs.getString("password");
                    String passwordDesencriptada = mEncoder.decode(passwordEncriptada);
                    FrmUsuario.txt_gestionar_password.setText(passwordDesencriptada);
                    FrmUsuario.txt_gestionar_telefono.setText(rs.getString("telefono")); //"
                    FrmUsuario.txt_buscar_dniUsuario.setText(rs.getString("dni")); //"

                }
                //par enviar en combo los roles
                int idRol = rs.getInt("idRol");
                FrmUsuario.jComboBox_gestionarRol.setSelectedItem(relacionarRol(idRol));
            }

        } catch (SQLException e) {
            System.out.println("Error al seleccionar usuario" + e);
        }
    }
    // Metodo para relacionar roles (sirve para enviar en combo los roles)

    public static String relacionarRol(int idRol) {

        String sql = "select rol from tb_rol where idRol = '" + idRol + "'";
        Statement st;
        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                descripcionRol = rs.getString("rol");
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("¡Error al obtener el id del rol!");
        }
        return descripcionRol;
    }

    /////////////////////////////////////////////////////////////////////////
    /**
     * **************************************************
     * metodo para guardar un usuario
     * **************************************************
     */
    public boolean guardar(Usuario objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("INSERT INTO tb_usuario VALUES (?,?,?,?,?,?,?,?,?)");
            consulta.setInt(1, 0); // id
            consulta.setString(2, objeto.getNombre());
            consulta.setString(3, objeto.getApellido());
            consulta.setInt(4, objeto.getIdRol());
            consulta.setString(5, objeto.getDni());
            consulta.setString(6, objeto.getUsuario());
            consulta.setString(7, objeto.getPassword());
            consulta.setString(8, objeto.getTelefono());
            consulta.setInt(9, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar usuario desde el controlador: " + e);
        }
        return respuesta;
    }

    //metodo para consulta si el usuario ya está guardado( ya existe) mediante el dni
    public boolean existeUsuario(String dni) {
        boolean respuesta = false;
        String sql = "SELECT dni FROM tb_usuario WHERE dni='" + dni + "';";
        Statement st;

        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql); //se ejecuta
            while (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar existencia de usuario" + e); //borré el +e despues de: usuario " 

        }
        return respuesta;
    }

    /**
     * **************************************************
     * metodo para actualizar un usuario
     * **************************************************
     */
    public boolean actualizar(Usuario objeto, int idUsuario) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("update tb_usuario set nombre=?, apellido = ?, idRol = ?, dni = ?, usuario = ?, password= ?, telefono = ?, estado = ? where idUsuario ='" + idUsuario + "'");
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getApellido());
            consulta.setInt(3, objeto.getIdRol());
            consulta.setString(4, objeto.getDni());
            consulta.setString(5, objeto.getUsuario());
            consulta.setString(6, objeto.getPassword());
            consulta.setString(7, objeto.getTelefono());
            consulta.setInt(8, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario desde el crud_usuario método actualizar: " + e);
        }
        return respuesta;
    }

    /**
     * **************************************************
     * metodo para eliminar un usuario
     * **************************************************
     */
    // SALE ERROR, ACTULAIZAMOS EL ESTADO A INACTIVO
    public boolean eliminar(int idUsuario) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            // Actualizar el estado del usuario a 0 (inactivo)
            PreparedStatement consulta = cn.prepareStatement(
                    "UPDATE tb_usuario SET estado = 0 WHERE idUsuario = ?");
            consulta.setInt(1, idUsuario);

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el estado del usuario desde el crud: " + e);
        }
        return respuesta;
    }

}
