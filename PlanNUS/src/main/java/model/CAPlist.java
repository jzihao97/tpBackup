package model;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import capcalcexceptions.IllegalCAPException;
import static model.Person.getModulesList;

public class CAPlist {
    private final ArrayList<Module> bobModuleList = getModulesList();
    private final ArrayList<Module> modulesListToSU = new ArrayList<>();
    private final ArrayList<CAP> CAPlist = new ArrayList<>();
    private final DecimalFormat formatFinalCAP = new DecimalFormat("#.##");
    private int numberOfCAP;

    //CONSTANTS
    private final String ERROR_INVALID_COMMAND = "INVALID COMMAND";
    private final String ILLEGAL_CAP_MESSAGE = "ILLEGAL CAP! Your CAP should not be more than 5.00.";
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
        setNumberOfCAP(0);
    }

    //Getter and Setter
    public void setNumberOfCAP(int numberOfCAP) {
        this.numberOfCAP = numberOfCAP;
    }

    public int getNumberOfCAP() {
        return numberOfCAP;
    }

    public double getTotalAcademicPoints() {
        double totalAcademicPoints = 0.00;
        for (CAP cap : CAPlist) {
            if (cap.getCAP() > 0) {
                totalAcademicPoints += cap.getCAP() * cap.getmoduleCredit();
            }
        }
        return totalAcademicPoints;
    }

    public int getTotalModuleCredit() {
        int totalModuleCredit = 0;
        for (CAP cap : CAPlist) {
            if (cap.getCAP() > 0) {
                totalModuleCredit += cap.getmoduleCredit();
            }
        }
        return totalModuleCredit;
    }

    //Main Function
    public void CAPCalculator() {
        System.out.println(WELCOME_MESSAGE);
                setInitialCAP();
        System.out.println(AWAIT_COMMAND);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toUpperCase();
        formatFinalCAP.setRoundingMode(RoundingMode.UP);

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
     * This function reads the list of modules that the user have taken and set the initial CAP and graded MCs.
     * If user did not take any module,set the initial CAP and graded MCs to be 0.
     */
    private void setInitialCAP() {
        try {
            if (!bobModuleList.isEmpty()) {
                for (Module module : bobModuleList) {
                    CAP currentCAP = new CAP(module.getCAP(), module.getModuleCredit());
                    CAPlist.add(currentCAP);
                    setNumberOfCAP(getNumberOfCAP() + 1);
                }
            } else {
                CAP currentCAP = new CAP(0, 0);
                CAPlist.add(currentCAP);
                setNumberOfCAP(getNumberOfCAP() + 1);
            }
        }catch (IllegalCAPException e) {
            System.out.println(ILLEGAL_CAP_MESSAGE);
        }
        printCurrentCAP();
    }

    /**
     * Allows the user to modify his or her current CAP and graded MCs.
     */
    private void setCurrentCAP() {
        Scanner in = new Scanner(System.in);
        try {
            CAP currentCAP = new CAP(0.00, 0);

            System.out.println("What is your current CAP?");
            currentCAP.setCAP(Double.parseDouble(in.nextLine()));

            System.out.println("How many graded MCs have you taken?");
            currentCAP.setmoduleCredit(Integer.parseInt(in.nextLine()));

            CAPlist.clear();
            CAPlist.add(currentCAP);
            System.out.println("Done!");
            printCurrentCAP();
        } catch (NullPointerException e) {
            System.out.println(ERROR_INVALID_COMMAND);
            System.out.println(AWAIT_COMMAND);
        } catch (NumberFormatException e){
            System.out.println(ERROR_INVALID_COMMAND);
            System.out.println(AWAIT_COMMAND);
        } catch (IllegalCAPException e) {
            System.out.println(ILLEGAL_CAP_MESSAGE);
            System.out.println(AWAIT_COMMAND);
        }
    }

    /**
     * Allow the user to set the target CAP that he or she want to achieve in the next given MCs.
     */
    private void setTargetCAP() {
        Scanner in = new Scanner(System.in);
        try {
            CAP targetCAP = new CAP(0.00,0);
            System.out.println("What is your target CAP?");
            targetCAP.setCAP(Double.parseDouble(in.nextLine()));

            System.out.println("How many graded MCs you are taking to achieve the target CAP?");
            targetCAP.setmoduleCredit(Integer.parseInt(in.nextLine()));

            calculateResults(getTotalAcademicPoints(), targetCAP.getCAP(), getTotalModuleCredit(),
                    targetCAP.getmoduleCredit());
        } catch(NullPointerException e) {
            System.out.println(ERROR_INVALID_COMMAND);
            System.out.println(AWAIT_COMMAND);
        } catch (IllegalCAPException e) {
            System.out.println(ILLEGAL_CAP_MESSAGE);
            System.out.println(AWAIT_COMMAND);
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
            System.out.println("OOPS!! Looks like you are not able to achieve your target CAP of " + targetCAP +
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
        double totalCAP = getTotalAcademicPoints() * getTotalModuleCredit();
        int totalGradedMCs = getTotalModuleCredit();
        double bestCAP = totalCAP;
        int bestGradedMCs = getTotalModuleCredit();
        int numberOfModulesToSU = 0;

        ModuleSorter moduleSorter = new ModuleSorter(modulesListToSU);
        ArrayList<Module> sortedModuleList = moduleSorter.getSortedModuleByGrades();

        for (Module module:modulesListToSU) {
            totalCAP += module.getCAP() * module.getModuleCredit();
            totalGradedMCs += module.getModuleCredit();
        }

        System.out.println("Your CAP without S/U any module is: " +
                formatCAPToString(totalCAP/(double)totalGradedMCs));
        System.out.println("Your graded MCs without S/U any module is: " + totalGradedMCs);

        for (Module module:sortedModuleList) {
            totalCAP -= module.getCAP() * module.getModuleCredit();
            totalGradedMCs -= module.getModuleCredit();
            System.out.println("S/U your module of " + module.getModuleCode() + " with grade " +module.getGrade()
                    + " will give you a CAP of: " + formatCAPToString(totalCAP/(double)totalGradedMCs));
            System.out.println("Your graded MCs after S/Uing this module is: " + totalGradedMCs);
            if (bestCAP < (totalCAP/(double)totalGradedMCs)) {
                bestCAP = totalCAP/(double)totalGradedMCs;
                bestGradedMCs = totalGradedMCs;
                numberOfModulesToSU++;
            }
        }
        System.out.println("Your highest CAP possible is: " + formatCAPToString(bestCAP)
                + " with a graded MC of " + bestGradedMCs);
        System.out.println("The modules you should be S/Uing are:");
        for (int i = 0 ; i<numberOfModulesToSU; i++) {
            Module SUModule = sortedModuleList.get(i);
            System.out.println(SUModule.getModuleCode() + " with grade " + SUModule.getGrade() +
                    " and modular credit of " + SUModule.getModuleCredit() + ".");
        }
    }

    /**
     * Returns CAP score as a string
     *
     * @param academicPoint academic point to parse
     * @return string of academic point
     */
    private String formatCAPToString(double academicPoint) {
        if (isNaN(academicPoint)) {
            return "0";
        }
        return formatFinalCAP.format(academicPoint);
    }

    /**
     * Prints out current CAP and number of graded MCs
     */
    private void printCurrentCAP() {
        double currentCAP = getTotalAcademicPoints()/(double)getTotalModuleCredit();
        System.out.println("Your current now CAP is: " + formatCAPToString(currentCAP));
        System.out.println("Number of graded MCs taken is: " + getTotalModuleCredit());
    }

    /**
     * function to return the abbreviation for the number
     *
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

    public boolean isNaN(double academicPoint) {
        return (academicPoint != academicPoint);
    }
}