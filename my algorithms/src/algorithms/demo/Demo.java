//package algorithms.demo;
//
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//
//import algorithms.mazeGenerators.Maze3d;
//import algorithms.mazeGenerators.Maze3dGenerator;
//import algorithms.mazeGenerators.MyMaze3dGenerator;
//import algorithms.mazeGenerators.Position;
//import algorithms.mazeGenerators.SimpleMaze3dGenerator;
//import algorithms.search.DFS;
//import algorithms.search.Solution;
//import io.MyCompressorOutputStream;
//
///*import algorithms.DFS;
//import algorithms.Solution;
//import io.MyCompressorOutputStream;
//import maze.generators.Maze;
//import maze.generators.MyMazeGenerator;*/
//
///**
// * Demo class
// * @author idan levy *
// */ 
//
//public class Demo {
//	/**
//	 * This method runs a demo
//	 * 
//	 */
//
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
//
//	public static void run() {
//		MyMaze3dGenerator gen = new MyMaze3dGenerator();
//		Maze3d maze = gen.generate(3, 11, 11);
//		System.out.println(maze);
//		MazeAdapter adapter = new MazeAdapter(maze);
//		//BFS bfs = new BFS();
//		DFS dfs = new DFS();
//		Solution solution = dfs.search(adapter);
//		System.out.println(solution);
//	}
//	
//	public void compressMaze() 
//	{		
//		MyMaze3dGenerator gen = new MyMaze3dGenerator();
//		Maze3d maze = gen.generate(3, 11, 11);
//		System.out.println(maze.toString());
//		
//		
//		// save it to a file
//		OutputStream out;
//		try {
//			out = new MyCompressorOutputStream(
//					new FileOutputStream("1.maz"));
//			out.write(maze.toByteArray());
//			out.flush();
//			out.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
//	}//compressMaze
//	
//}//Demo
