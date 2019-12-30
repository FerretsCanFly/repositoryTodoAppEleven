package eleven.opdracht;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

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

	//Controleert of item met actiepunt test is aangemaakt. Database begint met 2 voorbeeld actiepunten. Na test zouden er 3 items moeten bestaan.
	@Test
	public void testSaveToRepo()  {
		Todo todo = new Todo();
		todo.setActiepunt("Actiepunt test"); 
		todo.setGebruiker("Pete"); 
		todoRepo.save(todo);

		Iterable<Todo> todos = todoRepo.findAll();
		int nOfTodos = 3; 
		assertThat(todos).hasSize(nOfTodos);
		assertThat(todo.getActiepunt()).isEqualTo("Actiepunt test");
		assertThat(todo.getGebruiker()).isEqualTo("Pete");
	}	  
	
	//Controleert of actiepunt succesvol is gewijzigd
		@Test
		public void testUpdateRepo()  {
			Iterable<Todo> todos = todoRepo.findAll();
			int nOfTodos = 2;
			long testUpdateId = 1;
			Todo todo = todoRepo.getOne(testUpdateId);
			System.out.println(todo.getActiepunt());
			//Sla de waarden voor actiepunt en gebruiker op in een variabele die we kunnen vergelijken met de nieuwe waarden
			String actiepuntOud = todo.getActiepunt();
			String gebruikerOud = todo.getGebruiker();
			long idOud = todo.getId();
			
			todo.setActiepunt("Actiepunt nieuw test"); 
			todo.setGebruiker("Gebruiker nieuw test"); 
			
			assertThat(todo.getActiepunt()).isNotEqualToIgnoringCase(actiepuntOud);
			assertThat(todo.getActiepunt()).isNotEqualToIgnoringCase(gebruikerOud);
			assertThat(todo.getId() == idOud);
			assertThat(todos).hasSize(nOfTodos);	
			todoRepo.save(todo);
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
