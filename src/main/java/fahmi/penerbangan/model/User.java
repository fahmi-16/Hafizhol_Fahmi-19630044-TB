
package fahmi.penerbangan.model;

import fahmi.penerbangan.db.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User {
    private String user;
    private String pass;
    private String level;
    public MyConnection database;
    public Connection connection;
    
//    CONSTRUKTOR

    public User() {
    }

    public User(String user, String pass, String level) {
        this.user = user;
        this.pass = pass;
        this.level = level;
    }
    
    
//    CREATE
    public boolean create(){
        String insertSQL = "INSERT INTO user VALUES (?,?,?)";
//        System.out.println(insertSQL);

        this.database = new MyConnection();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(insertSQL);
            ps.setString(1, this.getUser());
            ps.setString(2, this.getPass());
            ps.setString(3, this.getLevel());
            ps.execute();
            return true;
        }catch (SQLException ex) {
            System.out.println("Insert Gagal");
        }
        return false;
    }
    
//    READ
    public ArrayList<User> read(){
        String selectSQL = "SELECT * FROM user";
        ArrayList<User> list = new ArrayList<>();
        
        this.database = new MyConnection();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(selectSQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                User user = new User();
                user.setUser(rs.getString(1));
                user.setPass(rs.getString(2));
                user.setLevel(rs.getString(3));

                
                list.add(user);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error SQL");
        }
        
        return null;
    }
    
//    UPDATE
    public boolean update(){
        String updateSQL = "UPDATE user SET password = ? ,level = ? WHERE user= ? ";
        System.out.println(updateSQL);

        this.database = new MyConnection();
        this.connection = this.database.getConnection();

        try {
            PreparedStatement ps = this.connection.prepareStatement(updateSQL);
            ps.setString(1, this.getPass());
            ps.setString(2, this.getLevel());
            ps.setString(3, this.getUser());
            ps.execute();
            return true;
        }catch (SQLException ex) {
            System.out.println("Update Gagal");
        }
        return false;
    }
    
//    DELETE
    public boolean delete(){
        String deleteSQL = "DELETE FROM user WHERE user= ? ";
//        System.out.println(deleteSQL);
        
        this.database = new MyConnection();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(deleteSQL);
            ps.setString(1, this.getUser());
            ps.execute();
            return true;
        }catch (SQLException ex) {
            System.out.println("Delete Gagal");
        }
        
        return false;
    }
    
//    SEARCH
    public ArrayList<User> search(String kata){
//        System.out.println(kata);
        String searchSQL = "SELECT * FROM user WHERE user LIKE '%"+kata+"%' OR level LIKE '%"+kata+"%'";
        ArrayList<User> list = new ArrayList<>();
        
        this.database = new MyConnection();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(searchSQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                User user = new User();
                user.setUser(rs.getString(1));
                user.setPass(rs.getString(2));
                user.setLevel(rs.getString(3));
                
                list.add(user);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error SQL");
        }
        
        return null;
    }
    
//    GETTER
    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getLevel() {
        return level;
    }

    public MyConnection getDatabase() {
        return database;
    }

    public Connection getConnection() {
        return connection;
    }
    
//    SETTER

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setDatabase(MyConnection database) {
        this.database = database;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
