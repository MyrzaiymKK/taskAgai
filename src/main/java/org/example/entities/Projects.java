package org.example.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "projects")
@Getter
@Setter
@NoArgsConstructor
@ToString
@SequenceGenerator(name = "base_id_gen", sequenceName = "address_sq",allocationSize = 1)
public class Projects extends BaseEntity {
    private String tittle;
    @ManyToOne
    private Company company;
    @ManyToMany
    private List<Programmers> programmers;
}
