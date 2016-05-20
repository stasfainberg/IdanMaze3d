package algorithms.mazeGenerators;

public class Test {

	private static void testMazeGenerator(Maze3dGenerator mg) {
		// prints the time it takes the algorithm to run
		System.out.println("measureTime");
		System.out.println(mg.measureAlgorithmTime(3, 4, 4));
		// generate another 3d maze
		System.out.println("generate");
		Maze3d maze = mg.generate(3, 4, 4);
		// get the maze entrance
		//System.out.println("positio p = maze.getStartPosition");
		Position p = maze.getStartPosition();
		System.out.println("Start position p = " + maze.getStartPosition());
		// print the position
		System.out.println(p); // format "{x,y,z}"
		// get all the possible moves from a position
		System.out.println("");
		String[] moves = maze.getPossibleMoves(p);
		// print the moves
		System.out.println(maze.toString());
		System.out.println("Print String Moves");
		for (String move : moves)
			System.out.println(move);
		// prints the maze exit position
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

		System.out.println("************** Simple *************");
		testMazeGenerator(new SimpleMaze3dGenerator());
		
		System.out.println("************** My *************");
		testMazeGenerator(new MyMaze3dGenerator());

	}

}
