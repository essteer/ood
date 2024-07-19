package com.ood2.generics;

import java.util.ArrayList;
import java.util.List;

//public class Catalog<Type extends CatalogItem<?>> {
//==============================
//Itai's solution - class signature - body matches mine
//==============================
//Generic Catalog class with ID limited to numeric types
class Catalog<Type extends CatalogItem<ID>, ID extends Number> {

	private List<Type> items;

	public Catalog() {
		this.items = new ArrayList<>();
	}

	public void addItem(Type item) {
		this.items.add(item);
	}

	public Type findItem(Number id) {
		for (Type item : this.items) {
			if (item.getId().equals(id)) {
				return item;
			}
		}
		return null;
	}

}



