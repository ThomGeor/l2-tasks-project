package reseauEchange;

public class Time {
	private int second;  
	
	public Time(int second) {
		this.second = second; 
	}
	
	public Time(int minute, int seconde) {
		this.second = minute * 60 + seconde; 
	}

	public Time(int hour, int minute, int seconde) {
		this.second = hour * 3600 + minute * 60 + second; 
	}
	
	public int getHour() {
		return second / 3600; 
	}
	
	public int getMinute() {
		return (second % 3600) / 60; 
	}
	
	public int getSecond() {
		return second % 60; 
	}
	
	public int getTotalSecond() {
		return this.second; 
	}
	
}
