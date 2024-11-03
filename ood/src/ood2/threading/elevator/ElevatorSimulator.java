package ood2.threading.elevator;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ConcurrentHashMap;

public class ElevatorSimulator {
    private int totalSimulationTime;
    private int ratePerSecond;
    private List<Passenger> passengers;
    private List<Elevator> elevators;
    private static final int NUM_ELEVATORS = 3;
    private ConcurrentHashMap<Integer, Integer> floorApproachingMap; // Map to track which floor is being approached by which elevator

    public ElevatorSimulator(int totalSimulationTime, int ratePerSecond, List<Passenger> passengers) {
        this.totalSimulationTime = totalSimulationTime;
        this.ratePerSecond = ratePerSecond;
        this.passengers = new CopyOnWriteArrayList<>(passengers);
        this.elevators = new CopyOnWriteArrayList<>();
        this.floorApproachingMap = new ConcurrentHashMap<>();

        for (int i = 0; i < NUM_ELEVATORS; i++) {
            elevators.add(new Elevator(i, passengers, floorApproachingMap));
        }
    }

    public void startSimulation() {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_ELEVATORS);

        for (Elevator elevator : elevators) {
            executorService.execute(elevator);
        }

        executorService.shutdown();

        try {
            Thread.sleep(totalSimulationTime * ratePerSecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Elevator elevator : elevators) {
            elevator.stopElevator();
        }
    }

    public static void main(String[] args) {
        ElevatorConfigReader reader = new ElevatorConfigReader("./src/resources/ElevatorConfig.txt");
        ElevatorSimulator simulator = new ElevatorSimulator(reader.getTotalSimulationTime(),
                reader.getRatePerSecond(), reader.getPassengers());
        simulator.startSimulation();
    }
}
