package model;

import moduledata.ModuleInitializer;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//search
//check duplicate

public class Person {
    private String personName;
    private int semesterIndex;
    private ArrayList<Module> modulesList = new ArrayList<>();
    private HashMap<String,Module> modulesAddedMap; // to check if modules has already been added
    private ModuleInitializer allModules;

    public Person (String name, int semesterIndex) {
        personName = name;
        this.semesterIndex = semesterIndex;
        allModules =  new ModuleInitializer();
    }

    public void addModule() {
        //add module if exists in our mod list
        //if not ask him do again
        //after confirming module is in list
        //prompt user for grade
        //A+ to F, or S, U, CSU, or NT for not taken
        //modulesList.add(MODULE)
        //failing which deal with exception

        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine(); //format "add cs1231"
        if (!checkValidAddCommand(userInput)) {
            System.out.println("Invalid ADD command!");
            return;
        }
        //check whether got module code
        try {
            String moduleCode = userInput.split(" ")[1].toUpperCase();
            if (checkIfModOfferedByNUS(moduleCode)) { //means module exists
//                if (checkIfModDuplicated(moduleCode)) { //means user already added
//                    System.out.println("You already have this mod on your calendar!");
//                }
                System.out.println("Semester you plan to take " +moduleCode.toUpperCase() + "?");
                userInput = in.nextLine();
                int semesterValue = Integer.parseInt(userInput);
                System.out.println("Grade (if applicable)?");
                String gradeValue = in.nextLine();
                Module newModuleToAdd = new Module(moduleCode, semesterValue, gradeValue);
                modulesList.add(newModuleToAdd);
                modulesAddedMap.put(moduleCode,newModuleToAdd);
                System.out.println(newModuleToAdd.getModuleCode() + " added.");
            } else { //module not offered by NUS
                System.out.println(moduleCode + " IS NOT OFFERED BY NUS");
            }
        } catch (Exception e) {
            System.out.println("Invalid command");
        }
    }

    public boolean checkValidAddCommand(String userInput) {
        return userInput.toLowerCase().startsWith("add");
    }

    public boolean checkIfModOfferedByNUS(String moduleCode) {
        return (allModules.getModuleMap().get(moduleCode) > -1);
    }

    public boolean checkIfModDuplicated(String moduleCode) {
        return (modulesAddedMap.containsKey(moduleCode));
    }

    public void removeModule(String moduleCode) {
        //check if the hash map has moduleCode as Key
        //if have, remove and print out confirmation of removal
            //module code removed, which sem it was in
        //if dont have, ask him do again
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public void printList() {
        for (Module module : modulesList) {
            System.out.println(module.getModuleCode());
            System.out.println(module.getSemesterIndex());
            System.out.println(module.getGrade());
        }
    }

    //main method
}
