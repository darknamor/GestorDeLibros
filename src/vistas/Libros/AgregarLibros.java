/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas.Libros;

import static controlador.funciones.limpiarCaja;
import java.awt.Window;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import modelo.conectar;
import modelo.consultar;
import vistas.App;

/**
 *
 * @author tiode
 */
public class AgregarLibros extends javax.swing.JFrame {
    private int lagu = 0;
    private String idu[][];
    private int lage = 0;
    private String ide[][];
    private int lagc = 0;
    private String idc[][];
    private int lagi = 0;
    private String idi[][];
    
    String id_autor_seleccionado = "";
    String id_editorial_seleccionado = "";
    String id_categoria_seleccionado = "";
    String id_idioma_seleccionado = "";
    /**
     * Creates new form GestionarLibros
     */
    public AgregarLibros() {
        initComponents();
        conectar conex = new conectar();
        Connection reg = conex.conexion();
        ResultSet rs;
        String consulta = "SELECT * FROM fastdevelopment.autores where autores_estado=1 ";
        consultar consul = new consultar(reg, consulta);
        if (consul.getError() == null) {
            rs = consul.getResultado();
            try {
                while (rs.next()) {
                    lagu++;
                }
                idu = new String[lagu][5];
                System.out.println("LARGO AUTORES:" + lagu);
                for (int i = 1; i < lagu + 1; i++) {
                    rs.absolute(i);
                    idu[(i - 1)][0] = (String) rs.getObject("autores_nombre");
                    idu[(i - 1)][2] = (String) rs.getObject("autores_apellido_paterno");
                    idu[(i - 1)][1] = "" + rs.getObject("autores_id");
                    idu[(i - 1)][3] = "" + rs.getObject("autores_nacionalidad");
                    idu[(i - 1)][4] = (String) rs.getObject("autores_apellido_materno");
                    //System.out.println(id[i][1]);
                    jComboBoxAutores.addItem("" + idu[(i - 1)][0] + " " + idu[(i - 1)][2]);
                }
            } catch (SQLException ex) {
                Logger.getLogger(AgregarLibros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        consulta = "SELECT * FROM fastdevelopment.categorias where categorias_estado=1;";
        consultar consulna = new consultar(reg, consulta);
        if (consulna.getError() == null) {
            rs = consulna.getResultado();
            try {
                while (rs.next()) {
                    lagc++;
                }
                idc = new String[lagc][2];
                System.out.println("LARGO CATEGORIAS:" + lagc);
                for (int i = 1; i < lagc; i++) {
                    rs.absolute(i);
                    idc[(i - 1)][0] = (String) rs.getObject("categorias_nombre");
                    idc[(i - 1)][1] = "" + rs.getObject("categorias_id");
                    //System.out.println(id[i][1]);
                    jComboBoxCategorias.addItem("" + idc[(i - 1)][0]);
                }
            } catch (SQLException ex) {
                Logger.getLogger(AgregarLibros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //consulto editoriales en la db
        consulta = "SELECT * FROM fastdevelopment.editoriales where editoriales_estado=1;";
        consultar consultar = new consultar(reg, consulta);
        if (consultar.getError() == null) {
            rs = consultar.getResultado();
            try {
                while (rs.next()) {
                    lage++;
                }
                ide = new String[lage][2];
                System.out.println("LARGO EDITORIALES:" + lage);
                for (int i = 1; i < lage; i++) {
                    rs.absolute(i);
                    ide[(i - 1)][0] = (String) rs.getObject("editoriales_nombre");
                    ide[(i - 1)][1] = "" + rs.getObject("editoriales_id");
                    //System.out.println(id[i][1]);
                    jComboBoxEditorial.addItem("" + ide[(i - 1)][0]);
                }
            } catch (SQLException ex) {
                Logger.getLogger(AgregarLibros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //consulto idioma en la db
        consulta = "SELECT * FROM fastdevelopment.idiomas where idiomas_estado=1;";
        consultar consultari = new consultar(reg, consulta);
        if (consultari.getError() == null) {
            rs = consultari.getResultado();
            try {
                while (rs.next()) {
                    lagi++;
                }
                idi = new String[lagi][2];
                System.out.println("LARGO EDITORIALES:" + lagi);
                for (int i = 1; i < lagi; i++) {
                    rs.absolute(i);
                    idi[(i - 1)][0] = (String) rs.getObject("idiomas_idioma");
                    idi[(i - 1)][1] = "" + rs.getObject("idiomas_id");
                    //System.out.println(id[i][1]);
                    jComboBoxIdioma.addItem("" + idi[(i - 1)][0]);
                }
            } catch (SQLException ex) {
                Logger.getLogger(AgregarLibros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_num_serie = new javax.swing.JTextField();
        txt_isbn = new javax.swing.JTextField();
        txt_titulo = new javax.swing.JTextField();
        txt_num_pag = new javax.swing.JTextField();
        txt_precio_ref = new javax.swing.JTextField();
        jComboBoxCategorias = new javax.swing.JComboBox();
        jComboBoxEditorial = new javax.swing.JComboBox();
        jComboBoxAutores = new javax.swing.JComboBox();
        jDateChooserAnoPub = new com.toedter.calendar.JDateChooser();
        jComboBoxIdioma = new javax.swing.JComboBox();
        btn_agregar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabelMin = new javax.swing.JLabel();
        jLabelClose = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Gestionar Libros"));
        jPanel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel1.setText("Número de Serie");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 143, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel2.setText("ISBN");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 143, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel3.setText("Título");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 99, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel4.setText("Número de Páginas");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 141, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel5.setText("Precio Referencial");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 99, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel6.setText("Año de publicación");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 99, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel7.setText("Idioma");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 99, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel8.setText("Autor");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 99, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel9.setText("Categorías");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 99, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel10.setText("Editorial");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 105, -1));
        jPanel1.add(txt_num_serie, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 222, -1));
        jPanel1.add(txt_isbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 222, -1));
        jPanel1.add(txt_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 222, -1));
        jPanel1.add(txt_num_pag, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 222, -1));
        jPanel1.add(txt_precio_ref, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 222, -1));

        jComboBoxCategorias.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jComboBoxCategorias.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Categoria" }));
        jComboBoxCategorias.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jComboBoxCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCategoriasActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 220, 20));

        jComboBoxEditorial.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jComboBoxEditorial.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Editorial" }));
        jComboBoxEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEditorialActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxEditorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 220, 20));

        jComboBoxAutores.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jComboBoxAutores.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Autor" }));
        jComboBoxAutores.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jComboBoxAutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAutoresActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxAutores, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 220, 20));

