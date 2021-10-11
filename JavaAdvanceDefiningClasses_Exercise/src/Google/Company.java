package Google;

public class Company {
    private String companyName;
    private String department;
    private double salary;

    public String getCompanyName() {
        return companyName;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public Company(String companyName, String department, double salary) {
        this.companyName = companyName;
        this.department = department;
        this.salary = salary;
    }
}
