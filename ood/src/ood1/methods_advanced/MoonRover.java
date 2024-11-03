package ood1.methods_advanced;

public class MoonRover {
	
	public static int roverMove(int size, String[] commands) {
		
		// Create new grid - an array of int[] rows
		int[][] grid = new int[size][size];
		// Create each row
		for (int i=0; i<size; i++) {
			// Each row is as long as the grid size
			int[] row = new int[size];
			// The starting number in each row
			int posNum = i * size;
			// Populate elements of each row
			for (int j = posNum; j< posNum + size; j++) {
			    // Add elements across row	
				row[j%size] = j; 
			}
			// Add row to grid
			grid[i] = row;
		}
		
		// Set starting coordinates
		int x = 0;
		int y = 0;
		// Iterate through commands
		for (String command : commands) {
			
			if (command.equals("UP") && x > 0) {
				x -= 1;
			}
			else if (command.equals("DOWN") && x < size - 1) {
				x += 1;
			}
			else if (command.equals("LEFT") && (y % size) > 0) {
				y -= 1;
			}
			else if (command.equals("RIGHT") && (y % size) < size - 1) {
				y += 1;
			}
		}
		// Return final position
		return grid[x][y];
	}
}
