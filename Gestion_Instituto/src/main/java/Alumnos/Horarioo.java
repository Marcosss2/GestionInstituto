/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alumnos;

/**
 *
 * @author Marco
 */
public class Horarioo {
 
  private int id;  
 private String horario;
private  int idA;
    public Horarioo(int id, String horario) {
        this.id = id;
        this.horario = horario;
    }

    
 
 
 
 public Horarioo(String nombre) {
        this.horario = nombre;
    }

    public Horarioo(int id, String horario, int idA) {
        this.id = id;
        this.horario = horario;
        this.idA = idA;
    }

 
    public String gethorario() {
        return horario;
    }

    public int getIdA() {
        return idA;
    }
 
 
 
 
  
    public int getId() {
        return id;
    }
    
  


  
}
