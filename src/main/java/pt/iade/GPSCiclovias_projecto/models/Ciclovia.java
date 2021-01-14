package pt.iade.GPSCiclovias_projecto.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Table;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;

@Entity 
@Table(name ="ciclovia")
public class Ciclovia {
    @Id @GeneratedValue
        (strategy = GenerationType.IDENTITY)
@Column(name="cic_id") private int id;
@Column(name="cic_nome") private String nome;
@Column(name="cic_extensao")private int extensao;
@Column(name="cic_inicio") private String inicio;
/*@Column(name="cic_iniCoord") private String iniCoord;*/
@Column(name="cic_descricao") private String descricao;
@Column(name="cic_fim") private String fim;
/*@Column(name="cic_fimCoord") private String fimCoord;*/
@Column(name="cic_distrito") private String distrito;
@Column(name="cic_cidade") private String cidade;
/*@ManyToOne@JoinColumn(name="cc_id")
private CategoriaCiclovia categoriaciclovia;*/
/*@OneToMany(mappedBy="pdi")
private List<CicloviaPontosInteresse> pdi = new ArrayList<>();*/


public Ciclovia() {	
	}
    public int getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public double getExtensao(){
        return extensao;
    }
    public String getInicio(){
        return inicio;
    }
    /*public String getIniCoord(){
        return iniCoord;
    }*/
    public String getDescricao(){
        return descricao;
    }
    public String getFim(){
        return fim;
    }
    /*public String getFimCoord(){
        return fimCoord;
    }*/
    public String getDistrito(){
        return distrito;
    }
    public String getCidade(){
        return cidade;
    }
    /*public List<CicloviaPontosInteresse> getPdi(){
        return pdi;
    }*/
}