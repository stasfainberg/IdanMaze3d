package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.Random;

public class SimpleMaze3dGenerator extends CommonMaze3dGenerator {

	// protected Maze3d maze;
	// private Random rand = new Random();

	@Override
	// need a simple implementation by random
	public Maze3d generate(int floor, int rows, int cols){ 

		// יצירת מופע של מבוך

		this.maze = new Maze3d(floor, rows, cols);
		this.array3d = maze.getMaze();
		


		/* קריאה למטודה initMaze() */
		//initMaze(floor, rows, cols); // אתחול מבוך בקירות (1-ים)
		for (int i=0;i<floor;i++)
		{
			for(int j=0;j<rows;j++)
			{
				for(int k=0;k<cols;k++)
				{
					array3d[i][j][k] = rand.nextInt(2);
				}
			}
		}
		

		// Choose random start position
		//chooseStartPosition();
		chooseStartPosition();
		chooseGoalPosition();

		
		//createMaze(startpos); // יצירת מבוך ויצירת מסלול עם 0-ים ו-1-ים
		return maze;

	}

	public void initMaze(int floor, int rows, int cols) {
		//Maze3d MyMaze = new Maze3d(floor, rows, cols);
		int[][][] m = maze.getMaze();

		for (int floor_count = 0; floor_count < floor; floor_count++) {
			for (int rows_count = 0; rows_count < rows; rows_count++) {
				for (int cols_count = 0; cols_count < cols; cols_count++)
					m[floor_count][rows_count][cols_count] = Maze3d.WALL;
			}
		}

	}

	// בחירה רנדומלית למיקום ההתחלתי
	public void chooseStartPosition() {
		if (maze.getFloor() > 0 && maze.getRows() > 0 && maze.getCols() > 0) {
			int floor = rand.nextInt(maze.getFloor());
			int rows = rand.nextInt(maze.getRows());
			int cols = rand.nextInt(maze.getCols());
			maze.setStartPosition(new Position(floor, rows, cols));
			this.array3d[floor][rows][cols] = 0;
		}
	}

	// בחירה רנדומלית נקודת סיום
	public void chooseGoalPosition() {
		int floor = 0, rows = 0, cols = 0;
//		Position temp = new Position(floor, rows, cols);
//		maze.setGoalPosition(temp);
		
		if (maze.getFloor() != floor && maze.getRows() != rows && maze.getCols() != cols) {
	
				do {
					floor = rand.nextInt(maze.getFloor());
					rows = rand.nextInt(maze.getRows());
					cols = rand.nextInt(maze.getCols());
				} while (maze.getStartPosition().getFloor()==floor && maze.getStartPosition().getRows()==rows && maze.getStartPosition().getCols()==cols);
				maze.setGoalPosition(new Position(floor, rows, cols));			
				this.array3d[floor][rows][cols] = 0;
		} 
		
	}

