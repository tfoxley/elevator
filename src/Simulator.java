import java.io.Console;
import java.util.ArrayList;
import java.util.List;

/**
 * User: travis
 * Date: 3/5/15
 * Time: 7:21 AM
 */
public class Simulator {

    int numElevators;
    int numFloors;
    List<Elevator> elevators;

    public Simulator(int numElevators, int numFloors) {
        this.numElevators = numElevators;
        this.numFloors = numFloors;
        this.elevators = new ArrayList<Elevator>();
        initializeElevators(numElevators);
        handleRequests();
    }

    private void handleRequests() {
        Console console = System.console();
        if (console == null) {
            System.err.println("No console.");
            System.exit(1);
        }

        boolean run = true;
        while (run) {
            String input = console.readLine("Where are you and where would you like to go? (example: 1 3)\n");
            if (input.equalsIgnoreCase("exit")) {
                run = false;
            } else {
                String[] parts = input.split(" ");
                if (parts.length < 2) {
                    System.out.println("Please provide current floor and the floor you would like to go to separated by a space.");
                } else {
                    int at = Integer.parseInt(parts[0]);
                    int to = Integer.parseInt(parts[1]);

                    if (to < 1 || to > numFloors || at < 1 || at > numFloors) {
                        System.out.println("Invalid floor. Please try again.");
                    } else {
                        Elevator elevator = findClosest(at);
                        if (elevator == null) {
                            System.out.println("No elevators are in service. Please contact maintenance.");
                        } else {
                            elevator.move(at);
                            elevator.move(to);
                        }
                    }
                }
            }
        }
    }

    private void initializeElevators(int numElevators) {
        for (int i = 1; i <= numElevators; i++) {
            elevators.add(new Elevator(i));
        }
    }

    private Elevator findClosest(int at) {
        int distance = numFloors;
        Elevator bestElevator = null;
        for (Elevator elevator : elevators) {
            int curDist = Math.abs(elevator.getFloor() - at);
            if (curDist < distance && !elevator.isNeedsMaint()) {
                distance = curDist;
                bestElevator = elevator;
            }
        }
        return bestElevator;
    }
}
