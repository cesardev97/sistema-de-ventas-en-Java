/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.panchis.vistas;

import com.panchis.dao.Conexion;
import com.panchis.dao.Crud_Usuario;
import static com.panchis.dao.Crud_Usuario.idUsuario;
import static com.panchis.vistas.Dashboard.Contenido;
import static com.panchis.vistas.Dashboard.ShowPanel;
import com.panchis.controlador.Ctrl_Dashboard;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Jean
 */
//<a href="https://www.flaticon.es/iconos-gratis/pizza" title="pizza iconos">Pizza iconos creados por Freepik - Flaticon</a>
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    //singleton
    private static Dashboard instance;
    public int idRol;

    public Dashboard() {
        initComponents();
        Ctrl_Dashboard controlador = new Ctrl_Dashboard(this);

        this.idRol = 0; // Valor predeterminado del rol
        FrmMenu p0 = new FrmMenu();
        ShowPanel(p0);
        Contenido.removeAll();
        Contenido.add(p0, BorderLayout.CENTER);
        Contenido.revalidate();
        Contenido.repaint();
        setIconImage(new ImageIcon(getClass().getResource("/com/panchis/imagenes/logo-panchis-amarillo.png")).getImage());
        this.setTitle("Menú Panchi's Pizza");

    }

    public void setNombreUsuario(String nombreUsuario) {
        txt_nombreUsuario.setText("Usuario: " + nombreUsuario + "");

    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("/com/panchis/imagenes/logo panchis 50 x50 px.png"));
        return retValue;
    }

    public static Dashboard getInstance() {
        if (instance == null) {
            instance = new Dashboard();
        }
        return instance;
    }

    public static void setIdRol(int idRol) {
        getInstance().idRol = idRol;
        getInstance().habilitarBotonesSegunRol();
    }

    public void habilitarBotonesSegunRol() {
        // Si el I del rol es 1 (ADMIN), habilitar todos los botones
        // Si el Id del rol es 2 (CAJERO), deshabilitar botones de configuración, etc.
        if (idRol == 1) {
        } else if (idRol == 2) {
            btnUsuario.setEnabled(false);
            btnCategoria.setEnabled(false);
        } else if (idRol == 3) {
            btnUsuario.setEnabled(false);
            btnCategoria.setEnabled(false);
            btnCliente.setEnabled(false);
            btnFacturar.setEnabled(false);
            btnHistorial.setEnabled(false);
            btnProducto.setEnabled(false);
            btnReportes.setEnabled(false);
        }
    }

