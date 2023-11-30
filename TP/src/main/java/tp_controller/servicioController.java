package tp_controller;

import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import tp_model.servicio;
import tp_model.usuario;

import java.util.List;

public class servicioController {

    public String crearServicio(String nombre){

        SessionFactory sessionFactory = new
                Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(servicio.class).buildSessionFactory();
        Session session = sessionFactory.openSession();

        try{
            servicio servicioNuevo = new servicio(nombre);
            session.beginTransaction();
            session.persist(servicioNuevo);
            session.getTransaction().commit();
            sessionFactory.close();

            return "servicio creado\n------------------\n" +servicioNuevo.getNombre();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "error al intentar ingresar un nuevo servicio";
    }


    public String listarServicios(){

        SessionFactory sessionFactory = new
                Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(servicio.class).buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            CriteriaQuery<servicio> cq = session.getCriteriaBuilder().createQuery(servicio.class);
            cq.from(servicio.class);
            List<servicio> listaServicios = session.createQuery(cq).getResultList();

            System.out.println("Lista de servicios: \n");
            for(servicio s : listaServicios){
                System.out.println(s.getId_servicio());
                System.out.println(s.getNombre());
                System.out.println("++++++++++++++++++++++++++++++++++++++++++");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return "Error al listar todos los servicios.";
    }
    public String leerServicio(int id){

        SessionFactory sessionFactory = new
                Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(servicio.class).buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            servicio servicioAleer = session.get(servicio.class,id);
            session.getTransaction().commit();
            sessionFactory.close();

            return "servicio"+id+"\n------------------\n"+servicioAleer.total();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Error al leer usuario.";
    }
}
