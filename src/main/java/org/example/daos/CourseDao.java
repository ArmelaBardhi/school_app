package org.example.daos;
import org.example.entities.Course;
import org.example.entities.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;


//kjo klase perdor hibernate Session per te bere query ne bazen e te dhenave


public class CourseDao extends GenericDao<Course, Long>{
    private final Session session;
//kur krijoj nje coursedao i jap nje session dhe ai lidhet direkt me entitein course
    public CourseDao(Session session) {
        super(session, Course.class);
        this.session = session;
    }

//    // Shton një kurs të ri në databazëur
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
//
     //kerkon kurse sipas emrit duke perdorur Like per kerkime te pjesshme
    public List<Course> searchByName(String name) {
        String query = "select t from Course t where t.name like :name";
        Query<Course> findQuery = session.createQuery(query, Course.class);
        findQuery.setParameter("name", "%"+name+"%");
        return findQuery.getResultList();
    }
//kerkon kurse sipas mesuesit nese jap ID e nje mesuesi do tme kthej te gjitha kurset qe jan rejistruar tek ai msues
    public List<Course> searchByTeacher(Long teacherID) {
        String query = "select c from Course c where c.teacher.id= :teacherID";
        Query<Course> findQuery = session.createQuery(query, Course.class);
        findQuery.setParameter("teacherID", teacherID);
        return findQuery.getResultList();
    }
}



