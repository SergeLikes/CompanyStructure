public class SoftwareEngineer extends TechnicalEmployee {

    private boolean codeAccess;
    private double bonus;

    public SoftwareEngineer(String name) {
        super(name,75000);
        this.codeAccess = false;
        this.bonus = 0.0;
        super.isManager(false);
    }

    public boolean getCodeAccess() {
        return codeAccess;
    }

    public void setCodeAccess(boolean access) {
        this.codeAccess = access;
    }

    public void setManager(TechnicalLead t) {
        super.setManager(t);
    }

    public Employee getManager() {
        return super.getManager();
    }

    public double getBonus() {
        return this.bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public int getSuccessfulCheckIns() {
        return super.getSuccessfulCheckIns();
    }

    public boolean checkInCode() {
        TechnicalLead t = (TechnicalLead)(super.getManager());
        if (t.approveCheckIn(this)) {
            super.increaseSuccessfulCheckIns();
            this.codeAccess = true;
            return true;
        }
        else {
            this.codeAccess = false;
        }
        return false;
    }

    public String employeeStatus() {
        return super.employeeStatus();
    }
}
