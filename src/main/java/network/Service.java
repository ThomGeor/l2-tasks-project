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

    // Change the Service's name
    public void setName(String name) {
        this.name = name;
    }

    // Change the Service's costPerHour
    public void setCostPerHour(int costPerHour) {
        this.costPerHour = costPerHour;
    }

    public String toString(){
        return this.name + "(" + this.costPerHour + ")";
    }

    /**
     * Check if services are same (check name)
     *
     * @return boolean
     * */
    public boolean equals(Object other) {
        // If same reference or same name they are equal
        return this == other || (other instanceof Service && this.name.equals(((Service) other).name));
    }

    /**
     * Possibility to create HashSets of Services without duplicates
     *
     * @return int
     * */
    public int hashCode() {
        return this.name.hashCode();
    }	
}
