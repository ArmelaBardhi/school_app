package org.example.daos;

import org.example.entities.Assignment;
import org.example.entities.Teacher;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AssignmentDao extends GenericDao<Assignment, Long>{
        private final Session session;

        public AssignmentDao(Session session) {
            super(session, Assignment.class);
            this.session = session;
        }

    public List<Assignment> searchByCourse(Long courseId) {
        String query = "select a from Assignment a where a.course.id = :id";
        Query<Assignment> findQuery = session.createQuery(query, Assignment.class);
        findQuery.setParameter("id", courseId);
        return findQuery.getResultList();
    }

}
