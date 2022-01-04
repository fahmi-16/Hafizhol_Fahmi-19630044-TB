
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

public class Pesawat {
    private String no_pesawat;
    private String nama_pesawat;
    private String maskapai;
    public MyConnection database;
    public Connection connection;
    
//    CREATE
    public boolean create(){
        String insertSQL = "INSERT INTO pesawat VALUES (?,?,?)";
//        System.out.println(insertSQL);

        this.database = new MyConnection();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(insertSQL);
            
            ps.setString(1, this.getNo_pesawat());
            ps.setString(2, this.getNama_pesawat());
            ps.setString(3, this.getMaskapai());
            ps.execute();
            return true;
        }catch (SQLException ex) {
            System.out.println("Insert Gagal");
        }
        return false;
    }
    
//    READ
    public ArrayList<Pesawat> read(){
        String selectSQL = "SELECT * FROM pesawat";
        ArrayList<Pesawat> list = new ArrayList<>();
        
        this.database = new MyConnection();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(selectSQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                Pesawat pesawat = new Pesawat();
                pesawat.setNo_pesawat(rs.getString(1));
                pesawat.setNama_pesawat(rs.getString(2));
                pesawat.setMaskapai(rs.getString(3));

                list.add(pesawat);
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
        String updateSQL = "UPDATE pesawat SET nama_pesawat= ?, maskapai = ? WHERE no_pesawat= ? ";
//        System.out.println(updateSQL);

        this.database = new MyConnection();
        this.connection = this.database.getConnection();

        try {
            PreparedStatement ps = this.connection.prepareStatement(updateSQL);
            ps.setString(1, this.getNama_pesawat());
            ps.setString(2, this.getMaskapai());
            ps.setString(3, this.getNo_pesawat());
            ps.execute();
            return true;
        }catch (SQLException ex) {
            System.out.println("Update Gagal");
        }
        return false;
    }
    
//    DELETE
    public boolean delete(){
        String deleteSQLpesawat = "DELETE FROM pesawat WHERE no_pesawat= ?";
        String deleteSQLkelas = "DELETE FROM kelas WHERE no_pesawat= ?";
//        System.out.println(deleteSQLpesawat);
//        System.out.println(deleteSQLkelas);
        
        this.database = new MyConnection();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement pspesawat = this.connection.prepareStatement(deleteSQLpesawat);
            PreparedStatement pskelas = this.connection.prepareStatement(deleteSQLkelas);
            pspesawat.setString(1, this.getNo_pesawat());
            pspesawat.execute();
            pskelas.setString(1, this.getNo_pesawat());
            pskelas.execute();
            return true;
        }catch (SQLException ex) {
            System.out.println("Delete Gagal");
        }
        
        return false;
    }
    
    
//    SEARCH
    public ArrayList<Pesawat> search(String kata){
//        System.out.println(kata);
        String searchSQL = "SELECT * FROM pesawat WHERE nama_pesawat LIKE '%"+kata+"%' OR no_pesawat LIKE '%"+kata+"%' OR maskapai LIKE '%"+kata+"%'";
        ArrayList<Pesawat> list = new ArrayList<>();
        
        this.database = new MyConnection();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(searchSQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                Pesawat pesawat = new Pesawat();
                pesawat.setNo_pesawat(rs.getString(1));
                pesawat.setNama_pesawat(rs.getString(2));
                pesawat.setMaskapai(rs.getString(3));
                
                list.add(pesawat);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Pesawat.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error SQL");
        }
        
        return null;
    }
    
//    CETAK PESAWAT
    public boolean cetakPesawat(){
        try {
            File namafile = new File("src\\main\\java\\fahmi\\penerbangan\\report\\rPesawat.jasper");
            JasperPrint jp = JasperFillManager.fillReport(namafile.getPath(), null, database.getConnection());
            JasperViewer.viewReport(jp, false);
        } catch (JRException e) {
//            JOptionPane.showMessageDialog(rootPane, e);
            System.out.println(e);
        }
        
        return false;
    }
    
//    CONSTRUKTOR
    public Pesawat() {
    }
    public Pesawat(String no_pesawat, String nama_pesawat, String maskapai) {
        this.no_pesawat = no_pesawat;
        this.nama_pesawat = nama_pesawat;
        this.maskapai = maskapai;
    }
    
//    GEETER
    public String getNo_pesawat() {
        return no_pesawat;
    }

    public String getNama_pesawat() {
        return nama_pesawat;
    }

    public String getMaskapai() {
        return maskapai;
    }
    
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
    
}
