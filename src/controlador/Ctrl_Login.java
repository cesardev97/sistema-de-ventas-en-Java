/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import static DAO.Crud_Rol.idRol;
import DAO.Crud_Usuario;
import static DAO.Crud_Usuario.idUsuarioAuditoria;
import static DAO.Crud_Usuario.obtenerDireccionIP;
import static DAO.Crud_Usuario.registrarAccion;
import Vistas.Dashboard;
import Vistas.Login;
import static Vistas.Login.btn_NoShowLogin;
import static Vistas.Login.btn_ShowLogin;
import static Vistas.Login.txtPassword;
import static Vistas.Login.txtusuario;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Usuario;

/**
 *
 * @author JEAN
 */
public class Ctrl_Login implements ActionListener {

    Login vista;

    public Ctrl_Login(Login vista) {
        this.vista = vista;
        // Inicializar la vista
        this.vista.setResizable(false);
        this.vista.setLocationRelativeTo(null);
        this.vista.setTitle("Login Panchi's Pizza");

        // Agregar el ActionListener A los botones
        //Crud_Dashboard.CargarTablaCategorias();
        this.vista.btnIngresar.addActionListener(this);

        this.vista.txtusuario.addActionListener(this);

        this.vista.txtPassword.addActionListener(this);

        this.vista.btn_ShowLogin.addActionListener(this);
        this.vista.btn_NoShowLogin.addActionListener(this);
        this.vista.btn_NoShowLogin.setVisible(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnIngresar) {
           this.Login();
            }
            if (e.getSource() == vista.btn_ShowLogin) {
                btn_ShowLogin.setVisible(false);
                btn_NoShowLogin.setVisible(true);
                txtPassword.setEchoChar((char) 0);
            }
            if (e.getSource() == vista.btn_NoShowLogin) {
                btn_ShowLogin.setVisible(true);
                btn_NoShowLogin.setVisible(false);
                txtPassword.setEchoChar('*');
            }

        }

    private void Login() {
        if (!txtusuario.getText().isEmpty() && !txtPassword.getText().isEmpty()) {
            Crud_Usuario controlUsuario = new Crud_Usuario();
            Usuario usuario = new Usuario();
            usuario.setUsuario(txtusuario.getText().trim());
            usuario.setPassword(txtPassword.getText().trim());

            if (controlUsuario.loginUser(usuario)) {
                int idRol = controlUsuario.obtenerIdRolUsuario(usuario.getIdUsuario());
                String nombreUsuario = usuario.getNombre();
                String apellidoUsuario = usuario.getApellido();

                Dashboard menuver = Dashboard.getInstance();
                menuver.setIdRol(idRol);

                Ctrl_Dashboard ctrlDashboard = new Ctrl_Dashboard(menuver);
                ctrlDashboard.setNombreUsuario(nombreUsuario, apellidoUsuario); // Actualiza el nombre de usuario

                menuver.setVisible(true);
                vista.dispose();
                 // Registrar la acción de inicio de sesión en la tabla de auditoría
                registrarAccion("Inicio de sesión mediante el login", idUsuarioAuditoria, obtenerDireccionIP());
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese las credenciales correctas");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Los campos están vacíos");
        }
    }

}



