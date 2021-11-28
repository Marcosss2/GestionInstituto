/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Alumnos.Alumnos;
import Alumnos.Profesores;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Marco
 */
public interface BD {
  
    
    
     List<Alumnos>seleccionarA() throws SQLException;
     List<Alumnos>ORD() throws SQLException;
     List<Alumnos>N() throws SQLException;
     List<Alumnos>E() throws SQLException;
     List<Alumnos>O1() throws SQLException;
     int insertar(Alumnos alumno) throws SQLException;
      int actualizar(Alumnos alumno) throws SQLException;
       
      int borrar(Alumnos alumno) throws SQLException;
      
    
    
    
    
}
