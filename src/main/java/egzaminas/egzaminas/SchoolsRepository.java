package egzaminas.egzaminas;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SchoolsRepository extends CrudRepository<School, Long> {
	@Override
	List<School> findAll();
	School findById(long id);
	@Query(value = "SELECT * FROM schools WHERE schools.name like %?1%", nativeQuery = true)
	List<School> findByName(String name);
}