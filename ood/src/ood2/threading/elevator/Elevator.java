package ood2.threading.elevator;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class Elevator implements Runnable {
    private int id;
    private int currentFloor;
    private boolean running;
    private List<Passenger> passengers;
    private List<Passenger> onboardPassengers;
    private ConcurrentHashMap<Integer, Integer> floorApproachingMap;

    public Elevator(int id, List<Passenger> passengers, ConcurrentHashMap<Integer, Integer> floorApproachingMap) {
        this.id = id;
        this.currentFloor = 0;
        this.running = true;
        this.passengers = passengers;
        this.onboardPassengers = new CopyOnWriteArrayList<>();
        this.floorApproachingMap = floorApproachingMap;
    }

    @Override
    public void run() {
        System.out.println("Elevator " + id + " started.");
        while (running) {
            if (onboardPassengers.isEmpty()) {
                loadPassengers();
            } else {
                dropOffPassengers();
            }
        }
        System.out.println("Elevator " + id + " stopped.");
    }

    private void loadPassengers() {
        synchronized (passengers) {
            Passenger nextPassenger = null;
            for (Passenger p : passengers) {
                if ((nextPassenger == null || Math.abs(p.getCurrentFloor() - currentFloor) < Math.abs(nextPassenger.getCurrentFloor() - currentFloor))
                        && !floorApproachingMap.containsKey(p.getCurrentFloor())) {
                    nextPassenger = p;
                }
            }

            if (nextPassenger != null) {
                floorApproachingMap.put(nextPassenger.getCurrentFloor(), id);
                moveToFloor(nextPassenger.getCurrentFloor());
                onboardPassengers.add(nextPassenger);
                passengers.remove(nextPassenger);
                floorApproachingMap.remove(nextPassenger.getCurrentFloor());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void dropOffPassengers() {
        Passenger nextDropOff = onboardPassengers.get(0);
        moveToFloor(nextDropOff.getDestinationFloor());
        onboardPassengers.remove(nextDropOff);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void moveToFloor(int floor) {
        while (currentFloor != floor) {
            if (currentFloor < floor) {
                currentFloor++;
            } else {
                currentFloor--;
            }

            System.out.println("Elevator " + id + " is on floor " + currentFloor);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopElevator() {
        running = false;
    }
}
