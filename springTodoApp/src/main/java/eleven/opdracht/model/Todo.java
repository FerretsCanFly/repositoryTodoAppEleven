package eleven.opdracht.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Todo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty
	private String actiepunt;

    @JsonFormat(pattern = "dd-mm-yyyy")
	private Date einddatum;
    
    private List<String> status = new ArrayList<>();
	
	public Todo() {
		super();
	}
	
	public Todo(long id, String actiepunt, Date einddatum, List<String> status) {
		super();
		this.id = id;
		this.actiepunt = actiepunt;
		this.einddatum = einddatum;
		this.status = status;
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

	public Date getEinddatum() {
		return einddatum;
	}

	public void setEinddatum(Date einddatum) {
		this.einddatum = einddatum;
	}

	public List<String> getStatus() {
		return status;
	}

	public void setStatus(List<String> status) {
		this.status = status;
	}
	
	
}
