package jp.co.normalcompany.library.repository;

import jp.co.normalcompany.library.entity.House;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends ListCrudRepository<House, Integer> {
}
