package network;

public class Service {
	private String name; 
	private int costPerHour; 
	
	public Service(String name, int costPerHour) {
		this.name = name;  
		this.costPerHour = costPerHour; 
	}

  // Return cost
	public int getCost() {
		return this.costPerHour; 
  }
  
  // Return cost
	public String getName() {
		return this.name; 
	}
  
  // Check if services are same (check name)
  public boolean equals(Object other){
    // If same reference or same name they are equal
    return (this == other || (other instanceof Service && this.name.equals(other.name))) ? true : false;
  }
}
