/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fahmi.penerbangan.form;

import fahmi.penerbangan.model.Kelas;
import fahmi.penerbangan.model.Penerbangan;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fahmi
 */
public class CariPenerbanganForm extends javax.swing.JFrame {

//    KODING KU
    Penerbangan penerbangan = new Penerbangan();
    Kelas kelas = new Kelas();
    
    public void tampilData(){
        ArrayList<Penerbangan> list = penerbangan.read();
        
        DefaultTableModel tableModel = (DefaultTableModel) tbPenerbangan.getModel();
        tableModel.setRowCount(0);
        
        Object[] row = new Object[8];
        
        for (int i = 0; i<list.size(); i++){
            row[0] = list.get(i).getId_penerbangan();
            row[1] = list.get(i).getNo_pesawat();
            row[2] = list.get(i).getNama_pesawat();
            row[3] = list.get(i).getMaskapai();
            row[4] = list.get(i).getTanggal();
            row[5] = list.get(i).getJam();
            row[6] = list.get(i).getAsal();
            row[7] = list.get(i).getTujuan();

            tableModel.addRow(row);
        }
    }
    
    public void tampilDataKelas(){
        ArrayList<Kelas> list = kelas.read(id_penerbanganTF.getText());
        
        DefaultTableModel tableModel = (DefaultTableModel) tbKelas.getModel();
        tableModel.setRowCount(0);
        
        Object[] row = new Object[4];
        
        for (int i = 0; i<list.size(); i++){
            row[0] = list.get(i).getId_kelas();
            row[1] = list.get(i).getKelas();
            row[2] = list.get(i).getBagasi();
            row[3] = list.get(i).getHarga();

            tableModel.addRow(row);
        }

    }
    
    public void tampilCari(){
        ArrayList<Penerbangan> list = penerbangan.search(cariTF.getText());
        
        DefaultTableModel tableModel = (DefaultTableModel) tbPenerbangan.getModel();
        tableModel.setRowCount(0);
        
        Object[] row = new Object[8];
        
        if(list.size() > 0){
//            System.out.println("Jalan");
            for (int i = 0; i<list.size(); i++){
                row[0] = list.get(i).getId_penerbangan();
                row[1] = list.get(i).getNo_pesawat();
                row[2] = list.get(i).getNama_pesawat();
                row[3] = list.get(i).getMaskapai();
                row[4] = list.get(i).getTanggal();
                row[5] = list.get(i).getJam();
                row[6] = list.get(i).getAsal();
                row[7] = list.get(i).getTujuan();
                tableModel.addRow(row);
            }
        }
    }
    
