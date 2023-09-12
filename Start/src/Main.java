import java.util.*;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Kevin", "Kneißl", 25);
        System.out.println("Name: " + person.getName());
        System.out.println("Alter: " + person.getAge());
        System.out.println("--------------------");
        person.setName("Anderer", "Name");
        person.setAge(30);
        System.out.println("Name: " + person.getName());
        System.out.println("Alter: " + person.getAge());

        System.out.println("--------------------");

        Employee employee = new Employee("Tobias", "Kügerl", 17);
        employee.setSupervisorID("GFG23G");
        employee.setSalary(3000.0f);
        System.out.println("Name: " + employee.getName());
        System.out.println("Alter: " + employee.getAge());
        System.out.println("Supervisor ID: " + employee.getSupervisorID());
        System.out.println("Gehalt: " + employee.getSalary());
        employee.salaryIncrease(500.0f);
        System.out.println("Neues Gehalt: " + employee.getSalary());

    }
}