public class Employee extends Person {
    private String supervisorID;
    private float salary;

    public Employee(String firstname, String lastname, int age) {
        super(firstname, lastname, age);
    }

    public void setSupervisorID(String supervisorID) {
        this.supervisorID = supervisorID;
    }

    public String getSupervisorID() {
        return this.supervisorID;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getSalary() {
        return salary;
    }

    public void salaryIncrease(float increaseAmount) {
        salary += increaseAmount;
    }
}