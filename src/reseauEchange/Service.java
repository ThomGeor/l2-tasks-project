package reseauEchange;

public class Service {
	private String name; 
	private int costPerHour; 
	
	public Service(String name, int costPerHour) {
		this.name = name;  
		this.costPerHour = costPerHour; 
	}

	public int getCoast() {
		return this.costPerHour; 
	}
	
	
}
