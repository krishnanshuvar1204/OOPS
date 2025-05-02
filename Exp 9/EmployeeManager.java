import java.util.ArrayList;
import java.util.ListIterator;

class Employee {
    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    
    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double newSalary) {
        this.salary = newSalary;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', salary=" + salary + "}";
    }
}

public class EmployeeManager {
    public static void main(String[] args) {
        
        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Alice", 101, 50000));
        employees.add(new Employee("Bob", 102, 55000));
        employees.add(new Employee("Charlie", 103, 60000));
        
        ListIterator<Employee> listIterator = employees.listIterator();
        while (listIterator.hasNext()) {
            Employee emp = listIterator.next();
            if (emp.getId() == 102) {
                emp.setSalary(58000); 
                System.out.println("Updated Bob's salary to " + emp.getSalary());
            }
        }

        listIterator = employees.listIterator(); 
        while (listIterator.hasNext()) {
            Employee emp = listIterator.next();
            if (emp.getId() == 103) {
                listIterator.remove();
                System.out.println("Removed employee with ID 103.");
            }
        }

        System.out.println("\nRemaining Employees:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}