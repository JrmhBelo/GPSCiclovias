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

import pt.iade.GPSCiclovias_projecto.models.Utilizador;
import pt.iade.GPSCiclovias_projecto.models.exceptions.NotFoundException;
import pt.iade.GPSCiclovias_projecto.models.repositories.UtilizadorRepository;
import pt.iade.GPSCiclovias_projecto.models.results.Response;



@RestController
@RequestMapping(path="/api/utilizador")
public class UtilizadorController {
    private Logger logger = LoggerFactory.getLogger(UtilizadorController.class);
    @Autowired
    private UtilizadorRepository utilizadorRepository;
    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Utilizador> getUtilizadores() {
        logger.info("Sending all utilizadores");
        return utilizadorRepository.findAll();
    }
    @GetMapping(path = "/{id:[1-15]+}",produces= MediaType.APPLICATION_JSON_VALUE)
    public Utilizador getUtilizador(@PathVariable int id) {
        logger.info("Sending utilizador with id "+id);
        Optional<Utilizador> _utilizador=utilizadorRepository.findById(id);
        if (_utilizador.isEmpty()) throw
            new NotFoundException(""+id,"Utilizador","id");
        else return _utilizador.get() ;
    }
    @DeleteMapping (path="/deleteUtilizador/{id:[1-15]+}",produces= MediaType.APPLICATION_JSON_VALUE)
    public Response deleteUtilizador(@PathVariable int id) {
        logger.info("Delete Utilizador with id number" + id);
        if(utilizadorRepository.deleteById(id))
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
    public Utilizador saveUtilizador(@RequestBody Utilizador utilizador) {
        Utilizador savedUtilizador = utilizadorRepository.save(utilizador);
        logger.info("Saving utilizador with id "+savedUtilizador.getId());
        return savedUtilizador;
    }
}
