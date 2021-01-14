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
@Table(name ="tipoveiculo")
public class TipoVeiculo {
    @Id @GeneratedValue
        (strategy = GenerationType.IDENTITY)
@Column(name="tv_id") private int id;
@Column(name="tv_nome") private String nome;
@Column(name="tv_descricao")private String descricao;
@ManyToOne@JoinColumn(name = "veiculo_vei_id")
private Veiculo veiculo;

public TipoVeiculo(){
    }
    public int getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public String getDescricao(){
        return descricao;
    }
    public Veiculo getVeiculo(int id){
    return veiculo;
    }
}