        jDateChooserAnoPub.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.add(jDateChooserAnoPub, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 220, -1));

        jComboBoxIdioma.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jComboBoxIdioma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Idioma" }));
        jComboBoxIdioma.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jComboBoxIdioma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxIdiomaActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxIdioma, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 220, 20));

        btn_agregar.setText("Agregar");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        btn_limpiar.setText("Limpiar");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(58, 71, 80));

        jLabelMin.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelMin.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMin.setText("-");
        jLabelMin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinMouseClicked(evt);
            }
        });

        jLabelClose.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelClose.setForeground(new java.awt.Color(255, 255, 255));
        jLabelClose.setText("X");
        jLabelClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Agregar Libro");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelMin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelClose)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelClose))
                .addGap(0, 17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(btn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        //limpiar campos
        limpiarCaja(txt_num_serie);
        limpiarCaja(txt_isbn);
        limpiarCaja(txt_titulo);
        limpiarCaja(txt_num_pag);
        limpiarCaja(txt_precio_ref);
        jDateChooserAnoPub.setDate(null);
        jComboBoxIdioma.setSelectedIndex(0);
        jComboBoxCategorias.setSelectedIndex(0);
        jComboBoxAutores.setSelectedIndex(0);
        jComboBoxEditorial.setSelectedIndex(0);
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        String  libros_numero_serie, libros_isbn, libros_titulo, libros_numero_paginas, libros_precio_referencia, libros_ano_publicacion, str_libros_idiomas, libros_publicacion,str_libros_autores, str_libos_categorias, str_libros_editorial;
        int libros_estado,libros_autores,libros_editorial,libos_categorias,libros_idiomas;
        libros_numero_serie = "" + txt_num_serie.getText();
        libros_isbn = "" + txt_isbn.getText();
        libros_titulo = "" + txt_titulo.getText();
        libros_numero_paginas = "" + txt_num_pag.getText();
        libros_precio_referencia = "" + txt_precio_ref.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        libros_ano_publicacion = "" + sdf.format(jDateChooserAnoPub.getDate());
        str_libros_idiomas = "" + jComboBoxIdioma.getSelectedItem().toString();
             
        libros_publicacion = "";        
        str_libros_autores = "" + jComboBoxAutores.getSelectedItem().toString();
        str_libos_categorias = "" + jComboBoxCategorias.getSelectedItem().toString();
        str_libros_editorial = "" + jComboBoxEditorial.getSelectedItem().toString();        
        System.out.println(""+str_libros_autores);
        libros_estado = 1;
        //Validaciones
        if (libros_numero_serie.equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese número de serie");
        } else if (libros_isbn.equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese ISBN");
        } else if (libros_titulo.equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese título");
        } else if (libros_numero_paginas.equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese número de paginas");
        } else if (libros_precio_referencia.equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese precio referencia");
        } else if (libros_ano_publicacion.equals("null")) {
            JOptionPane.showMessageDialog(null, "Ingrese año de publicación");
        } else if (str_libros_idiomas.equals("Seleccione Idioma")) {
            JOptionPane.showMessageDialog(null, "Ingrese idioma");
        } else if (str_libros_autores.equals("Seleccione Autor")) {
            JOptionPane.showMessageDialog(null, "Seleccione autores");
        } else if (str_libos_categorias.equals("Seleccione Categoria")) {
            JOptionPane.showMessageDialog(null, "Seleccione categoria");
        } else if (str_libros_editorial.equals("Seleccione Editorial")) {
            JOptionPane.showMessageDialog(null, "Ingrese editorial");
        } else {
            libros_idiomas=Integer.parseInt(id_idioma_seleccionado);  
            libros_autores=Integer.parseInt(id_autor_seleccionado);
            libos_categorias = Integer.parseInt(id_categoria_seleccionado);
            libros_editorial = Integer.parseInt(id_autor_seleccionado);
            conectar conex = new conectar();
            Connection reg = conex.conexion();
            String sql;
            //String val="1";
            sql = "INSERT INTO libros (libros_numero_serie, libros_isbn, libros_titulo, libros_numero_paginas, libros_precio_referencia, libros_ano_publicacion, libros_idiomas,libros_autores, libos_categorias, libros_editorial, libros_estado)VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement pst = reg.prepareStatement(sql);
                pst.setString(1, libros_numero_serie);
                pst.setString(2, libros_isbn);
                pst.setString(3, libros_titulo);
                pst.setString(4, libros_numero_paginas);
                pst.setString(5, libros_precio_referencia);
                pst.setString(6, libros_ano_publicacion);
                pst.setInt(7, libros_idiomas);
                pst.setInt(8, libros_autores);                
                pst.setInt(9, libos_categorias);
                pst.setInt(10, libros_editorial);
                pst.setInt(11, libros_estado);
                int n = pst.executeUpdate();
                if (n > 0) {                    
                    int input = JOptionPane.showOptionDialog(null, "Libro Registrado correctamente, Aceptar para continuar", "Mensaje", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                    if (input == JOptionPane.OK_OPTION) {
                        //cerrar ventana actual
                        this.dispose();
                    } else if (input == JOptionPane.CANCEL_OPTION) {
                        System.out.println("CANCELAR");
                        limpiarCaja(txt_num_serie);
                        limpiarCaja(txt_isbn);
                        limpiarCaja(txt_titulo);
                        limpiarCaja(txt_num_pag);
                        limpiarCaja(txt_precio_ref);
                        jDateChooserAnoPub.setDate(null);
                        jComboBoxIdioma.setSelectedIndex(0);
                        jComboBoxCategorias.setSelectedIndex(0);
                        jComboBoxAutores.setSelectedIndex(0);
                        jComboBoxEditorial.setSelectedIndex(0);
                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(AgregarLibros.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void jComboBoxCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCategoriasActionPerformed
        String selected = "" + jComboBoxCategorias.getSelectedItem().toString();
        if (selected.equals("Seleccione Categoria")) {            
            System.out.println("NADA SELECCIONADO");
        } else {
            for (int i = 0; i < lagc; i++) {
                if (selected.equals(idc[i][0])) {                   
                    id_categoria_seleccionado = idc[i][1];
                }
            }
            System.out.println("SELECCIONADO "+id_categoria_seleccionado);
        }       
    }//GEN-LAST:event_jComboBoxCategoriasActionPerformed

    private void jComboBoxEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEditorialActionPerformed
        String selected = "" + jComboBoxEditorial.getSelectedItem().toString();
        if (selected.equals("Seleccione Editorial")) {            
            System.out.println("NADA SELECCIONADO");
        } else {
            for (int i = 0; i < lage; i++) {
                if (selected.equals(ide[i][0])) {                   
                    id_editorial_seleccionado = ide[i][1];
                }
            }
            System.out.println("SELECCIONADO "+id_editorial_seleccionado);
        } 
    }//GEN-LAST:event_jComboBoxEditorialActionPerformed

    private void jComboBoxAutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAutoresActionPerformed
        String selected = "" + jComboBoxAutores.getSelectedItem().toString();
        if (selected.equals("Seleccione Autor")) {            
            System.out.println("NADA SELECCIONADO");
        } else {            
            
            for (int i = 0; i < lagu; i++) {
                if (selected.equals(idu[i][0] + " " + idu[i][2])) {                   
                    id_autor_seleccionado = idu[i][1];
                }
            }
            System.out.println("SELECCIONADO "+id_autor_seleccionado);
        } 
    }//GEN-LAST:event_jComboBoxAutoresActionPerformed

    private void jComboBoxIdiomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxIdiomaActionPerformed
        String selected = "" + jComboBoxIdioma.getSelectedItem().toString();
        if (selected.equals("Seleccione Idioma")) {            
            System.out.println("NADA SELECCIONADO");
        } else {
            for (int i = 0; i < lagi; i++) {
                if (selected.equals(idi[i][0])) {                   
                    id_idioma_seleccionado = ide[i][1];
                }
            }
            System.out.println("SELECCIONADO "+id_idioma_seleccionado);
        } 
    }//GEN-LAST:event_jComboBoxIdiomaActionPerformed

    private void jLabelMinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinMouseClicked

        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabelMinMouseClicked

    private void jLabelCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseClicked
        System.out.println("Cerrar");
        limpiarCaja(txt_num_serie);
        limpiarCaja(txt_isbn);
        limpiarCaja(txt_titulo);
        limpiarCaja(txt_num_pag);
        limpiarCaja(txt_precio_ref);
        jDateChooserAnoPub.setDate(null);
        jComboBoxIdioma.setSelectedIndex(0);
        jComboBoxCategorias.setSelectedIndex(0);
        jComboBoxAutores.setSelectedIndex(0);
        jComboBoxEditorial.setSelectedIndex(0);
        this.setVisible(false);
        App content = new App();
        content.setVisible(true);
        content.pack();
        content.setLocationRelativeTo(null);
        content.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }//GEN-LAST:event_jLabelCloseMouseClicked

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
            java.util.logging.Logger.getLogger(AgregarLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarLibros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_limpiar;
    private static javax.swing.JComboBox jComboBoxAutores;
    private static javax.swing.JComboBox jComboBoxCategorias;
    private static javax.swing.JComboBox jComboBoxEditorial;
    private static javax.swing.JComboBox jComboBoxIdioma;
    private com.toedter.calendar.JDateChooser jDateChooserAnoPub;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelMin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txt_isbn;
    private javax.swing.JTextField txt_num_pag;
    private javax.swing.JTextField txt_num_serie;
    private javax.swing.JTextField txt_precio_ref;
    private javax.swing.JTextField txt_titulo;
    // End of variables declaration//GEN-END:variables
}
