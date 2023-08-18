package co.jp.supercompany.library.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Person {

    @Id
    Integer id;

    String firstName;

    String LastName;

    @ManyToOne
    House house;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", houseId='" + house.id + '\'' +
                ", address='" + house.address + '\'' +
                '}';
    }
}
