package tp_views;
import tp_controller.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.Scanner;

public class vistaPrincipal {
    public static void main(String[] args){
        //siguiente linea puesta para obviar las salidas por consola de hibernate.
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        usuarioController usuarioCont = new usuarioController();
        servicioController servicioCont = new servicioController();
        tecnicoController tecnicoCont = new tecnicoController();
        incidenteController incidenteCont = new incidenteController();
        try(Scanner scanner = new Scanner(System.in)){
            char opcion;
            boolean aux = true;
            String menu = "\t MENU \n"
                    +"1 crear usuario \n"
                    +"2 contratar servicio \n"
                    +"3 alta tecnico \n"
                    +"4 alta incidente \n"
                    +"5 listado usuarios \n"
                    +"6 listado servicios \n"
                    +"7 listado tecnicos \n"
                    +"8 listado incidentes \n"
                    +"9 salir ";
            while(aux){
                System.out.println(menu);
                opcion = scanner.next().charAt(0);
                switch (opcion){
                    case '1' :
                        System.out.println("creando Usuario");
                        System.out.println("Escriba el nombre del usuario");
                        String nombreU = scanner.next();
                        System.out.println("Escriba el apellido del usuario");
                        String apellidoU = scanner.next();
                        System.out.println("Escriba el mail del usuario");
                        String mail = scanner.next();
                        System.out.println(usuarioCont.crearUsuario(nombreU,apellidoU,mail));
                    break;
                    case '2':
                        System.out.println("Contratar servicio");
                        System.out.println("cual es el nombre del servicio a contratar");
                        String nombreServ = scanner.next();
                        System.out.println(servicioCont.crearServicio(nombreServ));
                        break;
                    case '3':
                        System.out.println("Alta de tecnico");
                        System.out.println("cual es el nombre del tecnico a contratar");
                        String nombreTec = scanner.next();
                        System.out.println(tecnicoCont.crearTecnico(nombreTec));
                        break;
                    case '4':
                        System.out.println("Dar de alta nuevo incidente");
                        System.out.println("Breve descripcion del incidente");
                        String desc = scanner.next();
                        System.out.println("Indicar el id del cliente");
                        int incCli = scanner.nextInt();
                        System.out.println("Indicar el id del Tecnico a asignar");
                        int incTec = scanner.nextInt();
                        System.out.println("Indicar el id del servicio");
                        int incServ = scanner.nextInt();
                        System.out.println(incidenteCont.crearIncidente(desc,incCli,incTec,incServ));
                        break;
                    case '5':
                        usuarioCont.listarUsuarios();
                        break;
                    case '6':
                        servicioCont.listarServicios();
                        break;
                    case '7':
                        tecnicoCont.listarTecnicos();
                        break;
                    case  '8':
                        incidenteCont.listarIncidentes();
                        break;
                    case '9':
                        System.out.println("SALIR");
                        aux = false;
                        break;
                   default:
                       System.out.println("opcion invalida.");


                }
            }

        }





    }


}
