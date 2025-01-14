/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;
import config.conexion;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel; 
/**
 *
 * @author Usuario
 */
public class prestamo extends javax.swing.JFrame {

    /**
     * Creates new form prestamo
     */
    conexion cn = new conexion();
    Connection con;
    Statement st;
    ResultSet rs;
    public prestamo() {
        initComponents();
        buscaradmin();
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_libro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbo_libro = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_idlib = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_disponible = new javax.swing.JTextField();
        cbo_ad = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_cod = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_h = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_nom = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_apel = new javax.swing.JTextField();
        btn_regis = new javax.swing.JButton();
        rb_sala = new javax.swing.JRadioButton();
        rb_dom = new javax.swing.JRadioButton();
        btn_buscar = new javax.swing.JButton();
        txt_fp = new com.toedter.calendar.JDateChooser();
        txt_fd = new com.toedter.calendar.JDateChooser();
        jButton3 = new javax.swing.JButton();
        txt_idp = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255), 4));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("FECHA DE PRESTAMO:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 22, -1, -1));

        txt_libro.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_libroCaretUpdate(evt);
            }
        });
        txt_libro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_libroActionPerformed(evt);
            }
        });
        jPanel1.add(txt_libro, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 466, -1));

        jLabel6.setText("BUSCAR NOMBRE:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        cbo_libro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_libroActionPerformed(evt);
            }
        });
        jPanel1.add(cbo_libro, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 466, -1));

        jLabel7.setText("NOMBRE DEL LIBRO:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel8.setText("ID LIBRO:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, -1));
        jPanel1.add(txt_idlib, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 71, -1));

        jLabel10.setText("DISPONIBLE");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, -1, -1));
        jPanel1.add(txt_disponible, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 71, -1));

        jPanel1.add(cbo_ad, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 126, -1));

        jLabel5.setText("CODIGO:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 53, -1, -1));

        jLabel3.setText("FECHA DE DEVOLUCION:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 56, -1, -1));

        txt_cod.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_codCaretUpdate(evt);
            }
        });
        jPanel1.add(txt_cod, new org.netbeans.lib.awtextra.AbsoluteConstraints(389, 50, 126, -1));

        jLabel9.setText("ID ADMIN:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, -1, -1));

        jLabel4.setText("HORA DE PRESTAMO:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 22, -1, -1));
        jPanel1.add(txt_h, new org.netbeans.lib.awtextra.AbsoluteConstraints(479, 19, 126, -1));

        jLabel11.setText("NOMBRES DEL CLIENTE:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));
        jPanel1.add(txt_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 254, -1));

        jLabel12.setText("APELLIDOS DEL CLIENTE:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));
        jPanel1.add(txt_apel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 254, -1));

        btn_regis.setText("Registrar");
        btn_regis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regisActionPerformed(evt);
            }
        });
        jPanel1.add(btn_regis, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, -1, -1));

        buttonGroup1.add(rb_sala);
        rb_sala.setText("SALA");
        jPanel1.add(rb_sala, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 56, -1));

        buttonGroup1.add(rb_dom);
        rb_dom.setText("DOMICILIO");
        jPanel1.add(rb_dom, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 230, 98, -1));

        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, -1, -1));

        txt_fp.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(txt_fp, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 16, 144, -1));

        txt_fd.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(txt_fd, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 51, 144, -1));

        jButton3.setText("buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(527, 50, -1, -1));
        jPanel1.add(txt_idp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 86, -1));

        jPanel3.setBackground(new java.awt.Color(0, 102, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255), 4));
        jPanel3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 27)); // NOI18N
        jLabel13.setText("REGISTRO DE MATERIAL BIBLIOGRÁFICO");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_regisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regisActionPerformed
       
        agregar();
        
        
    }//GEN-LAST:event_btn_regisActionPerformed

    private void txt_libroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_libroActionPerformed
        
    }//GEN-LAST:event_txt_libroActionPerformed

    private void txt_libroCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_libroCaretUpdate
        // TODO add your handling code here:
        cbo_libro.removeAllItems();
        if(!txt_libro.getText().equals("")){
             buscarcbo();
         }
        
    }//GEN-LAST:event_txt_libroCaretUpdate

    private void cbo_libroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_libroActionPerformed
       
    }//GEN-LAST:event_cbo_libroActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        
        buscar();
        if(txt_disponible.getText().equals("0")){
            btn_regis.setEnabled(false);
        }
        else{
            btn_regis.setEnabled(true);
        }
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void txt_codCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_codCaretUpdate
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_codCaretUpdate

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        txt_nom.setText("");
        txt_apel.setText("");
        buscarcliente();
    }//GEN-LAST:event_jButton3ActionPerformed

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

    void agregar(){
        String fp = ((JTextField)txt_fp.getDateEditor().getUiComponent()).getText();
        String fd = ((JTextField)txt_fd.getDateEditor().getUiComponent()).getText();

        String hora = txt_h.getText();
        String codigo = txt_cod.getText();
        
        String id_ad = cbo_ad.getSelectedItem().toString();
        String id_lib = txt_idlib.getText();
        String lugar = "";
        if(rb_dom.isSelected()){
            lugar = "domicilio";
        }
        if(rb_sala.isSelected()){
            lugar = "sala";
        }
        String sql = "call insertar_prestamo ('"+fp+"','"+fd+"','"+hora+"','"+id_lib+"','"+id_ad+"','"+codigo+"','"+lugar+"')";
        //"insert into prestamo(fecha_prestamo,fecha_devolucion,hora_prestamo,id_libro,id_admin,codigo,lugar_p)values('"+fp+"','"+fd+"','"+hora+"','"+id_lib+"','"+id_ad+"','"+codigo+"','"+lugar+"')"
        try {
            if(fp.equals("")||fd.equals("")){
                JOptionPane.showMessageDialog(null,"Ingrese mas datos por favor");
            }else{
                
                con = cn.getConection();
                st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Prestamo registrado con exito");
                listar_id();
                
            }
        } catch (Exception e) {
        }
    }
    //fecha_prestamo,fecha_devolucion,hora_prestamo,id_libro,id_admin,codigo,lugar_p
    //'"+fp+"','"+fd+"','"+hora+"','"+id_lib+"','"+id_ad+"','"+codigo+"','"+lugar+"'
    void buscar(){
        String libro = cbo_libro.getSelectedItem().toString();
        String sql = "select * from libro where nombre_libro like '"+libro+"'";
        try {
            con = cn.getConection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                String id_libro = rs.getString("id_libro");
                String disponible = rs.getString("num_ejemplares");
                txt_idlib.setText(id_libro);
                txt_disponible.setText(disponible);
            }
        } catch (Exception e) {
        }
    }
    void update(){
        int restar = Integer.parseInt(txt_disponible.getText()) - 1;
        String resultado = Integer.toString(restar);
        String sql = "Update libro set num_ejemplares = '"+resultado+"'where nombre_libro='"+cbo_libro.getSelectedItem().toString()+"'";
        try {
            con = cn.getConection();
            st = con.createStatement();
            st.executeUpdate(sql);
        } catch (Exception e) {
        }
    }
    void buscaradmin(){
        String sql = "select * from administrador";
        try {
            con = cn.getConection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                cbo_ad.addItem(rs.getString("id_admin"));
            }
        } catch (Exception e) {
        }
    }
    void buscarcliente(){
        String codigo = txt_cod.getText();
        String sql = "select * from cliente where codigo = '"+codigo+"'";
        try {
            con = cn.getConection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                String nombre = rs.getString("nombre_cliente");
                String apellido = rs.getString("apellido_cliente");
                txt_nom.setText(nombre);
                txt_apel.setText(apellido);
            }
        } catch (Exception e) {
        }
    }
    void buscarcbo(){
        String libro = txt_libro.getText();
        String sql = "select * from libro where nombre_libro like '%"+libro+"%'";
        try {
            con = cn.getConection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                String nombre = rs.getString("nombre_libro");
                //String id_libro = rs.getString("id_libro");
                cbo_libro.addItem(nombre);
                //txt_idlib.setText(id_libro);
            }
        } catch (Exception e) {
        }
    }
    void agregardev(){
        String fecha = ((JTextField)txt_fd.getDateEditor().getUiComponent()).getText();
        String hora = txt_h.getText();
        String id = txt_idp.getText();
        String estado = "pendiente";
        String sql="insert into devolucion (fecha_d,hora_d,id_prestamo,estado) values ('"+fecha+"','"+hora+"','"+id+"','"+estado+"')";
        try {
            con = cn.getConection();
            st = con.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Prestamo registrado con exito");
        } catch (Exception e) {
        }
    }
    void listar_id(){
        String sql = "SELECT id_prestamo\n" +
                     "FROM prestamo\n" +
                     "ORDER BY id_prestamo DESC\n" +
                     "LIMIT 1;";
        try {
            con = cn.getConection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if(rs.next()){
                txt_idp.setText(rs.getString("id_prestamo"));
            }
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
            java.util.logging.Logger.getLogger(prestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(prestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(prestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(prestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new prestamo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_regis;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbo_ad;
    private javax.swing.JComboBox<String> cbo_libro;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton rb_dom;
    private javax.swing.JRadioButton rb_sala;
    private javax.swing.JTextField txt_apel;
    private javax.swing.JTextField txt_cod;
    private javax.swing.JTextField txt_disponible;
    private com.toedter.calendar.JDateChooser txt_fd;
    private com.toedter.calendar.JDateChooser txt_fp;
    private javax.swing.JTextField txt_h;
    private javax.swing.JTextField txt_idlib;
    private javax.swing.JTextField txt_idp;
    private javax.swing.JTextField txt_libro;
    private javax.swing.JTextField txt_nom;
    // End of variables declaration//GEN-END:variables
}
