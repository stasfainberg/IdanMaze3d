package algorithms.mazeGenerators;

public interface Maze3dGenerator {
	//generate building the Maze
	public Maze3d getMaze();
	public Maze3d generate(int floor, int rows, int cols);
	//moded time to creating the Maze
	public String measureAlgorithmTime(int floor, int rows, int cols);
	//����� ���� ������ (1-��)
	public void initMaze();
	//����� ����� ������ �������� ���� ������� ���� ��� ��������
	public abstract void chooseStartPosition();
}


