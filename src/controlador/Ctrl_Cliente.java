/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import DAO.Crud_Cliente;
import DAO.Crud_Usuario;
import Vistas.FrmCliente;
import java.awt.Color;
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
import modelo.Cliente;

/**
 *
 * @author Jean
 */
public class Ctrl_Cliente implements ActionListener {

    FrmCliente vista;
    Crud_Cliente crud;

    public Ctrl_Cliente(FrmCliente vista) {
        this.vista = vista;
        this.crud = new Crud_Cliente();
        // Agregar el ActionListener A los botones
        Crud_Cliente.CargarTablaCliente();
        this.vista.btn_guardar.addActionListener(this);
        this.vista.btn_actualizar.addActionListener(this);
        this.vista.btn_eliminar.addActionListener(this);
        this.vista.btn_buscar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btn_buscar) {
            //BUSCA EL CLIENTE SEGUN EL DNI
            if (FrmCliente.txt_buscar_dniCliente.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Escribe el DNI del cliente a buscar");
            } else {
                String clienteBuscar = FrmCliente.txt_buscar_dniCliente.getText().trim();
                Connection cn = DAO.Conexion.conectar();
                String sql = "SELECT * FROM tb_cliente where dni = '" + clienteBuscar + "'";
                Statement st;
                try {
                    st = cn.createStatement();
                    ResultSet rs = st.executeQuery(sql);
                    if (rs.next()) {
                        FrmCliente.txt_gestionar_nombre.setText(rs.getString("nombre")); //"
                        FrmCliente.txt_gestionar_apellido.setText(rs.getString("apellido")); //"
                        FrmCliente.txt_gestionar_dni.setText(rs.getString("dni")); //"
                        FrmCliente.txt_gestionar_direccion.setText(rs.getString("direccion")); //"
                        FrmCliente.txt_gestionar_telefono.setText(rs.getString("telefono")); //"
                    } else {
                        JOptionPane.showMessageDialog(null, "¡Dni de cliente incorrecta o no encontrada!");
                    }
                    FrmCliente.txt_buscar_dniCliente.setText("");
                    cn.close();
                } catch (SQLException a) { // como el "e" está ocupado se coloca "a
                    System.out.println("¡Error al buscar cliente!, " + a);
                }
            }
        }

