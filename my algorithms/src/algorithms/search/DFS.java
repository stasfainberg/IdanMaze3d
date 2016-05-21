	package algorithms.search;

	import java.util.HashMap;
	import java.util.HashSet;

public class DFS extends CommonSearcher {

		private HashSet<State> visitedStates = new HashSet<State>();
		//visitedStates - save that all locations that we visited in them
		private Solution solution;
		
		/** The Num of Nodes that have developed. */
		
		/**
		 * This function finds a solution to a searchable problem
		 * @param s the problem
		 * @return solution
		 */
		@Override	
		public Solution search(Searchable s) {
			// s - is searchable problem (beayat hipus)
			//s.getStartState - starting point of the problem s
			dfs(s, s.getStartState());		
			return solution;
		}
		
		private void dfs(Searchable s, State state) {
			
			setEvaluatedNodes(getEvaluatedNodes()+1);
			
//			System.out.println("number of evaluated: " + getEvaluatedNodes());
			/* dfs is rekursia 
			 
			 get 2 parameters: 
			     s - is searchable problem (beayat hipus)
			     state - starting point in the Maze
             return void;
             
             dfs save on the value solution the path (maslul) 
             from the state (starting point in the Maze) 
             to (final point in the Maze)
              */
			if (state.equals(s.getGoalState()))  //Stopping conditions
			/*if state = getFinalState (final point in the Maze)
			 than we run the method backtrace which return the solution
			 of the path (maslul) of the Maze.
			 */
			{
				solution = backtrace(state);
				return;
			}
			
			visitedStates.add(state); /* we add the state 
			(Current location - mikum nochechi)
			 to HashSet visitedStates */
			if(state.equals(s.getStartState()))
			{
				state.setCameFrom(null);
			}
			
			
			HashMap<Action,State> actions = s.getAllPossibleActions(state);
			/* HashMap save the possible locations that we can go to them */
			for(State neighbor: actions.values())
		   /*this loop run on all the neighbors from the HashMap-actions */
			{
	
//				System.out.println(actions.toString());
//				System.out.println("chosen neighbor: " + actions.toString() );
				if (!visitedStates.contains(neighbor)) {
					/* if neighbor not visited
					 * first: we update the value cameFrom (which node we came from) 
					 * second: we send to dfs(rekursia) the neighbor*/
					neighbor.setCameFrom(state);
					dfs(s, neighbor);					
				} 			
			}
			return;
		}



	}

