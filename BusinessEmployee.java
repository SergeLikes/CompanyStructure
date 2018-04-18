public abstract class BusinessEmployee extends Employee {

    private double bonusBudget;

    public BusinessEmployee(String name, double salary) {
        super(name,salary);
        this.bonusBudget = 0.0;
    }

    public double getBonusBadget() {
        return this.bonusBudget;
    }

    public void setBonusBudget(double bonusBudget) {
        this.bonusBudget = bonusBudget;
    }

    public String employeeStatus() {
        String result = super.toString() + " with a budget of " + this.bonusBudget;
        return result;
    }
}
