package ma.emsi.cinema.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ma.emsi.cinema.dao.*;

import ma.emsi.cinema.entities.*;
import javax.transaction.Transactional;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@RestController
@CrossOrigin("*")
public class CinemaRestController {
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private TicketRepository ticketRepository;
    /*
    @GetMapping("/listFilms")
    public List<Film> films(){return filmRepository.findAll();}*/

    @GetMapping(path = "/imageFilm/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] image(@PathVariable (name="id")Long id) throws Exception{
        Film f= filmRepository.findById(id).get();
        String photoName=f.getPhoto();
        File file = new File(System.getProperty("user.home")+"/cinema/images/"+photoName);
        Path path = Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }

    @PostMapping("/payerTickets")
    @Transactional
    public List<Ticket> payerTickets(@RequestBody TicketForm ticketForm){
        List<Ticket> listTickets=new ArrayList<>();
        ticketForm.getTickets().forEach(idTicket->{
           Ticket ticket =  ticketRepository.findById(idTicket).get();
           ticket.setNomClient(ticketForm.getNomClient());
           ticket.setReserve(true);
           ticket.setCodePayement(ticketForm.getCodePayement());
           ticketRepository.save(ticket);

           listTickets.add(ticket);
        });
        return listTickets;
    }

      @Data
       static class TicketForm{
    	    private String nomClient;
            private Integer codePayement;
            private List<Long> tickets = new ArrayList<>();

      }
}