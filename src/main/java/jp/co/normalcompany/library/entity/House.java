package jp.co.normalcompany.library.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class House {

    @Id
    Integer id;

    String address;

    public Integer getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }
}
