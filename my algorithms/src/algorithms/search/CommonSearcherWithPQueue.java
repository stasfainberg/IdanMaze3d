package algorithms.search;

import java.util.PriorityQueue;

public abstract class CommonSearcherWithPQueue extends CommonSearcher {
	protected PriorityQueue<State> openList;
	protected PriorityQueue<State> closedList;
	protected Solution solution;

	
	public CommonSearcherWithPQueue(){
		//openList-
		//כל הקודקודים שעברנו בהם אבל לא סימנו איתם
		openList = new PriorityQueue<State>();
		
		//closedList-
		//כל הקודקודים שסיימנו איתם
		closedList = new PriorityQueue<State>();
	}
	
	protected State popOpenlist(){
		evaluatedNodes++;
		return openList.poll();
	}
	
	
	
	
	
}




