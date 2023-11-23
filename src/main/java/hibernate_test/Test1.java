package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();


        System.out.println(sessionFactory.isClosed());

        Session session = sessionFactory.getCurrentSession();

        try {

            Employee employee = new Employee("test", "test", "it", 500);

            session.beginTransaction();
            session.persist(employee);
            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }




    }
}
