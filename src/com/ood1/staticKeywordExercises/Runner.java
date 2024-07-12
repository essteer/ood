package com.ood1.staticKeywordExercises;

public class Runner {

	public static void main(String[] args) {

		double matter = 10;
		double energy = 10;

		double matterToEnergy = EnergyMatterCalculator.matterToEnergy(matter);
		double energyToMatter = EnergyMatterCalculator.energyToMatter(energy);

		System.out.println("Matter to energy: " + matterToEnergy);
		System.out.println(matter * Math.pow(299792458, 2));
		System.out.println("Energy to matter: " + energyToMatter);
		System.out.println(energy / Math.pow(299792458, 2));
	}
}
