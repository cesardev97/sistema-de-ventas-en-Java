/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panchis.controlador;

import com.panchis.dao.Crud_Usuario;
import com.panchis.vistas.FrmReportes;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Jean
 */
public class Reportes {

    /*
    metodo para crear reportes de los clientes registrado en la BBDD
    
     */
   /* public void ReporteClientes() {
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "C:/Reporte Panchi's Pizzas/Reporte_Clientes.pdf"));// hay que tener mucho cuidado con las rutas, depedne de cada PC
//            Image header = Image.getInstance("src/Imagenes/logo panchis 80x80 px.png");
//            header.scaleToFit(650, 1000);
//            header.setAlignment(Chunk.ALIGN_CENTER);
            //formato al texto
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Reporte creado por \nVendedor Panchi´s\n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de Clientes \n\n");

            documento.open();
            //agregamos los datos
//            documento.add(header);
            documento.add(parrafo);

            PdfPTable tabla = new PdfPTable(5);
            tabla.addCell("Codigo");
            tabla.addCell("Nombres");
            tabla.addCell("dni");
            tabla.addCell("Telefono");
            tabla.addCell("Direccion");

            try {
                Connection cn = com.panchis.dao.Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select idCliente, concat(nombre, ' ', apellido) as nombres, dni, telefono, direccion from tb_cliente");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (SQLException e) {
                System.out.println("Error 4 en: " + e);
            }
            documento.close();

            JOptionPane.showMessageDialog(null, "Reporte creado");

        } catch (DocumentException e) {
            System.out.println("Error 1 en: " + e);
        } catch (FileNotFoundException ex) {
            System.out.println("Error 2 en: " + ex);
        } catch (IOException ex) {
            System.out.println("Error 3 en: " + ex);
        }
    }

    /* 
    * metodo para crear reportes de los productos registrados en el sistema
     */
   /* public void ReportesProductos() {
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "C:/Reporte Panchi's Pizzas/Reporte_Productos.pdf"));
//            Image header = Image.getInstance("src/Imagenes/logo panchis 50x50 px.png");
//            header.scaleToFit(650, 1000);
//            header.setAlignment(Chunk.ALIGN_CENTER);
            //formato al texto
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Reporte creado por \nVendedor(a) Panchi´sPizza\n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de Productos \n\n");

            documento.open();
            //agregamos los datos
//            documento.add(header);
            documento.add(parrafo);

            float[] columnsWidths = {3, 5, 4, 5, 7, 5, 6};

            PdfPTable tabla = new PdfPTable(columnsWidths);
            tabla.addCell("Codigo");
            tabla.addCell("Nombre");
            tabla.addCell("Cant.");
            tabla.addCell("Precio");
            tabla.addCell("Descripcion");
            tabla.addCell("Por. IGV"); //Iva
            tabla.addCell("Categoria");

            try {
                Connection cn = com.panchis.dao.Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select p.idProducto, p.nombre, p.cantidad, p.precio, p.discripcion, "
                        + "p.IGV, c.discripcion as categoria, p.estado "
                        + "from tb_producto as p, tb_categoria as c "
                        + "where p.idCategoria = c.idCategoria;");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                        tabla.addCell(rs.getString(7));
                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (SQLException e) {
                System.out.println("Error 4 en: " + e);
            }
            documento.close();

            JOptionPane.showMessageDialog(null, "Reporte creado");
            //se enviará los datos a tb_aditoria
            registrarAccion("Logró crear un reporte de productos");

        } catch (DocumentException e) {
            System.out.println("Error 1 en: " + e);
        } catch (FileNotFoundException ex) {
            System.out.println("Error 2 en: " + ex);
        } catch (IOException ex) {
            System.out.println("Error 3 en: " + ex);
        }
    }

    /* 
    * metodo para crear reportes de los categorias registrados en la BBDD
     */
  /*  public void ReportesCategorias() {
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "C:/Reporte Panchi's Pizzas/Reporte_Categotias.pdf"));
            //formato al texto
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Reporte creado por \n Vendedor(a) Panchi´sPizza \n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de Categorias \n\n");
            documento.open();
            //agregamos los datos
//            documento.add(header);
            documento.add(parrafo);

            PdfPTable tabla = new PdfPTable(3);
            tabla.addCell("Codigo");
            tabla.addCell("Descripcion");
            tabla.addCell("Estado");
            try {
                Connection cn = com.panchis.dao.Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select * from tb_categoria");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                    } while (rs.next());
                    documento.add(tabla);
                }
            } catch (SQLException e) {
                System.out.println("Error 4 en: " + e);
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado");
            //se enviará los datos a tb_aditoria
            registrarAccion("Logró crear un reporte de categorias");
        } catch (DocumentException e) {
            System.out.println("Error 1 en: " + e);
        } catch (FileNotFoundException ex) {
            System.out.println("Error 2 en: " + ex);
        } catch (IOException ex) {
            System.out.println("Error 3 en: " + ex);
        }
    }

    /* 
    * metodo para crear reportes de las ventas registrados en la BBDD
     */
  /*  public void ReportesVentas() {
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "C:/Reporte Panchi's Pizzas/Reporte_Ventas.pdf"));
            //formato al texto
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Reporte creado por \nVendedor Panchi´s\n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de Ventas \n\n");
            documento.open();
            //agregamos los datos
//            documento.add(header);
            documento.add(parrafo);
            float[] columnsWidths = {3, 9, 4, 5, 3};
            PdfPTable tabla = new PdfPTable(columnsWidths);
            tabla.addCell("Codigo");
            tabla.addCell("Cliente");
            tabla.addCell("Tot. Pagar");
            tabla.addCell("Fecha Venta");
            tabla.addCell("Estado");
            try {
                Connection cn = com.panchis.dao.Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select cv.idCabeceraVenta as id, concat(c.nombre, ' ', c.apellido) as cliente, "
                        + "cv.valorPagar as total, cv.fechaVenta as fecha, cv.estado "
                        + "from tb_cabecera_venta as cv, tb_cliente as c "
                        + "where cv.idCliente = c.idCliente;");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                    } while (rs.next());
                    documento.add(tabla);
                }
            } catch (SQLException e) {
                System.out.println("Error 4 en: " + e);
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado");
            //se enviará los datos a tb_aditoria
            registrarAccion("Logró crear un reporte de ventas");
        } catch (DocumentException e) {
            System.out.println("Error 1 en: " + e);
        } catch (FileNotFoundException ex) {
            System.out.println("Error 2 en: " + ex);
        } catch (IOException ex) {
            System.out.println("Error 3 en: " + ex);
        }
    }

    public void ReportesAuditorias() {
        Document documento = new Document(PageSize.A4.rotate()); // Configura la orientación horizontal

        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "C:/Reporte Panchi's Pizzas/Reporte_Auditorias.pdf"));
            //formato al texto
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Reporte creado por \n Empleado(a) Panchi´sPizza \n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de Eventos \n\n");
            documento.open();
            //agregamos los datos
//            documento.add(header);
            documento.add(parrafo);

            PdfPTable tabla = new PdfPTable(6);
            tabla.addCell("CÓDIGO");
            tabla.addCell("ID");
            tabla.addCell("NOMBRE");
            tabla.addCell("FECHA");
            tabla.addCell("HORA");
            tabla.addCell("ACCIÓN");
            tabla.addCell("IP");
            try {
                Connection cn = com.panchis.dao.Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select * from tb_auditoria");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));//faltra modificar consuilta para que en vez del id de usuario salga su nombre
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                    } while (rs.next());
                    documento.add(tabla);
                }
            } catch (SQLException e) {
                System.out.println("Error 4 en: " + e);
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado");
            //se enviará los datos a tb_aditoria
            registrarAccion("Logró crear un reporte de eventos/auditoria");
        } catch (DocumentException e) {
            System.out.println("Error 1 en: " + e);
        } catch (FileNotFoundException ex) {
            System.out.println("Error 2 en: " + ex);
        } catch (IOException ex) {
            System.out.println("Error 3 en: " + ex);
        }
    }

    // Métodoo para registrar laS acciones en la tabla de auditoría
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
    }*/
     public void ReporteClientes() {
        Document documento = new Document();
        try {
//            String ruta = System.getProperty("user.home");
//            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/OneDrive/Reporte_Clientes.pdf"));// hay que tener mucho cuidado con las rutas, depedne de cada PC
//            Image header = Image.getInstance("src/Imagenes/logo panchis 80x80 px.png");
//            header.scaleToFit(650, 1000);
//            header.setAlignment(Chunk.ALIGN_CENTER);
 
        // Ruta principal de los reportes
        String rutaPrincipal = "C:/Reportes Panchi's Pizzas";
        // Subcarpeta específica para los reportes de clientes
        String subcarpetaClientes = rutaPrincipal + "/Reportes Clientes";
        
        // Asegúrate de que la carpeta principal existe, si no, créala
        File carpetaPrincipal = new File(rutaPrincipal);
        if (!carpetaPrincipal.exists()) {
            carpetaPrincipal.mkdirs();
        }        
        // Asegúrate de que la subcarpeta específica existe, si no, créala
        File carpetaClientes = new File(subcarpetaClientes);
        if (!carpetaClientes.exists()) {
            carpetaClientes.mkdirs();
        }
        
        // Obtener la fecha actual y formatearla
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String fechaActual = formatter.format(new Date());        
        // Generar el nombre del archivo con la fecha
        String reporteclientes = "Reporte_Clientes " + fechaActual + ".pdf";        
        PdfWriter.getInstance(documento, new FileOutputStream(subcarpetaClientes + "/" + reporteclientes));
   
            //formato al texto
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Reporte creado por \nVendedor Panchi´s\n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de Clientes \n\n");

            documento.open();
            //agregamos los datos
//            documento.add(header);
            documento.add(parrafo);

            PdfPTable tabla = new PdfPTable(5);
            tabla.addCell("Codigo");
            tabla.addCell("Nombres");
            tabla.addCell("dni");
            tabla.addCell("Telefono");
            tabla.addCell("Direccion");

            try {
                Connection cn = com.panchis.dao.Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select idCliente, concat(nombre, ' ', apellido) as nombres, dni, telefono, direccion from tb_cliente");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (SQLException e) {
                System.out.println("Error 4 en: " + e);
            }
            documento.close();

            JOptionPane.showMessageDialog(null, "Reporte creado");

        } catch (DocumentException e) {
            System.out.println("Error 1 en: " + e);
        } catch (FileNotFoundException ex) {
            System.out.println("Error 2 en: " + ex);
        } catch (IOException ex) {
            System.out.println("Error 3 en: " + ex);
        }
    }

