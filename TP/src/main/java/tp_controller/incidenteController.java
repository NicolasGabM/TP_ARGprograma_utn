package tp_controller;


import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import tp_model.*;

import java.util.List;

public class incidenteController {
    public String crearIncidente(String nombre, int idUsu, int idTec, int idServ) {

        SessionFactory sessionFactory = new
                Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(incidentes.class).buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            incidentes incidenteNuevo = new incidentes(nombre, idUsu, idServ, idTec);
            session.beginTransaction();
            session.persist(incidenteNuevo);
            session.getTransaction().commit();
            sessionFactory.close();

            return "Se reporto un incidente "+incidenteNuevo.getDescripcion()+"\n------------------\n";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error al intentar ingresar un nuevo tecnico";
    }

    public String listarIncidentes() {

        SessionFactory sessionFactory = new
                Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(incidentes.class).buildSessionFactory();
        Session session = sessionFactory.openSession();

        usuarioController usu= new usuarioController();
        servicioController ser = new servicioController();
        tecnicoController tec = new tecnicoController();


        try {
            session.beginTransaction();

            CriteriaQuery<incidentes> cq = session.getCriteriaBuilder().createQuery(incidentes.class);
            cq.from(incidentes.class);
            List<incidentes> listaIncidentes = session.createQuery(cq).getResultList();

            System.out.println("\tLista de Incidentes: \n");
            for(incidentes x : listaIncidentes) {
                System.out.println(x.getId_incidente());
                System.out.println(x.getDescripcion());
                System.out.println(usu.leerUsuario(x.getUsuario()));
                System.out.println(tec.leerTecnico(x.getTecnico()));
                System.out.println(ser.leerServicio(x.getServicio()));

                System.out.println("++++++++++++++++++++++++++++++++++++++++++");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Error al listar.";
    }
}
