/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.*;
import javax.swing.JOptionPane;
        
/**
 *
 * @author Owner
 */
public class conectar {
   Connection con=null;
   public Connection conexion(){
       try {
           //cargar nuestro driver
           Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost/fastdevelopment","root","");
           System.out.println("Conexion establecida");
       } catch (ClassNotFoundException | SQLException e) {
           System.out.println("Error de conexion");
           JOptionPane.showMessageDialog(null, "error de conexion "+e);
       }
       return con;
   }
}
