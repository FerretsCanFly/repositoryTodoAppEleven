package eleven.opdracht.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eleven.opdracht.Repo.TodoRepo;
import eleven.opdracht.model.Todo;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TodoServiceImpl implements TodoService{
	private TodoRepo todoRepo;

	@Autowired
	public TodoServiceImpl(TodoRepo todoRepo) {
		this.todoRepo = todoRepo;
	}

	@Override
	public Optional<Todo> getById(Long id) {
		return todoRepo.findById(id);		
	}

	@Override
	public List<Todo> getAllTodos() {
		return (List<Todo>) todoRepo.findAll();
	}

	@Override
	public Todo save(final Todo todo) {
		return todoRepo.save(todo);		
	}

	@Override
	public Todo update(Todo todo) {
		return todoRepo.saveAndFlush(todo);
	}

	@Override
	public void delete(Todo todo) {
		todoRepo.delete(todo);	
	}

	public TodoRepo getTodoRepo() {
		return todoRepo;
	}

	public void setTodoRepo(TodoRepo todoRepo) {
		this.todoRepo = todoRepo;
	}
}
