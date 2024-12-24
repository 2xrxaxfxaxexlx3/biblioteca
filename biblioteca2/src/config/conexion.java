
package config;
import java.sql.Connection;
import java.sql.DriverManager;
public class conexion {
    Connection con;
    public conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca nuevo","root","");
        } catch (Exception e) {
            System.err.println("Error"+e);
        }
    }
    public Connection getConection(){
        return con;
    }
}
