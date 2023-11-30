package tp_model;

import jakarta.persistence.*;

@Entity
@Table(name = "incidentes")
public class incidentes {
    @Id
    @Column(name = "incidente_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_incidente;
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "cli_id")
    private int incUsuario;

    @Column(name = "serv_id")
    private int incServicio;

    @Column(name = "tec_id")
    private int incTecnico;

    public incidentes(){

    }
    public incidentes(String descripcion, int usuario, int servicio, int tecnico){
        this.descripcion = descripcion;
        this.incUsuario = usuario;
        this.incServicio = servicio;
        this.incTecnico = tecnico;
    }

    public String getDescripcion(){
        return this.descripcion;
    }
    public int getUsuario(){
        return this.incUsuario;
    }
    public int getServicio(){
        return this.incServicio;
    }
    public int getTecnico(){
        return this.incTecnico;
    }
    public int getId_incidente(){return this.id_incidente;}

}
