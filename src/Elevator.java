/**
 * User: travis
 * Date: 3/5/15
 * Time: 7:21 AM
 */
public class Elevator {
    private static final int ELEVATOR_DELAY = 1000;

    private int id;
    private int floor;
    private boolean doorsOpen;
    private int numTrips;
    private boolean needsMaint;


    public Elevator(int id) {
        this.id = id;
        this.floor = 1;
        this.doorsOpen = false;
        this.numTrips = 0;
        this.needsMaint = false;
        System.out.println("Elevator " + id + " is now online.");
    }

    public void move(int toFloor) {
        if (doorsOpen) {
            closeDoors();
        }
        if (toFloor < floor) {
            moveDown(toFloor);
        } else if (toFloor > floor) {
            moveUp(toFloor);
        } else {
            System.out.println("Elevator " + id + " already here!");
        }
        openDoors();
        numTrips++;
        if (numTrips > 99) {
            needsMaint = true;
            closeDoors();
        }
    }

    private void moveUp(int toFloor) {
        System.out.println("Elevator " + id + " Going up!");
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
        System.out.println("Elevator " + id + " Going down!");
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
        System.out.println("Elevator " + id + " currently on floor " + floor);
    }

    private void openDoors() {
        System.out.println("Elevator " + id + " doors opening.");
        doorsOpen = true;
    }

    private void closeDoors() {
        System.out.println("Elevator " + id + " doors closing.");
        doorsOpen = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public boolean isDoorsOpen() {
        return doorsOpen;
    }

    public void setDoorsOpen(boolean doorsOpen) {
        this.doorsOpen = doorsOpen;
    }

    public int getNumTrips() {
        return numTrips;
    }

    public void setNumTrips(int numTrips) {
        this.numTrips = numTrips;
    }

    public boolean isNeedsMaint() {
        return needsMaint;
    }

    public void setNeedsMaint(boolean needsMaint) {
        this.needsMaint = needsMaint;
    }
}
