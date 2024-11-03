package ood2.solid.worker;

public class CommissionWorker extends SalariedWorker {
	
	private double commissionRate;
	
	public CommissionWorker(int id, String name, double salary, double rate) {
		super(id, name, salary);
		this.commissionRate = rate;
	}
	
	public double getCommissionRate() {
		return this.commissionRate;
	}
	
	public void setCommissionRate(double newRate) {
		this.commissionRate = newRate;
	}
	
}
