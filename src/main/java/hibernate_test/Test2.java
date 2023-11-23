package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();


        System.out.println(sessionFactory.isClosed());



        try {
            Session session = sessionFactory.getCurrentSession();
            Employee employee = new Employee("petr", "ivanov", "HR", 500);

            session.beginTransaction();
            session.persist(employee);
            session.getTransaction().commit();

            Session newSession = sessionFactory.getCurrentSession();
            newSession.beginTransaction();
            Employee myEmployee = newSession.get(Employee.class, employee.getId());
            System.out.println(myEmployee);
            newSession.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }




    }
}
