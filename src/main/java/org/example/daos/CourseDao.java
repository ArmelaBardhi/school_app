package org.example.daos;
import org.example.entities.Course;
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


    public List<Course> search(String name, String className, String teacherFirstName, String teacherLastName) {
        Query<Course> query = session.createQuery(
                "FROM Course WHERE name = :name OR className = :className OR (teacher.firstName = :teacherFirstName AND teacher.lastName = :teacherLastName)",
                Course.class
        );
        query.setParameter("name", name);
        query.setParameter("className", className);
        query.setParameter("teacherFirstName", teacherFirstName);
        query.setParameter("teacherLastName", teacherLastName);
        return query.list();
    }

}




