package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    private String subject;
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Course> courses;
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Communication> communications;


}