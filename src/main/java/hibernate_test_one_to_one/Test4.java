package hibernate_test_one_to_one;

import hibernate_test_one_to_one.entity.Detail;
import hibernate_test_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test4 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();


        System.out.println(sessionFactory.isClosed());

        Session session = sessionFactory.getCurrentSession();

        try {


            session.beginTransaction();
            Employee employee = session.get(Employee.class, 2);

            session.delete(employee);

            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }




    }
}
