package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.Random;

public class SimpleMaze3dGenerator extends CommonMaze3dGenerator {

	//protected Maze3d maze;
	//private Random rand = new Random();
	
	@Override
	//need a simple implementation by random
	public Maze3d generate(int floor, int rows, int cols) 
	{
		
		
		System.out.println("generate started");
		//יצירת מופע של מבוך
		System.out.println(floor+","+rows+","+cols+",");
		
		this.maze = new Maze3d(floor, rows, cols);
		
		System.out.println(maze.toString());	

		Position pos=new Position();
		System.out.println("Position:" + pos);
		
		/* קריאה למטודה initMaze() */ 
		initMaze(floor, rows, cols); //אתחול מבוך בקירות (1-ים)
		
		
		// Choose random start position			
		chooseStartPosition();
		creatMaze(pos); //יצירת מבוך ויצירת מסלול עם 0-ים ו-1-ים
		return maze;
		
	}
	
//	public void initMaze(int floor, int rows, int cols) 
//	{
//		System.out.println("initMaze started");
//		Maze3d MyMaze = new Maze3d(floor,rows,cols);
//		int[][][] m = MyMaze.getMaze();
//		
//		System.out.println("MyMaze");
//		System.out.println(MyMaze.toString());
//		for(int floor_count = 0; floor_count < floor; floor_count++) 
//		{
//			for (int rows_count = 0; rows_count < rows; rows_count++) 
//			{
//				for (int cols_count = 0; cols_count < cols; cols_count++) 
//					m[floor_count][rows_count][cols_count] = Maze3d.WALL;
//			}
//		}		
//		System.out.println("MyMaze");
//		System.out.println(MyMaze.toString());
//	}
	//בחירה רנדומלית למיקום ההתחלתי
	public void chooseStartPosition() {	
		System.out.println("chooseStartPosition started");
		if(maze.getFloor()>0 && maze.getRows()>0 && maze.getCols()>0)
		{
			int floor = rand.nextInt(maze.getFloor());
			int rows = rand.nextInt(maze.getRows());
			int cols = rand.nextInt(maze.getCols());
			maze.setStartPosition(new Position(floor,rows,cols));
		}
		System.out.println("StartPosition:" + maze.getStartPosition());
	}
	
	//בחירה רנדומלית נקודת סיום
	public void chooseGoalPosition() {
		System.out.println("chooseGoalPosition");
		int floor=0, rows=0, cols=0;
		
		while(maze.getFloor()!= floor && maze.getRows()!= rows && maze.getCols()!=cols)
		{
			floor = rand.nextInt(maze.getFloor());
			rows = rand.nextInt(maze.getRows());
			cols = rand.nextInt(maze.getCols());
		
			maze.setGoalPosition(new Position(floor,rows,cols));
		}
	}
	
