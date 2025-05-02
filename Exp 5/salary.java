class Employee 
{
    private String name;
    private int empid;
    private double salary;

    public Employee()
    {
        this("Unknown", 0, 0.0);
    }

    public Employee(String name, int empid, double salary)
    {
        this.name = name;
        this.empid = empid;
        this.salary = salary;
    }

    public void increaseSalary(double percentage) 
    {
        salary += salary * percentage / 100;
    }

    public void displayDetails() {
        System.out.println(name + " ID: " + empid + " Salary: " + salary);
    }
}

class Manager extends Employee 
{
    private String department;

    public Manager(String name, int empid, double salary, String department)
    {
        super(name, empid, salary);
        this.department = department;
    }

    public void displayDetails()
    {
        super.displayDetails();
        System.out.println("Department: " + department);
    }
}

public class salary
{
    public static void main(String[] args) 
    {
        Employee emp = new Employee("Alice", 101, 50000);
        emp.displayDetails();
        emp.increaseSalary(10);
        emp.displayDetails();

        System.out.println();

        Manager mgr = new Manager("Bob", 201, 80000, "IT");
        mgr.displayDetails();
        mgr.increaseSalary(15);
        mgr.displayDetails();
    }
}