package fahmi.penerbangan.model;

import fahmi.penerbangan.db.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Login {
    private String user;
    private String pass;
    private String level;
    public MyConnection database;
    public Connection connection;
    
//    CONSTRUKTOR
    public Login() {
    }

    public Login(String user, String pass, String level) {
        this.user = user;
        this.pass = pass;
        this.level = level;
    }
    
//    SEARCH USER UNTUK MENDAPATKAN PASSWORD
    private ArrayList<User> search(String kata){
//        System.out.println(kata);
        String searchSQL = "SELECT * FROM user WHERE user LIKE '%"+kata+"%'";
//         OR level LIKE '%"+kata+"%'
        
        this.database = new MyConnection();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(searchSQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                setUser(rs.getString(1));
                setPass(rs.getString(2));
                setLevel(rs.getString(3));
                
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL");
        }
        
        return null;
    }
    
//    LOGIN
    public boolean masuk(String user, String pass){
        
        ArrayList<User> list = search(user);
//        System.out.println(getUser());
//        System.out.println(getPass());
//        System.out.println(user);
//        System.out.println(pass);
        
        return false; 
    }
    
    
//    GEETER
    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getLevel() {
        return level;
    }
    
//    SEETER
    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
