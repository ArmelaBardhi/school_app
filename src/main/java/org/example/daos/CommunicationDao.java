package org.example.daos;

import org.example.entities.Communication;
import org.hibernate.Session;

public class CommunicationDao {
    public class CommuncationDao extends GenericDao<Communication, Long> {
        private final Session session;


        public CommuncationDao(Session session) {
            super(session, Communication.class);
            this.session = session;
        }
    }
}
