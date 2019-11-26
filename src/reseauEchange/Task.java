package reseauEchange;

public class Task {
	private Service service; 
	private Member benificiary;
	private int numberOfPerson; 
	private Time time; 
	private int price; 
	private boolean volunteer; 
	
	public Task (Service service, Member benificiary, int nbrOfPerson, Time time, boolean volunteer) {
		this.service        = service; 
		this.benificiary    = benificiary; 
		this.numberOfPerson = nbrOfPerson; 
		this.time           = time;
		this.price          = 0; 
		this.volunteer = volunteer; 
	}
	
	public int getPrice() {
		int price = 0; 
		if(volunteer) {
			price = (service.getCoast() *  time.getHour() + 
					 service.getCoast() * (time.getMinute() / 60) + 
					 service.getCoast() * (time.getSecond() / 3600)) * 
					 numberOfPerson;  
		}
		return price; 
	}

}
