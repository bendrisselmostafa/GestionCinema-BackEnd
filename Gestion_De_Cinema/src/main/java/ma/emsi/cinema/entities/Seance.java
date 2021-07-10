package ma.emsi.cinema.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Seance implements Serializable {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
@Temporal(TemporalType.TIMESTAMP)
private Date heureDebut;
@OneToMany(mappedBy ="seance")
private Collection <Projection> seances;
}
