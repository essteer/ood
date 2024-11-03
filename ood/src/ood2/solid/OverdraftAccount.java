package ood2.solid;

public interface OverdraftAccount extends Account {
	
	boolean hasOverdraft();
	void setOverdraftLimit(double limit);

}
