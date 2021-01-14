package pt.iade.GPSCiclovias_projecto.models.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import pt.iade.GPSCiclovias_projecto.models.Veiculo;

public interface VeiculoRepository extends CrudRepository<Veiculo,Integer>{
    Iterable<Veiculo> findAll();
    Optional<Veiculo> findById(int id); 
    boolean deleteById(int id);
}