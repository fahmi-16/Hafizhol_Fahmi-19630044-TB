
package fahmi.penerbangan.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class MyConnection {
     private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "fahmi_penerbangan";
    private static final String TIMEZONE = "?serverTimezone=Asia/Makassar";
    private static final String USER = "root";
    private static final String PASS = "";
    
    public Connection getConnection(){
        Connection connection = null;
        
        try {
            Class.forName(JDBC_DRIVER);
//            System.out.println("Driver Di temukan");
            connection = DriverManager.getConnection(URL+DB_NAME+TIMEZONE,USER,PASS);
//            connection = DriverManager.getConnection(URL+DB_NAME, USER, PASS);
//            System.out.println("Koneksi Berhasil");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Driver tidak di temukan");
            JOptionPane.showMessageDialog(null, "Tidak Konek Ke DATABASE");
            System.out.println(e);
        } 
        
        return connection;
    }
}
