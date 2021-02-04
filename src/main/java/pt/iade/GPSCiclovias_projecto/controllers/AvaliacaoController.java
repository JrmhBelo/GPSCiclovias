package pt.iade.GPSCiclovias_projecto.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.GPSCiclovias_projecto.models.Avaliacao;
import pt.iade.GPSCiclovias_projecto.models.repositories.AvaliacaoRepository;


@RestController
@RequestMapping(path="/api/avaliacao")
public class AvaliacaoController {
    private Logger logger = LoggerFactory.getLogger(AvaliacaoController.class);
    @Autowired
    private AvaliacaoRepository avaliacaoRepository;
    
    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Avaliacao> getAvaliacao() {
        logger.info("Sending escala avaliacoes");
        return avaliacaoRepository.findAll();
    }
    
    @GetMapping (path="/ciclovia/{id}",produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Avaliacao> findByCicloviaId(@PathVariable int id) {
        logger.info("Sending avaliacao from ciclovia with id number" + id);
        return avaliacaoRepository.findByCicloviaId(id);   
    }
    

    @GetMapping (path="/utilizador/{id}",produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Avaliacao> findByUtilizadorId(@PathVariable int id) {
        logger.info("Sending avaliacao from utilizador with id number" + id);
        return avaliacaoRepository.findByUtilizadorId(id);   
    }
}
