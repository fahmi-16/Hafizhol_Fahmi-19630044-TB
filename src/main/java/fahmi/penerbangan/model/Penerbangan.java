
package fahmi.penerbangan.model;

import fahmi.penerbangan.db.MyConnection;
import fahmi.penerbangan.form.PenerbanganForm;
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

public class Penerbangan {
    private String id_penerbangan,no_pesawat,nama_pesawat,maskapai,tanggal,jam,asal,tujuan;
    public MyConnection database;
    public Connection connection;
    
//    CONSTRUKTOR
    public Penerbangan() {
    }

    public Penerbangan(String id_penerbangan, String no_pesawat, String nama_pesawat, String maskapai, String tanggal, String jam, String asal, String tujuan) {
        this.id_penerbangan = id_penerbangan;
        this.no_pesawat = no_pesawat;
        this.nama_pesawat = nama_pesawat;
        this.maskapai = maskapai;
        this.tanggal = tanggal;
        this.jam = jam;
        this.asal = asal;
        this.tujuan = tujuan;
    }

    
//    GEETER
    public String getId_penerbangan() {
        return id_penerbangan;
    }

    public String getNo_pesawat() {
        return no_pesawat;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getJam() {
        return jam;
    }

    public String getAsal() {
        return asal;
    }

    public String getTujuan() {
        return tujuan;
    }

    public String getNama_pesawat() {
        return nama_pesawat;
    }

    public String getMaskapai() {
        return maskapai;
    }
    
//    SEETER

    public void setId_penerbangan(String id_penerbangan) {
        this.id_penerbangan = id_penerbangan;
    }

    public void setNo_pesawat(String No_pesawat) {
        this.no_pesawat = No_pesawat;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public void setNama_pesawat(String nama_pesawat) {
        this.nama_pesawat = nama_pesawat;
    }

    public void setMaskapai(String maskapai) {
        this.maskapai = maskapai;
    }
    
    
//    CREATE
    public boolean create(){
        String insertSQL = "INSERT INTO penerbangan VALUES (?,?,?,?,?,?)";
//        System.out.println(insertSQL);

        this.database = new MyConnection();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(insertSQL);
            
            ps.setString(1, this.getId_penerbangan());
            ps.setString(2, this.getNo_pesawat());
            ps.setString(3, this.getTanggal());
            ps.setString(4, this.getJam());
            ps.setString(5, this.getAsal());
            ps.setString(6, this.getTujuan());
            ps.execute();
            return true;
        }catch (SQLException ex) {
            System.out.println("Insert Gagal");
        }
        return false;
    }
    
//    READ
    public ArrayList<Penerbangan> read(){
        String selectSQL = "SELECT A.id_penerbangan, A.no_pesawat, B.nama_pesawat, B.maskapai, A.tanggal, A.jam, A.asal, A.tujuan FROM penerbangan A JOIN pesawat B ON A.no_pesawat = B.no_pesawat ORDER BY A.tanggal ASC";
        ArrayList<Penerbangan> list = new ArrayList<>();
        
        this.database = new MyConnection();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(selectSQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                Penerbangan penerbangan = new Penerbangan();
                penerbangan.setId_penerbangan(rs.getString(1));
                penerbangan.setNo_pesawat(rs.getString(2));
                penerbangan.setNama_pesawat(rs.getString(3));
                penerbangan.setMaskapai(rs.getString(4));
                penerbangan.setTanggal(rs.getString(5));
                penerbangan.setJam(rs.getString(6));
                penerbangan.setAsal(rs.getString(7));
                penerbangan.setTujuan(rs.getString(8));

                list.add(penerbangan);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Pesawat.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error SQL");
        }
        
        return null;
    }
    
//    UPDATE
    public boolean update(){
        String updateSQL = "UPDATE penerbangan SET no_pesawat=?, tanggal=?, jam=?, asal=?, tujuan=? WHERE id_penerbangan= ? ";
//        System.out.println(updateSQL);
//        System.out.println(getId_penerbangan());
//        System.out.println(getNo_pesawat());
//        System.out.println(getTanggal());
//        System.out.println(getJam());
//        System.out.println(getAsal());
//        System.out.println(getTujuan());

        this.database = new MyConnection();
        this.connection = this.database.getConnection();

        try {
            PreparedStatement ps = this.connection.prepareStatement(updateSQL);
            
            ps.setString(1, this.getNo_pesawat());
            ps.setString(2, this.getTanggal());
            ps.setString(3, this.getJam());
            ps.setString(4, this.getAsal());
            ps.setString(5, this.getTujuan());
            ps.setString(6, this.getId_penerbangan());
            ps.execute();
            return true;
        }catch (SQLException ex) {
            System.out.println("Update Gagal");
        }
        return false;
    }
    
//    DELETE
    public boolean delete(){
        String deleteSQLpenerbangan = "DELETE FROM penerbangan WHERE id_penerbangan= ?";
        String deleteSQLkelas = "DELETE FROM kelas WHERE id_penerbangan= ?";
//        System.out.println(deleteSQLpesawat);
//        System.out.println(deleteSQLkelas);
        
        this.database = new MyConnection();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement pspesawat = this.connection.prepareStatement(deleteSQLpenerbangan);
            PreparedStatement pskelas = this.connection.prepareStatement(deleteSQLkelas);
            pspesawat.setString(1, this.getId_penerbangan());
            pspesawat.execute();
            pskelas.setString(1, this.getId_penerbangan());
            pskelas.execute();
            return true;
        }catch (SQLException ex) {
            System.out.println("Delete Gagal");
        }
        
        return false;
    }
    
//    SEARCH
    public ArrayList<Penerbangan> search(String kata){
//        System.out.println(kata);
        String searchSQL = "SELECT A.id_penerbangan, A.no_pesawat, B.nama_pesawat, B.maskapai, A.tanggal, A.jam, A.asal, A.tujuan FROM penerbangan A JOIN pesawat B ON A.no_pesawat = B.no_pesawat WHERE B.nama_pesawat LIKE '%"+kata+"%' OR A.no_pesawat LIKE '%"+kata+"%' OR B.maskapai LIKE '%"+kata+"%' OR A.id_penerbangan LIKE '%"+kata+"%' OR A.asal LIKE '%"+kata+"%' OR A.tujuan LIKE '%"+kata+"%' ORDER BY A.tanggal ASC";
        ArrayList<Penerbangan> list = new ArrayList<>();
        
        this.database = new MyConnection();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(searchSQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                Penerbangan penerbangan = new Penerbangan();
                penerbangan.setId_penerbangan(rs.getString(1));
                penerbangan.setNo_pesawat(rs.getString(2));
                penerbangan.setNama_pesawat(rs.getString(3));
                penerbangan.setMaskapai(rs.getString(4));
                penerbangan.setTanggal(rs.getString(5));
                penerbangan.setJam(rs.getString(6));
                penerbangan.setAsal(rs.getString(7));
                penerbangan.setTujuan(rs.getString(8));
                
                list.add(penerbangan);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Pesawat.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error SQL");
        }
        
        return null;
    }
    
//    CETAK PESAWAT
    public boolean cetakPenerbangan(){
        try {
            File namafile = new File("src\\main\\java\\fahmi\\penerbangan\\report\\rPenerbangan.jasper");
            JasperPrint jp = JasperFillManager.fillReport(namafile.getPath(), null, database.getConnection());
            JasperViewer.viewReport(jp, false);
        } catch (JRException e) {
//            JOptionPane.showMessageDialog(rootPane, e);
            System.out.println(e);
        }
        
        return false;
    }
    
    
//    KODING SAGAN CARI PENERBANGAN FORM
    //    SEARCH
    public ArrayList<Penerbangan> searchPenerbangan(String asal, String tujuan, String tanggal){
        String searchSQL = "SELECT A.id_penerbangan, A.no_pesawat, B.nama_pesawat, B.maskapai, A.tanggal, A.jam, A.asal, A.tujuan FROM penerbangan A JOIN pesawat B ON A.no_pesawat = B.no_pesawat WHERE A.asal LIKE '%"+asal+"%' AND A.tujuan LIKE '%"+tujuan+"%' AND A.tanggal LIKE '%"+tanggal+"%' ORDER BY A.tanggal ASC";
        ArrayList<Penerbangan> list = new ArrayList<>();
        
        this.database = new MyConnection();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(searchSQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                Penerbangan penerbangan = new Penerbangan();
                penerbangan.setId_penerbangan(rs.getString(1));
                penerbangan.setNo_pesawat(rs.getString(2));
                penerbangan.setNama_pesawat(rs.getString(3));
                penerbangan.setMaskapai(rs.getString(4));
                penerbangan.setTanggal(rs.getString(5));
                penerbangan.setJam(rs.getString(6));
                penerbangan.setAsal(rs.getString(7));
                penerbangan.setTujuan(rs.getString(8));
                
                list.add(penerbangan);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Pesawat.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error SQL");
        }
        
        return null;
    }
    
