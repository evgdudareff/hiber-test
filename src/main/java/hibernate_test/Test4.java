package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test4 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();



        try {
            Session session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            Employee myEmployee = session.get(Employee.class, 1);

            System.out.println(myEmployee);

            myEmployee.setSalary(1000);

            System.out.println(myEmployee);

            session.getTransaction().commit();


        } finally {
            sessionFactory.close();
        }




    }
}
