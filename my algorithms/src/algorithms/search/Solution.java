package algorithms.search;

import java.util.ArrayList;

//מחלקה זו אחראית על הפיתרון
public class Solution {
	//ArrayList-
	//זה מערך שאמור לייצג מצבים (קודקודים) במסלול הסופי של החיפוש
	private ArrayList<State> states;
    
	//getters and setters
	public ArrayList<State> getStates() {
		return states;
	}

	public void setStates(ArrayList<State> states) {
		this.states = states;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (State s: states) {
			sb.append(s).append("\n");
		}
		return sb.toString();
	}
}