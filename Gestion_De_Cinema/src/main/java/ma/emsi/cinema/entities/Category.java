package ma.emsi.cinema.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Category implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
	@Column(length = 75)
private String name;
@OneToMany(mappedBy = "categorie")
private Collection<Film> films;
}
