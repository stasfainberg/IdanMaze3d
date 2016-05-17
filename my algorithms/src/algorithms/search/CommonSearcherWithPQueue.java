package algorithms.search;

import java.util.PriorityQueue;

import domains.Searchable;
import domains.State;

public abstract class CommonSearcherWithPQueue extends CommonSearcher {
	protected PriorityQueue<State> openList;
	protected PriorityQueue<State> closedList;
	
	public CommonSearcherWithPQueue(){
		//openList-
		//�� ��������� ������ ��� ��� �� ����� ����
		openList = new PriorityQueue<State>();
		
		//closedList-
		//�� ��������� ������� ����
		closedList = new PriorityQueue<State>();
	}
	
}




