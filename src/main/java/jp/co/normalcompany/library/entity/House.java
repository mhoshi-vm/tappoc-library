package jp.co.normalcompany.library.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class House {

    @Id
    Integer id;

    String address;

    String residency;

    public Integer getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getResidency() {
        return residency;
    }
}
