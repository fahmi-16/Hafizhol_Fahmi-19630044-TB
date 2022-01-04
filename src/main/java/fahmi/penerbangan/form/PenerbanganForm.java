/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahmi.penerbangan.form;

import fahmi.penerbangan.model.Kelas;
import fahmi.penerbangan.model.Penerbangan;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fahmi
 */
public class PenerbanganForm extends javax.swing.JFrame {
//    KODING KU
    private String no_pesawat, nama_pesawat, maskapai;
    private CariPesawatForm caripesawatform = null;
    
    
    //    SEETER
    public void setNo_pesawat(String no_pesawat) {
        this.no_pesawat = no_pesawat;
    }

    public void setNama_pesawat(String nama_pesawat) {
        this.nama_pesawat = nama_pesawat;
    }

    public void setMaskapai(String maskapai) {
        this.maskapai = maskapai;
    }
    
//        SAGAN PILIHAN PESAWAT
    public void itemTerpilihPesawat(){
        CariPesawatForm caripesawatform = new CariPesawatForm();
        caripesawatform.penerbanganform = this;
        no_pesawatTF.setText(no_pesawat);
        nama_pesawatTF.setText(nama_pesawat);
        maskapaiTF.setText(maskapai);
    }


//    KODING KU
    Penerbangan penerbangan = new Penerbangan();
    Kelas kelas = new Kelas();
    
    public void tampilData(){
        ArrayList<Penerbangan> list = penerbangan.read();
        
        DefaultTableModel tableModel = (DefaultTableModel) tbPenerbangan.getModel();
        tableModel.setRowCount(0);
        
        Object[] row = new Object[8];
        
        if(list.size() > 0){
//            System.out.println("Jalan");
            int kodeAwal = 0;
            for (int i = 0; i<list.size(); i++){
                row[0] = list.get(i).getId_penerbangan();
                row[1] = list.get(i).getNo_pesawat();
                row[2] = list.get(i).getNama_pesawat();
                row[3] = list.get(i).getMaskapai();
                row[4] = list.get(i).getTanggal();
                row[5] = list.get(i).getJam();
                row[6] = list.get(i).getAsal();
                row[7] = list.get(i).getTujuan();
                
//                KODE OTOMATIS
                String kodeAsli = list.get(i).getId_penerbangan();
                int kodeAngka =(Integer.parseInt(kodeAsli.substring(3))+1);
                System.out.println(kodeAngka);
                
                if (kodeAwal<kodeAngka){
                    kodeAwal = kodeAngka;
                }
                
                id_penerbanganTF.setText(String.valueOf("PE-"+kodeAwal));
                tableModel.addRow(row);
            }
        }else if(list.size() == 0){
            id_penerbanganTF.setText("PE-1");
        }
    }
    
