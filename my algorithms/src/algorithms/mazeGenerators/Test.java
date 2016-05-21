package algorithms.mazeGenerators;

public class Test {

	private static void testMazeGenerator(Maze3dGenerator mg) {
		// prints the time it takes the algorithm to run
		System.out.println(mg.measureAlgorithmTime(3, 5, 5));
		// generate another 3d maze
		Maze3d maze = mg.generate(3,5,5);
		System.out.println(maze.toString());
		// get the maze entrance
		//System.out.println("positio p = maze.getStartPosition");
		Position p = maze.getStartPosition();
		System.out.println("Start position p = " + maze.getStartPosition());
		Position pp = maze.getStartPosition();
		System.out.println("Goal position pp = " + maze.getGoalPosition());
		// print the position
		System.out.println(p); // format "{x,y,z}"
		// get all the possible moves from a position
		String[] moves = maze.getPossibleMoves(p);
		// print the moves
		System.out.println("Print String Moves");
		for (String move : moves)
			System.out.println(move);
		// prints the maze exit position
		try {
			// get 2d cross sections of the 3d maze
			int[][] maze2dx = maze.getCrossSectionByFloor(2);
			maze.printCrossSection(maze2dx);
			int[][] maze2dy = maze.getCrossSectionByRows(5);
			maze.printCrossSection(maze2dy);
			int[][] maze2dz = maze.getCrossSectionByCols(0);
			maze.printCrossSection(maze2dz);
			// this should throw an exception!
			maze.getCrossSectionByFloor(-1);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("good!");
		}

	}

	public static void main(String[] args) {

		System.out.println("***************************************************");
		System.out.println("*******************    Simple     *****************");
		System.out.println("***************************************************");

		testMazeGenerator(new SimpleMaze3dGenerator());

		System.out.println("***************************************************");
		System.out.println("**********************    My    *******************");
		System.out.println("***************************************************");
		testMazeGenerator(new MyMaze3dGenerator());

	}

}
