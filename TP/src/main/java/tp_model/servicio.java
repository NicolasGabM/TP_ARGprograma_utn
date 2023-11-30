package tp_model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "servicios")
public class servicio {
    @Id
    @Column(name = "servicio_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_servicio;
    @Column(name = "nombre")
    private String nombre;


    public servicio(){

    }
    public servicio(String nombre){
        this.nombre = nombre;
    }
    public int getId_servicio(){
        return this.id_servicio;
    }
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String total(){
        return this.nombre +" ";
    }


}
