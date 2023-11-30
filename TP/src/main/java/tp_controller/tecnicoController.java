package tp_controller;

import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import tp_model.tecnico;
import tp_model.usuario;

import java.util.List;

public class tecnicoController {
    public String crearTecnico(String nombre){

        SessionFactory sessionFactory = new
                Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(tecnico.class).buildSessionFactory();
        Session session = sessionFactory.openSession();

        try{
            tecnico tecnicoNuevo = new tecnico(nombre);
            session.beginTransaction();
            session.persist(tecnicoNuevo);
            session.getTransaction().commit();
            sessionFactory.close();

            return "tecnico creado\n------------------\n" +tecnicoNuevo.getNombre();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "error al intentar ingresar un nuevo tecnico";
    }
    public String listarTecnicos(){

        SessionFactory sessionFactory = new
                Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(tecnico.class).buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            CriteriaQuery<tecnico> cq = session.getCriteriaBuilder().createQuery(tecnico.class);
            cq.from(tecnico.class);
            List<tecnico> listaTecnicos = session.createQuery(cq).getResultList();

            System.out.println("TECNICOS: \n");
            for(tecnico t : listaTecnicos){
                System.out.println(t.getId_tecnico());
                System.out.println(t.getNombre()+" ");
                System.out.println("++++++++++++++++++++++++++++++++++++++++++");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return "Error al listar.";
    }
    public String elimiarTecnico(int id){

        SessionFactory sessionFactory = new
                Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(tecnico.class).buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            tecnico tecnicoAeliminar = session.get(tecnico.class,id);
            session.remove(tecnicoAeliminar);
            session.getTransaction().commit();
            sessionFactory.close();

            return "El tecnico con el ID "+id+" fue eliminado";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Error al eliminar tecnico.";
    }
    public String leerTecnico(int id){

        SessionFactory sessionFactory = new
                Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(tecnico.class).buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            tecnico tecnicoAleer = session.get(tecnico.class,id);
            session.getTransaction().commit();
            sessionFactory.close();

            return "tecnico ID "+id+"\n------------------\n"+tecnicoAleer.total();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Error al leer tecnico.";
    }

}
