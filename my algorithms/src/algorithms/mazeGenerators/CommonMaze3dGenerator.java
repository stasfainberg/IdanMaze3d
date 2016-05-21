package algorithms.mazeGenerators;

import java.util.Objects;
import java.util.Random;

public abstract class CommonMaze3dGenerator implements Maze3dGenerator {
	
	protected Maze3d maze;
	int[][][] array3d;
	protected Random rand = new Random();
	
	@Override
	public abstract Maze3d generate(int floor, int rows, int cols);
	
	public abstract void chooseStartPosition();
	
	@Override
	public String measureAlgorithmTime(int floor, int rows, int cols) {
		//moded time to creating the Maze
//		Maze3d maze3d=new Maze3d(floor, rows, cols);
		long start = System.currentTimeMillis(); //begin time to building the maze
//		maze3d=generate(floor, rows, cols);
		this.generate(floor, rows, cols);
		long finish = System.currentTimeMillis(); // end time to building the maze		
		long generate_time=finish-start; // the total time to building the maze	
		String s = Objects.toString(generate_time, null); //casting time from long to string
		System.out.println("measureAlgorithmTime is: " + generate_time);
		return s;
	}
	
	public void initMaze(int floor, int rows, int cols) 
	{
		//Maze3d MyMaze = new Maze3d(floor,rows,cols);
		//int[][][] m = this.getMaze();
		
		//System.out.println(MyMaze.toString());
		
		for(int floor_count = 0; floor_count < floor; floor_count++) 
		{
			for (int rows_count = 0; rows_count < rows; rows_count++) 
			{
				for (int cols_count = 0; cols_count < cols; cols_count++) 
					maze.getMaze()[floor_count][rows_count][cols_count] = Maze3d.WALL;
			}
		}		
	}

//	public void initMaze() 
//	{
//		//int[][][] m = maze.getMaze();
//		for (int floor_count = 0; floor_count < maze.getFloor(); floor_count++) 
//		{
//			for (int rows_count = 0; rows_count < maze.getRows(); rows_count++) 
//			{
//				for (int cols_count = 0; cols_count < maze.getCols(); cols_count++) 
//					maze.getMaze()[floor_count][rows_count][cols_count] = Maze3d.WALL;
//			}
//		}		
//	}
	
//	public Maze3d getMaze(){
//		return maze;
//	}
	
	
	
	
	
	
}
