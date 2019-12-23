package eleven.opdracht;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import javax.activation.DataSource;
import javax.persistence.EntityManager;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

import eleven.opdracht.Repo.TodoRepo;
import eleven.opdracht.model.Todo;

@DataJpaTest
class TodoRepoTest {

	@Autowired
	TodoRepo todoRepo;

	//Via data.sql worden er 2 voorbeeld todo items aangemaakt. Test controleert of beide items worden gevonden
	@Test
	public void findAllTodos() {
		Iterable<Todo> todos = todoRepo.findAll();
		int nOfTodos = 2;
		assertThat(todos).hasSize(nOfTodos);
	}

	//Controleert of item met actiepunt test is aangemaakt
	@Test
	public void testSaveToRepo()  {
		Todo todo = new Todo();
		todo.setActiepunt("test"); 
		todo.setGebruiker("Piet"); 
		todoRepo.save(todo);
		assertThat(todo.getId()).isNotNull();
		assertThat(todo.getActiepunt()).isEqualTo("test");
		assertThat(todo.getGebruiker()).isEqualTo("Piet");
	}	  
	
	//Bij aanmaken van Todo is de boolean statusDone false en moet de tekst Onvoltooid achter het actiepunt staan. 
	//Wanneer statusDone op true wordt gezet moet de tekst achter het actiepunt in Voltooid veranderen
	@Test
	public void testStatustekst()  {
		Todo todo = new Todo();
		assertThat(todo.getStatusDoneAsString()).isEqualTo("Onvoltooid");
		todo.setStatusDone(true);
		assertThat(todo.getStatusDoneAsString()).isEqualTo("Voltooid");
	}	  
	
}
