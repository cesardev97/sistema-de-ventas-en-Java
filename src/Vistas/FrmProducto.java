/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

import DAO.Crud_Producto;
import controlador.Ctrl_Producto;
import java.io.IOException;

public class FrmProducto extends javax.swing.JPanel {

    public FrmProducto() {

        initComponents();
        Crud_Producto.CargarTablaProductos();
        Crud_Producto.CargarComboCategoria();
        Crud_Producto.CargarComboCategorias();
        //necesario para extraer los métodos del controlador producto
        Ctrl_Producto controlador = new Ctrl_Producto(this);
// inicializar para que se vena en el combo 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        btn_guardar = new javax.swing.JButton();
        txt_cantidad = new javax.swing.JTextField();
        txt_precio = new javax.swing.JTextField();
        txt_discripcion = new javax.swing.JTextField();
        jComboBoxIGV = new javax.swing.JComboBox<>();
        jComboBoxCategoria = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_producto = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txt_gestionar_nombre = new javax.swing.JTextField();
        btn_actualizar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        txt_gestionar_precio = new javax.swing.JTextField();
        txt_gestionar_discripcion = new javax.swing.JTextField();
        txt_gestionar_cantidad = new javax.swing.JTextField();
        jComboBox_gestionarCategoria = new javax.swing.JComboBox<>();
        jComboBox_gestionarIGV = new javax.swing.JComboBox<>();
        btn_buscar = new javax.swing.JButton();
        txt_buscar_idProducto = new javax.swing.JTextField();
        jButton_ExporExcel = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1002, 502));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("NUEVO PRODUCTO");

        txt_nombre.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "NOMBRE ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        btn_guardar.setBackground(new java.awt.Color(0, 0, 0));
        btn_guardar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/disco-flexible.png"))); // NOI18N
        btn_guardar.setText("GUARDAR");
        btn_guardar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_guardar.setContentAreaFilled(false);
        btn_guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_guardar.setFocusPainted(false);

        txt_cantidad.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "CANTIDAD ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        txt_precio.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "PRECIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        txt_discripcion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "DESCRIPCIÓN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jComboBoxIGV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione IGV:", "Sin IGV", "16%", "18%" }));

        jComboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Categorias" }));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("Todos los campos deben ser rellenados");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_cantidad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                            .addComponent(txt_nombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                            .addComponent(txt_precio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                            .addComponent(txt_discripcion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                            .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxIGV, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(43, 43, 43))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_discripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxIGV, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_producto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(jTable_producto);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 64, 690, 230));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("GESTIONAR PRODUCTO ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 21, -1, -1));

        txt_gestionar_nombre.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Nombre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel2.add(txt_gestionar_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 294, 223, 47));

        btn_actualizar.setBackground(new java.awt.Color(0, 0, 0));
        btn_actualizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar.png"))); // NOI18N
        btn_actualizar.setText("ACTUALIZAR");
        btn_actualizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_actualizar.setContentAreaFilled(false);
        btn_actualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_actualizar.setFocusPainted(false);
        jPanel2.add(btn_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 438, 121, 46));

        btn_eliminar.setBackground(new java.awt.Color(0, 0, 0));
        btn_eliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borrar.png"))); // NOI18N
        btn_eliminar.setText("ELIMINAR");
        btn_eliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_eliminar.setContentAreaFilled(false);
        btn_eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_eliminar.setFocusPainted(false);
        jPanel2.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 438, 121, 46));

        txt_gestionar_precio.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Precio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel2.add(txt_gestionar_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 294, 223, 47));

        txt_gestionar_discripcion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Descripción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel2.add(txt_gestionar_discripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 372, 339, 47));

        txt_gestionar_cantidad.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cantidad", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel2.add(txt_gestionar_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 372, 101, 47));

        jComboBox_gestionarCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione categoria:", "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(jComboBox_gestionarCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(497, 384, 206, 37));

        jComboBox_gestionarIGV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione IGV:", "Sin IGV", "16%", "18%" }));
        jPanel2.add(jComboBox_gestionarIGV, new org.netbeans.lib.awtextra.AbsoluteConstraints(497, 298, 206, 37));

        btn_buscar.setBackground(new java.awt.Color(0, 0, 0));
        btn_buscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        btn_buscar.setText("CONSULTAR");
        btn_buscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_buscar.setContentAreaFilled(false);
        btn_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_buscar.setFocusPainted(false);
        jPanel2.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 438, 121, 46));

        txt_buscar_idProducto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Digita ID para Buscar Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel2.add(txt_buscar_idProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 427, 191, 56));

        jButton_ExporExcel.setBackground(new java.awt.Color(255, 204, 0));
        jButton_ExporExcel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton_ExporExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ex.png"))); // NOI18N
        jButton_ExporExcel.setText("EXPORTAR EXCEL");
        jButton_ExporExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ExporExcelActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_ExporExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ExporExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ExporExcelActionPerformed
        ExportarExcel obj;
        try {
            obj = new ExportarExcel();
            obj.exportarExcel(jTable_producto);
        } catch (IOException ex) {
            System.out.println("Erro " + ex);
        }
    }//GEN-LAST:event_jButton_ExporExcelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btn_actualizar;
    public static javax.swing.JButton btn_buscar;
    public static javax.swing.JButton btn_eliminar;
    public static javax.swing.JButton btn_guardar;
    private javax.swing.JButton jButton_ExporExcel;
    public static javax.swing.JComboBox<String> jComboBoxCategoria;
    public static javax.swing.JComboBox<String> jComboBoxIGV;
    public static javax.swing.JComboBox<String> jComboBox_gestionarCategoria;
    public static javax.swing.JComboBox<String> jComboBox_gestionarIGV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_producto;
    public static javax.swing.JTextField txt_buscar_idProducto;
    public static javax.swing.JTextField txt_cantidad;
    public static javax.swing.JTextField txt_discripcion;
    public static javax.swing.JTextField txt_gestionar_cantidad;
    public static javax.swing.JTextField txt_gestionar_discripcion;
    public static javax.swing.JTextField txt_gestionar_nombre;
    public static javax.swing.JTextField txt_gestionar_precio;
    public static javax.swing.JTextField txt_nombre;
    public static javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables
}
