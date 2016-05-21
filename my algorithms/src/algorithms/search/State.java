package algorithms.search;

//import java.util.Comparator;

/**
 *    The class State is represents (meyatzeg) a node  
 *    by description, cost and cameFrom 
 *
 */
public class State implements Comparable<State> {

	
	private String description;
	private double cost;
	private State cameFrom;	
	protected String ActionName;

	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public State getCameFrom() {
		return cameFrom;
	}
	public void setCameFrom(State cameFrom) {
		this.cameFrom = cameFrom;
	}
	@Override
	public int compareTo(State s) {
		return (int)(this.cost - s.cost);
	}
	@Override
	public boolean equals(Object arg0) {
		State state = (State)arg0;
		return description.equals(state.description);
	}		
	
	@Override
	public int hashCode() {
		return description.hashCode();
	}
	
	@Override
	public String toString() {
		return description;
	}
	public String getActionName() {
		return ActionName;
	}
	
	
	
//	/**
//     * @param description: (תיאור)
//  	 * Describes the status of the treatment on node. it can be:
//	 * - Whether the node has not been treated yet
//	 * - Whether the node in a treatment now
//	 * - Is the treatment finished
//	*/
//	private String description;
//
//	/**
//	 * @param cost
//  	 * The cost of moving between nodes
//	*/
//	private double cost; 
//	
//	/**
//	 * @param cameFrom
//  	 * Which node we came from?
//	*/
//	private State cameFrom;	
//	protected String ActionName;
//	private State state;
//	
//	//getters and setters
//	public String getDescription() {
//		return description;
//	}
//	public void setDescription(String description) {
//		this.description = description;
//	}
//	public double getCost() {
//		return cost;
//	}
//	public void setCost(double cost) {
//		this.cost = cost;
//	}
//	public State getCameFrom() {
//		return cameFrom;
//	}
//	public void setCameFrom(State cameFrom) {
//		this.cameFrom = cameFrom;
//	}
//	
//	public State getState() {return state;}
//	
//	/**
//	*@param T State set the generally State(Node/Position...)
//	*/
//	public void setState(State state) {this.state =  state;}
//
//	//דריסה מטודה של גאוה המגדירה השוואה עפ"י מחיר
//	@Override
//	public int compareTo(State s) {
//		return (int)(this.cost - s.cost);
//	}
//	
//	//דריסת מטודה של גאוה על מנת לבדוק שיוויון עפ"י תיאור
//	@Override
//	public boolean equals(Object arg0) {
//		State state = (State)arg0;
//		return description.equals(state.description);
//	}		
//	
//	// מגדיר למבנה הנתונים טבלת גיבוב על איזה שדה של המחלקה תופעל פונקצית הגיבוב 
//	@Override
//	public int hashCode() {
//		return description.hashCode();
//	}
//	
//	@Override
//	public String toString() {
//		return description;
//	}
//	public void setActionName(String actionName) {
//		ActionName = actionName;		
//	}
//	
//	public String getActionName() {
//		return this.ActionName;		
//	}
	
	
	
	
	
}
