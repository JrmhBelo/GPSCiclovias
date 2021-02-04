package pt.iade.GPSCiclovias_projecto.models.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import pt.iade.GPSCiclovias_projecto.models.Avaliacao;
import pt.iade.GPSCiclovias_projecto.models.Ciclovia;
import pt.iade.GPSCiclovias_projecto.models.Utilizador;

public interface AvaliacaoRepository extends CrudRepository<Avaliacao,Integer>{
    Iterable<Avaliacao> findAll();
    Iterable<Avaliacao> findByCicloviaId(int cic_id);
    Iterable<Avaliacao> findByUtilizadorId(int int_id); 
    //Iterable<Avaliacao> findAvByCiclovia(Ciclovia nome);
}