//    private FrmUsuario getFrmUsuarioInstance() {
//        // Implementa este método para retornar la instancia correcta de FrmUsuario
//        // Esto dependerá de cómo estás manejando tus formularios en tu aplicación
//        return new FrmUsuario(); // Esto es solo un ejemplo
//    }
//    //ICONO DEL SISTEMA
//    @Override
//    public Image getIconImage() {
//        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/logo panchis 50 x50 px.png"));
//        return retValue;
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        Titulo_header = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_bienvenida = new javax.swing.JLabel();
        txt_nombreUsuario = new javax.swing.JLabel();
        Menu = new javax.swing.JPanel();
        btnUsuario = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        Separator2 = new javax.swing.JSeparator();
        Separator1 = new javax.swing.JSeparator();
        btnProducto = new javax.swing.JButton();
        Separator3 = new javax.swing.JSeparator();
        Separator4 = new javax.swing.JSeparator();
        btnCategoria = new javax.swing.JButton();
        Separator5 = new javax.swing.JSeparator();
        btnFacturar = new javax.swing.JButton();
        Separator6 = new javax.swing.JSeparator();
        btnReportes = new javax.swing.JButton();
        Separator7 = new javax.swing.JSeparator();
        Separator8 = new javax.swing.JSeparator();
        btnHistorial = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        Separator9 = new javax.swing.JSeparator();
        btnCliente = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Contenido = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Background.setBackground(new java.awt.Color(255, 255, 255));
        Background.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Background.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Header.setBackground(new java.awt.Color(255, 204, 0));
        Header.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        Titulo_header.setBackground(new java.awt.Color(0, 0, 0));
        Titulo_header.setFont(new java.awt.Font("Segoe UI Black", 3, 24)); // NOI18N
        Titulo_header.setText("SISTEMA DE VENTA ");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/panchis/imagenes/logo panchis 80x80 px.png"))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/panchis/imagenes/Pig (1).png"))); // NOI18N

        txt_bienvenida.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_bienvenida.setText("BIENVENIDO(A):");

        txt_nombreUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_nombreUsuario.setText("nombre de quien se logea");

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(349, 349, 349)
                .addComponent(Titulo_header)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(HeaderLayout.createSequentialGroup()
                        .addComponent(txt_bienvenida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(136, 136, 136))
                    .addGroup(HeaderLayout.createSequentialGroup()
                        .addComponent(txt_nombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jLabel1))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(Titulo_header)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(HeaderLayout.createSequentialGroup()
                        .addComponent(txt_bienvenida)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nombreUsuario))))
        );

        Menu.setBackground(new java.awt.Color(255, 204, 0));
        Menu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Menu.setForeground(new java.awt.Color(51, 255, 255));
        Menu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnUsuario.setBackground(new java.awt.Color(0, 0, 0));
        btnUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/panchis/imagenes/profile-user.png"))); // NOI18N
        btnUsuario.setText("USUARIO");
        btnUsuario.setBorder(null);
        btnUsuario.setBorderPainted(false);
        btnUsuario.setContentAreaFilled(false);
        btnUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuario.setFocusPainted(false);

        btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/panchis/imagenes/power.png"))); // NOI18N
        btnSalir.setText("CERRAR SESION");
        btnSalir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnSalir.setContentAreaFilled(false);
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setFocusPainted(false);

        Separator2.setBackground(new java.awt.Color(255, 204, 0));
        Separator2.setForeground(new java.awt.Color(0, 0, 0));

        Separator1.setBackground(new java.awt.Color(255, 204, 0));
        Separator1.setForeground(new java.awt.Color(0, 0, 0));

        btnProducto.setBackground(new java.awt.Color(0, 0, 0));
        btnProducto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/panchis/imagenes/box.png"))); // NOI18N
        btnProducto.setText("PRODUCTO");
        btnProducto.setBorder(null);
        btnProducto.setBorderPainted(false);
        btnProducto.setContentAreaFilled(false);
        btnProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProducto.setFocusPainted(false);

        Separator3.setBackground(new java.awt.Color(255, 204, 0));
        Separator3.setForeground(new java.awt.Color(0, 0, 0));

        Separator4.setBackground(new java.awt.Color(255, 204, 0));
        Separator4.setForeground(new java.awt.Color(0, 0, 0));

        btnCategoria.setBackground(new java.awt.Color(0, 0, 0));
        btnCategoria.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/panchis/imagenes/categorization.png"))); // NOI18N
        btnCategoria.setText("CATEGORIA");
        btnCategoria.setBorder(null);
        btnCategoria.setBorderPainted(false);
        btnCategoria.setContentAreaFilled(false);
        btnCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCategoria.setFocusPainted(false);

        Separator5.setBackground(new java.awt.Color(255, 204, 0));
        Separator5.setForeground(new java.awt.Color(0, 0, 0));

        btnFacturar.setBackground(new java.awt.Color(0, 0, 0));
        btnFacturar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFacturar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/panchis/imagenes/buy-button.png"))); // NOI18N
        btnFacturar.setText("FACTURAR");
        btnFacturar.setBorder(null);
        btnFacturar.setBorderPainted(false);
        btnFacturar.setContentAreaFilled(false);
        btnFacturar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFacturar.setFocusPainted(false);

        Separator6.setBackground(new java.awt.Color(255, 204, 0));
        Separator6.setForeground(new java.awt.Color(0, 0, 0));

        btnReportes.setBackground(new java.awt.Color(0, 0, 0));
        btnReportes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/panchis/imagenes/analytics.png"))); // NOI18N
        btnReportes.setText("REPORTES");
        btnReportes.setBorder(null);
        btnReportes.setBorderPainted(false);
        btnReportes.setContentAreaFilled(false);
        btnReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReportes.setFocusPainted(false);
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });

        Separator7.setBackground(new java.awt.Color(255, 204, 0));
        Separator7.setForeground(new java.awt.Color(0, 0, 0));

        Separator8.setBackground(new java.awt.Color(255, 204, 0));
        Separator8.setForeground(new java.awt.Color(0, 0, 0));

        btnHistorial.setBackground(new java.awt.Color(0, 0, 0));
        btnHistorial.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/panchis/imagenes/refresh.png"))); // NOI18N
        btnHistorial.setText("HISTORIAL");
        btnHistorial.setBorder(null);
        btnHistorial.setBorderPainted(false);
        btnHistorial.setContentAreaFilled(false);
        btnHistorial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHistorial.setFocusPainted(false);

        btnMenu.setBackground(new java.awt.Color(0, 0, 0));
        btnMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/panchis/imagenes/menu.png"))); // NOI18N
        btnMenu.setText("MENU DEL DÍA");
        btnMenu.setBorder(null);
        btnMenu.setBorderPainted(false);
        btnMenu.setContentAreaFilled(false);
        btnMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenu.setFocusPainted(false);

        Separator9.setBackground(new java.awt.Color(255, 204, 0));
        Separator9.setForeground(new java.awt.Color(0, 0, 0));
        Separator9.setEnabled(false);

        btnCliente.setBackground(new java.awt.Color(0, 0, 0));
        btnCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/panchis/imagenes/costumer.png"))); // NOI18N
        btnCliente.setText("CLIENTE");
        btnCliente.setBorder(null);
        btnCliente.setBorderPainted(false);
        btnCliente.setContentAreaFilled(false);
        btnCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCliente.setFocusPainted(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        jLabel3.setText("Versión 7.3.14.06.24");

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
            .addGroup(MenuLayout.createSequentialGroup()
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MenuLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Separator1)
                                    .addComponent(Separator2)
                                    .addComponent(btnUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)))
                            .addGroup(MenuLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(Separator9)
                                    .addComponent(Separator8, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Separator7, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Separator6, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Separator5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Separator4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Separator3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnFacturar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnHistorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)))))
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Separator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(Separator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Separator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Separator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Separator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFacturar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Separator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Separator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Separator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Separator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(btnSalir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        Contenido.setBackground(new java.awt.Color(204, 204, 204));
        Contenido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Contenido.setPreferredSize(new java.awt.Dimension(1010, 500));

        javax.swing.GroupLayout ContenidoLayout = new javax.swing.GroupLayout(Contenido);
        Contenido.setLayout(ContenidoLayout);
        ContenidoLayout.setHorizontalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1008, Short.MAX_VALUE)
        );
        ContenidoLayout.setVerticalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout BackgroundLayout = new javax.swing.GroupLayout(Background);
        Background.setLayout(BackgroundLayout);
        BackgroundLayout.setHorizontalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundLayout.createSequentialGroup()
                .addGap(0, 200, Short.MAX_VALUE)
                .addComponent(Contenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        BackgroundLayout.setVerticalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Contenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReportesActionPerformed

    /**
     * @param args the command line arguments
     */
//    esto se reemplazará con el de abajo 
    /// se comentó para que el main sea el login (no hay problemas el login ahora es el main)
//    public static void main(String args[]) {
//        // Invocar la ventana del panel de control
//        java.awt.EventQueue.invokeLater(() -> {
//            new Dashboard().setVisible(true);
//        });
//    }
    //////////////////////////7
//    public static void main(String args[]) {
//        // Invocar la ventana del panel de control
//        java.awt.EventQueue.invokeLater(() -> {
//            new Dashboard(1).setVisible(true); // Establecer un ID de rol predeterminado
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    public static javax.swing.JPanel Contenido;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Menu;
    private javax.swing.JSeparator Separator1;
    private javax.swing.JSeparator Separator2;
    private javax.swing.JSeparator Separator3;
    private javax.swing.JSeparator Separator4;
    private javax.swing.JSeparator Separator5;
    private javax.swing.JSeparator Separator6;
    private javax.swing.JSeparator Separator7;
    private javax.swing.JSeparator Separator8;
    private javax.swing.JSeparator Separator9;
    private javax.swing.JLabel Titulo_header;
    public static javax.swing.JButton btnCategoria;
    public static javax.swing.JButton btnCliente;
    public static javax.swing.JButton btnFacturar;
    public static javax.swing.JButton btnHistorial;
    public static javax.swing.JButton btnMenu;
    public static javax.swing.JButton btnProducto;
    public static javax.swing.JButton btnReportes;
    public static javax.swing.JButton btnSalir;
    public static javax.swing.JButton btnUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel txt_bienvenida;
    public static javax.swing.JLabel txt_nombreUsuario;
    // End of variables declaration//GEN-END:variables

    //nos sirve para cambiar entre jpanels cuando presioanmos un boton en el dashboardd
    public static void ShowPanel(JPanel p) { //borre el static

        p.setSize(1010, 500);// forzamos a darle el tamaño para evitar errores
        p.setLocation(0, 0); //centra
        Contenido.removeAll();
        Contenido.add(p, BorderLayout.CENTER);
        Contenido.revalidate();
        Contenido.repaint();

    }

}
