package org.example;

import org.example.config.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
    }
}


//“Ky projekt menaxhon studentë, mësues, kurse dhe komunikime duke përdorur DAO
// dhe Services për të organizuar dhe përpunuar të dhënat në mënyrë të strukturuar.”