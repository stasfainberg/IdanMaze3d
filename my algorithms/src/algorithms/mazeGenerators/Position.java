package algorithms.mazeGenerators;

//המחלקה מגדירה מיקום x,y,z

public class Position {
	public int floor;
	public int rows;
	public int cols;
	
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

