package ood2.generics;

public class Pair<T> {
	
	private T firstElementOfPair;
	private T secondElementOfPair;
	
	public Pair(T firstElement, T secondElement) {
		this.firstElementOfPair = firstElement;
		this.secondElementOfPair = secondElement;
	}
	
	public T getFirstElement() {
		return this.firstElementOfPair;
	}
	
	public T getSecondElement() {
		return this.secondElementOfPair;
	}
	
	public void setFirstElement(T element) {
		this.firstElementOfPair = element;
	}
	
	public void setSecondElement(T element) {
		this.secondElementOfPair = element;
	}

}
