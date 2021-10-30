public class Operator extends Employee implements EmployeePosition {
    public String jobTitle = "Operator";
    public double salary;

    public Operator() {
    }

    public Operator(String name, String surname, double baseSalary) {
        super(name, surname, baseSalary);
        super.employeePosition = this.jobTitle;
    }

    public double getSalary() {
        return this.salary;
    }

    @Override
    public String getJobTitle() {
        return this.jobTitle;
    }

    @Override
    public void calcSalary() {
        this.salary = this.baseSalary;
        super.salary = this.salary;
    }
}
