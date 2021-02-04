package pt.iade.GPSCiclovias_projecto.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;



@Entity 
@Table(name ="escala_avaliacao")
public class EscAvaliacao {
    @Id @GeneratedValue
        (strategy = GenerationType.IDENTITY)
@Column(name="escav_id") private int id;
@Column(name="escav_descricao") private String descricao;
@Column(name="escav_avaliacao")private int avaliacao;

public EscAvaliacao() {
}

public int getId() {
    return id;
}
public String getDescricao() {
    return descricao;
}
public int getAvaliacao() {
    return avaliacao;
}


}
