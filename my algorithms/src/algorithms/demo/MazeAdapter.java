package algorithms.demo;

import java.util.HashMap;

import algorithms.mazeGenerators.Direction;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Action;
import algorithms.search.MazeState;
import algorithms.search.Searchable;
import algorithms.search.State;

public class MazeAdapter implements Searchable {
	
	
	private Maze3d maze;
	private static final int MOVEMENT_COST = 1;
	
	public MazeAdapter(Maze3d maze) {
		this.maze = maze;
	}

	@Override
	public State getStartState() {
		MazeState startState = new MazeState(maze.getStartPosition());
		return startState;
	}

	@Override
	public State getGoalState() {
		MazeState goalState = new MazeState(maze.getGoalPosition());
		return goalState;
	}
	
	private Position getNextPosition(Position currPos, Direction dir) {
		switch (dir) {
		case RIGHT:
			return new Position(currPos.getFloor(), currPos.getRows(), currPos.getCols()+1);			
		case LEFT:
			return new Position(currPos.getFloor(), currPos.getRows(), currPos.getCols()-1);	
		case DOWN:
			return new Position(currPos.getFloor()-1, currPos.getRows(), currPos.getCols());	
		case UP:
			return new Position(currPos.getFloor()+1, currPos.getRows(), currPos.getCols());	
		case BACKWARD:
			return new Position(currPos.getFloor(), currPos.getRows()-1, currPos.getCols());	
		case FORWARD:
			return new Position(currPos.getFloor(), currPos.getRows()+1, currPos.getCols());
		}
		return null;
	}

	@Override
	public HashMap<Action, State> getAllPossibleActions(State state) {
		MazeState mazeState = (MazeState)state;
		Position pos = mazeState.getCurrPlayerPosition();
		Direction[] directions = maze.getPossibleDirections(pos);
		
		HashMap<Action, State> actions = new HashMap<Action, State>();
		for (Direction d: directions) {
			Action action = new Action(d.toString(), MOVEMENT_COST);
			MazeState newState = new MazeState(getNextPosition(pos, d));
			
			actions.put(action, newState);
		}
		
		return actions;
	}
	
	
	
//	private Maze3d maze;
//	private static final int MOVEMENT_COST = 1;
//	
//	public MazeAdapter(Maze3d maze) {
//		this.maze = maze;
//	}
//
//	@Override
//	public State getStartState() {
//		MazeState startState = new MazeState(maze.getStartPosition());
//		return startState;
//	}
//
//	@Override
//	public State getFinalState() {
//		MazeState goalState = new MazeState(maze.getGoalPosition());
//		return goalState;
//	}
//	
//	private Position getNextPosition(Position currPos, Direction dir) {
//		switch (dir) {
//		case DOWN:
//			return new Position(currPos.floor-1, currPos.rows,currPos.cols);	
//		case UP:
//			return new Position(currPos.floor+1, currPos.rows,currPos.cols);	
//		case RIGHT:
//			return new Position(currPos.floor, currPos.rows, currPos.cols+1);			
//		case LEFT:
//			return new Position(currPos.floor, currPos.rows, currPos.cols-1);
//		case BACKWARD:
//			return new Position(currPos.floor, currPos.rows-1, currPos.cols);
//		case FORWARD:
//			return new Position(currPos.floor, currPos.rows+1, currPos.cols);
//		}
//		
//		return null;
//	}
//	
//
//	@Override
//	public HashMap<Action, State> getAllPossibleActions(State state) {
//		MazeState mazeState = (MazeState)state;
//		Position pos = mazeState.getCurrPlayerPosition();
//		String[] directions = maze.getPossibleMoves(pos);
//		
//		HashMap<Action, State> actions = new HashMap<Action, State>();
//		for (String s: directions) {
//			Direction d=fromString(s);
//			Action action = new Action(d.toString(), MOVEMENT_COST);
//			MazeState newState = new MazeState(getNextPosition(pos, d));
//			
//			actions.put(action, newState);
//		}
//		
//		return actions;
//	}
//	
//	//casting from string s to enum Directions
//	public static Direction fromString(String s) 
//	{
//		if (s != null) {
//			for (Direction d : Direction.values()) 
//			{
//		        if (s.equals(d.valueOf(s))) 
//		        {
//		          return d;
//		        }
//		    }
//		}
//		return null;
//	}
//
//	@Override
//	public String MoveToAction(State a, State b) {
//		return maze.moveToAction(a.getState(), b.getState());
//	}
//
//	@Override
//	public int MoveToState(State a, State b) {
//		return maze.CostToState(a.getState(), b.getState());
//	}
	
	
	
	
	
	
}
