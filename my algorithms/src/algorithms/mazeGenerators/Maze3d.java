package algorithms.mazeGenerators;

import java.util.ArrayList;

import algorithms.search.State;

/**
 * *********** the class Maze3d ***************
 * Creating Maze Three-dimensional maze (Maze3d)
 * 
 * I chose the representation(Maze) of 3 floors 
 * the first floor [0][..][..] contains only of walls (1)
 * the second floor contains the entrance to the Maze
 * the third floor contains the exit of the Maze is entirely Ceiling (1) Except exit (0)
 */
public class Maze3d {
	/**
	 * @param maze is the maze[floor][rows][cols]
	 * 
	 * @param floor is floors in the maze
	 * @param cols is cols in the maze
	 * @param rows is rows in the maze
	 * 
	 * @param startPosition is start position in the maze
	 *   for example [1][0][1]
	 * 
	 * @param goalPosition is final position in the maze
	 *   for example [2][4][6]
	 */

	/*
	 * int[][][] maze3d={
		{
			{1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1},
		},
		{
			{1,0,1,1,1,1,1,1,1},
			{1,0,1,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,1,1},
			{1,0,1,1,1,1,0,1,1},
			{1,0,1,1,1,1,0,1,1},
			{1,1,1,1,1,1,1,1,1},
		},
		{
			{1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,0,1,1},
			{1,1,1,1,1,1,1,1,1},
		}
	};

	*/
	
	
	private int[][][] mazeArray; /**maze */
	private int floor; /**floors */
	private int rows; /**rows */
	private int cols; /** cols */
	private Position startPosition; //מיקום התחלתי
	private Position goalPosition; //מיקום סופי
	
	//משתנה סטטי הוא משתנה שקיים מתחילת התכנית לכל אורכה וקיים בזיכרון פעם אחת
	//ניתן לגשת אליו מבלי ליצור אובייקט
	public static final int WALL = 1;
	public static final int FREE = 0;
	
	public Maze3d(int floor, int rows, int cols) {		
		this.floor = floor;
		this.rows = rows;
		this.cols = cols;
		mazeArray = new int [floor][rows][cols];
	}
	
	//getters and setters
	/**
	 * Gets the floors.
	 *
	 * @return the floor
	 */
	public int getFloor() {
		return floor;
	}
	
	/**
	 * Gets the rows.
	 *
	 * @return the rows
	 */
	public int getRows() {
		return rows;
	}
	
	/**
	 * Gets the cols.
	 *
	 * @return the cols
	 */
	public int getCols() {
		return cols;
	}
	

	public static int getWall() {
		return WALL;
	}

	/**
	 * Sets the floor.
	 *
	 * @param floor is the new floor
	 */
	public void setFloor(int floor) {
		this.floor = floor;
	}
	
	/**
	 * Sets the rows.
	 *
	 * @param rows is the new rows
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}

	/**
	 * Sets the cols.
	 *
	 * @param cols is the new cols
	 */
	public void setCols(int cols) {
		this.cols = cols;
	}


	public void setMaze(int[][][] mazeArray) {
		this.mazeArray = mazeArray;
	}


	public int[][][] getMaze() {
		return mazeArray;
	}

	public Position getStartPosition() {
		return startPosition;
	}

	public void setStartPosition(Position startPosition) {
		this.startPosition = startPosition;
	}

	public Position getGoalPosition() {
		return goalPosition;
	}

	public void setGoalPosition(Position goalPosition) {
		this.goalPosition = goalPosition;
	}	
	
	public void print() {
		for (int floor_count = 0; floor_count < floor; floor_count++)
		{
			for (int rows_count = 0; rows_count < rows; rows_count++) 
			{
				for (int cols_count = 0; cols_count < cols; cols_count++) 
					System.out.print(mazeArray[floor_count][rows_count][cols_count] + " ");
				System.out.println();
			}
		}
	}
	
//	public String[] getPossibleMoves(Position p) 
//	{
//		ArrayList<Position> List = getAllvalidNeightbors(p);
//		String [] result = new String[List.size()];
//		
//		for(int i = 0; i < List.size(); i++)
//		{
//			result[i] = List.get(i).toString();
//		}
//		return result;
//	}
	
