package ma.emsi.cinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import ma.emsi.cinema.entities.Film;

@RepositoryRestResource
@CrossOrigin("*")
public interface FilmRepository extends JpaRepository<Film,Long> {

}
