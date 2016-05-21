//package algorithms.search;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.PriorityQueue;
//
//public class BestFirstSearch extends CommonSearcherWithPQueue implements Comparator<State>{
//
//	protected Distance h;
//	protected Searchable s;
//	
////Constructors
//	
//	/**
//	 * Instantiates a new AstarCommonSearcher that can Search.
//	 * Do super() to the Father he extends from him.
//	 * @param Solution represent the solution to return after the Search method.
//	 */
//	public BestFirstSearch(Solution solution){
//		super();
//		this.solution = solution;
//	}
//	
//	/**
//	 * Instantiates a new AstarCommonSearcher that can Search.
//	 * Do super() to the Father he extends from him.
//	 */
//	public BestFirstSearch(){
//		super();
//	}
//	/**
//	 * Instantiates a new AstarCommonSearcher that can Search.
//	 * Do super() to the Father he extends from him.
//	 * @param Distance h, A* work with Heuristic function, in this Constructor he gets the heuristic function from outside.
//	 */
//	public BestFirstSearch(Distance h){
//		super();
//		this.h = h;
//	}
//	/**
//	 * Instantiates a new AstarCommonSearcher that can Search.
//	 * Do super() to the Father he extends from him.
//	 * @param Solution represent the solution to return after the Search method.
//	 * @param Distance h, A* work with Heuristic function, in this Constructor he gets the heuristic function from outside.
//	 */
//	public BestFirstSearch(Distance h,Solution s){
//		super();
//		this.h = h;
//		this.solution = s;
//	}
//	/**
//	 * Instantiates a new AstarCommonSearcher that can Search.
//	 * Do super() to the Father he extends from him.
//	 * @param Solution represent the solution to return after the Search method.
//	 * @param Distance h, A* work with Heuristic function, in this Constructor he gets the heuristic function from outside.
//	 * @param Searchable se, an instance of Searchable that the Astar wanna search on him.
//	 */
//	@SuppressWarnings("unchecked")
//	public BestFirstSearch(Distance h,Solution s, Searchable se){
//		super();
//		this.h = h;
//		this.s = se;
//		this.solution = s;
//	}
//	
//	/**
//	 * This method only return.
//	 *@return The heuristic Function. 
//	 */
//	public Distance getH() {return h;}
//	
//	/**
//	 * This method only get heuristic function from outside.
//	 * @param set the heuristic function h from outside. 
//	 */
//	public void setH(Distance h) {this.h = h;}
//	
//	/**
//	 * override the method compare, A* work with other Cost that any other Searchers work, so you must override this.
//	 * @param state a0
//	 * @param state a1
//	 * @return -1 if a1 is bigger or 1 if a0 is bigger 
//	 */
//	@Override
//	public int compare(State a0, State a1)
//	{
//		State goal = s.getFinalState();
//		if (a0.getCost()+h.GetDistance(a0, goal)<a1.getCost()+h.GetDistance(a1, goal))
//			return -1;
//		else if(a0.getCost()+h.GetDistance(a0, goal)>a1.getCost()+h.GetDistance(a1, goal))
//			return 1;
//		return 0;
//	}
//	
//	
//	/**
//	 * This method goal is to search and generate a instance of solution to a search-able problam.
//	 *@param Searchable s instance represent the Problem you want to Solve.
//	 *@return Solution that contains the path from the beginning to the end.        
//	 */
//	@SuppressWarnings("unchecked")
//	public Solution Search(Searchable s) {
//		this.s = s;
//		State Start = s.getStartState();
//		State Goal = s.getFinalState();
//		Start.setActionName("StartState");
//		PriorityQueue<State> closelist = new PriorityQueue<State>();
//		openList.add(Start);
//		while(!openList.isEmpty())
//		{
//			State q = popOpenlist();
//			if (q.equals(Goal))
//			{
//				return this.backtrace(q);
//			}
//			openList.remove(q);
//			closelist.add(q);
//			ArrayList<State> Nodes = s.getAllPossibleStates(q);
//			for(State n : Nodes)
//			{
//				if(closelist.contains(n))
//				{
//					continue;
//				}
//				double Gscore =  q.getCost() +s.MoveToState(q, n)+ (h.GetDistance(n, Goal) -  h.GetDistance(q, Goal));
//				if(!openList.contains(n) || Gscore < n.getCost())
//				{
//					n.setCameFrom(q);
//					n.setActionName(s.MoveToAction(q, n));
//					n.setCost(Gscore);
//					if(!openList.contains(n))
//					{
//						openList.add(n);
//					}
//				}
//			}
//		}
//		System.out.println("Cannot Solve.");
//		return null;
//	}
//}