	// Direction = כיוון
	//המתודה מחזירה לנו מערך המכיל את כל הכיוונים האפשרים שניתן להגיע אליהם
	public String[] getPossibleMoves(Position pos) {
		
		//רשימה של כיוונים
		ArrayList<Direction> directions = new ArrayList<Direction>(); 
		
		int floor = pos.getFloor();
		int rows = pos.getRows();
		int cols = pos.getCols();
		
		if (pos.getFloor() > 0)
		{
			if(mazeArray[floor-1][rows][cols]==FREE)
				directions.add(Direction.DOWN);
		}
		if (pos.getRows() > 0){
			if(mazeArray[floor][rows-1][cols]==FREE)
				directions.add(Direction.BACKWARD);
		}
		if (pos.getCols() > 0){
			if(mazeArray[floor][rows][cols-1]==FREE)
				directions.add(Direction.LEFT);
		}
		if (pos.getFloor() < this.getFloor()-1){
			if(mazeArray[floor+1][rows][cols]==FREE)
				directions.add(Direction.UP);
		}
		if (pos.getRows() < this.getRows()-1 ){
			if(mazeArray[floor][rows+1][cols]==FREE)
				directions.add(Direction.FORWARD);
		}
		if (pos.getCols() < this.getCols()-1 ){
			if(mazeArray[floor][rows][cols+1]==FREE)
				directions.add(Direction.RIGHT);
		}
		
		
//		//אם הקומה העליונה פנויה נעלה למעלה
//		if (pos.floor + 1 < floor && mazeArray[pos.floor + 1][pos.rows][pos.cols] == FREE)
//			directions.add(Direction.UP);
//		//אם הקומה התחתונה פנויה נרד למטה
//		if (pos.floor  - 1 >=0 && mazeArray[pos.floor - 1][pos.rows][pos.cols] == FREE)
//			directions.add(Direction.DOWN);
//		//אם השורה התחתונה פנויה נלך קדימה
//		if (pos.rows + 1 < rows && mazeArray[pos.floor][pos.rows + 1][pos.cols] == FREE)
//			directions.add(Direction.FORWARD);
//		//אם השורה התחתונה פנויה נלך אחורה
//		if (pos.rows  - 1 >= 0 && mazeArray[pos.floor][pos.rows - 1][pos.cols] == FREE)
//			directions.add(Direction.BACKWARD);
//		//אם העמודה הימנית (הבאה) פנויה נלך ימינה
//		if (pos.cols + 1 < cols && mazeArray[pos.floor][pos.rows][pos.cols + 1] == FREE)
//			directions.add(Direction.RIGHT);
//		//אם עמודה השמאלית פנויה (הקודמת) פנויה נלך שמאלה
//		if (pos.cols  - 1 >= 0 && mazeArray[pos.floor][pos.rows][pos.cols - 1] == FREE)
//			directions.add(Direction.LEFT);
		
		//ניצור מערך שלתוכו נעביר את הרשימה
		Direction[] dir = new Direction[directions.size()]; 
		//עלינו להחזיר בסופו של דבר מערך של מחרוזות עם הכיוונים האפשריים
		String[] arr = new String[directions.size()]; 
		directions.toArray(dir); //נעביר את הכיוונים האפשריים מרשימה למערך
		
		//נעבור על שני המערכים ונעביר את הכיוונים האפשריים לתוך מערך מחרוזות
		for(int i=0;i<directions.size(); i++)
			arr[i]=dir[i].toString();	
		
		return arr;		
	}
	