    /* 
    * metodo para crear reportes de los productos registrados en el sistema
     */
    public void ReportesProductos() {
        Document documento = new Document();
        try {
//            String ruta = System.getProperty("user.home");
//            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/OneDrive/Reporte_Productos.pdf"));
//            Image header = Image.getInstance("src/Imagenes/logo panchis 50x50 px.png");
//            header.scaleToFit(650, 1000);
//            header.setAlignment(Chunk.ALIGN_CENTER);
   // Ruta principal de los reportes
        String rutaPrincipal = "C:/Reportes Panchi's Pizzas";
        // Subcarpeta específica para los reportes de clientes
        String subcarpetaProductos = rutaPrincipal + "/Reportes Productos";
        
        // Asegúrate de que la carpeta principal existe, si no, créala
        File carpetaPrincipal = new File(rutaPrincipal);
        if (!carpetaPrincipal.exists()) {
            carpetaPrincipal.mkdirs();
        }        
        // Asegúrate de que la subcarpeta específica existe, si no, créala
        File carpetaProductos = new File(subcarpetaProductos);
        if (!carpetaProductos.exists()) {
            carpetaProductos.mkdirs();
        }
        
        // Obtener la fecha actual y formatearla
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String fechaActual = formatter.format(new Date());        
        // Generar el nombre del archivo con la fecha
        String reporteproductos = "Reporte_Productos " + fechaActual + ".pdf";        
        PdfWriter.getInstance(documento, new FileOutputStream(subcarpetaProductos + "/" + reporteproductos));
            //formato al texto
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Reporte creado por \nVendedor(a) Panchi´sPizza\n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de Productos \n\n");

            documento.open();
            //agregamos los datos
//            documento.add(header);
            documento.add(parrafo);

            float[] columnsWidths = {3, 5, 4, 5, 7, 5, 6};

            PdfPTable tabla = new PdfPTable(columnsWidths);
            tabla.addCell("Codigo");
            tabla.addCell("Nombre");
            tabla.addCell("Cant.");
            tabla.addCell("Precio");
            tabla.addCell("Descripcion");
            tabla.addCell("Por. IGV"); //Iva
            tabla.addCell("Categoria");

            try {
                Connection cn = com.panchis.dao.Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select p.idProducto, p.nombre, p.cantidad, p.precio, p.discripcion, "
                        + "p.IGV, c.discripcion as categoria, p.estado "
                        + "from tb_producto as p, tb_categoria as c "
                        + "where p.idCategoria = c.idCategoria;");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                        tabla.addCell(rs.getString(7));
                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (SQLException e) {
                System.out.println("Error 4 en: " + e);
            }
            documento.close();

            JOptionPane.showMessageDialog(null, "Reporte creado");
            //se enviará los datos a tb_aditoria
            registrarAccion("Logró crear un reporte de productos");

        } catch (DocumentException e) {
            System.out.println("Error 1 en: " + e);
        } catch (FileNotFoundException ex) {
            System.out.println("Error 2 en: " + ex);
        } catch (IOException ex) {
            System.out.println("Error 3 en: " + ex);
        }
    }

