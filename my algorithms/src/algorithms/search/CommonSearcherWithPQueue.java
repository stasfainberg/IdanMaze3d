package algorithms.search;

import java.util.PriorityQueue;

import domains.Searchable;
import domains.State;

public abstract class CommonSearcherWithPQueue extends CommonSearcher {
	protected PriorityQueue<State> openList;
	protected PriorityQueue<State> closedList;
	
	public CommonSearcherWithPQueue(){
		//openList-
		//כל הקודקודים שעברנו בהם אבל לא סימנו איתם
		openList = new PriorityQueue<State>();
		
		//closedList-
		//כל הקודקודים שסיימנו איתם
		closedList = new PriorityQueue<State>();
	}
	
}




