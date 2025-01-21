package com.santhi.repository;

import com.santhi.model.Student;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HQLQueries {

    public static void getStudents() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        //  String hql = "FROM Student";
        //  String hql = "FROM Student s WHERE s.id = 2";
        String hql = "FROM Student S WHERE S.id > 3 ORDER BY S.major DESC";
        TypedQuery query = session.createQuery(hql);
        List<Student> results = query.getResultList();
        for (Student s : results) {
            System.out.println("Student Id: " + s.getId() + "|" + " First Name: " + s.getFirstName() + "|" + "Last Name: " + s.getLastName() + "Email: " + s.getEmail() + "|" + "Major: " + s.getMajor());

        }
    }
}
