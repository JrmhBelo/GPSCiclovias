package pt.iade.GPSCiclovias_projecto.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.GPSCiclovias_projecto.models.EscAvaliacao;
import pt.iade.GPSCiclovias_projecto.models.repositories.EscAvaliacaoRepository;


@RestController
@RequestMapping(path="/api/escavaliacao")
public class EscAvaliacaoController {
    private Logger logger = LoggerFactory.getLogger(EscAvaliacaoController.class);
    @Autowired
    private EscAvaliacaoRepository escavaliacaoRepository;
    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<EscAvaliacao> getEscalaAvaliacao() {
        logger.info("Sending escala avaliacoes");
        return escavaliacaoRepository.findAll();
    }
}