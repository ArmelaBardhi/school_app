package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.sql.ast.tree.update.Assignment;

import java.util.List;

@Entity
@Table(name = "courses")
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String className; // kolona 'class' në DB → 'className' këtu
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    @OneToMany(mappedBy = "course")
    private List<Student> students;
    @OneToMany(mappedBy = "course")
    private List<Assignment> assignments;

}

