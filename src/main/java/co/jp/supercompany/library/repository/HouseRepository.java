package co.jp.supercompany.library.repository;

import co.jp.supercompany.library.entity.House;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends ListCrudRepository<House, Integer> {
}
