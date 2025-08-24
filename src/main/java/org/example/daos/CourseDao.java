package org.example.daos;
import org.example.entities.Course;
import org.example.entities.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CourseDao extends GenericDao<Course, Long>{
    private final Session session;

    public CourseDao(Session session) {
        super(session, Course.class);
        this.session = session;
    }

//    // Shton një kurs të ri në databazë
//    public void save(Course course) {
//        session.beginTransaction();
//        session.persist(course); // ruan kursin
//        session.getTransaction().commit();
//    }
//
//    // Përditëson të dhënat e një kursi ekzistues
//    public void update(Course course) {
//        session.beginTransaction();
//        session.merge(course); // bashkon ndryshimet me kursin ekzistues
//        session.getTransaction().commit();
//    }
//
//    // Kthen të gjitha kurset që ekzistojnë në databazë
//    public List<Course> findAll() {
//        Query<Course> query = session.createQuery("FROM Course", Course.class);
//        return query.list();
//    }

    public List<Course> searchByLastName(String lastname) {
        String query = "select t from Course t where t.lastName = :lastname";
        Query<Course> findQuery = session.createQuery(query, Course.class);
        findQuery.setParameter("lastname", lastname);
        return findQuery.getResultList();
    }



    public List<Course> searchClass(String Class) {
        String query = "select t from Course t where t.tClass= :Class";
        Query<Course> findQuery = session.createQuery(query, Course.class);
        findQuery.setParameter("Class", Class);
        return findQuery.getResultList();


    }

    public List<Course> searchByTeacher(String Teacher) {
        String query = "select t from Course t where t.tTeacher= :Teacher";
        Query<Course> findQuery = session.createQuery(query, Course.class);
        findQuery.setParameter("Teacher", Teacher);
        return findQuery.getResultList();
    }
}



