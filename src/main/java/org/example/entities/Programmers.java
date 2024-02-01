package org.example.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "programmers")
@Getter
@Setter
@NoArgsConstructor
@ToString
@SequenceGenerator(name = "base_id_gen", sequenceName = "programmers_sq",allocationSize = 1)
public class Programmers extends BaseEntity{
    private String fullName;
    private String email;
    @ManyToMany(mappedBy = "programmers")
    private List<Projects> projects;
    @OneToOne
    private Address address;
}