	@Override
	//הפיכת מיקום למחרוזת
	public String toString() {
		String strOfMazeMatrix = "";
		for (int i = 0; i < (floor); i++) {
			strOfMazeMatrix += "\n{\n";
			for (int j = 0; j < (rows); j++) {
				strOfMazeMatrix += "{";
				for (int k = 0; k < (cols); k++) {
					strOfMazeMatrix += mazeArray[i][j][k];
				}
				strOfMazeMatrix += "}\n";
			}
			strOfMazeMatrix += "},\n";
		}
		return "Maze3d:\nDimensions are: floor=" + (floor) + ", col=" + (cols) + ", line=" + (rows)
				 + strOfMazeMatrix;
		

		
//StringBuilder sb = new StringBuilder();
//		sb.append("Start: " + startPosition + "\n");
//		sb.append("Goal: " + goalPosition + "\n");
//		
//		
//		for (int floor_count = 0; floor_count < floor; floor_count++)
//		{
//			for (int rows_count = 0; rows_count < rows; rows_count++) 
//			{
//				for (int cols_count = 0; cols_count < cols; cols_count++) 				
//					sb.append(maze[floor-1][rows-1][cols-1] + " ");
//			}
//			sb.append("\n");
//		}
//		
//		return sb.toString();
	}
	
	public byte[] toByteArray() {
		ArrayList<Byte> arr = new ArrayList<Byte>();
		arr.add((byte)floor);
		arr.add((byte)rows);
		arr.add((byte)cols);
		arr.add((byte)startPosition.floor);
		arr.add((byte)startPosition.rows);
		arr.add((byte)startPosition.cols);
		arr.add((byte)goalPosition.floor);
		arr.add((byte)goalPosition.rows);
		arr.add((byte)goalPosition.cols);
		
		for (int floor_count = 0; floor_count < floor; floor_count++)
		{
			for (int rows_count = 0; rows_count < rows; rows_count++) 
			{
				for (int cols_count = 0; cols_count < cols; cols_count++) 	
					arr.add((byte)mazeArray[floor][rows][cols]);
			}			
		}
		
		// Copy the array list to array of bytes
		byte[] bytes = new byte[arr.size()];
		for (int i = 0; i < arr.size(); i++) {
			bytes[i] = arr.get(i);
		}
		return bytes;
	}
	
	public int[][] getCrossSectionByFloor(int num)
	{
		int[][] floorArr= new int[rows][cols];
		for (int rows_count = 0; rows_count < rows; rows_count++) 
		{
			for (int cols_count = 0; cols_count < cols; cols_count++) 
				floorArr[rows_count][cols_count]=mazeArray[num][rows_count][cols_count];
		}
		
		return floorArr;
	}
	
	public int[][] getCrossSectionByRows(int num)
	{
		
		int[][] rowsArr= new int[rows][cols];
		for (int floor_count = 0; floor_count < floor; floor_count++) 
		{
			for (int cols_count = 0; cols_count < cols; cols_count++) 
				rowsArr[floor_count][cols_count]=mazeArray[floor_count][num][cols_count];
		}
		
		return rowsArr;
		
	}
	
	public int[][] getCrossSectionByCols(int num)
	{
		
		int[][] colsArr= new int[rows][cols];
		for (int floor_count = 0; floor_count < floor; floor_count++) 
		{
			for (int rows_count = 0; rows_count < rows; rows_count++)
				colsArr[floor_count][rows_count]=mazeArray[floor_count][rows_count][num];
		}
		
		return colsArr;
	}
	
	public ArrayList<Position> getAllNeightbors(Position s) {
		ArrayList<Position> List = new ArrayList<Position>();
		int floor = s.getFloor();
		int line = s.getRows();
		int col = s.getCols();
		if (floor > 0){
			List.add(new Position(floor-1,line,col));
		}
		if (line > 0){
			List.add(new Position(floor,line-1,col));
		}
		if (col > 0){
			List.add(new Position(floor,line,col-1));
		}
		if (floor < this.floor-1){
			List.add(new Position(floor+1,line,col));
		}
		if (line < this.rows-1 ){
			List.add(new Position(floor,line+1,col));
		}
		if (col < this.cols-1 ){
			List.add(new Position(floor,line,col+1));
		}
		return List;	
	}

