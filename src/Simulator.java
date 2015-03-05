import java.io.Console;

/**
 * User: travis
 * Date: 3/5/15
 * Time: 7:21 AM
 */
public class Simulator {

    int numElevators;
    int numFloors;

    public Simulator(int numElevators, int numFloors) {
        this.numElevators = numElevators;
        this.numFloors = numFloors;
        handleRequests();
    }

    private void handleRequests() {
        Console console = System.console();
        if (console == null) {
            System.err.println("No console.");
            System.exit(1);
        }
        String input = console.readLine("Where are you and where would you like to go?\n");
        String[] parts = input.split(" ");
        int at = Integer.parseInt(parts[0]);
        int to = Integer.parseInt(parts[1]);
        System.out.println("From " + at + " to " + to);
    }
}
