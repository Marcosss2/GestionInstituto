/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Alumnos.Asignaturas;
import Alumnos.Horarioo;
import Alumnos.Profesores;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Marco
 */
public interface BDA {
   
    
     List<Asignaturas>seleccionarS() throws SQLException;
     int insertarS(Asignaturas asignatura) throws SQLException;
     List<Asignaturas>seleccionarSh() throws SQLException;
     int insertarh(Horarioo hor) throws SQLException;
      int actualizarS(Asignaturas asignatura) throws SQLException;
       int borrarS(Asignaturas asignatura) throws SQLException;
    
    
    
}
