public class TopManager extends Employee implements EmployeePosition {
    public String jobTitle = "TopManager";
    public double salary;
    public double income;

    public TopManager() {
    }

    public TopManager(String name, String surname, double baseSalary) {
        super(name, surname, baseSalary);
        super.employeePosition = this.jobTitle;
    }


    public void setIncome(double income) {
        this.income = income;
    }

    @Override
    public String getJobTitle() {
        return this.jobTitle;
    }

    @Override
    public void calcSalary() {
        if (income > 10000000) {
            this.salary = this.baseSalary + this.baseSalary * 150 / 100;
            super.salary = this.salary;
        }
    }
}
