package pt.iade.GPSCiclovias_projecto.models.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import pt.iade.GPSCiclovias_projecto.models.Ciclovia;

public interface CicloviaRepository extends CrudRepository<Ciclovia,Integer>{
    Iterable<Ciclovia> findAll();
    Optional<Ciclovia> findById(int id);
    Iterable<Ciclovia> findByExtensaoBetween(int _extensaoMin, int _extensaoMax);
    Iterable<Ciclovia> findByDistrito(String distrito);
    Iterable<Ciclovia> findByCidade(String cidade);
}