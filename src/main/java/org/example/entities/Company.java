package org.example.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
@ToString
@SequenceGenerator(name = "base_id_gen", sequenceName = "companies_sq",allocationSize = 1)

public class Company extends BaseEntity{

    private String name;

    @OneToOne
    private Address address;
    @OneToMany(mappedBy = "company")
    private List<Projects> projects;

    public Company(String name) {
        this.name = name;
    }
}
