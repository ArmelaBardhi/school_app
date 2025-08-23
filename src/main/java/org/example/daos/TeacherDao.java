package org.example.daos;

import org.example.entities.Teacher;
import org.hibernate.Session;

public class TeacherDao extends GenericDao<Teacher,String > {
    private final Session session;

        public TeacherDao(Session session) {
            super(session, Teacher.class);
            this.session = session;

        }
    }

