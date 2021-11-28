/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Alumnos.Alumnos;
import Alumnos.Asignaturas;
import Alumnos.Horarioo;
import Alumnos.Profesores;
import Alumnos.horario;
import Datos.AlumnosD;
import Datos.AsignaturaD;
import Datos.BD;
import Datos.BDA;
import Datos.BDP;
import Datos.Datos;
import Datos.DatosImp;
import Datos.ProfesorD;
import Excepciones.Excepcion;
import Excepciones.ExcepcionE;
import Excepciones.ExcepcionL;
import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marco
 */
public class CapaImp implements Capa {
    
    Scanner sc = new Scanner(System.in);
    private final Datos datos;
    private final BD alum;
    private final BDP prof;
    private final BDA asig;
    AlumnosD personaDao1 = new AlumnosD();
    ProfesorD personaDao2 = new ProfesorD();
    private double total = 0;
    private double cantidad = 0;
    private double cantidadd = 0;
     private double media = 0;
      private double mediaN = 0;
     List<Alumnos> lista;

    public CapaImp() {
        this.datos = new DatosImp();
        this.alum = new AlumnosD();
        this.prof = new ProfesorD();
        this.asig = new AsignaturaD();
    }
    
    @Override
    public void AgregarAlumno(String nombreArchivo, String idAlumno, String nombre, String apellidos, String curso, String notas, String edad) {
        try {
            Alumnos Alumno = new Alumnos(Integer.parseInt(idAlumno), nombre, apellidos, curso, Double.parseDouble(notas),Integer.parseInt(edad));
            if (datos.existeRecurso(nombreArchivo) == true) {
                datos.agregarArticulo(Alumno, nombreArchivo);
            } else {
                System.out.println("El archivo no existe");
            }
            
        } catch (ExcepcionE ex) {
            ex.printStackTrace(System.out);
        } catch (Excepcion ex) {
            ex.printStackTrace(System.out);
        }
    }

