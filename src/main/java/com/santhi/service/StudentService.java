package com.santhi.service;

import com.santhi.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.archive.scan.spi.Scanner;
import org.hibernate.cfg.Configuration;


public class StudentService {
    public static void createTable(){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        transaction.commit();
        System.out.println("Sucessfully create Student Table");
        sessionFactory.close();
        session.close();
    }
    public static void addStudent(){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        //Created object to add student in table
        Student student = new Student();
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setEmail("john.doe@gmail.com");
        student.setMajor("Computer Science");

        Student student1 = new Student();
        student1.setFirstName("Jane");
        student1.setLastName("Doe");
        student1.setEmail("jane.doe@gmail.com");
        student1.setMajor("Finacne");

        Student student2 = new Student();
        student2.setFirstName("Kar");
        student2.setLastName("Doe");
        student2.setEmail("kar.doe@gmail.com");
        student2.setMajor("Computer Science");

        Student student3=new Student("Divya","Guru","guru.88@gmail.com","Commerce");
        Student student4=new Student("Div","Varu","varu.88@gmail.com","Java");

        session.persist(student);
        session.persist(student1);
        session.persist(student2);
        session.persist(student3);
        session.persist(student4);

        transaction.commit();
        System.out.println("Sucessfully added Student");
        sessionFactory.close();
        session.close();
    }
    public static void findStudent(){
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session session=sf.openSession();
        Transaction transaction=session.beginTransaction();

        int student_id=2;
        Student student=session.get(Student.class,student_id);
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        System.out.println(student.getEmail());
        System.out.println(student.getMajor());
        transaction.commit();
        session.close();


    }
    public static void updateStudent(){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Student student = new Student();
        student.setId(1);
        student.setFirstName("Karthik");
        student.setLastName("Va");
        student.setEmail("karthik.va@gmail.com");
        student.setMajor("Computer Science");
        session.merge(student);
       // session.merge(student);
        session.getTransaction().commit();
        System.out.println("Sucessfully updated Student");
        sessionFactory.close();
        session.close();
    }
    public static void deleteStudent(){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Student student = new Student();
        student.setId(2);
        session.delete(student);
        session.getTransaction().commit();
        sessionFactory.close();
        session.close();
    }
}
