package co.jp.supercompany.library.service;

import co.jp.supercompany.library.entity.Person;
import co.jp.supercompany.library.repository.HouseRepository;
import co.jp.supercompany.library.repository.PersonRepository;
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
