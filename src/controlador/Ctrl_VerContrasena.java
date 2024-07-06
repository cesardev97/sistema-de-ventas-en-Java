/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import DAO.Crud_Usuario;
import static DAO.Crud_Usuario.idUsuarioAuditoria;
import static DAO.Crud_Usuario.obtenerDireccionIP;
import static DAO.Crud_Usuario.registrarAccion;
import Vistas.Dashboard;
import static Vistas.FrmUsuario.btn_NoShowGestionar;
import static Vistas.FrmUsuario.btn_ShowGestionar;
import static Vistas.FrmUsuario.txt_gestionar_password;
import Vistas.FrmVerContrasena;
import static Vistas.FrmVerContrasena.btn_NoShowLogin;
import static Vistas.FrmVerContrasena.btn_ShowLogin;
import static Vistas.FrmVerContrasena.txtPasswordConfirmarContrasena;
import static Vistas.FrmVerContrasena.txtusuarioConfirmarContrasena;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Usuario;

/**
 *
 * @author JEAN
 */
public class Ctrl_VerContrasena implements ActionListener {

    FrmVerContrasena vista;

    public Ctrl_VerContrasena(FrmVerContrasena vista) {
        this.vista = vista;
        // Inicializar la vista
        this.vista.setResizable(false);
        this.vista.setLocationRelativeTo(null);
//        this.vista.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // No permitir minimizar
        this.vista.setTitle("Confirmar usuario");

        // Agregar el ActionListener A los botones
        //Crud_Dashboard.CargarTablaCategorias();
        this.vista.btnConfirmar.addActionListener(this);

        this.vista.txtusuarioConfirmarContrasena.addActionListener(this);

        this.vista.txtPasswordConfirmarContrasena.addActionListener(this);

        this.vista.btn_ShowLogin.addActionListener(this);
        this.vista.btn_NoShowLogin.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnConfirmar) {
            this.LoginVerContrasena();
        }
        if (e.getSource() == vista.btn_ShowLogin) {
            btn_ShowLogin.setVisible(false);
            btn_NoShowLogin.setVisible(true);
            txtPasswordConfirmarContrasena.setEchoChar((char) 0);
        }
        if (e.getSource() == vista.btn_NoShowLogin) {
            btn_ShowLogin.setVisible(true);
            btn_NoShowLogin.setVisible(false);
            txtPasswordConfirmarContrasena.setEchoChar('*');
        }
    }

//    private void LoginVerContrasena() {
//        // Verifica que los campos no estén vacíos
//        if (!txtusuarioConfirmarContrasena.getText().isEmpty() && !txtPasswordConfirmarContrasena.getText().isEmpty()) {
//            Crud_Usuario controlUsuario = new Crud_Usuario();
//            Usuario user = new Usuario();
//
//            // Establece el usuario y la contraseña
//            user.setUsuario(txtusuarioConfirmarContrasena.getText().trim());
//            user.setPassword(txtPasswordConfirmarContrasena.getText().trim());
//
//            // Verifica las credenciales del usuario
//            if (controlUsuario.loginUser(user)) {
//                int idRol = controlUsuario.obtenerIdRolUsuario(user.getIdUsuario());
//                String nombreUsuario = user.getNombre();
//                String apellidoUsuario = user.getApellido();
//
//                // Muestra un mensaje de confirmación
//                JOptionPane.showMessageDialog(null, "Usuario confirmado");
//                vista.dispose();//cierra el formulario de confirmar credenciales
//                btn_ShowGestionar.setVisible(true); //el boton se hbailita
//                btn_NoShowGestionar.setVisible(false);//el boton se deshabilita
//                txt_gestionar_password.setEchoChar((char) 0); // Mostrar contraseña despues d econfdirmar ususario
//                Dashboard menu = Dashboard.getInstance();
//
//                Ctrl_Dashboard ctrlDashboard = new Ctrl_Dashboard(menu);
//                ctrlDashboard.setNombreUsuario(nombreUsuario, apellidoUsuario); // Actualiza el nombre de usuario
//                menu.setEnabled(true);
//                menu.setVisible(true);
//                // Registrar la acción de inicio de sesión en la tabla de auditoría
//                registrarAccion("Inicio de sesión alterno: El usuario anterior usó las credenciales del usuario actual para ver las contraseñas", idUsuarioAuditoria, obtenerDireccionIP());
//            } else {
//                // Muestra mensaje de error si las credenciales son incorrectas
//                JOptionPane.showMessageDialog(null, "Ingrese las credenciales correctas");
//            }
//        } else {
//            // Muestra mensaje de error si los campos están vacíos
//            JOptionPane.showMessageDialog(null, "Los campos están vacíos");
//        }
//    }
    private void LoginVerContrasena() {
        // Verifica que los campos no estén vacíos
        if (!txtusuarioConfirmarContrasena.getText().isEmpty() && !txtPasswordConfirmarContrasena.getText().isEmpty()) {
            Crud_Usuario controlUsuario = new Crud_Usuario();
            Usuario user = new Usuario();
            // Establece el usuario y la contraseña
            user.setUsuario(txtusuarioConfirmarContrasena.getText().trim());
            user.setPassword(txtPasswordConfirmarContrasena.getText().trim());

            // Verifica las credenciales del usuario
            if (controlUsuario.loginUser(user)) {
                // Obtener el ID del rol del usuario
                int idRol = controlUsuario.obtenerIdRolUsuario(controlUsuario.idUsuarioAuditoria);
                Dashboard menu = Dashboard.getInstance();
                menu.setIdRol(idRol);
                if (idRol != 1) {
                    // Mostrar mensaje de falta de permisos
                    JOptionPane.showMessageDialog(null, "No tienes permisos para esta acción");
                    registrarAccion("Este usuario(sin permiso de administrador)intentó ver las contraseñas");
                    vista.dispose(); // cierra el formulario de confirmar credenciales
                    vista.setVisible(true);
                    
                    return; // Termina la ejecución del método si no tiene permisos

                }

                // Si tiene permisos (idRol == 1), continuar con las acciones normales
                // Muestra un mensaje de confirmación
                JOptionPane.showMessageDialog(null, "Usuario confirmado");
                vista.dispose(); // cierra el formulario de confirmar credenciales
                btn_ShowGestionar.setVisible(true); // el botón se habilita
                btn_NoShowGestionar.setVisible(false); // el botón se deshabilita
                txt_gestionar_password.setEchoChar((char) 0); // Mostrar contraseña después de confirmar usuario

                menu.habilitarBotonesSegunRol(); // Llama al método después de actual
                Ctrl_Dashboard ctrlDashboard = new Ctrl_Dashboard(menu);
                ctrlDashboard.setNombreUsuario(user.getNombre(), user.getApellido()); // Actualiza el nombre de usuario
                menu.setEnabled(true);
                menu.setVisible(true);

                // Registrar la acción de inicio de sesión en la tabla de auditoría
                controlUsuario.registrarAccion("Inicio de sesión alterno: El usuario anterior usó las credenciales del usuario actual para ver las contraseñas",
                        controlUsuario.idUsuarioAuditoria, controlUsuario.obtenerDireccionIP());
            } else {
                // Muestra mensaje de error si las credenciales son incorrectas
                JOptionPane.showMessageDialog(null, "Ingrese las credenciales correctas");
            }
        } else {
            // Muestra mensaje de error si los campos están vacíos
            JOptionPane.showMessageDialog(null, "Los campos están vacíos");
        }
    }

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
