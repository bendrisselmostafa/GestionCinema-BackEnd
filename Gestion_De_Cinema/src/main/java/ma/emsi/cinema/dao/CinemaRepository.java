package ma.emsi.cinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import ma.emsi.cinema.entities.Cinema;

@RepositoryRestResource
@CrossOrigin("*")
public interface CinemaRepository extends JpaRepository<Cinema,Long> {

}
