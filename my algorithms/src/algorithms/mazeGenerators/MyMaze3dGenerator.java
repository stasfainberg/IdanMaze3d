package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Stack;

public class MyMaze3dGenerator extends CommonMaze3dGenerator {

	// private Maze3d maze;
	// private Random rand = new Random();

	@Override

	// יצירת מבוך
	public Maze3d generate(int floor, int rows, int cols) {

		System.out.println("****************************** My Generate *******************************");
		this.maze = new Maze3d(floor, rows, cols);
		this.array3d = maze.getMaze();

		System.out.println(floor + "," + rows + "," + cols + ",");
		System.out.println(maze.toString());

		
		initMaze(floor, rows, cols);// אתחול ב-1ים (קירות)

		// Choose random start position
		chooseStartPosition();
		chooseGoalPosition();

		
		Position startpos = maze.getStartPosition();
		System.out.println("StartPosition:" + startpos);
		array3d[startpos.getFloor()][startpos.getRows()][startpos.getCols()] = 7;
		
		Position goalpos = maze.getGoalPosition();
		System.out.println("GoalPosition:" + goalpos);
		array3d[goalpos.getFloor()][goalpos.getRows()][goalpos.getCols()] = 4;
		
		System.out.println(maze.toString());

		// יצירת מבוך באמצעות DFS
		// מאתחל ב-0-ים ו-1-ים
		DFS(maze.getStartPosition());
		return maze;
	}

	public void initMaze(int floor, int rows, int cols) {
		// int[][][] m = maze.getMaze();
		
		System.out.println("************************* My initMaze ***************************");
		System.out.println("before initMaze");
		System.out.println(maze.toString());

		for (int floor_count = 0; floor_count < floor; floor_count++) {
			for (int rows_count = 0; rows_count < rows; rows_count++) {
				for (int cols_count = 0; cols_count < cols; cols_count++)
					this.maze.getMaze()[floor_count][rows_count][cols_count] = Maze3d.WALL;
			}
		}
		
		System.out.println("after initMaze");
		System.out.println(maze.toString());
		System.out.println("************************* End initMaze ************************");
	}

	public void chooseStartPosition() {
		
		System.out.println("************************* My chooseStartPosition Started **********************");
		int floor = rand.nextInt(maze.getFloor());
		while (floor % 2 == 1 && maze.getFloor() > 0)
			floor = rand.nextInt(maze.getFloor());

		int rows = rand.nextInt(maze.getRows());
		while (rows % 2 == 1 && maze.getRows() > 0)
			rows = rand.nextInt(maze.getRows());

		int cols = rand.nextInt(maze.getCols());
		while (cols % 2 == 1 && maze.getCols() > 0)
			cols = rand.nextInt(maze.getCols());

		maze.setStartPosition(new Position(floor, rows, cols));
		System.out.println("************************* end chooseStartPosition Ended **********************");
	}
	
