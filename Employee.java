public abstract class Employee {

    private String name;
    private double baseSalary;
    private double bonus;
    private int employeeID;
    private static int employees = 0;
    private Employee manager;
    private boolean isManager;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.bonus = 0.0;
        this.employeeID = ++employees;
        this.manager = null;
        this.isManager = false;
    }

    public double getBaseSalary() {
        return this.baseSalary;
    }

    public double getBonus() {
        return this.bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public String getName() {
        return this.name;
    }

    public int getEmployeeID() {
        return this.employeeID;
    }

    public Employee getManager() {
        return this.manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public boolean isManager() {
        return this.isManager;
    }

    public void isManager(boolean value) {
        this.isManager = value;
    }

    public boolean equals(Employee other) {
        return this.employeeID == other.getEmployeeID();
    }

    public String toString() {
        String result = Integer.toString(this.employeeID) + " " + this.name;
        return result;
    }
    public abstract String employeeStatus();
}
