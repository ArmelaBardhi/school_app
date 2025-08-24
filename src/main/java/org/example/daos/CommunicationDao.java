package org.example.daos;

import org.example.entities.Assignment;
import org.example.entities.Communication;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CommunicationDao {
    public class CommuncationDao extends GenericDao<Communication, Long> {
        private final Session session;


        public CommuncationDao(Session session) {
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
        //find by mesagge
        //find by data
    }
}