	public void createMaze(Position pos) {

		ArrayList<Direction> dirs = getPossibleDirections(pos);
		if (dirs.size() == 0)
			return;

//		System.out.println("dirs is:");
//		System.out.println(dirs.toString());

		for (int i = 0; i < dirs.size(); i++) {

			// Choose random direction
			int idx = rand.nextInt(dirs.size());

			Direction dir = dirs.get(idx);
//			System.out.println("dir is: " + dir);

			dirs.remove(idx);
			// int[][][] m = maze.getMaze();

			while (pos != maze.getGoalPosition()) {
				/* Choose random direction */
				/*
				 * 6 is the maximum and the 1 is our minimum we have 6 direction
				 * LEFT, RIGHT, DOWN, UP, FORWARD, BACKWARD
				 */
				// int idx = rand.nextInt(6)+1;

				int[][][] m = maze.getMaze();

				// try {
				// if(!(pos.getFloor()==0 && pos.getRows()==0 &&
				// pos.getCols()==0)){
				// }
				// } catch (Exception e) {
				// System.out.println("pos is (0,0,0)");
				// break;
				// }		
				
				if (!(pos.getFloor() == 0 && pos.getRows() == 0 && pos.getCols() == 0)) {

					switch (dir) {
					case UP:
						
						if (pos.getFloor() < maze.getFloor()-1){
							m[pos.getFloor() + 1][pos.getRows()][pos.getCols()] = Maze3d.FREE;
							createMaze(new Position(pos.getFloor() + 1, pos.getRows(), pos.getCols()));
							break;
						}
					case DOWN:
						
						if (pos.getFloor() > 0) {
							m[pos.getFloor() - 1][pos.getRows()][pos.getCols()] = Maze3d.FREE;
							createMaze(new Position(pos.getFloor() - 1, pos.getRows(), pos.getCols()));
							break;
						}
					case LEFT:
						
						if (pos.getCols() > 0) {
							m[pos.getFloor()][pos.getRows()][pos.getCols() - 1] = Maze3d.FREE;
							createMaze(new Position(pos.getFloor(), pos.getRows(), pos.getCols() - 1));
							break;
						}
					case RIGHT:
						
						if (pos.getCols() < maze.getCols() - 1) {
							m[pos.getFloor()][pos.getRows()][pos.getCols() + 1] = Maze3d.FREE;
							createMaze(new Position(pos.getFloor(), pos.getRows(), pos.getCols() + 1));
							break;
						}
					case FORWARD:
						
						if (pos.getRows() < maze.getRows() - 1) {
							m[pos.getFloor()][pos.getRows() + 1][pos.getCols()] = Maze3d.FREE;
							createMaze(new Position(pos.getFloor(), pos.getRows() + 1, pos.getCols()));
							break;
						}
					case BACKWARD:
						
						if (pos.getRows() > 0) {
							m[pos.getFloor()][pos.getRows() - 1][pos.getCols()] = Maze3d.FREE;
							createMaze(new Position(pos.getFloor(), pos.getRows() - 1, pos.getCols()));
							break;
						}
					}
				}
			}
		}
	}

	private ArrayList<Direction> getPossibleDirections(Position pos) {

		ArrayList<Direction> dirs = new ArrayList<Direction>();
		int[][][] m = maze.getMaze();
		
		int floor = pos.getFloor();
		int rows = pos.getRows();
		int col = pos.getCols();
		
		if (pos.getFloor() > 0)
		{
			if(array3d[floor-1][rows][col]==0)
				dirs.add(Direction.DOWN);
		}
		if (pos.getRows() > 0){
			if(array3d[floor][rows-1][col]==0)
				dirs.add(Direction.FORWARD);
		}
		if (pos.getCols() > 0){
			if(array3d[floor][rows][col-1]==0)
				dirs.add(Direction.LEFT);
		}
		if (pos.getFloor() < maze.getFloor()-1){
			if(array3d[floor+1][rows][col]==0)
				dirs.add(Direction.UP);
		}
		if (pos.getRows() < maze.getRows()-1 ){
			if(array3d[floor][rows+1][col]==0)
				dirs.add(Direction.BACKWARD);
		}
		if (pos.getCols() < maze.getCols()-1 ){
			if(array3d[floor][rows][col+1]==0)
				dirs.add(Direction.RIGHT);
		}
		
		
//		// Check up neighbor
//		if (pos.getFloor() - 1 <= 0 || (m[pos.getFloor() - 1][pos.getRows()][pos.getCols()] == Maze3d.WALL)) {
//			dirs.add(Direction.UP);
//		}
//
//		// Check down neighbor
//		if (pos.getFloor() + 1 > maze.getFloor() || (m[pos.getFloor() + 1][pos.getRows()][pos.getCols()] == Maze3d.WALL)) {
//			dirs.add(Direction.DOWN);
//		}
//
//		// Check left neighbor
//		if (pos.getRows() - 1 <= 0 || (m[pos.getFloor()][pos.getRows() - 1][pos.getCols()] == Maze3d.WALL)) {
//			dirs.add(Direction.LEFT);
//		}
//
//		// Check right neighbor
//		if (pos.getRows() + 1 > maze.getRows()
//				|| (m[pos.getFloor()][pos.getRows() + 1][pos.getCols()] == Maze3d.WALL)) {
//			dirs.add(Direction.RIGHT);
//		}
//
//		// Check back neighbor
//		if (pos.getCols() - 1 <= 0 || (m[pos.getFloor()][pos.getRows()][pos.getCols() - 1] == Maze3d.WALL)) {
//			dirs.add(Direction.BACKWARD);
//		}
//
//		// Check forward neighbor
//		if (pos.getCols() + 1 > maze.getCols()
//				|| (m[pos.getFloor()][pos.getRows()][pos.getCols() + 1] == Maze3d.WALL)) {
//			dirs.add(Direction.FORWARD);
//		}


//		System.out.println(dirs);

		return dirs;
	}

