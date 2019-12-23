package eleven.opdracht.Service;

import java.util.List;
import java.util.Optional;

import eleven.opdracht.model.Todo;

public interface TodoService {
	public List<Todo> getAllTodos();
	public Todo save(Todo todo);
	public Optional<Todo> getById(Long id);
	public void delete(Todo todo);
}