    public void tampilCariPenerbangan(){
        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat format = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(format.format(tanggalDC.getDate()));
        
        ArrayList<Penerbangan> list = penerbangan.searchPenerbangan(asalTF.getText(),tujuanTF.getText(),tanggal);
        
        DefaultTableModel tableModel = (DefaultTableModel) tbPenerbangan.getModel();
        tableModel.setRowCount(0);
        
        Object[] row = new Object[8];
        
        if(list.size() > 0){
//            System.out.println("Jalan");
            for (int i = 0; i<list.size(); i++){
                row[0] = list.get(i).getId_penerbangan();
                row[1] = list.get(i).getNo_pesawat();
                row[2] = list.get(i).getNama_pesawat();
                row[3] = list.get(i).getMaskapai();
                row[4] = list.get(i).getTanggal();
                row[5] = list.get(i).getJam();
                row[6] = list.get(i).getAsal();
                row[7] = list.get(i).getTujuan();
                tableModel.addRow(row);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Tidak ada penerbangan di jadwal yang anda masukkan");
            tampilCariPenerbanganNoTanggal();
        }
    }
    
    public void tampilCariPenerbanganNoTanggal(){        
        ArrayList<Penerbangan> list = penerbangan.searchPenerbangan(asalTF.getText(),tujuanTF.getText());
        
        DefaultTableModel tableModel = (DefaultTableModel) tbPenerbangan.getModel();
        tableModel.setRowCount(0);
        
        Object[] row = new Object[8];
        
        if(list.size() > 0){
//            System.out.println("Jalan");
            for (int i = 0; i<list.size(); i++){
                row[0] = list.get(i).getId_penerbangan();
                row[1] = list.get(i).getNo_pesawat();
                row[2] = list.get(i).getNama_pesawat();
                row[3] = list.get(i).getMaskapai();
                row[4] = list.get(i).getTanggal();
                row[5] = list.get(i).getJam();
                row[6] = list.get(i).getAsal();
                row[7] = list.get(i).getTujuan();
                tableModel.addRow(row);
            }
        }else{
            reset();
            JOptionPane.showMessageDialog(null, "Tidak ada penerbangan sesuai awal dan tujuan anda");
        }
    }
    
    public void reset() {
        DefaultTableModel tableModel = (DefaultTableModel) tbKelas.getModel();
        tableModel.setRowCount(0);
        
        Object[] row = new Object[4];
        for (int i = 0; i<5; i++){
            row[0] = "";
            row[1] = "";
            row[2] = "";
            row[3] = "";

            tableModel.addRow(row);
        }
        
        id_penerbanganTF.setText("");
        tanggalDC.setCalendar(null);
        asalTF.setText("");
        tujuanTF.setText("");
        tampilData();
      }
    /** Creates new form CariPenerbanganForm */
    public CariPenerbanganForm() {
        initComponents();
        reset();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        id_penerbanganTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        asalTF = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tujuanTF = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tanggalDC = new com.toedter.calendar.JDateChooser();
        BTcari_penerbangan = new javax.swing.JButton();
        BTbersih = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbKelas = new javax.swing.JTable();
        BTkeluar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPenerbangan = new javax.swing.JTable();
        cariTF = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("Id Penerbangan");

        id_penerbanganTF.setEnabled(false);

        jLabel4.setText("Tanggal");

        jLabel7.setText("Asal");

        jLabel8.setText("Tujuan");

        tanggalDC.setDateFormatString("yyyy-MM-dd");

        BTcari_penerbangan.setText("Cari");
        BTcari_penerbangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTcari_penerbanganActionPerformed(evt);
            }
        });

        BTbersih.setText("Bersih");
        BTbersih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTbersihActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(id_penerbanganTF)
                            .addComponent(tanggalDC, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addComponent(tujuanTF, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(asalTF, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BTbersih)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTcari_penerbangan)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(id_penerbanganTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(tanggalDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(asalTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tujuanTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTcari_penerbangan)
                    .addComponent(BTbersih))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel12.setText("Kelas");

        tbKelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id Kelas", "Kelas", "bagasi", "Harga"
            }
        ));
        tbKelas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKelasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbKelas);

        BTkeluar.setText("Keluar");
        BTkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTkeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BTkeluar)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BTkeluar)
                .addGap(28, 28, 28))
        );

        jLabel9.setText("Daftar Penerbangan Yang Tersedia");

        tbPenerbangan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID penerbangan", "No Pesawat", "Nama Pesawat", "Maskapai", "Tanggal", "Jam", "Asal", "Tujuan"
            }
        ));
        tbPenerbangan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPenerbanganMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbPenerbangan);

        cariTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cariTFKeyTyped(evt);
            }
        });

        jLabel10.setText("Cari Berdasarkan Maskapai, Id penerbangan, No pesawat, Nama Pesawat, Asal Atau Tujuan");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(cariTF, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cariTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Untuk memesan tiket, pilih dulu penerbangannya,");

        jLabel2.setText("Lalu klik 2 kali pada kelas yang anda ingin pesan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbPenerbanganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPenerbanganMouseClicked

        id_penerbanganTF.setText(tbPenerbangan.getValueAt(tbPenerbangan.getSelectedRow(), 0).toString());
        tampilDataKelas();
    }//GEN-LAST:event_tbPenerbanganMouseClicked

    private void cariTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariTFKeyTyped
        tampilCari();
    }//GEN-LAST:event_cariTFKeyTyped

    private void BTkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTkeluarActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this,
            "Konfirmasi Keluar Aplikasi",
            "Yakin untuk keluar dari program",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_BTkeluarActionPerformed

    private void BTcari_penerbanganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTcari_penerbanganActionPerformed
        if(asalTF.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Masukan Asal penerbangan");
        }else if (tujuanTF.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Masukan Tujuan penerbangan");
        }else{
            try{
                String tampilan = "yyyy-MM-dd";
                SimpleDateFormat format = new SimpleDateFormat(tampilan);
                String tanggal = String.valueOf(format.format(tanggalDC.getDate()));
                tampilCariPenerbangan();
            }catch (Exception e){
                tampilCariPenerbanganNoTanggal();
            }
        }
    }//GEN-LAST:event_BTcari_penerbanganActionPerformed

    private void BTbersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTbersihActionPerformed
        reset();
    }//GEN-LAST:event_BTbersihActionPerformed

    private void tbKelasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKelasMouseClicked
        if(id_penerbanganTF.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Pilih Penerbangan");
        }else{
            PesanForm pesanform = new PesanForm(tbKelas.getValueAt(tbKelas.getSelectedRow(), 0).toString());
            pesanform.setVisible(true);
            dispose();
        }
        
    }//GEN-LAST:event_tbKelasMouseClicked

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
            java.util.logging.Logger.getLogger(CariPenerbanganForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CariPenerbanganForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CariPenerbanganForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CariPenerbanganForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CariPenerbanganForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTbersih;
    private javax.swing.JButton BTcari_penerbangan;
    private javax.swing.JButton BTkeluar;
    private javax.swing.JTextField asalTF;
    private javax.swing.JTextField cariTF;
    private javax.swing.JTextField id_penerbanganTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser tanggalDC;
    private javax.swing.JTable tbKelas;
    private javax.swing.JTable tbPenerbangan;
    private javax.swing.JTextField tujuanTF;
    // End of variables declaration//GEN-END:variables

}
