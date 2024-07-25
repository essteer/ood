package com.ood2.solid.vehicle;

public class Boat extends AbstractVehicle implements WaterVehicle {
    
	private double currentSpeedInNauticalMilesPerHour;

    public Boat(int engineSize, boolean manualAssistance, boolean waterPowered, double currentSpeedInNauticalMilesPerHour) {
        super(engineSize, manualAssistance, waterPowered);
        this.currentSpeedInNauticalMilesPerHour = currentSpeedInNauticalMilesPerHour;
    }

    @Override
    public double getCurrentSpeedInNauticalMilesPerHour() {
        return currentSpeedInNauticalMilesPerHour;
    }
}
