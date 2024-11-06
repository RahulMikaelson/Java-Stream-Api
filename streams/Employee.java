package streams;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;
    private int age;

    public Employee() {
    }

    public Employee(int id, String name, String department, double salary, int age) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public int getAge() { return age; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDepartment(String department) { this.department = department; }
    public void setSalary(double salary) { this.salary = salary; }
    public void setAge(int age) { this.age = age; }

    @Override
    public String toString() {
        return "streams.Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    public static List<Employee> getEmployeeList() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Alice", "HR", 55000, 28));
        employees.add(new Employee(2, "Bob", "Finance", 70000, 32));
        employees.add(new Employee(3, "Charlie", "IT", 80000, 40));
        employees.add(new Employee(4, "David", "Marketing", 65000, 35));
        employees.add(new Employee(5, "Eve", "IT", 75000, 45));
        employees.add(new Employee(6, "Frank", "Finance", 60000, 30));
        employees.add(new Employee(7, "Grace", "HR", 50000, 25));
        employees.add(new Employee(8, "Heidi", "IT", 90000, 50));
        employees.add(new Employee(9, "Ivan", "Marketing", 62000, 33));
        employees.add(new Employee(10, "Judy", "Finance", 72000, 38));
        // Add more employees if needed for practice
        return employees;
    }
}
