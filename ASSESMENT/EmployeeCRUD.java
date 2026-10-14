package ASSESMENT;

import java.util.ArrayList;

public class EmployeeCRUD {
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();

        // Add employees
        employees.add(new Employee(101, "Rahul", 25000));
        employees.add(new Employee(102, "Aman", 30000));

        // Display employees
        System.out.println("Employee Details:");

        for (Employee e : employees) {
            e.display();
        }

        // Update employee salary
        for (Employee e : employees) {
            if (e.id == 102) {
                e.salary = 35000;
            }
        }

        System.out.println("\nAfter Update:");

        for (Employee e : employees) {
            e.display();
        }

        // Delete first employee
        employees.remove(0);

        System.out.println("\nAfter Delete:");

        for (Employee e : employees) {
            e.display();
        }
    }
}