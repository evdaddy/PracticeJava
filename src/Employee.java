public class Employee {
    public String name;
    public String surname;
    public double baseSalary;
    public String employeePosition;
    public double salary;

    public Employee() {}

    public Employee(String name, String surname, double baseSalary) {
        this.name = name;
        this.surname = surname;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getEmployeePosition() {
        return this.employeePosition;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setEmployeePosition(String employeePosition) {
        this.employeePosition = employeePosition;
    }
}
