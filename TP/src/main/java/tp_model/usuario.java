package tp_model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "clientes")
public class usuario {
    //atributos
    @Id
    @Column(name = "cliente_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;

    @Column (name = "mail")
    private String mail;


    public usuario(){

    }
    public usuario(String nombre,String apellido,  String mail){
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;

    }
    //getters
    public int getId(){return this.id_usuario;}
    public String getNombre(){
        return this.nombre;
    }
    public String getApellido(){
        return this.apellido;
    }
    public String getMail(){
        return this.mail;
    }


    //setters
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    public void setMail(String mail){
        this.mail = mail;
    }

    public String total(){
        return "Usuario: id "+id_usuario+" nombre y apellido "+nombre+" "+apellido+"\n"+" ";
    }
}
