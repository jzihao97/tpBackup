package model;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import model.CAP;
import model.Module;

public class CAPlist {
    private ArrayList<Module> modulesListToSU = new ArrayList<>();
    private ArrayList<CAP> CAPlist = new ArrayList<>();
    private DecimalFormat formatFinalCAP = new DecimalFormat("#.##");
    private int numberOfCAP;

    //CONSTANTS
    private final String ERROR_INVALID_COMMAND = "INVALID COMMAND";

    public CAPlist() {
        setNumberOfCAP(1);
    }

    //Getter and Setter
    public void setNumberOfCAP(int numberOfCAP) {
        this.numberOfCAP = numberOfCAP;
    }

    public int getNumberOfCAP() {
        return numberOfCAP;
    }

    //Main Function
    public void CAPCalculator() {
        System.out.println("Welcome to CAP Calculator! Commands available are:\n" +
                "  Current\n" +
                "  Set current\n" +
                "  Set target\n" +
                "  Set SU\n" +
                "To exit CAP Calculator, use command: \"exit\"\n\n" +
                "Initializing your CAP...");
                setInitialCAP();
        System.out.println("Type a command to continue...");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toUpperCase();

        while (!input.equals("EXIT")) {
            if (input.equals("CURRENT")) {
                printCurrentCAP();
            } else if (input.equals("SET CURRENT")) {
                setCurrentCAP();
            } else if (input.equals("SET TARGET")) {
                setTargetCAP();
            } else if (input.equals("SET SU")) {
                setSUs();
            }else {
                System.out.println(ERROR_INVALID_COMMAND);
            }
            input = scanner.nextLine().toUpperCase();
        }
    }

    /**
     * Set the initial CAP and graded MCs to be 0.
     * This function may be modified so that it reads the list of modules that the
     * User have taken and set the initial CAP and graded MCs.
     */
    public void setInitialCAP() {
        CAP currentCAP = new CAP(0.00, 0);
        CAPlist.add(currentCAP);
        printCurrentCAP();
    }

    /**
     * Allows the user to modify his or her current CAP and graded MCs.
     */
    public void setCurrentCAP() {
        Scanner in = new Scanner(System.in);
        CAP currentCAP = CAPlist.get(0);
        try {
            System.out.println("What is your current CAP?");
            currentCAP.setCAP(Double.parseDouble(in.nextLine()));

            System.out.println("How many graded MCs have you taken?");
            currentCAP.setmoduleCredit(Integer.parseInt(in.nextLine()));

            System.out.println("Done!");
            printCurrentCAP();
        } catch(NullPointerException e) {
            System.out.println(ERROR_INVALID_COMMAND);
            setInitialCAP();
        }
    }

    /**
     * Allow the user to set the target CAP that he or she want to achieve in the next given MCs.
     */
    public void setTargetCAP() {
        Scanner in = new Scanner(System.in);
        CAP targetCAP = new CAP(0.00,0);
        try {
            System.out.println("What is your target CAP?");
            targetCAP.setCAP(Double.parseDouble(in.nextLine()));

            System.out.println("How many graded MCs you are taking to achieve the target CAP?");
            targetCAP.setmoduleCredit(Integer.parseInt(in.nextLine()));
            calculateResults(CAPlist.get(0).getCAP(), targetCAP.getCAP(), CAPlist.get(0).getmoduleCredit(),
                    targetCAP.getmoduleCredit());
        } catch(NullPointerException e) {
            System.out.println(ERROR_INVALID_COMMAND);
        }
    }

    /**
     * Calculate what should be the user's minimum CAP in order to achieve user's target CAP
     *
     * @param currentCAP user's currentCAP
     * @param targetCAP user's targetCAP
     * @param gradedMC user's current graded MCs
     * @param targetGradedMC user's target MCs to get the target grades
     */
    public void calculateResults(double currentCAP,double targetCAP,int gradedMC,int targetGradedMC) {
        formatFinalCAP.setRoundingMode(RoundingMode.UP);

        double totalCAP = 0.00;
        double tempCAP = currentCAP;
        int totalMCs = gradedMC + targetGradedMC;

        while (totalCAP <= targetCAP) {
            tempCAP+=0.005;
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

    public void setSUs() {
        Scanner in = new Scanner(System.in);
        int numberOfModules = 0;
        System.out.println("How many modules did you take this semester?");
        numberOfModules = Integer.parseInt(in.nextLine());
        for (int i = 0; i<numberOfModules; i++) {
            System.out.println("What is the "+ getAbbreviations(i+1) +" module did you take?");
            String fullInputs = in.nextLine();
            String[] input = fullInputs.split(" ");
            Module moduleToSU = new Module(input[0],0,input[1],Integer.parseInt(input[2]));
            modulesListToSU.add(moduleToSU);
        }
        calculateSU();
    }

    public void calculateSU() {
        formatFinalCAP.setRoundingMode(RoundingMode.UP);
        CAP currentCAP = CAPlist.get(0);
        double totalCAP = currentCAP.getCAP() * currentCAP.getmoduleCredit();
        int totalGradedMCs = currentCAP.getmoduleCredit();
        double bestCAP = currentCAP.getCAP() * currentCAP.getmoduleCredit();
        int bestGradedMCs = currentCAP.getmoduleCredit();
        for (Module module:modulesListToSU) {
            totalCAP += module.getCAP() * module.getModuleCredit();
            totalGradedMCs += module.getModuleCredit();
        }

        System.out.println("Your CAP without SU any module is: " +
                formatFinalCAP.format(totalCAP/(double)totalGradedMCs));
        System.out.println("Your graded MCs without SU any module is: " + totalGradedMCs);

        for (Module module:modulesListToSU) {
            totalCAP -= module.getCAP() * module.getModuleCredit();
            totalGradedMCs -= module.getModuleCredit();
            System.out.println("SU your module of " + module.getModuleCode() + " with grade " +module.getGrade()
                    + " will give you a CAP of: " + formatFinalCAP.format(totalCAP/(double)totalGradedMCs));
            System.out.println("Your graded MCs after SUing this module is: " + totalGradedMCs);
        }
    }
    public void printCurrentCAP() {
        CAP currentCAP = CAPlist.get(0);
        System.out.println("Your current now CAP is: " + currentCAP.getCAP());
        System.out.println("Number of graded MCs taken is: " + currentCAP.getmoduleCredit());
    }

    public String getAbbreviations(int i) {
        if (i%10==1 & i!= 11) {
            return i+"st";
        } else if (i%10==2 & i!=12) {
            return i+"nd";
        } else if (i%10==3 & i!=13) {
            return i+"rd";
        } else {
            return i+"th";
        }
    }
}