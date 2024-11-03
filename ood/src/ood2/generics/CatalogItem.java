package ood2.generics;

// Generic type solution
//public interface CatalogItem<Type> {
//	
//	public Type getId();
//	public void setId(Type id);
//
//}

// Numeric type solution
//public interface CatalogItem<NumericType extends Number> {
//	
//	public NumericType getId();
//	public void setId(NumericType id);
//
//}
 
// ==============================
// Itai's solution
// ==============================
// Interface for CatalogItem with a generic ID type
interface CatalogItem<ID extends Number> {
    ID getId();
    void setId(ID id);
}
