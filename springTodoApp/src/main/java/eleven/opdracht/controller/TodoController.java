package eleven.opdracht.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import eleven.opdracht.Service.TodoServiceImpl;
import eleven.opdracht.model.Todo;
/**
 * Via verschillende knoppen in het hoofdmenu kan de gebruiker het actiepunt wijzigen, verwijderen, de status veranderen, of een nieuw actiepunt maken.
 * Prioriteit is aan te passen via de 'Edit' knop van het actiepunt.
 * @author Suzy
 */
@Controller
public class TodoController {

	private TodoServiceImpl todoServiceImpl;

	@Autowired
	public TodoController(TodoServiceImpl todoServiceImpl) {
		this.todoServiceImpl = todoServiceImpl;
	}

	//Haalt een lijst op van alle actiepunten en geeft het weer in het hoofdmenu
	@GetMapping(path ="todos")
	public String viewFirstPage(Model model) {
		List<Todo> listTodos = todoServiceImpl.getAllTodos();
		model.addAttribute("listTodos", listTodos);
		return "todos";		 
	}

	//Door te klikken op 'Nieuw actiepunt maken' komt gebruiker in het scherm om een nieuw actiepunt te maken
	@RequestMapping("new")
	public String showNewTodoForm(Model model) {
		Todo todo = new Todo();
		model.addAttribute("todo", todo);
		return "addTodo"; 
	}

	//Opslaan van wijziging of nieuw actiepunt en navigeert terug naar het hoofdmenu 
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String saveTodo(@ModelAttribute("todo") Todo todo) {
		todoServiceImpl.save(todo);	
		return "redirect:/todos";
	}	

	//Actiepunt bewerken en opslaan
	@RequestMapping(value = "update/{id}", method = RequestMethod.POST)
	public String updateTodo(@PathVariable("id") long id, Model model, @Valid Todo todo) {	
		todoServiceImpl.update(todo);
		model.addAttribute("todos", todoServiceImpl.getAllTodos());
		return "redirect:/todos";
	}	

	//Door te klikken op 'Edit' komt gebruiker in het scherm om een actiepunt te wijzigen. Wijzigen van het Id zorg dat het actiepunt met dat Id wordt gewijzigd.
	//Todo: Id van actiepunt doorgeven zonder dat gebruiker het kan aanpassen, zodat alleen het actiepunt waarvoor op 'Edit' is geklikt gewijzigd wordt. 
	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Todo todo = todoServiceImpl.getById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));	
		model.addAttribute("todo", todo);
		return "editTodo";
	}

	//Verwijder het actiepunt waar de 'Delete' knop voor is ingedrukt
	@GetMapping("delete/{id}")
	public String deleteTodo(@PathVariable("id") long id, Model model) {
		Todo todo = todoServiceImpl.getById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		todoServiceImpl.delete(todo);
		model.addAttribute("todos", todoServiceImpl.getAllTodos());
		return "redirect:/todos";
	}

	//Wijzigt het status overzicht van 'Onvoltooid' naar 'Voltooid'. Status kan alleen via deze knop worden aangepast
	@GetMapping("wijzigStatus/{id}")
	public String wijzigTodo(@PathVariable("id") long id, Model model) {
		Todo todo = todoServiceImpl.getById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		todo.setStatusDone(true); //Wanneer getStatusDoneAsString wordt geroepen geeft het de tekst Voltooid terug indien true, anders de tekst Onvoltooid
		todoServiceImpl.update(todo);
		model.addAttribute("todos", todoServiceImpl.getAllTodos());
		return "redirect:/todos";
	}

	//Applicatie afsluiten
	@GetMapping(path ="/shutdown-app")
	public void exitProgram(Model model) {
		int exitCode = 0;
		System.exit(exitCode); 
	}

}
