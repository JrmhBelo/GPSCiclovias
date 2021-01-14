package pt.iade.GPSCiclovias_projecto.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.Column;
import javax.persistence.Table;

//import java.util.List;

@Entity 
@Table(name ="categoriaciclovia")
public class CategoriaCiclovia {
    @Id @GeneratedValue
        (strategy = GenerationType.IDENTITY)
@Column(name="cc_id") private int id;
@Column(name="cc_nome") private String nome;
@Column(name="cc_descricao")private String descricao;
/*@OneToMany(mappedBy="categoriaciclovia")
private List<Ciclovia> ciclovias;*/


public CategoriaCiclovia() {
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
    /*public List<Ciclovia> getCiclovias(){
        return ciclovias;
    }*/
}
