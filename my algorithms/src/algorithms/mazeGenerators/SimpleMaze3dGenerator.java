package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.Random;

public class SimpleMaze3dGenerator extends CommonMaze3dGenerator {

	private Random rand = new Random();
	@Override
	//need a simple implementation by random
	public Maze3d generate(int floor, int rows, int cols) 
	{
		//יצירת מופע של מבוך
		Maze3d maze = new Maze3d(floor, rows, cols);
		
		Position pos=new Position(floor, rows, cols);
		
		/* קריאה למטודה initMaze() */ 
		initMaze(); //אתחול מבוך בקירות (1-ים)
		
		// Choose random start position			
		chooseStartPosition();
		creatMaze(pos,maze); //יצירת מבוך ויצירת מסלול עם 0-ים ו-1-ים
		return maze;
		
	}
	
	//בחירה רנדומלית למיקום ההתחלתי
	public void chooseStartPosition() {	
		if(maze.getFloor()>0 && maze.getRows()>0 && maze.getCols()>0)
		{
			int floor = rand.nextInt(maze.getFloor());
			int rows = rand.nextInt(maze.getRows());
			int cols = rand.nextInt(maze.getCols());
			maze.setStartPosition(new Position(floor,rows,cols));
		}
	}
	
	//בחירה רנדומלית נקודת סיום
	public void chooseGoalPosition() {	
		int floor=0, rows=0, cols=0;
		
		while(maze.getFloor()!= floor && maze.getRows()!= rows && maze.getCols()!=cols)
		{
			floor = rand.nextInt(maze.getFloor());
			rows = rand.nextInt(maze.getRows());
			cols = rand.nextInt(maze.getCols());
		
			maze.setGoalPosition(new Position(floor,rows,cols));
		}
	}
	
	public void creatMaze(Position pos,Maze3d maze)
	{
		while(pos!=maze.getGoalPosition()) 
		{
			/* Choose random direction */		
			/*6 is the maximum and the 1 is our minimum 
			we have 6 direction
			LEFT, RIGHT, DOWN, UP, FORWARD, BACKWARD */
			int idx = rand.nextInt(6)+1;

			int[][][] m = maze.getMaze();
			
			switch (idx) {
			case 3: //DOWN
				m[pos.floor-1][pos.rows][pos.cols] = Maze3d.FREE;
				generate(pos.floor-1, pos.rows, pos.cols);
				break;
			case 4: //UP
				m[pos.floor+1][pos.rows][pos.cols] = Maze3d.FREE;
				generate(pos.floor+1, pos.rows, pos.cols);
				break;
			case 1: //LEFT
				m[pos.floor][pos.rows][pos.cols-1] = Maze3d.FREE;
				generate(pos.floor, pos.rows, pos.cols-1);
				break;
			case 2: //RIGHT
				m[pos.floor][pos.rows][pos.cols+1] = Maze3d.FREE;
				generate(pos.floor, pos.rows, pos.cols+1);
				break;
			case 5: //FORWARD
				m[pos.floor][pos.rows+1][pos.cols] = Maze3d.FREE;
				generate(pos.floor, pos.rows+1, pos.cols);
				break;
			case 6: //BACKWARD
				m[pos.floor][pos.rows-1][pos.cols] = Maze3d.FREE;
				generate(pos.floor, pos.rows-1, pos.cols);
				break;
			}
		}				
	}
}
