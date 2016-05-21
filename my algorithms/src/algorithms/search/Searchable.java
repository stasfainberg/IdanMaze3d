package algorithms.search;

import java.util.HashMap;

public interface Searchable {
	State getStartState(); //����� ����� �� �����
	State getGoalState(); //����� ���� �� �����
	
	/* ����� ���� action
	 ���� ���� state
	 ���� ������ ������ �� �� ������ ��������
	 */
	HashMap<Action, State> getAllPossibleActions(State state);
	
	
//	String MoveToAction(State q, State n);
//	
//	int MoveToState(State a , State b);

	   
}
