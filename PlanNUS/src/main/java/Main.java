import apps.AcademicPlanner;
import objects.Person;
import model.CAPlist;
import moduledata.ModuleInitializer;

import java.util.Scanner;

public class Main {
    private static final String ERROR_INVALID_COMMAND = "Sorry, invalid command";
    private static final String COMMAND_LIST = "\nWelcome to PlanNUS! Apps available are:\n" +
            "  Academic Planner (Use Command: acadPlan)\n" +
            "  CAP Calculator (Use Command: capCalc)\n" +
            "To exit PlanNUS, use command: \"exit\"\n" +
            "Type a command to continue...";

    public static void main(String[] args) {
        ModuleInitializer allModules =  new ModuleInitializer();
        Person Bob = new Person("Bob");

        System.out.println(COMMAND_LIST);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();

        while (!input.startsWith("exit")) {
            if (input.startsWith("acadplan")) {
                AcademicPlanner academicPlanner = new AcademicPlanner(allModules, Bob);
                academicPlanner.planner();
                System.out.println(COMMAND_LIST);
            } else if (input.startsWith("capcalc")) {
                CAPlist capList = new CAPlist(Bob);
                capList.CAPCalculator();
                System.out.println(COMMAND_LIST);
            } else {
                System.out.println(ERROR_INVALID_COMMAND);
            }
            input = scanner.nextLine().toLowerCase();
        }
    }
}
