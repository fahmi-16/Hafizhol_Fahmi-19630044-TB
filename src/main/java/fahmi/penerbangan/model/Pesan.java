package fahmi.penerbangan.model;

import fahmi.penerbangan.db.MyConnection;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Pesan {
    private String id_keberangkatan, id_penerbangan, id_kelas,tanggal, nama, alamat, telepon, harga, bayar, kembali;
    public MyConnection database;
    public Connection connection;

//    CONSTRUKTOR
    public Pesan() {
    }

    public Pesan(String id_keberangkatan, String id_penerbangan, String id_kelas, String nama,String tanggal, String alamat, String telepon, String bayar, String kembali, String harga) {
        this.id_keberangkatan = id_keberangkatan;
        this.id_penerbangan = id_penerbangan;
        this.id_kelas = id_kelas;
        this.tanggal = tanggal;
        this.nama = nama;
        this.alamat = alamat;
        this.telepon = telepon;
        this.harga = harga;
        this.bayar = bayar;
        this.kembali = kembali;
    }
    
    
//    GEETER
    public String getId_keberangkatan() {
        return id_keberangkatan;
    }
    
    public String getId_kelas() {
        return id_kelas;
    }

    public String getId_penerbangan() {
        return id_penerbangan;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getTelepon() {
        return telepon;
    }

    public String getHarga() {
        return harga;
    }

    public String getBayar() {
        return bayar;
    }

    public String getKembali() {
        return kembali;
    }

    public String getTanggal() {
        return tanggal;
    }
    
    
//    SEETER
    public void setId_kelas(String id_kelas) {
        this.id_kelas = id_kelas;
    }
    
    public void setId_keberangkatan(String id_keberangkatan) {
        this.id_keberangkatan = id_keberangkatan;
    }

    public void setId_penerbangan(String id_penerbangan) {
        this.id_penerbangan = id_penerbangan;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
    
    public void setBayar(String bayar) {
        this.bayar = bayar;
    }
    
    public void setKembali(String kembali) {
        this.kembali = kembali;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    
//    CREATE
    public boolean create(){
        String insertSQL = "INSERT INTO keberangkatan VALUES (?,?,?,?,?,?)";
        String insertSQLTransaksi = "INSERT INTO transaksi VALUES (?,?,?,?,?)";
//        System.out.println(insertSQL);

        this.database = new MyConnection();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(insertSQL);
            
            ps.setString(1, this.getId_keberangkatan());
            ps.setString(2, this.getId_penerbangan());
            ps.setString(3, this.getId_kelas());
            ps.setString(4, this.getNama());
            ps.setString(5, this.getAlamat());
            ps.setString(6, this.getTelepon());
            
            ps.execute();
            
            PreparedStatement psT = this.connection.prepareStatement(insertSQLTransaksi);
            psT.setString(1, this.getId_keberangkatan());
            psT.setString(2, this.getHarga());
            psT.setString(3, this.getBayar());
            psT.setString(4, this.getKembali());
            psT.setString(5, this.getTanggal());
            psT.execute();
            return true;
        }catch (SQLException ex) {
            System.out.println("Insert Gagal");
        }
        return false;
    }
    
//    READ
    public ArrayList<Pesan> read(){
//        System.out.println(kata);
        String readSQL = "SELECT * FROM keberangkatan";
        ArrayList<Pesan> list = new ArrayList<>();
        
        this.database = new MyConnection();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(readSQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                Pesan pesan = new Pesan();
                pesan.setId_keberangkatan(rs.getString(1));
                pesan.setId_penerbangan(rs.getString(2));
                pesan.setId_kelas(rs.getString(3));
                pesan.setNama(rs.getString(4));
                pesan.setAlamat(rs.getString(5));
                pesan.setTelepon(rs.getString(6));
                
                list.add(pesan);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Pesan.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error SQL");
        }
        
        return null;
    }
    
//    UPDATE
    public boolean update(){
        String updateSQL = "UPDATE keberangkatan SET nama= ?, alamat = ?, telepon = ? WHERE id_keberangkatan= ? ";
//        System.out.println(updateSQL);

        this.database = new MyConnection();
        this.connection = this.database.getConnection();

        try {
            PreparedStatement ps = this.connection.prepareStatement(updateSQL);
            ps.setString(1, this.getNama());
            ps.setString(2, this.getAlamat());
            ps.setString(3, this.getTelepon());
            ps.setString(4, this.getId_keberangkatan());
            ps.execute();
            return true;
        }catch (SQLException ex) {
            System.out.println("Update Gagal");
        }
        return false;
    }
    
//    DELETE
    public boolean delete(){
        String deleteSQL = "DELETE FROM keberangkatan WHERE id_keberangkatan= ?";
        
        this.database = new MyConnection();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(deleteSQL);
            ps.setString(1, this.getId_keberangkatan());;
            ps.execute();
            return true;
        }catch (SQLException ex) {
            System.out.println("Delete Gagal");
        }
        
        return false;
    }
    
    
    public ArrayList<Pesan> readBerangkat(String kata){
//        System.out.println(kata);
        String readSQL = "SELECT * FROM keberangkatan WHERE id_penerbangan = '"+kata+"'";
        ArrayList<Pesan> list = new ArrayList<>();
        
        this.database = new MyConnection();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(readSQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                Pesan pesan = new Pesan();
                pesan.setId_keberangkatan(rs.getString(1));
                pesan.setId_penerbangan(rs.getString(2));
                pesan.setId_kelas(rs.getString(3));
                pesan.setNama(rs.getString(4));
                pesan.setAlamat(rs.getString(5));
                pesan.setTelepon(rs.getString(6));
                
                list.add(pesan);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Pesan.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error SQL");
        }
        
        return null;
    }
    
    //    CETAK KEBERANGKATAN
    public boolean cetakBerangkat(){
        try {
            File namafile = new File("src\\main\\java\\fahmi\\penerbangan\\report\\rBerangkat.jasper");
            JasperPrint jp = JasperFillManager.fillReport(namafile.getPath(), null, database.getConnection());
            JasperViewer.viewReport(jp, false);
        } catch (JRException e) {
//            JOptionPane.showMessageDialog(rootPane, e);
            System.out.println(e);
        }
        
        return false;
    }
    
    //    CETAK TRANSAKSI
    public boolean cetakTransaksi(){
        try {
            File namafile = new File("src\\main\\java\\fahmi\\penerbangan\\report\\rTransaksi.jasper");
            JasperPrint jp = JasperFillManager.fillReport(namafile.getPath(), null, database.getConnection());
            JasperViewer.viewReport(jp, false);
        } catch (JRException e) {
//            JOptionPane.showMessageDialog(rootPane, e);
            System.out.println(e);
        }
        
        return false;
    }
}
