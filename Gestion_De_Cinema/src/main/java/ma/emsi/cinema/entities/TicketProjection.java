package ma.emsi.cinema.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="ticketsProj", types=Ticket.class)
public interface TicketProjection {
	public Long getId();
	public String getNomClient();
	public boolean getReserve();
	public double getPrix();
	public Integer getCodePayement();
	public Place getPlace();

}
