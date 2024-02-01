package org.example.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@NoArgsConstructor
@ToString
@SequenceGenerator(name = "base_id_gen", sequenceName = "address_seq",allocationSize = 1)
public class Address extends BaseEntity {

    private String country;


    @OneToOne
    private Company company;
    @OneToOne(mappedBy = "address")
    private Programmers programmers;


    public Address(String country) {
        this.country = country;
    }
}
