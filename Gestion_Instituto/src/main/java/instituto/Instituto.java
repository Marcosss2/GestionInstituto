/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instituto;

import Alumnos.Alumnos;
import Negocio.Capa;
import Negocio.CapaImp;
import Excepciones.Excepcion;
import java.util.Scanner;
import Alumnos.horario;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import Datos.*;
import static java.lang.System.exit;
import java.sql.SQLException;
import java.util.Scanner;
import static javax.management.Query.or;

public class Instituto {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws Excepcion, ParseException, SQLException {
        // TODO code application logic here
        Capa alumnos = new CapaImp();
       
           
             
		int login=0;
		int pass=0;
		int intentos=1;
		int maximo=3;
	    
		        while((login!=1809)||(pass!=2235)&& (intentos<maximo)){
				Scanner teclado= new Scanner(System.in);
					System.out.println("introduzca un login: ");
					login=teclado.nextInt();
					System.out.println("Introduzca su pass:");
					pass=teclado.nextInt();
					
					if(intentos==3){
						System.out.println("acceso denegado..");
						intentos=intentos-maximo;
					}
				
					intentos++;
					
				
				
				
			}
			
			
			System.out.println("login y pass, correctos...");
        
        
     
        
        
        
        
        
        System.out.println("\nIntroduzca una opcion entre el 0 y 21");
        System.out.println("");
        System.out.println("\n 1 Abrir archivo de Alumnos y Profesores");
        System.out.println("\n 2 Añadir alumnos");
        System.out.println("\n 3 Listar alumnos");
        System.out.println("\n 4 Buscar alumno por id");
        System.out.println("\n 5 Media notas");
        System.out.println("\n 6 Media edad");
        System.out.println("\n 7 Borrar fichero");
        System.out.println("\n 8 Borrar alumno por id");
        System.out.println("\n 9 Añadir profesor");
        System.out.println("\n 10 Listar profesor");
        System.out.println("\n 11 Actualizar datos de los alumnos");
        System.out.println("\n 12 Actualizar datos de los profesores");
        System.out.println("\n 13 Borra profesor por id");
        System.out.println("\n 14 Agregar Asignaturas");
        System.out.println("\n 15 Listar Asignaturas");
        System.out.println("\n 16 Borrar asignaturas por id");
        System.out.println("\n 17 Alumnos ordenados por id de mayor a menor");
        System.out.println("\n 18 horarios de las asignaturas");
        System.out.println("\n 19 los alumnos que han aprobado");
        System.out.println("\n 20 los alumnos que son de segundo curso");
        System.out.println("\n 21Los alumnos ordenados por apellidos");
        System.out.println("\n 22introducir el horario");
        System.out.println("\n 23Los datos de las asignaturas que ya tienen el horario preestablecido");
        
        String fichero = null;
        String fichero1 = null;
        AlumnosD personaDao1 = new AlumnosD();
        Scanner sc = new Scanner(System.in);
        Capa hor = new CapaImp();
        Capa profesores = new CapaImp();
        Capa asignaturas = new CapaImp();
        int opciones;

