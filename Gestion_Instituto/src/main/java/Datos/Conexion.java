/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Alumno mañana
 */
public class Conexion {
  
  private static final String JDBC_URL = "jdbc:mysql://localhost:3306/trabajo?useSSL=false"
           + "&useTimezone=true&serverTimezone=UTC&"
           + "allowPublicKeyRetrieval=true";
  
   private static final String JDBC_USER = "root";
   
    private static final String JDBC_PASSWORD = "root";
   
    public static Connection getConnection() throws SQLException{
        
       return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        
    }
    
     public static void close(ResultSet rs) throws SQLException {
         
        rs.close();
         
     }
    
     public static void close(Statement stmt) throws SQLException {
         
         stmt.close();
     }
   
     
      public static void close(PreparedStatement stmt) throws SQLException {
         
         stmt.close();
     }
   
      public static void close(Connection conn) throws SQLException {
         
         conn.close();
     } 
      
      
}