	public ArrayList<Position> getAllvalidNeightbors(Position p) {
		ArrayList<Position> List = new ArrayList<Position>();
		int floor = p.getFloor();
		int line = p.getRows();
		int col = p.getCols();
		
		if (floor > 0)
		{
			if(mazeArray[floor-1][line][col]==0)
			List.add(new Position(floor-1,line,col));
		}
		if (line > 0){
			if(mazeArray[floor][line-1][col]==0)
			List.add(new Position(floor,line-1,col));
		}
		if (col > 0){
			if(mazeArray[floor][line][col-1]==0)
			List.add(new Position(floor,line,col-1));
		}
		if (floor < this.floor-1){
			if(mazeArray[floor+1][line][col]==0)
			List.add(new Position(floor+1,line,col));
		}
		if (line < this.rows-1 ){
			if(mazeArray[floor][line+1][col]==0)
			List.add(new Position(floor,line+1,col));
		}
		if (col < this.cols-1 ){
			if(mazeArray[floor][line][col+1]==0)
			List.add(new Position(floor,line,col+1));
		}
		return List;
	}
	
	public void printCrossSection(int [][] cross)
	{
		System.out.print("{\n");
		for(int i = 0; i<cross.length; i++){
			System.out.print("{");
			for(int j = 0; j<cross[i].length; j++){
				System.out.print(cross[i][j] + ",");
			}
			System.out.print("}\n");
		}	
		System.out.print("}\n");

	} 
	
	public String moveToAction(Position a,Position b) {
		if(a.getFloor() < b.getFloor())
			return "FloorUp";
		if(a.getFloor() > b.getFloor())
			return "FloorDown";
		if (a.getRows() < b.getRows())
			return "LineForward";
		if (a.getRows() > b.getRows())
			return "LineBackward";
		if (a.getCols() < b.getCols())
			return "ColLeft";
		return "ColRight";
		
	}

	public Direction[] getPossibleDirections(Position pos) {
		
//		System.out.println("===== getPossibleDirections ======");
//		System.out.println("current position: " + pos.toString());
		ArrayList<Direction> directions = new ArrayList<Direction>(); 
		
		
		
		int floor = pos.getFloor();
		int rows = pos.getRows();
		int cols = pos.getCols();
		
		
//		System.out.println("position array: " + mazeArray[floor][rows][cols]);
		
		if (pos.getFloor() > 0)
		{
			if(mazeArray[floor-1][rows][cols]==FREE){
				directions.add(Direction.DOWN);
			}
		}
		if (pos.getRows() > 0){
			if(mazeArray[floor][rows-1][cols]==FREE){
				directions.add(Direction.BACKWARD);
			}
		}
		if (pos.getCols() > 0){
			if(mazeArray[floor][rows][cols-1]==FREE){
				directions.add(Direction.LEFT);
			}
		}
		if (pos.getFloor() < (this.getFloor()-1) ){
			if(mazeArray[floor+1][rows][cols]==FREE){
				directions.add(Direction.UP);
			}
		}
		if (pos.getRows() < (this.getRows()-1) ){
			if(mazeArray[floor][rows+1][cols]==FREE){
				directions.add(Direction.FORWARD);
			}
		}
		if (pos.getCols() < (this.getCols()-1) ){
			if(mazeArray[floor][rows][cols+1]==FREE){
				directions.add(Direction.RIGHT);
			}
		}
		
		Direction[] dir = new Direction[directions.size()]; 
		//עלינו להחזיר בסופו של דבר מערך של מחרוזות עם הכיוונים האפשריים
		String[] arr = new String[directions.size()]; 
		directions.toArray(dir); //נעביר את הכיוונים האפשריים מרשימה למערך
		
		//נעבור על שני המערכים ונעביר את הכיוונים האפשריים לתוך מערך מחרוזות
		for(int i=0;i<directions.size(); i++)
			arr[i]=dir[i].toString();	
		
//		for(int jj=0; jj < dir.length ; jj++)
//		System.out.println("number of directions is: " + directions.size());
//		System.out.println(directions);
		
//		System.out.println("number of dir is: " + directions.size());
		
		for(int j=0; j < dir.length ; j++)
			System.out.println(dir[j]);
		return dir;		
	
	
	}
	
	
	
	
}


