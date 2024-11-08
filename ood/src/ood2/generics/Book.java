package ood2.generics;

// Generic type solution
//public class Book<Type> implements CatalogItem<Type> {
//	
//	private Type id;
//	
//	public Book(Type id) {
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
//}

// Numeric type solution
//public class Book<NumericType extends Number> implements CatalogItem<NumericType> {
//	
//	private NumericType id;
//	
//	public Book(NumericType id) {
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
//		return "Book [id=" + this.id + "]";
//	}
//
//}

//==============================
//Itai's solution
//==============================
//Book class implementing CatalogItem
class Book implements CatalogItem<Integer> {
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
