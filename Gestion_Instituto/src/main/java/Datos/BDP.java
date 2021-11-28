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
public interface BDP {
   
    List<Profesores>seleccionarP() throws SQLException;
     int insertarP(Profesores profesor) throws SQLException;
      int actualizarP(Profesores profesor) throws SQLException;
       int borrarP(Profesores profesor) throws SQLException;
    
    
    
    
    
    
    
}
