package algorithms.mazeGenerators;

public interface Maze3dGenerator {
	//generate building the Maze
	public Maze3d getMaze();
	public Maze3d generate(int floor, int rows, int cols);
	//moded time to creating the Maze
	public String measureAlgorithmTime(int floor, int rows, int cols);
	//אתחול מבוך בקירות (1-ים)
	public void initMaze();
	//בחירת מיקום התחלתי ואסטרקתי בגלל שהמימוש שונה לכל אלגוריתם
	public abstract void chooseStartPosition();
}


