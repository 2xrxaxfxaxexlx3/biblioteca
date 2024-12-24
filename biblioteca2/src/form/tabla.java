/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;
import config.conexion;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Image;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author Usuario
 */
public class tabla extends javax.swing.JFrame {

    /**
     * Creates new form tabla
     */
    conexion cn = new conexion();
    Connection con;
    Statement st;
    ResultSet rs;
    DefaultTableModel model;
    public tabla() {
        initComponents();
        listar();
    }
    
    void listar(){
        String sql = "select p.id_prestamo, p.fecha_prestamo, p.fecha_devolucion, p.hora_prestamo, p.id_libro , l.nombre_libro,p.codigo, p.lugar_p from prestamo p\n" +
"join libro l on p.id_libro = l.id_libro";
        try {
            con = cn.getConection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            Object[] biblioteca = new Object[8];
            model = (DefaultTableModel)tabladatos.getModel();
            while(rs.next()){
                biblioteca[0] = rs.getInt("id_prestamo");
                biblioteca[1] = rs.getString("fecha_prestamo");
                biblioteca[2] = rs.getString("fecha_devolucion");
                biblioteca[3] = rs.getString("hora_prestamo");
                biblioteca[4] = rs.getInt("id_libro");
                biblioteca[5] = rs.getString("nombre_libro");
                biblioteca[6] = rs.getString("codigo");
                biblioteca[7] = rs.getString("lugar_p");
                model.addRow(biblioteca);
            }
            tabladatos.setModel(model);
        } catch (Exception e) {
        }
    }
    void imprimir(){
        Document documento = new Document();
        try {
            String ruta= System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Libros.pdf"));
            Image libro = Image.getInstance("src/imagenes/Libros.png");
            libro.scaleToFit(540,800);
            libro.setAlignment(Chunk.ALIGN_CENTER);
            Font f1 = new Font(Font.FontFamily.TIMES_ROMAN,10,Font.NORMAL,BaseColor.BLACK);
            documento.open();
            documento.add(libro);
            documento.add(Chunk.NEWLINE);
            PdfPTable tabla = new PdfPTable(8);
            PdfPCell id = new PdfPCell(new Phrase("Id",f1));
            PdfPCell fp = new PdfPCell(new Phrase("Fecha Prestamo",f1));
            PdfPCell fd = new PdfPCell(new Phrase("Fecha Devolucion",f1));
            PdfPCell hora = new PdfPCell(new Phrase("Hora",f1));
            PdfPCell idlibro = new PdfPCell(new Phrase("Id L.",f1));
            PdfPCell nombre = new PdfPCell(new Phrase("Nombre Libro",f1));
            PdfPCell dni = new PdfPCell(new Phrase("Codigo",f1));
            PdfPCell lugar = new PdfPCell(new Phrase("Lugar",f1));
            float [] ancho = {2f, 5f, 5f, 3f, 2f, 6f, 5f, 4f};
            tabla.setWidths(ancho);
            tabla.addCell(id);
            tabla.addCell(fp);
            tabla.addCell(fd);
            tabla.addCell(hora);
            tabla.addCell(idlibro);
            tabla.addCell(nombre);
            tabla.addCell(dni);
            tabla.addCell(lugar);
            for(int i=0;i<tabladatos.getRowCount();i++){
                 for(int j=0;j<tabladatos.getColumnCount();j++){
                     PdfPCell datos = new PdfPCell(new Phrase(tabladatos.getValueAt(i, j).toString(),f1));
                     tabla.addCell(datos);
                 }
             }

            documento.add(Chunk.NEWLINE);
            documento.add(tabla);
            documento.close();
        } catch (Exception e) {
        }
         try {
            String ruta= System.getProperty("user.home");
            ProcessBuilder p = new ProcessBuilder();
            p.command("cmd.exe","/c",ruta+"/Desktop/Reporte_Libros.pdf");
            p.start();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabladatos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabladatos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255), 3));
        tabladatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "fecha prestamo", "fecha devolucion", "hora ", "id_libro", "nombre libro", "codigo", "lugar"
            }
        ));
        jScrollPane1.setViewportView(tabladatos);
        if (tabladatos.getColumnModel().getColumnCount() > 0) {
            tabladatos.getColumnModel().getColumn(0).setMinWidth(50);
            tabladatos.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabladatos.getColumnModel().getColumn(0).setMaxWidth(50);
            tabladatos.getColumnModel().getColumn(3).setMinWidth(70);
            tabladatos.getColumnModel().getColumn(3).setPreferredWidth(70);
            tabladatos.getColumnModel().getColumn(3).setMaxWidth(70);
            tabladatos.getColumnModel().getColumn(4).setMinWidth(70);
            tabladatos.getColumnModel().getColumn(4).setPreferredWidth(70);
            tabladatos.getColumnModel().getColumn(4).setMaxWidth(70);
            tabladatos.getColumnModel().getColumn(5).setMinWidth(300);
            tabladatos.getColumnModel().getColumn(5).setPreferredWidth(300);
            tabladatos.getColumnModel().getColumn(5).setMaxWidth(300);
            tabladatos.getColumnModel().getColumn(6).setMinWidth(100);
            tabladatos.getColumnModel().getColumn(6).setPreferredWidth(100);
            tabladatos.getColumnModel().getColumn(6).setMaxWidth(100);
            tabladatos.getColumnModel().getColumn(7).setMinWidth(90);
            tabladatos.getColumnModel().getColumn(7).setPreferredWidth(90);
            tabladatos.getColumnModel().getColumn(7).setMaxWidth(90);
        }

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("LISTA DE LIBROS PRESTADOS");

        jButton2.setBackground(new java.awt.Color(51, 102, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("CLIENTE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 102, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("PRESTAMO");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(51, 102, 255));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("IMPRIMIR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(51, 102, 255));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("REGISTRO C.");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1067, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGap(279, 279, 279)
                .addComponent(jLabel1)
                .addGap(75, 75, 75)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        prestamo ventana = new prestamo();
        
        ventana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        form_cliente ventana = new form_cliente();
     
        ventana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        imprimir();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        clientes ventana = new clientes();
        ventana .setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tabla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabladatos;
    // End of variables declaration//GEN-END:variables
}