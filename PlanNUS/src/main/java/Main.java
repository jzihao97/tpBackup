import model.Person;
import moduledata.ModuleInitializer;

import model.CAPlist;
import moduledata.ModuleDatum;
import moduledata.ModuleInitializer;

import java.text.DecimalFormat;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ModuleInitializer allModules =  new ModuleInitializer();
        Person Bob = new Person("Bob" , 3, allModules);

//        System.out.println("Welcome to PlanNUS! Apps available are:\n" +
//                "  add <module code>\n" +
//                "  edit <module code>\n" +
//                "  remove <module code>\n" +
//                "Type a command to continue...");
//        Scanner scanner = new Scanner(System.in);
//        String fullInput = scanner.nextLine().toUpperCase();
//        String[] inputs = fullInput.split(" ");
//
//        while (!inputs[0].equals("EXIT")) {
//            if (inputs[0].equals("ADD")) {
//                addModule(scanner, inputs[1]);
//            } else if (inputs[0].equals("EDIT")) {
//                editModule(scanner, inputs[1]);
//            } else if (inputs[0].equals("REMOVE")) {
//                removeModule(inputs[1]);
//            } else {
//                System.out.println(ERROR_INVALID_COMMAND);
//            }
//
//            fullInput = scanner.nextLine().toUpperCase();
//            inputs = fullInput.split(" ");
//        }

        Bob.moduleTracker();

        CAPlist CAPlist = new CAPlist();
        CAPlist.setInitialCAP();
        CAPlist.setCurrentCAP();
        CAPlist.setTargetCAP();
//        CAPlist.setSUs(); WORK IN PROCESS!!
    }
}
