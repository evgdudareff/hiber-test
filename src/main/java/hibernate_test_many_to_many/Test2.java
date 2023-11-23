package hibernate_test_many_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test2 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Section.class)
                .addAnnotatedClass(Child.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Section section1 = new Section("Voley");
            Section section2 = new Section("Chess");
            Child child1 = new Child(11, "Igor");


            child1.addSection(section1);
            child1.addSection(section2);


            session.persist(child1);
            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
        }




    }
}
