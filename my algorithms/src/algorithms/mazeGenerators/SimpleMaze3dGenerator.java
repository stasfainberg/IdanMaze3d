package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.Random;

public class SimpleMaze3dGenerator extends CommonMaze3dGenerator {

	// protected Maze3d maze;
	// private Random rand = new Random();

	@Override
	// need a simple implementation by random
	public Maze3d generate(int floor, int rows, int cols) {

		System.out.println("generate started");
		// יצירת מופע של מבוך
		System.out.println(floor + "," + rows + "," + cols + ",");

		this.maze = new Maze3d(floor, rows, cols);

		System.out.println(maze.toString());

		Position pos = new Position();
		System.out.println("Position:" + pos);

		/* קריאה למטודה initMaze() */
		initMaze(floor, rows, cols); // אתחול מבוך בקירות (1-ים)

		// Choose random start position
		//chooseStartPosition();
		chooseStartPosition();
		pos = maze.getStartPosition();
		System.out.println("Position:" + pos);
		
		createMaze(pos); // יצירת מבוך ויצירת מסלול עם 0-ים ו-1-ים
		return maze;

	}

	// public void initMaze(int floor, int rows, int cols)
	// {
	// System.out.println("initMaze started");
	// Maze3d MyMaze = new Maze3d(floor,rows,cols);
	// int[][][] m = MyMaze.getMaze();
	//
	// System.out.println("MyMaze");
	// System.out.println(MyMaze.toString());
	// for(int floor_count = 0; floor_count < floor; floor_count++)
	// {
	// for (int rows_count = 0; rows_count < rows; rows_count++)
	// {
	// for (int cols_count = 0; cols_count < cols; cols_count++)
	// m[floor_count][rows_count][cols_count] = Maze3d.WALL;
	// }
	// }
	// System.out.println("MyMaze");
	// System.out.println(MyMaze.toString());
	// }
	// בחירה רנדומלית למיקום ההתחלתי
	public void chooseStartPosition() {
		System.out.println("chooseStartPosition started");
		if (maze.getFloor() > 0 && maze.getRows() > 0 && maze.getCols() > 0) {
			int floor = rand.nextInt(maze.getFloor());
			int rows = rand.nextInt(maze.getRows());
			int cols = rand.nextInt(maze.getCols());
			maze.setStartPosition(new Position(floor, rows, cols));
		}
		System.out.println("StartPosition:" + maze.getStartPosition());
	}

	// בחירה רנדומלית נקודת סיום
	public void chooseGoalPosition() {
		System.out.println("chooseGoalPosition");
		int floor = 0, rows = 0, cols = 0;

		while (maze.getFloor() != floor && maze.getRows() != rows && maze.getCols() != cols) {
			floor = rand.nextInt(maze.getFloor());
			rows = rand.nextInt(maze.getRows());
			cols = rand.nextInt(maze.getCols());

			maze.setGoalPosition(new Position(floor, rows, cols));
		}
	}

