package algorithms.mazeGenerators;

//המחלקה מגדירה מיקום x,y,z

public class Position {
	public int floor;
	public int rows;
	public int cols;
	
	
	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public Position(int floor, int rows, int cols) {
		this.floor = floor; 
		this.rows = rows;
		this.cols= cols;
	}
	
	@Override 
	public String toString() {
		return "(" + floor + "," + rows + "," + cols + ")";
	}
}

