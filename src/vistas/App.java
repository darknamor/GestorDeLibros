/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import static controlador.funciones.cargarContenidoTabla;
import vistas.Libros.AgregarLibros;
import vistas.Libros.BuscarLibros;
import static controlador.funciones.dessubrayar;
import static controlador.funciones.subrayar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.conectar;
import modelo.consultar;
import vistas.Libros.EditarLibros;
import vistas.Libros.EliminarLibros;

/**
 *
 * @author tiode
 */
public class App extends javax.swing.JFrame {
    private int lagl = 0;
    private String idl[][];
    boolean activo=false;
    /**
     * Creates new form App
     */
    public App() {
        initComponents();
        
        //menu_bar.setVisible(false);
        
        contenido.setVisible(false);
        jTabla.setVisible(false);
        contenido_tabla.setVisible(false);
        //contenido_editar.setVisible(false);
        side_titulo1.setText("FastDevlopement");
        //cargarContenidoTabla("a","b","c","d","e",contenido_tabla);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem8 = new javax.swing.JMenuItem();
        panel = new javax.swing.JPanel();
        separador_titulo2 = new javax.swing.JSeparator();
        side_usuario = new javax.swing.JPanel();
        side_usuario_nombre = new javax.swing.JLabel();
        side_usuario_salir = new javax.swing.JLabel();
        side_usuario_icono = new javax.swing.JLabel();
        contenido = new javax.swing.JPanel();
        jTabla = new javax.swing.JScrollPane();
        contenido_tabla = new javax.swing.JTable();
        subTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        side_logo = new javax.swing.JLabel();
        side_titulo1 = new javax.swing.JLabel();
        menu_bar = new javax.swing.JMenuBar();
        menu_libros = new javax.swing.JMenu();
        agregar_libros = new javax.swing.JMenuItem();
        mostrar_libros = new javax.swing.JMenuItem();
        editar_libros = new javax.swing.JMenuItem();
        eliminar_libros = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        jMenuItem8.setText("jMenuItem8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setBackground(new java.awt.Color(58, 71, 80));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        separador_titulo2.setBackground(new java.awt.Color(204, 204, 204));
        separador_titulo2.setForeground(new java.awt.Color(204, 204, 204));
        panel.add(separador_titulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 620, 10));

        side_usuario.setBackground(new java.awt.Color(58, 71, 80));
        side_usuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        side_usuario_nombre.setBackground(new java.awt.Color(204, 204, 204));
        side_usuario_nombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        side_usuario_nombre.setForeground(new java.awt.Color(204, 204, 204));
        side_usuario_nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        side_usuario_nombre.setText("Jonathan González");
        side_usuario.add(side_usuario_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 130, -1));

