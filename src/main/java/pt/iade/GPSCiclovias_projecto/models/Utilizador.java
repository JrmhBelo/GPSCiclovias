package pt.iade.GPSCiclovias_projecto.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.Column;
import javax.persistence.Table;

import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;

@Entity
@Table(name = "utilizador")
public class Utilizador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uti_id")
    private int id;
    @Column(name = "uti_nome")
    private String nome;
    @Column(name = "uti_morada")
    private String morada;
    @Column(name = "uti_genero")
    private char genero;
    @Column(name = "uti_dnasc")      
    private LocalDate dnasc;
    @Column(name = "uti_idade")         
    private int idade; 
    /*@OneToMany(mappedBy="contactos")
    private List<UtilizadorContactos> contactos = new ArrayList<>();*/

    public Utilizador(){
    }
    public int getId() {
        return id;
    }
    public String getNome(){
        return nome;
    }
    public String getMorada(){
        return morada;
    }
    public char getGenero(){
        return genero;
    }
    public LocalDate getDnasc(){
        return dnasc;
    }
    public int getIdade(){
        return idade;
    }
    /*public List<UtilizadorContactos> getContactos() {
        return contactos;
    }*/
}