    /* 
    * metodo para crear reportes de los categorias registrados en la BBDD
     */
    public void ReportesCategorias() {
        Document documento = new Document();
        try {
           // String ruta = System.getProperty("user.home");
           // PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/OneDrive/Reporte_Categotias.pdf"));
              // Ruta principal de los reportes
        String rutaPrincipal = "C:/Reportes Panchi's Pizzas";
        // Subcarpeta específica para los reportes de clientes
        String subcarpetaCategorias = rutaPrincipal + "/Reportes Categorías";
        
        // Asegúrate de que la carpeta principal existe, si no, créala
        File carpetaPrincipal = new File(rutaPrincipal);
        if (!carpetaPrincipal.exists()) {
            carpetaPrincipal.mkdirs();
        }        
        // Asegúrate de que la subcarpeta específica existe, si no, créala
        File carpetaCategorias = new File(subcarpetaCategorias);
        if (!carpetaCategorias.exists()) {
            carpetaCategorias.mkdirs();
        }
        
        // Obtener la fecha actual y formatearla
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String fechaActual = formatter.format(new Date());        
        // Generar el nombre del archivo con la fecha
        String reportecategorias = "Reporte_Categorías " + fechaActual + ".pdf";        
        PdfWriter.getInstance(documento, new FileOutputStream(subcarpetaCategorias + "/" + reportecategorias));
            //formato al texto
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Reporte creado por \n Vendedor(a) Panchi´sPizza \n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de Categorias \n\n");
            documento.open();
            //agregamos los datos
//            documento.add(header);
            documento.add(parrafo);

            PdfPTable tabla = new PdfPTable(3);
            tabla.addCell("Codigo");
            tabla.addCell("Descripcion");
            tabla.addCell("Estado");
            try {
                Connection cn = com.panchis.dao.Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select * from tb_categoria");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                    } while (rs.next());
                    documento.add(tabla);
                }
            } catch (SQLException e) {
                System.out.println("Error 4 en: " + e);
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado");
            //se enviará los datos a tb_aditoria
            registrarAccion("Logró crear un reporte de categorias");
        } catch (DocumentException e) {
            System.out.println("Error 1 en: " + e);
        } catch (FileNotFoundException ex) {
            System.out.println("Error 2 en: " + ex);
        } catch (IOException ex) {
            System.out.println("Error 3 en: " + ex);
        }
    }

