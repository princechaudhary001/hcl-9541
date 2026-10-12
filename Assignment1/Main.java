import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// ---------------------------------------------------------
// 1. Salary Structure
// ---------------------------------------------------------
class Salary {
    private double basic;
    private double hra;
    private double ta;
    private double specialAllowance;

    public Salary(double basic, double hra, double ta, double specialAllowance) {
        this.basic = basic;
        this.hra = hra;
        this.ta = ta;
        this.specialAllowance = specialAllowance;
    }

    public Salary(double basic, double hra) {
        this(basic, hra, 0.0, 0.0);
    }

    public double getBonusComputableAmount() {
        // Bonus is calculated based on Basic and HRA
        return this.basic + this.hra;
    }
}

// ---------------------------------------------------------
// 2. Abstract Employee Base Class
// ---------------------------------------------------------
abstract class Employee {
    protected int empId;
    protected String name;
    protected Salary salary;
    protected double bonus;

    public Employee(int empId, String name, Salary salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
        this.bonus = 0.0;
    }

    public abstract double calculateBonus();

    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public double getBonus() {
        return bonus;
    }
}

// ---------------------------------------------------------
// 3. Role-Specific Implementations
// ---------------------------------------------------------
class Manager extends Employee {
    public Manager(int empId, String name, Salary salary) {
        super(empId, name, salary);
    }

    @Override
    public double calculateBonus() {
        this.bonus = this.salary.getBonusComputableAmount() * 0.12;
        return this.bonus;
    }
}

class Admin extends Employee {
    public Admin(int empId, String name, Salary salary) {
        super(empId, name, salary);
    }

    @Override
    public double calculateBonus() {
        this.bonus = this.salary.getBonusComputableAmount() * 0.10;
        return this.bonus;
    }
}

class Engineer extends Employee {
    public Engineer(int empId, String name, Salary salary) {
        super(empId, name, salary);
    }

    @Override
    public double calculateBonus() {
        this.bonus = this.salary.getBonusComputableAmount() * 0.12;
        return this.bonus;
    }
}

class Accountant extends Employee {
    public Accountant(int empId, String name, Salary salary) {
        super(empId, name, salary);
    }

    @Override
    public double calculateBonus() {
        this.bonus = this.salary.getBonusComputableAmount() * 0.08;
        return this.bonus;
    }
}

// ---------------------------------------------------------
// 4. Bonus Processor & Reporting
// ---------------------------------------------------------
class BonusProcessor {
    private List<Employee> employees;

    public BonusProcessor(List<Employee> employees) {
        this.employees = employees;
    }

    public void processBonuses() {
        for (Employee emp : employees) {
            emp.calculateBonus();
        }
    }

    public List<Employee> getSortedEmployees() {
        List<Employee> sortedList = new ArrayList<>(employees);
        // Sort employees by bonus in descending order
        sortedList.sort((e1, e2) -> Double.compare(e2.getBonus(), e1.getBonus()));
        return sortedList;
    }
}

class ConsoleReportViewer {
    public static void display(List<Employee> employees) {
        for (Employee emp : employees) {
            System.out.println("Emp_id: " + emp.getEmpId());
            System.out.println("Name: " + emp.getName());
            System.out.println("Bonus: Rs. " + String.format("%.2f", emp.getBonus()));
            System.out.println();
        }
    }
}

// ---------------------------------------------------------
// 5. Main Application Execution
// ---------------------------------------------------------
public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Manager(101, "Rahul", new Salary(30000, 15000, 5000, 10000)));
        employeeList.add(new Admin(102, "Priya", new Salary(20000, 10000)));
        employeeList.add(new Engineer(103, "Amit", new Salary(35000, 17500)));
        employeeList.add(new Accountant(104, "Neha", new Salary(25000, 12000)));

        BonusProcessor processor = new BonusProcessor(employeeList);
        processor.processBonuses();

        List<Employee> sortedEmployees = processor.getSortedEmployees();
        ConsoleReportViewer.display(sortedEmployees);
    }
}