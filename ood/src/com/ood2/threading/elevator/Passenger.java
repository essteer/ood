package com.ood2.threading.elevator;

public class Passenger {
    private int currentFloor;
    private int destinationFloor;
    private int count;

    public Passenger(int currentFloor, int destinationFloor, int count) {
        this.currentFloor = currentFloor;
        this.destinationFloor = destinationFloor;
        this.count = count;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public int getCount() {
        return count;
    }
}
