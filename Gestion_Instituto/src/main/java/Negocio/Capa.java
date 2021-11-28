/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Alumnos.horario;
import Excepciones.Excepcion;
import java.io.File;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author Marco
 */
public interface Capa {
  
   
   void AgregarAlumno(String nombreArchivo, String idAlumno, String nombre,  String apellidos, String curso,String notas,String edad);
   void AgregarProfesor(String nombreArchivo, String idProfesor, String nombre,  String apellidos, String curso,String asignaturas);
   void AgregarAsignatura(String nombreArchivo, String idAsignatura, String nombre,String fecha);
  // public void AgregarHorario(String nombreArchivo,String horr);
   void Listar (String nombreArchivo);
   void Listar1 (String nombreArchivo);
    void Listar2 (String nombreArchivo) throws SQLException;
    void Buscar(String nombreArchivo, String buscar) throws Excepcion;
    void IniciarArchivo(String nombreArchivo);
    void Borrar(String nombreArchivo);
    void mediaNotas(String nombreArchivo) throws Excepcion;
    void media(String nombreArchivo)throws Excepcion; 
    void borrarArticulo(String nombreArchivo, String nombreArticulo);
     
     
     
    
     void seleccionarA() throws SQLException;
     void ORD() throws SQLException;
     void N() throws SQLException;
     void O1() throws SQLException;
     void E() throws SQLException;
     void insertar(String ii,String mm,String pp,String cc,String nn,String ee) throws SQLException;
      void actualizar(String a,String b,String ccc,String d,String eee,String f) throws SQLException;
    
       void seleccionarP() throws SQLException;
     void insertarP(String a,String b,String ccc,String d,String eee) throws SQLException;
      void actualizarP(String a,String b,String ccc,String d,String eee) throws SQLException;
      void borrar(String i) throws SQLException;
      void borrarP(String a) throws SQLException;
   
      void seleccionarS() throws SQLException;
      void seleccionarSh() throws SQLException;
     void insertarS(String a,String b,String ccc) throws SQLException;
     void insertarh(String a,String b,int c) throws SQLException;
      void actualizarS(String a,String b,String ccc) throws SQLException;
      void borrarS(String i) throws SQLException;
     
}
