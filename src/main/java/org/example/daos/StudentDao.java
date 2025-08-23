package org.example.daos;

import org.example.entities.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDao {
    private final Session session;

    public StudentDao(Session session) {
        this.session = session;
    }

    // Shton një student të ri në databazë
    public void save(Student student) {
        session.beginTransaction();
        session.persist(student); // ruan studentin
        session.getTransaction().commit();
    }

    // Përditëson të dhënat e një studenti ekzistues
    public void update(Student student) {
        session.beginTransaction();
        session.merge(student); // bashkon ndryshimet me studentin ekzistues
        session.getTransaction().commit();
    }

    // Kthen listën e studentëve që i përkasin një kursi specifik
    public List<Student> findByCourse(Long courseId) {
        Query<Student> query = session.createQuery(
                "FROM Student WHERE course.id = :courseId", Student.class);
        query.setParameter("courseId", courseId);
        return query.list();
    }

    // Kërkon studentë sipas emrit, mbiemrit ose klasës
    public List<Student> search(String firstName, String lastName, String className) {
        Query<Student> query = session.createQuery(
                "FROM Student WHERE firstName = :firstName OR lastName = :lastName OR className = :className",
                Student.class);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        query.setParameter("className", className);
        return query.list();
    }
}




