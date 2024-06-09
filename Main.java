import java.util.*;
import java.util.stream.Collectors;

public class Main {
   static List<Employee> employees = new ArrayList<>();
   static {
       employees.add(new Employee("John", "Doe", "john.doe@example.com", 50000));
       employees.add(new Employee("Jane", "Smith", "jane.smith@example.com", 60000));
       employees.add(new Employee("Robert", "Johnson", "robert.johnson@example.com", 55000));
       employees.add(new Employee("Emily", "Davis", "emily.davis@example.com", 62000));
       employees.add(new Employee("Michael", "Brown", "michael.brown@example.com", 70000));
       employees.add(new Employee("Sarah", "Wilson", "sarah.wilson@example.com", 48000));
       employees.add(new Employee("David", "Lee", "david.lee@example.com", 51000));
       employees.add(new Employee("Laura", "Garcia", "laura.garcia@example.com", 53000));
       employees.add(new Employee("James", "Martinez", "james.martinez@example.com", 59000));
       employees.add(new Employee("Anna", "Hernandez", "anna.hernandez@example.com", 56000));
   }
    public static void main(String[] args) {
       // Stream Api
        System.out.println("<-------------------------------------------------------------------------->");
        employees.stream().forEach(System.out::println);
        System.out.println("<-------------------------------------------------------------------------->");
        employees.stream().filter(employee -> employee.getSalary()>55000).forEach(System.out::println);
        System.out.println("<-------------------------------------------------------------------------->");
        employees.stream().sorted((employee1,employee2)->Double.compare(employee1.getSalary(), employee2.getSalary())).forEach(System.out::println);
        System.out.println("<-------------------------------------------------------------------------->");
        employees.stream().sorted((employee1,employee2)->Double.compare(employee2.getSalary(), employee1.getSalary())).limit(1).forEach(System.out::println);
        System.out.println("<-------------------------------------------------------------------------->");
        Double avgSalary=employees.stream().mapToDouble(Employee::getSalary).average().orElse(0);
        System.out.println(avgSalary);
        System.out.println("<-------------------------------------------------------------------------->");

    }
}
