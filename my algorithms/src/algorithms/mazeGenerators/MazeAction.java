package algorithms.mazeGenerators;
import domains.Action;

public class MazeAction extends Action {
		
	public static final double mazeMovementCost = 1;
	private Direction move;
	
	public MazeAction(Direction move) {
		super(move.toString(), mazeMovementCost);
	}
	
}
