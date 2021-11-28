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
import Excepciones.ExcepcionE;
import Excepciones.ExcepcionL;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marco
 */
public class DatosImp  implements Datos{


    @Override
    public boolean existeRecurso(String nombreRecurso) {
      File archivo = new File(nombreRecurso);
     
      return archivo.exists();
      
    }

    @Override
    public void crearRecurso(String nombreRecurso) throws Excepcion {
        File archivo = new File(nombreRecurso);
        
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new Excepcion("Excepción intentando crear el archivo");
        }
        
    }

    @Override
    public List<Alumnos> listarRecurso(String nombreRecurso) throws ExcepcionL {
        File archivo = new File(nombreRecurso);
        
        Alumnos articuloN = null;
        String[] articulo = new String[6]; 
        List<Alumnos> articulos = new ArrayList<>();
        
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = null;
            while((lectura = entrada.readLine()) != null){
                // lectura = "idArticulo;nombre;descripcion;precio;fecha"
                
                articulo = lectura.split(";"); // {idArticulo, nombre, descripcion, precio, fecha}
                articuloN = new Alumnos(Integer.parseInt(articulo[0]), 
                        articulo[1],articulo[2], articulo[3], 
                        Double.parseDouble(articulo[4]), Integer.parseInt(articulo[5]));
                articulos.add(articuloN);
            }
            entrada.close();            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            
        } catch (IOException ex){
            ex.printStackTrace(System.out);
            throw new ExcepcionL("Excepción leyendo el fichero...");            
        }
        return articulos;                
    }

     public List<Profesores> listarRecurso1(String nombreRecurso) throws ExcepcionL {
        File archivo = new File(nombreRecurso);
        
        Profesores articuloN = null;
        String[] articulo = new String[6]; 
        List<Profesores> articulos = new ArrayList<>();
        
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = null;
            while((lectura = entrada.readLine()) != null){
                // lectura = "idArticulo;nombre;descripcion;precio;fecha"
                
                articulo = lectura.split(";"); // {idArticulo, nombre, descripcion, precio, fecha}
                articuloN = new Profesores(Integer.parseInt(articulo[0]), 
                        articulo[1],articulo[2], articulo[3], 
                         articulo[4]);
                articulos.add(articuloN);
            }
            entrada.close();            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            
        } catch (IOException ex){
            ex.printStackTrace(System.out);
            throw new ExcepcionL("Excepción leyendo el fichero...");            
        }
        return articulos;                
    }

    
    
     @Override
    public List<Asignaturas> listarRecurso2(String nombreRecurso) throws ExcepcionL, ParseException {
        File archivo = new File(nombreRecurso);
        
        Asignaturas articuloN = null;
        String[] articulo = new String[6]; 
        List<Asignaturas> articulos = new ArrayList<>();
        
        String fecha = "dd/MM/yyyy";
        SimpleDateFormat formatoFecha = new SimpleDateFormat(fecha,Locale.ENGLISH);
        
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = null;
           
        
            
            while((lectura = entrada.readLine()) != null){
               
                
                articulo = lectura.split(";"); 
                articuloN = new Asignaturas(Integer.parseInt(articulo[0]), 
                        articulo[1],formatoFecha.parse(articulo[2]));
                articulos.add(articuloN);
            }
            entrada.close();            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            
        } catch (IOException ex){
            ex.printStackTrace(System.out);
            throw new ExcepcionL("Excepción leyendo el fichero...");            
        }
        return articulos;                
    }

    
    
    
    
    
    
    @Override
    public void agregarArticulo(Alumnos alumno, String nombreRecurso) 
            throws ExcepcionE {        
        File archivo = new File(nombreRecurso);
        
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            String articuloTxt = alumno.getIdAlumno()+ ";" +
                    alumno.getNombre() + ";" + alumno.getApellidos() + ";" +
                    alumno.getCurso() + ";" + alumno.getNotas() + ";" + alumno.getedad();
            salida.println(articuloTxt);
            salida.close();
            // Formato de cada linea del fichero es: idArticulo;nombre;descripcion;precio;fecha
            // sin embargo tengo un Objeto Articulo
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new ExcepcionE("Excepción escribiendo un nuevo "
                    + "artículo en el Recurso");
        }
        
    }
      @Override
     public void agregarHorario(horario hor, String nombreRecurso) 
            throws ExcepcionE {        
        File archivo = new File(nombreRecurso);
        
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            String articuloTxt = hor.Lunes+ ";" +
                    hor.Martes + ";" + hor.Miercoles + ";" +
                    hor.Jueves + ";" + hor.Viernes ;
            salida.println(articuloTxt);
            salida.close();
            // Formato de cada linea del fichero es: idArticulo;nombre;descripcion;precio;fecha
            // sin embargo tengo un Objeto Articulo
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new ExcepcionE("Excepción escribiendo un nuevo "
                    + "artículo en el Recurso");
        }
        
    }
    
    
    
      public void agregarArticulo1(Profesores profesor, String nombreRecurso) 
            throws ExcepcionE {        
        File archivo = new File(nombreRecurso);
        
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            String articuloTxt =  profesor.getIdProfesor() + ";" +
                    profesor.getNombre() + ";" + profesor.getApellidos() + ";" +
                    profesor.getCurso() + ";" + profesor.getAsignaturas();
            salida.println(articuloTxt);
            salida.close();
            // Formato de cada linea del fichero es: idArticulo;nombre;descripcion;precio;fecha
            // sin embargo tengo un Objeto Articulo
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new ExcepcionE("Excepción escribiendo un nuevo "
                    + "artículo en el Recurso");
        }
        
    }
    
    
    
    
    public void agregarArticulo2(Asignaturas asignatura, String nombreRecurso) 
            throws ExcepcionE {        
        File archivo = new File(nombreRecurso);
        
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            String articuloTxt =  asignatura.getIdAsignaturas() + ";" +
                    asignatura.getNombre() + ";" + asignatura.getFechaexam();
                   
            salida.println(articuloTxt);
            salida.close();
            
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new ExcepcionE("Excepción escribiendo un nuevo "
                    + "artículo en el Recurso");
        }
        
    }

    @Override
    public String buscarArticuloSimple(String nombreRecurso, String buscar) throws ExcepcionL {
      File archivo = new File(nombreRecurso);
        String mensaje = "";
        int linea = 0;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();
            
            while (lectura != null) {
                String[] product = lectura.split(";");
                linea = linea + 1;
                if(product[0].equalsIgnoreCase(buscar)){
                    mensaje = "id : " + nombreRecurso + "\n" + "Alumno : " + lectura + "\n" + "Linea : " + linea;
                    break;
                }
                
                lectura = entrada.readLine();
            }
            
            if(lectura == null) {
                System.out.println("el producto no esta en stock");
            }
            
            entrada.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace(System.out);
                System.out.println("Error al leerlo");
            } catch (IOException e) {
            e.printStackTrace(System.out);
            System.out.println("No se ha encontrado el archivo");
        }
        
        return mensaje;
    }

    @Override
    public String buscarArticuloPorId(String nombreRecurso, String buscar) throws ExcepcionL{
        File archivo = new File(nombreRecurso);
        String mensaje = "";
        int linea = 0;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();
            
            while (lectura != null) {
                String[] alumno = lectura.split(";");
                linea = linea + 1;
                if(alumno[3].equalsIgnoreCase(buscar)){
                    mensaje = "Nombre del archivo : " + nombreRecurso + "\n" + "Alumno : " + lectura + "\n" + "Linea : " + linea;
                    break;
                }
                
                lectura = entrada.readLine();
            }
            
            if(lectura == null) {
                System.out.println("el producto no esta en stock");
            }
            
            entrada.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace(System.out);
                System.out.println("Error al leerlo");
            } catch (IOException e) {
            e.printStackTrace(System.out);
            System.out.println("No se ha encontrado el archivo");
        }
        
        return mensaje;
    }

    @Override
    public void borrarArticulo(String nombreRecurso, String nombreArticulo) throws Excepcion {
        
        File archivo = new File(nombreRecurso);
        
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();
            
            //Creamos el archivo
            PrintWriter salida = new PrintWriter(archivo);
            System.out.println("Se ha creado con exito el archivo");
            
            while (lectura != null) {
                String[] product = lectura.split(";");
                
                if(product[0].equalsIgnoreCase(nombreArticulo)){
                    lectura = entrada.readLine();
                    continue;
                }
                
                //Escribimos las lineas que no queremos eliminar
                salida = new PrintWriter(new FileWriter(archivo, true));
                salida.println(lectura);
                salida.close();
                
                //Pasamos a la siguiente linea
                lectura = entrada.readLine();
            }
            
            if(lectura == null) {
                if(archivo.exists() == true){
                    archivo.delete();
                    System.out.println("El archivo a sido eliminado");
                } else {
                    System.out.println("El archivo que quieres eliminar no existe");
                }
                System.out.println("Se han eliminado las lineas");
            }
            
            entrada.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace(System.out);
                System.out.println("Error al leerlo");
            } catch (IOException e) {
            e.printStackTrace(System.out);
            System.out.println("No se ha encontrado el archivo");
        }
        
    }

    @Override
    public String borrarRecurso(String nombreRecurso) {
        File archivo = new File(nombreRecurso);
        String msg = "";
        if (existeRecurso(nombreRecurso)){
            archivo.delete();
            msg = "Recurso borrado con éxito";
        }
        else {
            msg = "No se ha podido borrar el archivo ya que no existe";
        }
        return msg;
    } 

    @Override
    public void modificar(String fAntiguo, String texto) throws Exception {
      
           
    {
       
   
            File archivo = new File(fAntiguo); // este es el archivo que insertaras caracteres
           FileWriter escribir = new FileWriter(archivo);
           texto = "aqui van los caracteres a insertar";
          for(int i=0; i<texto.length();i++){
            escribir.write(texto.charAt(i));
             escribir.close();
                        
 
                  
}
    }
        
        
    
    
    }
    
 
    
  
    
     
    
}