package egzaminas.egzaminas;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ApplicationsRepository extends CrudRepository<Application, Long> {
	@Override
	List<Application> findAll();
	Application findById(long id);
}