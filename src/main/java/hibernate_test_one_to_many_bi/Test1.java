package hibernate_test_one_to_many_bi;


import hibernate_test_one_to_many_bi.entity.Department;
import hibernate_test_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            Department department = new Department("VR", 100, 500);
            Employee employee1 = new Employee("petr", "ivanov", 300);
            Employee employee2 = new Employee("lena", "sidorova", 250);

            department.addEmployee(employee1);
            department.addEmployee(employee2);

            session.beginTransaction();
            session.persist(department);
            session.getTransaction().commit();


//            session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//            Department department1 = session.get(Department.class, department.getId());
//            for (Employee employee: department1.getEmployees()){
//                System.out.println(employee);
//            }
//            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }




    }
}
