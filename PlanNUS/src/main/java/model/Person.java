package model;

import moduledata.ModuleInitializer;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Person {
    private String personName;
    private int semesterIndex;
    private ArrayList<Module> modulesList = new ArrayList<>();
    private HashMap<String,Module> modulesAddedMap = new HashMap<>(); // to check if modules has already been added
    private ModuleInitializer allModules;

    //CONSTANTS
    private final int STARTING_SEMESTER_INDEX = 1;
    private final int FINAL_SEMESTER_INDEX = 10;
    private final String ERROR_INVALID_COMMAND = "INVALID COMMAND";
    private final String ERROR_INVALID_SEMESTER_INDEX = "INVALID SEMESTER INDEX";
    private final String ERROR_INVALID_GRADE = "INVALID GRADE VALUE";
    private final String ERROR_NOT_OFFERED = " IS NOT OFFERED BY NUS";
    private final String ERROR_DUPLICATE_MOD = "You already have this mod on your calendar!";
    private final String ERROR_NOT_ADDED = "You have not added this module into your list yet";
    private final String ERROR_EDIT_OPTION = "Number entered does not correspond to any feature";


    //Setter and Getter
    public Person (String name, int semesterIndex, ModuleInitializer allModules) {
        setPersonName(name);
        setSemesterIndex(semesterIndex);
        this.allModules =  allModules;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getSemesterIndex() {
        return semesterIndex;
    }

    public void setSemesterIndex(int semesterIndex) {
        if (checkValidSemester(semesterIndex)) {
            this.semesterIndex = semesterIndex;
        } else {
            System.out.println(ERROR_INVALID_SEMESTER_INDEX);
        }
    }

    public ArrayList<Module> getModulesList() {
        return modulesList;
    }

    public HashMap<String, Module> getModulesAddedMap() {
        return modulesAddedMap;
    }


    //Main methods
    public String commandsList() {
        String commands = "  add <module code>\n" +
                "  edit <module code>\n" +
                "  remove <module code>\n" +
                "Type a command to continue...";
        return commands;
    }

    public void moduleTracker() {
        System.out.println("Welcome to Module Tracker! Commands available are:\n" +
                commandsList());

        Scanner scanner = new Scanner(System.in);
        String fullInput = scanner.nextLine().toUpperCase();
        String[] inputs = fullInput.split(" ");

        while (!inputs[0].equals("EXIT")) {
            if (inputs[0].equals("ADD")) {
                addModule(scanner, inputs[1]);
            } else if (inputs[0].equals("EDIT")) {
                editModule(scanner, inputs[1]);
            } else if (inputs[0].equals("REMOVE")) {
                removeModule(inputs[1]);
            } else {
                System.out.println(ERROR_INVALID_COMMAND);
            }
            System.out.println(commandsList());
            fullInput = scanner.nextLine().toUpperCase();
            inputs = fullInput.split(" ");
        }
    }

    /**
     * Adds a module to the user's academic calendar if it exists in ModuleDatum,
     * else does not add module into user's academic calendar.
     * Validates user's input semester and grade.
     * If either is invalid, does not add module into user's academic calendar.
     */
    private void addModule(Scanner in, String moduleCode) {
//        String userInput = in.nextLine(); //format "add cs1231"
//        if (!checkValidAddCommand(userInput)) {
//            System.out.println(ERROR_INVALID_COMMAND);
//            return;
//        }
        try {
//            String moduleCode = userInput.split(" ")[1].toUpperCase();
            if (checkIfModOfferedByNUS(moduleCode)) {
                if (checkIfModTaken(moduleCode)) {
                    System.out.println(ERROR_DUPLICATE_MOD);
                }

                System.out.println("Semester you plan to take " + moduleCode.toUpperCase() + "?");
                String userInput = in.nextLine();
                int semesterValue = Integer.parseInt(userInput);

                if (!checkValidSemester(semesterValue)) {
                    System.out.println(ERROR_INVALID_SEMESTER_INDEX);
                    return;
                }

                System.out.println("Grade received for " + moduleCode.toUpperCase() +"?");
                String gradeValue = in.nextLine();
                if (!checkValidGrade(gradeValue)) {
                    System.out.println(ERROR_INVALID_GRADE);
                    return;
                }
                int moduleCredit = getModuleCreditForModule(moduleCode);
                Module newModuleToAdd = new Module(moduleCode, semesterValue, gradeValue, moduleCredit);
                modulesList.add(newModuleToAdd);
                modulesAddedMap.put(moduleCode,newModuleToAdd);
                System.out.println(newModuleToAdd.getModuleCode()
                        + " added into Semester " + semesterValue + ".");
            } else {
                System.out.println(moduleCode + ERROR_NOT_OFFERED);
            }
        } catch (Exception e) {
            System.out.println(ERROR_INVALID_COMMAND);
        }
    }

    /**
     * Allows user to edit the module entry of his academic calendar.
     * Parameters allowed to change are semesterIndex or Grade.
     */
    private void editModule(Scanner in, String moduleCode) {
        try {
            if (checkIfModTaken(moduleCode)) {
                System.out.println("Enter the number corresponding to the feature you wish to edit:" +
                        "\n1) Semester\n2) Grade");
                String choice = in.nextLine();
                if (choice.equals("1")) {
                    System.out.println("Enter the new semester value: ");
                    String newValue = in.nextLine();
                    if (!checkValidSemester(Integer.parseInt(newValue))) {
                        System.out.println(ERROR_INVALID_SEMESTER_INDEX);
                        return;
                    }
                    for (Module item : modulesList) {
                        if (item.getModuleCode().equals(moduleCode)) {
                            item.setSemesterIndex(Integer.parseInt(newValue));
                            break;
                        }
                    }
                    modulesAddedMap.get(moduleCode).setSemesterIndex(Integer.parseInt(newValue));
                    System.out.println("Semester for " + moduleCode + " successfully updated!");
                } else if (choice.equals("2")) {
                    System.out.println("Enter the new grade: ");
                    String gradeValue = in.nextLine();
                    if (!checkValidGrade(gradeValue)) {
                        System.out.println(ERROR_INVALID_GRADE);
                        return;
                    }
                    for (Module item : modulesList) {
                        if (item.getModuleCode().equals(moduleCode)) {
                            item.setGrade(gradeValue);
                            break;
                        }
                    }
                    modulesAddedMap.get(moduleCode).setGrade(gradeValue);
                    System.out.println("Grade for " + moduleCode + " successfully updated!");
                } else {
                    System.out.println(ERROR_EDIT_OPTION);
                }
            } else {
                System.out.println(ERROR_NOT_ADDED);
            }
        } catch (Exception e) {
            System.out.println(ERROR_INVALID_COMMAND);
        }
    }

    /**
     * Removes moduleCode from user's academic calendar if it exists,
     * else prompts user of error.
     */
    private void removeModule(String moduleCode) {
        try {
            if (checkIfModTaken(moduleCode)) {
                modulesAddedMap.remove(moduleCode);
                for (Module item : modulesList) {
                    if (item.getModuleCode().equals(moduleCode)) {
                        System.out.println(item.getModuleCode() + " has been removed from the list");
                        modulesList.remove(item);
                        break;
                    }
                }
            } else {
                System.out.println(ERROR_NOT_ADDED);
            }
        } catch (Exception e) {
            System.out.println(ERROR_INVALID_COMMAND);
        }
    }


    //Helper functions
    /**
     * Function to return module credits for module code
     *
     * @param moduleCode string of module code
     * @return int of module credit
     */
    private int getModuleCreditForModule(String moduleCode) {
        int mapIndex = allModules.getModuleMap().get(moduleCode);
        return allModules.getModuleFullDetails()[mapIndex].getModuleCredit();
    }

    /**
     * Returns true if module code is offered by NUS,
     * else returns false.
     * @param moduleCode input module code
     * @return boolean of module code in ModuleDatum
     */
    private boolean checkIfModOfferedByNUS(String moduleCode) {
        return (allModules.getModuleMap().get(moduleCode) > -1);
    }

    /**
     * Returns tru if module is in the user's academic calendar
     * else returns false.
     *
     * @param moduleCode moduleCode to check
     * @return boolean
     */
    private boolean checkIfModTaken(String moduleCode) {
        return (modulesAddedMap.containsKey(moduleCode));
    }

    /**
     * Returns true if grade is a Grade option offered by NUS,
     * else returns false.
     *
     * @param grade grade to check
     * @return boolean
     */
    private boolean checkValidGrade(String grade) {
        switch (grade.toUpperCase()) {
        case "A+":
            //Fallthrough
        case "A":
            //Fallthrough
        case "A-":
            //Fallthrough
        case "B+":
            //Fallthrough
        case "B":
            //Fallthrough
        case "B-":
            //Fallthrough
        case "C+":
            //Fallthrough
        case "C":
            //Fallthrough
        case "D+":
            //Fallthrough
        case "D":
            //Fallthrough
        case "F":
            //Fallthrough
        case "CS":           //Completed Satisfactorily
            //Fallthrough
        case "CU":           //Completed Unsatisfactorily
            //Fallthrough
        case "S":            //Satisfactory
            //Fallthrough
        case "U":            //Unsatisfactory
            //Fallthrough
        case "W":            //Withdrawn
            //Fallthrough
        case "IC":           //Incomplete
            //Fallthrough
        case "IP":           //In progress
            //Fallthrough
        case "AUD":          //Audit
            //Fallthrough
        case "WU":           //Withdrawn from University
            //Fallthrough
        case "EXE" :         //Exempted
            //Fallthrough
        case "NT":           //Not taken
            return true;
        default:
            return false;
        }
    }

    /**
     * Returns true if semsesterIndex is a valid semesterIndex
     * else returns false
     *
     * @param semesterIndex semesterIndex to check
     * @return false
     */
    private boolean checkValidSemester (int semesterIndex) {
        return (semesterIndex >= STARTING_SEMESTER_INDEX && semesterIndex <= FINAL_SEMESTER_INDEX);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Prints all mods in the module list
     */
    public void printList() {
        for (Module module : modulesList) {
            System.out.println(module.getModuleCode());
            System.out.println(module.getSemesterIndex());
            System.out.println(module.getGrade());
            System.out.println("MC: " + module.getModuleCredit());
        }
    }

    /**
     * Returns true if input is a valid add command,
     * else returns false.
     *
     * @param userInput user's input
     * @return boolean of valid command
     */
//    private boolean checkValidAddCommand(String userInput) {
//        return userInput.toLowerCase().startsWith("add");
//    }

    /**
     * Returns true if userInput is a valid edit command,
     * else returns false.
     *
     * @param userInput user's input
     * @return boolean
     */
//    private boolean checkValidEditCommand(String userInput) {
//        return userInput.toLowerCase().startsWith("edit");
//    }

    /**
     * Returns true if command is a valid delete command,
     * else returns false.
     *
     * @param userInput user's input
     * @return boolean
     */
//    private boolean checkValidDeleteCommand(String userInput) {
//        return userInput.toLowerCase().startsWith("delete");
//    }
}