    public void tampilDataKelas(){
        ArrayList<Kelas> list = kelas.read(id_penerbanganTF.getText());
        
        DefaultTableModel tableModel = (DefaultTableModel) tbKelas.getModel();
        tableModel.setRowCount(0);
        
        Object[] row = new Object[4];
        
        for (int i = 0; i<list.size(); i++){
            row[0] = list.get(i).getKelas();
            row[1] = list.get(i).getKursi();
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
        
        no_pesawatTF.setText("");
        nama_pesawatTF.setText("");
        maskapaiTF.setText("");
        id_penerbanganTF.setText("");
        tanggalDC.setCalendar(null);
        jamTF.setText("");
        menitTF.setText("");
        asalTF.setText("");
        tujuanTF.setText("");
        BTtambah.setEnabled(true);
        BTubah.setEnabled(false);
        BThapus.setEnabled(false);
//        tampilDataKelas();
        tampilData();
      }
    
    
    /**
     * Creates new form PenerbanganForm
     */
    public PenerbanganForm() {
        initComponents();
        reset();
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
        no_pesawatTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nama_pesawatTF = new javax.swing.JTextField();
        maskapaiTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        BTcari_pesawat = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        id_penerbanganTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        asalTF = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tujuanTF = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tanggalDC = new com.toedter.calendar.JDateChooser();
        menitTF = new javax.swing.JTextField();
        jamTF = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPenerbangan = new javax.swing.JTable();
        cariTF = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        BTkeluar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        BTtambah = new javax.swing.JButton();
        BTbersih = new javax.swing.JButton();
        BThapus = new javax.swing.JButton();
        BTubah = new javax.swing.JButton();
        btCetakPesawat = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        BTseting_kelas = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbKelas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("No Pesawat");

        no_pesawatTF.setEnabled(false);

        jLabel2.setText("Nama Pesawat");

        nama_pesawatTF.setEnabled(false);

        maskapaiTF.setEnabled(false);

        jLabel5.setText("Maskapai");

        BTcari_pesawat.setText("Cari Pesawat");
        BTcari_pesawat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTcari_pesawatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 144, Short.MAX_VALUE)
                        .addComponent(BTcari_pesawat))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(no_pesawatTF)
                            .addComponent(maskapaiTF)
                            .addComponent(nama_pesawatTF))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(no_pesawatTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nama_pesawatTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(maskapaiTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTcari_pesawat)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setText("Id Penerbangan");

        id_penerbanganTF.setEnabled(false);

        jLabel4.setText("Tanggal");

        jLabel6.setText("Jam Berangkat");

        jLabel7.setText("Asal");

        jLabel8.setText("Tujuan");

        tanggalDC.setDateFormatString("yyyy-MM-dd");

        jLabel11.setText(":");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addComponent(tujuanTF, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(asalTF, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(id_penerbanganTF, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                .addComponent(tanggalDC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jamTF, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(menitTF, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)))))
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
                    .addComponent(jLabel6)
                    .addComponent(menitTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jamTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(asalTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tujuanTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setText("Daftar Penerbangan");

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

        BTkeluar.setText("Keluar");
        BTkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTkeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cariTF, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BTkeluar)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(BTkeluar)
                .addContainerGap())
        );

        BTtambah.setText("Tambah");
        BTtambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTtambahActionPerformed(evt);
            }
        });

        BTbersih.setText("Bersih");
        BTbersih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTbersihActionPerformed(evt);
            }
        });

        BThapus.setText("Hapus");
        BThapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BThapusActionPerformed(evt);
            }
        });

        BTubah.setText("Ubah");
        BTubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTubahActionPerformed(evt);
            }
        });

        btCetakPesawat.setText("Cetak");
        btCetakPesawat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCetakPesawatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BTtambah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BThapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTubah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btCetakPesawat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTbersih, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTtambah)
                    .addComponent(BTbersih)
                    .addComponent(BTubah))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BThapus)
                    .addComponent(btCetakPesawat))
                .addContainerGap())
        );

        jLabel12.setText("Kelas");

        BTseting_kelas.setText("Seting");
        BTseting_kelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTseting_kelasActionPerformed(evt);
            }
        });

        tbKelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kelas", "Kursi", "bagasi", "Harga"
            }
        ));
        tbKelas.setEnabled(false);
        jScrollPane2.setViewportView(tbKelas);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(BTseting_kelas)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(BTseting_kelas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BTcari_pesawatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTcari_pesawatActionPerformed
        CariPesawatForm caripesawatform = new CariPesawatForm();
        caripesawatform.penerbanganform = this;
        caripesawatform.setVisible(true);
    }//GEN-LAST:event_BTcari_pesawatActionPerformed

    private void tbPenerbanganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPenerbanganMouseClicked

        id_penerbanganTF.setText(tbPenerbangan.getValueAt(tbPenerbangan.getSelectedRow(), 0).toString());
        no_pesawatTF.setText(tbPenerbangan.getValueAt(tbPenerbangan.getSelectedRow(), 1).toString());
        nama_pesawatTF.setText(tbPenerbangan.getValueAt(tbPenerbangan.getSelectedRow(), 2).toString());
        maskapaiTF.setText(tbPenerbangan.getValueAt(tbPenerbangan.getSelectedRow(), 3).toString());
        tanggalDC.setDate(Date.valueOf(tbPenerbangan.getValueAt(tbPenerbangan.getSelectedRow(), 4).toString()));
        jamTF.setText(tbPenerbangan.getValueAt(tbPenerbangan.getSelectedRow(), 5).toString().substring(0,2));
        menitTF.setText(tbPenerbangan.getValueAt(tbPenerbangan.getSelectedRow(), 5).toString().substring(3,5));
        asalTF.setText(tbPenerbangan.getValueAt(tbPenerbangan.getSelectedRow(), 6).toString());
        tujuanTF.setText(tbPenerbangan.getValueAt(tbPenerbangan.getSelectedRow(), 7).toString());
        tampilDataKelas();
        BTtambah.setEnabled(false);
        BTubah.setEnabled(true);
        BThapus.setEnabled(true);
        no_pesawatTF.setEnabled(false);
    }//GEN-LAST:event_tbPenerbanganMouseClicked

    private void cariTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariTFKeyTyped
        tampilCari();
    }//GEN-LAST:event_cariTFKeyTyped

    private void btCetakPesawatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCetakPesawatActionPerformed
        penerbangan.cetakPenerbangan();
    }//GEN-LAST:event_btCetakPesawatActionPerformed

    private void BTtambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTtambahActionPerformed

        penerbangan.setId_penerbangan(id_penerbanganTF.getText());
        penerbangan.setNo_pesawat(no_pesawatTF.getText());
        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat format = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(format.format(tanggalDC.getDate()));
        penerbangan.setTanggal(tanggal);
        penerbangan.setJam(jamTF.getText()+":"+menitTF.getText()+":00");
        penerbangan.setAsal(asalTF.getText());
        penerbangan.setTujuan(tujuanTF.getText());

        if (penerbangan.create()){
            tampilData();
            JOptionPane.showMessageDialog(null, "Berhasil Di Simpan");
            reset();
        }else{
            JOptionPane.showMessageDialog(null, "Gagal Di Simpan");
        }
    }//GEN-LAST:event_BTtambahActionPerformed

    private void BTbersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTbersihActionPerformed
        reset();
    }//GEN-LAST:event_BTbersihActionPerformed

    private void BThapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BThapusActionPerformed
        try {
            int jawab;

            if ((jawab = JOptionPane.showConfirmDialog(null, "Ingin menghapus data?", "konfirmasi", JOptionPane.YES_NO_OPTION)) == 0) {
                penerbangan.setId_penerbangan(id_penerbanganTF.getText());

                if (penerbangan.delete()){
                    tampilData();
                    JOptionPane.showMessageDialog(null, "Berhasil Di Hapus");
                    reset();
                }else{
                    JOptionPane.showMessageDialog(null, "Gagal Di Hapus");
                }

                tampilData();
                reset();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_BThapusActionPerformed

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

    private void BTubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTubahActionPerformed
        penerbangan.setId_penerbangan(id_penerbanganTF.getText());
        penerbangan.setNo_pesawat(no_pesawatTF.getText());
        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat format = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(format.format(tanggalDC.getDate()));
        penerbangan.setTanggal(tanggal);
        penerbangan.setJam(jamTF.getText()+":"+menitTF.getText()+":00");
        penerbangan.setAsal(asalTF.getText());
        penerbangan.setTujuan(tujuanTF.getText());

        if (penerbangan.update()){
            tampilData();
            JOptionPane.showMessageDialog(null, "Berhasil Di Ubah");
            reset();
        }else{
            JOptionPane.showMessageDialog(null, "Gagal Di Ubah");
        }
    }//GEN-LAST:event_BTubahActionPerformed

    private void BTseting_kelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTseting_kelasActionPerformed
        if (no_pesawatTF.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Pilih penerbangan terlebih dahulu");
        }else{
            KelasForm kelasform = new KelasForm();
            kelasform.setId_penerbangan(id_penerbanganTF.getText());
            kelasform.setVisible(true);
        }
    }//GEN-LAST:event_BTseting_kelasActionPerformed

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
            java.util.logging.Logger.getLogger(PenerbanganForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PenerbanganForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PenerbanganForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PenerbanganForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PenerbanganForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTbersih;
    private javax.swing.JButton BTcari_pesawat;
    private javax.swing.JButton BThapus;
    private javax.swing.JButton BTkeluar;
    private javax.swing.JButton BTseting_kelas;
    private javax.swing.JButton BTtambah;
    private javax.swing.JButton BTubah;
    private javax.swing.JTextField asalTF;
    private javax.swing.JButton btCetakPesawat;
    private javax.swing.JTextField cariTF;
    private javax.swing.JTextField id_penerbanganTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jamTF;
    private javax.swing.JTextField maskapaiTF;
    private javax.swing.JTextField menitTF;
    private javax.swing.JTextField nama_pesawatTF;
    private javax.swing.JTextField no_pesawatTF;
    private com.toedter.calendar.JDateChooser tanggalDC;
    private javax.swing.JTable tbKelas;
    private javax.swing.JTable tbPenerbangan;
    private javax.swing.JTextField tujuanTF;
    // End of variables declaration//GEN-END:variables
}