	public void chooseGoalPosition() {
		System.out.println("************************* My chooseGoalPosition Started **********************");
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
		}
		System.out.println("************************* My chooseGoalPosition Ended **********************");

	} 
		

	private void DFS(Position pos) {
		System.out.println("*********************** My DFS ***************************");

		System.out.println("Current Position: " + pos);
		
		ArrayList<Direction> dirs = getPossibleDirections(pos);
		if (dirs.size() == 0)
			return;

		System.out.println("dirs is:");
		System.out.println(dirs.toString());

		for (int i = 1; i < dirs.size(); i++) {

			System.out.println("number of i is: " + i);

			// Choose random direction
			int idx = rand.nextInt(dirs.size());
			System.out.println("number of idx is: " + idx);

			Direction dir = dirs.get(idx);
			System.out.println("dir is: ");
			System.out.println(dir);

			dirs.remove(idx);
			int[][][] m = maze.getMaze();

			switch (dir) {
			case DOWN:
				if(pos.floor>=2){
					m[pos.floor-1][pos.rows][pos.cols] = Maze3d.FREE;
					//m[pos.floor-2][pos.rows][pos.cols] = Maze3d.FREE;				
					DFS(new Position(pos.floor-1, pos.rows, pos.cols));
				}
				break;
//				m[pos.floor - 1][pos.rows][pos.cols] = Maze3d.FREE;
//				if (pos.floor == 2) {
//					m[pos.floor - 2][pos.rows][pos.cols] = Maze3d.FREE;
//					DFS(new Position(pos.floor - 2, pos.rows, pos.cols));
//					break;
//				}
//				DFS(new Position(pos.floor - 1, pos.rows, pos.cols));
//				break;
			case UP:
				if(pos.floor<=pos.floor-2){
					m[pos.floor+1][pos.rows][pos.cols] = Maze3d.FREE;
					//m[pos.floor+2][pos.rows][pos.cols] = Maze3d.FREE;				
					DFS(new Position(pos.floor+1, pos.rows, pos.cols));
				}
				break;
//				m[pos.floor + 1][pos.rows][pos.cols] = Maze3d.FREE;
//				if (pos.floor == 0) {
//					m[pos.floor + 2][pos.rows][pos.cols] = Maze3d.FREE;
//					DFS(new Position(pos.floor + 2, pos.rows, pos.cols));
//					break;
//				}
//				DFS(new Position(pos.floor + 1, pos.rows, pos.cols));
//				break;
			case LEFT:
				if(pos.cols>=2){
					m[pos.floor][pos.rows][pos.cols-1] = Maze3d.FREE;
					//m[pos.floor][pos.rows][pos.cols-2] = Maze3d.FREE;				
					DFS(new Position(pos.floor, pos.rows, pos.cols-1));
				}
				break;
//				m[pos.floor][pos.rows][pos.cols - 1] = Maze3d.FREE;
//				m[pos.floor][pos.rows][pos.cols - 2] = Maze3d.FREE;
//				DFS(new Position(pos.floor, pos.rows, pos.cols - 2));
//				break;
			case RIGHT:
				if(pos.cols<=pos.cols-2)
				{
					m[pos.floor][pos.rows][pos.cols+1] = Maze3d.FREE;
					//m[pos.floor][pos.rows][pos.cols+2] = Maze3d.FREE;				
					DFS(new Position(pos.floor, pos.rows, pos.cols+1));
				}
				break;
//				m[pos.floor][pos.rows][pos.cols + 1] = Maze3d.FREE;
//				m[pos.floor][pos.rows][pos.cols + 2] = Maze3d.FREE;
//				DFS(new Position(pos.floor, pos.rows, pos.cols + 2));
//				break;
			case BACKWARD:
				if(pos.rows>=2)
				{
					m[pos.floor][pos.rows-1][pos.cols] = Maze3d.FREE;
					//m[pos.floor][pos.rows-2][pos.cols] = Maze3d.FREE;				
					DFS(new Position(pos.floor, pos.rows-1, pos.cols));
				}
				break;
//				m[pos.floor][pos.rows - 1][pos.cols] = Maze3d.FREE;
//				m[pos.floor][pos.rows - 2][pos.cols] = Maze3d.FREE;
//				DFS(new Position(pos.floor, pos.rows - 2, pos.cols));
//				break;
			case FORWARD:
				if(pos.rows<=pos.rows-2)
				{
					m[pos.floor][pos.rows+1][pos.cols] = Maze3d.FREE;
					//m[pos.floor][pos.rows+2][pos.cols] = Maze3d.FREE;				
					DFS(new Position(pos.floor, pos.rows+1, pos.cols));
				}
					break;
//				m[pos.floor][pos.rows + 1][pos.cols] = Maze3d.FREE;
//				m[pos.floor][pos.rows + 2][pos.cols] = Maze3d.FREE;
//				DFS(new Position(pos.floor, pos.rows + 2, pos.cols));
//				break;

			}
		}
		System.out.println("*********************** end DFS ***************************");

	}

	private ArrayList<Direction> getPossibleDirections(Position pos) {
		System.out.println("************************* My getPossibleDirections ****************************");
		ArrayList<Direction> dirs = new ArrayList<Direction>();
		int[][][] m = maze.getMaze();

		System.out.println("maze:");
		System.out.println(maze.toString());
		
		System.out.println("StartPosition: " + pos.toString());
		System.out.println("goalPosition: " + maze.getGoalPosition());
		
		System.out.println("start check neighbors");

		
		int floor = pos.getFloor();
		int rows = pos.getRows();
		int col = pos.getCols();
		
		array3d = maze.getMaze();
		
		if (pos.getFloor() > 0)
		{
			if(array3d[floor-1][rows][col]==Maze3d.WALL)
				dirs.add(Direction.DOWN);
		}
		if (pos.getRows() > 0){
			if(array3d[floor][rows-1][col]==Maze3d.WALL)
				dirs.add(Direction.FORWARD);
		}
		if (pos.getCols() > 0){
			if(array3d[floor][rows][col-1]==Maze3d.WALL)
				dirs.add(Direction.LEFT);
		}
		if (pos.getFloor() < maze.getFloor()-1){
			if(array3d[floor+1][rows][col]==Maze3d.WALL)
				dirs.add(Direction.UP);
		}
		if (pos.getRows() < maze.getRows()-1 ){
			if(array3d[floor][rows+1][col]==Maze3d.WALL)
				dirs.add(Direction.BACKWARD);
		}
		if (pos.getCols() < maze.getCols()-1 ){
			if(array3d[floor][rows][col+1]==Maze3d.WALL)
				dirs.add(Direction.RIGHT);
		}
		
//		// Check up neighbor
//		if (pos.floor - 2 >= 0 && m[pos.floor - 2][pos.rows][pos.cols] == Maze3d.WALL) {
//			dirs.add(Direction.UP);
//		}
//
//		// Check down neighbor
//		if (pos.floor + 2 < maze.getRows() && m[pos.floor + 2][pos.rows][pos.cols] == Maze3d.WALL) {
//			dirs.add(Direction.DOWN);
//		}
//
//		// Check left neighbor
//		if (pos.rows - 2 >= 0 && m[pos.floor][pos.rows - 2][pos.cols] == Maze3d.WALL) {
//			dirs.add(Direction.LEFT);
//		}
//
//		// Check right neighbor
//		if (pos.rows + 2 < maze.getCols() && m[pos.floor][pos.rows + 2][pos.cols] == Maze3d.WALL) {
//			dirs.add(Direction.RIGHT);
//		}
//
//		// Check back neighbor
//		if (pos.cols - 2 >= 0 && m[pos.floor][pos.rows][pos.cols - 2] == Maze3d.WALL) {
//			dirs.add(Direction.BACKWARD);
//		}
//
//		// Check forward neighbor
//		if (pos.cols + 2 < maze.getCols() && m[pos.floor][pos.rows][pos.cols + 2] == Maze3d.WALL) {
//			dirs.add(Direction.FORWARD);
//		}

		System.out.println("dir size:");
		System.out.println(dirs.size());
		System.out.println("dir is:");
		System.out.println(dirs);
		System.out.println("************************* end getPossibleDirections ****************************");

		return dirs;
	}

	public Maze3d getMaze() {
		return maze;
	}

}
