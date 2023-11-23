package hibernate_test_one_to_one;

import hibernate_test_one_to_one.entity.Detail;
import hibernate_test_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test6 {
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
            Employee employee = new Employee("dmitry", "ivanov", "it", 500);
            Detail detail = new Detail("London", "9999", "gmail");

            employee.setDetail(detail);
            detail.setEmployee(employee);
            session.save(detail);

            session.getTransaction().commit();

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Employee createdEmp = session.get(Employee.class, employee.getId());
            System.out.println(createdEmp.getDetail());
            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }




    }
}
