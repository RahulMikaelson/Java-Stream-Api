package streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("<----------------------------------------------------------------------------->");
        // 1. Find all employees in the "IT" department.
        System.out.println("1. Print Employees in IT department");
        Employee.getEmployeeList().stream().filter(employee -> employee.getDepartment().equals("IT")).forEach(System.out::println);
        System.out.println("<----------------------------------------------------------------------------->");
        // 2. Retrieve a list of employees whose age is over 30.
        System.out.println("2. Print Employees age greater than 30");
        Employee.getEmployeeList().stream().filter(employee -> employee.getAge() > 30).forEach(System.out::println);
        System.out.println("<----------------------------------------------------------------------------->");
        // 3. Get the names of all employees in uppercase.
        System.out.println("3. Print Employees name in uppercase");
        Employee.getEmployeeList().stream().map(employee -> employee.getName().toUpperCase()).forEach(System.out::println);
        System.out.println("<----------------------------------------------------------------------------->");
        // 4. Find the total number of employees.
        System.out.println("4. Print total number of employees");
        System.out.println(Employee.getEmployeeList().stream().count());
        System.out.println("<----------------------------------------------------------------------------->");
        // 5. Count employees in each department.
        System.out.println("5. Print total number of employees in each Department");
        Map<String, Long> collect = Employee.getEmployeeList().stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        collect.forEach((department, strength) -> System.out.println(department + " : " + strength));
        System.out.println("<----------------------------------------------------------------------------->");
        // 6. Get the average salary of employees in the "Finance" department.
        System.out.println("6. Print Avg salary of Employees in Finance department");
        Double avgSalary =
                Employee.getEmployeeList().stream().filter(employee -> employee.getDepartment().equals("Finance")).collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println("Avg Salary: " + avgSalary);
        System.out.println("<----------------------------------------------------------------------------->");
        // 7. Find the maximum salary among all employees.
        Optional<Employee> max = Employee.getEmployeeList().stream().max(Comparator.comparingDouble(Employee::getSalary));
        max.ifPresent(employee -> System.out.println("Max Salary: " + employee.getSalary()));
        System.out.println("<----------------------------------------------------------------------------->");
        // 8. Get the minimum age of employees in the "HR" department.
        Optional<Employee> hr = Employee.getEmployeeList().stream().filter(employee -> employee.getDepartment().equals("HR")).min(Comparator.comparingDouble(Employee::getAge));
        hr.ifPresent(employee -> System.out.println("Min Salary: " + employee.getAge()));
        System.out.println("<----------------------------------------------------------------------------->");
        // 9. List all unique departments.
        Employee.getEmployeeList().stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
        System.out.println("<----------------------------------------------------------------------------->");
        // 10. Check if any employee has a salary above 90,000.
        Employee.getEmployeeList().stream().filter(employee -> employee.getSalary()>90000).forEach(System.out::println);
        System.out.println("<----------------------------------------------------------------------------->");
        // 11. Verify if all employees are older than 20.
        boolean b = Employee.getEmployeeList().stream().allMatch(employee -> employee.getAge() > 20);
        if(b){
            System.out.println("All Employees are above 20");
        }else{
            System.out.println("Not All Employees are above 20");

        }
        System.out.println("<----------------------------------------------------------------------------->");
        // 12. Check if there is any employee named "Alice."
        boolean name = Employee.getEmployeeList().stream().anyMatch(employee -> employee.getName().equals("Alice"));
        if(name){
            System.out.println("All Employees are above 20");
        }else{
            System.out.println("Not All Employees are above 20");

        }
        System.out.println("<----------------------------------------------------------------------------->");
        // 13. Find the first employee whose salary is greater than 60,000.
        Employee.getEmployeeList().stream().filter(employee -> employee.getSalary() > 60000).findFirst().ifPresent(System.out::println);
        System.out.println("<----------------------------------------------------------------------------->");
        // 14. Sort employees by their age.
        Employee.getEmployeeList().stream().sorted(Comparator.comparingInt(Employee::getAge)).forEach(System.out::println);
        System.out.println("<----------------------------------------------------------------------------->");
        // 15. Sort employees by salary in descending order.
        Employee.getEmployeeList().stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).forEach(System.out::println);
        System.out.println("<----------------------------------------------------------------------------->");
        // 16. Retrieve only the first 3 employees from the sorted list by age.
        Employee.getEmployeeList().stream().sorted(Comparator.comparingInt(Employee::getAge)).limit(3).forEach(System.out::println);
        System.out.println("<----------------------------------------------------------------------------->");
        // 17. Skip the first 2 employees and get the rest.
        Employee.getEmployeeList().stream().skip(2).forEach(System.out::println);
        System.out.println("<----------------------------------------------------------------------------->");
        // 18. Concatenate the names of all employees, separated by commas.
        String names = Employee.getEmployeeList().stream().map(Employee::getName).collect(Collectors.joining(", "));
        System.out.println("<----------------------------------------------------------------------------->");
        // 19. Calculate the sum of salaries of employees in "Marketing."
        DoubleSummaryStatistics marketing = Employee.getEmployeeList().stream().filter(employee -> employee.getDepartment().equals("Marketing")).collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(marketing.getSum());
        System.out.println("<----------------------------------------------------------------------------->");
        // 20. Find any employee in the "HR" department.
        Employee.getEmployeeList().stream().filter(employee -> employee.getDepartment().equals("HR")).limit(1).forEach(System.out::println);
        System.out.println("<----------------------------------------------------------------------------->");
        // 21. Group employees by their department.
        Map<String, List<Employee>> collect1 = Employee.getEmployeeList().stream().collect(Collectors.groupingBy(Employee::getDepartment));
        collect1.forEach((s, employees) -> System.out.println(s+"  "+employees));
        System.out.println("<----------------------------------------------------------------------------->");
        // 22. Partition employees by age (e.g., below 30 and 30 or above).
        Map<Boolean, List<Employee>> collect2 = Employee.getEmployeeList().stream().collect(Collectors.partitioningBy(employee -> employee.getAge() > 30));
        collect2.forEach((e,fuck)-> System.out.println(e+" "+fuck));
        System.out.println("<----------------------------------------------------------------------------->");
        // 23. Get a list of employee names in the "Finance" department.
        List<String> financeEmployees =Employee.getEmployeeList().stream().filter(employee -> employee.getDepartment().equals("Finance")).map(Employee::getName).toList();
        System.out.println("<----------------------------------------------------------------------------->");
        // 24. Find employees who earn more than 75,000 and are younger than 40.
        Employee.getEmployeeList().stream().filter(employee->(employee.getSalary()>70000 && employee.getAge()>40)).toList().forEach(System.out::println);
        System.out.println("<----------------------------------------------------------------------------->");
        // 25. Retrieve the names of employees sorted by age in ascending order.
        Employee.getEmployeeList().stream().sorted(Comparator.comparingDouble(Employee::getAge)).map(Employee::getName).forEach(System.out::println);
        System.out.println("<----------------------------------------------------------------------------->");
        // 26. Check if all employees in "IT" earn more than 50,000.
        boolean itEmployees = Employee.getEmployeeList().stream().allMatch(employee -> (employee.getDepartment().equals("IT") && employee.getSalary()<50000));
        if(itEmployees){
            System.out.println("Not all employees are above 50000");
            System.out.println(itEmployees);
        }else{
            System.out.println("All Employees are above 50000");
        }
        System.out.println("<----------------------------------------------------------------------------->");
        // 27. Find the employee with the highest salary.
        Employee.getEmployeeList().stream().max(Comparator.comparingDouble(Employee::getSalary)).ifPresent(employee -> System.out.println(employee.getName()));
        System.out.println("<----------------------------------------------------------------------------->");
        // 28. Find the employee with the lowest age.
        Employee.getEmployeeList().stream().min(Comparator.comparingDouble(Employee::getAge)).ifPresent(employee -> System.out.println(employee.getName()));
        System.out.println("<----------------------------------------------------------------------------->");
        // 29. Retrieve distinct ages of employees.
        Employee.getEmployeeList().stream().map(Employee::getAge).distinct().forEach(System.out::println);
        System.out.println("<----------------------------------------------------------------------------->");
        // 30. Get a list of employees sorted by department and then by salary.
        Employee.getEmployeeList().stream().sorted(Comparator.comparing(Employee::getDepartment).thenComparing(Employee::getSalary)).toList().forEach(System.out::println);
        System.out.println("<----------------------------------------------------------------------------->");
        // 31. Find the average age of employees in the "IT" department.
        Double it = Employee.getEmployeeList().stream().filter(employee -> employee.getDepartment().equals("IT")).collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(it);
        System.out.println("<----------------------------------------------------------------------------->");
        // 32. Get the total salary of employees who are younger than 35.
        double totalSalaryOfEmployeesGreaterThanThirtyFive = Employee.getEmployeeList().stream().filter(employee -> employee.getAge() < 35).mapToDouble(Employee::getSalary).sum();
        System.out.println(totalSalaryOfEmployeesGreaterThanThirtyFive);
        System.out.println("<----------------------------------------------------------------------------->");
        // 33. Collect the names of employees whose salary is above 60,000 into a set.
        Set<Employee> employeeWith60kPlus = Employee.getEmployeeList().stream().filter(employee -> employee.getSalary() > 60000).collect(Collectors.toSet());
        System.out.println(employeeWith60kPlus);
        System.out.println("<----------------------------------------------------------------------------->");
        // 34. Find employees whose name starts with the letter "A."
        boolean employeeWithPrefixA = Employee.getEmployeeList().stream().anyMatch(employee -> employee.getName().startsWith("A"));
        System.out.println("<----------------------------------------------------------------------------->");
        // 35. Get a list of employee ages sorted in descending order.
        Employee.getEmployeeList().stream().sorted(Comparator.comparingInt(Employee::getAge)).toList().forEach(System.out::println);
        System.out.println("<----------------------------------------------------------------------------->");
        // 36. Retrieve the second highest salary among employees.
        Employee.getEmployeeList().stream().sorted(Comparator.comparingDouble(Employee::getSalary)).skip(1).limit(1).forEach(System.out::println);
        System.out.println("<----------------------------------------------------------------------------->");
        // 37. Count employees with a salary between 50,000 and 70,000.
        long countOfEmployees = Employee.getEmployeeList().stream().filter(employee -> (employee.getSalary() < 70000 && employee.getSalary() > 50000)).count();
        System.out.println(countOfEmployees);
        System.out.println("<----------------------------------------------------------------------------->");
        // 38. Check if there are employees in "Marketing" over the age of 40.
        boolean employeeWithAgeOver40 = Employee.getEmployeeList().stream().anyMatch(employee -> (employee.getDepartment().equals("Marketing") && employee.getAge()>40 ));
        System.out.println(employeeWithAgeOver40 ? "Yes" : "No");
        System.out.println("<----------------------------------------------------------------------------->");
        // 39. Partition employees into those earning above and below 65,000.
        Map<Boolean, List<Employee>> employeesAboveAndBelow65K = Employee.getEmployeeList().stream().collect(Collectors.partitioningBy(employee -> employee.getSalary() > 65000));
        System.out.println(employeesAboveAndBelow65K);
        System.out.println("<----------------------------------------------------------------------------->");
        // 40. Find the average salary of all employees.
        Double avgSalaryOfAll = Employee.getEmployeeList().stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(avgSalaryOfAll);
        System.out.println("<----------------------------------------------------------------------------->");
        // 41. Retrieve employees who are in the "IT" or "HR" department.
         Employee.getEmployeeList().stream().filter(employee -> (employee.getDepartment().equals("IT") || employee.getDepartment().equals("HR"))).toList().forEach(System.out::println);
        System.out.println("<----------------------------------------------------------------------------->");
        // 42. List employees whose salary is not a multiple of 10,000.
        Employee.getEmployeeList().stream().filter(employee -> employee.getSalary()%10000 !=0).toList().forEach(System.out::println);
        System.out.println("<----------------------------------------------------------------------------->");
        // 43. Find employees whose age is an even number.
        Employee.getEmployeeList().stream().filter(employee -> employee.getAge()%2 ==0).toList().forEach(System.out::println);
        System.out.println("<----------------------------------------------------------------------------->");
        // 44. Sort employees first by department in descending order, then by age.
        Employee.getEmployeeList().stream().sorted(Comparator.comparing(Employee::getDepartment).thenComparing(Employee::getAge)).forEach(System.out::println);
        System.out.println("<----------------------------------------------------------------------------->");
        // 45. List the first names of employees over the age of 45.
        Employee.getEmployeeList().stream().filter(employee -> employee.getAge()>45).forEach(employee -> System.out.println(employee.getName()));
        System.out.println("<----------------------------------------------------------------------------->");
        // 46. Check if there is an employee in "Finance" with the same age as an employee in "HR."
        System.out.println("<----------------------------------------------------------------------------->");
        // 47. Get the sum of ages of employees in "Finance."
        Integer finance = Employee.getEmployeeList().stream().filter(employee -> employee.getDepartment().equals("Finance")).mapToInt(Employee::getAge).sum();
        System.out.println(finance);
        System.out.println("<----------------------------------------------------------------------------->");
        // 48. Retrieve a sorted list of employee names without duplicates.
        Employee.getEmployeeList().stream().sorted(Comparator.comparing(Employee::getName)).distinct().forEach(System.out::println);
        System.out.println("<----------------------------------------------------------------------------->");
        // 49. Get a list of employee names and departments sorted alphabetically by name.
        Employee.getEmployeeList().stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Comparator.comparing(Employee::getDepartment))).distinct().forEach(System.out::println);
        System.out.println("<----------------------------------------------------------------------------->");
        // 50. Find employees who are in either "Finance" or "IT" with a salary below 60,000.
        Employee.getEmployeeList().stream()
                .filter(employee -> ((employee.getDepartment().equals("Finance") && employee.getSalary()>60000)||(employee.getDepartment().equals("IT") && employee.getSalary()>60000))).toList().forEach(System.out::println);
        System.out.println("<----------------------------------------------------------------------------->");

    }
}
