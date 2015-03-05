/**
 * User: travis
 * Date: 3/5/15
 * Time: 7:21 AM
 */
public class Elevator {
    private static final int ELEVATOR_DELAY = 1000;

    int floor;



    public Elevator() {
        floor = 1;
    }

    private void move(int toFloor) {
        if (toFloor < floor) {
            moveDown(toFloor);
        } else if (toFloor > floor) {
            moveUp(toFloor);
        } else {
            System.out.println("Already here!");
        }
    }

    private void moveUp(int toFloor) {
        System.out.println("Going up!");
        while (floor < toFloor) {
            try {
                Thread.sleep(ELEVATOR_DELAY);
            } catch (InterruptedException ie) {

            }
            floor++;
            announceFloor();
        }
    }

    private void moveDown(int toFloor) {
        System.out.println("Going down!");
        while (floor > toFloor) {
            try {
                Thread.sleep(ELEVATOR_DELAY);
            } catch (InterruptedException ie) {

            }
            floor--;
            announceFloor();
        }
    }

    private void announceFloor() {
        System.out.println("Currently on floor " + floor);
    }
}
