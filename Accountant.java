import java.util.LinkedList;

public class Accountant extends BusinessEmployee {

    private TechnicalLead teamSupported;
    private Employee manager;

    public Accountant(String name) {
        super(name,50000);
        this.teamSupported = null;
        this.manager = null;
        super.isManager(false);
    }

    public TechnicalLead getTeamSupported() {
        return teamSupported;
    }

    public double getBonusBadget() {
        return super.getBonusBadget();
    }

    public Employee getManager() {
        return this.manager;
    }

    public void supportTeam(TechnicalLead lead) {
        if (this.teamSupported == null) {
            this.teamSupported = new TechnicalLead(lead.getName());
            LinkedList<SoftwareEngineer> engineers = lead.getEngineers();
            double bonusBadget = 0.0;
            for (SoftwareEngineer s : engineers) {
                bonusBadget += s.getBaseSalary();
            }
            bonusBadget += (bonusBadget) * 0.1;
            super.setBonusBudget(bonusBadget);
        }
    }

    public boolean approveBonus(double bonus) {
        if ( (teamSupported == null) || (bonus > super.getBonusBadget())) {
            return false;
        }
        double newBadget = super.getBonusBadget() - bonus;
        super.setBonusBudget(newBadget);
        return true;
    }

    public String employeeStatus() {
        String result = super.toString() + " with a budget of " + Double.toString(super.getBonusBadget()) + " and is supporting " + teamSupported.getName();
        return result;
    }
}
