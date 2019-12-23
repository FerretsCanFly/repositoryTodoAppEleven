//package eleven.opdracht;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.json.JacksonTester;
//import org.springframework.test.web.servlet.MockMvc;
//import static org.hamcrest.Matchers.containsString;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//import org.aspectj.lang.annotation.Before;
//
//import eleven.opdracht.Repo.TodoRepo;
//import eleven.opdracht.controller.TodoController;
//
//@DataJpaTest
//class TodoControllerTest {
//	
//	@Autowired
//    private MockMvc mockMvc;
//	
//	 @Mock
//	 private TodoRepo todoRepo;
//	 
//	    @InjectMocks
//	    private TodoController todoController;
//	    
//	    
//	@Test
//	public void testViewFirstPage() throws Exception {
//		this.mockMvc.perform(get("/view/todos"))
//		   .andExpect(status().isOk())
//		   .andExpect(content().string(containsString("Mijn eerste actiepunt")));
//	}
//
//	@Test
//	void testShowNewTodoForm() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSaveTodo() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testShowUpdateForm() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testDeleteUser() {
//		fail("Not yet implemented");
//	}
//
//}
