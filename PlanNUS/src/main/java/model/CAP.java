package model;

public class CAP {
    private double CAP;
    private int moduleCredit;

    public CAP(double CAP,int moduleCredit) {
        setCAP(CAP);
        setmoduleCredit(moduleCredit);
    }

    public void setCAP(double CAP) {
        this.CAP = CAP;
    }

    public void setmoduleCredit(int moduleCredit) {
        this.moduleCredit = moduleCredit;
    }

    public double getCAP() {
        return CAP;
    }

    public int getmoduleCredit() {
        return moduleCredit;
    }
}
