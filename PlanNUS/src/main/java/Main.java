import model.Person;
import model.CAPlist;
import moduledata.ModuleInitializer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String ERROR_INVALID_COMMAND = "Sorry, invalid command";

        ModuleInitializer allModules =  new ModuleInitializer();
        Person Bob = new Person("Bob" , 3, allModules);

        System.out.println("Welcome to PlanNUS! Apps available are:\n" +
                "  Module Tracker (Use Command: modTrack)\n" +
                "  CAP Calculator (Use Command: capCalc)\n" +
                "To exit PlanNUS, use command: \"exit\"\n" +
                "Type a command to continue...");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();

        while (!input.startsWith("exit")) {
            if (input.startsWith("modtrack")) {
                Bob.moduleTracker();
            } else if (input.startsWith("capcalc")) {
                CAPlist capList = new CAPlist();
                capList.CAPCalculator();
            } else {
                System.out.println(ERROR_INVALID_COMMAND);
            }
            input = scanner.nextLine().toLowerCase();
        }
    }
}