	// public ArrayList<Direction> getAllvalidNeightbors(Position p){
	// ArrayList<Direction> List = new ArrayList<Direction>();
	// int floor = p.floor;
	// int row = p.rows;
	// int col = p.cols;
	//
	// if (floor > 0)
	// {
	// if(maze[floor-1][row][col]==0)
	// List.add(new Position(floor-1,row,col));
	// }
	// if (row > 0){
	// if(maze[floor][row-1][col]==0)
	// List.add(new Position(floor,row-1,col));
	// }
	// if (col > 0){
	// if(maze[floor][row][col-1]==0)
	// List.add(new Position(floor,row,col-1));
	// }
	// if (floor < this.floor-1){
	// if(maze[floor+1][row][col]==0)
	// List.add(new Position(floor+1,row,col));
	// }
	// if (row < this.row-1 ){
	// if(maze[floor][row+1][col]==0)
	// List.add(new Position(floor,row+1,col));
	// }
	// if (col < this.col-1 ){
	// if(maze[floor][row][col+1]==0)
	// List.add(new Position(floor,row,col+1));
	// }
	// return List;
	// }

	//
	// private ArrayList<Direction> getPossibleDirections(Position pos) {
	// System.out.println("getPossibleDirections");
	//
	// ArrayList<Direction> dirs = new ArrayList<Direction>();
	// int[][][] m = maze.getMaze();
	//
	// // Check up neighbor
	// if (pos.floor >= 0 && m[pos.floor][pos.rows][pos.cols] == Maze3d.WALL) {
	// dirs.add(Direction.UP);
	// }
	//
	// // Check down neighbor
	// if (pos.floor < maze.getRows() && m[pos.floor][pos.rows][pos.cols] ==
	// Maze3d.WALL) {
	// dirs.add(Direction.DOWN);
	// }
	//
	// // Check left neighbor
	// if (pos.rows >= 0 && m[pos.floor][pos.rows][pos.cols] == Maze3d.WALL) {
	// dirs.add(Direction.LEFT);
	// }
	//
	// // Check right neighbor
	// if (pos.rows < maze.getCols() && m[pos.floor][pos.rows][pos.cols] ==
	// Maze3d.WALL) {
	// dirs.add(Direction.RIGHT);
	// }
	//
	// // Check back neighbor
	// if (pos.cols >= 0 && m[pos.floor][pos.rows][pos.cols] == Maze3d.WALL) {
	// dirs.add(Direction.BACKWARD);
	// }
	//
	// // Check forward neighbor
	// if (pos.cols < maze.getCols() && m[pos.floor][pos.rows][pos.cols] ==
	// Maze3d.WALL) {
	// dirs.add(Direction.FORWARD);
	// }
	//
	//
	// return dirs;
	// }
	//

	public Maze3d getMaze() {
		return maze;
	}

}
