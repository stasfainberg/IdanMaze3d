package domains;

import java.util.HashMap;

public interface Searchable {
	State getStartState(); //נקודת התחלה של המבוך
	State getFinalState(); //נקודת סיום של המבוך
	
	/* המפתח יהיה action
	 הערך יהיה state
	 טבלת הגיבוב מייצגת את כל המצבים האפשריים
	 */
	HashMap<Action, State> getAllPossibleActions(State state);
	
}
