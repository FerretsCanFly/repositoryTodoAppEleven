package eleven.opdracht.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
/**
 * Todo Entiteitsklasse. Bevat alle eigenschappen van het Todo object. Actiepunt status is by default false, 
 * wat wordt weergegeven als tekst 'Onvoltooid' in overzicht.
 * @author Suzy
 *
 */
@Entity
public class Todo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@NotEmpty
	private String actiepunt;

	@JsonSerialize(using = ToStringSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate einddatum;

	private String gebruiker;

	private String prio;

	private boolean statusDone = false;

	private String statusDoneAsString;

	public Todo() {
		super();
	}

	//	//Dit zou ik graag anders organiseren zodat ik niet zoveel losse variabelen via de constructor mee geef. 
	//	public Todo(long id, String actiepunt, LocalDate einddatum, String gebruiker, boolean statusDone, String statusDoneAsString, String prio) {
	//		super();
	//		this.id = id;
	//		this.actiepunt = actiepunt;
	//		this.einddatum = einddatum;
	//		this.gebruiker = gebruiker;
	//	//	this.statusDone = statusDone;
	//	//	this.statusDoneAsString = statusDoneAsString; 
	//		this.prio = prio;
	//	}

	public Todo(long id, String actiepunt, LocalDate einddatum, String gebruiker, String prio) {
		super();
		this.id = id;
		this.actiepunt = actiepunt;
		this.einddatum = einddatum;
		this.gebruiker = gebruiker;
		this.prio = prio;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getActiepunt() {
		return actiepunt;
	}

	public void setActiepunt(String actiepunt) {
		this.actiepunt = actiepunt;
	}

	public LocalDate getEinddatum() {
		return einddatum;
	}

	public void setEinddatum(LocalDate einddatum) {
		this.einddatum = einddatum;
	}


	public String getGebruiker() {
		return gebruiker;
	}

	public void setGebruiker(String gebruiker) {
		this.gebruiker = gebruiker;
	}

	public boolean isStatusDone() {
		return statusDone;
	}

	public void setStatusDone(boolean statusDone) {

		this.statusDone = statusDone;
	}

	public String getPrio() {
		return prio;
	}

	public void setPrio(String prio) {
		this.prio = prio;
	}

	//Zet de tekst voor status op Voltooid of Onvoltooid afhankelijk van de boolean status. 
	//Boolean wordt op true gezet na drukken van de knop
	public String getStatusDoneAsString() {
		if (statusDone) {
			return "Voltooid";
		}
		else {
			return "Onvoltooid";
		}		
	}

	public void setStatusDoneAsString(String statusDoneAsString) {
		this.statusDoneAsString = statusDoneAsString;
	}		
}
