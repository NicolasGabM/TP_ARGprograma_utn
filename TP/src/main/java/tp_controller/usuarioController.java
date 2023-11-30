package tp_controller;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import tp_model.servicio;
import tp_model.usuario;

import java.util.List;


public class usuarioController {
    public String crearUsuario(String nombre, String apellido, String mail){

        SessionFactory sessionFactory = new
                Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(usuario.class).buildSessionFactory();
        Session session = sessionFactory.openSession();

        try{
            usuario usuarioNuevo = new usuario(nombre,apellido,mail);
            session.beginTransaction();
            session.persist(usuarioNuevo);
            session.getTransaction().commit();
            sessionFactory.close();

            return "usuario creado\n------------------\n" +usuarioNuevo.total();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "error al intentar ingresar un nuevo usuario";
    }
    public String elimiarUsuario(int id){

        SessionFactory sessionFactory = new
                Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(usuario.class).buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            usuario usuarioAeliminar = session.get(usuario.class,id);
            session.remove(usuarioAeliminar);
            session.getTransaction().commit();
            sessionFactory.close();

            return "El usuario con el ID "+id+" fue eliminado";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Error al eliminar usuario.";
    }

    public String actualizarUsuario(int id,String nombre, String apellido, String mail, int cuit){

        SessionFactory sessionFactory = new
                Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(usuario.class).buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            usuario usuarioActualizar = session.get(usuario.class, id);
            usuarioActualizar.setNombre(nombre);
            usuarioActualizar.setApellido(apellido);
            usuarioActualizar.setMail(mail);
            session.persist(usuarioActualizar);
            session.getTransaction().commit();
            sessionFactory.close();

            return "El usuario con el ID "+id+" fue actualizado\n------------------\n"+usuarioActualizar.total();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Error al actualizar usuario.";
    }
    public String leerUsuario(int id){

        SessionFactory sessionFactory = new
                Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(usuario.class).buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            usuario usuarioAleer = session.get(usuario.class,id);
            session.getTransaction().commit();
            sessionFactory.close();

            return "Usuario ID "+id+"\n------------------\n"+usuarioAleer.total();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Error al leer usuario.";
    }
    public String listarUsuarios(){

        SessionFactory sessionFactory = new
                Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(usuario.class).buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            CriteriaQuery<usuario> cq = session.getCriteriaBuilder().createQuery(usuario.class);
            cq.from(usuario.class);
            List<usuario> listaUsuarios = session.createQuery(cq).getResultList();

            System.out.println("Lista de usuarios: \n");
            for(usuario u : listaUsuarios){
                System.out.println(u.getId());
                System.out.println(u.getNombre()+" ");
                System.out.println(u.getApellido()+" ");
                System.out.println(u.getMail()+"\n");
                System.out.println("++++++++++++++++++++++++++++++++++++++++++");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return "Error al listar.";
    }




}

