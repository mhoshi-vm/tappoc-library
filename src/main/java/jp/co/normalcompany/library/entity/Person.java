package jp.co.normalcompany.library.entity;

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

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public House getHouse() {
        return house;
    }
}
