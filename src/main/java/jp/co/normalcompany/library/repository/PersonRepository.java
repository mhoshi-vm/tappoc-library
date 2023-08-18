package jp.co.normalcompany.library.repository;

import jp.co.normalcompany.library.entity.Person;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends ListCrudRepository<Person, Integer> {
}
