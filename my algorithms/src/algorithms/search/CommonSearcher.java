package algorithms.search;
import java.util.ArrayList;
import java.util.PriorityQueue;


public abstract class CommonSearcher implements Searcher {
	
	

	protected int evaluatedNodes;
	
	public CommonSearcher() {
		
	}
	
	
	public int getEvaluatedNodes() {
		return evaluatedNodes;
	}

	
	public void setEvaluatedNodes(int evaluatedNodes) {
		this.evaluatedNodes = evaluatedNodes;
	}
	
	public abstract Solution search(Searchable s);
	
	protected Solution backtrace(State state) {
				
		/*backtrace:  
		 * get a parameter - state
		 * returns an array which represents (meyatzeg) the path (maslul)
		 * from state to start location in maze  
		 * we will use this method when state = Final location in maze
		 * */
		State location = state;
		/* State - the location in the searching problem
		(can be a node in graph or a position in the maze and so on) */
		// location is an object of class State
		ArrayList<State> states = new ArrayList<State>();
		/* states is array of state (nodes), 
		   Each cell represents (meyatzeg) State (class) 
		 /** the array looks like: 
		     the first cell- Final location in maze (state)
		     .
		     .
		     .
		     the final cell- start location in maze
		     [Final location in maze][][]...[start location in maze]
		 */ 
		while (location != null) {
			states.add(0, location);	
			location = location.getCameFrom();
		}
		Solution solution = new Solution();
		solution.setStates(states);
		return solution; 
	}
}
