package algorithms.demo;

import java.rmi.activation.ActivationGroupDesc.CommandEnvironment;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Maze3dGenerator;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import algorithms.mazeGenerators.Position;
import algorithms.mazeGenerators.SimpleMaze3dGenerator;

public class Test {
	
	private static void testMazeGenerator(Maze3dGenerator mg){
		// prints the time it takes the algorithm to run
		System.out.println("measure");
		System.out.println(mg.measureAlgorithmTime(3, 15, 15));
		// generate another 3d maze
		System.out.println("generate");
		Maze3d maze=mg.generate(3, 15, 15);
		// get the maze entrance
		System.out.println("positio p = maze.getStartPosition");
		Position p=maze.getStartPosition();
		// print the position
		System.out.println("");
		System.out.println(p); // format "{x,y,z}"
		// get all the possible moves from a position
		System.out.println("");
		String[] moves=maze.getPossibleMoves(p);
		// print the moves
		for(String move : moves)
		System.out.println(move);
		// prints the maze exit position
		System.out.println(maze.getGoalPosition());
		try {
			// get 2d cross sections of the 3d maze
			int[][] maze2dx = maze.getCrossSectionByFloor(2);
			// TODO add code to print the array
			int[][] maze2dy = maze.getCrossSectionByRows(5);
			// TODO add code to print the array
			int[][] maze2dz = maze.getCrossSectionByCols(0);
			// TODO add code to print the array
			// this should throw an exception!
			maze.getCrossSectionByFloor(-1);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("good!");
		}
		}
		public static void main(String[] args) {
			
			
			
			
			
//		System.out.println("******************* Simple ******************");
//		//testMazeGenerator(new SimpleMaze3dGenerator());
//		System.out.println("");
//		System.out.println("******************* My ******************");
//		//testMazeGenerator(new MyMaze3dGenerator());
//		
		SimpleMaze3dGenerator smg = new SimpleMaze3dGenerator();
		smg.generate(3, 10, 10);
//		
//		MyMaze3dGenerator mmg = new MyMaze3dGenerator();
//		mmg.generate(3, 10, 10);
		
		
		
		
		
		
		}
	
//	public void testMazeGenerator(Maze3dGenerator mg)
//	{
//		Maze3d maze = mg.getMaze();
//		int floor = mg.getMaze().getFloor();
//		int rows = mg.getMaze().getRows();
//		int cols = mg.getMaze().getCols();
//		// prints the time it takes the algorithm to run
//		System.out.println();
//		
//		// generate another 3d maze
//		mg.generate(floor,rows,cols);
//		int[][][] mazeArr = maze.getMaze();
//		
//		// get the maze entrance
//		Position p=maze.getStartPosition();
//		
//		// print the position
//		System.out.println(p); // format "{x,y,z}"
//		
//		// get all the possible moves from a position
//		String[] moves=maze.getPossibleMoves(p);
//		
//		// print the moves
//		for(String move : moves)
//			System.out.println(move);
//		
//		// prints the maze exit position
//		System.out.println(maze.getGoalPosition());
//		try{
//			// get 2d cross sections of the 3d maze
//			int[][] maze2dx=maze.getCrossSectionByFloor(2);
//			for (int rows_count = 0; rows_count < rows; rows_count++) 
//			{
//				for (int cols_count = 0; cols_count < cols; cols_count++) 
//					System.out.println(mazeArr[2][rows_count][cols_count]);
//			}
//			int[][] maze2dy=maze.getCrossSectionByRows(5);
//			for (int floor_count = 0; floor_count < floor; floor_count++) 
//			{
//				for (int cols_count = 0; cols_count < cols; cols_count++) 
//					System.out.println(mazeArr[floor_count][5][cols_count]);
//			}
//			int[][] maze2dz=maze.getCrossSectionByCols(0);
//			for (int floor_count = 0; floor_count < floor; floor_count++) 
//			{
//				for (int rows_count = 0; rows_count < rows; rows_count++)
//					System.out.println(mazeArr[floor_count][rows_count][0]);
//			}
//			// this should throw an exception!
//			maze.getCrossSectionByFloor(-1);
//		} catch (IndexOutOfBoundsException e){
//			System.out.println("good!");
//		}
//	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
