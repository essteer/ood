package com.ood2.generics;

// Generic type solution

//public class Borrower<Type> implements CatalogItem<Type> {
//
//	private Type id;
//	
//	public Borrower(Type id) {
//		this.id = id;
//	}
//	
//	public Type getId() {
//		return this.id;
//	}
//	
//	public void setId(Type id) {
//		this.id = id;
//	}
//
//}

// Numeric type solution
//public class Borrower<NumericType extends Number> implements CatalogItem<NumericType> {
//
//	private NumericType id;
//
//	public Borrower(NumericType id) {
//		this.id = id;
//	}
//
//	public NumericType getId() {
//		return this.id;
//	}
//
//	public void setId(NumericType id) {
//		this.id = id;
//	}
//
//	@Override
//	public String toString() {
//		return "Borrower [id=" + this.id + "]";
//	}
//}

//==============================
//Itai's solution
//==============================
//Borrower class implementing CatalogItem
class Borrower implements CatalogItem<Integer> {
	private Integer id;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}
}
