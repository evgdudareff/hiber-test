package hibernate_test_one_to_one;

import hibernate_test_one_to_one.entity.Detail;
import hibernate_test_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();


        System.out.println(sessionFactory.isClosed());

        Session session = sessionFactory.getCurrentSession();

        try {

            Employee employee = new Employee("oleg", "petrov", "it", 500);
            Detail detail = new Detail("Moscow", "9999", "gmail");
            employee.setDetail(detail);

            session.beginTransaction();

            session.save(employee);

            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }




    }
}
