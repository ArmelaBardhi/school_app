package org.example.daos;

import org.example.entities.Course;
import org.example.entities.Teacher;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TeacherDao extends GenericDao<Teacher,Long > {
    private final Session session;

    public TeacherDao(Session session) {
        super(session, Teacher.class);
        this.session = session;

    }

    public List<Teacher> searchByName(String name) {
        String query = "select t from Teacher t where t.name = :firstname";
        Query<Teacher> findQuery = session.createQuery(query, Teacher.class);
        findQuery.setParameter("firstname", name);
        return findQuery.getResultList();
    }

    public List<Teacher> searchByLastName(String lastname) {
        String query = "select t from Teacher t where t.lastName = :lastname";
        Query<Teacher> findQuery = session.createQuery(query, Teacher.class);
        findQuery.setParameter("lastname", lastname);
        return findQuery.getResultList();
    }
    public List<Teacher> searchBySubject(String subject) {
        String query = "select t from Teacher t where t.subject = :subject";
        Query<Teacher> findQuery = session.createQuery(query, Teacher.class);
        findQuery.setParameter("subject", subject);
        return findQuery.getResultList();
    }

    public List<Course> findByTeacher(Long teacherId) {
        // "FROM Course c WHERE c.teacher.id = :teacherId"
        Teacher teacher = this.findBYId(teacherId);
        if (teacher != null) {
            return teacher.getCourses();
        } else {
            return null;
        }
    }
}