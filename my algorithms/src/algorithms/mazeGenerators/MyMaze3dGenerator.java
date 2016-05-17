package algorithms.mazeGenerators;


import java.util.ArrayList;
import java.util.Random;

public class MyMaze3dGenerator extends CommonMaze3dGenerator{

	private Random rand = new Random();
	@Override
	
	//יצירת מבוך
	public Maze3d generate(int floor, int rows, int cols) 
	{
		maze.setFloor(floor);
		maze.setRows(rows);
		maze.setCols(cols);
		
		initMaze();//אתחול ב-1ים (קירות)
		
		// Choose random start position			
		chooseStartPosition();
		
		//יצירת מבוך באמצעות DFS
		//מאתחל ב-0-ים ו-1-ים
		DFS(maze.getStartPosition());				
		return maze;
	}
	

	public void chooseStartPosition() 
	{		
		int floor = rand.nextInt(maze.getFloor());
		while (floor % 2 == 1 && maze.getFloor()>0)
			floor = rand.nextInt(maze.getFloor());
		
		int rows = rand.nextInt(maze.getRows());
		while (rows % 2 == 1 && maze.getRows()>0)
			rows = rand.nextInt(maze.getRows());
		
		int cols = rand.nextInt(maze.getCols());
		while (cols % 2 == 1 && maze.getCols()>0)
			cols = rand.nextInt(maze.getCols());
		
		maze.setStartPosition(new Position(floor,rows,cols));
	}
	
	private void DFS(Position pos) {
		ArrayList<Direction> dirs = getPossibleDirections(pos);
		if (dirs.size() == 0)
			return;
	
		for (int i = 1; i < dirs.size(); i++) {
		
			// Choose random direction
			int idx = rand.nextInt(dirs.size());
			Direction dir = dirs.get(idx);
			dirs.remove(idx);
			int[][][] m = maze.getMaze();
			
			switch (dir) {
			case DOWN:
				m[pos.floor-1][pos.rows][pos.cols] = Maze3d.FREE;
				if(pos.floor==2)
				{
					m[pos.floor-2][pos.rows][pos.cols] = Maze3d.FREE;				
					DFS(new Position(pos.floor-2, pos.rows, pos.cols));
					break;
				}
				DFS(new Position(pos.floor-1, pos.rows, pos.cols));
				break;
			case UP:
				m[pos.floor+1][pos.rows][pos.cols] = Maze3d.FREE;
				if(pos.floor==0)
				{
					m[pos.floor+2][pos.rows][pos.cols] = Maze3d.FREE;				
					DFS(new Position(pos.floor+2, pos.rows, pos.cols));
					break;
				}
				DFS(new Position(pos.floor+1, pos.rows, pos.cols));
				break;
			case LEFT:
				m[pos.floor][pos.rows][pos.cols-1] = Maze3d.FREE;
				m[pos.floor][pos.rows][pos.cols-2] = Maze3d.FREE;				
				DFS(new Position(pos.floor, pos.rows, pos.cols-2));
				break;
			case RIGHT:
				m[pos.floor][pos.rows][pos.cols+1] = Maze3d.FREE;
				m[pos.floor][pos.rows][pos.cols+2] = Maze3d.FREE;				
				DFS(new Position(pos.floor, pos.rows, pos.cols+2));
				break;
			case BACKWARD:
				m[pos.floor][pos.rows-1][pos.cols] = Maze3d.FREE;
				m[pos.floor][pos.rows-2][pos.cols] = Maze3d.FREE;				
				DFS(new Position(pos.floor, pos.rows-2, pos.cols));
				break;
			case FORWARD:
				m[pos.floor][pos.rows+1][pos.cols] = Maze3d.FREE;
				m[pos.floor][pos.rows+2][pos.cols] = Maze3d.FREE;				
				DFS(new Position(pos.floor, pos.rows+2, pos.cols));
				break;

			} 
		} 
	} 
	
	private ArrayList<Direction> getPossibleDirections(Position pos) {
		ArrayList<Direction> dirs = new ArrayList<Direction>();
		int[][][] m = maze.getMaze();
		
		// Check up neighbor
		if (pos.floor - 2 >= 0 && m[pos.floor-2][pos.rows][pos.cols] == Maze3d.WALL) {
			dirs.add(Direction.UP);
		}
				
		// Check down neighbor
		if (pos.floor + 2 < maze.getRows() && m[pos.floor+2][pos.rows][pos.cols] == Maze3d.WALL) {
			dirs.add(Direction.DOWN);
		}
		
		// Check left neighbor
		if (pos.rows - 2 >= 0 && m[pos.floor][pos.rows-2][pos.cols] == Maze3d.WALL) {
			dirs.add(Direction.LEFT);
		}
		
		// Check right neighbor
		if (pos.rows + 2 < maze.getCols() && m[pos.floor][pos.rows+2][pos.cols] == Maze3d.WALL) {
			dirs.add(Direction.RIGHT);
		}
		
		// Check back neighbor
		if (pos.cols - 2 >= 0 && m[pos.floor][pos.rows][pos.cols-2] == Maze3d.WALL) {
			dirs.add(Direction.BACKWARD);
		}
		
		// Check forward neighbor
		if (pos.cols + 2 < maze.getCols() && m[pos.floor][pos.rows][pos.cols+2] == Maze3d.WALL) {
			dirs.add(Direction.FORWARD);
		}
		
		
		return dirs;
	}

}