	public void creatMaze(Position pos)
	{
		System.out.println("CreateMaze");
		
		ArrayList<Direction> dirs = getPossibleDirections(pos);
		if (dirs.size() == 0)
			return;
		
		for (int i = 0; i < dirs.size(); i++) {
			// Choose random direction
			int idx = rand.nextInt(dirs.size());
			Direction dir = dirs.get(idx);
			dirs.remove(idx);
			int[][][] m = maze.getMaze();
			
			while(pos!=maze.getGoalPosition()) 
			{
				/* Choose random direction */		
				/*6 is the maximum and the 1 is our minimum 
				we have 6 direction
				LEFT, RIGHT, DOWN, UP, FORWARD, BACKWARD */
				//int idx = rand.nextInt(6)+1;
	
				//int[][][] m = maze.getMaze();
				
				switch (dir) {
				case DOWN:
					m[pos.floor][pos.rows][pos.cols] = Maze3d.FREE;
					if(pos.floor==2)
					{
						m[pos.floor-2][pos.rows][pos.cols] = Maze3d.FREE;				
						creatMaze(new Position(pos.floor-2, pos.rows, pos.cols));
						break;
					}
					creatMaze(new Position(pos.floor-1, pos.rows, pos.cols));
					break;
				case UP:
					m[pos.floor+1][pos.rows][pos.cols] = Maze3d.FREE;
					if(pos.floor==0)
					{
						m[pos.floor+2][pos.rows][pos.cols] = Maze3d.FREE;				
						creatMaze(new Position(pos.floor+2, pos.rows, pos.cols));
						break;
					}
					creatMaze(new Position(pos.floor+1, pos.rows, pos.cols));
					break;
				case LEFT:
					m[pos.floor][pos.rows][pos.cols-1] = Maze3d.FREE;
					m[pos.floor][pos.rows][pos.cols-2] = Maze3d.FREE;				
					creatMaze(new Position(pos.floor, pos.rows, pos.cols-2));
					break;
				case RIGHT:
					m[pos.floor][pos.rows][pos.cols+1] = Maze3d.FREE;
					m[pos.floor][pos.rows][pos.cols+2] = Maze3d.FREE;				
					creatMaze(new Position(pos.floor, pos.rows, pos.cols+2));
					break;
				case BACKWARD:
					m[pos.floor][pos.rows-1][pos.cols] = Maze3d.FREE;
					m[pos.floor][pos.rows-2][pos.cols] = Maze3d.FREE;				
					creatMaze(new Position(pos.floor, pos.rows-2, pos.cols));
					break;
				case FORWARD:
					m[pos.floor][pos.rows+1][pos.cols] = Maze3d.FREE;
					m[pos.floor][pos.rows+2][pos.cols] = Maze3d.FREE;				
					creatMaze(new Position(pos.floor, pos.rows+2, pos.cols));
					break;
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
		
		System.out.println(pos.getFloor());
		System.out.println(pos.getRows());
		System.out.println(pos.getCols());
		
		System.out.println("start check neighbors");
		// Check up neighbor
		if ((pos.getFloor()-1) >= 0 && m[(pos.getFloor()-1)][pos.getRows()-1][pos.getCols()-1] == Maze3d.WALL) {
			dirs.add(Direction.UP);
		}
				
		// Check down neighbor
		if ((pos.getFloor()-1) + 2 < maze.getRows() && m[(pos.getFloor()-1) + 1][pos.rows][pos.cols] == Maze3d.WALL) {
			dirs.add(Direction.DOWN);
		}
		
		// Check left neighbor
		if ((pos.getRows()-1) - 2 >= 0 && m[pos.floor][(pos.getRows()-1)-2][pos.cols] == Maze3d.WALL) {
			dirs.add(Direction.LEFT);
		}
		
		// Check right neighbor
		if (pos.rows + 2 < maze.getCols() && m[pos.floor][(pos.getRows()-1)+2][pos.cols] == Maze3d.WALL) {
			dirs.add(Direction.RIGHT);
		}
		
		// Check back neighbor
		if ((pos.getCols()-1) - 2 >= 0 && m[pos.floor][pos.rows][(pos.getCols()-1)-2] == Maze3d.WALL) {
			dirs.add(Direction.BACKWARD);
		}
		
		// Check forward neighbor
		if ((pos.getCols()-1) + 2 < maze.getCols() && m[pos.floor][pos.rows][(pos.getCols()-1)+2] == Maze3d.WALL) {
			dirs.add(Direction.FORWARD);
		}
		
		System.out.println("getPossibleDirections Ended");
		return dirs;
	}
	
	
//	public ArrayList<Direction> getAllvalidNeightbors(Position p){
//		ArrayList<Direction> List = new ArrayList<Direction>();			
//		int floor = p.floor;
//		int row = p.rows;
//		int col = p.cols;
//		
//		if (floor > 0)
//		{
//			if(maze[floor-1][row][col]==0)
//			List.add(new Position(floor-1,row,col));
//		}
//		if (row > 0){
//			if(maze[floor][row-1][col]==0)
//			List.add(new Position(floor,row-1,col));
//		}
//		if (col > 0){
//			if(maze[floor][row][col-1]==0)
//			List.add(new Position(floor,row,col-1));
//		}
//		if (floor < this.floor-1){
//			if(maze[floor+1][row][col]==0)
//			List.add(new Position(floor+1,row,col));
//		}
//		if (row < this.row-1 ){
//			if(maze[floor][row+1][col]==0)
//			List.add(new Position(floor,row+1,col));
//		}
//		if (col < this.col-1 ){
//			if(maze[floor][row][col+1]==0)
//			List.add(new Position(floor,row,col+1));
//		}
//		return List;
//	}
	
	
//	
//	private ArrayList<Direction> getPossibleDirections(Position pos) {
//		System.out.println("getPossibleDirections");
//
//		ArrayList<Direction> dirs = new ArrayList<Direction>();
//		int[][][] m = maze.getMaze();
//		
//		// Check up neighbor
//		if (pos.floor >= 0 && m[pos.floor][pos.rows][pos.cols] == Maze3d.WALL) {
//			dirs.add(Direction.UP);
//		}
//				
//		// Check down neighbor
//		if (pos.floor < maze.getRows() && m[pos.floor][pos.rows][pos.cols] == Maze3d.WALL) {
//			dirs.add(Direction.DOWN);
//		}
//		
//		// Check left neighbor
//		if (pos.rows >= 0 && m[pos.floor][pos.rows][pos.cols] == Maze3d.WALL) {
//			dirs.add(Direction.LEFT);
//		}
//		
//		// Check right neighbor
//		if (pos.rows < maze.getCols() && m[pos.floor][pos.rows][pos.cols] == Maze3d.WALL) {
//			dirs.add(Direction.RIGHT);
//		}
//		
//		// Check back neighbor
//		if (pos.cols >= 0 && m[pos.floor][pos.rows][pos.cols] == Maze3d.WALL) {
//			dirs.add(Direction.BACKWARD);
//		}
//		
//		// Check forward neighbor
//		if (pos.cols < maze.getCols() && m[pos.floor][pos.rows][pos.cols] == Maze3d.WALL) {
//			dirs.add(Direction.FORWARD);
//		}
//		
//		
//		return dirs;
//	}
//	
	
	
	
	
	public Maze3d getMaze(){
		System.out.println("getMaze Started");
		return maze;
	}

	
	
	
	
	
	
}
