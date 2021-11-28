/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Alumnos.Alumnos;
import Alumnos.Asignaturas;
import Alumnos.Horarioo;
import Alumnos.horario;
import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author Marco
 */
public class AsignaturaD implements BDA{
  
    
      private static String SQL_SELECT = "SELECT * FROM asignatura";
  private static String SQL_INSERT = "INSERT INTO asignatura(idAsignatura, nombre, fechaE) VALUES (?, ?, ?)";
   private static  final String SQL_UPDATE = "UPDATE asignatura SET nombre = ?, fechaE = ? WHERE idAsignatura = ?";
   private static String SQL_DELETE = "DELETE FROM asignatura WHERE idAsignatura = ?";
   private static String SQL_INSERT1 = "INSERT INTO horario(idHorario,nombre,idA) VALUES (?, ?, ?)";
   private static String SQL_Unir = "SELECT * FROM horario,asignatura WHERE idAsignatura=idA";
   @Override
   public List<Asignaturas> seleccionarS() throws SQLException{
    
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    List<Asignaturas> personas = new ArrayList<>();
    
    try {
        
        conn = getConnection();
         stmt = conn.prepareStatement(SQL_SELECT);
         rs = stmt.executeQuery();
    
     while(rs.next()){
        
       int idAsignatura = rs.getInt("idAsignatura");
       String nombre = rs.getString("nombre");
        Date fechaE = rs.getDate("fechaE");
        
          personas.add(new Asignaturas( idAsignatura, nombre,fechaE));
      
       
       
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
   public List<Asignaturas> seleccionarSh() throws SQLException{
    
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    List<Asignaturas> personas = new ArrayList<>();
    
    try {
        
        conn = getConnection();
         stmt = conn.prepareStatement(SQL_Unir);
         rs = stmt.executeQuery();
    
     while(rs.next()){
        
       int idAsignatura = rs.getInt("idAsignatura");
       String nombre = rs.getString("nombre");
        Date fechaE = rs.getDate("fechaE");
        
          personas.add(new Asignaturas( idAsignatura, nombre,fechaE));
      
       
       
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
      public int insertarS(Asignaturas asignatura) throws SQLException {
      
      Connection conn = null;
    PreparedStatement stmt = null;
    
  java.util.Date fecha =  new java.util.Date();
  
       SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
    
    
    int registros = 0;
    
    
      try {
        
          conn = getConnection();
         stmt = conn.prepareStatement(SQL_INSERT);
          
         stmt.setInt(1, asignatura.getIdAsignaturas());
         stmt.setString(2,asignatura.getNombre());
         stmt.setDate(3, new java.sql.Date(fecha.getTime()));
        
         
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
     public int insertarh(Horarioo hor) throws SQLException {
      
      Connection conn = null;
    PreparedStatement stmt = null;
    
  java.util.Date fecha =  new java.util.Date();
  
       SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
    
    
    int registros = 0;
    
    
      try {
        
          conn = getConnection();
         stmt = conn.prepareStatement(SQL_INSERT1);
         stmt.setInt(1, hor.getId());
         
         stmt.setString(2, hor.gethorario());
         stmt.setInt(3, hor.getIdA());
         
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
   public int actualizarS(Asignaturas asignatura) throws SQLException {
      
      Connection conn = null;
    PreparedStatement stmt = null;
    
    int registros = 0;
    
    
      try {
        
          conn = getConnection();
         stmt = conn.prepareStatement(SQL_UPDATE);
          
        stmt.setInt(1, asignatura.getIdAsignaturas());
         stmt.setString(2,asignatura.getNombre());
         stmt.setDate(3, (java.sql.Date) asignatura.getFechaexam());
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
  public int borrarS(Asignaturas asignatura) throws SQLException {
         
         
         Connection conn = null;
         PreparedStatement stmt = null;
         int registros = 0;
         
         try {
             conn = getConnection();
         stmt = conn.prepareStatement(SQL_DELETE);
             
            stmt.setInt(1, asignatura.getIdAsignaturas());
         
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