    /* 
    * metodo para crear reportes de las ventas registrados en la BBDD
     */
    public void ReportesVentas() {
        Document documento = new Document();
        try {
            //String ruta = System.getProperty("user.home");
        // Ruta principal de los reportes
        String rutaPrincipal = "C:/Reportes Panchi's Pizzas";
        // Subcarpeta específica para los reportes de ventas
        String subcarpetaVentas = rutaPrincipal + "/Reportes Ventas";
        
        // Asegúrate de que la carpeta principal existe, si no, créala
        File carpetaPrincipal = new File(rutaPrincipal);
        if (!carpetaPrincipal.exists()) {
            carpetaPrincipal.mkdirs();
        }
        
        // Asegúrate de que la subcarpeta específica existe, si no, créala
        File carpetaVentas = new File(subcarpetaVentas);
        if (!carpetaVentas.exists()) {
            carpetaVentas.mkdirs();
        }
        
        // Obtener la fecha actual y formatearla
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String fechaActual = formatter.format(new Date());
        
        // Generar el nombre del archivo con la fecha
        String reporteventas = "Reporte_Ventas " + fechaActual + ".pdf";
        
        PdfWriter.getInstance(documento, new FileOutputStream(subcarpetaVentas + "/" + reporteventas));
        
       //PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Reporte_Ventas.pdf"));
           // PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/OneDrive/Reporte_Ventas.pdf"));
            //formato al texto
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Reporte creado por \nVendedor Panchi´s\n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de Ventas \n\n");
            documento.open();
            //agregamos los datos
//            documento.add(header);
            documento.add(parrafo);
            float[] columnsWidths = {3, 9, 4, 5, 3};
            PdfPTable tabla = new PdfPTable(columnsWidths);
            tabla.addCell("Codigo");
            tabla.addCell("Cliente");
            tabla.addCell("Tot. Pagar");
            tabla.addCell("Fecha Venta");
            tabla.addCell("Estado");
            try {
                Connection cn = com.panchis.dao.Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select cv.idCabeceraVenta as id, concat(c.nombre, ' ', c.apellido) as cliente, "
                        + "cv.valorPagar as total, cv.fechaVenta as fecha, cv.estado "
                        + "from tb_cabecera_venta as cv, tb_cliente as c "
                        + "where cv.idCliente = c.idCliente;");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                    } while (rs.next());
                    documento.add(tabla);
                }
            } catch (SQLException e) {
                System.out.println("Error 4 en: " + e);
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado");
            //se enviará los datos a tb_aditoria
            registrarAccion("Logró crear un reporte de ventas");
        } catch (DocumentException e) {
            System.out.println("Error 1 en: " + e);
        } catch (FileNotFoundException ex) {
            System.out.println("Error 2 en: " + ex);
        } catch (IOException ex) {
            System.out.println("Error 3 en: " + ex);
        }
    }

    public void ReportesAuditorias() {
        Document documento = new Document(PageSize.A4.rotate()); // Configura la orientación horizontal

        try {
           // String ruta = System.getProperty("user.home");
           // PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/OneDrive/Reporte_Auditorias.pdf"));
           
        // Ruta principal de los reportes
        String rutaPrincipal = "C:/Reportes Panchi's Pizzas";
        // Subcarpeta específica para los reportes de ventas
        String subcarpetaAuditorias = rutaPrincipal + "/Reportes Auditorías";
        
        // Asegúrate de que la carpeta principal existe, si no, créala
        File carpetaPrincipal = new File(rutaPrincipal);
        if (!carpetaPrincipal.exists()) {
            carpetaPrincipal.mkdirs();
        }
        
        // Asegúrate de que la subcarpeta específica existe, si no, créala
        File carpetaAuditorias = new File(subcarpetaAuditorias);
        if (!carpetaAuditorias.exists()) {
            carpetaAuditorias.mkdirs();
        }
        
        // Obtener la fecha actual y formatearla
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String fechaActual = formatter.format(new Date());
        
        // Generar el nombre del archivo con la fecha
        String reporteauditorias = "Reporte_Auditorías " + fechaActual + ".pdf";
        
        PdfWriter.getInstance(documento, new FileOutputStream(subcarpetaAuditorias + "/" + reporteauditorias));
            //formato al texto
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Reporte creado por \n Empleado(a) Panchi´sPizza \n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de Eventos \n\n");
            documento.open();
            //agregamos los datos
//            documento.add(header);
            documento.add(parrafo);

            PdfPTable tabla = new PdfPTable(6);
            tabla.addCell("Codigo");
            tabla.addCell("nombre");
            tabla.addCell("Fecha");
            tabla.addCell("Hora");
            tabla.addCell("Acción");
            tabla.addCell("IP PC");
            try {
                Connection cn = com.panchis.dao.Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select * from tb_auditoria");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));//faltra modificar consuilta para que en vez del id de usuario salga su nombre
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                    } while (rs.next());
                    documento.add(tabla);
                }
            } catch (SQLException e) {
                System.out.println("Error 4 en: " + e);
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado");
            //se enviará los datos a tb_aditoria
            registrarAccion("Logró crear un reporte de eventos");
        } catch (DocumentException e) {
            System.out.println("Error 1 en: " + e);
        } catch (FileNotFoundException ex) {
            System.out.println("Error 2 en: " + ex);
        } catch (IOException ex) {
            System.out.println("Error 3 en: " + ex);
        }
    }

    private void registrarAccion(String accion) {
        try {
            Connection con = com.panchis.dao.Conexion.conectar();
            String sql = "INSERT INTO tb_auditoria (idUsuario, fecha_conexion, hora_conexion, accion_realizada, ip_computadora) "
                    + "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Crud_Usuario.idUsuario); //
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
