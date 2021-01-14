package pt.iade.GPSCiclovias_projecto.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.Table;


@Entity 
@Table(name ="utilizador_uti_contactos")
public class UtilizadorContactos {
    @Id @GeneratedValue
    (strategy = GenerationType.IDENTITY)
@Column(name="id") private int id;   //como não existe do outro lado prenche com zero
@Column(name="uti_contactos") 
private String[] contactos;
@ManyToOne@JoinColumn(name = "utilizador_uti_id")
private Utilizador utilizador;

public UtilizadorContactos(String[] contactos, Utilizador utilizador){
    this.contactos=contactos;
    this.utilizador=utilizador;
    }
    public String[] getContactos(){
        return contactos;
    }
    public Utilizador getUtilizador(){
        return utilizador;
    }
}