        if (e.getSource() == vista.btn_guardar) {
            Cliente cliente = new Cliente();
            Crud_Cliente controlCliente = new Crud_Cliente();

            String nombre = FrmCliente.txt_nombre.getText().trim();
            String apellido = FrmCliente.txt_apellido.getText().trim();
            String dni = FrmCliente.txt_dni.getText().trim();
            String direccion = FrmCliente.txt_direccion.getText().trim();
            String telefono = FrmCliente.txt_telefono.getText().trim();

            // Validación de campos vacíos
            if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty() || direccion.isEmpty() || telefono.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Complete los campos faltantes");
            } else {
                boolean validacionNombre = esSoloLetras(nombre);
                boolean validacionApellido = esSoloLetras(apellido);
                boolean validacionDni = esNumerico(dni) && dni.length() == 8;
                boolean validacionTelefono = esNumerico(telefono) && telefono.length() == 9;

                if (!validacionNombre && !validacionApellido) {
                    JOptionPane.showMessageDialog(null, "Los campos Nombre y Apellido solo aceptan letras");
                } else if (!validacionNombre) {
                    JOptionPane.showMessageDialog(null, "El campo Nombre solo acepta letras");
                } else if (!validacionApellido) {
                    JOptionPane.showMessageDialog(null, "El campo Apellido solo acepta letras");
                } else if (!validacionDni && !validacionTelefono) {
                    JOptionPane.showMessageDialog(null, "El DNI debe tener 8 dígitos y el campo TELÉFONO debe tener 9 dígitos, ambos solo aceptan valores numéricos");
                } else if (!validacionDni) {
                    JOptionPane.showMessageDialog(null, "El campo DNI debe tener 8 dígitos y solo acepta valores numéricos");
                } else if (!validacionTelefono) {
                    JOptionPane.showMessageDialog(null, "El campo TELÉFONO debe tener 9 dígitos y solo acepta valores numéricos");
                } else {
                    if (!controlCliente.existeCliente(dni)) {
                        cliente.setNombre(nombre);
                        cliente.setApellido(apellido);
                        cliente.setDni(dni);
                        cliente.setDireccion(direccion);
                        cliente.setTelefono(telefono);
                        cliente.setEstado(1);

                        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres guardar este cliente?", "Confirmar registro", JOptionPane.YES_NO_OPTION);
                        if (confirmacion == JOptionPane.YES_OPTION) {
                            if (controlCliente.guardar(cliente)) {
                                JOptionPane.showMessageDialog(null, "Registro Guardado");
                                Crud_Cliente.Limpiar();
                                Crud_Cliente.CargarTablaCliente();
                                registrarAccion("Logró agregar un cliente");
                            } else {
                                JOptionPane.showMessageDialog(null, "Error al guardar");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El Cliente ya se encuentra registrado en la Base de Datos.");
                        registrarAccion("El sistema impidió registrar un cliente existente");
                    }
                }
            }
        }

        if (e.getSource() == vista.btn_actualizar) {
            int idCliente = Crud_Cliente.idCliente;
            String nombre = FrmCliente.txt_gestionar_nombre.getText().trim();
            String apellido = FrmCliente.txt_gestionar_apellido.getText().trim();
            String dni = FrmCliente.txt_gestionar_dni.getText().trim();
            String direccion = FrmCliente.txt_gestionar_direccion.getText().trim();
            String telefono = FrmCliente.txt_gestionar_telefono.getText().trim();

            if (idCliente == 0) {
                JOptionPane.showMessageDialog(null, "¡Seleccione un Cliente!");
            } else {
                // Validación de campos vacíos
                if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty() || direccion.isEmpty() || telefono.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "¡Completa todos los campos!");
                } else {
                    boolean validacionNombre = esSoloLetras(nombre);
                    boolean validacionApellido = esSoloLetras(apellido);
                    boolean validacionDni = esNumerico(dni) && dni.length() == 8;
                    boolean validacionTelefono = esNumerico(telefono) && telefono.length() == 9;

                    if (!validacionNombre && !validacionApellido) {
                        JOptionPane.showMessageDialog(null, "Los campos Nombre y Apellido solo aceptan letras");
                    } else if (!validacionNombre) {
                        JOptionPane.showMessageDialog(null, "El campo Nombre solo acepta letras");
                    } else if (!validacionApellido) {
                        JOptionPane.showMessageDialog(null, "El campo Apellido solo acepta letras");
                    } else if (!validacionDni && !validacionTelefono) {
                        JOptionPane.showMessageDialog(null, "El DNI debe tener 8 dígitos y el campo TELÉFONO debe tener 9 dígitos, ambos solo aceptan valores numéricos");
                    } else if (!validacionDni) {
                        JOptionPane.showMessageDialog(null, "El campo DNI debe tener 8 dígitos y solo acepta valores numéricos");
                    } else if (!validacionTelefono) {
                        JOptionPane.showMessageDialog(null, "El campo TELÉFONO debe tener 9 dígitos y solo acepta valores numéricos");
                    } else {
                        Cliente cliente = new Cliente();
                        Crud_Cliente controlCliente = new Crud_Cliente();
                        cliente.setNombre(nombre);
                        cliente.setApellido(apellido);
                        cliente.setDni(dni);
                        cliente.setDireccion(direccion);
                        cliente.setTelefono(telefono);
                        cliente.setEstado(1);

                        // Mostrar un cuadro de diálogo de confirmación
                        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres actualizar este cliente seleccionado?", "Confirmar Actualización", JOptionPane.YES_NO_OPTION);
                        if (confirmacion == JOptionPane.YES_OPTION) {
                            if (controlCliente.actualizar(cliente, idCliente)) {
                                JOptionPane.showMessageDialog(null, "¡Datos del cliente actualizados!");
                                //se enviará los datos a tb_aditoria
                                registrarAccion("Logró actualizar el cliente: " + idCliente);
                                Crud_Cliente.CargarTablaCliente();
                                Crud_Cliente.Limpiar2();
                            } else {
                                JOptionPane.showMessageDialog(null, "¡Error al actualizar desde el controlador!");
                                //se enviará los datos a tb_aditoria
                                registrarAccion("presentó un error al actualizar datos clientes");
                            }
                        }
                    }
                }
            }
        }

        if (e.getSource() == vista.btn_eliminar) {
            int idCliente = Crud_Cliente.idCliente;
            Crud_Cliente controlCliente = new Crud_Cliente();
            if (idCliente == 0) {
                JOptionPane.showMessageDialog(null, "¡Seleccione un cliente!");
            } else {
                // Mostrar un cuadro de diálogo de confirmación
                int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres eliminar este cliente?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
                // Verificar si el usuario confirmó la eliminación
                if (confirmacion == JOptionPane.YES_OPTION) {
                    if (!controlCliente.eliminar(idCliente)) {
                        JOptionPane.showMessageDialog(null, "¡Cliente Eliminado!");
                        //se enviará los datos a tb_aditoria
                        registrarAccion("Logró eliminar un cliente con id: " + idCliente);
                        Crud_Cliente.CargarTablaCliente();
                        Crud_Cliente.Limpiar2();
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "¡Error al eliminar cliente!");
                        //se enviará los datos a tb_aditoria
                        registrarAccion("presentó un error al eliminar datos clientes");
                        Crud_Cliente.Limpiar2();
                    }
                }
            }
        }
    }

// Comprueba que los campos sean numéricos
    private boolean esNumerico(String str) {
        return str.chars().allMatch(Character::isDigit);
    }

// Comprueba que los campos solo contengan letras
    private boolean esSoloLetras(String str) {
        return str.chars().allMatch(Character::isLetter);
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
