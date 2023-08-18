package co.jp.supercompany.library.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class House {

    @Id
    Integer id;

    String address;
}
