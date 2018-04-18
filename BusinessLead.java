import java.util.LinkedList;

public class BusinessLead extends BusinessEmployee {

    private int headCount;
    private LinkedList<Accountant> accountants;

    public BusinessLead(String name) {
        super(name,100000);
        accountants = new LinkedList<Accountant>();
        this.headCount = 10;
    }

    public int getHeadCount() {
        return this.headCount;
    }

    public void setHeadCount(int headCount) {
        this.headCount = headCount;
    }

    public boolean hasHeadCount() {
        return accountants.size() >= headCount;
    }

    public boolean addReport(Accountant e, TechnicalLead supportTeam) {
        if (accountants.size() < headCount) {
            accountants.add(e);
            e.supportTeam(supportTeam);
            double newBudget = super.getBonusBadget() + (e.getBonusBadget()*1.1);
            super.setBonusBudget(newBudget);
            supportTeam.setSupportedAccountant(e);
            return true;
        }
        return false;
    }

    public boolean requestBonus(Employee e, double bonus) {
        if (bonus <= super.getBonusBadget()) {
            e.setBonus(bonus);
            double newBudget = super.getBonusBadget() - bonus;
            super.setBonusBudget(newBudget);
            return true;
        }
        return false;
    }

    public boolean approveBonus(Employee e, double bonus) {
        for (Accountant a : accountants) {
            TechnicalLead techLead = a.getTeamSupported();
            if (e.getManager().getEmployeeID() == techLead.getEmployeeID()) {
                if (a.approveBonus(bonus)) {
                    e.setBonus(bonus);
                    return true;
                }
            }
        }
        return false;
    }

    public String getTeamStatus() {
        if (accountants.isEmpty()) {
            return this.employeeStatus() + " and no direct reports yet";
        }
        StringBuilder result = new StringBuilder(this.employeeStatus() + " and is managing:\n");
        for (Accountant a : accountants) {
            result.append(a.employeeStatus() + "\n");
        }
        return result.toString();
    }

    public String employeeStatus() {
        return super.employeeStatus();
    }
}
