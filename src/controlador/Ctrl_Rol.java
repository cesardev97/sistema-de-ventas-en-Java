/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import DAO.Crud_Rol;
import DAO.Crud_Usuario;
//import static Vistas.FrmCategoria.jTable_categoria;//tener en cuenta esto
import Vistas.FrmRol;
//import static Vistas.FrmCategoria.jTable_categoria;
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
import javax.swing.table.DefaultTableModel;
//import javax.swing.table.DefaultTableModel;
import modelo.Rol;

/**
 *
 * @author Jean
 */
// AQUI DEBERA IR LAS ACCIONES DE LOS BOTONES
public class Ctrl_Rol implements ActionListener {
// private static int idCategoria; //reemplazado por  -> int idCategoria = Crud_Categoria.idCategoria;

    FrmRol vista;
    Crud_Rol crud;

    // Constructor que recibe la instancia de FrmCategoria
    public Ctrl_Rol(FrmRol vista) {
        this.vista = vista;
        this.crud = new Crud_Rol();
        // Agregar el ActionListener A los botones
        Crud_Rol.CargarTablaRol();
        this.vista.btn_guardar.addActionListener(this);
        this.vista.btn_actualizar.addActionListener(this);
        this.vista.btn_eliminar.addActionListener(this);
        this.vista.btn_buscar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.btn_buscar) {
            //BUSCA EL ROL SEGUN EL ID
            if (FrmRol.txt_buscar_idRol.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Escribe el ID del Rol a buscar");

            } else {
                String RolBuscar = FrmRol.txt_buscar_idRol.getText().trim();
                Connection cn = DAO.Conexion.conectar();
                String sql = "SELECT * FROM tb_Rol where idRol = '" + RolBuscar + "'";
                Statement st;
                try {
                    st = cn.createStatement();
                    ResultSet rs = st.executeQuery(sql);
                    if (rs.next()) {
                        //error ortográfico persistente en todo el código tener que corregirlo 
                        FrmRol.txt_gestionar_nombre.setText(rs.getString("rol")); //"

                    } else {
                        JOptionPane.showMessageDialog(null, "¡ID de Rol incorrecta o no encontrada!");
                    }
                    FrmRol.txt_buscar_idRol.setText("");
                    cn.close();
                } catch (SQLException a) { // como el "e" está ocupado se coloca "a
                    System.out.println("¡Error al buscar id!, " + a);
                }
            }

        }
        if (e.getSource() == vista.btn_guardar) {
            Rol rol = new Rol();
            Crud_Rol controlRol = new Crud_Rol();
            rol.setRol(FrmRol.txt_rol.getText().trim());
            //validar si el campo esta vacio
            if (FrmRol.txt_rol.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "complete todos los campos");
            } else {
                if (!controlRol.existeRol(FrmRol.txt_rol.getText().trim())) {
                    rol.setRol(FrmRol.txt_rol.getText().trim());
                    rol.setEstado(1); //guarda el campo estado con 1
                    if (controlRol.guardar(rol)) {
                        JOptionPane.showMessageDialog(null, "Registro guardado");
                        //se enviará los datos a tb_aditoria
                        registrarAccion("Logró agregar un nuevo rol");

//                         Limpiar el modelo de la tabla(proceso inncesario y provoca error)
//                    DefaultTableModel model = (DefaultTableModel) FrmRol.jTable_rol.getModel();
//                    model.setRowCount(0);
                        // Volver a cargar los datos en el modelo de la tabla
                        Crud_Rol.CargarTablaRol();

                    } else {
                        JOptionPane.showMessageDialog(null, "Error al guardar");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "La categoria ya se encuentra en la base de datos");
                }

            }
            //limpiar campos
            FrmRol.txt_gestionar_nombre.setText("");
        }
//
        if (e.getSource() == vista.btn_actualizar) {
            int idRol = Crud_Rol.idRol;
            if (!FrmRol.txt_gestionar_nombre.getText().isEmpty()) {
                Rol rol = new Rol();
                Crud_Rol controlRol = new Crud_Rol();
                rol.setRol(FrmRol.txt_gestionar_nombre.getText().trim());

                if (controlRol.actualizar(rol, idRol)) {

                    JOptionPane.showMessageDialog(null, "Rol Actualizado");
                    //se enviará los datos a tb_aditoria
                    registrarAccion("Logró actualizar el rol: " + idRol + "");
                    FrmRol.txt_gestionar_nombre.setText("");
                    Crud_Rol.CargarTablaRol();
                } else {
                    JOptionPane.showMessageDialog(null, "error al actualizar rol desde el controlador ");
                }

            } else {
                JOptionPane.showMessageDialog(null, "seleccione un Rol");
            }

        }
//
        if (e.getSource() == vista.btn_eliminar) {
            if (!FrmRol.txt_gestionar_nombre.getText().isEmpty()) {
                Rol categoria = new Rol();
                Crud_Rol controlRol = new Crud_Rol();
                categoria.setRol(FrmRol.txt_gestionar_nombre.getText().trim());
                int idRol = Crud_Rol.idRol;
                if (!controlRol.eliminar(idRol)) {

                    JOptionPane.showMessageDialog(null, "Categoria Eliminada");
                    //se enviará los datos a tb_aditoria
                    registrarAccion("Logró eliminar unrol con id: " + idRol + "");
                    FrmRol.txt_gestionar_nombre.setText("");
                    Crud_Rol.CargarTablaRol();
                } else {
                    JOptionPane.showMessageDialog(null, "error al eliminar rol");
                }
            } else {
                JOptionPane.showMessageDialog(null, "seleccione un rol");
            }
        }

    }

    //metodo pra la auditoria
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
