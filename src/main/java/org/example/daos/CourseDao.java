package org.example.daos;
import org.example.entities.Course;
import org.example.entities.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CourseDao {
    private final Session session;

    public CourseDao(Session session) {
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

    public List<Course> searchByName(String name) {
        String query = "select t from Course t where t.name = :name";
        Query<Course> findQuery = session.createQuery(query, Course.class);
        findQuery.setParameter("name", name);
        return findQuery.getResultList();
    }

    public List<Course> searchByTeacher(Long teacherID) {
        String query = "select c from Course c where c.teacher.id= :teacherID";
        Query<Course> findQuery = session.createQuery(query, Course.class);
        findQuery.setParameter("teacherID", teacherID);
        return findQuery.getResultList();
    }
}



