package nusplan;

import java.util.Scanner;
import static nusplan.function.UserGreeter.showWelcomeMessage;
import static nusplan.function.UserGreeter.showExitMessage;

public class nusPLAN {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        showWelcomeMessage();
        System.out.println("What is your name?");

        Scanner in = new Scanner(System.in);
        System.out.println("Hello " + in.nextLine());

        showExitMessage();
    }
}
