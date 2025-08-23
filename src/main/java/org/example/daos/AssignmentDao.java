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

    public List<Assignment> searchByStudent(String ) {
        String query = "select t from Teacher t where t.name = :firstname";
        Query<Teacher> findQuery = session.createQuery(query, Teacher.class);
        findQuery.setParameter("firstname", name);
        return findQuery.getResultList();

}
