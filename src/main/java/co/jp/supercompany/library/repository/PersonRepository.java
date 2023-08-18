package co.jp.supercompany.library.repository;

import co.jp.supercompany.library.entity.Person;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends ListCrudRepository<Person, Integer> {
}
