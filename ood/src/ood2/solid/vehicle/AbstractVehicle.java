package ood2.solid.vehicle;

public abstract class AbstractVehicle implements Vehicle {
	
	private int engineSize;
    private boolean manualAssistance;
    private boolean waterPowered;

    public AbstractVehicle(int engineSize, boolean manualAssistance, boolean waterPowered) {
        this.engineSize = engineSize;
        this.manualAssistance = manualAssistance;
        this.waterPowered = waterPowered;
    }

    @Override
    public int getEngineSize() {
        return engineSize;
    }

    @Override
    public boolean hasManualAssistance() {
        return manualAssistance;
    }

    @Override
    public boolean isWaterPowered() {
        return waterPowered;
    }

}
