package pt.iade.GPSCiclovias_projecto.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name = "veiculo")
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vei_id")
    private int id;
    @Column(name = "vei_numerorodas") 
    private int numerorodas;
    @Column(name = "vei_marca")
    private String marca;
    @Column(name = "vei_modelo")
    private String modelo;
    @ManyToOne@JoinColumn(name="uti_id")
    private Utilizador utilizador;
    @OneToMany(mappedBy="id")
    private List<TipoVeiculo> tipoveiculo = new ArrayList<>();

    public Veiculo() {
    }
    public int getId() {
        return id;
    }
    public int getNrodas(){
        return numerorodas;
    }
    public String getMarca(){
        return marca;
    }
    public String getModelo(){
        return modelo;
    }
    public List<TipoVeiculo> getTipoVeiculo(int id){
        return tipoveiculo;
    }
}