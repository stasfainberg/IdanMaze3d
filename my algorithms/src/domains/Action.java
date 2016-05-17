package domains;

public class Action {
	private String description; //תיאור
	private double cost; //מחיר קשת
	
	//constructor
	public Action() {}
	public Action(String description, double cost) {		
		this.description = description;
		this.cost = cost;
	}
	
	//getters and setters
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
	
	//casting to string
	@Override
	public String toString() {
		return description;
	}	
}
