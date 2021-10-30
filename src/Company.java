import java.util.*;

public class Company {
    public double income;
    public int count;
    public String nameNewEmployee;
    public String surnameNewEmployee;
    public double baseSalaryNewEmployee;
    public String newEmployeePosition;
    public static ArrayList<Employee> employees = new ArrayList<>();
    public static ArrayList<Employee> topSalaryStaff = new ArrayList<>();
    public static ArrayList<Employee> lowestSalaryStaff = new ArrayList<>();

    public void hire(String nameNewEmployee, String surnameNewEmployee, double baseSalaryNewEmployee, String newEmployeePosition) {
        if (newEmployeePosition.equals("Operator")) {
            Operator operator = new Operator(nameNewEmployee, surnameNewEmployee, baseSalaryNewEmployee);
            employees.add(operator);
        } else if (newEmployeePosition.equals("Manager")) {
            Manager manager = new Manager(nameNewEmployee, surnameNewEmployee, baseSalaryNewEmployee);
            employees.add(manager);
        } else if (newEmployeePosition.equals("TopManager")) {
            TopManager topManager = new TopManager(nameNewEmployee, surnameNewEmployee, baseSalaryNewEmployee);
            employees.add(topManager);
        } else {
            System.out.println("Такой должности нет");
        }
    }

    public void hireAll() {
        System.out.println("Вводите должность, имя, фамилию и оклад в формате: `\n` Должность Имя Фамилия Оклад `\n` для того чтобы прекратить вводить - введите 'stop' ");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();

            if (s.equals("stop")) {
                break;
            } else {
                String[] subS;
                subS = s.split(" ");
                newEmployeePosition = subS[0];
                nameNewEmployee = subS[1];
                surnameNewEmployee = subS[2];
                baseSalaryNewEmployee = Double.parseDouble(subS[3]);

                hire(nameNewEmployee, surnameNewEmployee, baseSalaryNewEmployee, newEmployeePosition);
            }
        }
    }

    public void fire(String name, String surname, String employeePosition) {
        for (int i = 0; i < employees.size(); i++) {
            if ((employees.get(i).getName().equals(name)) && (employees.get(i).getSurname().equals(surname)) && (employees.get(i).getEmployeePosition().equals(employeePosition))) {
                employees.remove(i);
            }
        }
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    static void getTopSalaryStaff(int count) {
        ArrayList<Employee> clone = (ArrayList<Employee>) employees.clone();
        clone.sort(Comparator.comparing(Employee::getSalary).reversed());
        for (int i = 0; i < count; i++) topSalaryStaff.add(clone.get(i));
        for (int i = 0; i < count; i++) {
            System.out.println("- " + topSalaryStaff.get(i).getSalary());
        }
        clone.removeAll(employees);
        topSalaryStaff.removeAll(employees);
    }

    static void getLowestSalaryStaff(int count) {
        ArrayList<Employee> clone = (ArrayList<Employee>) employees.clone();
        clone.sort(Comparator.comparing(Employee::getSalary));
        for (int i = 0; i < count; i++) lowestSalaryStaff.add(clone.get(i));
        for (int i = 0; i < count; i++) {
            System.out.println("- " + lowestSalaryStaff.get(i).getSalary());
        }
        clone.removeAll(employees);
        lowestSalaryStaff.removeAll(employees);
    }

    public static void main(String[] args){
        int income = 2000000;

        for (int i = 0; i < 180; i++) {
            int baseSalary = (int) (50000 + Math.random() * 50000);
            Operator operator = new Operator("name", "surname", baseSalary);
            operator.calcSalary();
            employees.add(operator);
        }

        for (int i = 0; i < 80; i++) {
            int baseSalary = (int) (70000 + Math.random() * 50000);
            Manager manager = new Manager("name1", "surname2", baseSalary);
            manager.calcSalary();
            employees.add(manager);
        }

        for (int i = 0; i < 10; i++) {
            int baseSalary = (int) (70000 + Math.random() * 50000);
            TopManager topManager = new TopManager("name2", "surname2", baseSalary);
            topManager.calcSalary();
            employees.add(topManager);
        }

       int count = 15;
        System.out.println("Список 15 самых высоких зарплат в компании: \n");
        getTopSalaryStaff(count);

        count = 30;
        System.out.println("Список 30 самых низких зарплат в компании: \n");
        getLowestSalaryStaff(count);

        System.out.println("Увольнение 50%");
        for (int i = 0; i < employees.size() / 2; i++) {
            employees.remove(i);
        }

        count = 15;
        System.out.println("Список 15 самых высоких зарплат в компании: \n");
        getTopSalaryStaff(count);

        count = 30;
        System.out.println("Список 30 самых низких зарплат в компании: '\n'");
        getLowestSalaryStaff(count);
    }
}
