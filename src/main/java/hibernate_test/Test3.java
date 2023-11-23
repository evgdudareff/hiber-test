package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();



        try {
            Session session = sessionFactory.getCurrentSession();

            session.beginTransaction();

//            List<Employee> employees = session.createQuery("from Employee").getResultList();
//
            List<Employee> employees = session.createQuery("from Employee where name='petr'").getResultList();

            for (Employee employee : employees){
                System.out.println(employee);
            }



            session.getTransaction().commit();


        } finally {
            sessionFactory.close();
        }




    }
}
