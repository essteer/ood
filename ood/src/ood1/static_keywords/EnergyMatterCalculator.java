package ood1.static_keywords;

public class EnergyMatterCalculator {
	
	public static final double SPEED_OF_LIGHT = 299792458;
	
	public static double matterToEnergy(double matter) {
		return matter * Math.pow(SPEED_OF_LIGHT, 2);
	}
	
	public static double energyToMatter(double energy) {
		return energy / Math.pow(SPEED_OF_LIGHT, 2);
	}

}