	public void createMaze(Position pos) {
		System.out.println("CreateMaze");

		ArrayList<Direction> dirs = getPossibleDirections(pos);
		if (dirs.size() == 0)
			return;

		System.out.println("dirs is:");
		System.out.println(dirs.toString());
		
		
		
		for (int i = 0; i < dirs.size(); i++) {
			
			System.out.println("number of i is: " + i);
			// Choose random direction
			int idx = rand.nextInt(dirs.size());
			System.out.println("number of idx is: " + idx);
			
			
			Direction dir = dirs.get(idx);
			System.out.println("dir is: ");
			System.out.println(dir);
			

			dirs.remove(idx);
			// int[][][] m = maze.getMaze();
			array3d = maze.getMaze();

			System.out.println(maze.getGoalPosition());
			while (pos != maze.getGoalPosition()) {
				/* Choose random direction */
				/*
				 * 6 is the maximum and the 1 is our minimum we have 6 direction
				 * LEFT, RIGHT, DOWN, UP, FORWARD, BACKWARD
				 */
				// int idx = rand.nextInt(6)+1;

				int[][][] m = maze.getMaze();

				System.out.println("creating the maze");
				
				try {
					if(!(pos.getFloor()==0 && pos.getRows()==0 && pos.getCols()==0)){
					}
				} catch (Exception e) {
					System.out.println("pos is (0,0,0)");
					break;
				}
				
				if(!(pos.getFloor()==0 && pos.getRows()==0 && pos.getCols()==0)){
					
					switch (dir) {
					case DOWN:
						m[pos.getFloor() - 1][pos.getRows()][pos.getCols()] = Maze3d.FREE;
						if (pos.getFloor() == 2) {
							m[pos.getFloor() - 2][pos.getRows()][pos.getCols()] = Maze3d.FREE;
							createMaze(new Position(pos.getFloor() - 2, pos.getRows(), pos.getCols()));
							break;
						}
						createMaze(new Position(pos.getFloor() - 1, pos.getRows(), pos.getCols()));
						break;
					case UP:
						m[pos.getFloor() + 1][pos.getRows()][pos.getCols()] = Maze3d.FREE;
						if (pos.getFloor() == 2) {
							m[pos.getFloor() + 2][pos.getRows()][pos.getCols()] = Maze3d.FREE;
							createMaze(new Position(pos.getFloor() + 2, pos.getRows(), pos.getCols()));
							break;
						}
						createMaze(new Position(pos.getFloor() + 1, pos.getRows(), pos.getCols()));
						break;
					case LEFT:
						m[pos.getFloor()][pos.getRows()][pos.getCols() - 1] = Maze3d.FREE;
						m[pos.getFloor()][pos.getRows()][pos.getCols() - 2] = Maze3d.FREE;
						createMaze(new Position(pos.getFloor(), pos.getRows(), pos.getCols() - 2));
						break;
					case RIGHT:
						m[pos.getFloor()][pos.getRows()][pos.getCols() + 1] = Maze3d.FREE;
						m[pos.getFloor()][pos.getRows()][pos.getCols() + 2] = Maze3d.FREE;
						createMaze(new Position(pos.getFloor(), pos.getRows(), pos.getCols() + 2));
						break;
					case BACKWARD:
						m[pos.getFloor()][pos.getRows() - 1][pos.getCols()] = Maze3d.FREE;
						m[pos.getFloor()][pos.getRows() - 2][pos.getCols()] = Maze3d.FREE;
						createMaze(new Position(pos.getFloor(), pos.getRows() - 2, pos.getCols()));
						break;
					case FORWARD:
						m[pos.getFloor()][pos.getRows() + 1][pos.getCols()] = Maze3d.FREE;
						m[pos.getFloor()][pos.getRows() + 2][pos.getCols()] = Maze3d.FREE;
						createMaze(new Position(pos.getFloor(), pos.getRows() + 2, pos.getCols()));
						break;
					}
				}
			}
		}
	}

	private ArrayList<Direction> getPossibleDirections(Position pos) {

		System.out.println("getPossibleDirections started");

		ArrayList<Direction> dirs = new ArrayList<Direction>();
		int[][][] m = maze.getMaze();

		System.out.println("maze:");
		System.out.println(maze.toString());

		System.out.println(pos.toString());

		System.out.println("start check neighbors");
		
		// Check up neighbor
		if (pos.getFloor() >= 0 && m[pos.getFloor()-1][pos.getRows()][pos.getCols()] == Maze3d.WALL) {
			dirs.add(Direction.UP);
		}

		// Check down neighbor
		if (pos.getFloor() + 2 < maze.getFloor() && m[pos.getFloor() + 2][pos.getRows()][pos.getCols()] == Maze3d.WALL) {
			dirs.add(Direction.DOWN);
		}

		// Check left neighbor
		if (pos.getRows() - 2 >= 0 && m[pos.getFloor()][pos.getRows() - 2][pos.getCols()] == Maze3d.WALL) {
			dirs.add(Direction.LEFT);
		}

		// Check right neighbor
		if (pos.getRows() + 2 < maze.getRows() && m[pos.getFloor()][pos.getRows() + 2][pos.getCols()] == Maze3d.WALL) {
			dirs.add(Direction.RIGHT);
		}

		// Check back neighbor
		if (pos.getCols() - 2 >= 0 && m[pos.getFloor()][pos.getRows()][pos.getCols() - 2] == Maze3d.WALL) {
			dirs.add(Direction.BACKWARD);
		}

		// Check forward neighbor
		if (pos.getCols() + 2 < maze.getCols() && m[pos.getFloor()][pos.getRows()][pos.getCols() + 2] == Maze3d.WALL) {
			dirs.add(Direction.FORWARD);
		}

		System.out.println("dir size:");
		System.out.println(dirs.size());
		
		System.out.println("getPossibleDirections Ended");
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
		System.out.println("getMaze Started");
		return maze;
	}

}
