package pt.iade.GPSCiclovias_projecto.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name ="Escala_avaliacao")
public class Avaliacao {
    @Id @GeneratedValue
        (strategy = GenerationType.IDENTITY)
@Column(name="escav_id") private int id;
@Column(name="escav_avaliacao") private int ava;
@Column(name="escav_descricao")private String descricao;


    public Avaliacao() {
    }
    public int getId(){
        return id;
    }
    public int getAva(){
        return ava;
    }
    public String getDescricao(){
        return descricao;
    }
}