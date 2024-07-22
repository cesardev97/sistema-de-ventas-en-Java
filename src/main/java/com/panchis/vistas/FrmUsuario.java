/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.panchis.vistas;
import com.panchis.dao.Crud_Usuario;
import com.panchis.controlador.Ctrl_Usuario;
import java.io.IOException;

/**
 *
 * @author Jean
 */
public class FrmUsuario extends javax.swing.JPanel {

    /**
     * Creates new form FrmUsuario
     */
    public FrmUsuario() {
        initComponents();
        //ncesario para cargar la tabla de usuarioss
        Crud_Usuario.CargarTablaUsuarios() ;
        //ncesario para ejecutar los métods del controlador usuario
        Ctrl_Usuario controlador = new Ctrl_Usuario(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_apellido = new javax.swing.JTextField();
        txt_usuario = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        btn_guardar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        btn_NoShow = new javax.swing.JButton();
        btn_Show = new javax.swing.JButton();
        txt_dni = new javax.swing.JTextField();
        jComboBoxRol = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txt_gestionar_nombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_usuario = new javax.swing.JTable();
        btn_eliminar = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        txt_gestionar_apellido = new javax.swing.JTextField();
        txt_gestionar_telefono = new javax.swing.JTextField();
        txt_gestionar_usuario = new javax.swing.JTextField();
        txt_gestionar_dni = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        txt_buscar_dniUsuario = new javax.swing.JTextField();
        btn_auditoria = new javax.swing.JButton();
        btn_Roles = new javax.swing.JButton();
        jComboBox_gestionarRol = new javax.swing.JComboBox<>();
        btn_ShowGestionar = new javax.swing.JButton();
        btn_NoShowGestionar = new javax.swing.JButton();
        txt_gestionar_password = new javax.swing.JPasswordField();
        jButton_ExporExcel = new javax.swing.JButton();

        setFocusable(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("NUEVO USUARIO");

        txt_nombre.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "NOMBRE"));
        txt_nombre.setPreferredSize(new java.awt.Dimension(50, 50));

        txt_apellido.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "APELLIDO"));
        txt_apellido.setPreferredSize(new java.awt.Dimension(50, 50));

        txt_usuario.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "USUARIO"));
        txt_usuario.setPreferredSize(new java.awt.Dimension(50, 50));

        txt_telefono.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "TELÉFONO"));

        btn_guardar.setBackground(new java.awt.Color(255, 204, 51));
        btn_guardar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/panchis/imagenes/disco-flexible.png"))); // NOI18N
        btn_guardar.setText("GUARDAR");
        btn_guardar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_guardar.setBorderPainted(false);
        btn_guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("Todos los campos deben ser rellenados");

        txt_password.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "CONTRASEÑA"));

        btn_NoShow.setBackground(new java.awt.Color(255, 204, 0));
        btn_NoShow.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_NoShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/panchis/imagenes/ojonover.png"))); // NOI18N
        btn_NoShow.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btn_NoShow.setBorderPainted(false);
        btn_NoShow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btn_Show.setBackground(new java.awt.Color(255, 204, 0));
        btn_Show.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_Show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/panchis/imagenes/ojover.png"))); // NOI18N
        btn_Show.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btn_Show.setBorderPainted(false);
        btn_Show.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txt_dni.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "DNI"));
        txt_dni.setPreferredSize(new java.awt.Dimension(50, 50));

        jComboBoxRol.setBackground(new java.awt.Color(255, 204, 0));
        jComboBoxRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione ROL:", "ADMIN", "CAJERO", "MESERO" }));
        jComboBoxRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRolActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_apellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_telefono, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_password)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_NoShow, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_Show, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(30, 30, 30))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_dni, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_dni, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxRol, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btn_NoShow, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_Show, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 500));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel8.setText("GESTIONAR USUARIO ");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, -1));

        txt_gestionar_nombre.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Nombre"));
        txt_gestionar_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_gestionar_nombreActionPerformed(evt);
            }
        });
        jPanel2.add(txt_gestionar_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 286, 178, 56));

        jTable_usuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "N°", "Nombre", "Apellido"
            }
        ));
        jScrollPane1.setViewportView(jTable_usuario);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 85, 713, 183));

        btn_eliminar.setBackground(new java.awt.Color(0, 0, 0));
        btn_eliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/panchis/imagenes/borrar.png"))); // NOI18N
        btn_eliminar.setText("ELIMINAR");
        btn_eliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_eliminar.setContentAreaFilled(false);
        btn_eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_eliminar.setFocusPainted(false);
        jPanel2.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(241, 429, 121, 46));

        btn_actualizar.setBackground(new java.awt.Color(255, 204, 0));
        btn_actualizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/panchis/imagenes/actualizar.png"))); // NOI18N
        btn_actualizar.setText("ACTUALIZAR");
        btn_actualizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_actualizar.setContentAreaFilled(false);
        btn_actualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_actualizar.setFocusPainted(false);
        jPanel2.add(btn_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 429, 121, 46));

        txt_gestionar_apellido.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Apellido"));
        jPanel2.add(txt_gestionar_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(241, 286, 198, 54));

        txt_gestionar_telefono.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Teléfono"));
        jPanel2.add(txt_gestionar_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 354, 178, 53));

        txt_gestionar_usuario.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Usuario"));
        jPanel2.add(txt_gestionar_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(241, 354, 198, 53));

        txt_gestionar_dni.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dni"));
        jPanel2.add(txt_gestionar_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 286, 137, 54));

        btn_buscar.setBackground(new java.awt.Color(0, 0, 0));
        btn_buscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/panchis/imagenes/lupa.png"))); // NOI18N
        btn_buscar.setText("CONSULTAR");
        btn_buscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_buscar.setContentAreaFilled(false);
        btn_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_buscar.setFocusPainted(false);
        jPanel2.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(428, 429, 121, 46));

        txt_buscar_dniUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Digita DNI para Buscar usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel2.add(txt_buscar_dniUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(567, 419, 193, 54));

        btn_auditoria.setBackground(new java.awt.Color(255, 204, 0));
        btn_auditoria.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_auditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/panchis/imagenes/auditoria.png"))); // NOI18N
        btn_auditoria.setText("AUDITORIAS");
        btn_auditoria.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btn_auditoria.setBorderPainted(false);
        btn_auditoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(btn_auditoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(634, 26, 126, 39));

        btn_Roles.setBackground(new java.awt.Color(255, 204, 0));
        btn_Roles.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_Roles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/panchis/imagenes/project-manager.png"))); // NOI18N
        btn_Roles.setText("ROLES");
        btn_Roles.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btn_Roles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Roles.setEnabled(false);
        btn_Roles.setFocusPainted(false);
        btn_Roles.setFocusable(false);
        jPanel2.add(btn_Roles, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 26, 118, 39));

        jComboBox_gestionarRol.setBackground(new java.awt.Color(255, 204, 0));
        jComboBox_gestionarRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione ROL:", "ADMIN", "CAJERO", "MESERO" }));
        jComboBox_gestionarRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_gestionarRolActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox_gestionarRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(606, 286, 154, 45));

        btn_ShowGestionar.setBackground(new java.awt.Color(255, 204, 0));
        btn_ShowGestionar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_ShowGestionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/panchis/imagenes/ojover.png"))); // NOI18N
        btn_ShowGestionar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btn_ShowGestionar.setBorderPainted(false);
        btn_ShowGestionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(btn_ShowGestionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 367, 40, 40));

        btn_NoShowGestionar.setBackground(new java.awt.Color(255, 204, 0));
        btn_NoShowGestionar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_NoShowGestionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/panchis/imagenes/ojonover.png"))); // NOI18N
        btn_NoShowGestionar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btn_NoShowGestionar.setBorderPainted(false);
        btn_NoShowGestionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(btn_NoShowGestionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(669, 367, 45, 40));

        txt_gestionar_password.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Contraseña"));
        jPanel2.add(txt_gestionar_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(458, 354, 193, 53));

        jButton_ExporExcel.setBackground(new java.awt.Color(255, 204, 0));
        jButton_ExporExcel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton_ExporExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/panchis/imagenes/Ex.png"))); // NOI18N
        jButton_ExporExcel.setText("EXPORTAR EXCEL");
        jButton_ExporExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ExporExcelActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_ExporExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, -1, 40));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 790, 500));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void jComboBoxRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxRolActionPerformed

    private void jComboBox_gestionarRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_gestionarRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_gestionarRolActionPerformed

    private void txt_gestionar_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_gestionar_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_gestionar_nombreActionPerformed

    private void jButton_ExporExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ExporExcelActionPerformed
        ExportarExcel obj;
        try {
            obj = new ExportarExcel();
            obj.exportarExcel(jTable_usuario);
        } catch (IOException ex) {
            System.out.println("Erro " + ex);
        }
    }//GEN-LAST:event_jButton_ExporExcelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btn_NoShow;
    public static javax.swing.JButton btn_NoShowGestionar;
    public static javax.swing.JButton btn_Roles;
    public static javax.swing.JButton btn_Show;
    public static javax.swing.JButton btn_ShowGestionar;
    public javax.swing.JButton btn_actualizar;
    public static javax.swing.JButton btn_auditoria;
    public static javax.swing.JButton btn_buscar;
    public javax.swing.JButton btn_eliminar;
    public javax.swing.JButton btn_guardar;
    public static javax.swing.JButton jButton_ExporExcel;
    public static javax.swing.JComboBox<String> jComboBoxRol;
    public static javax.swing.JComboBox<String> jComboBox_gestionarRol;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel8;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_usuario;
    public static javax.swing.JTextField txt_apellido;
    public static javax.swing.JTextField txt_buscar_dniUsuario;
    public static javax.swing.JTextField txt_dni;
    public static javax.swing.JTextField txt_gestionar_apellido;
    public static javax.swing.JTextField txt_gestionar_dni;
    public static javax.swing.JTextField txt_gestionar_nombre;
    public static javax.swing.JPasswordField txt_gestionar_password;
    public static javax.swing.JTextField txt_gestionar_telefono;
    public static javax.swing.JTextField txt_gestionar_usuario;
    public static javax.swing.JTextField txt_nombre;
    public static javax.swing.JPasswordField txt_password;
    public static javax.swing.JTextField txt_telefono;
    public static javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
