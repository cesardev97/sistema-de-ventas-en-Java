/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
//import Vistas.FrmCategoria;

import Vistas.FrmCategoria;
import static Vistas.FrmCategoria.jTable_categoria;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Categoria;

public class Crud_Categoria extends Conexion {

    public static int idCategoria;

    public Crud_Categoria() {

    }

    /**
     * **************************************************
     * MÉTODO PARA CARGAR LA TABLA DE LAS CATEGORIAS DESDE LA BASE DE DATOS CON
     * CONSULTA SQL **************************************************
     */
    public static void CargarTablaCategorias() {

        Connection con = DAO.Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel(); //verificar
        String sql = "SELECT idCategoria, discripcion, estado FROM tb_categoria";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            FrmCategoria.jTable_categoria = new JTable(model);
            FrmCategoria.jScrollPane1.setViewportView(FrmCategoria.jTable_categoria);

            model.addColumn("id");
            model.addColumn("nombre");
            model.addColumn("estado");
            // SIRVE PARA QUE ESTADO EN VES DE APARECER 0 O 1 APARECE ACTIVO O INACTIVO
            while (rs.next()) {
                Object fila[] = new Object[3];
                for (int i = 0; i < 3; i++) {
                    if (i == 2) {
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
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla categoria:" + e);
        }
        // sirve para que si se clickea en la tabla se envian los datos
        jTable_categoria.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_categoria.rowAtPoint(e.getPoint());
                int columna_point = 0;
                if (fila_point > -1) {
                    idCategoria = (int) model.getValueAt(fila_point, columna_point);
                    EnviarDatosCategoriasSeleccionadas(idCategoria);
                }
            }
        });

    }

    /**
     * ***********************************************************************
     * MÉTODO PARA ENVIAR DATOS SELECCIONADOS SEGÚN ID AL CLICKEAR LA TABLA
     * ************************************************************************
     */
    private static void EnviarDatosCategoriasSeleccionadas(int idCategoria) {
        try {
            Connection con = DAO.Conexion.conectar();
            PreparedStatement pst = con.prepareStatement(
                    "SELECT * FROM tb_categoria WHERE idCategoria ='" + idCategoria + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                FrmCategoria.txt_gestionar_discripcion.setText(rs.getString("discripcion")); //"discripcion" campo registrado con ese error ortografico en la BBDD
                FrmCategoria.txt_buscar_idCategoria.setText(rs.getString("idCategoria")); //"discripcion" campo registrado con ese error ortografico en la BBDD
            }
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al seleccionar categoria" + e);
        }
    }

    /**
     * **************************************************
     * MÉTODO PARA GUARDAR CATEGORÍA
     * **************************************************
     */
    public boolean guardar(Categoria objeto) {
        boolean respuesta = false;
        Connection cn = DAO.Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("INSERT INTO tb_categoria values(?,?,?)");
            consulta.setInt(1, 0); // id
            consulta.setString(2, objeto.getDiscripcion());
            consulta.setInt(3, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar categoria" + e);
        }

        return respuesta;
    }

    /**
     * **************************************************
     * MÉTODO PARA VALIDAR SI UNA CATEGORÍA YA EXISTE Y NO REGISTRARLA
     * **************************************************
     */
    public boolean existeCategoria(String categoria) {
        boolean respuesta = false;
        String sql = "SELECT discripcion FROM tb_categoria where discripcion = '" + categoria + "';";
        Statement st;

        try {
            Connection cn = DAO.Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar categoria: " + e);
        }
        return respuesta;
    }

    /**
     * **************************************************
     * MÉTODO PARA ACTUALIZAR CATEGORÍA
     * **************************************************
     */
    public boolean actualizar(Categoria objeto, int idCategoria) {

        boolean respuesta = false;
        Connection cn = DAO.Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("UPDATE tb_categoria SET discripcion=? WHERE idCategoria = '" + idCategoria + "'");
            consulta.setString(1, objeto.getDiscripcion()); // id

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al actualizar categoria desde el crud_categoria" + e);
        }

        return respuesta;
    }

     /**
     * **************************************************
     * MÉTODO PARA ELIMINAR CATEGORÍA
     * **************************************************
     */
    public boolean eliminar(int idCategoria) {
        boolean respuesta = false;
        Connection cn = DAO.Conexion.conectar();
        try {
           
            
            PreparedStatement consulta = cn.prepareStatement(
                    "UPDATE tb_categoria SET estado = 0 WHERE idCategoria = ?");
            consulta.setInt(1, idCategoria);

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al eliminar categoria" + e);
        }

        return respuesta;
    }
}
