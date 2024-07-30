package com.ood2.threading.elevator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ElevatorConfigReader {
    private int totalSimulationTime;
    private int ratePerSecond;
    private List<Passenger> passengers;

    public ElevatorConfigReader(String filename) {
        passengers = new ArrayList<>();
        readConfig(filename);
    }

    private void readConfig(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            totalSimulationTime = Integer.parseInt(br.readLine());
            ratePerSecond = Integer.parseInt(br.readLine());
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                int currentFloor = parseFloor(parts[0]);
                int destinationFloor = parseFloor(parts[1]);
                int count = Integer.parseInt(parts[2]);
                passengers.add(new Passenger(currentFloor, destinationFloor, count));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int parseFloor(String floor) {
        if (floor.equalsIgnoreCase("G")) {
            return 0;
        } else {
            return Integer.parseInt(floor);
        }
    }

    public int getTotalSimulationTime() {
        return totalSimulationTime;
    }

    public int getRatePerSecond() {
        return ratePerSecond;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }
}

