/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import DAO.Crud_Categoria;
import DAO.Crud_Usuario;
//import static Vistas.FrmCategoria.jTable_categoria;//tener en cuenta esto
import Vistas.FrmCategoria;
//import conexion.Conexion; //ya no sirve
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
//import javax.swing.table.DefaultTableModel;
import modelo.Categoria;

/**
 *
 * @author Jean
 */
// AQUI DEBERÁ IR LAS ACCIONES DE LOS BOTONES
public class Ctrl_Categoria implements ActionListener {

// private static int idCategoria; //reemplazado por  -> int idCategoria = Crud_Categoria.idCategoria;
    FrmCategoria vista;
    Crud_Categoria crud;

    // Constructor que recibe la instancia de FrmCategoria
    public Ctrl_Categoria(FrmCategoria vista) {
        this.vista = vista;
        this.crud = new Crud_Categoria();
        // Agregar el ActionListener A los botones
        Crud_Categoria.CargarTablaCategorias();
        this.vista.btn_guardar.addActionListener(this);
        this.vista.btn_actualizar.addActionListener(this);
        this.vista.btn_eliminar.addActionListener(this);
        this.vista.btn_buscar.addActionListener(this);
    }

    @Override
    //registra acciones de los botones
    public void actionPerformed(ActionEvent e) {

        /* BOTÓN BUSCAR*/
        if (e.getSource() == vista.btn_buscar) {
            //BUSCA EL CLIENTE SEGUN EL DNI
            if (FrmCategoria.txt_buscar_idCategoria.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Escribe el ID de la categoria a buscar");

            } else {
                String categoriaBuscar = FrmCategoria.txt_buscar_idCategoria.getText().trim();
                Connection cn = DAO.Conexion.conectar();
                String sql = "SELECT * FROM tb_categoria where idCategoria = '" + categoriaBuscar + "'";
                Statement st;
                try {
                    st = cn.createStatement();
                    ResultSet rs = st.executeQuery(sql);
                    if (rs.next()) {

                        FrmCategoria.txt_gestionar_discripcion.setText(rs.getString("discripcion")); //"

                    } else {
                        JOptionPane.showMessageDialog(null, "¡ID de categoria incorrecta o no encontrada!");
                    }
                    FrmCategoria.txt_buscar_idCategoria.setText("");
                    cn.close();
                } catch (SQLException a) { // como el "e" está ocupado se coloca "a
                    System.out.println("¡Error al buscar id!, " + a);

                }
            }

        }
        /* BOTÓN BUSCAR*/
        if (e.getSource() == vista.btn_guardar) {
            Categoria categoria = new Categoria();
            Crud_Categoria controlCategoria = new Crud_Categoria();
            categoria.setDiscripcion(FrmCategoria.txt_discripcion.getText().trim());
            //validar si el campo esta vacio
            if (FrmCategoria.txt_discripcion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "complete todos los campos");
            } else {
                if (!controlCategoria.existeCategoria(FrmCategoria.txt_discripcion.getText().trim())) {
                    categoria.setDiscripcion(FrmCategoria.txt_discripcion.getText().trim());
                    categoria.setEstado(1); //guarda el campo estado con 1
                    int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres GUARDAR esta CATEGORÍA?", "Confirmar Guardado", JOptionPane.YES_NO_OPTION);
                    if (confirmacion == JOptionPane.YES_OPTION) {
                        if (controlCategoria.guardar(categoria)) {
                            JOptionPane.showMessageDialog(null, "Registro guardado");
                            //se enviará los datos a tb_aditoria
                            registrarAccion("Logró registar una nueva categoría: " + categoria + "");

                            // Limpiar el modelo de la tabla(proceso inncesario y provoca error)
//                    DefaultTableModel model = (DefaultTableModel) jTable_categoria.getModel();
//                    model.setRowCount(0);
                            // Volver a cargar los datos en el modelo de la tabla
                            Crud_Categoria.CargarTablaCategorias();

                        } else {
                            JOptionPane.showMessageDialog(null, "Error al guardar");
                            //se enviará los datos a tb_aditoria
                            registrarAccion("No pudo guardar una nueva categoría ");
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "La categoria ya se encuentra en la base de datos");
                    //se enviará los datos a tb_aditoria
                    registrarAccion("Intentó guardar una categoría existente");
                }

            }
            //limpiar campos
            FrmCategoria.txt_discripcion.setText("");
        }
        /* BOTÓN ACTUALIZAR*/

        if (e.getSource() == vista.btn_actualizar) {
            int idCategoria = Crud_Categoria.idCategoria;
            if (!FrmCategoria.txt_gestionar_discripcion.getText().isEmpty()) {
                Categoria categoria = new Categoria();
                Crud_Categoria controlCategoria = new Crud_Categoria();
                categoria.setDiscripcion(FrmCategoria.txt_gestionar_discripcion.getText().trim());
                int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres ACTUALIZAR esta CATEGORÍA?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
                // Verificar si el usuario confirmó la eliminación
                if (confirmacion == JOptionPane.YES_OPTION) {
                    if (controlCategoria.actualizar(categoria, idCategoria)) {

                        JOptionPane.showMessageDialog(null, "Categoria Actualizada");
                        //se enviará los datos a tb_aditoria
                        registrarAccion("pActualizó la categoría: " + idCategoria + "");
                        FrmCategoria.txt_gestionar_discripcion.setText("");
                        Crud_Categoria.CargarTablaCategorias();
                    } else {
                        JOptionPane.showMessageDialog(null, "error al actualizar categoria desde el controlador ");
                        //se enviará los datos a tb_aditoria
                        registrarAccion("presentó un error al actualizar datos de categoría");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "seleccione una categoria");
                //se enviará los datos a tb_aditoria
                registrarAccion("Intentó actualizar una categoría sin seleccionarla");
            }

        }
        /* BOTÓN ELIMINAR*/
        if (e.getSource() == vista.btn_eliminar) {
            if (!FrmCategoria.txt_gestionar_discripcion.getText().isEmpty()) {
                Categoria categoria = new Categoria();
                Crud_Categoria controlCategoria = new Crud_Categoria();
                categoria.setDiscripcion(FrmCategoria.txt_discripcion.getText().trim());
                int idCategoria = Crud_Categoria.idCategoria;
                // Mostrar un cuadro de diálogo de confirmación
                int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres ELIMINAR esta categoría?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
                // Verificar si el usuario confirmó la eliminación
                if (confirmacion == JOptionPane.YES_OPTION) {
                    if (!controlCategoria.eliminar(idCategoria)) {
                        JOptionPane.showMessageDialog(null, "Categoria Eliminada");
                        //se enviará los datos a tb_aditoria
                        registrarAccion("Logró eliminar un(a) categoría con id: " + idCategoria + "");
                        FrmCategoria.txt_gestionar_discripcion.setText("");
                        Crud_Categoria.CargarTablaCategorias();
                    } else {
                        JOptionPane.showMessageDialog(null, "error al eliminar categoria");
                        //se enviará los datos a tb_aditoria
                        registrarAccion("presentó un error al eliminar datos categoría: " + idCategoria + "");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "seleccione una categoria");
                //se enviará los datos a tb_aditoria
                registrarAccion("Intentó eliminar una categoría sin seleccionarla");
            }
        }

    }
    /* REGISTRA EVENTOS EN tb_auditoria*/
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
