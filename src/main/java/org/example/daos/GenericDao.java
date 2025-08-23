package org.example.daos;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Queue;

public abstract class GenericDao<E,ID> {
    private final Session session;
    private final Class<E> clazz;
    private Transaction transaction;

    public GenericDao(Session session, Class<E> clazz) {
        this.session = session;
        this.clazz = clazz;
    }
    public E save(E entity){
        try {
            this.transaction= session.beginTransaction();
            E savedEntity= session.merge(entity);
            transaction.commit();
            return savedEntity;
        }catch (Exception e){
            transaction.rollback();
            throw new RuntimeException(e);
        }
    }

    public E findBYId(ID id){
        return session.find(clazz, id);
    }
    public void delete(ID id){
        try {
            this.transaction=session.beginTransaction();
            E entity=this.findBYId(id);
            session.remove(entity);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            throw new RuntimeException();
        }
    }
    public List<E> findAll(){

        String query= "select record from ".concat(clazz.getSimpleName()).concat(" record");
        Query<E> findAllQuery= session.createQuery(query,clazz);
        return findAllQuery.getResultList();

    }
}







