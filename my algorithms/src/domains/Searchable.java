package domains;

import java.util.HashMap;

public interface Searchable {
	State getStartState(); //����� ����� �� �����
	State getFinalState(); //����� ���� �� �����
	
	/* ����� ���� action
	 ���� ���� state
	 ���� ������ ������ �� �� ������ ��������
	 */
	HashMap<Action, State> getAllPossibleActions(State state);
	
}
