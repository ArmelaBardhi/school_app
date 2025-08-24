package org.example.daos;

import org.example.entities.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class StudentDao extends GenericDao<Student, Long>{
    private final Session session;

    public StudentDao(Session session) {
        super(session, Student.class);
        this.session = session;
    }

    // Shton një student të ri në databazë
//    public void save(Student student) {
//        session.beginTransaction();
//        session.persist(student); // ruan studentin
//        session.getTransaction().commit();
//    }

    // Përditëso të dhënat e një studenti ekzistues
//    public void update(Student student) {
//        session.beginTransaction();
//        session.merge(student); // bashkon ndryshimet me studentin ekzistues
//        session.getTransaction().commit();
//    }

    public List<Student> searchByFirst(String firstname) {
        String query = "select t from Student t where t.name = :firstname";
        Query<Student> findQuery = session.createQuery(query, Student.class);
        findQuery.setParameter("firsttname", firstname);
        return findQuery.getResultList();
    }
    public List<Student> searchByLastName(String lastname) {
        String query = "select t from Student t where t.lastName = :lastname";
        Query<Student> findQuery = session.createQuery(query, Student.class);
        findQuery.setParameter("lastname", lastname);
        return findQuery.getResultList();
    }
    public List<Student>searchByDateOfBirth(LocalDate birthday){
        String query ="select t from Student t where t.birthday = :dateofbirth";
        Query<Student>findQuery=session.createQuery(query, Student.class);
        findQuery.setParameter("dateofbirth",birthday);
        return  findQuery.getResultList();
    }

    public List<Student> searchCourse(Long courseId) {
        String query = "select s from Student s where s.course.id = :courseId";
        Query<Student> findQuery = session.createQuery(query, Student.class);
        findQuery.setParameter("courseId", courseId);
        return findQuery.getResultList();
    }


}




