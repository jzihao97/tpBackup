package model;

import moduledata.ModuleInitializer;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.Scanner;

public class Person {
    private String personName;
    private int semesterIndex;
    private ArrayList<Module> modulesList = new ArrayList<>();
    private ModuleInitializer allModules;

    public Person (String name, int semesterIndex) {
        personName = name;
        this.semesterIndex = semesterIndex;
        allModules =  new ModuleInitializer();
    }

    public void addModule() {
        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine(); //format "add cs1231"
        //check whether got module code
        String moduleCode = userInput.split(" ")[1].toUpperCase();
        if (allModules.getModuleMap().get(moduleCode) > -1) {
            System.out.println("Sem?");
            userInput = in.nextLine();
            int semesterValue = Integer.parseInt(userInput);
            System.out.println("Grade?");
            String gradeValue = in.nextLine();
            modulesList.add(new Module(moduleCode,semesterValue,gradeValue));
            System.out.println("Module added");
        }
        //add module if exists in our mod list
        //if not ask him do again
        //after confirming module is in list
        //prompt user for grade
            //A+ to F, or S, U, CSU, or NT for not taken
        //modulesList.add(MODULE)
        //failing which deal with exception
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
