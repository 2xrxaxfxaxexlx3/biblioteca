/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;
import config.conexion;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Usuario
 */
public class lista_libros extends javax.swing.JFrame {

    /**
     * Creates new form lista_libros
     */
    conexion cn = new conexion();
    Connection con;
    Statement st;
    ResultSet rs;
    DefaultTableModel model;
    public lista_libros() {
        initComponents();
        listar();
        listar2();
        
    }
    void listar(){
        String sql="select l.id_libro, l.nombre_libro, l.edicion, l.num_ejemplares, l.autor, e.nombre_editorial from libro l \n" +
                    "left join editorial e on l.id_editorial = e.id_editorial ";
        try {
            con = cn.getConection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            Object[] libro= new Object[6];
            model = (DefaultTableModel)tabladatos.getModel();
            while(rs.next()){
                libro[0]= rs.getInt("id_libro");
                libro[1]= rs.getString("nombre_libro");
                libro[2]= rs.getInt("edicion");
                libro[3]= rs.getInt("num_ejemplares");
                libro[4]= rs.getString("autor");
                libro[5]= rs.getString("nombre_editorial");
                model.addRow(libro);
            }
            tabladatos.setModel(model);
        } catch (Exception e) {
        }
    }
    void agregar(){
        String nombre = txt_titulo.getText();
        String ejemplares= txt_cantidad.getText();
        String edicion = txt_edicion.getText();
        String autor = txt_autor.getText();
        String editorial= txt_idedit.getText();
        String sql = "call insertar_libro('"+editorial+"','"+nombre+"','"+ejemplares+"','"+edicion+"','"+autor+"')";
        //"Insert into libro (id_editorial,nombre_libro,num_ejemplares,edicion,autor)values('"+editorial+"','"+nombre+"','"+ejemplares+"','"+edicion+"','"+autor+"')"
        try {
            if (txt_titulo.equals("")||txt_edicion.equals("")||txt_cantidad.equals("")||txt_autor.equals("")){
                JOptionPane.showMessageDialog(null,"Ingrese mas datos por favor");
            }
            else{
                con = cn.getConection();
                CallableStatement stmt = con.prepareCall(sql);
                stmt.execute();
                rs=stmt.getResultSet();
                JOptionPane.showMessageDialog(null, "Libro añadido");
                limpiarTabla(model);
                Object[] libro= new Object[6];
                model = (DefaultTableModel)tabladatos.getModel();
                while(rs.next()){
                    libro[0]= rs.getInt("id_libro");
                    libro[1]= rs.getString("nombre_libro");
                    libro[2]= rs.getInt("edicion");
                    libro[3]= rs.getInt("num_ejemplares");
                    libro[4]= rs.getString("autor");
                    libro[5]= rs.getString("nombre_editorial");
                    model.addRow(libro);
                }
                tabladatos.setModel(model);
            }
        } catch (Exception e) {
        }
    }
    void listar2(){
        String sql = "select nombre_editorial from editorial";
       
        try {
            con = cn.getConection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                cbo_edit.addItem(rs.getString("nombre_editorial"));
            }
        } catch (Exception e) {
        }
    }
    void listar_id(){
        String valor = cbo_edit.getSelectedItem().toString();
        String sql2= "select id_editorial from editorial where nombre_editorial ='"+valor+"'";
        try {
            con = cn.getConection();
            st = con.createStatement();
            rs = st.executeQuery(sql2);
            if (rs.next()){
                txt_idedit.setText(rs.getString("id_editorial"));
            }
        } catch (Exception e) {
        }
    }
    void listar_id2(){
        String valor = txt_idedit.getText();
        txt_idedit.setText("");
        String sql2= "select id_editorial from editorial where nombre_editorial ='"+valor+"'";
        try {
            con = cn.getConection();
            st = con.createStatement();
            rs = st.executeQuery(sql2);
            if (rs.next()){
                txt_idedit.setText(rs.getString("id_editorial"));
            }
        } catch (Exception e) {
        }
    }
    void limpiarTabla(DefaultTableModel model) {
        for (int i = 0; i <= tabladatos.getRowCount()-1; i++) {
            model.removeRow(i);
            i = i - 1;
        }

    }
    void modificar(){
        String id = txt_idlib.getText();
        String titulo = txt_titulo.getText();
        String edicion = txt_edicion.getText();
        String ejemplar = txt_cantidad.getText();
        String autor = txt_autor.getText();
        String editorial = txt_idedit.getText();
        String sql = "call modificar_libro('"+titulo+"','"+ejemplar+"','"+edicion+"','"+autor+"','"+editorial+"','"+id+"')";
        //update libro set nombre_libro = '"+titulo+"',num_ejemplares= '"+ejemplar+"',edicion= '"+edicion+"',autor= '"+autor+"',id_editorial = '"+editorial+"' where id_libro = "+id;
        try {
            if (txt_autor.equals("")||txt_cantidad.equals("")||txt_edicion.equals("")||txt_idedit.equals("")||txt_titulo.equals("") ){
                JOptionPane.showMessageDialog(null, "ingrese mas datos");
            }
            else{
                con = cn.getConection();
                CallableStatement stmt = con.prepareCall(sql);
                stmt.execute();
                rs=stmt.getResultSet();
                JOptionPane.showMessageDialog(null, "Libro Modificado");
                limpiarTabla(model);
                Object[] libro= new Object[6];
                model = (DefaultTableModel)tabladatos.getModel();
                while(rs.next()){
                    libro[0]= rs.getInt("id_libro");
                    libro[1]= rs.getString("nombre_libro");
                    libro[2]= rs.getInt("edicion");
                    libro[3]= rs.getInt("num_ejemplares");
                    libro[4]= rs.getString("autor");
                    libro[5]= rs.getString("nombre_editorial");
                    model.addRow(libro);
                }
                tabladatos.setModel(model);
            }
        } catch (Exception e) {
        }
    }
    void eliminar(){
        String id = txt_idlib.getText();
        String sql = "call eliminar_libro('"+id+"')";
        int fila = tabladatos.getSelectedRow();
        if ( fila<0){
            JOptionPane.showMessageDialog(null, "No se selecciono nada");
        }
        else{
            try {
                con = cn.getConection();
                CallableStatement stmt = con.prepareCall(sql);
                stmt.execute();
                rs=stmt.getResultSet();
                JOptionPane.showMessageDialog(null, "Libro eliminado");
                limpiarTabla(model);
                Object[] libro= new Object[6];
                model = (DefaultTableModel)tabladatos.getModel();
                while(rs.next()){
                    libro[0]= rs.getInt("id_libro");
                    libro[1]= rs.getString("nombre_libro");
                    libro[2]= rs.getInt("edicion");
                    libro[3]= rs.getInt("num_ejemplares");
                    libro[4]= rs.getString("autor");
                    libro[5]= rs.getString("nombre_editorial");
                    model.addRow(libro);
                }
                tabladatos.setModel(model);
            } catch (Exception e) {
            }
        }
    }
    void limpiar(){
        txt_idlib.setText("");
        txt_titulo.setText("");
        txt_edicion.setText("");
        txt_cantidad.setText("");
        txt_autor.setText("");
        txt_idedit.setText("");
    }
    void listar_cbo(){
        String sql= "select nombre_libro from libro where nombre_libro like '%"+txt_titulo.getText()+"%'";
        try {
            con = cn.getConection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){
                cbo_buscar.addItem(rs.getString("nombre_libro"));
            }
        } catch (Exception e) {
        }
    }
    void agregar_editorial(){
        String nombre= txt_edit.getText();
        String ruc = txt_ruc.getText();
        String tel= txt_tel.getText();
        String sql = "Insert into editorial(nombre_editorial,ruc,telefono)values('"+nombre+"','"+ruc+"','"+tel+"')";
        try {
            if (txt_edit.equals("")||txt_ruc.equals("")||txt_tel.equals("")){
                JOptionPane.showMessageDialog(null, "Ingrese mas datos");
            }
            else{
                con = cn.getConection();
                st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showConfirmDialog(null, "Editorial añadida");
            }
        } catch (Exception e) {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tabladatos = new javax.swing.JTable();
        txt_titulo = new javax.swing.JTextField();
        cbo_buscar = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        txt_cantidad = new javax.swing.JTextField();
        txt_edicion = new javax.swing.JTextField();
        txt_autor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_edit = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_ruc = new javax.swing.JTextField();
        txt_tel = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        cbo_edit = new javax.swing.JComboBox<>();
        txt_idlib = new javax.swing.JTextField();
        txt_idedit = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204), 3));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabladatos.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        tabladatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Titulo ", "Edicion", "Cantidad", "Autor", "Editorial"
            }
        ));
        tabladatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabladatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabladatos);
        if (tabladatos.getColumnModel().getColumnCount() > 0) {
            tabladatos.getColumnModel().getColumn(0).setMinWidth(40);
            tabladatos.getColumnModel().getColumn(0).setPreferredWidth(40);
            tabladatos.getColumnModel().getColumn(0).setMaxWidth(40);
            tabladatos.getColumnModel().getColumn(1).setMinWidth(300);
            tabladatos.getColumnModel().getColumn(1).setPreferredWidth(300);
            tabladatos.getColumnModel().getColumn(1).setMaxWidth(300);
            tabladatos.getColumnModel().getColumn(2).setMinWidth(60);
            tabladatos.getColumnModel().getColumn(2).setPreferredWidth(60);
            tabladatos.getColumnModel().getColumn(2).setMaxWidth(60);
            tabladatos.getColumnModel().getColumn(3).setMinWidth(60);
            tabladatos.getColumnModel().getColumn(3).setPreferredWidth(60);
            tabladatos.getColumnModel().getColumn(3).setMaxWidth(60);
            tabladatos.getColumnModel().getColumn(4).setMinWidth(200);
            tabladatos.getColumnModel().getColumn(4).setPreferredWidth(200);
            tabladatos.getColumnModel().getColumn(4).setMaxWidth(200);
            tabladatos.getColumnModel().getColumn(5).setMinWidth(150);
            tabladatos.getColumnModel().getColumn(5).setPreferredWidth(150);
            tabladatos.getColumnModel().getColumn(5).setMaxWidth(150);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 812, 290));

        txt_titulo.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_tituloCaretUpdate(evt);
            }
        });
        jPanel1.add(txt_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 335, -1));

        jPanel1.add(cbo_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 309, -1));

        jButton1.setText("buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, -1, -1));
        jPanel1.add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 71, -1));
        jPanel1.add(txt_edicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 71, -1));
        jPanel1.add(txt_autor, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, 193, -1));

        jLabel2.setText("Ejemplares:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 64, -1));

        jLabel3.setText("Edicion:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, -1, -1));

        jLabel4.setText("Autor:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 60, 37, -1));

        jLabel5.setText("Nombre:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel6.setText("Editorial:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, -1, -1));
        jPanel1.add(txt_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 220, -1));

        jLabel7.setText("Nombre Editorial:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel8.setText("Ruc:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, -1, -1));

        jLabel9.setText("Telefono:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, -1, -1));
        jPanel1.add(txt_ruc, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 110, -1));
        jPanel1.add(txt_tel, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, 110, -1));

        jButton6.setText("Agregar Editorial");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 90, 130, -1));

        jButton2.setText("Añadir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 120, 90, 60));

        jButton3.setText("Modificar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 190, 90, 59));

        jButton4.setText("Eliminar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 260, 90, 60));

        jPanel1.add(cbo_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 190, 30));
        jPanel1.add(txt_idlib, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 80, -1));
        jPanel1.add(txt_idedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, 70, -1));

        jPanel5.setBackground(new java.awt.Color(204, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)), "Menú"));

        jButton7.setText("PRESTAMO");
        jButton7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("LISTA CLIENTE");
        jButton8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("LISTA LIBROS");
        jButton9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("LISTA DEVOL");
        jButton10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("LIBROS ALMC");
        jButton11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("REG. CLIENTES");
        jButton12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 102, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255), 4));
        jPanel4.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("LIBROS ALMACENADOS");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(255, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(244, 244, 244))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 941, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        txt_idedit.setText("");
        listar_id();
        agregar();
        limpiar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tabladatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabladatosMouseClicked
        // TODO add your handling code here:
        int row = tabladatos.getSelectedRow();
        if (row==-1){
            JOptionPane.showMessageDialog(null,"No se selecciono");
        }
        else{
            String id = tabladatos.getValueAt(row, 0).toString();
            String nombre = tabladatos.getValueAt(row, 1).toString();
            String ejemplar = tabladatos.getValueAt(row, 3).toString();
            String edicion = tabladatos.getValueAt(row, 2).toString();
            String autor = tabladatos.getValueAt(row, 4).toString();
            String editorial = tabladatos.getValueAt(row, 5).toString();
            txt_idlib.setText(id);
            txt_titulo.setText(nombre);
            txt_edicion.setText(edicion);
            txt_cantidad.setText(ejemplar);
            txt_autor.setText(autor);
            txt_idedit.setText(editorial);
            cbo_edit.setSelectedItem(editorial);
        }
    }//GEN-LAST:event_tabladatosMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //TODO add your handling code here:
        txt_idedit.setText("");
        listar_id();
        modificar();
        limpiar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        eliminar();
        limpiar();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txt_tituloCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_tituloCaretUpdate
        // TODO add your handling code here:
        cbo_buscar.removeAllItems();
        if (!txt_titulo.getText().equals("")){
            listar_cbo();
        }
    }//GEN-LAST:event_txt_tituloCaretUpdate

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        limpiarTabla(model);
        listar_libro();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        txt_edit.setText("");
        txt_ruc.setText("");
        txt_tel.setText("");
        agregar_editorial();
        cbo_edit.removeAllItems();
        listar2();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        prestamo ventana1 = new prestamo();
        ventana1.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        clientes ventana = new clientes();
        ventana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        tabla ventana = new tabla();
        ventana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        devolucion ventana = new devolucion();
        ventana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        lista_libros ventana = new lista_libros();
        ventana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        form_cliente ventana = new form_cliente();
        ventana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton12ActionPerformed
    void listar_libro(){
        String sql = "select * from libro where nombre_libro='"+cbo_buscar.getSelectedItem().toString()+"'";
        try {
            con= cn.getConection();
            st=con.createStatement();
            rs=st.executeQuery(sql);
            Object[] libro= new Object[6];
            model = (DefaultTableModel)tabladatos.getModel();
            while(rs.next()){
                libro[0]= rs.getInt("id_libro");
                libro[1]= rs.getString("nombre_libro");
                libro[2]= rs.getInt("edicion");
                libro[3]= rs.getInt("num_ejemplares");
                libro[4]= rs.getString("autor");
                libro[5]= rs.getInt("id_editorial");
                model.addRow(libro);
            }
            tabladatos.setModel(model);   
            
        } catch (Exception e) {
        }
    }
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(lista_libros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(lista_libros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(lista_libros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(lista_libros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new lista_libros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbo_buscar;
    private javax.swing.JComboBox<String> cbo_edit;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabladatos;
    private javax.swing.JTextField txt_autor;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_edicion;
    private javax.swing.JTextField txt_edit;
    private javax.swing.JTextField txt_idedit;
    private javax.swing.JTextField txt_idlib;
    private javax.swing.JTextField txt_ruc;
    private javax.swing.JTextField txt_tel;
    private javax.swing.JTextField txt_titulo;
    // End of variables declaration//GEN-END:variables
}