   // @Override
    /* public void AgregarHorario(String nombreArchivo,String horr) {
        try {
           
            
            if (datos.existeRecurso(nombreArchivo) == true) {
                datos.agregarHorario(enum.parse(horr), nombreArchivo);
            } else {
                System.out.println("El archivo no existe");
            }
            
        } catch (ExcepcionE ex) {
            ex.printStackTrace(System.out);
        } catch (Excepcion ex) {
            ex.printStackTrace(System.out);
        }
    }*/

    
    
    
    
    
    @Override
    public void AgregarProfesor(String nombreArchivo, String idProfesor, String nombre, String apellidos, String curso, String asignaturas) {
        try {
            Profesores profesor = new Profesores(Integer.parseInt(idProfesor), nombre, apellidos, curso, asignaturas);
            if (datos.existeRecurso(nombreArchivo) == true) {
                datos.agregarArticulo1(profesor, nombreArchivo);
            } else {
                System.out.println("El archivo no existe");
            }
            
        } catch (ExcepcionE ex) {
            ex.printStackTrace(System.out);
        } catch (Excepcion ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    @Override
    public void AgregarAsignatura(String nombreArchivo, String idAsignatura, String nombre, String fecha) {
       
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        
        
        try {
            Asignaturas asignatura = new Asignaturas(Integer.parseInt(idAsignatura), nombre, formatoFecha.parse(fecha));
            if (datos.existeRecurso(nombreArchivo) == true) {
                datos.agregarArticulo2(asignatura, nombreArchivo);
            } else {
                System.out.println("El archivo no existe");
            }
            
        } catch (ExcepcionE ex) {
            ex.printStackTrace(System.out);
        } catch (Excepcion ex) {
            ex.printStackTrace(System.out);
        } catch (ParseException ex) {
            Logger.getLogger(CapaImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void Listar(String nombreArchivo) {
        List<Alumnos> lista;
        try {
            lista = datos.listarRecurso(nombreArchivo);
            lista.forEach(alumno -> {
                System.out.println("Alumnos: " + alumno.getIdAlumno() + " | nombre: " + alumno.getNombre() + " | apellido: " + alumno.getApellidos() + " | curso " + alumno.getCurso() + " | notas: " + alumno.getNotas() + " | edad: " + alumno.getedad());
            });
            
        } catch (ExcepcionL e) {
            System.out.println("Error ");
            e.printStackTrace(System.out);
        } catch (Excepcion ex) {
            Logger.getLogger(Capa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void Listar1(String nombreArchivo) {
        List<Profesores> lista;
        try {
            lista = datos.listarRecurso1(nombreArchivo);
            lista.forEach(profesor -> {
                System.out.println("profesores: " + profesor.getIdProfesor() + " | nombre: " + profesor.getNombre() + " | apellido: " + profesor.getApellidos() + " | curso: " + profesor.getCurso() + " | asignaturas: " + profesor.getAsignaturas());
            });
            
        } catch (ExcepcionL e) {
            System.out.println("Error ");
            e.printStackTrace(System.out);
        } catch (Excepcion ex) {
            Logger.getLogger(Capa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Listar2(String nombreArchivo) throws SQLException {
        List<Asignaturas> lista;
        String fecha = "dd/MM/YYYY";
        try {
            lista = datos.listarRecurso2(nombreArchivo);
            lista.forEach(asignatura -> {
                System.out.println("profesores: " + asignatura.getIdAsignaturas() + " | nombre: " + asignatura.getNombre() + " | fecha: " + asignatura.getFechaexam());
            });
            
        } catch (ExcepcionL e) {
            System.out.println("Error ");
            e.printStackTrace(System.out);
        } catch (Excepcion ex) {
            Logger.getLogger(Capa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(CapaImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void Buscar(String nombreArchivo, String buscar) throws Excepcion {
        try {
            System.out.println(datos.buscarArticuloSimple(nombreArchivo,buscar));
        } catch (ExcepcionL e) {
            e.printStackTrace(System.out);
        }
    }
    
    @Override
    public void IniciarArchivo(String nombreArchivo) {
        try {
            if (datos.existeRecurso(nombreArchivo) == false) {
                datos.crearRecurso(nombreArchivo);
            } else {
                System.out.println("El archivo ya existe");
            }
            
        } catch (Excepcion e) {
            e.printStackTrace(System.out);
        }
    }
    
    @Override
    public void Borrar(String nombreArchivo) {
        datos.borrarRecurso(nombreArchivo);
        System.out.println("Catalogo eliminado con exito");
    }
    
    @Override
    public void mediaNotas(String nombreArchivo) throws Excepcion {
        try {
            lista = datos.listarRecurso(nombreArchivo);
            total = 0;
            mediaN = 0;
            lista.forEach(alumno -> {
                var no = alumno.getNotas();
                total = total + no;
             mediaN = total/Alumnos.num;
            });
            
            System.out.println("la media de las notas: " + mediaN );
            //System.out.println("Precio total de los productos: " + datos.precioTotal(nombreArchivo)+"€");
        } catch (ExcepcionL ex) {
            Logger.getLogger(Capa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    

    
    @Override
    public void media(String nombreArchivo) throws Excepcion {
        try {
            lista = datos.listarRecurso(nombreArchivo);
            cantidadd = 0;
            media=0;
            lista.forEach(alumno -> {
                var cant = alumno.getedad();
                cantidadd = cantidadd + cant;
                media = cantidadd/Alumnos.num;
            });
            System.out.println("L a media de edad de los Alumnos: " + media);
            //System.out.println("Cantidad de productos:" + datos.maxCantidad(nombreArchivo));
        } catch (ExcepcionL ex) {
            Logger.getLogger(Capa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void borrarArticulo(String nombreRecurso, String nombreArticulo) {
        
        try {
            datos.borrarArticulo(nombreRecurso,nombreArticulo);
        } catch (Excepcion ex) {
            Logger.getLogger(CapaImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Catalogo eliminado con exito");
    }
    


    
    @Override
    public void seleccionarA() throws SQLException {
        
        AlumnosD personaDao = new AlumnosD();
        
        List<Alumnos> alumnos = alum.seleccionarA();
        
        alumnos.forEach(alumno -> {
            
            System.out.println("alumnos" + alumno);
            
        });
        
    }
    
    @Override
    public void insertar(String ii, String mm, String pp, String cc, String nn, String ee) throws SQLException {
        
        int idAlumno = Integer.parseInt(ii);
        String nombre = mm;
        String apellidos = pp;
        String curso = cc;
        double nota = Double.parseDouble(nn);
        int edad = Integer.parseInt(ee);
        
        Alumnos alumno2 = new Alumnos(idAlumno, nombre, apellidos, curso, nota, edad);
        
        alum.insertar(alumno2);
        
    }
    
    @Override
    public void actualizar(String ii, String mm, String pp, String cc, String nn, String ee) throws SQLException {
        
        Alumnos alumno2 = new Alumnos(Integer.parseInt(ii), mm, pp, cc,
                Double.parseDouble(nn), Integer.parseInt(ee));
        
        alum.actualizar(alumno2);
        
    }
    
    @Override
    public void seleccionarP() throws SQLException {
        
        ProfesorD profesores = new ProfesorD();
        
        List<Profesores> profesoress = prof.seleccionarP();
        
        profesoress.forEach(profesor -> {
            
            System.out.println("profesores" + profesor);
            
        });
        
    }
    
    @Override
    public void insertarP(String a,String b,String ccc,String d,String eee) throws SQLException {
        Profesores profesores1 = new Profesores(Integer.parseInt(a), b, ccc, d,
                eee);
       
        
        prof.insertarP(profesores1);
        
    }
    
    @Override
    public void actualizarP(String a,String b,String ccc,String d,String eee) throws SQLException {
        
      Profesores profesores2 = new Profesores(Integer.parseInt(a), b, ccc, d,
                eee);
        
        prof.actualizarP(profesores2);
    }
    
    @Override
    public void borrar(String i) throws SQLException {
        
        Alumnos alumno2 = new Alumnos(Integer.parseInt(i));
        
        alum.borrar(alumno2);
        // personaDao1.borrar(alumno2);
        
    }
    
    @Override
    public void borrarP(String a) throws SQLException {
        
       Profesores profesores3 = new Profesores(Integer.parseInt(a));
        
        prof.borrarP(profesores3);
        
    }

    @Override
    public void seleccionarS() throws SQLException {
       
            AsignaturaD personaDao = new AsignaturaD();
        
        List<Asignaturas> as = asig.seleccionarS();
        
        as.forEach(asignatura -> {
            
            System.out.println("asignaturas" + asignatura);
            
       
        });
    
    }

     @Override
    public void seleccionarSh() throws SQLException {
       
            AsignaturaD personaDao = new AsignaturaD();
        
        List<Asignaturas> as = asig.seleccionarSh();
        
        as.forEach(asignatura -> {
            
            System.out.println("asignaturas" + asignatura);
            
       
        });
    
    }

    
    @Override
    public void insertarS(String a, String b, String ccc) throws SQLException {

         SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        
       Asignaturas  asignatura1 = null;
        try {
            asignatura1 = new Asignaturas(Integer.parseInt(a),b,formatoFecha.parse(ccc));
        } catch (ParseException ex) {
            Logger.getLogger(CapaImp.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
       asig.insertarS(asignatura1);
    
    
    }

    @Override
    public void actualizarS(String a, String b, String ccc) throws SQLException {
      
    }

    @Override
    public void borrarS(String i) throws SQLException {

        String fecha = "dd/MM/yyyy";
        SimpleDateFormat formatoFecha = new SimpleDateFormat(fecha);
        
        
         Asignaturas  asignatura1 = new Asignaturas(Integer.parseInt(i));
        
        
        asig.borrarS(asignatura1);
    
    
}

    @Override
    public void ORD() throws SQLException {
      
          AlumnosD personaDao = new AlumnosD();
        
        List<Alumnos> alumnos = alum.ORD();
        
        alumnos.forEach(alumno -> {
            
            System.out.println("alumnos" + alumno);
            
        }); 
        
        
        
    }

    @Override
    public void N() throws SQLException {
        
            AlumnosD personaDao = new AlumnosD();
        
        List<Alumnos> alumnos = alum.N();
        
        alumnos.forEach(alumno -> {
            
            System.out.println("alumnos" + alumno);
            
        }); 
        
        
        
        
        
        
    }

    @Override
    public void E() throws SQLException {
       
            AlumnosD personaDao = new AlumnosD();
        
        List<Alumnos> alumnos = alum.E();
        
        alumnos.forEach(alumno -> {
            
            System.out.println("alumnos" + alumno);
            
        }); 
    
    
    }

    @Override
    public void O1() throws SQLException {
       
        
           AlumnosD personaDao = new AlumnosD();
        
        List<Alumnos> alumnos = alum.O1();
        
        alumnos.forEach(alumno -> {
            
            System.out.println("alumnos" + alumno);
            
        }); 
    
        
    }
   @Override
   public void insertarh(String d,String a,int  c) throws SQLException {
        Horarioo hor = new Horarioo(Integer.parseInt(d), a, c);
       
        
        asig.insertarh(hor);
        
    }
    
    
    

}