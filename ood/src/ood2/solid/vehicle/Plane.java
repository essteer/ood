package ood2.solid.vehicle;

public class Plane extends AbstractVehicle implements Flyable {
    
	private boolean abilityToFly;

    public Plane(int engineSize, boolean manualAssistance, boolean waterPowered, boolean abilityToFly) {
        super(engineSize, manualAssistance, waterPowered);
        this.abilityToFly = abilityToFly;
    }

    @Override
    public boolean canFly() {
        return abilityToFly;
    }
}
