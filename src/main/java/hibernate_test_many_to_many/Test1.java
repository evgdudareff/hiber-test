package hibernate_test_many_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test1 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Section.class)
                .addAnnotatedClass(Child.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Section section1 = new Section("Football");
            Child child1 = new Child(15, "Petr");
            Child child2 = new Child(5, "Ivan");
            Child child3 = new Child(10, "Lev");

            section1.addChild(child1);
            section1.addChild(child2);
            section1.addChild(child3);

            session.persist(section1);
            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
        }




    }
}