        do {
            Scanner entrada = new Scanner(System.in);
            opciones = entrada.nextInt();
            switch (opciones) {

                case 0:
                    System.out.println("FIN DEL PROGRAMA");
                    break;

                case 1:
                       System.out.println("abrir archivo de Alumnos y Profesores");
                     
                    alumnos.IniciarArchivo("Alumnos.txt");
                   
                    profesores.IniciarArchivo("Profesores.txt");
                    asignaturas.IniciarArchivo("Asignaturas.txt");
                    // asignaturas.IniciarArchivo("productosss1.txt");
                    System.out.println("\n¿Que más quieres hacer?");
                    break;

                case 2:
                   
                       System.out.println("introduzca los datos del alumnos");
                       System.out.println("id");
                    var ai = sc.nextLine();
                    System.out.println("Nombre");
                    String am = sc.nextLine();
                   System.out.println("Apellido");
                    String ap = sc.nextLine();
                   System.out.println("Curso");
                    String ac = sc.nextLine();
                    System.out.println("Nota");
                    var aat = sc.nextLine();
                    System.out.println("edad");
                    var aa = sc.nextLine();
                    
                    
                    alumnos.AgregarAlumno("Alumnos.txt", ai, am, ap, ac, aat, aa);
                    alumnos.insertar(ai, am, ap, ac, aat, aa);

                    System.out.println("\n¿Que más quieres hacer?");

                    break;

                case 3:
                     
                    //alumnos.Listar("Alumnos.txt");
                    alumnos.seleccionarA();
                    System.out.println("\n¿Que más quieres hacer?");

                    break;

                case 4:
                    System.out.println("introduzca el id del alumno que quiera buscar");
                     
                    String buscar = sc.nextLine();
                    alumnos.Buscar("Alumnos.txt", buscar);
                    System.out.println("\n¿Que más quieres hacer?");
                    break;

                case 5:
                  
                    alumnos.mediaNotas("Alumnos.txt");
                    System.out.println("\n¿Que más quieres hacer?");
                    break;

                case 6:
                    
                    alumnos.media("Alumnos.txt");
                    System.out.println("\n¿Que más quieres hacer?");
                    break;

                case 7:
                     System.out.println("introduzca el nombre del fichero que quiera borrar");
                    String borrar = sc.nextLine();
                    alumnos.Borrar(borrar);
                    System.out.println("\n¿Que más quieres hacer?");
                    break;

                case 8:
                      System.out.println("introduzca el id del alumno que desea borrar");
                        String borrarN = sc.nextLine();
                      alumnos.borrarArticulo("Alumnos.txt", borrarN);
                      alumnos.borrar(borrarN);
                    System.out.println("\n¿Que más quieres hacer?");
                    break;

                case 9:
                       System.out.println("introduzca los datos del profesor");
                    System.out.println("id");
                       var idp = sc.nextLine();
                       System.out.println("nombre");
                    String nombrep = sc.nextLine();
                    System.out.println("apellido");
                    String apellidop = sc.nextLine();
                    System.out.println("curso");
                    String cursop = sc.nextLine();
                    System.out.println("asignatura");
                    String asignaturap = sc.nextLine();  
                       
                       
                    profesores.AgregarProfesor("Profesores.txt",idp,nombrep,apellidop,cursop,asignaturap);
                    profesores.insertarP(idp,nombrep,apellidop,cursop,asignaturap);
                    System.out.println("\n¿Que más quieres hacer?");
              break;
                case 10:
                    
                    profesores.Listar1("Profesores.txt");
                    profesores.seleccionarP();
                    System.out.println("\n¿Que más quieres hacer?");

                    break;

              
                

                case 11:
                    System.out.println("introduzca los datos del alumno");
                    System.out.println("id");
                    var a = sc.nextLine();
                    System.out.println("nombre");
                    String b = sc.nextLine();
                    System.out.println("apellido");
                    String ccc = sc.nextLine();
                    System.out.println("Curso");
                    String d = sc.nextLine();
                    System.out.println("notas");
                    var eee = sc.nextLine();
                    System.out.println("edad");
                    var f = sc.nextLine();

                    alumnos.actualizar(a, b, ccc, d, eee, f);
                    System.out.println("\n¿Que más quieres hacer?");
                    break;

              

                case 12:
                     
                    System.out.println("introduzca los datos del profesor");
                    System.out.println("id");
                    var idpp = sc.nextLine();
                    System.out.println("nombre");
                    String nombrepp = sc.nextLine();
                    System.out.println("apellido");
                    String apellidopp = sc.nextLine();
                    System.out.println("curso");
                    String cursopp = sc.nextLine();
                    System.out.println("asignatura");
                    String asignaturapp = sc.nextLine();
                    
                    profesores.actualizarP(idpp,nombrepp,apellidopp,cursopp,asignaturapp);
                     System.out.println("\n¿Que más quieres hacer?");
                    break;

                case 13:
                    
                    System.out.println("introduzca el id");
                     var idppp = sc.nextLine();
                    
                    
                    
                    profesores.borrarP(idppp);
                    System.out.println("\n¿Que más quieres hacer?");
                    break;


                case 14:
                    System.out.println("id");
                    var asi = sc.nextLine();
                    System.out.println("nombre");
                    String tip = sc.nextLine();
                    System.out.println("fecha actual");
                    var fecha = sc.nextLine();
                    
                    asignaturas.AgregarAsignatura("Asignaturas.txt",asi,tip,fecha);
                    asignaturas.insertarS(asi, tip, fecha);
              
                System.out.println("\n¿Que más quieres hacer?");
                break;
                case 15:
                   System.out.println("los datos de asignaturas");
                // asignaturas.Listar2("Asignaturas.txt");
                 asignaturas.seleccionarS();
                System.out.println("\n¿Que más quieres hacer?");
                break;     
                 
                
                 case 16:
                    
                    System.out.println("introduzca el id de la asignatura");
                     var iA = sc.nextLine();
                   
                    
                    
                    
                   asignaturas.borrarS(iA);
                    System.out.println("\n¿Que más quieres hacer?");
                    break;
                      case 17:
                    
                    
                     alumnos.ORD();
                      
                    System.out.println("\n¿Que más quieres hacer?");
                     break;
                   case 18:
               
                   String a3;   
                   
               do {
                   System.out.println("introduzca el nombre de la asignatura");
                   a3 = sc.nextLine();
                 switch(a3){
             case "Lengua":
                 
                System.out.println("Esta asignatura es el " + horario.Lunes);
                
                break;
                
             case "Ingles":
                  
                 System.out.println("Esta asignatura es el " + horario.Martes);
                 
                 break;
             case "Matematicas":
                System.out.println("Esta asignatura es el " + horario.Miercoles);
                break;
             case "Historia":
                System.out.println("Esta asignatura es el " + horario.Jueves);
                 break;
             case "Fisica":
                System.out.println("Esta asignatura es el " + horario.Viernes);
                break;
       
              case "Musica":
                System.out.println("Esta asignatura es el " + horario.Viernes);
                break;
                case "Latin":
                System.out.println("Esta asignatura es el " + horario.Martes);
                break;
                case "Plastica":
                System.out.println("Esta asignatura es el " + horario.Lunes);
                break;
               
               case "Economia":
                System.out.println("Esta asignatura es el " + horario.Viernes);
                break;
               
               case "Salir":
                 
                return;
                default:
                    System.out.println("Esta asignatura no existe");
               
               }

                   }while(a3 != "a");
                     
                    
                    break;
                    
                    
                  case 19:
                    
                    
                     alumnos.N();
                      
                    System.out.println("\n¿Que más quieres hacer?");
                     break;    
                    
                  case 20:
                    
                    
                     alumnos.E();
                      System.out.println("\n¿Que más quieres hacer?");
                    
                     break; 
                     
                     case 21:
                    
                   
                     alumnos.O1();
                      System.out.println("\n¿Que más quieres hacer?");
                    
                     break; 
                    case 22:
                    
                   
                     
                      System.out.println("id");
                     var nu= sc.nextLine();
                     System.out.println("dia de la semana");
                    String horario = sc.nextLine();
                    
                    
                    
                    asignaturas.insertarh(nu,horario,1);
                    
                    System.out.println("\n¿Que más quieres hacer?");
                    
                     break; 
                     
                   case 23:
                  
                
                 asignaturas.seleccionarSh();
                System.out.println("\n¿Que más quieres hacer?");
                break; 
                     
                default:
                    System.out.println("Valor erroneo");
            }

        } while (opciones != 0);

    }

}
