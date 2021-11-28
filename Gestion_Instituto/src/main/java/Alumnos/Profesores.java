/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alumnos;

import java.util.Date;

/**
 *
 * @author Marco
 */
public class Profesores {
 
    private int idProfesor;
    private String nombre;
    private String apellidos;
    private String curso;
    private String asignaturas;

    public Profesores(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Profesores() {
    }

    
    public Profesores(String nombre) {
        this.nombre = nombre;
    }

    
    
    public Profesores(int idProfesor, String nombre, String apellidos, String curso, String asignaturas) {
        this.idProfesor = idProfesor;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.curso = curso;
        this.asignaturas = asignaturas;
    }

    public int getIdProfesor() {
        return idProfesor;
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

    public String getAsignaturas() {
        return asignaturas;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
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

    public void setAsignaturas(String asignaturas) {
        this.asignaturas = asignaturas;
    }

    @Override
    public String toString() {
        return "Profesores{" + "idProfesor=" + idProfesor + ", nombre=" + nombre + ", apellidos=" + apellidos + ", curso=" + curso + ", asignaturas=" + asignaturas + '}';
    }
    
    
    
    
    
    
}
