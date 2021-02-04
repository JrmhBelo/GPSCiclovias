package pt.iade.GPSCiclovias_projecto.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Table;


@Entity 
@Table(name ="avaliacao")
public class Avaliacao {
    @Id @GeneratedValue
        (strategy = GenerationType.IDENTITY)

@Column(name="av_data") private Date data;
@ManyToOne@JoinColumn(name="escav_id") private EscAvaliacao escala;
@ManyToOne@JoinColumn(name="cic_id") private Ciclovia ciclovia;
@ManyToOne@JoinColumn(name="uti_id")private Utilizador utilizador;

public Avaliacao() {
    
}
public Date getData() {
    return data; 
}
public EscAvaliacao getEscala() {
    return escala;
}
public Ciclovia getCiclovia() {
    return ciclovia;
}
public Utilizador getUtilizador() {
    return utilizador;
}    

}

