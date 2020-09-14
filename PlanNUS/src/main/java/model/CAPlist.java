package model;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import model.CAP;
import model.Module;

public class CAPlist {
    private ArrayList<CAP> CAPlist = new ArrayList<>();
    private int numberOfCAP;

    public CAPlist() {
        setNumberOfCAP(1);
    }

    public void setNumberOfCAP(int numberOfCAP) {
        this.numberOfCAP = numberOfCAP;
    }

    public int getNumberOfCAP() {
        return numberOfCAP;
    }

    /**
     * Set the initial CAP and graded MCs to be 0.
     * This function may be modified so that it reads the list of modules that the
     * User have taken and set the initial CAP and graded MCs.
     */
    public void setInitialCAP() {
        CAP currentCAP = new CAP(0.00, 0);
        CAPlist.add(currentCAP);
        printCurrentCAP(currentCAP.getCAP(), currentCAP.getmoduleCredit());
    }

    /**
     * Allows the user to modify his or her current CAP and graded MCs.
     */
    public void setCurrentCAP() {
        Scanner in = new Scanner(System.in);
        CAP currentCAP = CAPlist.get(0);
        System.out.println("What is your current CAP?");
        currentCAP.setCAP(Double.parseDouble(in.nextLine()));
        System.out.println("How many graded MCs have you taken?");
        currentCAP.setmoduleCredit(Integer.parseInt(in.nextLine()));
        System.out.println("Done! ");
        printCurrentCAP(currentCAP.getCAP(), currentCAP.getmoduleCredit());
    }

    /**
     * Allow the user to set the target CAP that he or she want to achieve in the next given MCs.
     */
    public void setTargetCAP() {
        Scanner in = new Scanner(System.in);
        CAP targetCAP = new CAP(0.00,0);
        System.out.println("What is your target CAP?");
        targetCAP.setCAP(Double.parseDouble(in.nextLine()));
        System.out.println("How many graded MCs you are taking to achieve the target CAP?");
        targetCAP.setmoduleCredit(Integer.parseInt(in.nextLine()));
        calculateResults(CAPlist.get(0).getCAP(),targetCAP.getCAP(),CAPlist.get(0).getmoduleCredit(),targetCAP.getmoduleCredit());
    }

    /**
     *
     * @param currentCAP user's currentCAP
     * @param targetCAP user's targetCAP
     * @param gradedMC user's current graded MCs
     * @param targetGradedMC user's target MCs to get the target grades
     */
    public void calculateResults(double currentCAP,double targetCAP,int gradedMC,int targetGradedMC) {
        DecimalFormat formatFinalCAP = new DecimalFormat("#.##");
        formatFinalCAP.setRoundingMode(RoundingMode.UP);
        double totalCAP = 0.00;
        double tempCAP = currentCAP;
        int totalMCs = gradedMC + targetGradedMC;
        while (targetCAP > totalCAP && tempCAP <= 5) {
            tempCAP+=0.01;
            totalCAP = ((currentCAP * gradedMC) + (tempCAP * targetGradedMC))/(double)totalMCs;
        }
        if (tempCAP <= 5) {
            System.out.println("You should achieve a minimum CAP of " + formatFinalCAP.format(tempCAP) + " for your next " +
                    targetGradedMC + " MCs to achieve your target CAP of " + targetCAP + ".");
        } else {
            System.out.println("OPSS!! Looks like you are not able to achieve your target CAP of " + targetCAP +
                    " with you target MCs of " + targetGradedMC + ".");
        }
    }

//    public void setSUs() {
//        Scanner in = new Scanner(System.in);
//        int numberOfModules = 0;
//        System.out.println("How many modules did you take this semester?");
//        numberOfModules = Integer.parseInt(in.nextLine());
//        for (int i = 0; i<numberOfModules; i++) {
//            System.out.println("What module did you take?");
//        }
//    }


    public void printCurrentCAP(double currentCAP, int gradedMC) {
        System.out.println("Your current now CAP is: " + currentCAP);
        System.out.println("Number of graded MCs taken is: " + gradedMC);
    }
}