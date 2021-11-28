/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Alumnos.Alumnos;
import Alumnos.Profesores;
import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marco
 */
public class ProfesorD implements BDP {
   
    
   private static String SQL_SELECT = "SELECT * FROM profesor";
  private static String SQL_INSERT = "INSERT INTO profesor(idProfesor, nombre, apellidos, curso, asignaturas) VALUES (?, ?, ?, ?, ?)";
   private static  final String SQL_UPDATE = "UPDATE profesor SET nombre = ?, apellidos = ?, curso = ?, asignaturas = ? WHERE idProfesor = ?";
   private static String SQL_DELETE = "DELETE FROM profesor WHERE idProfesor = ?";
   @Override
   public List<Profesores> seleccionarP() throws SQLException{
    
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    List<Profesores> personas = new ArrayList<>();
    
    try {
        
        conn = getConnection();
         stmt = conn.prepareStatement(SQL_SELECT);
         rs = stmt.executeQuery();
    
     while(rs.next()){
        
       int idProfesor = rs.getInt("idProfesor");
       String nombre = rs.getString("nombre");
        String apellidos = rs.getString("apellidos");
        String curso = rs.getString("curso");
        String asignaturas = rs.getString("asignaturas");  
          personas.add(new Profesores( idProfesor, nombre, apellidos,  curso, asignaturas));
       
       
       
     }
    
    
    } catch (SQLException ex) {
        
       ex.printStackTrace();
    } finally {
        
      close(rs);
        close(stmt);
        close(conn);
    }
    
    return personas;
    
}
  

      @Override
      public int insertarP(Profesores profesor) throws SQLException {
      
      Connection conn = null;
    PreparedStatement stmt = null;
    
    int registros = 0;
    
    
      try {
        
          conn = getConnection();
         stmt = conn.prepareStatement(SQL_INSERT);
          
         stmt.setInt(1, profesor.getIdProfesor());
         stmt.setString(2, profesor.getNombre());
         stmt.setString(3, profesor.getApellidos());
         stmt.setString(4, profesor.getCurso());
         stmt.setString(5, profesor.getAsignaturas());
         
         
         registros = stmt.executeUpdate();
         
      } catch (SQLException EX) {
      
       EX.printStackTrace();
      } finally {
          
        close(stmt);
        close(conn);
          
      }
       return registros;
  }
  
  
  @Override
   public int actualizarP(Profesores profesor) throws SQLException {
      
      Connection conn = null;
    PreparedStatement stmt = null;
    
    int registros = 0;
    
    
      try {
        
          conn = getConnection();
         stmt = conn.prepareStatement(SQL_UPDATE);
          
         
         stmt.setString(1, profesor.getNombre());
         stmt.setString(2, profesor.getApellidos());
         stmt.setString(3, profesor.getCurso());
         stmt.setString(4, profesor.getAsignaturas());
          
           stmt.setInt(5, profesor.getIdProfesor());
         
         registros = stmt.executeUpdate();
         
      } catch (SQLException EX) {
      
       EX.printStackTrace();
      } finally {
          
        close(stmt);
        close(conn);
          
      }
       return registros;
  }   
    
    
    
        @Override
         public int borrarP(Profesores profesor) throws SQLException {
         
         
         Connection conn = null;
         PreparedStatement stmt = null;
         int registros = 0;
         
         try {
             conn = getConnection();
         stmt = conn.prepareStatement(SQL_DELETE);
             
            stmt.setInt(1, profesor.getIdProfesor());
         
             registros = stmt.executeUpdate();
         
         
         } catch (SQLException ex) {
         
         ex.printStackTrace(System.out);
         } finally{
             
             
             close(stmt);
        close(conn);
             
         }
         
         return registros;
         
         
         
     }

   
    
   
    
    
    
    
    
    
    
    
    
    
    
}
