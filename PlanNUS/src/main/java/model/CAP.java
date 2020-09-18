package model;

import capcalcexceptions.IllegalCAPException;

public class CAP {
    private double CAP;
    private int moduleCredit;

    //CONSTANT
    private final double MAXIMUM_ACADPOINT = 5.00;

    public CAP(double CAP,int moduleCredit) throws IllegalCAPException {
        setCAP(CAP);
        setmoduleCredit(moduleCredit);
    }

    public void setCAP(double CAP) throws IllegalCAPException {
        if (CAP <= MAXIMUM_ACADPOINT) {
            this.CAP = CAP;
        } else {
            throw new IllegalCAPException();
        }
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
