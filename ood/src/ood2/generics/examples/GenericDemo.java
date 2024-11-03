package ood2.generics.examples;

public class GenericDemo {

	public static void main(String[] args) {
		
		GenericList<Food> todo = new GenericList<>();
		// Add items
		todo.add_item(new Food("bananas"));
		todo.add_item(new Food("bread"));
		todo.add_item(new Food("butter"));
		todo.add_item(new Food("eggs"));
		// todo.add_item(new Food("milk"));
		Food milk = new Food("milk");
		todo.add_item(milk);

		// Print
		System.out.println("My to do list for today:");
		todo.print_list();
		
		// After buying milk, remove it from the list
		todo.remove_item(milk);
		// todo.remove_item(new Food("milk"));
		
		// Print
		System.out.println("\nBought milk. Current to do list:");
		todo.print_list();
		
		// Add another bacon
		append(todo, new Food("bacon"));
		System.out.println("\nAdded bacon. Current to do list:");
		todo.print_list();
	}

	// Generic method 
	public static <T> void append(GenericList<T> list, T item) {
		list.add_item(item);
	}

}