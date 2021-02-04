package pt.iade.GPSCiclovias_projecto.models.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pt.iade.GPSCiclovias_projecto.models.Utilizador;
import pt.iade.GPSCiclovias_projecto.models.views.AtividadeStatsView;

public interface UtilizadorRepository extends CrudRepository<Utilizador,Integer>{
    Iterable<Utilizador> findAll();
    Optional<Utilizador> findById(int id);
    boolean deleteById(int id);
    String statsQuery = "SELECT uti_id as Id , uti_nome as Nome, sum(cic_extensao) as Extensao , count(*) as Cicpercorridas, "+
    "(select count(*) from veiculo where Utilizador.uti_id = veiculo.vei_id) as VeiUtilizados "+
    "from Utilizador "+
    "Inner join Ciclovia "+
    "ON Utilizador.uti_id=Ciclovia.cic_id "+
    "group by uti_id ";
    
    @Query(value=statsQuery, nativeQuery=true)
    Iterable<AtividadeStatsView> getAtividadeStats();
}