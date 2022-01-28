public class Life {
	private String grid[][];
	private int dY;
	private int dX;
	private double probability;
	public Life() {
		dX = 50;
		dY = 50;
		grid = new String[dX][dY];
		probability = 0.25;
		build();
		print();
	}
	public Life(int x, int y, double chance) {
		dX = x;
		dY = y;
		grid = new String[x][y];
		probability = chance;
		build();
		print();
	}
	public void build() {
		for(int row = 0; row < grid.length; row++) {
			for(int col = 0; col < grid[row].length; col++) {
				double random = Math.random();
				if (random <= 0.25) {
					grid[row][col] = "*";
				}
				else {
					grid[row][col] = " ";
				}
			}
		}
	}
	public boolean isAlive(int x, int y) {
		String val = grid[x][y];
		if (val.equals("*")) {
			return true;
		}
		return false;
	}
	public void nextGeneration(){
		String newMatrix[][] = new String[dX][dY];
		for(int row = 0; row < grid.length; row++) {
			for(int col = 0; col < grid[row].length; col++) {
				int nCount = 0;
				
				// Checks if the one below is alive
				if(row + 1 < grid.length) {
					if(isAlive(row + 1, col)) {
						nCount += 1;
					}
				}
				// Checks if the one above is alive
				if(row -1 >= 0) {
					if(isAlive(row - 1, col)) {
						nCount += 1;
					}
				}
				// Checks if the one to the left is alive
				if(col - 1 >= 0) {
					if(isAlive(row, col-1)) {
						nCount += 1;
					}
				}
				// Checks if the one to the right is alive
				if(col + 1 < grid[row].length) {
					if(isAlive(row, col+1)) {
						nCount += 1;
					}
				}
				
				// Checks if up and to the left is alive
				if(row - 1 >= 0 && col - 1 >= 0) {
					if(isAlive(row-1, col-1)) {
						nCount += 1;
					}
				}
				// Checks if up and to the right is alive
				if(row - 1 >= 0 && col + 1 < grid[row].length) {
					if(isAlive(row-1, col+1)) {
						nCount += 1;
					}
				}
				// Checks if below and to the left is alive
				if(row + 1 < grid.length && col - 1 >= 0) {
					if(isAlive(row+1, col-1)) {
						nCount += 1;
					}
				}
				// Checks if below and to the right is alive
				if(row + 1 < grid.length && col + 1 < grid[row].length) {
					if(isAlive(row+1, col+1)) {
						nCount += 1;
					}
				}
				// Determines if spot lives or dies
				if(isAlive(row, col)) {
					if(nCount == 2 || nCount == 3) {
						newMatrix[row][col] = "*";
					}
					else {
						newMatrix[row][col] = " ";
					}
				}
				else {
					if(nCount == 3) {
						newMatrix[row][col] = "*";
					}
					else {
						newMatrix[row][col] = " ";
					}
				}
			}
		}
		System.out.println("------------");
		grid = newMatrix;
		print();
	}
	public void print() {
		System.out.print(toString());
	}
	public void println(String str) {
		System.out.print("\n" + str + "\n");
	}
	public String toString() {
		String msg = "";
		for(int row = 0; row < grid.length; row++) {
			for(int col = 0; col < grid[row].length; col++) {
				msg += grid[row][col] + " ";
			}
			msg += "\n";
		}
		return msg;
	}
}
