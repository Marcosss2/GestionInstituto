/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Alumnos.Alumnos;
import Alumnos.Asignaturas;
import Alumnos.Profesores;
import Alumnos.horario;
import Excepciones.Excepcion;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author Marco
 */
public interface Datos {
  
    boolean existeRecurso(String nombreRecurso);
    
    void crearRecurso(String nombreRecurso) throws Excepcion;
    
    List<Alumnos> listarRecurso(String nombreRecurso) throws Excepcion;
    List<Profesores> listarRecurso1(String nombreRecurso) throws Excepcion;
    List<Asignaturas> listarRecurso2(String nombreRecurso) throws Excepcion ,ParseException;
    void agregarArticulo(Alumnos alumnos, String nombreRecurso) throws Excepcion;        
    void agregarArticulo1(Profesores profesor, String nombreRecurso) throws Excepcion;
    void agregarArticulo2(Asignaturas asignatura, String nombreRecurso) throws Excepcion;
    void agregarHorario(horario hor, String nombreRecurso) throws Excepcion;
    String buscarArticuloSimple(String nombreRecurso, String buscar) throws Excepcion;
    
    String buscarArticuloPorId(String nombreRecurso, String buscar) throws Excepcion;
     void modificar(String fAntiguo,String texto) throws Exception;
    void borrarArticulo(String nombreRecurso, String nombreArticulo) throws Excepcion;
    
    String borrarRecurso(String nombreRecurso);
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
