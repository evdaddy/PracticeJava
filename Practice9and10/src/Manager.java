public class Manager extends Employee implements EmployeePosition {
    public String jobTitle = "Manager";
    public double salary;

    public Manager() {
    }

    public Manager(String name, String surname, double baseSalary) {
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
        this.salary = baseSalary + (115000 + Math.random() * 25000) * 5 / 100;
        super.salary = this.salary;
    }
}
