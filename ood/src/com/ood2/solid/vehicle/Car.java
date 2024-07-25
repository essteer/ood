package com.ood2.solid.vehicle;

public class Car extends AbstractVehicle implements LandVehicle {
    
	private int numberOfAxles;
    private double currentSpeedInLandMilesPerHour;

    public Car(int engineSize, boolean manualAssistance, boolean waterPowered, int numberOfAxles, double currentSpeedInLandMilesPerHour) {
        super(engineSize, manualAssistance, waterPowered);
        this.numberOfAxles = numberOfAxles;
        this.currentSpeedInLandMilesPerHour = currentSpeedInLandMilesPerHour;
    }

    @Override
    public int getNumberOfAxles() {
        return numberOfAxles;
    }

    @Override
    public double getCurrentSpeedInLandMilesPerHour() {
        return currentSpeedInLandMilesPerHour;
    }
}
