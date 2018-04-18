public abstract class TechnicalEmployee extends Employee {

    private int successfulCheckIns;

    public TechnicalEmployee(String name, double salary) {
        super(name,salary);
        this.successfulCheckIns = 0;
        super.setManager(null);
    }

    public String employeeStatus() {
        String result = super.toString() + " has " + this.successfulCheckIns + " successful check ins";
        return result;
    }

    public int getSuccessfulCheckIns() {
        return this.successfulCheckIns;
    }

    public void increaseSuccessfulCheckIns() {
        this.successfulCheckIns++;
    }
}
