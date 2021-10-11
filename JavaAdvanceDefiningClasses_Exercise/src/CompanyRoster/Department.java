package CompanyRoster;
import java.util.List;

public class Department {
    String name;
    List<Employee> employee;
    double avgSalary;

    Department(String name, List<Employee> employee) {
        this.name = name;
        this.employee = employee;
        this.avgSalary = employee.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
    }

    double getAvgSalary() {
        return avgSalary;
    }

    String getName() {
        return name;
    }

    List<Employee> getEmployee() {
        return employee;
    }
}
