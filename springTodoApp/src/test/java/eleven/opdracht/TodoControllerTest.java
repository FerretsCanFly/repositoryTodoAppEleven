//package eleven.opdracht;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import eleven.opdracht.Repo.TodoRepo;
//import eleven.opdracht.Service.TodoService;
//import eleven.opdracht.controller.TodoController;
//import eleven.opdracht.model.Todo;
//
//@DataJpaTest
//class TodoControllerTest {
//	
//	 @Autowired
//	    private MockMvc mockMvc;
//	 
//		@Autowired
//		TodoRepo todoRepo;
//	 
//	    @MockBean
//	    private TodoService service;
//	 
//	    
//	    @MockBean
//	    Todo todo;
//
//	@Test
//	void testViewFirstPage() throws Exception {
//		this.mockMvc.perform(get("/todos"))
//	      .andExpect(status().isOk());
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
//	void testUpdateTodo() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testShowUpdateForm() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testDeleteTodo() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testWijzigTodo() {
//		fail("Not yet implemented");
//	}
//
//}
