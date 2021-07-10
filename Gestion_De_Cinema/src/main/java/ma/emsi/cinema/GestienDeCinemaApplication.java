package ma.emsi.cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import ma.emsi.cinema.entities.Film;
import ma.emsi.cinema.entities.Salle;
import ma.emsi.cinema.entities.Ticket;
import ma.emsi.cinema.service.ICinemaInitService;

@SpringBootApplication
public class GestienDeCinemaApplication implements CommandLineRunner {
	@Autowired
	private ICinemaInitService cinemaInitService ;

	@Autowired
	private RepositoryRestConfiguration restConfiguration;
	public static void main(String[] args)  {
		SpringApplication.run(GestienDeCinemaApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		restConfiguration.exposeIdsFor(Film.class,Salle.class,Ticket.class);
		cinemaInitService.initVilles();
		cinemaInitService.initCinemas();
		cinemaInitService.initSalles();
		cinemaInitService.initPlaces();
		cinemaInitService.initSeances();
		cinemaInitService.initCategories();
		cinemaInitService.initFilms();
		cinemaInitService.initProjections();
		cinemaInitService.initTickets();
	}

}
