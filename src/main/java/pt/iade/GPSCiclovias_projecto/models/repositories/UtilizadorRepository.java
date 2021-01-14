package pt.iade.GPSCiclovias_projecto.models.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import pt.iade.GPSCiclovias_projecto.models.Utilizador;

public interface UtilizadorRepository extends CrudRepository<Utilizador,Integer>{
    Iterable<Utilizador> findAll();
    Optional<Utilizador> findById(int id);
    boolean deleteById(int id);
}