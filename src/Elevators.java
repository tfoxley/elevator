import java.lang.Integer;

public class Elevators {
    public static void main(String [] args) {
        int numElevators = Integer.parseInt(args[0]);
        int numFloors = Integer.parseInt(args[1]);
        System.out.println("Starting elevator simulation with " + numElevators + " elevators and " + numFloors + " floors.");
    }
}