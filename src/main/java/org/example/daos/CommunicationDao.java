package org.example.daos;

import org.example.entities.Assignment;
import org.example.entities.Communication;
import org.example.entities.Course;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.annotation.processing.Messager;
import java.time.LocalDate;
import java.util.List;

public class CommunicationDao extends GenericDao<Communication, Long> {
    private final Session session;

    public CommunicationDao(Session session) {
        super(session, Communication.class);
        this.session = session;
    }

    public List<Communication> searchByStudent(Long studentId) {
        String query = "select c from Communication c where c.student.id = :id";
        Query<Communication> findQuery = session.createQuery(query, Communication.class);
        findQuery.setParameter("id", studentId);
        return findQuery.getResultList();
    }

    public List<Communication> searchByTeacher(Long teacherId) {
        String query = "select c from Communication c where c.teacher.id = :id";
        Query<Communication> findQuery = session.createQuery(query, Communication.class);
        findQuery.setParameter("id", teacherId);
        return findQuery.getResultList();
    }
    public List<Communication>searchByMessage(String message){
        String query ="select c from Communication c where c.message like :message";
        Query<Communication> findQuery = session.createQuery(query, Communication.class);
        findQuery.setParameter("message", "%"+message+"%");
        return findQuery.getResultList();
    }
    public List<Communication>searchByDate(LocalDate date){
        String query="select c from Communication c where c.sentDate=:date";
        Query<Communication>findQuery=session.createQuery(query, Communication.class);
        findQuery.setParameter("date",date);
        return findQuery.getResultList();
    }

}



