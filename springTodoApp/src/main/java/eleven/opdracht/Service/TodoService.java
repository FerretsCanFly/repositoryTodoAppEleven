package eleven.opdracht.Service;

import java.util.List;
import java.util.Optional;

import eleven.opdracht.model.Todo;

public interface TodoService {
	
	public Optional<Todo> getById(Long id);
	public List<Todo> getAllTodos();	
	public Todo save(Todo todo);
	public Todo update(Todo todo);
	public void delete(Todo todo);
}
