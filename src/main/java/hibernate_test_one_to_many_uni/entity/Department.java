package hibernate_test_one_to_many_uni.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String departmentName;

    @Column(name = "min_salary")
    private int minSalary;

    @Column(name = "max_salary")
    private int maxSalary;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.DETACH})
    @JoinColumn(name = "department_id")
    private List<Employee> employees;

    public Department(String departmentName, int minSalary, int maxSalary) {
        this.departmentName = departmentName;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public Department() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

//    не работает
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee){
        if (this.employees == null){
            this.employees = new ArrayList<>();
        }

        this.employees.add(employee);
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", minSalary=" + minSalary +
                ", maxSalary=" + maxSalary +
                '}';
    }
}
