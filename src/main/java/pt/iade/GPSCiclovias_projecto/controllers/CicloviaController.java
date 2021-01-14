package pt.iade.GPSCiclovias_projecto.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.GPSCiclovias_projecto.models.Ciclovia;
import pt.iade.GPSCiclovias_projecto.models.exceptions.NotFoundException;
import pt.iade.GPSCiclovias_projecto.models.repositories.CicloviaRepository;

import java.util.Optional;

@RestController
@RequestMapping(path="/api/ciclovias")
public class CicloviaController {
    private Logger logger = LoggerFactory.getLogger(CicloviaController.class);
    @Autowired
    private CicloviaRepository cicloviaRepository;
    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Ciclovia> getCiclovias() {
        logger.info("Sending all ciclovias");
        return cicloviaRepository.findAll();
    }
    @GetMapping (path="/{id:[1-15]+}",produces= MediaType.APPLICATION_JSON_VALUE)
    public Ciclovia findById(@PathVariable int id){
        logger.info("Sending Ciclovia with id number" + id);
        Optional <Ciclovia> _ciclovia=cicloviaRepository.findById(id);
        if(_ciclovia.isEmpty()) throw
            new NotFoundException (""+id,"Ciclovia","id");
        else return _ciclovia.get();
    }
    @GetMapping(path = "/{distrito:[^1-15]+}",produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Ciclovia> getCicloviaDistrito(@PathVariable(value = "distrito") String distrito) {
        logger.info("Sending Ciclovia with distrito "+distrito);
        return cicloviaRepository.findByDistrito(distrito);
    }
    @GetMapping (path="/{distrito:[^1-15]+}/{cidade:[^1-15]+}",produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Ciclovia> getCicloviaCidade(@PathVariable("cidade") String cidade){
        logger.info("Sending Ciclovias with cidade " + cidade);
            return cicloviaRepository.findByCidade(cidade);
    }
    @GetMapping (path="/search/{min}/{max}",produces= MediaType.APPLICATION_JSON_VALUE)//CERTO
    public Iterable<Ciclovia> findByExtensaoBetween(@PathVariable("min") int min,
                                                    @PathVariable("max")int max){
        logger.info("Sending Ciclovias with extensao between" + min + " and "+max);
        return cicloviaRepository.findByExtensaoBetween(min,max);
    }
    /*@GetMapping (path="/{pdi}",produces= MediaType.APPLICATION_JSON_VALUE)//ERRO
    public ArrayList<Ciclovia> getCicPdi(@PathVariable("pdi")String pdi)
                                            throws NotFoundException{
        logger.info("Sending Ciclovias with Ponto de Interesse" + pdi);
        ArrayList<Ciclovia> ciclovia= CicloviaRepository.getCicPdi(pdi);
        if(ciclovia!=null)return ciclovia;
        else throw new NotFoundException (""+pdi,"Ciclovia","ponto de interesse");
    }*/
}