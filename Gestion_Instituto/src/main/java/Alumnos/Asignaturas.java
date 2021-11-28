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
public class Asignaturas {
   
    private int idAsignaturas;
    private String nombre; 
    private Date Fechaexam;

    public Asignaturas(int idAsignaturas) {
        this.idAsignaturas = idAsignaturas;
    }

    public Asignaturas(String nombre) {
        this.nombre = nombre;
    }

    
    public Asignaturas(int idAsignaturas, String nombre) {
        this.idAsignaturas = idAsignaturas;
        this.nombre = nombre;
    }
    
   
   
    
    public Asignaturas(int idAsignaturas, String nombre, Date Fechaexam) {
        this.idAsignaturas = idAsignaturas;
        this.nombre = nombre;
        this.Fechaexam = Fechaexam;
    }

    public int getIdAsignaturas() {
        return idAsignaturas;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechaexam() {
        return Fechaexam;
    }

    public void setIdAsignaturas(int idAsignaturas) {
        this.idAsignaturas = idAsignaturas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaexam(Date Fechaexam) {
        this.Fechaexam = Fechaexam;
    }

    @Override
    public String toString() {
        return "Asignaturas{" + "idAsignaturas=" + idAsignaturas + ", nombre=" + nombre + ", Fechaexam=" + Fechaexam + '}';
    }
   
    
    
    
    
    
    
    
    

    
}
