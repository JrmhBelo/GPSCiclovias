package pt.iade.GPSCiclovias_projecto.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.GPSCiclovias_projecto.models.EscAvaliacao;

public interface EscAvaliacaoRepository extends CrudRepository<EscAvaliacao,Integer>{
    Iterable<EscAvaliacao> findAll();

}