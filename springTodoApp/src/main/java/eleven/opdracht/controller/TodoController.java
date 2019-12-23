package eleven.opdracht.controller;

import java.util.ArrayList;
import java.util.List;

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

@Controller
public class TodoController {
	@Autowired
	private TodoServiceImpl todoServiceImpl;
	
	 @GetMapping(path ="/view/todos")
	 public String viewFirstPage(Model model) {
		 List<Todo> listTodos = todoServiceImpl.getAllTodos();
		 model.addAttribute("listTodos", listTodos);
		 return "/view/todos";		 
	 }
	
    @RequestMapping("/new")
    public String showNewTodoForm(Model model) {
      Todo todo = new Todo();
      model.addAttribute("todo", todo);
        return "view/addTodo"; 
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveTodo(@ModelAttribute("todo") Todo todo) {
    	todoServiceImpl.save(todo);	
    	return "redirect:/view/todos";
    }
   
    	@GetMapping("/edit/{id}")
    	public String showUpdateForm(@PathVariable("id") long id, Model model) {
    	    Todo todo = todoServiceImpl.getById(id)
    	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));	     
    	    model.addAttribute("todo", todo);
    	    return "view/editTodo";
    	}
    	
    	@GetMapping("/delete/{id}")
    	public String deleteUser(@PathVariable("id") long id, Model model) {
    	    Todo todo = todoServiceImpl.getById(id)
    	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
    	    todoServiceImpl.delete(todo);
    	    model.addAttribute("todos", todoServiceImpl.getAllTodos());
    	    return "redirect:/view/todos";
    	}
    	
//    	@ModelAttribute("/chooseableStatus")
//    	public List<Todo> populateDepartments(Model model) 
//    	{
//    		 List<Todo> listTodos = 
//    				 
//    				 todoServiceImpl.getStatus();
//    		 model.addAttribute("listTodos", listTodos);
//    	    return listTodos;
//    	}
}
