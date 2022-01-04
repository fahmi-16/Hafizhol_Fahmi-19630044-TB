
package fahmi.penerbangan.model;

import fahmi.penerbangan.db.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Kelas {
    String id_kelas, id_penerbangan, kelas;
    int kursi,harga;
    double bagasi;
    public MyConnection database;
    public Connection connection;
    
//    CONSTRUKTOR
    public Kelas() {
    }

    public Kelas(String id_kelas, String id_penerbangan, String kelas, int kursi, double bagasi, int harga) {
        this.id_kelas = id_kelas;
        this.id_penerbangan = id_penerbangan;
        this.kelas = kelas;
        this.kursi = kursi;
        this.bagasi = bagasi;
        this.harga = harga;
    }
    
//    GEETER
    public String getId_kelas() {
        return id_kelas;
    }

    public String getId_penerbangan() {
        return id_penerbangan;
    }

    public String getKelas() {
        return kelas;
    }

    public int getKursi() {
        return kursi;
    }

    public double getBagasi() {
        return bagasi;
    }

    public int getHarga() {
        return harga;
    }
    
//    SEETER
    public void setId_kelas(String id_kelas) {
        this.id_kelas = id_kelas;
    }

    public void setId_penerbangan(String no_pesawat) {
        this.id_penerbangan = no_pesawat;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public void setKursi(int kursi) {
        this.kursi = kursi;
    }

    public void setBagasi(double bagasi) {
        this.bagasi = bagasi;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
    
//    CREATE
    public boolean create(){
        String insertSQL = "INSERT INTO kelas VALUES (?,?,?,?,?,?)";
//        System.out.println(insertSQL);

        this.database = new MyConnection();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(insertSQL);
            
            ps.setString(1, this.getId_kelas());
            ps.setString(2, this.getId_penerbangan());
            ps.setString(3, this.getKelas());
            ps.setInt(4, this.getKursi());
            ps.setDouble(5, this.getBagasi());
            ps.setDouble(6, this.getHarga());
            ps.execute();
            return true;
        }catch (SQLException ex) {
            System.out.println("Insert Gagal");
        }
        return false;
    }
    
//    READ
    public ArrayList<Kelas> read(String id_penerbangan){
//        System.out.println(no_pesawat);
        String selectSQL = "SELECT * FROM kelas WHERE id_penerbangan LIKE '%"+id_penerbangan+"%'";
        ArrayList<Kelas> list = new ArrayList<>();
        
        this.database = new MyConnection();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(selectSQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                Kelas kelasT = new Kelas();
                kelasT.setId_kelas(rs.getString(1));
                kelasT.setId_penerbangan(rs.getString(2));
                kelasT.setKelas(rs.getString(3));
                kelasT.setKursi(rs.getInt(4));
                kelasT.setBagasi(rs.getDouble(5));
                kelasT.setHarga(rs.getInt(6));

                list.add(kelasT);
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
        String updateSQL = "UPDATE kelas SET kelas= ?, kursi = ?, bagasi = ?, harga = ? WHERE id_kelas= ? ";
//        System.out.println(updateSQL);

        this.database = new MyConnection();
        this.connection = this.database.getConnection();

        try {
            PreparedStatement ps = this.connection.prepareStatement(updateSQL);
            
            ps.setString(1, this.getKelas());
            ps.setInt(2, this.getKursi());
            ps.setDouble(3, this.getBagasi());
            ps.setDouble(4, this.getHarga());
            ps.setString(5, this.getId_kelas());
            
            ps.execute();
            return true;
        }catch (SQLException ex) {
            System.out.println("Update Gagal");
        }
        return false;
    }
    
//    DELETE
    public boolean delete(){
        String deleteSQL = "DELETE FROM kelas WHERE id_kelas= ?";
        
        this.database = new MyConnection();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(deleteSQL);
            ps.setString(1, this.getId_kelas());
            ps.execute();
            return true;
        }catch (SQLException ex) {
            System.out.println("Delete Gagal");
        }
        
        return false;
    }
    
    
//    KODING SAGAN FORM PESAN FORM
    //    READ
    public ArrayList<Kelas> readKelas(String id_kelas){
//        System.out.println(no_pesawat);
        String selectSQL = "SELECT * FROM kelas WHERE id_kelas LIKE '%"+id_kelas+"%'";
        ArrayList<Kelas> list = new ArrayList<>();
        
        this.database = new MyConnection();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(selectSQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                Kelas kelasT = new Kelas();
                kelasT.setId_kelas(rs.getString(1));
                kelasT.setId_penerbangan(rs.getString(2));
                kelasT.setKelas(rs.getString(3));
                kelasT.setKursi(rs.getInt(4));
                kelasT.setBagasi(rs.getDouble(5));
                kelasT.setHarga(rs.getInt(6));

                list.add(kelasT);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Pesawat.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error SQL");
        }
        
        return null;
    }
}
