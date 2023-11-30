package tp_model;

import jakarta.persistence.*;

@Entity
@Table(name = "tecnicos")
public class tecnico {
    @Id
    @Column(name = "tecnico_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tecnico;
    private String nombre;

    public tecnico(){

    }

    public tecnico(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }
    public int getId_tecnico(){
        return this.id_tecnico;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String total(){
        return this.nombre+" "+"\n tecnico id: "+this.id_tecnico;
    }
}
