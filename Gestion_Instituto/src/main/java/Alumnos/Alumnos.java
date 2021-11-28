
package Alumnos;

import java.util.Date;


public class Alumnos {
  
    
    private int idAlumno;
    private String nombre;
    private String apellidos;
    private String curso;
    private double notas;
    private int edad;
     public static int num;
    public Alumnos() {
    }

    
   
    public Alumnos(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    
    public Alumnos(int idAlumno, String nombre, String apellidos, String curso, double notas, int edad) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.curso = curso;
        this.notas = notas;
        this.edad = edad;
     num ++;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCurso() {
        return curso;
    }

    public double getNotas() {
        return notas;
    }

    public int getedad() {
        return edad;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setNotas(double notas) {
        this.notas = notas;
    }

    public void setedad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Alumnos{" + "idAlumno=" + idAlumno + ", nombre=" + nombre + ", apellidos=" + apellidos + ", curso=" + curso + ", notas=" + notas + ", edad=" + edad + '}';
    }


    
}




