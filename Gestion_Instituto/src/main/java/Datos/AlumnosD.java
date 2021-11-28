package Datos;




import Alumnos.Alumnos;
import Alumnos.Profesores;
import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AlumnosD  implements BD{
  
    
  private static String SQL_SELECT = "SELECT * FROM alumno";
  private static String SQL_ORDER = "SELECT * FROM alumno ORDER BY idAlumno DESC ";
   private static String SQL_ORDER1 = "SELECT * FROM alumno ORDER BY apellidos ";
  private static String SQL_Not = "SELECT * FROM alumno WHERE notas >= 5 ";
  private static String SQL_E = "SELECT * FROM alumno WHERE curso = 'segundo' ";
  private static String SQL_INSERT = "INSERT INTO alumno(idAlumno, nombre, apellidos, curso, notas, edad) VALUES (?, ?, ?, ?, ?, ?)";
   private static  final String SQL_UPDATE = "UPDATE alumno SET nombre = ?, apellidos = ?, curso = ?, notas = ?, edad = ? WHERE idAlumno = ?";
   private static String SQL_DELETE = "DELETE FROM alumno WHERE idAlumno = ?";
     
    
   
   @Override
   public List<Alumnos> seleccionarA() throws SQLException{
    
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    List<Alumnos> personas = new ArrayList<>();
    
    try {
        
        conn = getConnection();
         stmt = conn.prepareStatement(SQL_SELECT);
         rs = stmt.executeQuery();
    
     while(rs.next()){
        
       int idAlumno = rs.getInt("idAlumno");
       String nombre = rs.getString("nombre");
        String apellidos = rs.getString("apellidos");
        String curso = rs.getString("curso");
          double notas = rs.getDouble("notas");
          int edad  = rs.getInt("edad");
          personas.add(new Alumnos( idAlumno, nombre, apellidos,  curso, notas, edad));
      
       
       
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
   
    public List<Alumnos> E() throws SQLException{
    
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    List<Alumnos> personas = new ArrayList<>();
    
    try {
        
        conn = getConnection();
         stmt = conn.prepareStatement(SQL_E);
         rs = stmt.executeQuery();
    
     while(rs.next()){
        
       int idAlumno = rs.getInt("idAlumno");
       String nombre = rs.getString("nombre");
        String apellidos = rs.getString("apellidos");
        String curso = rs.getString("curso");
          double notas = rs.getDouble("notas");
          int edad  = rs.getInt("edad");
          personas.add(new Alumnos( idAlumno, nombre, apellidos,  curso, notas, edad));
      
       
       
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
 public List<Alumnos> O1() throws SQLException{
    
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    List<Alumnos> personas = new ArrayList<>();
    
    try {
        
        conn = getConnection();
         stmt = conn.prepareStatement(SQL_ORDER1);
         rs = stmt.executeQuery();
    
     while(rs.next()){
        
       int idAlumno = rs.getInt("idAlumno");
       String nombre = rs.getString("nombre");
        String apellidos = rs.getString("apellidos");
        String curso = rs.getString("curso");
          double notas = rs.getDouble("notas");
          int edad  = rs.getInt("edad");
          personas.add(new Alumnos( idAlumno, nombre, apellidos,  curso, notas, edad));
      
       
       
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
   public List<Alumnos> N() throws SQLException{
    
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    List<Alumnos> personas = new ArrayList<>();
    
    try {
        
        conn = getConnection();
         stmt = conn.prepareStatement(SQL_Not);
         rs = stmt.executeQuery();
    
     while(rs.next()){
        
       int idAlumno = rs.getInt("idAlumno");
       String nombre = rs.getString("nombre");
        String apellidos = rs.getString("apellidos");
        String curso = rs.getString("curso");
          double notas = rs.getDouble("notas");
          int edad  = rs.getInt("edad");
          personas.add(new Alumnos( idAlumno, nombre, apellidos,  curso, notas, edad));
      
       
       
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
    public List<Alumnos> ORD() throws SQLException{
    
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    List<Alumnos> personas = new ArrayList<>();
    
    try {
        
        conn = getConnection();
         stmt = conn.prepareStatement(SQL_ORDER);
         rs = stmt.executeQuery();
    
     while(rs.next()){
        
       int idAlumno = rs.getInt("idAlumno");
       String nombre = rs.getString("nombre");
        String apellidos = rs.getString("apellidos");
        String curso = rs.getString("curso");
          double notas = rs.getDouble("notas");
          int edad  = rs.getInt("edad");
          personas.add(new Alumnos( idAlumno, nombre, apellidos,  curso, notas, edad));
      
       
       
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
      public int insertar(Alumnos alumno) throws SQLException {
      
      Connection conn = null;
    PreparedStatement stmt = null;
    
    int registros = 0;
    
    
      try {
        
          conn = getConnection();
         stmt = conn.prepareStatement(SQL_INSERT);
          
         stmt.setInt(1, alumno.getIdAlumno());
         stmt.setString(2, alumno.getNombre());
         stmt.setString(3, alumno.getApellidos());
         stmt.setString(4, alumno.getCurso());
         stmt.setDouble(5, alumno.getNotas());
         stmt.setInt(6, alumno.getedad());
         
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
   public int actualizar(Alumnos alumno) throws SQLException {
      
      Connection conn = null;
    PreparedStatement stmt = null;
    
    int registros = 0;
    
    
      try {
        
          conn = getConnection();
         stmt = conn.prepareStatement(SQL_UPDATE);
          
         
         stmt.setString(1, alumno.getNombre());
         stmt.setString(2, alumno.getApellidos());
         stmt.setString(3, alumno.getCurso());
         stmt.setDouble(4, alumno.getNotas());
          stmt.setInt(5, alumno.getedad());
           stmt.setInt(6, alumno.getIdAlumno());
         
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
  public int borrar(Alumnos alumno) throws SQLException {
         
         
         Connection conn = null;
         PreparedStatement stmt = null;
         int registros = 0;
         
         try {
             conn = getConnection();
         stmt = conn.prepareStatement(SQL_DELETE);
             
            stmt.setInt(1, alumno.getIdAlumno());
         
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
