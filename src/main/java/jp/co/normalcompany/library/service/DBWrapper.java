package jp.co.normalcompany.library.service;

import jp.co.normalcompany.library.entity.Person;
import jp.co.normalcompany.library.repository.HouseRepository;
import jp.co.normalcompany.library.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBWrapper {

    PersonRepository personRepository;

    HouseRepository houseRepository;

    public DBWrapper(PersonRepository personRepository, HouseRepository houseRepository) {
        this.personRepository = personRepository;
        this.houseRepository = houseRepository;
    }
    public List<Person> listPerson(){
        return personRepository.findAll();
    }

}