    public ArrayList<Penerbangan> searchPenerbangan(String asal, String tujuan){
        String searchSQL = "SELECT A.id_penerbangan, A.no_pesawat, B.nama_pesawat, B.maskapai, A.tanggal, A.jam, A.asal, A.tujuan FROM penerbangan A JOIN pesawat B ON A.no_pesawat = B.no_pesawat WHERE A.asal LIKE '%"+asal+"%' or A.tujuan LIKE '%"+tujuan+"%' ORDER BY A.tanggal ASC";
        ArrayList<Penerbangan> list = new ArrayList<>();
        
        this.database = new MyConnection();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(searchSQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                Penerbangan penerbangan = new Penerbangan();
                penerbangan.setId_penerbangan(rs.getString(1));
                penerbangan.setNo_pesawat(rs.getString(2));
                penerbangan.setNama_pesawat(rs.getString(3));
                penerbangan.setMaskapai(rs.getString(4));
                penerbangan.setTanggal(rs.getString(5));
                penerbangan.setJam(rs.getString(6));
                penerbangan.setAsal(rs.getString(7));
                penerbangan.setTujuan(rs.getString(8));
                
                list.add(penerbangan);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Pesawat.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error SQL");
        }
        
        return null;
    }
    
//    KODING SAGAN FORM PESAN FORM
//    SEARCH
    public ArrayList<Penerbangan> readPenerbangan(String kata){
//        System.out.println(kata);
        String readSQL = "SELECT A.id_penerbangan, A.no_pesawat, B.nama_pesawat, B.maskapai, A.tanggal, A.jam, A.asal, A.tujuan FROM penerbangan A JOIN pesawat B ON A.no_pesawat = B.no_pesawat WHERE A.id_penerbangan = '"+kata+"'";
        ArrayList<Penerbangan> list = new ArrayList<>();
        
        this.database = new MyConnection();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(readSQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                Penerbangan penerbangan = new Penerbangan();
                penerbangan.setId_penerbangan(rs.getString(1));
                penerbangan.setNo_pesawat(rs.getString(2));
                penerbangan.setNama_pesawat(rs.getString(3));
                penerbangan.setMaskapai(rs.getString(4));
                penerbangan.setTanggal(rs.getString(5));
                penerbangan.setJam(rs.getString(6));
                penerbangan.setAsal(rs.getString(7));
                penerbangan.setTujuan(rs.getString(8));
                
                list.add(penerbangan);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Pesawat.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error SQL");
        }
        
        return null;
    }
}
