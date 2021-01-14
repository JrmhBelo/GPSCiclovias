package pt.iade.GPSCiclovias_projecto.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.GPSCiclovias_projecto.models.Veiculo;
import pt.iade.GPSCiclovias_projecto.models.exceptions.NotFoundException;
import pt.iade.GPSCiclovias_projecto.models.repositories.VeiculoRepository;
import pt.iade.GPSCiclovias_projecto.models.results.Response;



@RestController
@RequestMapping(path="/api/veiculos")
public class VeiculoController {
    private Logger logger = LoggerFactory.getLogger(VeiculoController.class);//CERTO
    @Autowired
    private VeiculoRepository veiculoRepository;
    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Veiculo> getVeiculos() {
        logger.info("Sending all veiculos");
        return veiculoRepository.findAll();
    }
    @GetMapping (path="/{id:[1-15]+}",produces= MediaType.APPLICATION_JSON_VALUE)//CERTO
    public Veiculo findById(@PathVariable int id){
        logger.info("Sending veiculo with id "+id);
        Optional<Veiculo> _veiculo=veiculoRepository.findById(id);
        if (_veiculo.isEmpty()) throw
            new NotFoundException(""+id,"Veiculo","id");
        else return _veiculo.get() ;
    }
    @DeleteMapping (path="/deleteVeiculo/{id:[1-15]+}",produces= MediaType.APPLICATION_JSON_VALUE)//ERRADO?
    public Response deleteVeiculo(@PathVariable int id) {
        logger.info("Delete Veiculo with id number" + id);
        if(veiculoRepository.deleteById(id))
            return new Response (id+"was deleted.",null);
        else return new Response(id+"not found.", null);
    }
    /*@DeleteMapping(path = "/{id:[0-9]+}", … )
    public SimpleResult deleteUnit(@PathVariable int id){
        logger.info("Deleting unit with id "+id);
            // No verification to see if it exists
        unitRepository.deleteById(id);
        return new SimpleResult("Deleted unit with id "+id+
            " (if id does not exists nothing was deleted)",
            null);
    }*/
    @PostMapping(path ="",produces= MediaType.APPLICATION_JSON_VALUE)
    public Veiculo saveVeiculo(@RequestBody Veiculo veiculo) {
        Veiculo savedVeiculo = veiculoRepository.save(veiculo);
        logger.info("Saving veiculo with id "+savedVeiculo.getId());
        return savedVeiculo;
    }
}