        side_usuario_salir.setBackground(new java.awt.Color(204, 204, 204));
        side_usuario_salir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        side_usuario_salir.setForeground(new java.awt.Color(204, 204, 204));
        side_usuario_salir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        side_usuario_salir.setText("Salir");
        side_usuario_salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        side_usuario_salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                side_usuario_salirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                side_usuario_salirMouseExited(evt);
            }
        });
        side_usuario.add(side_usuario_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 130, -1));

        side_usuario_icono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        side_usuario_icono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/recursos/icons8_Circled_User_Male_Skin_Type_4_96px.png"))); // NOI18N
        side_usuario.add(side_usuario_icono, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 90));

        panel.add(side_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 130, 140));

        contenido.setBackground(new java.awt.Color(58, 71, 80));
        contenido.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabla.setBorder(null);

        contenido_tabla.setAutoCreateRowSorter(true);
        contenido_tabla.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        contenido_tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titulo", "Autores", "Numero de serie", "ISBN", "Numero de paginas", "Precio Referencia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        contenido_tabla.setGridColor(new java.awt.Color(255, 255, 255));
        contenido_tabla.setIntercellSpacing(new java.awt.Dimension(5, 5));
        contenido_tabla.setRowHeight(25);
        contenido_tabla.setSelectionBackground(new java.awt.Color(136, 204, 67));
        jTabla.setViewportView(contenido_tabla);
        if (contenido_tabla.getColumnModel().getColumnCount() > 0) {
            contenido_tabla.getColumnModel().getColumn(3).setPreferredWidth(20);
        }

        contenido.add(jTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 670, 350));

        subTitulo.setBackground(new java.awt.Color(204, 204, 204));
        subTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        subTitulo.setForeground(new java.awt.Color(204, 204, 204));
        subTitulo.setText("SubTitulo");
        contenido.add(subTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 30));

        panel.add(contenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 770, 450));

        jPanel1.setBackground(new java.awt.Color(58, 71, 80));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        side_logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        side_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/recursos/icons8_Save_the_Children_75px.png"))); // NOI18N
        jPanel1.add(side_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 70));

        side_titulo1.setBackground(new java.awt.Color(204, 204, 204));
        side_titulo1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        side_titulo1.setForeground(new java.awt.Color(255, 255, 255));
        side_titulo1.setText("Titulo");
        jPanel1.add(side_titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 270, -1));

        panel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 390, 80));

        menu_libros.setText("   Libros    ");
        menu_libros.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        agregar_libros.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        agregar_libros.setText("Agregar Libro");
        agregar_libros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_librosActionPerformed(evt);
            }
        });
        menu_libros.add(agregar_libros);

        mostrar_libros.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK));
        mostrar_libros.setText("Mostrar Libros");
        mostrar_libros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrar_librosActionPerformed(evt);
            }
        });
        menu_libros.add(mostrar_libros);

        editar_libros.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK));
        editar_libros.setText("Editar Libros");
        editar_libros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editar_librosActionPerformed(evt);
            }
        });
        menu_libros.add(editar_libros);

        eliminar_libros.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK));
        eliminar_libros.setText("Eliminar Libros");
        eliminar_libros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminar_librosActionPerformed(evt);
            }
        });
        menu_libros.add(eliminar_libros);

        menu_bar.add(menu_libros);

        jMenu2.setText("   Autores      ");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        menu_bar.add(jMenu2);

        jMenu3.setText("   Editoriales      ");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        menu_bar.add(jMenu3);

        jMenu4.setText("   Venta de Libros   ");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        menu_bar.add(jMenu4);

        setJMenuBar(menu_bar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 787, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregar_librosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_librosActionPerformed
        
        AgregarLibros content = new AgregarLibros();
        content.setVisible(true);
        content.pack();
        content.setLocationRelativeTo(null);
        content.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
        side_titulo1.setText("FastDevlopement");
        subTitulo.setVisible(false);
        contenido.setVisible(false);
        contenido_tabla.setVisible(false);
    }//GEN-LAST:event_agregar_librosActionPerformed

    private void mostrar_librosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrar_librosActionPerformed
        
        
        subTitulo.setText("Mostrar Libros");
        side_titulo1.setText("Libros");
        subTitulo.setVisible(true);
        subTitulo.setText("Mostrar Libros");
        
        contenido.setVisible(true);
        jTabla.setVisible(true);
        contenido_tabla.setVisible(true);
        //contenido_editar.setVisible(false);
        if(activo==false){
            DefaultTableModel model = (DefaultTableModel) contenido_tabla.getModel();
            model.setRowCount(0);
            activo=true;
            conectar conex = new conectar();
            Connection reg = conex.conexion();
            ResultSet rsml;
            String consulta = "SELECT A.*,B.autores_nombre,B.autores_apellido_paterno FROM fastdevelopment.libros as A inner join fastdevelopment.autores as B on A.libros_autores=B.autores_id where libros_estado=1; ";
            consultar consul = new consultar(reg, consulta);
            if (consul.getError() == null) {
                rsml = consul.getResultado();
                try {
                    while (rsml.next()) {
                        lagl++;
                    }
                    idl = new String[lagl][6];
                    System.out.println("LARGO LIBROS:" + lagl);
                    for (int i = 1; i < lagl + 1; i++) {
                        rsml.absolute(i);
                        idl[(i - 1)][0] = (String) rsml.getObject("libros_titulo");                    
                        idl[(i - 1)][1] = "" + rsml.getObject("autores_nombre")+" "+ rsml.getObject("autores_apellido_paterno");
                        idl[(i - 1)][2] = (String) rsml.getObject("libros_numero_serie");
                        idl[(i - 1)][3] = "" + rsml.getObject("libros_isbn");
                        idl[(i - 1)][4] = (String) rsml.getObject("libros_numero_paginas");
                        idl[(i - 1)][5] = (String) rsml.getObject("libros_precio_referencia");
                        //System.out.println(id[i][1]);
                        //jComboBoxAutores.addItem("" + idl[(i - 1)][0] + " " + idl[(i - 1)][2]);
                        cargarContenidoTabla(idl[(i - 1)][0],idl[(i - 1)][1],idl[(i - 1)][2],idl[(i - 1)][3],idl[(i - 1)][4],idl[(i - 1)][5],contenido_tabla);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(AgregarLibros.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            contenido.setVisible(true);
            contenido_tabla.setVisible(true);
        }
        
    }//GEN-LAST:event_mostrar_librosActionPerformed

    private void side_usuario_salirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_side_usuario_salirMouseEntered
        subrayar(side_usuario_salir);
    }//GEN-LAST:event_side_usuario_salirMouseEntered

    private void side_usuario_salirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_side_usuario_salirMouseExited
        dessubrayar(side_usuario_salir);
    }//GEN-LAST:event_side_usuario_salirMouseExited

    private void editar_librosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editar_librosActionPerformed
        subTitulo.setText("Editar Libros");
        side_titulo1.setText("Libros");
        subTitulo.setVisible(true);
        subTitulo.setText("Editar Libros");
        
        contenido.setVisible(true);
        jTabla.setVisible(false);
        EditarLibros content = new EditarLibros();
        content.setVisible(true);
        content.pack();
        content.setLocationRelativeTo(null);
        content.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
        
    }//GEN-LAST:event_editar_librosActionPerformed

    private void eliminar_librosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminar_librosActionPerformed
        // TODO add your handling code here:
         subTitulo.setText("Eliminar Libros");
        side_titulo1.setText("Libros");
        subTitulo.setVisible(true);
        subTitulo.setText("Eliminar Libros");
        
        contenido.setVisible(true);
        jTabla.setVisible(false);
        EliminarLibros content = new EliminarLibros();
        content.setVisible(true);
        content.pack();
        content.setLocationRelativeTo(null);
        content.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_eliminar_librosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem agregar_libros;
    private javax.swing.JPanel contenido;
    private javax.swing.JTable contenido_tabla;
    private javax.swing.JMenuItem editar_libros;
    private javax.swing.JMenuItem eliminar_libros;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jTabla;
    private javax.swing.JMenuBar menu_bar;
    private javax.swing.JMenu menu_libros;
    private javax.swing.JMenuItem mostrar_libros;
    private javax.swing.JPanel panel;
    private javax.swing.JSeparator separador_titulo2;
    private javax.swing.JLabel side_logo;
    private javax.swing.JLabel side_titulo1;
    private javax.swing.JPanel side_usuario;
    private javax.swing.JLabel side_usuario_icono;
    private javax.swing.JLabel side_usuario_nombre;
    private javax.swing.JLabel side_usuario_salir;
    private javax.swing.JLabel subTitulo;
    // End of variables declaration//GEN-END:variables
}
