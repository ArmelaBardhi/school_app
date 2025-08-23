package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "students")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "year_of_birth")
    private String birthday;
    @OneToMany
    @JoinColumn(name = "course_id")
    private Course course;
    @OneToMany(mappedBy = "student")
private List<Communication>communications;



    }

