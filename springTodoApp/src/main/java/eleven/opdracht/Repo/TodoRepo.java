package eleven.opdracht.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eleven.opdracht.model.Todo;

@Repository
public interface TodoRepo extends JpaRepository<Todo, Long>{

}
