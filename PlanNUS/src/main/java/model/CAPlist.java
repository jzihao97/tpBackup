package model;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import moduledata.ModuleInitializer;

public class CAPlist {
    private final ModuleInitializer allModules =  new ModuleInitializer();
    private final Person Bob = new Person("Bob" , 3, allModules);
    private final ArrayList<Module> bobModuleList = Bob.getModulesList();
    private final ArrayList<Module> modulesListToSU = new ArrayList<>();
    private final ArrayList<CAP> CAPlist = new ArrayList<>();
    private final DecimalFormat formatFinalCAP = new DecimalFormat("#.##");
    private int numberOfCAP;

    //CONSTANTS
    private final String ERROR_INVALID_COMMAND = "INVALID COMMAND";
    private final String AWAIT_COMMAND = "Type a command to continue...";
    private final String EXIT_COMMAND = "EXIT";
    private final String CURRENT_COMMAND = "CURRENT";
    private final String SET_CURRENT_COMMAND = "SET CURRENT";
    private final String SET_TARGET_COMMAND = "SET TARGET";
    private final String SET_SU_COMMAND = "SET SU";
    private final String EXIT_MESSAGE = "EXITING CAPCALC";
    private final String WELCOME_MESSAGE = "Welcome to CAP Calculator! Commands available are:\n" +
            "  Current\n" +
            "  Set current\n" +
            "  Set target\n" +
            "  Set SU\n" +
            "To exit CAP Calculator, use command: \"exit\"\n\n" +
            "Initializing your CAP...";


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
        System.out.println(WELCOME_MESSAGE);
                setInitialCAP();
        System.out.println(AWAIT_COMMAND);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toUpperCase();

        while (!input.equals(EXIT_COMMAND)) {
            if (input.equals(CURRENT_COMMAND)) {
                printCurrentCAP();
            } else if (input.equals(SET_CURRENT_COMMAND)) {
                setCurrentCAP();
            } else if (input.equals(SET_TARGET_COMMAND)) {
                setTargetCAP();
            } else if (input.equals(SET_SU_COMMAND)) {
                setSUs();
            }else {
                System.out.println(ERROR_INVALID_COMMAND);
            }
            input = scanner.nextLine().toUpperCase();
        }
        System.out.println(EXIT_MESSAGE);
    }

    /**
     * Set the initial CAP and graded MCs to be 0.
     * This function may be modified so that it reads the list of modules that the
     * User have taken and set the initial CAP and graded MCs.
     */
    private void setInitialCAP() {
        double academicPoint = 0.00;
        int gradedMcs = 0;
        CAP currentCAP = new CAP(0, 0);
        formatFinalCAP.setRoundingMode(RoundingMode.UP);
        if (!bobModuleList.isEmpty()) {
            for (Module module : bobModuleList) {
                academicPoint += module.getCAP() * module.getModuleCredit();
                gradedMcs += module.getModuleCredit();
            }
            academicPoint = academicPoint / ((double) gradedMcs);
            currentCAP.setCAP(academicPoint);
            currentCAP.setmoduleCredit(gradedMcs);
        }
        CAPlist.add(currentCAP);
        printCurrentCAP();
    }

    /**
     * Allows the user to modify his or her current CAP and graded MCs.
     */
    private void setCurrentCAP() {
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
    private void setTargetCAP() {
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
    private void calculateResults(double currentCAP,double targetCAP,int gradedMC,int targetGradedMC) {

        double totalCAP = 0.00;
        double tempCAP = currentCAP;
        int totalMCs = gradedMC + targetGradedMC;

        while (totalCAP <= targetCAP) {
            tempCAP+=0.005;
            totalCAP = ((currentCAP * gradedMC) + (tempCAP * targetGradedMC))/(double)totalMCs;
        }

        if (tempCAP <= 5) {
            System.out.println("You should achieve a minimum CAP of " + formatCAPToString(tempCAP) + " for your next " +
                    targetGradedMC + " MCs to achieve your target CAP of " + targetCAP + ".");
        } else {
            System.out.println("OPSS!! Looks like you are not able to achieve your target CAP of " + targetCAP +
                    " with you target MCs of " + targetGradedMC + ".");
        }
    }

    private void setSUs() {
        Scanner in = new Scanner(System.in);
        int numberOfModules;
        System.out.println("How many modules did you take this semester?");
        numberOfModules = Integer.parseInt(in.nextLine());
        for (int i = 0; i < numberOfModules; i++) {
            System.out.println("What is the "+ getAbbreviations(i+1) +" module did you take?");
            String fullInputs = in.nextLine();
            String[] input = fullInputs.split(" ");
            Module moduleToSU = new Module(input[0],0,input[1],Integer.parseInt(input[2]));
            modulesListToSU.add(moduleToSU);
        }
        calculateSU();
    }

    private void calculateSU() {
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

    /**
     * Returns CAP score as a string
     *
     * @param academicPoint academic point to parse
     * @return string of academic point
     */
    private String formatCAPToString(double academicPoint) {
        return formatFinalCAP.format(academicPoint);
    }

    /**
     * Prints out current CAP and number of graded MCs
     */
    private void printCurrentCAP() {
        CAP currentCAP = CAPlist.get(0);
        System.out.println("Your current now CAP is: " + currentCAP.getCAP());
        System.out.println("Number of graded MCs taken is: " + currentCAP.getmoduleCredit());
    }

    /**
     * function to return the abbreviation for the number
     * @param number number to return the abbreviation for
     * @return string
     */
    private String getAbbreviations(int number) {
        if (number % 10 == 1 & number != 11) {
            return number + "st";
        } else if (number % 10 == 2 & number != 12) {
            return number + "nd";
        } else if (number % 10 == 3 & number != 13) {
            return number + "rd";
        } else {
            return number + "th";
        }
    }
}