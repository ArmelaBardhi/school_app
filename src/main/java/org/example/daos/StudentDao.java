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

    // Përditëso të dhënat e një studenti ekzistues
    public void update(Student student) {
        session.beginTransaction();
        session.merge(student); // bashkon ndryshimet me studentin ekzistues
        session.getTransaction().commit();
    }

    public List<Student> searchByFirst(String firstname) {
        String query = "select t from Student t where t.firstName = :firstname";
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
    public List<Student>searchByDateOfBirth(String dateofbirth){
        String query ="select t from Student t where t.dateofbirth=:dateofbirth";
        Query<Student>findQuery=session.createQuery(query, Student.class);
        findQuery.setParameter("dateofbirth",dateofbirth);
        return  findQuery.getResultList();
    }
    public List<Student> searchClass(String Class) {
        String query = "select t from Student t where t.class = :class";
        Query<Student> findQuery = session.createQuery(query, Student.class);
        findQuery.setParameter("class", Class);
        return findQuery.getResultList();
    }
    public List<Student> searchCourse(String course) {
        String query = "select t from Student t where t.course = :course";
        Query<Student> findQuery = session.createQuery(query, Student.class);
        findQuery.setParameter("course", course);
        return findQuery.getResultList();
    }


}




