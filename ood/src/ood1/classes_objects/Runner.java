package ood1.classes_objects;

public class Runner {

	public static void main(String[] args) {
		
		HardDrive drive1 = new HardDrive("Seagate", 2048);
		HardDrive drive2 = new HardDrive("Dell", 3072, 500);
		
		Processor processor1 = new Processor("Intel Xeon", 2.93, 6);
		Processor processor2 = new Processor("Intel Celeron", 2.9, 2);
		
		Memory memory1 = new Memory("Kingston", 4, 1600);
		Memory memory2 = new Memory("Corsair", 8, 1333);
		
		System.out.println(drive1.getModel());
		System.out.println(drive1.getCapacity());
		System.out.println(drive1.getUsedSpace());
		System.out.println();
		System.out.println(drive2.getModel());
		System.out.println(drive2.getCapacity());
		System.out.println(drive2.getUsedSpace());
		System.out.println();
		System.out.println(processor1.getModel());
		System.out.println(processor1.getNumberOfCores());
		System.out.println(processor1.getSpeed());
		System.out.println();
		System.out.println(processor2.getModel());
		System.out.println(processor2.getNumberOfCores());
		System.out.println(processor2.getSpeed());
		System.out.println();
		System.out.println(memory1.getModel());
		System.out.println(memory1.getCapacity());
		System.out.println(memory1.getSpeed());
		System.out.println();
		System.out.println(memory2.getModel());
		System.out.println(memory2.getCapacity());
		System.out.println(memory2.getSpeed());

	}

}
